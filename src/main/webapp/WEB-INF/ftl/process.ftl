  <div id="online" class="slave">
    <div>
     <table id="master_process" class="log_t_p" cellspacing="0" cellpadding="0">
      <thead>
      	<tr>
      		<th class="l_t_time">主机进程</th>
    	</tr>
      </thead>
      <tbody id="slave_log">
      <#list master_processes as p>
      <tr id="${p.id}" <#if p.alert!=0>class="warning"</#if>>
      	<td class="l_t_time">${p.processname}</td>
      </tr> 
      </#list>
      </tbody>
      </table>
     </div>
  </div>    
  <div id="online" class="slave">
  <div>
     <table id="admin_process" class="log_t_p" cellspacing="0" cellpadding="0">
      <thead>
      	<tr>
      		<th class="l_t_time">后台管理进程</th>
    	</tr>
      </thead>
      <tbody id="slave_log">
      <#list admin_processes as p>
      <tr id="${p.id}" <#if p.alert!=0>class="warning"</#if>>
      	<td class="l_t_time">${p.processname}</td>
      </tr> 
      </#list>
      </tbody>
      </table>
     </div>
  </div>  
  <div id="online" class="slave">
    <div>
     <table id="lb_process" class="log_t_p" cellspacing="0" cellpadding="0">
      <thead>
      	<tr>
      		<th class="l_t_time">LB进程</th>
    	</tr>
      </thead>
      <tbody id="slave_log">
      <#list lb_processes as p>
      <tr id="${p.id}" <#if p.alert!=0>class="warning"</#if>>
      	<td class="l_t_time">${p.processname}</td>
      </tr> 
      </#list>
      </tbody>
      </table>
     </div>
  </div>
