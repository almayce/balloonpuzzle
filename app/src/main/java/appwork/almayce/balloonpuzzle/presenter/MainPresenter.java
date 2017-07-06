package appwork.almayce.balloonpuzzle.presenter;

import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import appwork.almayce.balloonpuzzle.App;
import appwork.almayce.balloonpuzzle.SchedulersTransformer;
import appwork.almayce.balloonpuzzle.view.MainView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by almayce on 08.06.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Disposable disposable;

    public void onItemClick(View v) {
        App.isCancelled = false;
        App.isDone = false;
        ImageView imageView = (ImageView) v;
        String name = imageView.getContentDescription().toString();
        getViewState().startCharActivity(name);
        disposable = Observable.interval(1, TimeUnit.MILLISECONDS)
                .compose(new SchedulersTransformer<>())
                .subscribe(aLong -> {
                    if (aLong == 1)
                        playSound("voice_balls");
                    if (aLong == 6400)
                        playSound(name);
                    if (App.isCancelled || App.isDone || aLong > 7000)
                        disposable.dispose();
                });
    }

    public void playSound(String name) {
        App.playSound(name);
    }

    public void stopSound() {
        App.stopSound();
    }
}
