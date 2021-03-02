package com.company;

import com.company.calculation.OutputClass;
import com.company.calculation.creators.ExtraSwitch;

import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) { new Calculator().run(); }

    private void run() {
        System.out.println("Calculator ready to calculate!");

        decisionSwitchFunction();
    }



    private void decisionSwitchFunction() {
        Scanner scanner = new Scanner(System.in);
        String decision;
        OutputClass object = new OutputClass(null, null, null);

        while (true) {
            ExtraSwitch extraSwitch = new ExtraSwitch();

            System.out.println("Choose: 'fig' for figure/object computation / 'print' for print figure's data / 'exit'");
            decision = String.valueOf(scanner.nextLine());

                switch (decision) {
                    case "f":
                    case "fig":
                    case "Fig":
                        assert false;
                        object = extraSwitch.decisionSwitch();
                        break;

                    case "p":
                    case "print":
                    case "Print":
                        assert false;
                        extraSwitch.printSwitch(object);

                        break;

                    case "exit":
                        System.exit(0);

                    default:
                        break;
                }
            }
        }
    }
