package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Indicates whether the amount is a credit or a debit.  Usage: A zero amount is considered to be a credit amount.
 */
public enum OBCreditDebitCode0 {
  
  CREDIT("Credit"),
  
  DEBIT("Debit");

  private String value;

  OBCreditDebitCode0(String value) {
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
  public static OBCreditDebitCode0 fromValue(String value) {
    for (OBCreditDebitCode0 b : OBCreditDebitCode0.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

