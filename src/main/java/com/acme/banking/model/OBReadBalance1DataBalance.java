package com.acme.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Set of elements used to define the balance details.
 */
@ApiModel(description = "Set of elements used to define the balance details.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-13T17:34:42.069342-05:00[America/Chicago]")
public class OBReadBalance1DataBalance   {
  @JsonProperty("AccountId")
  private String accountId;

  @JsonProperty("CreditDebitIndicator")
  private OBCreditDebitCode2 creditDebitIndicator;

  @JsonProperty("Type")
  private OBBalanceType1Code type;

  @JsonProperty("DateTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private Date dateTime;

  @JsonProperty("Amount")
  private OBReadBalance1DataAmount amount;

  @JsonProperty("CreditLine")
  @Valid
  private List<OBReadBalance1DataCreditLine> creditLine = null;

  public OBReadBalance1DataBalance accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner.")
  @NotNull

@Size(min=1,max=40) 
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public OBReadBalance1DataBalance creditDebitIndicator(OBCreditDebitCode2 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
    return this;
  }

  /**
   * Get creditDebitIndicator
   * @return creditDebitIndicator
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OBCreditDebitCode2 getCreditDebitIndicator() {
    return creditDebitIndicator;
  }

  public void setCreditDebitIndicator(OBCreditDebitCode2 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
  }

  public OBReadBalance1DataBalance type(OBBalanceType1Code type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OBBalanceType1Code getType() {
    return type;
  }

  public void setType(OBBalanceType1Code type) {
    this.type = type;
  }

  public OBReadBalance1DataBalance dateTime(Date dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Indicates the date (and time) of the balance.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return dateTime
  */
  @ApiModelProperty(required = true, value = "Indicates the date (and time) of the balance.All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00")
  @NotNull

  @Valid

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public OBReadBalance1DataBalance amount(OBReadBalance1DataAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OBReadBalance1DataAmount getAmount() {
    return amount;
  }

  public void setAmount(OBReadBalance1DataAmount amount) {
    this.amount = amount;
  }

  public OBReadBalance1DataBalance creditLine(List<OBReadBalance1DataCreditLine> creditLine) {
    this.creditLine = creditLine;
    return this;
  }

  public OBReadBalance1DataBalance addCreditLineItem(OBReadBalance1DataCreditLine creditLineItem) {
    if (this.creditLine == null) {
      this.creditLine = new ArrayList<OBReadBalance1DataCreditLine>();
    }
    this.creditLine.add(creditLineItem);
    return this;
  }

  /**
   * Get creditLine
   * @return creditLine
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<OBReadBalance1DataCreditLine> getCreditLine() {
    return creditLine;
  }

  public void setCreditLine(List<OBReadBalance1DataCreditLine> creditLine) {
    this.creditLine = creditLine;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadBalance1DataBalance obReadBalance1DataBalance = (OBReadBalance1DataBalance) o;
    return Objects.equals(this.accountId, obReadBalance1DataBalance.accountId) &&
        Objects.equals(this.creditDebitIndicator, obReadBalance1DataBalance.creditDebitIndicator) &&
        Objects.equals(this.type, obReadBalance1DataBalance.type) &&
        Objects.equals(this.dateTime, obReadBalance1DataBalance.dateTime) &&
        Objects.equals(this.amount, obReadBalance1DataBalance.amount) &&
        Objects.equals(this.creditLine, obReadBalance1DataBalance.creditLine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, creditDebitIndicator, type, dateTime, amount, creditLine);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadBalance1DataBalance {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    creditDebitIndicator: ").append(toIndentedString(creditDebitIndicator)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    creditLine: ").append(toIndentedString(creditLine)).append("\n");
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

