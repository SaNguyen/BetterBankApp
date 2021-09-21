package com.acme.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OBReadBalance1Data
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-13T17:34:42.069342-05:00[America/Chicago]")
public class OBReadBalance1Data   {
  @JsonProperty("Balance")
  @Valid
  private List<OBReadBalance1DataBalance> balance = new ArrayList<OBReadBalance1DataBalance>();

  public OBReadBalance1Data balance(List<OBReadBalance1DataBalance> balance) {
    this.balance = balance;
    return this;
  }

  public OBReadBalance1Data addBalanceItem(OBReadBalance1DataBalance balanceItem) {
    this.balance.add(balanceItem);
    return this;
  }

  /**
   * Get balance
   * @return balance
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@Size(min=1) 
  public List<OBReadBalance1DataBalance> getBalance() {
    return balance;
  }

  public void setBalance(List<OBReadBalance1DataBalance> balance) {
    this.balance = balance;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadBalance1Data obReadBalance1Data = (OBReadBalance1Data) o;
    return Objects.equals(this.balance, obReadBalance1Data.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadBalance1Data {\n");
    
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

