package com.example.converter;

import com.example.model.Executor;
import com.example.model.WorkType;
import com.example.repository.WorkTypeRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@AllArgsConstructor
public class JsonExecutorDeserializer extends JsonDeserializer<Executor> {

    WorkTypeRepository repository;

    @Override
    public Executor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        WorkType workType = repository.findById(node.get("type").asLong()).get();
        String name = node.get("name").asText();
        String lastName = node.get("lastName").asText();

        return new Executor(null, name, lastName, workType);

    }
}
