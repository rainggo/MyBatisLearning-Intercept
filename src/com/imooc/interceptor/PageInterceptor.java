package com.imooc.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.imooc.entity.MyPage;

/**
 * 分页拦截器
 */
@Intercepts({
    @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class}) 
    })
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable { // 成功进行拦截
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler,
				SystemMetaObject.DEFAULT_OBJECT_FACTORY,
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		MappedStatement mappedStatement = (MappedStatement) metaObject
				.getValue("delegate.mappedStatement");
		// 获得sql语句的id
		String id = mappedStatement.getId();
		if (id.matches(".+ByPage$")) {
			BoundSql boundSql = (BoundSql) statementHandler.getBoundSql();
			// 原始的sql语句
			String sql = boundSql.getSql();
			// 查询总条数的sql语句
			String countSql = "select count(*) from (" + sql + ") a";
			// 获得原始的连接
			Connection connection = (Connection) invocation.getArgs()[0];
			PreparedStatement preparedStatement = connection.prepareStatement(countSql);
			// 设置参数
			ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(preparedStatement);
			// 运行sql语句
			ResultSet rs = preparedStatement.executeQuery();

			Map<?, ?> params = (Map<?, ?>) boundSql.getParameterObject();
			MyPage page = (MyPage) params.get("page");
			if (rs.next()) {
				page.setTotalNumber(rs.getInt(1));
				page.count();
			}
			// 改造后带分页查询的sql语句
			String pageSql = sql + " limit " + page.getDbIndex() + ","
					+ page.getDbNumber();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed(); // 使用反射让流程继续
	}

	@Override
	public Object plugin(Object target) { // 进行拦截
		return Plugin.wrap(target, this); // 使用本拦截器类的实例进行返回拦截对象
	}

	@Override
	public void setProperties(Properties properties) {

	}

}
