package cat.wars.foodie.framework.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.util.List;

/**
 * @program: foodie
 * @description: Json utils, based on jackson and spring-web exception
 * @author: Wars
 * @created: 2020/01/08 00:29
 */
public class JSONUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T jsonToObject(String json, Class<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new HttpMessageNotReadableException("JSON parse error: ", e, null);
        }
    }

    public static <T> List<T> jsonToList(String json, Class<T> type) {
        JavaType javaType = MAPPER.getTypeFactory().constructArrayType(type);
        try {
            return MAPPER.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new HttpMessageNotReadableException("JSON parse error: ", e, null);
        }
    }

    public static String objectToJson(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new HttpMessageNotWritableException("Could not transform [" + o + "] to output message", e);
        }
    }
}
