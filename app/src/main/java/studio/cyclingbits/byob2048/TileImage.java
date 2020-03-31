package studio.cyclingbits.byob2048;

import android.widget.ImageView;

import java.util.Random;

public class TileImage {

    private RuntimeConstants constants = new RuntimeConstants();
    private ImageView imageView;
    private int tileScore = 2;
    private int currentX = 0;
    private int currentY = 0;
    private int matrixX = 0;
    private int matrixY = 0;


    public TileImage(RuntimeConstants constants, int matrixX, int matrixY) {
        this.constants = constants;
        this.matrixX = matrixX;
        this.matrixY = matrixY;
        currentX = constants.getGridImageX();
        currentY = constants.getGridImageY();

        // 10% chance that new tile is 4
        int chance = new Random().nextInt(100);
        if (chance >= 90) {
            tileScore = 4;
        }
    }

    public void draw() {
        imageView = new ImageView(constants.getContext());
        imageView.setImageResource(constants.getTileResourceId(tileScore));
        imageView.setPadding(constants.getTilePadding(), constants.getTilePadding(), constants.getTilePadding(), constants.getTilePadding());

        imageView.setX(calculateX());
//        imageView.setX(constants.getGridImageX());
        imageView.setY(calculateY());
//        imageView.setY(constants.getGridImageY());


        constants.getGridView().addView(imageView, constants.getTileImageSize(), constants.getTileImageSize());
    }

    private int calculateX() {
        return (int) (constants.getGridImageX() + (matrixY * constants.getTileImageSize()) );
    }

    private int calculateY() {
        return (int) (constants.getGridImageY() + (matrixX * constants.getTileImageSize()) );
    }
}
