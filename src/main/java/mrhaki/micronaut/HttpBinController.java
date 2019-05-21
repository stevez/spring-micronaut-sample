package mrhaki.micronaut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/sample")
public class HttpBinController {

    @Inject
    private HttpBinClient client;

    public HttpBinController(HttpBinClient client) {
        this.client = client;
    }


    @GetMapping(value = "/uuid", produces = APPLICATION_JSON_VALUE)
    ResponseUuidData uuid() {
        return client.uuid();
    }

    @GetMapping(value = "/data")
    ResponseData.MessageResponseData data() {
        return client.data("Micronaut rocks").getJson();
    }

}
