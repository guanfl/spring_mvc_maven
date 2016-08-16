 <h3>计划任务配置</h3>
 <table cellspacing="0" cellpadding="0">
  <tr>
  	<th>任务名</th>
  	<th>运行状态</th>
  	<th>触发时间</th>
  	<th>下一次触发时间</th>
  	<th>操作</th>
  </tr>
  <tr>
   <td>${sJobMessage.jobDescription} </td>
   <td><#if sJobMessage.jobState=='NORMAL'>运行<#else>停止</#if></td>
   <td>
       <select name="start_job_hour" id="start_job_hour" style="vertical-align:middle;">
        <#assign x=24>
         <#list 0..x as i>
          <option VALUE="${i}" <#if i==sJobMessage.hour>selected</#if>>${i}</option>
         </#list>            
       </select>
       点 
       <select name="start_job_minute" id="start_job_minute" style="vertical-align:middle;">
        <#assign x=59>
         <#list 0..x as i>
          <option VALUE="${i}" <#if i==sJobMessage.minute>selected</#if>>${i}</option>
         </#list>            
       </select>
       分   
       <input style="vertical-align:middle;" onclick="changeSchedulerTrigger('start_job','start_group','joblist');" type="button" value="修改" name="button" class="button_g" />
   </td>
   <td>${sJobMessage.nextFireTime?string("yyyy-MM-dd HH:mm:ss")}</td>
   
   <td>
    <#if sJobMessage.jobState=='NORMAL'>
     <a href="javascript:pauseScheduler('start_job','start_group','joblist');" class="paused"></a>
    <#else> 
     <a href="javascript:resumeScheduler('start_job','start_group','joblist');" class="start"></a>
    </#if>
    <input style="vertical-align:middle;" onclick="startUpClotsSys();" type="button" value="启动系统" name="button" class="button_g" />
   </td>
  </tr>
  <tr>
   <td>${dJobMessage.jobDescription} </td>
   <td><#if dJobMessage.jobState=='NORMAL'>运行<#else>停止</#if></td>
   <td>
       <select name="shutdown_job_hour" id="shutdown_job_hour" style="vertical-align:middle;">
        <#assign x=24>
         <#list 1..x as i>
          <option VALUE="${i}" <#if i==dJobMessage.hour>selected</#if>>${i}</option>
         </#list>            
       </select>
       点 
       <select name="shutdown_job_minute" id="shutdown_job_minute" style="vertical-align:middle;">
        <#assign x=59>
         <#list 1..x as i>
          <option VALUE="${i}" <#if i==dJobMessage.minute>selected</#if>>${i}</option>
         </#list>            
       </select>
       分 
       <input style="vertical-align:middle;" class="button_g" onclick="changeSchedulerTrigger('shutdown_job','shutdown_group','joblist');" type="button" value="修改" name="button"/>
   </td>
   <td>${dJobMessage.nextFireTime?string("yyyy-MM-dd HH:mm:ss")}</td>
   
   <td>
    <#if dJobMessage.jobState=='NORMAL'>
     <a href="javascript:pauseScheduler('shutdown_job','shutdown_group','joblist');" class="paused"></a>
    <#else> 
     <a href="javascript:resumeScheduler('shutdown_job','shutdown_group','joblist');" class="start"></a>
    </#if> 
    <input style="vertical-align:middle;" onclick="shutDownClotsSys();" type="button" value="停止系统" name="button" class="button_g" />
   </td>
  </tr>
 
   <tr>
   <td>${gsJobMessage.jobDescription} </td>
   <td><#if gsJobMessage.jobState=='NORMAL'>运行<#else>停止</#if></td>
   <td>
       <select name="game_start_job_hour" id="game_start_job_hour" style="vertical-align:middle;">
        <#assign x=24>
         <#list 0..x as i>
          <option VALUE="${i}" <#if i==gsJobMessage.hour>selected</#if>>${i}</option>
         </#list>            
       </select>
       点 
       <select name="game_start_job_minute" id="game_start_job_minute" style="vertical-align:middle;">
        <#assign x=59>
         <#list 0..x as i>
          <option VALUE="${i}" <#if i==gsJobMessage.minute>selected</#if>>${i}</option>
         </#list>            
       </select>
       分   
       <input style="vertical-align:middle;" onclick="changeSchedulerTrigger('game_start_job','start_group','joblist');" type="button" value="修改" name="button" class="button_g" />
   </td>
   <td>${gsJobMessage.nextFireTime?string("yyyy-MM-dd HH:mm:ss")}</td>
   
   <td>
    <#if gsJobMessage.jobState=='NORMAL'>
     <a href="javascript:pauseScheduler('game_start_job','start_group','joblist');" class="paused"></a>
    <#else> 
     <a href="javascript:resumeScheduler('game_start_job','start_group','joblist');" class="start"></a>
    </#if>
   </td>
  </tr>
  <tr>
   <td>${gdJobMessage.jobDescription} </td>
   <td><#if gdJobMessage.jobState=='NORMAL'>运行<#else>停止</#if></td>
   <td>
       <select name="game_shutdown_job_hour" id="game_shutdown_job_hour" style="vertical-align:middle;">
        <#assign x=24>
         <#list 1..x as i>
          <option VALUE="${i}" <#if i==gdJobMessage.hour>selected</#if>>${i}</option>
         </#list>            
       </select>
       点 
       <select name="game_shutdown_job_minute" id="game_shutdown_job_minute" style="vertical-align:middle;">
        <#assign x=59>
         <#list 1..x as i>
          <option VALUE="${i}" <#if i==gdJobMessage.minute>selected</#if>>${i}</option>
         </#list>            
       </select>
       分 
       <input style="vertical-align:middle;" class="button_g" onclick="changeSchedulerTrigger('game_shutdown_job','shutdown_group','joblist');" type="button" value="修改" name="button"/>
   </td>
   <td>${gdJobMessage.nextFireTime?string("yyyy-MM-dd HH:mm:ss")}</td>
   
   <td>
    <#if gdJobMessage.jobState=='NORMAL'>
     <a href="javascript:pauseScheduler('game_shutdown_job','shutdown_group','joblist');" class="paused"></a>
    <#else> 
     <a href="javascript:resumeScheduler('game_shutdown_job','shutdown_group','joblist');" class="start"></a>
    </#if> 
   </td>
  </tr>
  
  <tr>
   <td>${pJobMessage.jobDescription} </td>
   <td><#if pJobMessage.jobState=='NORMAL'>运行<#elseif pJobMessage.jobState=='BLOCKED'>阻塞<#else>停止</#if></td>
   <td>
       <select name="clots_process_flash_job_second" id="clots_process_flash_job_second" style="vertical-align:middle;">
        <#assign x=20>
         <#list 1..x as i>
          <option VALUE="${i*10}" <#if '0/'+i*10+' * * * * ?'==pJobMessage.cronExpression>selected</#if>>${i*10}</option>
         </#list>            
       </select>
       秒 
       <input style="vertical-align:middle;" class="button_g" onclick="changeSchedulerTrigger('clots_process_flash_job','process_group','joblist');" type="button" value="修改" name="button"/>
   </td>
   <td>${pJobMessage.nextFireTime?string("yyyy-MM-dd HH:mm:ss")}</td>
   
   <td>
    <#if pJobMessage.jobState=='NORMAL' || pJobMessage.jobState=='BLOCKED'>
     <a href="javascript:pauseScheduler('clots_process_flash_job','process_group','joblist');" class="paused"></a>
    <#else> 
     <a href="javascript:resumeScheduler('clots_process_flash_job','process_group','joblist');" class="start"></a>
    </#if> 
   </td>
  </tr>   
 </tabel> 
