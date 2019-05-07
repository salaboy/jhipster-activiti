package io.swagger.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import io.swagger.configuration.ClientConfiguration;

@FeignClient(name="${invoice_.name:invoice_}", url="${invoice_.url:https://35.189.86.253:8080/invoice}", configuration = ClientConfiguration.class)
public interface InvoiceResourceApiClient extends InvoiceResourceApi {
}