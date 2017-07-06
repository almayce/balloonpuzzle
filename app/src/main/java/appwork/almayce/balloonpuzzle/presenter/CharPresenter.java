package appwork.almayce.balloonpuzzle.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import appwork.almayce.balloonpuzzle.App;
import appwork.almayce.balloonpuzzle.SchedulersTransformer;
import appwork.almayce.balloonpuzzle.model.item.Balls;
import appwork.almayce.balloonpuzzle.model.item.Markers;
import appwork.almayce.balloonpuzzle.view.CharView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by almayce on 09.06.17.
 */
@InjectViewState
public class CharPresenter extends MvpPresenter<CharView> {

    private Markers markers = new Markers();
    private Balls balls = new Balls();

    private Disposable disposable;

    public void onDone() {
        App.isDone = true;
        disposable = Observable.interval(1, TimeUnit.MILLISECONDS)
                .compose(new SchedulersTransformer<>())
                .subscribe(aLong -> {
                    if (aLong == 1)
                        App.playSound("well_done");
                    if (aLong == 1000)
                        App.playSound("well_done_voice1");
                    if (aLong == 2000)
                        App.playSound("try_again");
                    if (aLong == 2500)
                        getViewState().restartActivity();
                    if (App.isCancelled || aLong > 3000)
                        disposable.dispose();
                });
    }

    public void addMarkers(String name) {
        List<Integer> markersArray = markers.getMarkers(name);
        Observable.range(0, markersArray.size())
                .compose(new SchedulersTransformer<>())
                .subscribe(integer -> {
                    getViewState().addMarker(markersArray.get(integer));
                    getViewState().showBall(balls.getBalls().get(integer));
                });


    }

    public void playSound(String name) {
        App.playSound(name);
    }

    public void stopSound() {
        App.stopSound();
    }

    public void onClickExit() {
        App.stopSound();
        App.isCancelled = true;
        getViewState().backToMainActivity();
    }
}
