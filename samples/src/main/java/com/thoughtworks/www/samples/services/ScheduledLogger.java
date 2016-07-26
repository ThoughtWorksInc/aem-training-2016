package com.thoughtworks.www.samples.services;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Component(
        metatype = true,
        label = "TW samples scheduled logger",
        description = "Simple demo for cron-job like task with properties",
        immediate = true)
@Properties({
        @Property(
                label = "Cron expression defining when this Scheduled Service will run",
                name = "scheduler.expression",
                value = "*/30 * * * * ?",
                description = "Cron-job expression"),
        @Property(
                label = "Allow concurrent executions",
                name = "scheduler.concurrent",
                boolValue = false,
                propertyPrivate = true,
                description = "Whether or not to schedule this task concurrently")
})
@Service
public class ScheduledLogger implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledLogger.class);

    @Override
    public void run() {
        logger.debug("SimpleScheduledTask is now running, myParameter='{}'", myParameter);
    }

    @Property(label = "A parameter", description = "Can be configured in /system/console/configMgr")
    public static final String MY_PARAMETER = "myParameter";
    private String myParameter;

    @Activate
    protected void activate(final Map<String, Object> config) {
        configure(config);
    }

    private void configure(final Map<String, Object> config) {
        myParameter = PropertiesUtil.toString(config.get(MY_PARAMETER), null);
        logger.debug("configure: myParameter='{}''", myParameter);
    }
}
