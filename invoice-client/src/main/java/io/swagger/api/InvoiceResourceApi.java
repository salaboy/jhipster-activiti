/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Invoice;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-01T12:21:00.421Z")

@Api(value = "InvoiceResource", description = "the InvoiceResource API")
public interface InvoiceResourceApi {

    @ApiOperation(value = "createInvoice", nickname = "createInvoiceUsingPOST", notes = "", response = Invoice.class, tags={ "invoice-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Invoice.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/invoices",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<Invoice> createInvoiceUsingPOST(@ApiParam(value = "invoice" ,required=true )  @Valid @RequestBody Invoice invoice);


    @ApiOperation(value = "deleteInvoice", nickname = "deleteInvoiceUsingDELETE", notes = "", tags={ "invoice-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    @RequestMapping(value = "/api/invoices/{id}",
        produces = "*/*", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvoiceUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "getAllInvoices", nickname = "getAllInvoicesUsingGET", notes = "", response = Invoice.class, responseContainer = "List", tags={ "invoice-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Invoice.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/invoices",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<Invoice>> getAllInvoicesUsingGET(@ApiParam(value = "Page number of the requested page") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "Size of a page") @Valid @RequestParam(value = "size", required = false) Integer size,@ApiParam(value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.") @Valid @RequestParam(value = "sort", required = false) List<String> sort);


    @ApiOperation(value = "getInvoice", nickname = "getInvoiceUsingGET", notes = "", response = Invoice.class, tags={ "invoice-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Invoice.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/invoices/{id}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<Invoice> getInvoiceUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "updateInvoice", nickname = "updateInvoiceUsingPUT", notes = "", response = Invoice.class, tags={ "invoice-resource", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Invoice.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/api/invoices",
        produces = "*/*", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<Invoice> updateInvoiceUsingPUT(@ApiParam(value = "invoice" ,required=true )  @Valid @RequestBody Invoice invoice);

}
