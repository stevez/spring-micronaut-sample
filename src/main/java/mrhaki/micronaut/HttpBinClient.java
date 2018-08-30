package mrhaki.micronaut;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.Client;
import reactor.core.publisher.Mono;

@Client("http://httpbin.org")
interface HttpBinClient {
    
    @Get("/uuid")
    Mono<ResponseUuidData> uuid();
    
    @Post("/anything")
    Mono<ResponseData> data(String message);
    
}
