package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;

import java.util.List;

public class Call extends Term {

    private Term callee;
    private List<Term> arguments;

    public Call(String kind,  Term callee, List<Term> arguments, Location location) {
        super(kind, location);
        this.callee = callee;
        this.arguments = arguments;
    }

    public Term getCallee() {
        return callee;
    }

    public void setCallee(Term callee) {
        this.callee = callee;
    }

    public List<Term> getArguments() {
        return arguments;
    }

    public void setArguments(List<Term> arguments) {
        this.arguments = arguments;
    }
}
