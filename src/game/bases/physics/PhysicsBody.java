package game.bases.physics;

/**
 * Created by Administrator on 7/25/2017.
 */
public interface PhysicsBody {
    BoxCollider getBoxCollider();
    boolean isActive();
}
