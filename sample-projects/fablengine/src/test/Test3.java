package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.obj.fb.FbState;

public class Test3 {

    public static void main(String[] args) {
        HashMap< FbState, String> state_formula = new HashMap();
        List<String> formulaApplied = new ArrayList();
        //when state apply to actor
        FbState state = new FbState();
        {//effect on affect
            String formula = state.getEffectFormula();
            state_formula.put(state, formula);
            formulaApplied.add(formula);
            formulaApplied.add(formula);
        }
        {//effect each turn
            formulaApplied.add(state.getEffectFormula());
        }
        //
        System.out.println(formulaApplied.size());
        formulaApplied.remove(state_formula.get(state));
        formulaApplied.remove(state_formula.get(state));
        formulaApplied.remove(state_formula.get(state));
        System.out.println(formulaApplied.size());
        //
    }
}