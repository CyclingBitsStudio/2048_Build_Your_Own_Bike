package studio.cyclingbits.byob2048;

import java.util.HashMap;
import java.util.Random;

public class TileManager {

    private RuntimeConstants constants = new RuntimeConstants();

    private TileImage[][] matrix = new TileImage[4][4];

    public TileManager(RuntimeConstants constants) {
        this.constants = constants;
    }

    private void initResources() {
        HashMap<Integer, Integer> drawables = new HashMap<>();
        drawables.put(2, R.drawable.ic_btn_01_saddle);
        drawables.put(4, R.drawable.ic_btn_02_handlebar);
        drawables.put(8, R.drawable.ic_btn_03_chain);
        drawables.put(16, R.drawable.ic_btn_04_brakes);
        drawables.put(32, R.drawable.ic_btn_05_frame);
        drawables.put(64, R.drawable.ic_btn_06_crank);
        drawables.put(128, R.drawable.ic_btn_07_rear_wheel);
        drawables.put(256, R.drawable.ic_btn_08_front_wheel);
        drawables.put(512, R.drawable.ic_btn_09_lever);
        drawables.put(1024, R.drawable.ic_btn_10_front_derailleur);
        drawables.put(2048, R.drawable.ic_btn_11_rear_derailleur);
        constants.setDrawables(drawables);

    }

    public void initGame() {
        initResources();
        matrix = new TileImage[4][4];

        for (int i = 0; i < 2; i++) {
            int x = new Random().nextInt(4);
            int y = new Random().nextInt(4);
            if (matrix[x][y] == null) {
                TileImage tile = new TileImage(constants, x, y);
                matrix[x][y] = tile;
            } else {
                i--;
            }
        }

    }

    public void drawAllTiles() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] != null) {
                    matrix[i][j].draw();
                }
            }
        }

//        if (endGame) {
//            callback.gameOver();
//        }
    }



}
