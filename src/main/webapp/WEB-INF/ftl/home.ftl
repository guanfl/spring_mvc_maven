<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as w/>
<#import "/templates/mod.ftl" as base/>
<#assign context=rc.getContextPath()/>
<@base.page title="log">
<script type="text/javascript">
    var m_topnum = ${master_logs?size}+1;
    var m_botomnum = 1;
    
    $(document).ready(function () {  
       $.get('${context}/process',null,function(data){
        	  $('#online_process').html(data); 
     	}); 	  
       connect();
    });
     
    function connect(){
    
        var timeCallback = function() {
    	     //日志输出
    	     stompClient.subscribe('/topic/master.log.data.*', function(greeting){
    	       var log = JSON.parse(greeting.body);
    	       //不报警输出
    	       if(log.alertpattern=='0'){
    	         if(log.logContent!='process')$('#master_log').prepend('<tr id="master_log_'+m_topnum+'"><td class="l_t_time">'+log.logTimeString+'</td><td class="l_t_level">'+log.logLevel+'</td><td class="l_t_proces">'+log.system+'</td><td class="l_t_content">'+log.logContent+'</td></tr>');
    	       //报警不出声
    	       }else if(log.alertpattern=='1'){
    	         if(log.logContent!='process')$('#master_log').prepend('<tr id="master_log_'+m_topnum+'" class="warning"><td class="l_t_time">'+log.logTimeString+'</td><td class="l_t_level">'+log.logLevel+'</td><td class="l_t_proces">'+log.system+'</td><td class="l_t_content">'+log.logContent+'</td></tr>');
    	         $('#masterimg').attr('class','failure');
    	        //报警出声
    	       }else{
    	         if(log.logContent!='process')$('#master_log').prepend('<tr id="master_log_'+m_topnum+'" class="warning"><td class="l_t_time">'+log.logTimeString+'</td><td class="l_t_level">'+log.logLevel+'</td><td class="l_t_proces">'+log.system+'</td><td class="l_t_content">'+log.logContent+'</td></tr>');
    	         $('#masterimg').attr('class','failure');
    	         playaduio('master_alarm');
    	       }
    	       if(log.logContent!='process'){
    	        if(m_topnum-m_botomnum==30){
    	    	   $('#master_log_'+m_botomnum).remove();
    	    	   m_botomnum = m_botomnum+1;
    	        }
    	        m_topnum = m_topnum+1;
    	       }
    	       
    	     });
    	     
    	   //进程监控状态输出
    	   stompClient.subscribe('/topic/slave.log.data.*', function(greeting){
      	       var log = JSON.parse(greeting.body);//
      	       for(var o in log){
      	        if(log[o].alert==1){
      	           $('#'+log[o].id).attr('class','warning');
      	          }else{
      	           $('#'+log[o].id).attr('class','normally');
      	          }
      	       }
      	     });
      	 //连接监控状态输出
	     stompClient.subscribe('/topic/sys.connect.data.*', function(greeting){
  	       var log = JSON.parse(greeting.body);//
  	       if(log.alertpattern=='0'){
  	        $('#'+log.system+'_server').attr('class','linked');
  	        $('#'+log.system+'_process').attr('class','log_t_p');
  	       }else{
  	        $('#'+log.system+'_server').attr('class','unlink');
  	        $('#'+log.system+'_process').attr('class','log_t_p mask');
  	       }
  	     }); 
      	};
      
        var errorCallback = function(error) {
          //断开后重连
          setTimeout(reconnect(),5000);    
        };
        
        var socket = new SockJS("${context}/send");
        var stompClient = Stomp.over(socket);
        stompClient.connect("guest", "guest", timeCallback, errorCallback);//进行连接
     }

     function reconnect(){
      $.get('${context}/process',null,function(data){
        	  $('#online_process').html(data); 
      }); 
      connect();
     }	
     function reset(id){
       $('#'+id).attr('class','normally');
       if(id=='masterimg'){
         stop('master_alarm');
       }else{
         stop('slave_alarm');
       }
     }
     
        
        function playaduio(id){
          var audEle = document.getElementById(id);
            if(audEle.paused){
                audEle.play();
            }
        }
        function stop(id){
            var audEle = document.getElementById(id);
            if(audEle.played){
                audEle.pause();
            }
        } 
   </script>
<div class="home">
  <div id="online" class="master">
    <div style="display:none">
     <audio id="master_alarm" src="${context}/static/styles/alert.mp3" controls="controls" loop="loop">
        you browser does not support the audio tag;
     </audio>
    </div>
  	<div class="m_i">
  		<div class="normally" id="masterimg"/>
  		<button type="button" onclick="reset('masterimg');">重  置</button>
		</div>
		<div class="link_status">
			<div class="monitor">
			监控
			</div>
			<div id="progress" class="progress width2 progress-blue" value="50">
				<span class="server_icon">主机</span>
				<span id="master_time"></span>
				<span id="master_server" class="linked"></span>
			</div>
			<div id="progress" class="progress width2 progress-blue" value="50">
				<span class="server_icon">后台</span>
				<span id="admin_time"></span>
				<span id="admin_server" class="linked"></span>
			</div> 
			<div id="progress" class="progress width2 progress-blue" value="50">
				<span class="server_icon">LB</span>
				<span id="lb_server" class="linked"></span>
			</div>
		</div>
		
  	</div>
     <div>
     <table class="log_t" cellspacing="0" cellpadding="0">
      <thead>
      	<tr>
      		<th class="l_t_time">时间</th>
      		<th class="l_t_level">级别</th>
      		<th class="l_t_proces">系统</th>
      		<th class="l_t_content">内容</th>
    	</tr>
      </thead>
      <tbody id="master_log">
      <#list master_logs as log>
       <tr id="master_log_${master_logs?size-log_index}" <#if log.alert==1>class="warning"</#if>>
       	<td class="l_t_time">${log.logTime?string("MM-dd HH:mm:ss")}</td>
       	<td class="l_t_level">${log.logLevel}</td>
       	<td class="l_t_proces">${log.system}</td>
       	<td class="l_t_content">${log.logContent}</td>
       </tr> 
      </#list>
      </tbody>
     </table>
     </div>
  </div>
  
 <div id="online_process"></div>   
 

</@base.page >


