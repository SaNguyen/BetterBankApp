package com.acme.bankapp.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Meta Data relevant to the payload
 */
@ApiModel(description = "Meta Data relevant to the payload")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-02T21:42:03.713950-05:00[America/Chicago]")
public class Meta   {
  @JsonProperty("TotalPages")
  private Integer totalPages;

  @JsonProperty("FirstAvailableDateTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private Date firstAvailableDateTime;

  @JsonProperty("LastAvailableDateTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private Date lastAvailableDateTime;

  public Meta totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  @ApiModelProperty(value = "")


  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Meta firstAvailableDateTime(Date firstAvailableDateTime) {
    this.firstAvailableDateTime = firstAvailableDateTime;
    return this;
  }

  /**
   * All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return firstAvailableDateTime
  */
  @ApiModelProperty(value = "All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00")

  @Valid

  public Date getFirstAvailableDateTime() {
    return firstAvailableDateTime;
  }

  public void setFirstAvailableDateTime(Date firstAvailableDateTime) {
    this.firstAvailableDateTime = firstAvailableDateTime;
  }

  public Meta lastAvailableDateTime(Date lastAvailableDateTime) {
    this.lastAvailableDateTime = lastAvailableDateTime;
    return this;
  }

  /**
   * All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00
   * @return lastAvailableDateTime
  */
  @ApiModelProperty(value = "All dates in the JSON payloads are represented in ISO 8601 date-time format.  All date-time fields in responses must include the timezone. An example is below: 2017-04-05T10:43:07+00:00")

  @Valid

  public Date getLastAvailableDateTime() {
    return lastAvailableDateTime;
  }

  public void setLastAvailableDateTime(Date lastAvailableDateTime) {
    this.lastAvailableDateTime = lastAvailableDateTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meta meta = (Meta) o;
    return Objects.equals(this.totalPages, meta.totalPages) &&
        Objects.equals(this.firstAvailableDateTime, meta.firstAvailableDateTime) &&
        Objects.equals(this.lastAvailableDateTime, meta.lastAvailableDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, firstAvailableDateTime, lastAvailableDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Meta {\n");
    
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    firstAvailableDateTime: ").append(toIndentedString(firstAvailableDateTime)).append("\n");
    sb.append("    lastAvailableDateTime: ").append(toIndentedString(lastAvailableDateTime)).append("\n");
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

