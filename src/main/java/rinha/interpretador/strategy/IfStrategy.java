package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.If;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.BoolVal;
import rinha.interpretador.core.values.Val;

import java.util.Map;

public class IfStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof If;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof If iff) {
            var condition = getVal(scope, iff.getCondition());
            if(condition instanceof BoolVal c) {
                if(c.value()) {
                    return  getVal(scope, iff.getThen());
                } else {
                    return getVal(scope, iff.getOtherwise());
                }
            }
        }
        return null;
    }
}
