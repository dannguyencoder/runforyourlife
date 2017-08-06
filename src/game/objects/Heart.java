package game.objects;

import game.Utils;
import game.bases.GameObject;
import game.bases.physics.BoxCollider;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.Animation;

/**
 * Created by Administrator on 8/3/2017.
 */
public class Heart extends GameObject implements PhysicsBody {

    BoxCollider boxCollider;

    public Heart()
    {
        super();
        this.renderer = new Animation(
                Utils.loadAssetImage("girl-powerup/heart 1-01.png")
        );
        this.boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
