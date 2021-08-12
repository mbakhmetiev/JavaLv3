package lesson1.dz1_2;

import java.util.ArrayList;
import java.util.List;

public class Type1Impl<T> implements Type1<T> {

    private T[] arrT1;
    private int currentsize;

    public Type1Impl(int size) {
        this.arrT1 = (T[]) new Object[size];
    }

    @Override
    public void add(T value) {
        add(value, currentsize);
    }

    @Override
    public void add(T value, int index) {
        arrT1[index] = value;
        currentsize++;
    }
    @Override
    public T get(int index) {
        return arrT1[index];
    }

    @Override
    public void display() {
        for (int i = 0; i < currentsize; i++) {
            System.out.print(arrT1[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void swap(int ind1, int ind2) {
        T temp = arrT1[ind1];
        arrT1[ind1] = arrT1[ind2];
        arrT1[ind2] = temp;
    }

    @Override
    public List<T> toArrList() {
        List<T> arrList = new ArrayList<>();
        for (T x : arrT1) {
            arrList.add(x);
        }
        return arrList;
    }
}
