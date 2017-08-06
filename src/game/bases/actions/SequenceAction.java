package game.bases.actions;

import game.bases.GameObject;

import java.util.List;
import java.util.Arrays;

/**
 * Created by Administrator on 8/1/2017.
 */
public class SequenceAction implements Action {

    List<Action> actions;
    private int currentActionIndex;

    public SequenceAction(Action... actions)
    {
        this.actions = Arrays.asList(actions);
        currentActionIndex = 0;
    }

    @Override
    public boolean run(GameObject gameObject) {

        if (currentActionIndex >= actions.size())
        {
            return true;
        }

        Action currentAction = actions.get(currentActionIndex);
        if (currentAction.run(gameObject))
        {
            currentActionIndex++;

        }

        return false;
    }

    @Override
    public void reset() {
        currentActionIndex = 0;
        for (Action action : actions)
        {
            action.reset();
        }
    }
}
