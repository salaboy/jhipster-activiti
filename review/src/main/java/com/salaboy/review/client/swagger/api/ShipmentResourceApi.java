/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.salaboy.review.client.swagger.api;

import com.salaboy.review.client.swagger.model.Shipment;
import io.swagger.annotations.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-01T12:21:00.421Z")

@Api(value = "ShipmentResource", description = "the ShipmentResource API")
public interface ShipmentResourceApi {

    @ApiOperation(value = "createShipment", nickname = "createShipmentUsingPOST", notes = "", response = Shipment.class, tags={ "shipment-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Shipment.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/shipments",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<Shipment> createShipmentUsingPOST(@ApiParam(value = "shipment", required = true) @Valid @RequestBody Shipment shipment);


    @ApiOperation(value = "deleteShipment", nickname = "deleteShipmentUsingDELETE", notes = "", tags={ "shipment-resource", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/shipments/{id}",
        produces = "*/*",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteShipmentUsingDELETE(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllShipments", nickname = "getAllShipmentsUsingGET", notes = "", response = Shipment.class, responseContainer = "List", tags={ "shipment-resource", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Shipment.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/shipments",
        produces = "*/*",
        method = RequestMethod.GET)
    ResponseEntity<List<Shipment>> getAllShipmentsUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page, @ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size, @ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getShipment", nickname = "getShipmentUsingGET", notes = "", response = Shipment.class, tags={ "shipment-resource", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Shipment.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/shipments/{id}",
        produces = "*/*",
        method = RequestMethod.GET)
    ResponseEntity<Shipment> getShipmentUsingGET(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "updateShipment", nickname = "updateShipmentUsingPUT", notes = "", response = Shipment.class, tags={ "shipment-resource", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = Shipment.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/shipments",
        produces = "*/*",
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<Shipment> updateShipmentUsingPUT(@ApiParam(value = "shipment", required = true) @Valid @RequestBody Shipment shipment);

}
