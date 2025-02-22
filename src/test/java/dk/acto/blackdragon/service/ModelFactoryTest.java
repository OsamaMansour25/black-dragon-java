package dk.acto.blackdragon.service;

import dk.acto.blackdragon.model.Model;
import io.vavr.collection.List;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ModelFactoryTest {

    @Test(dependsOnGroups = "fetch", groups = "parse")
    public void testParse(ITestContext context) {

        String data = String.valueOf(context.getAttribute("data"));
        // Log the value of the data attribute
        System.out.println("Data attribute value: " + data);

        ModelFactory<Model> subject = new MyModelFactory();

        List<Model> result = subject.parse(data);
        assertNotNull(result);
        assertEquals(result.length(), 13);
        context.setAttribute("models", result);
    }
}