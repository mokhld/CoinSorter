
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CoinSorterGUI extends CoinSorter implements ActionListener {

    public CoinSorterGUI() {
    }

    static JTextField exchangeInput, coinType, ExcludeInput, minInput, maxInput, currencyInput;
    static JButton coinCalBtn, dispConfig, setDetails, printList, multiCoinCal;
    static JTextArea output;

    public boolean isAlpha(String s) {
        if (s == null) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "Calculate Coin":
                if (isAlpha(exchangeInput.getText()) || isAlpha(coinType.getText())) {
                    output.setText("Invalid Input");
                } else {
                    output.setText(this.coinCalculator(Integer.valueOf(exchangeInput.getText()), Integer.valueOf(coinType.getText())));
                }
                break;
            case "Display Config":
                output.setText(this.displayProgramConfigs());
                break;
            case "Set Details":
                int count = 0;
                if (!isAlpha(minInput.getText())) {
                    this.setMinCoinIn(Integer.valueOf(minInput.getText()));
                    count++;
                }
                if (!isAlpha(maxInput.getText())) {
                    this.setMaxCoinIn(Integer.valueOf(maxInput.getText()));
                    count++;
                }
                if (!currencyInput.getText().equals("Currency Here")) {
                    this.setCurrency(currencyInput.getText());
                    count++;
                }
                if (count > 0) {
                    output.setText("Details Updated");
                } else {
                    count = 0;
                    output.setText("Invalid Input");
                }

                break;
            case "Print List":
                output.setText(this.printCoinList());
                break;
            case "Calculate Multi-coin":
                if (isAlpha(exchangeInput.getText()) || isAlpha(ExcludeInput.getText())) {
                    output.setText("Invalid Input");
                } else {
                    output.setText(this.multiCoinCalculator(Integer.valueOf(exchangeInput.getText()), Integer.valueOf(ExcludeInput.getText())));
                }
                break;
            default:
                break;
        }
    }

    public void formGUI() {
        CoinSorterGUI csGUI = new CoinSorterGUI();
        JFrame f = new JFrame("Coin Sorter");
        f.setSize(300, 300);
        f.getContentPane().setLayout(new GridLayout(3, 1));
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        output = new JTextArea(8, 30);
        output.setEditable(false);
        output.setText("Output");

        exchangeInput = new JTextField("Exchange Amount Here", 15);
        coinType = new JTextField("Coin Type Here", 15);
        ExcludeInput = new JTextField("Excluded Coin Here", 15);
        minInput = new JTextField("Minimum Amount Here", 15);
        maxInput = new JTextField("Maximum Amount Here", 15);
        currencyInput = new JTextField("Currency Here", 15);
        coinCalBtn = new JButton("Calculate Coin");
        dispConfig = new JButton("Display Config");
        setDetails = new JButton("Set Details");
        printList = new JButton("Print List");
        multiCoinCal = new JButton("Calculate Multi-coin");

        coinCalBtn.addActionListener((ActionListener) csGUI);
        dispConfig.addActionListener((ActionListener) csGUI);
        setDetails.addActionListener((ActionListener) csGUI);
        printList.addActionListener((ActionListener) csGUI);
        multiCoinCal.addActionListener((ActionListener) csGUI);

        output.setLineWrap(true);
        output.setWrapStyleWord(true);

        f.getContentPane().add(exchangeInput);
        f.getContentPane().add(coinType);
        f.getContentPane().add(coinCalBtn);
        f.getContentPane().add(ExcludeInput);
        f.getContentPane().add(multiCoinCal);
        f.getContentPane().add(dispConfig);
        f.getContentPane().add(printList);
        f.getContentPane().add(minInput);
        f.getContentPane().add(maxInput);
        f.getContentPane().add(currencyInput);
        f.getContentPane().add(setDetails);
        f.getContentPane().add(output);

        f.setSize(800, 200);
        f.setVisible(true);
    }

}
