package generated.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Specifies the Mutability of the Transaction record.
 */
public enum OBTransactionMutability1Code {
  
  MUTABLE("Mutable"),
  
  IMMUTABLE("Immutable");

  private String value;

  OBTransactionMutability1Code(String value) {
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
  public static OBTransactionMutability1Code fromValue(String value) {
    for (OBTransactionMutability1Code b : OBTransactionMutability1Code.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

