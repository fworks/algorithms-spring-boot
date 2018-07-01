package fworks.algorithms.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.persistence.AttributeConverter;
import lombok.extern.log4j.Log4j2;

/**
 * Simple Json converter to String to save an object as json in the db.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public class JsonConverter implements AttributeConverter<Object, String> {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      log.error("Error trying to convert data to json.", e);
      return null;
      // or throw an error
    }
  }

  @Override
  public Object convertToEntityAttribute(String json) {
    try {
      return objectMapper.readValue(json, Object.class);
    } catch (IOException ex) {
      log.error("Error trying to convert json to data.", ex);
      return null;
    }
  }

}
