package ua.kiev.univ.cyb.project1.knight.equipment.armors;

import ua.kiev.univ.cyb.project1.knight.equipment.materials.ShieldMaterial;

/**
 * Shield is type of armor. Class extends <code>Armor</code>
 * and uses field with enum <code>ShieldMaterial</code>.
 * @author Anton Babak
 * @since 07.11.2015
 */
public class Shield extends Armor {
    /**
     * Shield material.
     */
    private ShieldMaterial material;

    /**
     * Create helmet with price, weight, strength and type.
     * @param price Price extends from <code>Equipment</code>
     * @param weight Weight extends from <code>Equipment</code>
     * @param strength Strength extends from <code>Armor</code>
     * @param material Shield material
     */
    public Shield(int price, int weight, int strength, ShieldMaterial material) {
        this.weight = weight;
        this.price = price;
        this.material = material;
        this.strength = strength;
    }

    public ShieldMaterial getMaterial() {
        return material;
    }

    public void setMaterial(ShieldMaterial material) {
        this.material = material;
    }
}
