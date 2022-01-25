/**
 * @author Thonifho
 */
package za.co.wethinkcode.robotworlds.Server.Domain.world.obstacles;

import za.co.wethinkcode.robotworlds.Server.Domain.world.Position;

/**
 * Implements the creation of the mine obstacle
 * Action: Thoni
 */

public class SquareMine implements Obstacle {
    int x;
    int y;

    public SquareMine(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter methods to return the state of the mine obstacle
     * @return BottomLeftX, BottomLeftY, size of the mine
     */
    @Override
    public int getBottomLeftX() { return this.x; }

    @Override
    public int getBottomLeftY() { return this.y; }

    @Override
    public int getSize() { return 5; }

    @Override
    public boolean getIsPit(){return false;}

    /**
     * Method to check whether a future position is occupied by a mine
     * @param position the position to check
     * @return true if a mine is in place
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
     * Check if the path to be traversed contains a mine.
     * @param a first position
     * @param b second position
     * @return true if there is a mine in the path.
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
