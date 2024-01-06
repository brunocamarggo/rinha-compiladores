package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Val;

import java.util.Map;
import java.util.Set;

public interface EvalStrategy {

    Set<EvalStrategy> STRATEGIES = Set.of(
            new StrStrategy(),
            new BinaryStrategy(),
            new IntStrategy(),
            new PrintStrategy(),
            new BoolStrategy(),
            new IfStrategy(),
            new LetStrategy(),
            new CallStrategy(),
            new FunctionStrategy(),
            new VarStrategy()

    );

    default Val getVal(Map<String, Val> scope, Term term){
        return STRATEGIES.stream()
                .filter(evalStrategy -> evalStrategy.apply(term))
                .findFirst()
                .map(evalStrategy -> evalStrategy.eval(term, scope))
                .orElseThrow();
    }
    boolean apply(Term term);

    Val eval(Term term, Map<String, Val> scope);
}
