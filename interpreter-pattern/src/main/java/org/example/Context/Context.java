package org.example.Context;

import java.util.*;

public class Context {
    private Map<String, String> queryContext = new HashMap<>();
    private static volatile Context singletonInstance;

    public static Context createContext() {
        if(singletonInstance == null) {
            synchronized (Context.class) {
                if(singletonInstance == null) {
                    singletonInstance = new Context();
                }
            }
        }

        return singletonInstance;
    }

    public void addClause(String clause, String statement){
        queryContext.put(clause, statement);
    }

    public String getClause(String clause){
        return queryContext.get(clause);
    }
}
