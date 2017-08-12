package co.jagu.presentation.injection.module;

import android.app.Activity;
import android.content.Context;

import co.jagu.presentation.injection.ActivityContext;
import co.jagu.presentation.ui.base.BaseActivity;
import dagger.Module;
import dagger.Provides;


@Module
public class BaseActivityModule {

    /*--
    fields
    -- */
    private BaseActivity mBaseActivity;

    /*--
    constructors
    -- */
    public BaseActivityModule(BaseActivity baseActivity) {
        mBaseActivity = baseActivity;
    }

    /*--
    provides
    -- */
    @Provides
    Activity provideActivity() {
        return mBaseActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mBaseActivity;
    }
}
