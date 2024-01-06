package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;
import rinha.interpretador.core.Parameter;

public class Let extends Term {

    private Parameter name;
    private Term value;
    private Term next;

    public Let(String kind, Parameter name, Term value, Term next, Location location) {
        super(kind, location);
        this.name = name;
        this.value = value;
        this.next = next;
    }

    public Parameter getName() {
        return name;
    }

    public void setName(Parameter name) {
        this.name = name;
    }

    public Term getValue() {
        return value;
    }

    public void setValue(Term value) {
        this.value = value;
    }

    public Term getNext() {
        return next;
    }

    public void setNext(Term next) {
        this.next = next;
    }
}
