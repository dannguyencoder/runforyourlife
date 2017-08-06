package game.enemies.spawn;

import game.bases.GameObject;
import game.bases.GameObjectPool;
import game.bases.Vector2D;
import game.bases.actions.Action;
import game.enemies.Enemy;

/**
 * Created by Administrator on 8/1/2017.
 */
public class EnemySpawnAction implements Action {

    public Vector2D position;

    public EnemySpawnAction(Vector2D position)
    {
        this.position = position;
    }

    @Override
    public boolean run(GameObject gameObject) {
        Enemy enemy = GameObjectPool.recycle(Enemy.class);
        enemy.position.set(position);
        enemy.config();

        return true;
    }

    @Override
    public void reset() {

    }
}
