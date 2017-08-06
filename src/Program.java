/**
 * Created by NHEM on 09/07/2017.
 */

import game.GameWindow;
import game.bases.physics.BoxCollider;
import game.scenes.Scene;

public class Program {
    public static void main(String[] args) {

        BoxCollider b1 = new BoxCollider(10, 20);
        BoxCollider b2 = new BoxCollider(20, 10);

        b1.position.addUp(30, 0);

//        ArrayList<Base> all = new ArrayList<>();
//
//        all.add(new Base());
//        all.add(new A());
//        all.add(new B());
//        all.add(new A());
//
//        for (Base base : all)
//        {
//            base.doSmt();
//        }
//
//        Base base = new Base();
//        base.doSmt();
//
//        A a = new A();
//        a.doSmt();
//
//        Base b2 = a;
//        b2.doSmt();

//        Base b = new Base();
//        A a = new A();
//
//        System.out.println(a.getClass());
//
//        Base c = a;
//
//        System.out.println(c.getClass() == A.class);
//
//        doSomething(b);
//        doSomething(a);

        // GameWindow
        GameWindow gameWindow = new GameWindow();
        gameWindow.loop();
    }

//    public static void doSomething(Base b)
//    {
//        System.out.println("hahaaha");
//        b.doSmt();
//    }
//
//    public static void doSomething(A a)
//    {
//        System.out.println("haahaha");
//        a.doSmt();
//    }
//
//    public static <T extends Base> void doSomething(T t)
//    {
//        t.doSmt();
//    }
}
