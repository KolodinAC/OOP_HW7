package controller;

import model.Calculatable;
import model.Number;

public class Calculator<N extends Number> {

    public N summ (N arg1, N arg2){
        N sum = (N) arg1.sum(arg2);
        return sum;
    }

    public N subtraction (N arg1, N arg2){
        N sub = (N) arg1.subtraction(arg2);
        return sub;
    }

    public N multiplication (N arg1, N arg2){
        N mult = (N) arg1.multiplication(arg2);
        return mult;
    }

    public N division (N arg1, N arg2){
        N div = (N) arg1.division(arg2);
        return div;
    }

    public N sqrt (N arg){
        N sq = (N) arg.sqrt();
        return sq;
    }

    public N exp (N arg){
        N xp = (N) arg.exp();
        return xp;
    }
}
