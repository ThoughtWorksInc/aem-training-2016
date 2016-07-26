package com.thoughtworks.www.samples.servlets;

import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReferencedAssetsServletTest {
    @Rule
    public AemContext context = new AemContext();

    @InjectMocks
    ReferencedAssetsServlet referencedAssetsServlet;

    private final static String ASSETS_SAMPLE = "/content/dam/any/dam.jpg";
    private Resource resource;

    @Mock
    private MockSlingHttpServletRequest request;

    @Mock
    private MockSlingHttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        resource = context.create().resource(ASSETS_SAMPLE);
        request.setMethod(HttpConstants.METHOD_GET);
        when(request.getResource()).thenReturn(resource);
        response = new MockSlingHttpServletResponse();
    }

    @Test
    public void testDoGet() throws Exception {
        referencedAssetsServlet.doGet(request, response);
        assertEquals("application/json", response.getContentType());
    }
}