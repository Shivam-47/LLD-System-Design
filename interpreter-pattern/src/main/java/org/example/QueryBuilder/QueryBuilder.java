package org.example.QueryBuilder;

import org.example.Context.Context;
import org.example.QueryRuleInterpreter.QueryInterpreter;

import java.util.*;

public class QueryBuilder {
    private String tableName;
    private List<String> columns;
    private QueryInterpreter queryInterpreter;

    public QueryBuilder(String tableName, QueryInterpreter queryInterpreter, List<String> columns) {
        this.tableName = tableName;
        this.queryInterpreter = queryInterpreter;
        this.columns = columns;
    }

    public String buildQuery(Context context) {
        String query = "SELECT ";
        String commaSeparatedColumns = String.join(",", columns);
        query += commaSeparatedColumns;

        query += " FROM " + tableName;

        if(this.queryInterpreter != null){
            query += " WHERE ";
            query += queryInterpreter.interpret(context);
        }

        return query;
    }
}
