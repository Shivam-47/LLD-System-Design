package org.example.SplitStrategy;

import org.example.Split.SplitRequest;
import org.example.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedSplit implements SplitStrategy{

    @Override
    public boolean validateAmount(Double amount, List<SplitRequest> splitRequestList) {
        double totalWeight = 0.0;
        for(SplitRequest splitRequest: splitRequestList){
            totalWeight += splitRequest.getPercentage();
        }

        return (totalWeight == 100.0);
    }

    @Override
    public Map<User, Double> splitAmount(Double amount, List<SplitRequest> splitRequestList) {
        Map<User, Double> response = new HashMap<>();
        for(int i=0;i<splitRequestList.size();i++){
            SplitRequest splitRequest = splitRequestList.get(i);
            User user = splitRequest.getUser();
            double weight = splitRequest.getPercentage();
            double ratio = weight/100;
            Double weightedAmount = amount*ratio;
            response.put(user, weightedAmount);
        }

        return response;
    }
}
