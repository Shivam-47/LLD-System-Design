package org.example.SplitStrategy;

import org.example.Split.SplitRequest;
import org.example.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements SplitStrategy {
    @Override
    public boolean validateAmount(Double amount, List<SplitRequest> splitRequestList) {
        /*
        Double splitAmount=0.0;
        for(int i=0;i<splitRequestList.size();i++){
           SplitRequest request = splitRequestList.get(i);
           splitAmount += request.getAmount();
           if(splitAmount.doubleValue() > amount.doubleValue()){
               System.out.println("EqualSplit:: split amount " + splitAmount + "cannot be more than "+amount);
               return false;
           }
        }
        */

        return true;
    }

    @Override
    public Map<User, Double> splitAmount(Double amount, List<SplitRequest> splitRequestList) {
        Map<User,Double> response = new HashMap<User, Double>();

        int numberOfUsers = splitRequestList.size();
        Double amountPerUser = amount.doubleValue()/numberOfUsers;

        for(int i=0;i<splitRequestList.size();i++){
            SplitRequest request = splitRequestList.get(i);
            User user = request.getUser();
            response.put(user, amountPerUser);
        }

        return response;
    }
}
