package com.midlife.exams.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.Map;
import java.util.logging.Logger;

public class HashMapConverter implements AttributeConverter<Map<String,Object>,String> {
    Logger logger=Logger.getLogger(HashMapConverter.class.getName());

    ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return objectMapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            logger.warning("Cant convert Map To String" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s,Map.class);
        } catch (JsonProcessingException e) {
            logger.warning("Cant convert String to Map" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
