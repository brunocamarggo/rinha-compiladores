package rinha.interpretador.strategy;

import rinha.interpretador.core.Parameter;
import rinha.interpretador.core.terms.Function;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Closure;
import rinha.interpretador.core.values.Val;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionStrategy implements EvalStrategy {
    @Override
    public boolean apply(Term term) {
        return term instanceof Function;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Function function) {
            List<Parameter> parameters = function.getParameters();
            Term body = function.getValue();
            return new Closure(body, parameters, new HashMap<>(scope));
        }
        return null;
    }
}
