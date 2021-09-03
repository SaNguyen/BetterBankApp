/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.acme.bankapp.api;

import java.util.Date;
import com.acme.bankapp.model.OBErrorResponse1;
import com.acme.bankapp.model.OBReadTransaction6;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-02T21:42:03.713950-05:00[America/Chicago]")
@Validated
@Api(value = "transactions", description = "the transactions API")
public interface TransactionsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /transactions : Get Transactions
     *
     * @param authorization An Authorisation Token as per https://tools.ietf.org/html/rfc6750 (required)
     * @param xFapiAuthDate The time when the PSU last logged in with the TPP.  All dates in the HTTP headers are represented as RFC 7231 Full Dates. An example is below:  Sun, 10 Sep 2017 19:43:31 UTC (optional)
     * @param xFapiCustomerIpAddress The PSU&#39;s IP address if the PSU is currently logged in with the TPP. (optional)
     * @param xFapiInteractionId An RFC4122 UID used as a correlation id. (optional)
     * @param xCustomerUserAgent Indicates the user-agent that the PSU is using. (optional)
     * @param fromBookingDateTime The UTC ISO 8601 Date Time to filter transactions FROM NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component. (optional)
     * @param toBookingDateTime The UTC ISO 8601 Date Time to filter transactions TO NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component. (optional)
     * @return Transactions Read (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     *         or Method Not Allowed (status code 405)
     *         or Not Acceptable (status code 406)
     *         or Too Many Requests (status code 429)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "Get Transactions", nickname = "getTransactions", notes = "", response = OBReadTransaction6.class, authorizations = {
        @Authorization(value = "PSUOAuth2Security", scopes = {
            @AuthorizationScope(scope = "accounts", description = "Ability to read Accounts information") })
         }, tags={ "Transactions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Transactions Read", response = OBReadTransaction6.class),
        @ApiResponse(code = 400, message = "Bad request", response = OBErrorResponse1.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden", response = OBErrorResponse1.class),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 405, message = "Method Not Allowed"),
        @ApiResponse(code = 406, message = "Not Acceptable"),
        @ApiResponse(code = 429, message = "Too Many Requests"),
        @ApiResponse(code = 500, message = "Internal Server Error", response = OBErrorResponse1.class) })
    @GetMapping(
        value = "/transactions",
        produces = { "application/json; charset=utf-8", "application/json", "application/jose+jwe" }
    )
    default ResponseEntity<OBReadTransaction6> getTransactions(@ApiParam(value = "An Authorisation Token as per https://tools.ietf.org/html/rfc6750" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "The time when the PSU last logged in with the TPP.  All dates in the HTTP headers are represented as RFC 7231 Full Dates. An example is below:  Sun, 10 Sep 2017 19:43:31 UTC" ) @RequestHeader(value="x-fapi-auth-date", required=false) String xFapiAuthDate,@ApiParam(value = "The PSU's IP address if the PSU is currently logged in with the TPP." ) @RequestHeader(value="x-fapi-customer-ip-address", required=false) String xFapiCustomerIpAddress,@ApiParam(value = "An RFC4122 UID used as a correlation id." ) @RequestHeader(value="x-fapi-interaction-id", required=false) String xFapiInteractionId,@ApiParam(value = "Indicates the user-agent that the PSU is using." ) @RequestHeader(value="x-customer-user-agent", required=false) String xCustomerUserAgent,@ApiParam(value = "The UTC ISO 8601 Date Time to filter transactions FROM NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component.") @Valid @RequestParam(value = "fromBookingDateTime", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) Date fromBookingDateTime,@ApiParam(value = "The UTC ISO 8601 Date Time to filter transactions TO NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component.") @Valid @RequestParam(value = "toBookingDateTime", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) Date toBookingDateTime) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"Meta\" : { \"LastAvailableDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"FirstAvailableDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"TotalPages\" : 0 }, \"Links\" : { \"Last\" : \"https://openapi-generator.tech\", \"Prev\" : \"https://openapi-generator.tech\", \"Next\" : \"https://openapi-generator.tech\", \"Self\" : \"https://openapi-generator.tech\", \"First\" : \"https://openapi-generator.tech\" }, \"Data\" : { \"Transaction\" : [ { \"SupplementaryData\" : { \"key\" : \"{}\" }, \"CreditorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"DebtorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"AccountId\" : \"AccountId\", \"TransactionReference\" : \"TransactionReference\", \"ProprietaryBankTransactionCode\" : { \"Issuer\" : \"Issuer\", \"Code\" : \"Code\" }, \"AddressLine\" : \"AddressLine\", \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"CreditorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"CurrencyExchange\" : { \"SourceCurrency\" : \"SourceCurrency\", \"ExchangeRate\" : 0.8008281904610115, \"QuotationDate\" : \"2000-01-23T04:56:07.000+00:00\", \"UnitCurrency\" : \"UnitCurrency\", \"ContractIdentification\" : \"ContractIdentification\", \"InstructedAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TargetCurrency\" : \"TargetCurrency\" }, \"StatementReference\" : [ null, null ], \"ChargeAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TransactionId\" : \"TransactionId\", \"TransactionInformation\" : \"TransactionInformation\", \"BookingDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"BankTransactionCode\" : { \"SubCode\" : \"SubCode\", \"Code\" : \"Code\" }, \"MerchantDetails\" : { \"MerchantName\" : \"MerchantName\", \"MerchantCategoryCode\" : \"MerchantCategoryCode\" }, \"CardInstrument\" : { \"AuthorisationType\" : \"ConsumerDevice\", \"Identification\" : \"Identification\", \"CardSchemeName\" : \"AmericanExpress\", \"Name\" : \"Name\" }, \"ValueDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"DebtorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"Balance\" : { \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" } } }, { \"SupplementaryData\" : { \"key\" : \"{}\" }, \"CreditorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"DebtorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"AccountId\" : \"AccountId\", \"TransactionReference\" : \"TransactionReference\", \"ProprietaryBankTransactionCode\" : { \"Issuer\" : \"Issuer\", \"Code\" : \"Code\" }, \"AddressLine\" : \"AddressLine\", \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"CreditorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"CurrencyExchange\" : { \"SourceCurrency\" : \"SourceCurrency\", \"ExchangeRate\" : 0.8008281904610115, \"QuotationDate\" : \"2000-01-23T04:56:07.000+00:00\", \"UnitCurrency\" : \"UnitCurrency\", \"ContractIdentification\" : \"ContractIdentification\", \"InstructedAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TargetCurrency\" : \"TargetCurrency\" }, \"StatementReference\" : [ null, null ], \"ChargeAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TransactionId\" : \"TransactionId\", \"TransactionInformation\" : \"TransactionInformation\", \"BookingDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"BankTransactionCode\" : { \"SubCode\" : \"SubCode\", \"Code\" : \"Code\" }, \"MerchantDetails\" : { \"MerchantName\" : \"MerchantName\", \"MerchantCategoryCode\" : \"MerchantCategoryCode\" }, \"CardInstrument\" : { \"AuthorisationType\" : \"ConsumerDevice\", \"Identification\" : \"Identification\", \"CardSchemeName\" : \"AmericanExpress\", \"Name\" : \"Name\" }, \"ValueDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"DebtorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"Balance\" : { \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" } } } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json; charset=utf-8"))) {
                    String exampleString = "{ \"Meta\" : { \"LastAvailableDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"FirstAvailableDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"TotalPages\" : 0 }, \"Links\" : { \"Last\" : \"https://openapi-generator.tech\", \"Prev\" : \"https://openapi-generator.tech\", \"Next\" : \"https://openapi-generator.tech\", \"Self\" : \"https://openapi-generator.tech\", \"First\" : \"https://openapi-generator.tech\" }, \"Data\" : { \"Transaction\" : [ { \"SupplementaryData\" : { \"key\" : \"{}\" }, \"CreditorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"DebtorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"AccountId\" : \"AccountId\", \"TransactionReference\" : \"TransactionReference\", \"ProprietaryBankTransactionCode\" : { \"Issuer\" : \"Issuer\", \"Code\" : \"Code\" }, \"AddressLine\" : \"AddressLine\", \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"CreditorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"CurrencyExchange\" : { \"SourceCurrency\" : \"SourceCurrency\", \"ExchangeRate\" : 0.8008281904610115, \"QuotationDate\" : \"2000-01-23T04:56:07.000+00:00\", \"UnitCurrency\" : \"UnitCurrency\", \"ContractIdentification\" : \"ContractIdentification\", \"InstructedAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TargetCurrency\" : \"TargetCurrency\" }, \"StatementReference\" : [ null, null ], \"ChargeAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TransactionId\" : \"TransactionId\", \"TransactionInformation\" : \"TransactionInformation\", \"BookingDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"BankTransactionCode\" : { \"SubCode\" : \"SubCode\", \"Code\" : \"Code\" }, \"MerchantDetails\" : { \"MerchantName\" : \"MerchantName\", \"MerchantCategoryCode\" : \"MerchantCategoryCode\" }, \"CardInstrument\" : { \"AuthorisationType\" : \"ConsumerDevice\", \"Identification\" : \"Identification\", \"CardSchemeName\" : \"AmericanExpress\", \"Name\" : \"Name\" }, \"ValueDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"DebtorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"Balance\" : { \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" } } }, { \"SupplementaryData\" : { \"key\" : \"{}\" }, \"CreditorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"DebtorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"AccountId\" : \"AccountId\", \"TransactionReference\" : \"TransactionReference\", \"ProprietaryBankTransactionCode\" : { \"Issuer\" : \"Issuer\", \"Code\" : \"Code\" }, \"AddressLine\" : \"AddressLine\", \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"CreditorAccount\" : { \"SecondaryIdentification\" : \"SecondaryIdentification\", \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"CurrencyExchange\" : { \"SourceCurrency\" : \"SourceCurrency\", \"ExchangeRate\" : 0.8008281904610115, \"QuotationDate\" : \"2000-01-23T04:56:07.000+00:00\", \"UnitCurrency\" : \"UnitCurrency\", \"ContractIdentification\" : \"ContractIdentification\", \"InstructedAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TargetCurrency\" : \"TargetCurrency\" }, \"StatementReference\" : [ null, null ], \"ChargeAmount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" }, \"TransactionId\" : \"TransactionId\", \"TransactionInformation\" : \"TransactionInformation\", \"BookingDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"BankTransactionCode\" : { \"SubCode\" : \"SubCode\", \"Code\" : \"Code\" }, \"MerchantDetails\" : { \"MerchantName\" : \"MerchantName\", \"MerchantCategoryCode\" : \"MerchantCategoryCode\" }, \"CardInstrument\" : { \"AuthorisationType\" : \"ConsumerDevice\", \"Identification\" : \"Identification\", \"CardSchemeName\" : \"AmericanExpress\", \"Name\" : \"Name\" }, \"ValueDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"DebtorAgent\" : { \"PostalAddress\" : { \"StreetName\" : \"StreetName\", \"CountrySubDivision\" : \"CountrySubDivision\", \"Department\" : \"Department\", \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ], \"BuildingNumber\" : \"BuildingNumber\", \"TownName\" : \"TownName\", \"Country\" : \"Country\", \"SubDepartment\" : \"SubDepartment\", \"PostCode\" : \"PostCode\" }, \"SchemeName\" : \"SchemeName\", \"Identification\" : \"Identification\", \"Name\" : \"Name\" }, \"Balance\" : { \"Amount\" : { \"Amount\" : \"Amount\", \"Currency\" : \"Currency\" } } } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json; charset=utf-8", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
