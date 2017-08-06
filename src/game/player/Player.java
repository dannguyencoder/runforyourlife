package game.player;

import game.Utils;
import game.bases.*;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physics;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.ImageRenderer;
import game.inputs.InputManager;
import game.objects.Platform;

import java.util.LinkedList;

/**
 * Created by NHEM on 11/07/2017.
 */
public class Player extends GameObject{

    //Properties: Thuoc tinh
    Constraints constraints;
    private BoxCollider boxCollider;

    InputManager inputManager;

    FrameCounter coolDownCounter;
    boolean spellDisabled;

    private float gravity = 2f;
    private PlayerAnimator animator;

    public static Player instance;

    Vector2D velocity;
    FrameCounter velocityCounter = new FrameCounter(17);

    public boolean jumping = false;
    public boolean falling = true;

    public Player(){
        this.velocity = new Vector2D();
        this.coolDownCounter = new FrameCounter(15); // 17 = 300 miliseconds to cooldown
        animator = new PlayerAnimator();
        this.renderer = animator;
        this.boxCollider = new BoxCollider(30, 30);
        this.children.add(boxCollider);

        instance = this;
    }



    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        animate();
        move();
        castSpell();
        coolDown();
    }

    private void animate() {
        animator.run(this);
    }

    private void castSpell() {
        if (inputManager.xPressed && !spellDisabled)
        {
            PlayerSpell playerSpell = GameObjectPool.recycle(PlayerSpell.class);
            playerSpell.position.set(this.position.add(0, -20));
            spellDisabled = true;
        }
    }

    private void move() {
        this.velocity.set(0, 0);

        this.velocity.y += gravity;
        this.velocity.x = 0;

        if (InputManager.instance.leftPressed)
            this.velocity.x -= 5;
        if (InputManager.instance.rightPressed)
            this.velocity.x += 5;
        if (InputManager.instance.upPressed)
            if (Physics.bodyInRect(position.add(0, 1), boxCollider.width, boxCollider.height, Platform.class) != null) {
                this.velocity.y = -90;
            }


        moveVertical();
        moveHorizontal();

        this.position.addUp(velocity);
    }

    private void jump()
    {
        if (jumping == true)
        {
            this.velocity.y += gravity;
        }
    }

    private void moveHorizontal()
    {
        float deltaX = velocity.x > 0 ? 1: -1;
        PhysicsBody body = Physics.bodyInRect(position.add(velocity.x, 0), boxCollider.width, boxCollider.height, Platform.class);

        if (body != null)
        {
            while (Physics.bodyInRect(position.add(deltaX, 0), boxCollider.width, boxCollider.height, Platform.class) == null)
            {
                position.addUp(deltaX, 0);
            }
            this.velocity.x = 0;
        }
    }

    private void moveVertical()
    {
        float deltaY = velocity.y > 0 ? 1: -1;
        PhysicsBody body = Physics.bodyInRect(position.add(0, velocity.y), boxCollider.width, boxCollider.height, Platform.class);
        if (body != null) {
            while(Physics.bodyInRect(position.add(0, deltaY), boxCollider.width, boxCollider.height, Platform.class) == null) {
                position.addUp(0, deltaY);
            }
            this.velocity.y = 0;
        }
    }

    public void coolDown() {
        //cooldown
        if (spellDisabled){
            boolean status = coolDownCounter.run();
            if (status) {
                spellDisabled = false;
                coolDownCounter.reset();
            }
        }
    }

    //setter
    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    public void setInputManager(InputManager inputManager)
    {
        this.inputManager = inputManager;
    }
}
