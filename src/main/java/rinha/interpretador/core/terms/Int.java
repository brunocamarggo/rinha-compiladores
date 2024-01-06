package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;
import rinha.interpretador.core.values.IntVal;

public class Int extends Term {

    private IntVal value;

    public Int(String kind, IntVal value, Location location) {
        super(kind, location);
        this.value = value;
    }

    public IntVal getValue() {
        return value;
    }

    public void setValue(IntVal value) {
        this.value = value;
    }
}
