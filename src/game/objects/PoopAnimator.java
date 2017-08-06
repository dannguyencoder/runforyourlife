package game.objects;

import game.Utils;
import game.bases.Vector2D;
import game.bases.renderers.Animation;
import game.bases.renderers.Renderer;

import java.awt.*;

/**
 * Created by Administrator on 8/3/2017.
 */
public class PoopAnimator implements Renderer {

    private Animation poopAnimation;

    public PoopAnimator()
    {
        poopAnimation = new Animation(
                Utils.loadAssetImage("obstacles/poop-01.png")
        );
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        if (poopAnimation != null)
        {
            poopAnimation.render(g, position);
        }
    }
}
