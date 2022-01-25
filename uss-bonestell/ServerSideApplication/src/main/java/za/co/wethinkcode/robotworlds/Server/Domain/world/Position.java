/**
 * @author Thonifho
 */
package za.co.wethinkcode.robotworlds.Server.Domain.world;


import java.util.ArrayList;
import java.util.List;

/**
 * Class to create position objects.
 * Action: Tshepo
 */
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    /**
     * Checks if the future position is within the world coordinates
     * @param topLeft
     * @param bottomRight
     * @return true if it is within and false if not.
     */
    public boolean isIn(Position topLeft, Position bottomRight) {
        boolean withinTop = this.y <= topLeft.getY();
        boolean withinBottom = this.y >= bottomRight.getY();
        boolean withinLeft = this.x >= topLeft.getX();
        boolean withinRight = this.x <= bottomRight.getX();
        return withinTop && withinBottom && withinLeft && withinRight;
    }

    public List<Integer> toList() {
        List<Integer> l = new ArrayList<>();
        l.add(x);
        l.add(y);
        return l;
    }

    @Override
    public String toString() {
        return "x: " + getX() + ", y: " + getY();
    }
}
