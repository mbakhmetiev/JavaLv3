package lesson1.dz1_2;

public class Type1Test {
    public static void main(String[] args) {
        // *** Задание 1 ***
        int size = 5;
        Type1<String> t1Str = new Type1Impl<>(size);
        t1Str.add("Mary");
        t1Str.add("had");
        t1Str.add("a");
        t1Str.add("little");
        t1Str.add("lamb");
        int ind1 = 0; int ind2 = 4; // Элементы для свопа
        System.out.println("*** Исходный массив ***");
        t1Str.display();
        t1Str.swap(ind1, ind2);
        System.out.printf("*** Элементы %d и %d переставлены ***\n", ind1, ind2);
        t1Str.display();

        Type1<Integer> t1Int = new Type1Impl<>(size);
        for (int i = 0; i < size; i++) {
            t1Int.add((i + 1) * 10);
        }
        ind1 = 1; ind2 = 2; // Элементы для свопа
        System.out.println("*** Исходный массив ***");
        t1Int.display();
        t1Int.swap(ind1, ind2);
        System.out.printf("*** Элементы %d и %d переставлены ***\n", ind1, ind2);
        t1Int.display();

        // *** Задание 2 ***
        System.out.println("*** Перевод в ArrayList ***");
        System.out.println(t1Str.toArrList());
        System.out.println(t1Int.toArrList());
    }
}
