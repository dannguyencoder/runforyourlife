package game.bases.actions;

import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;

import java.util.Vector;

/**
 * Created by Administrator on 8/1/2017.
 */
public class MoveByAction implements Action {

    private Vector2D velocity;

    public MoveByAction(Vector2D velocity, int countMax) {
        this.velocity = velocity;
        this.frameCounter = new FrameCounter(countMax);
    }

    private FrameCounter frameCounter;

    @Override
    public boolean run(GameObject gameObject) {
        if (frameCounter.run())
        {
            return true;
        }

        gameObject.position.addUp(velocity);

        return false;
    }

    @Override
    public void reset() {
        frameCounter.reset();
    }
}
