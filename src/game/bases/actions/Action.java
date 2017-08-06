package game.bases.actions;

import game.bases.GameObject;

/**
 * Created by Administrator on 8/1/2017.
 */
public interface Action {
    boolean run(GameObject gameObject);
    void reset();
}
