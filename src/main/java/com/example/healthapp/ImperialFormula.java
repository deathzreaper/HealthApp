package com.example.healthapp;

class ImperialFormula {
    private double inputKg;
    private double inputM;

    ImperialFormula(double inputKg, double inputM) {
        this.inputKg = inputKg;
        this.inputM = inputM;
    }

    double getInputKg() {
        return inputKg;
    }

    double getInputM() {
        return inputM;
    }

    double computeBMI(double kg, double m) {
        double result=0;

        double KG_TO_LBS = 2.20462;
        double lbs = Math.round(kg * KG_TO_LBS );
        double m_TO_IN = 39.3701;
        double in = Math.round((m * m_TO_IN) *100);

        result = (lbs / (Math.pow((in/100), 2)))* 703;

        return result;
    }

}
