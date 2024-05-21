public class PatternBlock extends Pattern{

    @Override
    public int getSizeX() {
        return 2;
    }

    @Override
    public int getSizeY() {
        return 2;
    }

    @Override
    public boolean getCell(int x, int y) {
        boolean[][] glider =  {
                {true, true},
                {true, true}
        };
        return glider[x][y];
    }
}