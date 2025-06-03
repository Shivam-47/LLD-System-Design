package org.example.SplitStrategy;

public class SplitStrategyFactory {

    public SplitStrategy getStrategyFromSplitType(String splitType){
        switch (splitType){
            case "equal":
                return new EqualSplit();
            case "weighted":
                return new WeightedSplit();
            default:
                return new EqualSplit();
        }
    }

}
