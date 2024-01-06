package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;

public class If extends Term {

    private Term condition;
    private Term then;
    private  Term otherwise;

    public If(String kind, Term condition, Term then, Term otherwise, Location location) {
        super(kind, location);
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
    }

    public Term getCondition() {
        return condition;
    }

    public void setCondition(Term condition) {
        this.condition = condition;
    }

    public Term getThen() {
        return then;
    }

    public void setThen(Term then) {
        this.then = then;
    }

    public Term getOtherwise() {
        return otherwise;
    }

    public void setOtherwise(Term otherwise) {
        this.otherwise = otherwise;
    }
}
