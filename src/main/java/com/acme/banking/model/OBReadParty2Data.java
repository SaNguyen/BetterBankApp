package com.acme.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * OBReadParty2Data
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-13T17:34:42.069342-05:00[America/Chicago]")
public class OBReadParty2Data   {
  @JsonProperty("Party")
  private OBParty2 party;

  public OBReadParty2Data party(OBParty2 party) {
    this.party = party;
    return this;
  }

  /**
   * Get party
   * @return party
  */
  @ApiModelProperty(value = "")

  @Valid

  public OBParty2 getParty() {
    return party;
  }

  public void setParty(OBParty2 party) {
    this.party = party;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadParty2Data obReadParty2Data = (OBReadParty2Data) o;
    return Objects.equals(this.party, obReadParty2Data.party);
  }

  @Override
  public int hashCode() {
    return Objects.hash(party);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadParty2Data {\n");
    
    sb.append("    party: ").append(toIndentedString(party)).append("\n");
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

