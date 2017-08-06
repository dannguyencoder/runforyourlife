package game.enemies.shoot;

import game.bases.GameObject;
import game.bases.GameObjectPool;
import game.bases.Vector2D;
import game.bases.actions.Action;
import game.enemies.Enemy;
import game.enemies.EnemyBullet;
import game.player.Player;

/**
 * Created by Administrator on 8/1/2017.
 */
public class EnemyShootAction implements Action {
    @Override
    public boolean run(GameObject gameObject) {
        Enemy enemy = (Enemy) gameObject;
        Vector2D target = Player.instance.position;

        Vector2D bulletVelocity = target.substract(enemy.position)
                .normalize()
                .multiply(4);

        EnemyBullet enemyBullet = GameObjectPool.recycle(EnemyBullet.class);
        enemyBullet.config(bulletVelocity);
        enemyBullet.position.set(enemy.position);
        return true;
    }

    @Override
    public void reset() {

    }
}
