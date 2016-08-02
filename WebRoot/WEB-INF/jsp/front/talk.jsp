<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>聊天机器人</title>
	<link rel="stylesheet" type="text/css" href="<%= basePath %>resources/css/jscrollpane1.css" />
	<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
	<script src="<%= basePath %>resources/js/common/jquery.mousewheel.js"></script>
	<script src="<%= basePath %>resources/js/common/jquery.jscrollpane.min.js"></script>
	<script src="<%= basePath %>resources/js/common/scroll-startstop.events.jquery.js"></script>
	<script src="<%= basePath %>resources/js/front/talk.js"></script>
	</head>
	<body>
		<input type="hidden" value="<%= basePath %>" id="basePath"/>
		<br/>
		<div class="talk">
			<div class="talk_title"><span>正在与机器人聊天</span></div>
			<div class="talk_record">
				<div id="jp-container" class="jp-container">
					
				</div>
			</div>
			
			<div class="talk_word">
				&nbsp;
				<input class="add_face" id="facial" type="button" title="" value="" />
				<input id="content" class="messages emotion"   />
				<input class="talk_send" onclick="send();" type="button" title="发送" value="发送" />
			</div>
		</div>
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
	</body>
</html>