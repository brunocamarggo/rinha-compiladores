package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;
import rinha.interpretador.core.values.BoolVal;

public class Bool extends Term {

    private BoolVal value;

    public Bool(String kind, BoolVal value, Location location) {
        super(kind, location);
        this.value = value;
    }

    public BoolVal isValue() {
        return value;
    }

    public void setValue(BoolVal value) {
        this.value = value;
    }
}
