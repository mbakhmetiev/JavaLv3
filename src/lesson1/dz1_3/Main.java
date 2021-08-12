package lesson1.dz1_3;

public class Main {
        public static void main(String[] args) throws ClassNotFoundException {
            // *** Создать инстансы фруктов ***
            Apple apple = new Apple();
            Orange orange = new Orange();
            // *** Задать вместимость ящиков в штуках фруктов **
            int appleBox1q = 10;
            int appleBox2q = 15;
            int orangeBox1q = 12;
            int orangeBox2q = 10;

            BoxActions<Apple> appleBox1 = new Box<>(appleBox1q, apple.getWeight(), "appleBox1");
            BoxActions<Apple> appleBox2 = new Box<>(appleBox2q, apple.getWeight(), "appleBox2");

            // *** Заполняем apple ящик 2 полностью ***
            for (int i = 0; i < appleBox2q; i++) {
                appleBox2.addFruitToBox(apple);
            }

            System.out.printf("Вес ящика %s: %.2f\n",appleBox2.getBoxName(), appleBox2.getBoxWeight());

            // *** Пересыпаем из ящика 2 в 1  ***
            appleBox2.moveFruits((Box<Apple>) appleBox1);
            System.out.printf("Вес ящика %s после пересыпания: %.2f\n",appleBox1.getBoxName(), appleBox1.getBoxWeight());
            System.out.printf("Вес ящика %s после пересыпания: %.2f\n",appleBox2.getBoxName(), appleBox2.getBoxWeight());

            // *** Попытка снова заполнить ящик, срабатывает отказ по переполнению ***
            for (int i = 0; i < appleBox2q; i++) {
                appleBox2.addFruitToBox(apple);
            }
            System.out.printf("Вес ящика %s: %.2f\n",appleBox2.getBoxName(), appleBox2.getBoxWeight());

            BoxActions<Orange> orangeBox1 = new Box<>(orangeBox1q, orange.getWeight(), "orangeBox1");
            BoxActions<Orange> orangeBox2 = new Box<>(orangeBox2q, orange.getWeight(), "orangeBox2");

            // *** Заполняем orange ящик 1 полностью ***
            for (int i = 0; i < orangeBox1q; i++) {
                orangeBox1.addFruitToBox(orange);
            }
            System.out.printf("Вес ящика %s: %.2f\n",orangeBox1.getBoxName(), orangeBox1.getBoxWeight());

            // *** Пересыпаем из ящика 1 в 2  ***
            orangeBox1.moveFruits((Box<Orange>) orangeBox2);
            System.out.printf("Вес ящика %s: %.2f\n",orangeBox1.getBoxName(), orangeBox1.getBoxWeight());
            System.out.printf("Вес ящика %s: %.2f\n",orangeBox2.getBoxName(), orangeBox2.getBoxWeight());

            // *** Результат сравнения  appleBox2 и orangeBox2 ***
            boolean res = (appleBox2.compareTo((Box<?>) orangeBox2)) == 1;
            System.out.printf("Ящик %s равен по весу %s (True/False) - %b\n",appleBox2.getBoxName(), orangeBox2.getBoxName(), res);

            // *** Результат сравнения  appleBox1 и orangeBox1 ***
            res = (orangeBox1.compareTo((Box<?>) appleBox1)) == 1;
            System.out.printf("Ящик %s равен по весу %s (True/False) - %b\n",orangeBox1.getBoxName(), appleBox1.getBoxName(), res);

    }
}
