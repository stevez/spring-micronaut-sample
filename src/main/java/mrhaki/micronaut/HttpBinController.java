package mrhaki.micronaut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping("/sample")
public class HttpBinController {

    private final HttpBinClient client;

    public HttpBinController(final HttpBinClient client) {
        this.client = client;
    }

    @GetMapping(value = "/uuid", produces = TEXT_PLAIN_VALUE)
    Mono<String> uuid() {
        return client.uuid().map(response -> response.getUuid().toString());
    }

    @GetMapping(value = "/data")
    Mono<ResponseData.MessageResponseData> data() {
        return client.data("Micronaut rocks").map(response -> response.getJson());
    }

}
