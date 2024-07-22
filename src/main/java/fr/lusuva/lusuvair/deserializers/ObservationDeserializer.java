package fr.lusuva.lusuvair.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.lusuva.lusuvair.dtos.apiweatherdto.ObservationDto;

public class ObservationDeserializer extends JsonDeserializer<Object> {
    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        
        if (node.isArray()) {
            return mapper.readValue(node.traverse(p.getCodec()), ObservationDto[].class);
        } else {
            return mapper.readValue(node.traverse(p.getCodec()), ObservationDto.class);
        }
    }
}