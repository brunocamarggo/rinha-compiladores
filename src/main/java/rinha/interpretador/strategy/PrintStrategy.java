package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Print;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.StrVal;
import rinha.interpretador.core.values.Val;

import java.util.List;
import java.util.Map;

public class PrintStrategy implements EvalStrategy {

    private static List<EvalStrategy> strategies = List.of(
            new StrStrategy(),
            new BinaryStrategy(),
            new IntStrategy(),
            new PrintStrategy(),
            new BoolStrategy());

    @Override
    public boolean apply(Term term) {
        return term instanceof Print;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Print print) {
            var val = getVal(scope, print.getValue());
            System.out.print(val);
            return new StrVal("\n");
        }
        return null;
    }
}
