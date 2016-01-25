package ua.kiev.univ.cyb.project1.knight.equipment.armors;

import ua.kiev.univ.cyb.project1.knight.equipment.materials.BreastplateType;

/**
 * Breastplate is type of armor. Class extends <code>Armor</code>
 * and uses field with enum <code>BreastplateType</code>.
 * @author Anton Babak
 * @since 07.11.2015
 */
public class Breastplate extends Armor{
    /**
     * Breastplate type.
     */
    private BreastplateType type;

    public BreastplateType getType() {
        return type;
    }

    public void setType(BreastplateType type) {
        this.type = type;
    }

    /**
     * Create breastplate with price, weight, strength and type.
     * @param price Price extends from <code>Equipment</code>
     * @param weight Weight extends from <code>Equipment</code>
     * @param strength Strength extends from <code>Armor</code>
     * @param type Type of breastplate
     */
    public Breastplate(int price, int weight,int strength, BreastplateType type) {
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.strength = strength;
    }
}
