package studio.cyclingbits.byob2048;

import android.content.Context;
import android.widget.FrameLayout;

import java.util.HashMap;

public class RuntimeConstants {

    private Context context;
    private HashMap<Integer, Integer> drawables;
    private FrameLayout gridView;
    private int gridImageX;
    private int gridImageY;
    private int tileImageSize;
    private int tilePadding;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public FrameLayout getGridView() {
        return gridView;
    }

    public void setGridView(FrameLayout gridView) {
        this.gridView = gridView;
    }

    public int getGridImageX() {
        return gridImageX;
    }

    public void setGridImageX(int gridImageX) {
        this.gridImageX = gridImageX;
    }

    public int getGridImageY() {
        return gridImageY;
    }

    public void setGridImageY(int gridImageY) {
        this.gridImageY = gridImageY;
    }

    public int getTileImageSize() {
        return tileImageSize;
    }

    public void setTileImageSize(int tileImageSize) {
        this.tileImageSize = tileImageSize;
    }

    public int getTilePadding() {
        return tilePadding;
    }

    public void setTilePadding(int tilePadding) {
        this.tilePadding = tilePadding;
    }

    public HashMap<Integer, Integer> getDrawables() {
        return drawables;
    }

    public void setDrawables(HashMap<Integer, Integer> drawables) {
        this.drawables = drawables;
    }

    public int getTileResourceId(int count) {
        return drawables.get(count);
    }
}
