package rinha.interpretador.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import rinha.interpretador.deserializer.TermDeserializer;
import rinha.interpretador.core.terms.Term;

public record ABS(
        String name,
        @JsonDeserialize(using = TermDeserializer.class)
        Term expression,
        Location location
) {

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
