<#import "/spring.ftl" as spring />
<#import "/templates/mod.ftl" as w/>
<#import "/templates/mod.ftl" as base/>
<#assign context=rc.getContextPath()/>

<@base.page title="syslog">

<script language="javascript" type="text/javascript" src="${context}/static/js/My97DatePicker/WdatePicker.js"></script>
<div class="home">
 <form>
  起始时间:
  <input id="beginDate" size="10" name="beginDate" type="text"/><img onclick="WdatePicker({el:'beginDate'})" src="${context}/static/images/date.png" width="32" height="32" align="absmiddle">
  截至时间:
  <input id="endDate" size="10" name="endDate" type="text"/><img onclick="WdatePicker({el:'endDate'})" src="${context}/static/images/date.png" width="32" height="32" align="absmiddle">
  系统类别：
  <select id="system" name="system">
    <option value="">全部系统</option>
    <option value="master">主机系统</option>
    <option value="lb">负载均衡器</option>
    <option value="admin">后台管理</option>
  </select>
    日志级别：
  <select id="logLevel" name="logLevel">
    <option value="">全部级别</option>
    <option value="I">INFO</option>
    <option value="W">WARN</option>
    <option value="E">ERROR</option>
  </select>
  <input id ="searchsubmit" name="" value="查询" type="button" class="search">
 </form>
 
 <div id="bd" >
 <div valign="top" class="content">
	 <h3>
	   <span><a href="${context}/log/syslogmain" class="<#if title=='syslog'>current</#if>">本系统操作日志</a></span>
	   <span><a class="current">CLOTS系统日志</a></span>
	 </h3>
	 <div class="user" id="right"></div>
 </div>
 </div>
</div>
<script type="text/javascript">

	$(document).ready(function(){
	   //获得系统日志列表
	   $.get('${context}/clotslog/query',null,function(data){
	      $('#right').html(data);
	   }); 
	});
	
	
	if (mini == null)var mini = {};
    if (mini.search == null)mini.search = {};

    mini.search.list = function(params) {
       if (params == null)params = {};
       $.post('${context}/clotslog/query',params,function(data){
            $('#right').html(data);
       })
    }
    
   $('#searchsubmit').click(
      function () {
       var params;
       if (params == null)params = {};
       params=$("form").serializeArray();
       $.post('${context}/clotslog/query',params,function(data){
         $('#right').html(data);
      });
   }); 

 </script>


</@base.page >
