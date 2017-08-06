package game.objects;

import game.Utils;
import game.bases.GameObject;
import game.bases.physics.BoxCollider;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.ImageRenderer;

/**
 * Created by Administrator on 8/4/2017.
 */
public class Platform extends GameObject implements PhysicsBody {

    private BoxCollider boxCollider;

    public Platform()
    {
        super();
        this.renderer = new ImageRenderer(Utils.loadAssetImage("yellow_square.jpg"));
        this.boxCollider = new BoxCollider(60, 60);
        this.children.add(boxCollider);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
