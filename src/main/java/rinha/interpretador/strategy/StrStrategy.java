package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Str;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Val;

import java.util.Map;

public class StrStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof Str;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Str str) {
            return str.getValue();
        }
        throw new RuntimeException("Error");
    }
}
