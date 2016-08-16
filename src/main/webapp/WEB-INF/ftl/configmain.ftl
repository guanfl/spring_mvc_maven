<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as w/>
<#import "/templates/mod.ftl" as base/>
<#assign security=JspTaglibs["/WEB-INF/security.tld"] />
<#assign context=rc.getContextPath()/>
<@base.page title="config">
    <script type="text/javascript">
    
        $(document).ready(function () {
     	   
      	//获得启停时间配置列表
        $.get('${context}/job/joblist',null,function(data){
      	      $('#joblist').html(data);
      	}); 
      	<@security.authorize ifAnyGranted="ROLE_ADMIN,ROLE_SUPER_ADMIN">
     	$.get('${context}/job/processlist/master',null,function(data){
        	  $('#config').html(data); 
     	 });
        </@security.authorize>
     });
        
        
       //暂停计划任务 
       function pauseScheduler(name,group,page){
            var params;
            if (params == null)params = {};
            params['name'] = name;
            params['group'] = group;
            
            $.post('${context}/job/pauseScheduler',params,function(data){
                $.get('${context}/job/'+page,null,function(data){
       	          $('#'+page).html(data);
       	       });
             });
         
        }
        
        function goto(system){
        
         $.get('${context}/job/processlist/'+system,null,function(data){
        	  $('#config').html(data); 
     	 });
        }
        
        
        //开始计划任务
        function resumeScheduler(name,group,page){
            var params;
            if (params == null)params = {};
            params['name'] = name;
            params['group'] = group;
            $.post('${context}/job/resumeScheduler',params,function(data){
                $.get('${context}/job/'+page,null,function(data){
       	         $('#'+page).html(data);
       	         });
             });
         
        }
        
        //改变计划任务时间
        function changeSchedulerTrigger(name,group,page){
            var params;
            if (params == null)params = {};
            params['name'] = name;
            params['group'] = group;
            params['hour'] = $('#'+name+'_hour').val()
            params['minute'] = $('#'+name+'_minute').val()
            params['second'] = $('#'+name+'_second').val()
            
            $.post('${context}/job/changeSchedulerTrigger',params,function(data){
                $.get('${context}/job/'+page,null,function(data){
       	         $('#'+page).html(data);
       	         });
             });
         
        }
        
        //提交进程配置修改
        function changeProcessConfig(id,processname){
        
            var params;
            if (params == null)params = {};
            params['id'] = id;
            params['processname'] = processname;
            params['alertpattern'] = $('#alertpattern_'+id).val();
            params['startpattern'] = $('#startpattern_'+id).val();
            
            $.post('${context}/job/updateProcessConfig',params,function(data){
                if(data){
                  alert('修改成功！');
                 }else{
                  alert('修改失败！');
                 }
             });
         
        }
         //手动启动主机
       function startUpClotsSys(){
            $.post('${context}/job/startUpClotsSys',null,function(data){
                if(data){
                  alert('启动系统成功！');
                 }else{
                  alert('启动系统失败！');
                 }
             });
         
        }
       //手动停止主机
       function shutDownClotsSys(){
            $.post('${context}/job/shutDownClotsSys',null,function(data){
                if(data){
                  alert('停止系统成功！');
                 }else{
                  alert('停止系统失败！');
                 }
             });
         
        }           
        
    </script>
</head>

<body>

 <div class="home">
    <div class="content" id="joblist"></div>
    <div class="content" id="config"></div>
 </div>
</@base.page >


