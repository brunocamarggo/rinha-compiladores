package rinha.interpretador.strategy;

import rinha.interpretador.core.Parameter;
import rinha.interpretador.core.terms.Let;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Val;

import java.util.Map;

public class LetStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof Let;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Let let) {
            Parameter parameter = let.getName();
            String text = parameter.text();
            var value = getVal(scope, let.getValue());
            scope.put(text, value);
            return getVal(scope, let.getNext());
        }
        return null;
    }
}
