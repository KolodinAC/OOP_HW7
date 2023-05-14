package view;

import controller.Calculator;
import controller.Logger;
import controller.NumCreator;
import model.Calculatable;
import model.Cash;
import model.ComplexNumber;
import model.Loggable;
import model.Number;

import java.util.Scanner;

public class Gui {
    NumCreator crt = new NumCreator();
    Calculator calc = new Calculator();
    Cash temp = new Cash();
    Logger logger = new Logger();
    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                System.out.println("Список комманд:\n 1.NONE\n 2.CNUM\n 3.PLUSE\n 4.MINUSE\n 5.MULT\n 6.LOG\n 7.EXIT\n");
                String command = prompt("Введите доступную команду: ");
                com = Commands.valueOf(command.toUpperCase());


                if (com == Commands.EXIT) return;
                switch (com) {
                    case CNUM:
                        createComplNum();
                        break;
                    case PLUSE:
                        sum();
                        break;
                    case MINUSE:
                        subtraction();
                        break;
                    case MULT:
                        multiplication();
                        break;
                    case LOG:
                        showLog();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showLog() {
        System.out.println(logger.printLogs());
    }

    private void log(String comment) {
        logger.log(comment);
    }

    private void multiplication() {
        if (temp.look() instanceof ComplexNumber){
            System.out.println("Давайте создадим второе число.");
            log("*");
            //Number res = temp.fromCash().multiplication(this.createComplNum());
            Number res = calc.multiplication((Number) temp.fromCash(),this.createComplNum());
            temp.toCash(res);
            log("=");
            log(res.toString());
            System.out.println(res);
        }
    }

    private void subtraction() {
        if (temp.look() instanceof ComplexNumber) {
            System.out.println("Давайте создадим второе число.");
            log("-");
            //Number res = temp.fromCash().subtraction(this.createComplNum());
            Number res = calc.subtraction((Number) temp.fromCash(),this.createComplNum());
            temp.toCash(res);
            log("=");
            log(res.toString());
            System.out.println(res);
        }
    }

    public ComplexNumber createComplNum() {
        int ind = Integer.parseInt(prompt("Введите индекс для комплекса:"));
        int mat = Integer.parseInt(prompt("Введите материальную часть комплекса:"));
        int img = Integer.parseInt(prompt("Введите мнимую часть комплекса"));
        ComplexNumber complex = crt.createComplexNumber(ind, mat, img);
        log(complex.toString());
        temp.toCash(complex);
        return complex;
    }

    public void sum(){
        if (temp.look() instanceof ComplexNumber){
            System.out.println("Давайте создадим второе число.");
            log("+");
            //Number res = temp.fromCash().sum(this.createComplNum());
            Number res = calc.summ((Number) temp.fromCash(),this.createComplNum());
            log("=");
            log(res.toString());
            temp.toCash(res);
            System.out.println(res);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
