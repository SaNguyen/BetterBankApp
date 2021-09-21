package com.acme.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OBReadBeneficiary5
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-13T17:34:42.069342-05:00[America/Chicago]")
public class OBReadBeneficiary5   {
  @JsonProperty("Data")
  private OBReadBeneficiary5Data data;

  @JsonProperty("Links")
  private Links links;

  @JsonProperty("Meta")
  private Meta meta;

  public OBReadBeneficiary5 data(OBReadBeneficiary5Data data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OBReadBeneficiary5Data getData() {
    return data;
  }

  public void setData(OBReadBeneficiary5Data data) {
    this.data = data;
  }

  public OBReadBeneficiary5 links(Links links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
  */
  @ApiModelProperty(value = "")

  @Valid

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }

  public OBReadBeneficiary5 meta(Meta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * @return meta
  */
  @ApiModelProperty(value = "")

  @Valid

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadBeneficiary5 obReadBeneficiary5 = (OBReadBeneficiary5) o;
    return Objects.equals(this.data, obReadBeneficiary5.data) &&
        Objects.equals(this.links, obReadBeneficiary5.links) &&
        Objects.equals(this.meta, obReadBeneficiary5.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, links, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadBeneficiary5 {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

