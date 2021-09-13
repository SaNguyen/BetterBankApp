package generated.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Balance type, in a coded form.
 */
public enum OBBalanceType1Code {
  
  CLOSINGAVAILABLE("ClosingAvailable"),
  
  CLOSINGBOOKED("ClosingBooked"),
  
  CLOSINGCLEARED("ClosingCleared"),
  
  EXPECTED("Expected"),
  
  FORWARDAVAILABLE("ForwardAvailable"),
  
  INFORMATION("Information"),
  
  INTERIMAVAILABLE("InterimAvailable"),
  
  INTERIMBOOKED("InterimBooked"),
  
  INTERIMCLEARED("InterimCleared"),
  
  OPENINGAVAILABLE("OpeningAvailable"),
  
  OPENINGBOOKED("OpeningBooked"),
  
  OPENINGCLEARED("OpeningCleared"),
  
  PREVIOUSLYCLOSEDBOOKED("PreviouslyClosedBooked");

  private String value;

  OBBalanceType1Code(String value) {
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
  public static OBBalanceType1Code fromValue(String value) {
    for (OBBalanceType1Code b : OBBalanceType1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

