package com.example.converter;

import com.example.model.Customer;
import com.example.model.Executor;
import com.example.model.Order;
import com.example.model.WorkType;
import com.example.repository.CustomerRepository;
import com.example.repository.ExecutorRepository;
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
public class JsonOrderDeserializer extends JsonDeserializer<Order> {

    CustomerRepository customerRepository;
    ExecutorRepository executorRepository;
    WorkTypeRepository workTypeRepository;

    @Override
    public Order deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Customer customer = customerRepository.findById(node.get("customer").asLong()).get();
        Executor executor = executorRepository.findById(node.get("executor").asLong()).get();
        WorkType workType = workTypeRepository.findById(node.get("workType").asLong()).get();

        return new Order(null, customer, executor, workType);
    }
}
