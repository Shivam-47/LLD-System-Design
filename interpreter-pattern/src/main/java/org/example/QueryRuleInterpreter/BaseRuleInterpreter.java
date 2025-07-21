package org.example.QueryRuleInterpreter;

import org.example.Context.Context;

public class BaseRuleInterpreter implements QueryInterpreter {
    private String queryRule;

    public BaseRuleInterpreter(String queryRule) {
        this.queryRule = queryRule;
    }

    @Override
    public String interpret(Context context) {
        return queryRule;
    }
}
