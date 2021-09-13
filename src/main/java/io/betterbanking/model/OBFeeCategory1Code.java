package generated.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Categorisation of fees and charges into standard categories.
 */
public enum OBFeeCategory1Code {
  
  FCOT("FCOT"),
  
  FCRE("FCRE"),
  
  FCSV("FCSV");

  private String value;

  OBFeeCategory1Code(String value) {
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
  public static OBFeeCategory1Code fromValue(String value) {
    for (OBFeeCategory1Code b : OBFeeCategory1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

