package rinha.interpretador.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import rinha.interpretador.core.Location;
import rinha.interpretador.core.Parameter;
import rinha.interpretador.core.terms.*;
import rinha.interpretador.core.values.BoolVal;
import rinha.interpretador.core.values.IntVal;
import rinha.interpretador.core.values.StrVal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TermDeserializer extends StdDeserializer<Term> {

    public TermDeserializer() {
        this(null);
    }

    public TermDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Term deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        return getTerm(node);
    }

    private Term getTerm(JsonNode node) {
        var kind = node.get("kind").asText();
        return switch (kind) {
            case "Print" -> new Print(kind, getTerm(node.get("value")), getLocation(node));
            case "Str" -> new Str(kind, new StrVal(node.get("value").asText()), getLocation(node));
            case "Int" -> new Int(kind, new IntVal(node.get("value").asInt()), getLocation(node));
            case "Bool" -> new Bool(kind, new BoolVal(node.get("value").booleanValue()), getLocation(node));
            case "Binary" -> new Binary(kind,
                                        getTerm(node.get("lhs")),
                                        BinaryOp.valueOf(node.get("op").asText()),
                                        getTerm(node.get("rhs")),
                            getLocation(node));
            case "If" -> new If(kind, getTerm(node.get("condition")),
                                        getTerm(node.get("then")),
                                        getTerm(node.get("otherwise")),
                                        getLocation(node));
            case "Let" -> new Let(kind,
                    getParameter(node),
                    getTerm(node.get("value")),
                    getTerm(node.get("next")),
                    getLocation(node));
            case "Var" -> new Var(kind, new StrVal(node.get("text").asText()), getLocation(node));
            case "Function" -> new Function(kind,
                    getParameters(node),
                    getTerm(node.get("value")),
                    getLocation(node));
            case "Call" -> new Call(kind,
                    getTerm(node.get("callee")),
                    getTerms(node),
                    getLocation(node));
            default -> throw new RuntimeException("ERRO NO PARSE DO JSON!");
        };
    }

    private Location getLocation(JsonNode node) {
        JsonNode location = node.get("location");
        int start = location.get("start").asInt();
        int end = location.get("end").asInt();
        String filename = location.get("filename").asText();
        return new Location(start, end, filename);
    }

    private Parameter getParameter(JsonNode node) {

        JsonNode parameter = node.get("name");
        if(parameter != null) {
            JsonNode location = parameter.get("location");
            int start = location.get("start").asInt();
            int end = location.get("end").asInt();
            String filename = location.get("filename").asText();
            Location location1 = new Location(start, end, filename);
            String text = parameter.get("text").asText();
            return new Parameter(text, location1);
        }
        return null;
    }

    private Parameter getFnParameter(JsonNode node) {
        JsonNode location = node.get("location");
        int start = location.get("start").asInt();
        int end = location.get("end").asInt();
        String filename = location.get("filename").asText();
        Location location1 = new Location(start, end, filename);
        String text = node.get("text").asText();
        return new Parameter(text, location1);
    }

    private List<Parameter> getParameters(JsonNode node) {
        var arrayNode = (ArrayNode) node.get("parameters");
        var parameters = new ArrayList<Parameter>();
        for(int i = 0; i < arrayNode.size(); i++) {
            parameters.add(getFnParameter(arrayNode.get(i)));
        }
        return parameters;
    }

    private List<Term> getTerms(JsonNode node) {
        var arrayNode = (ArrayNode) node.get("arguments");
        var terms = new ArrayList<Term>();
        for(int i = 0; i < arrayNode.size(); i++) {
            terms.add(getTerm(arrayNode.get(i)));
        }
        return terms;
    }
 }
