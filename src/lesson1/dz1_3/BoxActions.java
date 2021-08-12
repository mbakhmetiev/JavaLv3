package lesson1.dz1_3;

public interface BoxActions <T> {
    void addFruitToBox (T fruit);
    void removeFruitFromBox();
    float getBoxWeight ();
    void moveFruits(Box<T> box);
    String getBoxName();
    int compareTo(Box<?> box);

}
