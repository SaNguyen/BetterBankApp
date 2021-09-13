package generated.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Specifies the status of the standing order in code form.
 */
public enum OBExternalStandingOrderStatus1Code {
  
  ACTIVE("Active"),
  
  INACTIVE("Inactive");

  private String value;

  OBExternalStandingOrderStatus1Code(String value) {
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
  public static OBExternalStandingOrderStatus1Code fromValue(String value) {
    for (OBExternalStandingOrderStatus1Code b : OBExternalStandingOrderStatus1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

