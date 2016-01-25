package ua.kiev.univ.cyb.project1.knight.equipment;

/**
 * Equipment for project1.
 * Abstract class implements interface <code>Comparable</code>.
 * @author Anton Babak
 * @since 07.11.2015
 */
public abstract class Equipment implements Comparable<Equipment> {
    /**
     * Weight of equipment.
     */
    protected int weight;

    /**
     * Price of equipment.
     */
    protected int price;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Equipment o) {
        return this.weight - o.weight;
    }
}
