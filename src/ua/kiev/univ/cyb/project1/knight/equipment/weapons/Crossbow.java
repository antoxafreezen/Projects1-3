package ua.kiev.univ.cyb.project1.knight.equipment.weapons;

public class Crossbow extends Weapon {

    /**
     * Tension of bowstring. Influences on shooting distance and damage.
     */
    private int bowstringTension;

    /**
     * Create helmet with price, weight, damage and bowstring tension.
     * @param price Price extends from <code>Equipment</code>.
     * @param weight Weight extends from <code>Equipment</code>.
     * @param damage Damage extends from <code>Weapon</code>
     * @param bowstringTension Tension of bowstring
     */
    public Crossbow(int price, int weight, int damage, int bowstringTension) {
        this.price = price;
        this.weight = weight;
        this.damage = damage;
        this.bowstringTension = bowstringTension;
    }

    public int getBowstringTension() {
        return bowstringTension;
    }

    public void setBowstringTension(int bowstringTension) {
        this.bowstringTension = bowstringTension;
    }

    /**
     * Redefine method of imroving sword.
     * Increase the tension of bowstring.
     * @param damage Weapon improve such quantity of damage.
     */
    @Override
    public void improveWeapon(int damage) {
        pullBowstring(damage);
    }

    /**
     * Increase the tension of bowstring.
     * @param damage Crossbow improve such quantity of damage.
     */
    private void pullBowstring(int damage) {
        this.damage += damage;
    }
}
