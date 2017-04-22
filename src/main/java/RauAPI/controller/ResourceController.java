package RauAPI.controller;

import RauAPI.model.Resource;
import RauAPI.model.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by flo on 22.04.17.
 */
@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/resource", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity getAllResources() {
        List<Resource> resources = resourceService.getAllRessources();
        if (resources.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok().body(resources);
    }

    @RequestMapping(value = "/resource/{id}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity getResource(@PathVariable("id") int id) {
        Resource resource = resourceService.getResource(id);
        if (resource == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(resource);
    }

    @RequestMapping(value = "/resource", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity addResource(@RequestBody Resource resource) {
        int result = resourceService.addResource(resource);
        return ResponseEntity.ok().build();
    }

}
