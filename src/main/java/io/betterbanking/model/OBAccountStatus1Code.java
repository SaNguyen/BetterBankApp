package generated.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Specifies the status of account resource in code form.
 */
public enum OBAccountStatus1Code {
  
  DELETED("Deleted"),
  
  DISABLED("Disabled"),
  
  ENABLED("Enabled"),
  
  PENDING("Pending"),
  
  PROFORMA("ProForma");

  private String value;

  OBAccountStatus1Code(String value) {
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
  public static OBAccountStatus1Code fromValue(String value) {
    for (OBAccountStatus1Code b : OBAccountStatus1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

