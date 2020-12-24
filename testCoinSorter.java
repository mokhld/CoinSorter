
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testCoinSorter {

    public static void main(String args[]) {
        List<Integer> coins = new ArrayList();
        coins.add(200);
        coins.add(100);
        coins.add(50);
        coins.add(20);
        coins.add(10);
        CoinSorter cSorter = new CoinSorter("Pennies", 0, 10000, coins);
        int mainMenuSelection = -1;
        int e;
        int c = 0;
        Scanner sc = new Scanner(System.in);
        OUTER:
        while (true) {
            while (mainMenuSelection < 1 || mainMenuSelection > 6) {
                System.out.println("\n\n***Coin Sorter - Main Menu***\n"
                        + "1 - Coin calculator\n"
                        + "2 - Multiple coin calculator\n"
                        + "3 - Print coin list\n"
                        + "4 - Set details\n"
                        + "5 - Display program configurations\n"
                        + "6 - Quit the program\n");
                System.out.print("Choose a valid option: ");
                mainMenuSelection = sc.nextInt();
            }
            switch (mainMenuSelection) {
                case 1:
                    System.out.print("Please enter Exchange Amount: ");
                    e = sc.nextInt();
                    while (e < cSorter.getMinCoinIn() && e > cSorter.getMaxCoinIn()) {
                        System.out.print("Please enter valid Exchange Amount: ");
                        e = sc.nextInt();
                    }
                    System.out.print("Please enter Coin Type: ");
                    c = sc.nextInt();
                    System.out.println(cSorter.coinCalculator(e, c));
                    break;
                case 2:
                    System.out.print("Please enter Exchange Amount: ");
                    e = sc.nextInt();
                    while (e < cSorter.getMinCoinIn() && e > cSorter.getMaxCoinIn()) {
                        System.out.print("Please enter valid Exchange Amount: ");
                        e = sc.nextInt();
                    }
                    cSorter.validateExcludedCoin();
                    System.out.println(cSorter.multiCoinCalculator(e, c));
                    break;
                case 3:
                    System.out.println(cSorter.printCoinList());
                    break;
                case 4:
                    int subselectionMenu = -1;
                    INNER:
                    while (subselectionMenu < 1 || subselectionMenu > 4) {
                        System.out.println("***Set Details Sub-Menu***\n"
                                + "1 - Set currency\n"
                                + "2 - Set minimum coin input value\n"
                                + "3 - Set maximum coin input value\n"
                                + "4 - Return to main menu\n");
                        System.out.print("Please Choose valid option: ");
                        subselectionMenu = sc.nextInt();

                        switch (subselectionMenu) {
                            case 1:
                                System.out.print("Set Currency: ");
                                String curr;
                                curr = sc.next();
                                cSorter.setCurrency(curr);
                                break;
                            case 2:
                                System.out.print("Set Minimum Coin Input Value: ");
                                int min;
                                min = sc.nextInt();
                                cSorter.setMinCoinIn(min);
                                break;
                            case 3:
                                System.out.print("Set Maximum Coin Input Value: ");
                                int max;
                                max = sc.nextInt();
                                cSorter.setMaxCoinIn(max);
                                break;
                            case 4:
                                break INNER;
                            default:
                                break;
                        }
                        subselectionMenu = -1;
                    }
                    break;
                case 5:
                    System.out.println(cSorter.displayProgramConfigs());
                    break;
                case 6:
                    break OUTER;
                default:
                    break;
            }
            mainMenuSelection = -1;
        }
    }
}
