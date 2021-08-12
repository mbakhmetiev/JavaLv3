package lesson1.dz1_3;

import java.util.ArrayList;

public class Box <T> implements BoxActions<T>, Comparable<Box<?>> {

    private String boxName;
    private Integer maxFruit;
    private float maxBoxWeight;
    private ArrayList<T> fruitsInBox = new ArrayList<>();
    private float fruitWeight;

    public Box(Integer q, float fruitWeight, String name) {
        this.maxFruit = q;
        this.fruitWeight = fruitWeight;
        this.boxName = name;
        this.maxBoxWeight = q * fruitWeight;
    }

    public String getBoxName() {
        return this.boxName;
    }

    @Override
    public void addFruitToBox(T fruit) {
        if (!checkBoxFull(this)) {
            this.fruitsInBox.add(fruit);
        } else {
            System.out.printf("Ящик %s заполнен\n", boxName);
        }
    }

    public boolean checkBoxFull(Box<T> box) {
        return box.getBoxWeight() >= box.maxBoxWeight;
    }


    @Override
    public void removeFruitFromBox() {
        if (checkBoxNotEmpty(this)) {
            fruitsInBox.remove(0);
        } else System.out.printf("Ящик %s - пустой\n", boxName);
    }

    public boolean checkBoxNotEmpty(Box<T> box) {
        return box.getBoxWeight() >= 0;
    }

    @Override
    public float getBoxWeight() {
        if (this.fruitsInBox.size() == 0) {
            return 0.0f;
        } else {
            return this.fruitsInBox.size() * this.fruitWeight;
        }
    }
    @Override
    public int compareTo(Box<?> box) {
        if(this.getBoxWeight() == box.getBoxWeight()) {
            return 1;
        } else return -1;

    }
    @Override
    public void moveFruits (Box<T> box) {
        int arrSize = this.fruitsInBox.size();
        ArrayList<T> copyOfbox = new ArrayList<>();
        copyOfbox.addAll(this.fruitsInBox);
        if (checkBoxNotEmpty(this)) {
            for (int i = 0; i < arrSize; i++) {
                if (!checkBoxFull(box)) {
                    box.fruitsInBox.add(this.fruitsInBox.get(i));
                    copyOfbox.remove(0);
                }
            }
            this.fruitsInBox = copyOfbox;
        }
    }
}