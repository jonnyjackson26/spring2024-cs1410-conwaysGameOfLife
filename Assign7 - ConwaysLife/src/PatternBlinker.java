public class PatternBlinker extends Pattern{

    @Override
    public int getSizeX() {
        return 3;
    }

    @Override
    public int getSizeY() {
        return 3;
    }

    @Override
    public boolean getCell(int x, int y) {
        boolean[][] glider =  {
                {false, true, false},
                {false, true, false},
                {false, true, false}
        };
        return glider[x][y];
    }
}