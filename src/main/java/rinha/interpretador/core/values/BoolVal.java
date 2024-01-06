package rinha.interpretador.core.values;

public record BoolVal(boolean value) implements Val {

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
