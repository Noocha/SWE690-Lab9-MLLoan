import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

public class ClassificationLogisticLoan {
    String trainingFilename;
    String testingFilename;

    String predictFilename;
    Classifier classifier;
    int classAttributes;

    public ClassificationLogisticLoan() {}


    public ClassificationLogisticLoan(String trainingFilename, String testingFilename, String predictFilename, int classAttributes) {
        this.trainingFilename = trainingFilename;
        this.testingFilename = testingFilename;
        this.predictFilename = predictFilename;
        this.classAttributes = classAttributes;
    }



    public ClassificationLogisticLoan(Classifier classifier) {
        this.classifier = classifier;
    }


    public String getTrainingFilename() {
        return trainingFilename;
    }

    public void setTrainingFilename(String trainingFilename) {
        this.trainingFilename = trainingFilename;
    }

    public String getTestingFilename() {
        return testingFilename;
    }

    public void setTestingFilename(String testingFilename) {
        this.testingFilename = testingFilename;
    }

    public String getPredictFilename() {
        return predictFilename;
    }

    public void setPredictFilename(String predictFilename) {
        this.predictFilename = predictFilename;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    public int getClassAttributes() {
        return classAttributes;
    }

    public void setClassAttributes(int classAttributes) {
        this.classAttributes = classAttributes;
    }

    public Instances getDataSet(String filename) {
        ArffLoader loader = new ArffLoader();
        try {
            loader.setFile(new File(filename));
            Instances dataset = loader.getDataSet();
            dataset.setClassIndex(classAttributes);
            return dataset;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void trainingAndTesting() {
        Instances trainingDataSet = getDataSet(trainingFilename);
        Instances testingDataSet = getDataSet(testingFilename);
        classifier = new Logistic();
        try {
            classifier.buildClassifier(trainingDataSet);
            Evaluation evaluation = new Evaluation(trainingDataSet);
            evaluation.evaluateModel(classifier, testingDataSet);

            System.out.println("Loan Model");
            System.out.println(classifier);
            System.out.println("Loan Evaluation");
            System.out.println(evaluation.toSummaryString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  predictDataSet() {
        System.out.println("Prediction from Data Set File");
        Instance predictionDataSet;
        double answerValue = 0;

        Instances predictDataSets = getDataSet(predictFilename);
        for (int i = 0; i < predictDataSets.numInstances(); i++) {
            predictionDataSet = predictDataSets.instance(i);
            try {
                answerValue = classifier.classifyInstance(predictionDataSet);
                printAttribute(predictionDataSet);
                System.out.println(answerValue == 0 ? ">>>>> You can Loan" : ">>>>> You can not Loan");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println();
        }
    }

    public String predictOneInstance (String married, String dependent, String graduate, String selfEmployed, double appIncome,
                                      double coAppIncome, double loanAmount, double loanTerm, String propertyArea) {
        String loanAnswer = "";
        Instance predictDataSet = getDataSet(predictFilename).instance(0);
        predictDataSet.setValue(0, married);
        predictDataSet.setValue(1, dependent);
        predictDataSet.setValue(2, graduate);
        predictDataSet.setValue(3, selfEmployed);
        predictDataSet.setValue(4, appIncome);
        predictDataSet.setValue(5, coAppIncome);
        predictDataSet.setValue(6, loanAmount);
        predictDataSet.setValue(7, loanTerm);
        predictDataSet.setValue(8, propertyArea);

        try {
            double value = classifier.classifyInstance(predictDataSet);
            printAttribute(predictDataSet);
            loanAnswer = value == 0 ? "Congratulation You can Loan" : "Sorry, can not Loan";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loanAnswer;
    }

    private void printAttribute(Instance predictionDataSet) {
        System.out.println("Married: " + predictionDataSet.stringValue(0));
        System.out.println("Dependents: " + predictionDataSet.stringValue(1));
        System.out.println("Education: " + predictionDataSet.stringValue(2));
        System.out.println("Self_Employed: " + predictionDataSet.stringValue(3));
        System.out.println("ApplicantIncome: " + predictionDataSet.value(4));
        System.out.println("CoapplicantIncome: " + predictionDataSet.value(5));
        System.out.println("LoanAmount: " + predictionDataSet.value(6));
        System.out.println("Loan_Amount_Term: " + predictionDataSet.value(7));
        System.out.println("Property_Area: " + predictionDataSet.stringValue(8));

    }


}
