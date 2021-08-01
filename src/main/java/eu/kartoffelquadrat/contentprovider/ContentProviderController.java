/**
 *
 * @Author: Maximilian Schiedermeier
 * @Date: August 2021
 */
package eu.kartoffelquadrat.contentprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/***
 * This controller tells the time via a REST interface.
 */
@RestController
@CrossOrigin
public class ContentProviderController {

    @GetMapping("/resource")
    public String getResource() {
        return "{\"resource\": \"Success!\"}";
    }
}
