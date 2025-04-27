package org.example.Coin;

public class Coin {

    public enum CoinType {
        ONE, TWO, FIVE, TEN, FIFTY;

        public static Integer getValue(CoinType coinType) {
            switch (coinType) {
                case ONE:
                    return 1;
                case TWO:
                    return 2;
                case FIVE:
                    return 5;
                case TEN:
                    return 10;
                case FIFTY:
                    return 50;
                default:
                    return -1;
            }
        }
    }

    private CoinType coinType;

    public Integer getValue() {
        return value;
    }

    private Integer value;

    public Coin(CoinType coinType) {
        this.coinType = coinType;
        this.value = CoinType.getValue(coinType);
    }
}
