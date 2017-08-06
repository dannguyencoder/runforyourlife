package game.scenes;

import game.bases.GameObject;

/**
 * Created by Administrator on 8/1/2017.
 */
public abstract class Scene {
    public abstract void init(); //initialize
    public void deInit()
    {
        GameObject.clear();
    }//de-initialize
}
