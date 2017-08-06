package game.bases;

/**
 * Created by Administrator on 7/16/2017.
 */
public class Constraints {
    float top;
    float bottom;
    float left;
    float right;

    public Constraints(float top, float bottom, float left, float right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public void make(Vector2D position)
    {
        position.x = Mathx.clamp(position.x, left, right);
        position.y = Mathx.clamp(position.y, top, bottom);
    }
}
