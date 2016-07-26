package com.thoughtworks.www.samples.models;
/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.settings.SlingSettingsService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables=Resource.class)
public class HelloWorldModel {
    @Inject
    private SlingSettingsService settings;

    @Inject @Named("sling:resourceType") @Default(values="No resourceType")
    protected String resourceType;

    @Inject @Optional @Default(values="Unnamed")
    private String username;

    @PostConstruct
    protected void init() {
    }

    public String getMessage() {
        return "\tHello World!\n"
                + "\tThis is instance: " + settings.getSlingId() + "\n"
                + "\tResource type is: " + resourceType + "\n";
    }

    public String getUsername() {
        return username;
    }
}