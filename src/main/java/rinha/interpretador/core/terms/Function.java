package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;
import rinha.interpretador.core.Parameter;

import java.util.List;

public class Function extends Term {

    List<Parameter> parameters;
    private Term value;

    public Function(String kind, List<Parameter> parameters, Term value, Location location) {
        super(kind, location);
        this.parameters = parameters;
        this.value = value;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Term getValue() {
        return value;
    }

    public void setValue(Term value) {
        this.value = value;
    }
}
