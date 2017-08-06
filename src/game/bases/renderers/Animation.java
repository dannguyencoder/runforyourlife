package game.bases.renderers;

import game.bases.FrameCounter;
import game.bases.Vector2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.Arrays;

/**
 * Created by Administrator on 7/25/2017.
 */
public class Animation implements Renderer {

    private List<BufferedImage> images;
    private int imageIndex = 0;
    private FrameCounter frameCounter;
    private boolean finished;
    private boolean repeat;

    public boolean isFinished() {
        return finished;
    }

    public Animation(int delayFrame, boolean repeat, BufferedImage... imagesArr)
    {
        this.images = Arrays.asList(imagesArr);
        frameCounter = new FrameCounter(delayFrame);
        this.repeat = repeat;
    }

    public Animation(BufferedImage... imageArr)
    {
        this(3, true, imageArr);
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        if (frameCounter.run())
        {
            changeIndex();
            frameCounter.reset();
        }

        BufferedImage image = images.get(imageIndex);
        g.drawImage(image, (int) position.x - image.getWidth()/2, (int) position.y - image.getHeight()/2, null);
    }

    private void changeIndex() {

        if (imageIndex >= images.size() - 1)
        {
            if (repeat) {
                imageIndex = 0;
            }
            finished = true;
        } else
        {
            imageIndex++;
        }
    }

    public void reset()
    {
        imageIndex = 0;
        finished = false;
    }
}
