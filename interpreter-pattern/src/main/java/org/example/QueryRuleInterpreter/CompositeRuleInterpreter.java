package org.example.QueryRuleInterpreter;

import org.example.Context.Context;

import java.util.*;

public class CompositeRuleInterpreter implements QueryInterpreter {
    private List<QueryInterpreter> childRules;
    private String conjunctionOperator;

    public CompositeRuleInterpreter(List<QueryInterpreter> childRules, String conjunctionOperator){
        this.childRules = childRules;
        this.conjunctionOperator = conjunctionOperator;
    }

    @Override
    public String interpret(Context context) {
        String queryClause = "";
        for(int i=0;i<childRules.size();i++){
            String childClause = childRules.get(i).interpret(context);
            queryClause += "(" + childClause + ")";

            if(i+1<childRules.size()){
                queryClause += " " + context.getClause(conjunctionOperator) + " ";
            }
        }

        return queryClause;
    }
}
