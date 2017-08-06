package game.objects;

import game.Utils;
import game.bases.GameObject;
import game.bases.physics.BoxCollider;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.Animation;

/**
 * Created by Administrator on 8/3/2017.
 */
public class Rocket extends GameObject implements PhysicsBody {

    BoxCollider boxCollider;

    public Rocket()
    {
        super();
        this.renderer = new Animation(
                Utils.loadAssetImage("bothpowerup/rocket.png")
        );
        this.boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
