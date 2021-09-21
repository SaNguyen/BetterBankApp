package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Rate type for overdraft fee/charge (where it is charged in terms of a rate rather than an amount)
 */
public enum OBInterestRateType1Code0 {
  
  INBB("INBB"),
  
  INFR("INFR"),
  
  INGR("INGR"),
  
  INLR("INLR"),
  
  INNE("INNE"),
  
  INOT("INOT");

  private String value;

  OBInterestRateType1Code0(String value) {
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
  public static OBInterestRateType1Code0 fromValue(String value) {
    for (OBInterestRateType1Code0 b : OBInterestRateType1Code0.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

