package RauAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by flo on 22.04.17.
 */
@RestController
public class ResourceController {

    @RequestMapping(value = "/resource", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity getAllResources() {
        return null; //TODO: Implement
    }

}
