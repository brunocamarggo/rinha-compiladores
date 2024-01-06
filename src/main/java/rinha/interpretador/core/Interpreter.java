package rinha.interpretador.core;

import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.Val;
import rinha.interpretador.strategy.*;

import java.util.HashMap;
import java.util.List;

public class Interpreter {

    private static final HashMap<String, Val> SCOPE = new HashMap<>();

    private static final List<EvalStrategy> STRATEGIES = List.of(
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

    private Interpreter() {
    }

    public static Object eval(ABS abs) {
        return eval(abs.expression(), SCOPE);
    }

    private static Val eval(Term term, HashMap<String, Val> scope) {
        return STRATEGIES.stream()
                .filter(evalStrategy -> evalStrategy.apply(term))
                .findFirst()
                .map(evalStrategy -> evalStrategy.eval(term, scope))
                .orElseThrow();
    }


}
