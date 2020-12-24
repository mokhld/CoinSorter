
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoinSorter {

    private String currency;
    private int minCoinIn;
    private int maxCoinIn;
    private int totalCoinValue;
    private int excludedCoin;
    private List<Integer> coinList;

    public CoinSorter(String currency, int minCoinIn, int maxCoinIn, List<Integer> coinList) {
        this.currency = currency;
        this.minCoinIn = minCoinIn;
        this.maxCoinIn = maxCoinIn;
        this.coinList = coinList;
    }

    public CoinSorter() {
        coinList = new ArrayList();
        coinList.add(200);
        coinList.add(100);
        coinList.add(50);
        coinList.add(20);
        coinList.add(10);
        minCoinIn = 0;
        maxCoinIn = 1000;
        currency = "Penny";
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getMinCoinIn() {
        return minCoinIn;
    }

    public void setMinCoinIn(int minCoinIn) {
        if (minCoinIn >= 0 && minCoinIn <= 10000) {
            this.minCoinIn = minCoinIn;
        }
    }

    public int getMaxCoinIn() {
        return maxCoinIn;
    }

    public void setMaxCoinIn(int maxCoinIn) {
        if (maxCoinIn >= 0 && maxCoinIn <= 10000) {
            this.maxCoinIn = maxCoinIn;
        }
    }

    public String printCoinList() {
        String coinListString = "The current coin denominations are in circulation: ";
        for (int coin : coinList) {
            if (coin == 10) {
                coinListString += String.valueOf(coin) + ".\n";
            } else {
                coinListString += String.valueOf(coin) + ", ";
            }
        }
        return coinListString;
    }

    public String displayProgramConfigs() {
        return "The current currency is: " + this.currency + " with the Maximum value of " + String.valueOf(this.maxCoinIn) + "p and the minimum value of " + String.valueOf(this.minCoinIn) + "p";
    }

    public void validateExcludedCoin() {
        excludedCoin = -1;
        while (coinList.indexOf(excludedCoin) == -1) {
            System.out.print("Please Enter a Correct Number to Exclude: ");;
            Scanner sc = new Scanner(System.in);
            excludedCoin = sc.nextInt();
        }
    }

    public String coinCalculator(int exchange, int coinType) {
        return "A total of " + String.valueOf(exchange / coinType) + " x " + coinType + "p coins can be exchanged, with a remainder of " + String.valueOf(exchange % coinType) + "p ";
    }

    public String multiCoinCalculator(int exchange, int excluded) {
        excluded = excludedCoin;
        int coinCounts[] = new int[5];
        Arrays.fill(coinCounts, 0);
        int remainder = 0;
        while (exchange > 10) {
            if (coinList.get(0) != excluded && exchange >= coinList.get(0)) {
                exchange = exchange - coinList.get(0);
                coinCounts[0]++;
            } else if (coinList.get(1) != excluded && exchange >= coinList.get(1)) {
                exchange = exchange - coinList.get(1);
                coinCounts[1]++;
            } else if (coinList.get(2) != excluded && exchange >= coinList.get(2)) {
                exchange = exchange - coinList.get(2);
                coinCounts[2]++;
            } else if (coinList.get(3) != excluded && exchange > coinList.get(3)) {
                exchange = exchange - coinList.get(3);
                coinCounts[3]++;
            } else if (coinList.get(4) != excluded && exchange > coinList.get(4)) {
                exchange = exchange - coinList.get(4);
                coinCounts[4]++;
            }
        }
        return "The coins exchanged are: " + String.valueOf(coinCounts[0]) + " x 200p, " + String.valueOf(coinCounts[1]) + " x 100p, " + String.valueOf(coinCounts[2]) + " x 50p, " + String.valueOf(coinCounts[3]) + " x 20p, " + String.valueOf(coinCounts[4]) + " x 10p, with a remainder of " + String.valueOf(exchange) + "p.";
    }
}
