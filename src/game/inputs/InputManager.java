package game.inputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Administrator on 7/18/2017.
 */
public class InputManager {
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean upPressed;
    public boolean downPressed;
    public boolean xPressed;

    public static final InputManager instance = new InputManager();

    //final la de tranh viec co thang vao nghich Inputmanager.instance = null; Java rat chat, chi co minh lam cho no long ra thoi, chu khong co minh lam cho no chat lai

    private List<InputListener> inputListeners;

    public void register(InputListener inputListener) {
        inputListeners.add(inputListener);
    }

    public void unregister(InputListener inputListener)
    {
        inputListeners.remove(inputListener);
    }

    private InputManager()
    {
        inputListeners = new ArrayList<>();
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_X:
                xPressed = true;
                break;
        }

        for (InputListener inputListener : inputListeners)
        {
            inputListener.onKeyPress(keyEvent.getKeyCode());
        }

    }

    public void keyReleased(KeyEvent keyEvent)
    {
        switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_X:
                xPressed = false;
                break;
        }

        Iterator<InputListener> iterator = inputListeners.iterator();
        while (iterator.hasNext())
        {
            InputListener inputListener = iterator.next();
            if (inputListener.onKeyReleased(keyEvent.getKeyCode()))
            {
                iterator.remove();
            }
        }
    }
}
