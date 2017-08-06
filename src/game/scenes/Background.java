package game.scenes;

import game.Utils;
import game.bases.GameObject;
import game.bases.physics.BoxCollider;
import game.bases.renderers.ImageRenderer;
import game.bases.Vector2D;

import javax.swing.*;

/**
 * Created by Administrator on 7/23/2017.
 */
public class Background extends GameObject {

    private ImageRenderer imageRenderer;
    public static Background instance;

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public void setBoxCollider(BoxCollider boxCollider) {
        this.boxCollider = boxCollider;
    }

    private BoxCollider boxCollider;

    public Background()
    {
        super();
        instance = this;
        imageRenderer = new ImageRenderer(Utils.loadAssetImage("background/background_duongpho.png"));
        imageRenderer.anchor.set(0,1);

        this.renderer = imageRenderer;

        this.boxCollider = new BoxCollider(684, 1200);
        System.out.println(boxCollider);


    }

    @Override
    public void run(Vector2D parentPosition) {
        if (this.position.y - imageRenderer.getHeight() < 0) {
            this.position.addUp(0, 1);
        }

    }

    public float getWidth()
    {
        return this.imageRenderer.getWidth();
    }

    public float getHeight()
    {
        return this.imageRenderer.getHeight();
    }
}
