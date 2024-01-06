package rinha.interpretador.core.values;

public record IntVal(int value) implements Val {
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
