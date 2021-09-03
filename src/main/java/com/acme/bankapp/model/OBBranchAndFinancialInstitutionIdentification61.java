package com.acme.bankapp.model;

import java.util.Objects;
import com.acme.bankapp.model.OBPostalAddress6;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Financial institution servicing an account for the creditor.
 */
@ApiModel(description = "Financial institution servicing an account for the creditor.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-02T21:42:03.713950-05:00[America/Chicago]")
public class OBBranchAndFinancialInstitutionIdentification61   {
  @JsonProperty("SchemeName")
  private String schemeName;

  @JsonProperty("Identification")
  private String identification;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("PostalAddress")
  private OBPostalAddress6 postalAddress;

  public OBBranchAndFinancialInstitutionIdentification61 schemeName(String schemeName) {
    this.schemeName = schemeName;
    return this;
  }

  /**
   * Name of the identification scheme, in a coded form as published in an external list.
   * @return schemeName
  */
  @ApiModelProperty(value = "Name of the identification scheme, in a coded form as published in an external list.")


  public String getSchemeName() {
    return schemeName;
  }

  public void setSchemeName(String schemeName) {
    this.schemeName = schemeName;
  }

  public OBBranchAndFinancialInstitutionIdentification61 identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Unique and unambiguous identification of a financial institution or a branch of a financial institution.
   * @return identification
  */
  @ApiModelProperty(value = "Unique and unambiguous identification of a financial institution or a branch of a financial institution.")

@Size(min=1,max=35) 
  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public OBBranchAndFinancialInstitutionIdentification61 name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name by which an agent is known and which is usually used to identify that agent.
   * @return name
  */
  @ApiModelProperty(value = "Name by which an agent is known and which is usually used to identify that agent.")

@Size(min=1,max=140) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OBBranchAndFinancialInstitutionIdentification61 postalAddress(OBPostalAddress6 postalAddress) {
    this.postalAddress = postalAddress;
    return this;
  }

  /**
   * Get postalAddress
   * @return postalAddress
  */
  @ApiModelProperty(value = "")

  @Valid

  public OBPostalAddress6 getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(OBPostalAddress6 postalAddress) {
    this.postalAddress = postalAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBBranchAndFinancialInstitutionIdentification61 obBranchAndFinancialInstitutionIdentification61 = (OBBranchAndFinancialInstitutionIdentification61) o;
    return Objects.equals(this.schemeName, obBranchAndFinancialInstitutionIdentification61.schemeName) &&
        Objects.equals(this.identification, obBranchAndFinancialInstitutionIdentification61.identification) &&
        Objects.equals(this.name, obBranchAndFinancialInstitutionIdentification61.name) &&
        Objects.equals(this.postalAddress, obBranchAndFinancialInstitutionIdentification61.postalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemeName, identification, name, postalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBBranchAndFinancialInstitutionIdentification61 {\n");
    
    sb.append("    schemeName: ").append(toIndentedString(schemeName)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    postalAddress: ").append(toIndentedString(postalAddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

