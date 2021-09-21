package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * How frequently the fee/charge is applied to the account
 */
public enum OBFeeFrequency1Code2 {
  
  FEAC("FEAC"),
  
  FEAO("FEAO"),
  
  FECP("FECP"),
  
  FEDA("FEDA"),
  
  FEHO("FEHO"),
  
  FEI("FEI"),
  
  FEMO("FEMO"),
  
  FEOA("FEOA"),
  
  FEOT("FEOT"),
  
  FEPC("FEPC"),
  
  FEPH("FEPH"),
  
  FEPO("FEPO"),
  
  FEPS("FEPS"),
  
  FEPT("FEPT"),
  
  FEPTA("FEPTA"),
  
  FEPTP("FEPTP"),
  
  FEQU("FEQU"),
  
  FESM("FESM"),
  
  FEST("FEST"),
  
  FEWE("FEWE"),
  
  FEYE("FEYE");

  private String value;

  OBFeeFrequency1Code2(String value) {
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
  public static OBFeeFrequency1Code2 fromValue(String value) {
    for (OBFeeFrequency1Code2 b : OBFeeFrequency1Code2.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

