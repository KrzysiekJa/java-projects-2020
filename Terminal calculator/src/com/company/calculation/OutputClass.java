package com.company.calculation;

public class OutputClass {

    public OutputClass(String str, Figure fig, Prism prism){
        this.str = str;
        this.fig = fig;
        this.prism = prism;
    }

    public Figure getFig() {
        return fig;
    }

    public String getStr() {
        return str;
    }

    public Prism getPrism() {
        return prism;
    }

    private String str;
    private Figure fig;
    private Prism prism;
}
