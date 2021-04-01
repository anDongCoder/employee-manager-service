package cn.employee.manager.utils;






import cn.employee.manager.config.DatePatternConst;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {


    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Objects.nonNull(p) && StringUtils.isNotEmpty(p.getText()) ?
                LocalDateTime.parse(p.getText(), DatePatternConst.DATE_TIME_FORMATTER) : null;
    }
}
