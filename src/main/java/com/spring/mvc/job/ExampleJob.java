/**
* ClassName : ExampleJob.java
* Create on ：2016年4月18日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Example QuartzJob
 * @author guanfl
 * JobDetail对象保存运行一个新任务所需要的全部信息，Spring提供一个叫做JobDetailBean的类让JobDetail<br>
 */
public class ExampleJob extends QuartzJobBean {
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("executeInternal jobDetail==>");
    }

}
