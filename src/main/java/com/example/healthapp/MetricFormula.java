package com.example.healthapp;

class MetricFormula {
    private double inputKg;
    private double inputM;

    MetricFormula(double inputKg, double inputM) {
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
        return kg / (Math.pow(m,2));
    }
}
