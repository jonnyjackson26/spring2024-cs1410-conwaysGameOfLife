public class LifeSimulator {
    private boolean[][] life;
    private int sizeX;
    private int sizeY;
    public LifeSimulator(int sizeX, int sizeY) {
        life = new boolean[sizeX][sizeY];
        this.sizeX=sizeX;
        this.sizeY=sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public boolean getCell(int x, int y) {
        return life[x][y];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for(int i=0; i<pattern.getSizeX(); i++) {
            for(int j=0; j<pattern.getSizeY(); j++) {
                if(i+startX<life.length && j+startY<life[0].length) {
                    life[i + startX][j + startY] = pattern.getCell(i, j);
                }
            }
        }
    }
    public void update() {
        boolean[][] updated = new boolean[life.length][life[0].length];
        for(int i=0; i<life.length; i++) {
            for(int j=0; j<life[0].length; j++) {
                if (life[i][j] && numOfLiveNeighbors(i, j) < 2) {
                    updated[i][j] = false; //died by underpopulation
                } else if (life[i][j] && (numOfLiveNeighbors(i, j) == 2 || numOfLiveNeighbors(i, j) == 3)) {
                    updated[i][j] = true; //lives on
                } else if (life[i][j] && numOfLiveNeighbors(i, j) > 3) {
                    updated[i][j] = false; //overpopulation
                } else if (!life[i][j] && numOfLiveNeighbors(i, j) == 3) {
                    updated[i][j] = true; //reproduction
                } else {
                    updated[i][j]=life[i][j];
                }
            }
        }
        life=updated;
    }
    private int numOfLiveNeighbors(int x, int y) {
        int cntr=0;
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                if(i>=0 && j>=0 && i< life.length && j<life[0].length && (i != x || j != y)) { //if in bounds and not the actual middle cell
                    if (life[i][j]) {
                        cntr++;
                    }
                }
            }
        }
        return cntr;
    }

};

