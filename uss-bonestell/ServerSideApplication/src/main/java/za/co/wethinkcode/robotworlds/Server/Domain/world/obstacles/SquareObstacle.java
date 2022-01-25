/**
 * @author Thonifho
 */
package za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles;

import za.co.wethinkcode.robotworlds.Server.Domain.world.Position;


/**
 * Class to implement square obstacles and pits
 * Action: Thoni
 */
public class SquareObstacle implements Obstacle {
    int x;
    int y;
    boolean isPit;
    int size;

    /**
     * Obstacle is noted by the x and y coordinate as well as a boolean
     * noting true if the obstacle is a pit and false if not
     * @param x
     * @param y
     * @param isPit
     */
    public SquareObstacle(int x, int y, boolean isPit) {
        this.x = x;
        this.y = y;
        this.isPit = isPit;
        this.size = getSize();
    }

    /**
     * Getter methods access the values of various values.
     * @return BottomLeftX, BottomLeftY, boolean pit or not, size of the obstacle.
     */
    @Override
    public int getBottomLeftX() { return this.x; }

    @Override
    public int getBottomLeftY() { return this.y; }

    @Override
    public boolean getIsPit(){ return this.isPit; }

    @Override
    public int getSize() { return 5; }

    /**
     * Method to check if the future position is accessible
     * @param position the position to check
     * @return true if it is blocked
     */
    @Override
    public boolean blocksPosition(Position position) {
        for (int i = 0; i < 5; i++) {
            if ((this.x + i == position.getX()) & (position.getY() == this.y))
                return true;
            if ((this.x == position.getX()) & (position.getY() == this.y+i))
                return true;
        }
        return false;
    }

    /**
     * Checks whether the path to be traversed if blocked
     * @param a first position
     * @param b second position
     * @return true if the path is blocked
     */
    @Override
    public boolean blocksPath(Position a, Position b) {
        Position check;
        if (a.getX() == b.getX()){
            // checkY
            if (a.getY() < b.getY()){
                for (int i = 0; i < b.getY() - a.getY(); i++){
                    check = new Position(a.getX(), a.getY()+i);
                    if (blocksPosition(check))
                        return true;
                }
            }
            else {
                for (int i = 0; i < a.getY() - b.getY(); i++){
                    check = new Position(a.getX(), b.getY()+i);
                    if (blocksPosition(check))
                        return true;
                }
            }
        }
        else {
            //checkX
            if (a.getX() < b.getX()){
                for (int i = 0; i < b.getX() - a.getX(); i++){
                    check = new Position(a.getX()+i, a.getY());
                    if (blocksPosition(check))
                        return true;
                }
            }
            else {
                for (int i = 0; i < a.getX() - b.getX(); i++){
                    check = new Position(a.getX()+i, b.getY());
                    if (blocksPosition(check))
                        return true;
                }
            }
        }
        return false;
    }
}
