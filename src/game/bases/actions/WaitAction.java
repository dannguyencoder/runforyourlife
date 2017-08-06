package game.bases.actions;

import game.bases.FrameCounter;
import game.bases.GameObject;
import jdk.internal.org.objectweb.asm.tree.FrameNode;

/**
 * Created by Administrator on 8/1/2017.
 */
public class WaitAction implements Action{

    private FrameCounter frameCounter;

    public WaitAction(int countMax)
    {
        frameCounter = new FrameCounter(countMax);
    }

    @Override
    public boolean run(GameObject gameObject) {
        return frameCounter.run();
    }

    @Override
    public void reset() {
        frameCounter.reset();
    }
}
