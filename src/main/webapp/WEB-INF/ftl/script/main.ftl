<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as w/>
<#import "/templates/mod.ftl" as base/>
<#assign context=rc.getContextPath()/>
<#assign security=JspTaglibs["/WEB-INF/security.tld"] />
<@base.page title="script">


  <div id="bd" class="home">
    <div class="user" id="right"></div>

<div id="addform" style="<#if error??><#else>display:none</#if>">
<h3>新增定时脚本</h3>
<form action="${context}/script/addScript" method="post">
<table cellpadding="0" cellspacing="0">
	<tr>
		<th>脚本名称：</th>
		<td><@spring.formInput "scriptForm.jobname" /><span>* <@spring.showErrors "<br>"/></span></td>
	</tr>
	<tr>
		<th>脚本路径：</th>
		<td><@spring.formInput "scriptForm.scriptpath" /><span>* <@spring.showErrors "<br>"/></span></td>
	</tr>
    <tr>
    	<th style="border-bottom:none;">所属系统：</th>
    	<td style="border-bottom:none;">
    	 <input type="radio" name="system" value="master" checked> 主机 
         <input type="radio" name="system" value="admin"> 后台 
         <input type="radio" name="system" value="lb"> 负载均衡 
       </td>
    </tr>
    <tr>
		<th>时间表达式：</th>
		<td><@spring.formInput "scriptForm.cronExpression" /><span>* <@spring.showErrors "<br>"/></span></td>
	</tr>
</table>

 <div region="south" class="box_b">
   <input type="submit" value="确  定" class="ok">
   <input onclick="hiddenform();" type="button" value="取  消" class="cancel">
 </div>
</form> 
</div>

</div>
<script type="text/javascript">

     $(document).ready(function(){
		   //获得所有脚本列表
		   $.get('${context}/script/scriptlist',null,function(data){
		      $('#right').html(data);
		   }); 
	  });
		
		
	  function showaddform(){
	     $("#addform").show();
	  }
	  
	 function showeditform(id,jobname,cronExpression){
	        var params;
            if (params == null)params = {};
            params['id'] = id;
            params['jobname'] = jobname;
            params['cronExpression'] = cronExpression;
	       $.get('${context}/script/showEditForm',params,function(data){
		      $('#cronExpression_'+id).html(data);
		   }); 
	  }
	  
	  function hiddenform(){
	     $("#addform").hide();
	  }	
	  function hiddeneditform(){
	     $("#editform").hide();
	  }	
  
	  //删除脚本
	  function removeScript(jobname,id){
	   if(confirm("确定要删除该脚本配置吗？")){
	     var params;
	     if (params == null)params = {};
	     params['jobname'] = jobname;
	     params['id'] = id;
	     $.post('${context}/script/delScript/',params,function(data){
	      $.get('${context}/script/scriptlist',null,function(data){
	  	      $('#right').html(data);
	  	   });
	     });
	    }
	   }
   
       //暂停计划任务 
       function pauseScheduler(name,group){
            var params;
            if (params == null)params = {};
            params['name'] = name;
            params['group'] = group;
            $.post('${context}/script/pauseScheduler',params,function(data){
              $.get('${context}/script/scriptlist',null,function(data){
	  	      $('#right').html(data);
	  	      });
           });
        }
        //开始计划任务
        function resumeScheduler(name,group){
            var params;
            if (params == null)params = {};
            params['name'] = name;
            params['group'] = group;
            $.post('${context}/script/resumeScheduler',params,function(data){
              $.get('${context}/script/scriptlist',null,function(data){
	  	      $('#right').html(data);
	  	      });
             }); 
        }
        
        //改变计划任务时间
        function changeSchedulerTrigger(id,name){
            var params;
            if (params == null)params = {};
            params['jobname'] = name;
            params['cronExpression'] = $('#input_'+id).val()
            
            $.post('${context}/script/changeSchedulerTrigger',params,function(data){
             if(data){
               $.get('${context}/script/scriptlist',null,function(data){
	  	       $('#right').html(data);
	  	       });
	  	      }else{
	  	       alert('日期格式不正确');
	  	      }
             });
        }

 </script>


</@base.page >
