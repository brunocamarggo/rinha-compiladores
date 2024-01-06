package rinha.interpretador.strategy;

import rinha.interpretador.core.Parameter;
import rinha.interpretador.core.terms.Call;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Closure;
import rinha.interpretador.core.values.Val;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof Call;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Call call) {
            var callee = getVal(scope, call.getCallee());
            if(callee instanceof Closure closure) {
                HashMap<String, Val> newScope = new HashMap<>(scope);
                List<Parameter> parameters = closure.parameters();
                List<Term> arguments = call.getArguments();
                for(int i = 0; i < parameters.size(); i++) {
                    newScope.put(parameters.get(i).text(), getVal(scope, arguments.get(i)));
                }
                return getVal(newScope, closure.body());
            }
            throw new RuntimeException("Calle nao eh uma function!!!");
        }
        return null;
    }
}
