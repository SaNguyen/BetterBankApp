package generated.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Fee/Charge Type
 */
public enum OBFeeType1Code {
  
  FEPF("FEPF"),
  
  FTOT("FTOT"),
  
  FYAF("FYAF"),
  
  FYAM("FYAM"),
  
  FYAQ("FYAQ"),
  
  FYCP("FYCP"),
  
  FYDB("FYDB"),
  
  FYMI("FYMI"),
  
  FYXX("FYXX");

  private String value;

  OBFeeType1Code(String value) {
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
  public static OBFeeType1Code fromValue(String value) {
    for (OBFeeType1Code b : OBFeeType1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

