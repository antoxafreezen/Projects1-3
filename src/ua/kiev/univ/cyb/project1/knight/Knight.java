package ua.kiev.univ.cyb.project1.knight;


import ua.kiev.univ.cyb.project1.knight.equipment.Equipment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Equip armor and weapon.
 *  Knight fights for honor.
 *  @author Anton Babak
 *  @since 07.11.2015
 */
public class Knight {
    /**
     * Equipment list.
     */
    private List<Equipment> equipment = new ArrayList<>();
    /**
     * Knight's name.
     */
    private String name;
    /**
     * Knight's weight.
     */
    private int weight;
    /**
     * Create knight with name and weight.
     * @param name Knight's name.
     * @param weight Knight's weight
     */
    public Knight(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Create project1 with name and his equipment.
     * @param name Knight's name.
     * @param equipment Knight's equipment.
     * @param weight Knight's weight.
     */
    public Knight(String name, int weight, List<Equipment> equipment) {
        this.equipment = equipment;
        this.name = name;
        this.weight = weight;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Add equipment in project1's equipment list.
     * @param e Equipment to add.
     */
    public void equip(Equipment e){
        equipment.add(e);
    }

    /**
     * Sort knight's equipment list by weight
     * @return Sorted equipment list.
     */
    public List<Equipment> sortByEquipmentWeight(){
        List<Equipment> sortedEquipment = equipment;
        Collections.sort(sortedEquipment);
        return sortedEquipment;
    }

    /**
     * Find knight's equipment within a specified price range.
     * @param from Low limit of range
     * @param to High limit of range
     * @return List of suitable equipment
     */
    public List<Equipment> findByPriceRange(int from, int to){
        List<Equipment> foundEquipment = new ArrayList<>();
        for(Equipment e: equipment){
            if (e.getPrice() <= to && e.getPrice() >= from){
                foundEquipment.add(e);
            }
        }
        return foundEquipment;
    }

    /**
     * Summarize all equipment weight
     * @return Sum of equioment weights
     */
    public int sumEquipmentWeight(){
        int sum = 0;
        for (Equipment e: equipment){
            sum += e.getWeight();
        }
        return sum;
    }
    /**
     * Summarize all equipment cost
     * @return Sum of equioment prices
     */
    public int sumEquipmentPrice(){
        int sum = 0;
        for (Equipment e: equipment){
            sum += e.getPrice();
        }
        return sum;
    }

    /**
     * Simulate real fight between knights.
     * @param otherKnight Opponent.
     */
    public void fight(Knight otherKnight){
        System.out.println("Starting the great fight: " + this.name + " VS " + otherKnight.name);
        if (this.sumEquipmentWeight() + this.weight < otherKnight.sumEquipmentWeight() + otherKnight.weight)
            System.out.println("Winner is " + otherKnight.name);
        else if (this.sumEquipmentWeight() + this.weight > otherKnight.sumEquipmentWeight() + otherKnight.weight)
            System.out.println("Winner is " + this.name);
        else if (this.sumEquipmentPrice() < otherKnight.sumEquipmentPrice())
            System.out.println("Winner is " + otherKnight.name);
        else if (this.sumEquipmentPrice() > otherKnight.sumEquipmentPrice())
            System.out.println("Winner is " + this.name);
        else System.out.println("We have no winner.");
    }
}
