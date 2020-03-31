package studio.cyclingbits.byob2048;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private RuntimeConstants constants = new RuntimeConstants();
    private FrameLayout bikeView;
    private ImageView frontWheelImage;
    private ImageView frameImage;
    private ImageView crankImage;
    private ImageView rearWheelImage;
    private ImageView saddleImage;

    // grid
    private FrameLayout gridView;
    private int gridViewHeight;
    private int gridViewWidth;

    private ImageView gridImage;
    private int gridImageSize;
    private int gridImageX;
    private int gridImageY;
    private int gridSVGSize = 840;
    private int gridSVGTileSize = 200;
    private int gridSVGPadding = 5;
    private float gridImageScale;


    // tile
    private int tilePadding;
    private int tileImageSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constants.setContext(this);


        bikeView = findViewById(R.id.bike_view);

//        frontWheelImage = new ImageView(this);
//        frontWheelImage.setImageResource(R.drawable.ic_100_front_wheel);
//        bikeView.addView(frontWheelImage);
//
//        frameImage = new ImageView(this);
//        frameImage.setImageResource(R.drawable.ic_100_frame);
//        bikeView.addView(frameImage);
//
//        crankImage = new ImageView(this);
//        crankImage.setImageResource(R.drawable.ic_100_crank);
//        bikeView.addView(crankImage);
//
//        rearWheelImage = new ImageView(this);
//        rearWheelImage.setImageResource(R.drawable.ic_100_rear_wheel);
//        bikeView.addView(rearWheelImage);
//
//        saddleImage = new ImageView(this);
//        saddleImage.setImageResource(R.drawable.ic_100_saddle);
//        bikeView.addView(saddleImage);

        gridView = findViewById(R.id.grid_view);
        constants.setGridView(gridView);

        gridView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                buildGrid();
                gridImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                TileManager tileManager = new TileManager(constants);
                tileManager.initGame();
                tileManager.drawAllTiles();
            }
        });


    }

    private void buildGrid() {
        // grid view width & height
        gridViewHeight = gridView.getHeight();
        gridViewWidth = gridView.getWidth();

        // grid image width & height
        if(gridViewHeight<gridViewWidth){
            gridImageSize = gridViewHeight;
        } else {
            gridImageSize = gridViewWidth;
        }

        // grid image X & Y
        gridImageX = (gridViewWidth - gridImageSize) / 2;
        constants.setGridImageX(gridImageX);
        gridImageY = 0;
        constants.setGridImageY(gridImageY);

        // grid scale
        gridImageScale = (float) gridImageSize / gridSVGSize;

        // draw
        gridImage = new ImageView(this);
        gridImage.setImageResource(R.drawable.ic_grid_padding_5_10);
        gridImage.setX(gridImageX);
        gridImage.setY(gridImageY);
        gridView.addView(gridImage, gridImageSize, gridImageSize);

        // tile
        tilePadding = Math.round(gridSVGPadding * gridImageScale);
        constants.setTilePadding(tilePadding);
        tileImageSize = Math.round(gridSVGTileSize * gridImageScale) + tilePadding*2;
        constants.setTileImageSize(tileImageSize);
    }

}
