package appwork.almayce.balloonpuzzle.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 11.06.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ParentView extends MvpView {
}
