package game.bases;

import game.bases.actions.Action;
import game.bases.physics.Physics;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.Renderer;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.List;

/**
 * Created by Administrator on 7/18/2017.
 */
public class GameObject {

    //Object pulling

    public Vector2D position; //Relative
    public Vector2D screenPosition; //Screen

    public boolean isActive;

    public Renderer renderer;

    public Vector<GameObject> children;
    public Vector<Action> actions;

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObjects = new Vector<>();
    private List<Action> newActions;


    public static void add (GameObject gameObject)
    {
        newGameObjects.add(gameObject);
        if (gameObject instanceof PhysicsBody)
        {
            Physics.add((PhysicsBody) gameObject);
        }
    }

    public static void renderAll(Graphics2D g2d)
    {
        for (GameObject gameObject : gameObjects)
        {
            if (gameObject.isActive)
                gameObject.render(g2d);
        }
    }

    public static void runAll()
    {
        for (GameObject gameObject : gameObjects)
        {
            if (gameObject.isActive)
                gameObject.run(Vector2D.ZERO);
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();

        for (int i = 0; i < gameObjects.size(); i++)
        {
            for (int j = i + 1; j < gameObjects.size(); j++)
            {
                GameObject gi = gameObjects.get(i);
                GameObject gj = gameObjects.get(j);
            }
        }
    }

    public static void runAllActions()
    {
        System.out.println(gameObjects.size());
        int i = 0;
        for (GameObject gameObject : gameObjects)
        {
            if (gameObject.isActive())
            {
                gameObject.runActions();
                i++;
            }
        }
        System.out.println(">>"+i);
    }

    public boolean isActive() {
        return isActive;
    }

    public GameObject()
    {
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.children = new Vector<>();
        this.isActive = true;
        this.actions = new Vector<>();
        this.newActions = new Vector<>();

    }

    public void render(Graphics2D g2d)
    {
        if (renderer != null) {
            renderer.render(g2d, this.position);
        }
    }

    public void run(Vector2D parentPosition)
    {
        //position => relative
        this.screenPosition = parentPosition.add(position);

        for (GameObject child : children)
        {
            child.run(this.screenPosition);
        }
    }

    void runActions()
    {
        Iterator<Action> iterator = actions.iterator();
        while (iterator.hasNext())
        {
            Action action = iterator.next();
            boolean actionDone = action.run(this);
            if (actionDone)
            {
                iterator.remove();
            }
        }

        actions.addAll(newActions);
        newActions.clear();
    }

    public void addAction(Action action)
    {
        newActions.add(action);
    }

    public void refresh()
    {
        isActive = true;
        this.actions.clear();
        this.newActions.clear();
    }

    public static void clear()
    {
        gameObjects.clear();
        GameObjectPool.clear();
        Physics.clear();
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
