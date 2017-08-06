package game.enemies;

import game.Utils;
import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.actions.MoveByAction;
import game.bases.actions.SequenceAction;
import game.bases.actions.WaitAction;
import game.bases.physics.BoxCollider;
import game.bases.renderers.ImageRenderer;
import game.bases.Vector2D;
import game.scenes.Background;

/**
 * Created by Administrator on 7/23/2017.
 */
public class EnemyBullet extends GameObject {

    BoxCollider boxCollider;


    public EnemyBullet() {

        super();

        this.boxCollider = new BoxCollider(20, 20);
        this.children.add(boxCollider);
        this.renderer = new ImageRenderer(Utils.loadAssetImage("enemies/bullets/white.png"));
    }

    public void config(Vector2D velocity)
    {
        this.addAction(
                new SequenceAction(
                        new MoveByAction(velocity.multiply(2), 5),
                        new WaitAction(1),
                        new MoveByAction(velocity, 9999)
                )
        );
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (!this.boxCollider.collideWith(Background.instance.getBoxCollider()))
        {
            this.isActive = false;
        }
    }
}
