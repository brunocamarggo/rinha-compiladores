package rinha.interpretador.strategy;

import rinha.interpretador.core.terms.Binary;
import rinha.interpretador.core.terms.BinaryOp;
import rinha.interpretador.core.terms.Term;
import rinha.interpretador.core.values.BoolVal;
import rinha.interpretador.core.values.IntVal;
import rinha.interpretador.core.values.StrVal;
import rinha.interpretador.core.values.Val;

import java.util.Map;


public class BinaryStrategy implements EvalStrategy {

    @Override
    public boolean apply(Term term) {
        return term instanceof Binary;
    }

    @Override
    public Val eval(Term term, Map<String, Val> scope) {
        if(term instanceof Binary binary) {

            var lhs = getVal(scope, binary.getLhs());
            var rhs = getVal(scope, binary.getRhs());

            if(isIntegers(lhs, rhs) && BinaryOp.Eq == binary.getOp()) {
                IntVal lhs2 = (IntVal) lhs;
                IntVal rhs2 = (IntVal) rhs;
                return new BoolVal(lhs2.value() == rhs2.value());
            }
            if(isIntegers(lhs, rhs) && BinaryOp.Add == binary.getOp())  {
                IntVal lhs2 = (IntVal) lhs;
                IntVal rhs2 = (IntVal) rhs;
                return new IntVal(lhs2.value() + rhs2.value());
            }
            if(isIntegers(lhs, rhs) && BinaryOp.Lt == binary.getOp())  {
                IntVal lhs2 = (IntVal) lhs;
                IntVal rhs2 = (IntVal) rhs;
                return new BoolVal(lhs2.value() < rhs2.value());
            }
            if(isIntegers(lhs, rhs) && BinaryOp.Sub == binary.getOp()) {
                IntVal lhs2 = (IntVal) lhs;
                IntVal rhs2 = (IntVal) rhs;
                return new IntVal(lhs2.value() - rhs2.value());
            } else if (isStrings(lhs, rhs) && BinaryOp.Add == binary.getOp()) {
                StrVal lhs2 = (StrVal) lhs;
                StrVal rhs2 = (StrVal) rhs;
                return new StrVal(lhs2.value() + rhs2.value());
            } else if (lhs instanceof StrVal && rhs instanceof IntVal && BinaryOp.Add == binary.getOp()) {
                StrVal lhs2 = (StrVal) lhs;
                IntVal rhs2 = (IntVal) rhs;
                return new StrVal(lhs2.value() + rhs2.value());
            } else if (lhs instanceof IntVal && rhs instanceof StrVal && BinaryOp.Add == binary.getOp()) {
                IntVal lhs2 = (IntVal) lhs;
                StrVal rhs2 = (StrVal) rhs;
                return new StrVal(lhs2.value() + rhs2.value());
            }
            throw new RuntimeException("parametros invalidos na op ad" + term);
        }
        throw new RuntimeException("Error");
    }

    private static boolean isStrings(Object lhs, Object rhs) {
        return lhs instanceof String && rhs instanceof String;
    }

    private static boolean isIntegers(Object lhs, Object rhs) {
        return lhs instanceof IntVal && rhs instanceof IntVal;
    }
}
