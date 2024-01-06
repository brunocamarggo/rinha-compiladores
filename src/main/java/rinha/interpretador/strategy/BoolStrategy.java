package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Bool;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Val;

import java.util.Map;

public class BoolStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof Bool;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Bool bool) {
            return bool.isValue();
        }
        return null;
    }
}
