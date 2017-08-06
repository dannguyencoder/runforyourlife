package game.enemies;

import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.GameObjectPool;
import game.bases.Vector2D;
import game.bases.actions.SequenceAction;
import game.bases.actions.WaitAction;
import game.enemies.shoot.EnemyShootAction;
import game.enemies.spawn.EnemySpawnAction;

/**
 * Created by Administrator on 7/18/2017.
 */
public class EnemySpawner extends GameObject {

    public EnemySpawner()
    {
        super();
        this.addAction(
                new SequenceAction(
                        new EnemySpawnAction(new Vector2D(10,10)),
                        new EnemySpawnAction(new Vector2D(174, 10)),
                        new WaitAction(3000/17),
                        new EnemySpawnAction(new Vector2D(10, 10)),
                        new EnemySpawnAction(new Vector2D(174, 10))
                )
        );
    }

}
