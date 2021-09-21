package com.acme.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * Set of elements used to provide details of a generic rate related to the statement resource.
 */
@ApiModel(description = "Set of elements used to provide details of a generic rate related to the statement resource.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-13T17:34:42.069342-05:00[America/Chicago]")
public class OBStatement2StatementRate   {
  @JsonProperty("Rate")
  private String rate;

  @JsonProperty("Type")
  private String type;

  public OBStatement2StatementRate rate(String rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Rate associated with the statement rate type.
   * @return rate
  */
  @ApiModelProperty(required = true, value = "Rate associated with the statement rate type.")
  @NotNull

@Pattern(regexp="^(-?\\d{1,3}){1}(\\.\\d{1,4}){0,1}$") 
  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public OBStatement2StatementRate type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Statement rate type, in a coded form.
   * @return type
  */
  @ApiModelProperty(required = true, value = "Statement rate type, in a coded form.")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBStatement2StatementRate obStatement2StatementRate = (OBStatement2StatementRate) o;
    return Objects.equals(this.rate, obStatement2StatementRate.rate) &&
        Objects.equals(this.type, obStatement2StatementRate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rate, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBStatement2StatementRate {\n");
    
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

