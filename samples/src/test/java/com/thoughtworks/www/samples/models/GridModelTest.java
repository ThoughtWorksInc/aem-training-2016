package com.thoughtworks.www.samples.models;

import io.wcm.testing.mock.aem.junit.AemContext;
import junitx.util.PrivateAccessor;
import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GridModelTest {

    @Rule
    public AemContext context = new AemContext();

    public Resource resource;

    private GridModel gridModel;

    @Before
    public void setup() throws Exception {
        resource = context.create().resource("app/content/test/resource");
        context.addModelsForPackage("com.thoughtworks.www.samples.models");

        gridModel = context.currentResource(resource).adaptTo(GridModel.class);
        PrivateAccessor.setField(gridModel, "grid", "3");
    }

    @Test
    public void testGridCount() throws Exception {
        assertNotNull(gridModel);
        List<Map<String, String>> grid = gridModel.getGrid();
        assertNotNull(grid);
        assertEquals(3, grid.size());
        String itemStyle = grid.get(0).get("style");
        String itemName = grid.get(0).get("name");
        assertEquals("col-md-4", itemStyle);
        assertEquals("col-content-0", itemName);
    }
}
