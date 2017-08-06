package game.scenes;

import game.Utils;
import game.bases.GameObject;
import game.bases.renderers.ImageRenderer;
import game.inputs.InputListener;
import game.inputs.InputManager;

import javax.rmi.CORBA.Util;

/**
 * Created by Administrator on 8/1/2017.
 */
public class MenuScene extends Scene implements InputListener {

    @Override
    public void init() {
        GameObject introImage = new GameObject();
        introImage.renderer = new ImageRenderer(Utils.loadAssetImage("scenes/menu.png"));
        introImage.position.set(Settings.GAMEPLAY_WIDTH / 2, Settings.GAMEPLAY_HEIGHT / 2);

        GameObject.add(introImage);

        InputManager.instance.register(this);
    }

    @Override
    public boolean onKeyPress(int keyCode) {
        SceneManager.instance.requestChangeScene(new Level1Scene());
        return false;
    }

    @Override
    public boolean onKeyReleased(int keyCode) {
        SceneManager.instance.requestChangeScene(new Level1Scene());
        return true; //Request delete
    }

//    @Override
//    public void deInit() {
//
//        super.deInit();
//        InputManager.instance.unregister(this);
//    }
}
