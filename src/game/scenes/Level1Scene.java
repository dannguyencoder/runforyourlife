package game.scenes;

import game.bases.Constraints;
import game.bases.GameObject;
import game.enemies.Enemy;
import game.enemies.EnemySpawner;
import game.inputs.InputManager;
import game.objects.Platform;
import game.player.Player;

/**
 * Created by Administrator on 8/1/2017.
 */
public class Level1Scene extends Scene {
    Background background;

    @Override
    public void init() {
        addBackground();
        addPlayer();
        addPlatforms();
//        addEnemySpawner();
    }

    private void addBackground() {
        background = new Background();
        background.position.y = Settings.WINDOW_HEIGHT;
        GameObject.add(background);
    }

    private void addPlatforms()
    {
        for (int i = 0, platformX = 0; i < 20; i++, platformX+=10)
        {
            Platform platform = new Platform();
            platform.position.set(platformX, 600);
            GameObject.add(platform);
        }

        addPlatform(130, 600 - 30);
        addPlatform(130, 600 - 30*2);
    }

    private void addPlatform(int x, int y) {
        Platform platform = new Platform();
        platform.position.set(x, y);
        GameObject.add(platform);
    }

    private void addPlayer() {
        Player player = new Player();
        player.setConstraints(new Constraints(20,Settings.WINDOW_HEIGHT, 0, background.getWidth()));
        player.setInputManager(InputManager.instance);
        player.position.set(384 / 2, Settings.WINDOW_HEIGHT -  50);

        Player.instance = player;
        GameObject.add(player);
    }

    private void addEnemySpawner() {
        Enemy enemy = new Enemy();
        enemy.position.set(background.getWidth() / 2, 0);
        GameObject.add(enemy);
        GameObject.add(new EnemySpawner());
    }
}
