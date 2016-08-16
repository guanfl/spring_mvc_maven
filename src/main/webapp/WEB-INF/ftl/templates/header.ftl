
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">

<#assign security=JspTaglibs["/WEB-INF/security.tld"] />
<#assign context=rc.getContextPath()/>
  <head>
    <meta http-equiv="Pragma" content="no-cache">
    <link rel="stylesheet" href="${context}/static/styles/screen.css" type="text/css" media="screen, projection"/>
    <script type="text/javascript" src="${context}/static/js/jquery-1.4.4.min.js"></script>
 
    <script type="text/javascript" src="${context}/static/js/util.js"></script>
    <script type="text/javascript" src="${context}/static/js/websocket/stomp.js"></script>
    <script type="text/javascript" src="${context}/static/js/websocket/sockjs-0.3.4.js"></script>

    <title>开乐彩运营管理系统</title>
</head>

<script type="text/javascript">

     $(document).ready(function () {   	    
        timeconnect();
     });
     
     function timeconnect(){
        var socket_time = new SockJS("${context}/send");
        var stompClient_time = Stomp.over(socket_time);
       
        var timeCallback_time = function() {
        	
    	     //clots系统时间输出
    	     stompClient_time.subscribe('/topic/sys.time.data.*', function(greeting){
    	        var data = JSON.parse(greeting.body);
    	        if(data.system=='sys'){
    	         $('#time').html(data.time);
    	        }else if(data.system=='master'){
    	          if(data.alert==1){
    	             $('#master_time').attr('class','warning');
    	          }else{
    	             $('#master_time').attr('class','normally');
    	          }
    	          $('#master_time').html(data.time);
    	        }else if(data.system=='admin'){
    	          if(data.alert==1){
    	             $('#admin_time').attr('class','warning');
    	          }else{
    	             $('#admin_time').attr('class','normally');
    	          }
    	          $('#admin_time').html(data.time);
    	        }
    	     });    	     
      	 };
        	     	
         var errorCallback_time = function(error) {
            setTimeout(timeconnect(),5000);
         };
        
        stompClient_time.connect("guest", "guest", timeCallback_time, errorCallback_time);
     }
     
</script>

<body>
<div class="container">
    <div class="header">
    	<div class="logo"><img src="${context}/static/images/logo.png" /></div>
        <div class="nav">
        	<ul>
        	  	<li><a href="${context}/main" onclick="change_bg(this)" class="<#if title=='log'>current</#if>">进程监控</a></li>
        	  	<li><a href="${context}/job/configmain" onclick="change_bg(this)" class="<#if title=='config'>current</#if>">系统配置</a></li>
        	  	<li><a href="${context}/script/main" onclick="change_bg(this)" class="<#if title=='script'>current</#if>">脚本管理</a></li>
        	  	<li><a href="${context}/log/syslogmain" onclick="change_bg(this)" class="<#if title=='syslog'>current</#if>">系统日志</a></li>
         	 	<@security.authorize ifAnyGranted="ROLE_ADMIN,ROLE_SUPER_ADMIN"><li><a href="${context}/user/main" onclick="change_bg(this)" class="<#if title=='user'>current</#if>">用户管理</a></li></@security.authorize>
          	 	<li><a href="${context}/pwd/pwdform" onclick="change_bg(this)" class="<#if title=='password'>current</#if>">修改密码</a></li>
       		</ul>
        </div>
        <div class="user_ic">
            <span id="time"></span>
        	<span> 欢迎: <b><i><@security.authentication property="principal.username" /></i></b>
        	<a href="${context}/j_spring_security_logout">[退出]</a></span>
        	
        </div>
	</div>
	<div>