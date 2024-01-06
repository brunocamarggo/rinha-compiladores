package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;

public class Print extends Term {

    private Term value;

    public Print(String kind, Term value, Location location) {
        super(kind, location);
        this.value = value;
    }

    public Term getValue() {
        return value;
    }

    public void setValue(Term value) {
        this.value = value;
    }
}
