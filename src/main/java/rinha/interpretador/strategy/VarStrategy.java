package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.terms.Var;
import rinha.interpretador.core.values.Val;

import java.util.Map;

public class VarStrategy implements EvalStrategy {
    @Override
    public boolean apply(Term term) {
        return term instanceof Var;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Var varr) {
            var text = varr.getText().value();
            return scope.get(text);
        }
        return null;
    }
}
