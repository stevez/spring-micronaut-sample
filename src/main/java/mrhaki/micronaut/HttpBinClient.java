package mrhaki.micronaut;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client(value="${bin.url}", configuration = BinClientConfiguration.class)
interface HttpBinClient {
    
    @Get("/uuid")
    ResponseUuidData uuid();
    
    @Post("/anything")
    ResponseData data(String message);
    
}
