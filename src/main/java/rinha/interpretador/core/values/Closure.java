package rinha.interpretador.core.values;

import rinha.interpretador.core.Parameter;
import rinha.interpretador.core.terms.Term;

import java.util.HashMap;
import java.util.List;

public record Closure(
        Term body,
        List<Parameter> parameters,
        HashMap<String, Object> env
) implements Val { }
