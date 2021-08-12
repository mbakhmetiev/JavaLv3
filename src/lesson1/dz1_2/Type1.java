package lesson1.dz1_2;

import java.util.List;

public interface Type1 <T>{

    void add(T value);

    void add(T value, int index);

    T get(int index);

    void display();

    void swap(int ind1, int ind2);

    List<T> toArrList ();
}
