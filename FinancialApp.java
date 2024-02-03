import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FinancialApp extends JFrame implements ActionListener {
    JButton button;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField6;
    JTextField textField7;

    public FinancialApp() {
        setTitle("Financial app");
        setSize(850, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        mainPanel.setBackground(new Color(169, 169, 169));
        mainPanel.setForeground(Color.WHITE);

        JLabel headerLabel = new JLabel("Compound Interest Calculator");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);

        JLabel label1 = new JLabel("1.Stock price:");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        textField1 = new JTextField();
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel label2 = new JLabel("2.Month of dividend:");
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        textField2 = new JTextField();
        textField2.setForeground(Color.WHITE);
        textField2.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel label3 = new JLabel("3.Avrege Dividend rate:");
        label3.setFont(new Font("Arial", Font.BOLD, 24));
        textField3 = new JTextField();
        textField3.setForeground(Color.WHITE);
        textField3.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel label4 = new JLabel("4.Entry price:");
        label4.setFont(new Font("Arial", Font.BOLD, 24));
        textField4 = new JTextField();
        textField4.setForeground(Color.WHITE);
        textField4.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel label5 = new JLabel("5.Avrege stock market return:");
        label5.setFont(new Font("Arial", Font.BOLD, 24));
        textField5 = new JTextField();
        textField5.setForeground(Color.WHITE);
        textField5.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel label6 = new JLabel("6.Time of investment (years):");
        label6.setFont(new Font("Arial", Font.BOLD, 24));
        textField6 = new JTextField();
        textField6.setForeground(Color.WHITE);
        textField6.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel label7 = new JLabel("7.Payment every month:");
        label7.setFont(new Font("Arial", Font.BOLD, 24));
        textField7 = new JTextField();
        textField7.setForeground(Color.WHITE);
        textField7.setFont(new Font("Arial", Font.PLAIN, 24));

        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);
        label5.setForeground(Color.WHITE);
        label6.setForeground(Color.WHITE);
        label7.setForeground(Color.WHITE);

        textField1.setBackground(new Color(192, 192, 192));
        textField2.setBackground(new Color(192, 192, 192));
        textField3.setBackground(new Color(192, 192, 192));
        textField4.setBackground(new Color(192, 192, 192));
        textField5.setBackground(new Color(192, 192, 192));
        textField6.setBackground(new Color(192, 192, 192));
        textField7.setBackground(new Color(192, 192, 192));

        textField1.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));
        textField2.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));
        textField3.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));
        textField4.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));
        textField5.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));
        textField6.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));
        textField7.setBorder(BorderFactory.createLineBorder(new Color(105, 105, 105)));

        button = new JButton("Calculate My Investment");
        button.setFont(new Font("Arial", Font.BOLD, 36));
        button.setBackground(new Color(105, 105, 105));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);

        JTextArea instructionsTextArea = new JTextArea(
                "instructions:\n\n" +
                        "1. Price of the asset you want to purchase.\n" +
                        "2. The month in which the dividend is paid.(Jun = 6) \n" +
                        "3. The percentage rate of the paid dividend.\n"+
                        "4. Amount of money you want to invest initially.\n"+
                        "5. Anticipated asset growth over the year.\n"+
                        "6. The number of years you intend to conduct the investment.\n"+
                        "7. The amount you want to contribute each month to purchase additional shares.\n"


        );
        instructionsTextArea.setEditable(false);
        instructionsTextArea.setBackground(new Color(192, 192, 192));
        instructionsTextArea.setForeground(Color.WHITE);
        instructionsTextArea.setFont(new Font("Arial", Font.PLAIN, 20));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(headerLabel)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label6)
                                .addComponent(label7))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
                .addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(instructionsTextArea, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(headerLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField3))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField4))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textField5))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(textField6))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(textField7))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructionsTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        add(mainPanel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
                CSVsave.cName();
                if (Calculation.checkInput(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(), textField6.getText(), textField7.getText())) {
                    int stockP = Integer.parseInt(textField1.getText());
                    int Mod = Integer.parseInt(textField2.getText());
                    int Dr = Integer.parseInt(textField3.getText());
                    int Pv = Integer.parseInt(textField4.getText());
                    double r = Double.parseDouble(textField5.getText());
                    double t = Double.parseDouble(textField6.getText());
                    int add = Integer.parseInt(textField7.getText());
                    Calculation.StockCalc(stockP, Mod, Dr, Pv, r, t, add);
                    Calculation.StockCalc1(stockP, Mod, Dr, Pv, r, t, add);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong data fomrat", "Fail", JOptionPane.ERROR_MESSAGE);
                }
        }


    }

    public static void main(String[] args) {
        new FinancialApp();
    }
}