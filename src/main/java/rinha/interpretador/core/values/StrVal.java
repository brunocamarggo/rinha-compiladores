package rinha.interpretador.core.values;

public record StrVal(String value) implements Val {

    @Override
    public String toString() {
        return value;
    }
}
