package com.thoughtworks.www.samples.services.impl;

import com.thoughtworks.www.samples.services.SimpleService;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Component(
        label = "TW AEM Samples - Basic OSGi Service",
        description = "Sample implementation of an OSGi service",
        metatype = true,
        configurationFactory = true)
@Properties({
    @Property(
        label = "Service Name",
        name = SimpleService.PROP_NAME,
        description = "This is an example property which is used to uniquely identify the service impl by name.",
        value = "my-sample"
    )
})
@Service
public class SimpleServiceImpl implements SimpleService {
    private static final Logger log = LoggerFactory.getLogger(SimpleServiceImpl.class);

    /* OSGi Properties */
    private static final String DEFAULT_WORLD = "earth";
    private String world = DEFAULT_WORLD;
    @Property(label = "World",
            description = "The world",
            value = DEFAULT_WORLD)
    public static final String PROP_WORLD = "world";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public final String helloWorld() {
        return String.format("Hello %s!", this.world);
    }

    @Override
    public final void doWork(final ResourceResolver resourceResolver) throws PersistenceException {
        Resource resource = resourceResolver.getResource("/content/some/resource");
        ModifiableValueMap properties = resource.adaptTo(ModifiableValueMap.class);
        properties.put("workDone", true);

        resourceResolver.commit();
    }

    /* OSGi Component Methods */
    @Activate
    protected final void activate(final Map<String, String> properties) throws Exception {
        // Read in OSGi Properties for use by the OSGi Service in the Activate method
        this.world = PropertiesUtil.toString(properties.get(PROP_WORLD), DEFAULT_WORLD);
    }

    @Deactivate
    protected final void deactivate(final Map<String, String> properties) {
        // Remove method is not used
    }
}
