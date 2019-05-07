package com.salaboy.review.web.rest;


import com.salaboy.review.client.swagger.api.ShipmentResourceApiClient;
import com.salaboy.review.client.swagger.model.Invoice;
import com.salaboy.review.client.swagger.model.Shipment;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.process.runtime.connector.Connector;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;

/**
 * REST controller for managing Invoice.
 */
@RestController
@RequestMapping("/api")
public class ProcessRuntimeResource {

    private final Logger log = LoggerFactory.getLogger(ProcessRuntimeResource.class);


    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private ShipmentResourceApiClient shipmentResourceApiClient;

    @Bean(name = "service-implementation")
    public Connector serviceImplementation() {
        return integrationContext -> {
            System.out.println(">>>> Connector Executed! ");
            System.out.println(">>>" + integrationContext.getInBoundVariables().get("invoice"));
            Invoice invoice = (Invoice)integrationContext.getInBoundVariables().get("invoice");
            Shipment shipment = new Shipment();
            shipment.setDate(OffsetDateTime.now());
            shipment.setInvoice(invoice);
            shipment.setDetails("hey details");
            shipment.setTrackingCode("ABC-123");
            shipmentResourceApiClient.createShipmentUsingPOST(shipment);
            return integrationContext;
        };
    }


    /**
     * POST  /start : Create a new process.
     *
     * @return the ResponseEntity with status 201 (Created) and with body the new invoice, or with status 400 (Bad Request) if the invoice has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/start")
    public ResponseEntity<String> startProcess(@RequestBody Invoice invoice) throws URISyntaxException {

        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 50));
        processRuntime.start(ProcessPayloadBuilder.start()
                 .withProcessDefinitionKey(processDefinitionPage.getContent().get(0).getKey())
            .withVariable("invoice", invoice)
            .build());
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/defs")
    public ResponseEntity<String> getProcessDefs() throws URISyntaxException {

        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 50));
        processDefinitionPage.getContent().stream().forEach(pd -> log.info(pd.getKey()));
        return ResponseEntity.ok("hello process defs");
    }
}
