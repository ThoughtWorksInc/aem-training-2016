package com.thoughtworks.www.samples.services;

import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;

public interface SimpleService {
    String PROP_NAME = "service-name";

    String helloWorld();

    void doWork(ResourceResolver resourceResolver) throws PersistenceException;
}