package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Int;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Val;

import java.util.Map;

public class IntStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof Int;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Int intt) {
            return intt.getValue();
        }
        return null;
    }
}
