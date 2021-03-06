package appwork.almayce.balloonpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import appwork.almayce.balloonpuzzle.AdManager;
import appwork.almayce.balloonpuzzle.App;
import appwork.almayce.balloonpuzzle.R;
import appwork.almayce.balloonpuzzle.databinding.ActivityCharBinding;
import appwork.almayce.balloonpuzzle.presenter.CharPresenter;

/**
 * Created by almayce on 09.06.17.
 */

public class CharActivity extends MvpAppCompatActivity implements CharView {

    @InjectPresenter
    CharPresenter charPresenter;

    ActivityCharBinding binding;

    private InterstitialAd ad;

    private ImageView ivChar;
    private List<Integer> markers;
    private LinearLayout llPlayGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.hideSystemUI(getWindow());
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_char_11);
        String name = getIntent().getStringExtra("name");
//        llPlayGrid = new LinearLayout(getApplicationContext());
//        llPlayGrid = binding.llPlayGrid;

        markers = new ArrayList<>();
        int layoutId = R.layout.activity_char_11;
//
        switch (name) {
            case "А":
                layoutId = R.layout.activity_char_11;
                break;
            case "Ф":
                layoutId = R.layout.activity_char_12;
                break;
            case "Д":
                layoutId = R.layout.activity_char_13;
                break;
            case "З":
                layoutId = R.layout.activity_char_14;
                break;
            case "С":
                layoutId = R.layout.activity_char_15;
                break;
            case "Е":
                layoutId = R.layout.activity_char_16;
                break;
            case "Ж":
                layoutId = R.layout.activity_char_17;
                break;
            case "Ь":
                layoutId = R.layout.activity_char_18;
                break;
            case "Ъ":
                layoutId = R.layout.activity_char_19;
                break;

            case "У":
                layoutId = R.layout.activity_char_21;
                break;
            case "В":
                layoutId = R.layout.activity_char_22;
                break;
            case "Т":
                layoutId = R.layout.activity_char_23;
                break;
            case "Х":
                layoutId = R.layout.activity_char_24;
                break;
            case "Л":
                layoutId = R.layout.activity_char_25;
                break;
            case "Я":
                layoutId = R.layout.activity_char_26;
                break;
            case "Ё":
                layoutId = R.layout.activity_char_27;
                break;
            case "Щ":
                layoutId = R.layout.activity_char_28;
                break;

            case "М":
                layoutId = R.layout.activity_char_31;
                break;
            case "О":
                layoutId = R.layout.activity_char_32;
                break;
            case "Н":
                layoutId = R.layout.activity_char_33;
                break;
            case "Ы":
                layoutId = R.layout.activity_char_34;
                break;
            case "Р":
                layoutId = R.layout.activity_char_35;
                break;
            case "Э":
                layoutId = R.layout.activity_char_36;
                break;
            case "Ч":
                layoutId = R.layout.activity_char_37;
                break;
            case "Ш":
                layoutId = R.layout.activity_char_38;
                break;

            case "П":
                layoutId = R.layout.activity_char_41;
                break;
            case "Б":
                layoutId = R.layout.activity_char_42;
                break;
            case "Г":
                layoutId = R.layout.activity_char_43;
                break;
            case "К":
                layoutId = R.layout.activity_char_44;
                break;
            case "И":
                layoutId = R.layout.activity_char_45;
                break;
            case "Й":
                layoutId = R.layout.activity_char_46;
                break;
            case "Ю":
                layoutId = R.layout.activity_char_47;
                break;
            case "Ц":
                layoutId = R.layout.activity_char_48;
                break;
        }
        setContentView(layoutId);
//        findViewById(R.id.iv1).setOnTouchListener(onTouchListener);
//        findViewById(R.id.iv2).setOnTouchListener(onTouchListener);
//        findViewById(R.id.iv3).setOnTouchListener(onTouchListener);
//        findViewById(R.id.iv4).setOnTouchListener(onTouchListener);
//        findViewById(R.id.iv5).setOnTouchListener(onTouchListener);
//        ivChar = (ImageView) findViewById(R.id.ivChar);


//        ImageView ivMarkers = (ImageView) findViewById(R.id.ivMarkers);
//        Bitmap bitmap = ((BitmapDrawable) ivMarkers.getDrawable()).getBitmap();


        charPresenter.addMarkers(name);
        initAd();

        com.google.android.gms.ads.AdView adView = (AdView) findViewById(R.id.adView);
        adView.setVisibility(AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) ? View.VISIBLE : View.INVISIBLE);
        adView.loadAd(new AdRequest.Builder().build());

        findViewById(R.id.ivExit).setOnClickListener(v -> {
            charPresenter.onClickExit();
            findViewById(R.id.ivExit).setOnClickListener(null);
        });
    }

    private void initAd() {
        ad = new InterstitialAd(getApplicationContext());
        ad.setAdUnitId(getString(R.string.inter_ad_unit_id));
        ad.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        ad.loadAd(new AdRequest.Builder().build());
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        float startX;
        float startY;

        float tolerance = 100F;
        float dX, dY;

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            boolean doneX = false;
            boolean doneY = false;

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:
                    startX = view.getX();
                    startY = view.getY();
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    view.setX(event.getRawX() + dX);
                    view.setY(event.getRawY() + dY);
                    break;

                case MotionEvent.ACTION_UP:

                    float x = view.getX() + view.getWidth() / 2;
                    float y = view.getY() + view.getHeight() / 2;


                    for (int o = 0; o < markers.size(); o++) {
                        ImageView marker = (ImageView) findViewById(markers.get(o));
                        float correctX = marker.getX() + marker.getWidth() / 2;
                        float correctY = marker.getY() + marker.getHeight() / 2;

                        System.out.println(x + " " + correctX);
                        System.out.println(y + " " + correctY);


                        if (x > correctX - tolerance && x < correctX + tolerance)
                            doneX = true;
                        if (y > correctY - tolerance && y < correctY + tolerance)
                            doneY = true;

                        if (doneX && doneY) {

                            view.setX(correctX - view.getWidth() / 2);
                            view.setY(correctY - view.getHeight() / 2);

                            charPresenter.playSound("correctly");
                            view.setOnTouchListener(null);
                            markers.remove(o);
//
                            if (markers.size() == 0) {
                                App.getProgressManagerInstance().saveProgress(getIntent().getStringExtra("name"));
                                charPresenter.onDone();
                            }
                            break;

                        } else if (o == markers.size() - 1) {
                            charPresenter.playSound("wrong");
                            view.setX(startX);
                            view.setY(startY);
                        }
                    }


                default:
                    return false;
            }
            return true;
        }
    };

    @Override
    public void restartActivity() {
        Intent i = new Intent(this, this.getClass());
        i.putExtra("name", getIntent().getStringExtra("name"));
        finish();
        this.startActivity(i);
    }

    @Override
    public void backToMainActivity() {
        charPresenter.playSound("neutral");
        showAd();
    }

    @Override
    public void addMarker(int id) {
        markers.add(id);
    }

    @Override
    public void showBall(int ballId) {
        ImageView ivBall = (ImageView) findViewById(ballId);
        ivBall.setVisibility(View.VISIBLE);
        ivBall.setOnTouchListener(onTouchListener);
    }

    public void showAd() {
        if (AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) && ad.isLoaded())
            ad.show();
        else startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onBackPressed() {
    }
}
