package game;

import game.bases.GameObject;
import game.inputs.InputManager;
import game.scenes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by NHEM on 09/07/2017.
 */
public class GameWindow extends JFrame {

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;



//    Player player = new Player();
//    ArrayList <PlayerSpell> playerSpells = new ArrayList<>();

    InputManager inputManager = InputManager.instance;

    Scene startupScene;

    public GameWindow() {
        setupWindow();
        setupBackBuffer();

//        Contraints contraints = new Contraints(20, this.getHeight(), 0, background.getWidth());
//        player.setConstraints(contraints);
//        player.position.set(background.getWidth() / 2, this.getHeight() - 50);

        setupInput();
        setupStartupScene();

        this.setVisible(true);
    }

    private void setupStartupScene() {
        startupScene = new MenuScene();
        startupScene.init();
    }

    private void setupBackBuffer() {
        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }
        });
    }

    long lastUpdateTime;
    public void loop() {
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastUpdateTime > 17) {
                lastUpdateTime = currentTime;
                run();
                render();
            }
        }
    }

    public void run() {
        GameObject.runAll();
        GameObject.runAllActions();
        //Change scene
        SceneManager.instance.changeSceneIfNeeded();
    }

    public void render() {
        backBufferGraphics2D.setColor(Color.BLACK);
        backBufferGraphics2D.fillRect(0, 0 ,this.getWidth(), this.getHeight());

        GameObject.renderAll(backBufferGraphics2D);

        Graphics2D g2d = (Graphics2D)this.getGraphics();

        g2d.drawImage(backBufferImage, 0, 0, null);
    }

    private void setupWindow() {
        this.setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
        this.setResizable(true);
        this.setTitle("Tohou - Remade by Nhem");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //System.out.println("Closing");
                System.exit(0);
                //super.windowClosing(e);
            }
        });
    }

}
