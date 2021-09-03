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
 * Set of elements used to provide details of a generic date time for the statement resource.
 */
@ApiModel(description = "Set of elements used to provide details of a generic date time for the statement resource.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-02T21:42:03.713950-05:00[America/Chicago]")
public class OBStatement2StatementDateTime   {
  @JsonProperty("DateTime")
  private Date dateTime;

  @JsonProperty("Type")
  private String type;

  public OBStatement2StatementDateTime dateTime(Date dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public OBStatement2StatementDateTime type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Date time type, in a coded form.
   * @return type
  */
  @ApiModelProperty(required = true, value = "Date time type, in a coded form.")
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
    OBStatement2StatementDateTime obStatement2StatementDateTime = (OBStatement2StatementDateTime) o;
    return Objects.equals(this.dateTime, obStatement2StatementDateTime.dateTime) &&
        Objects.equals(this.type, obStatement2StatementDateTime.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateTime, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBStatement2StatementDateTime {\n");
    
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
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

