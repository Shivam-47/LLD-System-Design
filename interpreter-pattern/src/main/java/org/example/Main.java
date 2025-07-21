package org.example;

import org.example.Context.Context;
import org.example.QueryBuilder.QueryBuilder;
import org.example.QueryRuleInterpreter.BaseRuleInterpreter;
import org.example.QueryRuleInterpreter.CompositeRuleInterpreter;
import org.example.QueryRuleInterpreter.QueryInterpreter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Interpreter pattern!");

        Context context = Context.createContext();
        context.addClause("&&", "AND");
        context.addClause("||", "OR");

        List<QueryInterpreter> andQueryInterpreters = new ArrayList<>();

        andQueryInterpreters.add(new BaseRuleInterpreter("seller_id = 11"));
        andQueryInterpreters.add(new BaseRuleInterpreter("seller_status = 'active'"));
        andQueryInterpreters.add(new BaseRuleInterpreter("buyer_id != 11"));
        andQueryInterpreters.add(new BaseRuleInterpreter("buyer_status = 'active'"));
        QueryInterpreter compositeAndClause = new CompositeRuleInterpreter(andQueryInterpreters, "&&");

        List<QueryInterpreter> orQueryInterpreters = new ArrayList<>();
        orQueryInterpreters.add(new BaseRuleInterpreter("product_id = 112"));
        orQueryInterpreters.add(new BaseRuleInterpreter("brand_id = 7"));
        QueryInterpreter compositeOrClause = new CompositeRuleInterpreter(orQueryInterpreters, "||");


        List<QueryInterpreter> finalQueryInterpreters = new ArrayList<>();
        finalQueryInterpreters.add(compositeAndClause);
        finalQueryInterpreters.add(compositeOrClause);

        QueryInterpreter finalInterpreter = new CompositeRuleInterpreter(finalQueryInterpreters, "&&");

        QueryBuilder qb = new QueryBuilder(
                "seller_products",
                finalInterpreter,
                List.of("product_id", "brand_id", "seller_id", "seller_status", "buyer_id", "buyer_status")
        );

        String query = qb.buildQuery(context);
        System.out.println("Generated SQL Query: " + query);
    }
}