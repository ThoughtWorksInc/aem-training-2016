package com.thoughtworks.www.samples.servlets;

import io.wcm.testing.mock.aem.junit.AemContext;
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SearchHelperServletTest {
    @Rule
    public AemContext context = new AemContext();

    @InjectMocks
    SearchHelperServlet searchHelperServlet;

    @Mock
    private MockSlingHttpServletRequest request;

    @Mock
    private MockSlingHttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        request = new MockSlingHttpServletRequest();
        request.setMethod(HttpConstants.METHOD_GET);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("keyword", "test");
        request.setParameterMap(params);
        response = new MockSlingHttpServletResponse();
    }

    @Test
    public void testSearchResult() throws Exception {
//        searchHelperServlet.doGet(request, response);
//        assertEquals("{\"keyword\": \"test\"}", response.getOutputAsString());
    }
}
