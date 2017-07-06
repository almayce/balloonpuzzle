package appwork.almayce.balloonpuzzle.model.item;

import java.util.ArrayList;
import java.util.List;

import appwork.almayce.balloonpuzzle.R;

/**
 * Created by almayce on 04.07.17.
 */

public class Balls {
    private List<Integer> balls;

    public Balls() {
        balls = new ArrayList<>();
        init();
    }

    public List<Integer> getBalls() {
        return balls;
    }

    private void init() {
        balls.add(R.id.b1);
        balls.add(R.id.b2);
        balls.add(R.id.b3);
        balls.add(R.id.b4);
        balls.add(R.id.b5);
        balls.add(R.id.b6);
        balls.add(R.id.b7);
        balls.add(R.id.b8);
        balls.add(R.id.b9);
        balls.add(R.id.b10);
        balls.add(R.id.b11);
        balls.add(R.id.b12);
        balls.add(R.id.b13);
        balls.add(R.id.b14);
        balls.add(R.id.b15);
        balls.add(R.id.b16);
        balls.add(R.id.b17);
        balls.add(R.id.b18);
        balls.add(R.id.b19);
        balls.add(R.id.b20);
        balls.add(R.id.b21);
        balls.add(R.id.b22);
        balls.add(R.id.b23);
    }
}
