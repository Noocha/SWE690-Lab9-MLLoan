import weka.classifiers.Classifier;

public class MLLoan {

    public static void main(String[] args) {
        ClassificationLogisticLoan loan = new ClassificationLogisticLoan("src/creditRisk_Clean_NoCreditHistory_training.arff", "src/creditRisk_Clean_NoCreditHistory_testing.arff", "src/creditRisk_Clean_NoCreditHistory_predict.arff", 0);
        loan.setClassAttributes(9);
        loan.trainingAndTesting();
        loan.predictDataSet();

        LoadView loanView = new LoadView();
        loanView.setClassifier(loan.getClassifier());
        loanView.setVisible(true);
    }
}
