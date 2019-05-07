package com.salaboy.review.client.swagger.api;


import com.salaboy.review.client.swagger.configuration.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${invoice_.name:invoice}", url="${invoice_.url:http://invoice:8081}", configuration = ClientConfiguration.class)
public interface InvoiceResourceApiClient extends InvoiceResourceApi {
}
