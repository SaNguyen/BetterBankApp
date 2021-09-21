package com.acme.banking.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Contains details of fees and charges which are not associated with either borrowing or features/benefits
 */
@ApiModel(description = "Contains details of fees and charges which are not associated with either borrowing or features/benefits")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-13T17:34:42.069342-05:00[America/Chicago]")
public class OtherFeesCharges   {
  @JsonProperty("FeeChargeDetail")
  @Valid
  private List<OtherFeesChargesFeeChargeDetail> feeChargeDetail = new ArrayList<OtherFeesChargesFeeChargeDetail>();

  @JsonProperty("FeeChargeCap")
  @Valid
  private List<OtherFeesChargesFeeChargeCap> feeChargeCap = null;

  public OtherFeesCharges feeChargeDetail(List<OtherFeesChargesFeeChargeDetail> feeChargeDetail) {
    this.feeChargeDetail = feeChargeDetail;
    return this;
  }

  public OtherFeesCharges addFeeChargeDetailItem(OtherFeesChargesFeeChargeDetail feeChargeDetailItem) {
    this.feeChargeDetail.add(feeChargeDetailItem);
    return this;
  }

  /**
   * Other fees/charges details
   * @return feeChargeDetail
  */
  @ApiModelProperty(required = true, value = "Other fees/charges details")
  @NotNull

  @Valid
@Size(min=1) 
  public List<OtherFeesChargesFeeChargeDetail> getFeeChargeDetail() {
    return feeChargeDetail;
  }

  public void setFeeChargeDetail(List<OtherFeesChargesFeeChargeDetail> feeChargeDetail) {
    this.feeChargeDetail = feeChargeDetail;
  }

  public OtherFeesCharges feeChargeCap(List<OtherFeesChargesFeeChargeCap> feeChargeCap) {
    this.feeChargeCap = feeChargeCap;
    return this;
  }

  public OtherFeesCharges addFeeChargeCapItem(OtherFeesChargesFeeChargeCap feeChargeCapItem) {
    if (this.feeChargeCap == null) {
      this.feeChargeCap = new ArrayList<OtherFeesChargesFeeChargeCap>();
    }
    this.feeChargeCap.add(feeChargeCapItem);
    return this;
  }

  /**
   * Details about any caps (maximum charges) that apply to a particular fee/charge
   * @return feeChargeCap
  */
  @ApiModelProperty(value = "Details about any caps (maximum charges) that apply to a particular fee/charge")

  @Valid

  public List<OtherFeesChargesFeeChargeCap> getFeeChargeCap() {
    return feeChargeCap;
  }

  public void setFeeChargeCap(List<OtherFeesChargesFeeChargeCap> feeChargeCap) {
    this.feeChargeCap = feeChargeCap;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtherFeesCharges otherFeesCharges = (OtherFeesCharges) o;
    return Objects.equals(this.feeChargeDetail, otherFeesCharges.feeChargeDetail) &&
        Objects.equals(this.feeChargeCap, otherFeesCharges.feeChargeCap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feeChargeDetail, feeChargeCap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtherFeesCharges {\n");
    
    sb.append("    feeChargeDetail: ").append(toIndentedString(feeChargeDetail)).append("\n");
    sb.append("    feeChargeCap: ").append(toIndentedString(feeChargeCap)).append("\n");
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

