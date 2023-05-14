package model;

public interface Calculatable<T extends Number> {
    T subtraction(T arg2);
    T multiplication (T arg2);
    T sum (T arg2);
    T division (T arg2);
    T sqrt ();
    T exp ();
}
