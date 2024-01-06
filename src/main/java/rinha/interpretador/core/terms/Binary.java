package rinha.interpretador.core.terms;

import rinha.interpretador.core.Location;

public class Binary extends Term {
    private Term lhs;
    private BinaryOp op;
    private Term rhs;

    public Binary(String kind, Term lhs, BinaryOp op, Term rhs, Location location) {
        super(kind, location);
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }

    public Term getLhs() {
        return lhs;
    }

    public void setLhs(Term lhs) {
        this.lhs = lhs;
    }

    public BinaryOp getOp() {
        return op;
    }

    public void setOp(BinaryOp op) {
        this.op = op;
    }

    public Term getRhs() {
        return rhs;
    }

    public void setRhs(Term rhs) {
        this.rhs = rhs;
    }
}
