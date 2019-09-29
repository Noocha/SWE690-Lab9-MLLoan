import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import weka.classifiers.Classifier;
/*
 * Created by JFormDesigner on Sun Sep 29 09:49:12 ICT 2019
 */
/**
 * @author unknown
 */
public class LoadView extends JFrame {
    ClassificationLogisticLoan loanObj;

    public LoadView() {
        loanObj = new ClassificationLogisticLoan();
        loanObj.setPredictFilename("src/creditRisk_Clean_NoCreditHistory_predict.arff");
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here

        String married = checkBox1.isSelected() ? "Yes" : "No";
        int dep = comboBox1.getSelectedIndex();
        String dependent = dep == 3 ? "3+" : (dep + "");
        String graduate = checkBox2.isSelected() ? "Graduate" : "NotGraduate";
        String selfEmp = checkBox3.isSelected() ? "Yes" : "No";
        double appIncome = Double.parseDouble(textField1.getText());
        double coAppIncome = Double.parseDouble(textField2.getText());
        double loanAmount = Double.parseDouble(textField3.getText());
        double loanTerm = Double.parseDouble(textField4.getText());
        String proArea = comboBox2.getSelectedItem().toString();
//        String proArea = propAreaIndex == 0 ? "Rural" : propAreaIndex == 1 ? "Urban" : "Semiurban";
        String result = loanObj.predictOneInstance(married, dependent, graduate, selfEmp, appIncome, coAppIncome, loanAmount, loanTerm, proArea);

        textField5.setText(result);
    }

    public void setClassifier(Classifier cl) {
        loanObj.setClassifier(cl);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Nattagan Ananpech
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        label2 = new JLabel();
        checkBox2 = new JCheckBox();
        label4 = new JLabel();
        checkBox3 = new JCheckBox();
        label5 = new JLabel();
        textField1 = new JTextField();
        label6 = new JLabel();
        textField2 = new JTextField();
        label7 = new JLabel();
        textField3 = new JTextField();
        label8 = new JLabel();
        textField4 = new JTextField();
        label9 = new JLabel();
        comboBox2 = new JComboBox<>();
        button1 = new JButton();
        textField5 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[245,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Married");
        contentPane.add(label1, "cell 0 0");

        //---- checkBox1 ----
        checkBox1.setText("Yes, application is married");
        contentPane.add(checkBox1, "cell 1 0");

        //---- label3 ----
        label3.setText("Dependents");
        contentPane.add(label3, "cell 3 0");

        //---- comboBox1 ----
        comboBox1.setOpaque(false);
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "0",
            "1",
            "2",
            "3"
        }));
        contentPane.add(comboBox1, "cell 4 0");

        //---- label2 ----
        label2.setText("Graduate");
        contentPane.add(label2, "cell 0 1");

        //---- checkBox2 ----
        checkBox2.setText("Yes already graduate");
        contentPane.add(checkBox2, "cell 1 1");

        //---- label4 ----
        label4.setText("Self-employed");
        contentPane.add(label4, "cell 3 1");

        //---- checkBox3 ----
        checkBox3.setText("Self-employed");
        contentPane.add(checkBox3, "cell 4 1");

        //---- label5 ----
        label5.setText("Applicant Income [x 1000 $]");
        contentPane.add(label5, "cell 0 2");

        //---- textField1 ----
        textField1.setText("0");
        contentPane.add(textField1, "cell 1 2");

        //---- label6 ----
        label6.setText("Co-Applicant Income");
        contentPane.add(label6, "cell 3 2");

        //---- textField2 ----
        textField2.setText("0");
        contentPane.add(textField2, "cell 4 2");

        //---- label7 ----
        label7.setText("Loan Amount [x 1000 $]");
        contentPane.add(label7, "cell 0 3");

        //---- textField3 ----
        textField3.setText("0");
        contentPane.add(textField3, "cell 1 3");

        //---- label8 ----
        label8.setText("Loan Amount Term [months]");
        contentPane.add(label8, "cell 3 3");

        //---- textField4 ----
        textField4.setText("0");
        contentPane.add(textField4, "cell 4 3");

        //---- label9 ----
        label9.setText("Property Area");
        contentPane.add(label9, "cell 0 4");

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "Rural",
            "Urban",
            "Semiurban"
        }));
        contentPane.add(comboBox2, "cell 1 4");

        //---- button1 ----
        button1.setText("Apply");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 0 6");
        contentPane.add(textField5, "cell 1 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public static void main(String[] args) {
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Nattagan Ananpech
    private JLabel label1;
    private JCheckBox checkBox1;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JLabel label2;
    private JCheckBox checkBox2;
    private JLabel label4;
    private JCheckBox checkBox3;
    private JLabel label5;
    private JTextField textField1;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label8;
    private JTextField textField4;
    private JLabel label9;
    private JComboBox<String> comboBox2;
    private JButton button1;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
