package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;
import rinha.interpretador.core.values.StrVal;

public class Var extends Term {

    private StrVal text;

    public Var(String kind, StrVal text, Location location) {
        super(kind, location);
        this.text = text;
    }

    public StrVal getText() {
        return text;
    }

    public void setText(StrVal text) {
        this.text = text;
    }
}
