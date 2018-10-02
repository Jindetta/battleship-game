package tiko.vc.battleship;

/**
 * A class that contains an individual ship data.
 */
public class Ship {

    /**
     * Define ship id.
     */
    private int id;

    /**
     * Define ship name.
     */
    private String name;

    /**
     * Define ship length.
     */
    private int length;

    /**
     * Overrides constructor.
     *
     * @param length Ship length.
     * @param id Ship id.
     * @param name Ship name.
     */
    public Ship(int length, int id, String name) {
        setLength(length);
        setName(name);
        setId(id);
    }

    /**
     * Gets ship id.
     *
     * @return Ship id as int.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets ship id.
     *
     * @param id Ship id value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets ship length.
     *
     * @return Ship length as int.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets ship length.
     *
     * @param length Ship length value.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets ship name.
     *
     * @return Ship name as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets ship name.
     *
     * @param name Ship name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }
}