package london;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

@RestController
public class UserController {

    private static final String basePath = "classpath:responses";
    private ResourceLoader resourceLoader;

    @Autowired
    public UserController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        String path = basePath + "/users.json";
        Resource resource = this.resourceLoader.getResource(path);

        return loadJson(resource).asText();
    }

    static JsonNode loadJson(Resource resource) {
        try {
            String json = IOUtils.toString(resource.getInputStream(), JsonEncoding.UTF8.getJavaName());
            return JsonNodeFactory.instance.textNode(json);
        } catch(IOException e){
            throw new RuntimeException();
        }
    }
    
}