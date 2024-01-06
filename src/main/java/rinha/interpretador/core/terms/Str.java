package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;
import rinha.interpretador.core.values.StrVal;

public class Str extends Term {

    private StrVal value;

    public Str(String kind, StrVal value, Location location) {
        super(kind, location);
        this.value = value;
    }

    public StrVal getValue() {
        return value;
    }

    public void setValue(StrVal value) {
        this.value = value;
    }
}
