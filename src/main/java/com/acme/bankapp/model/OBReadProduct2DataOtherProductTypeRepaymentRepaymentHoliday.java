package com.acme.bankapp.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details of capital repayment holiday if any
 */
@ApiModel(description = "Details of capital repayment holiday if any")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-02T21:42:03.713950-05:00[America/Chicago]")
public class OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday   {
  @JsonProperty("MaxHolidayLength")
  private Integer maxHolidayLength;

  /**
   * The unit of period (days, weeks, months etc.) of the repayment holiday
   */
  public enum MaxHolidayPeriodEnum {
    PACT("PACT"),
    
    PDAY("PDAY"),
    
    PHYR("PHYR"),
    
    PMTH("PMTH"),
    
    PQTR("PQTR"),
    
    PWEK("PWEK"),
    
    PYER("PYER");

    private String value;

    MaxHolidayPeriodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MaxHolidayPeriodEnum fromValue(String value) {
      for (MaxHolidayPeriodEnum b : MaxHolidayPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("MaxHolidayPeriod")
  private MaxHolidayPeriodEnum maxHolidayPeriod;

  @JsonProperty("Notes")
  @Valid
  private List<String> notes = null;

  public OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday maxHolidayLength(Integer maxHolidayLength) {
    this.maxHolidayLength = maxHolidayLength;
    return this;
  }

  /**
   * The maximum length/duration of a Repayment Holiday
   * @return maxHolidayLength
  */
  @ApiModelProperty(value = "The maximum length/duration of a Repayment Holiday")


  public Integer getMaxHolidayLength() {
    return maxHolidayLength;
  }

  public void setMaxHolidayLength(Integer maxHolidayLength) {
    this.maxHolidayLength = maxHolidayLength;
  }

  public OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday maxHolidayPeriod(MaxHolidayPeriodEnum maxHolidayPeriod) {
    this.maxHolidayPeriod = maxHolidayPeriod;
    return this;
  }

  /**
   * The unit of period (days, weeks, months etc.) of the repayment holiday
   * @return maxHolidayPeriod
  */
  @ApiModelProperty(value = "The unit of period (days, weeks, months etc.) of the repayment holiday")


  public MaxHolidayPeriodEnum getMaxHolidayPeriod() {
    return maxHolidayPeriod;
  }

  public void setMaxHolidayPeriod(MaxHolidayPeriodEnum maxHolidayPeriod) {
    this.maxHolidayPeriod = maxHolidayPeriod;
  }

  public OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday notes(List<String> notes) {
    this.notes = notes;
    return this;
  }

  public OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<String>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  @ApiModelProperty(value = "")


  public List<String> getNotes() {
    return notes;
  }

  public void setNotes(List<String> notes) {
    this.notes = notes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday obReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday = (OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday) o;
    return Objects.equals(this.maxHolidayLength, obReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday.maxHolidayLength) &&
        Objects.equals(this.maxHolidayPeriod, obReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday.maxHolidayPeriod) &&
        Objects.equals(this.notes, obReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxHolidayLength, maxHolidayPeriod, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadProduct2DataOtherProductTypeRepaymentRepaymentHoliday {\n");
    
    sb.append("    maxHolidayLength: ").append(toIndentedString(maxHolidayLength)).append("\n");
    sb.append("    maxHolidayPeriod: ").append(toIndentedString(maxHolidayPeriod)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

