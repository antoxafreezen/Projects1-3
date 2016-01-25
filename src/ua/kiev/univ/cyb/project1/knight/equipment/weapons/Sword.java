package ua.kiev.univ.cyb.project1.knight.equipment.weapons;
/**
 * Sword is type of wepon. Class extends <code>Weapon</code>.
 * @author Anton Babak
 * @since 07.11.2015
 */
public class Sword extends Weapon {
    /**
     * General parameter for sword. Difference between blade and handle weight
     * = 0 - great balance
     * > 0 - blade is heavier
     * < 0 - handle is heavier
     */
    private int balance;

    /**
     * Create helmet with price, weight, damage and balance.
     * @param price Price extends from <code>Equipment</code>.
     * @param weight Weight extends from <code>Equipment</code>.
     * @param bladeWeight Blade weight.
     * @param handleWeight Handle weight.
     * @param damage Damage extends from <code>Weapon</code>
     */
    public Sword(int price, int weight, int damage, int bladeWeight, int handleWeight) {
        this.price = price;
        this.weight = weight;
        this.damage = damage;
        this.balance = bladeWeight - handleWeight;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Redefine method of imroving sword.
     * Sharps the sword.
     * @param damage Weapon improve such quantity of damage.
     */
    @Override
    public void improveWeapon(int damage) {
        sharpSword(damage);
    }

    /**
     * Sharp the sword. Increase damage.
     * @param damage Sword improve such quantity of damage.
     */
    private void sharpSword(int damage) {
        this.damage += damage;
    }
}
