package org.example.SplitStrategy;

import java.util.List;
import java.util.Map;

import org.example.User.User;
import org.example.Split.SplitRequest;

public interface SplitStrategy {
    boolean validateAmount(Double amount, List<SplitRequest> splitRequestList);
    Map<User, Double> splitAmount(Double amount, List<SplitRequest> splitRequestList);
}
