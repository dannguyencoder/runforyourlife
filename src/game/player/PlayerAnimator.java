package game.player;

import game.Utils;
import game.bases.Vector2D;
import game.bases.renderers.Animation;
import game.bases.renderers.Renderer;

import java.awt.*;

/**
 * Created by Administrator on 7/30/2017.
 */
public class PlayerAnimator implements Renderer{

    public Animation jumpLeftAnimation;
    public Animation jumpRightAnimation;
    public Animation leftAnimation;
    public Animation rightAnimation;
    public Animation straightAnimation;

    private Animation currenAnimation;

    public PlayerAnimator() {
        leftAnimation = new Animation(
                Utils.loadAssetImage("players/left/1.png"),
                Utils.loadAssetImage("players/left/2.png"),
                Utils.loadAssetImage("players/left/3.png"),
                Utils.loadAssetImage("players/left/4.png"),
                Utils.loadAssetImage("players/left/5.png"),
                Utils.loadAssetImage("players/left/6.png"),
                Utils.loadAssetImage("players/left/7.png"),
                Utils.loadAssetImage("players/left/8.png")
        );

        rightAnimation = new Animation(
                Utils.loadAssetImage("players/right/1.png"),
                Utils.loadAssetImage("players/right/2.png"),
                Utils.loadAssetImage("players/right/3.png"),
                Utils.loadAssetImage("players/right/4.png"),
                Utils.loadAssetImage("players/right/5.png"),
                Utils.loadAssetImage("players/right/6.png"),
                Utils.loadAssetImage("players/right/7.png"),
                Utils.loadAssetImage("players/right/8.png")
                );

        straightAnimation = new Animation(
                Utils.loadAssetImage("players/straight/0.png")
                );

        jumpRightAnimation = new Animation(
                Utils.loadAssetImage("players/right/5.png")
        );

        jumpLeftAnimation = new Animation(
                Utils.loadAssetImage("players/left/5.png")
        );
    }

    public void run(Player player)
    {
        if (player.velocity.x < 0)
        {
            currenAnimation = leftAnimation;
            if (player.velocity.y < 0)
            {
                currenAnimation = jumpLeftAnimation;
            }
        }
        else if (player.velocity.x > 0)
        {
            currenAnimation = rightAnimation;
            if (player.velocity.y < 0)
            {
                currenAnimation = jumpRightAnimation;
            }
        }
        else
        {
            currenAnimation = straightAnimation;
        }
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        if (currenAnimation != null)
        {
            currenAnimation.render(g, position);
        }
    }
}
