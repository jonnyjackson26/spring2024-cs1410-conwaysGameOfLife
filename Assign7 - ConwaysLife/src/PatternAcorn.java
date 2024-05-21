public class PatternAcorn extends Pattern {


    @Override
    public int getSizeX() {
        return 7;
    }

    @Override
    public int getSizeY() {
        return 3;
    }

    @Override
    public boolean getCell(int x, int y) {
        if(x>0 && y>0) {
            boolean[][] acorn = {
                    {false, true, false, false, false, false, false},
                    {false, false, false, true, false, false, false},
                    {true, true, false, false, true, true, true}
            };
            return acorn[y][x];
        } else {
            return false;
        }
    }
}