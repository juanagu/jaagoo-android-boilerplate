package co.jagu.presentation.ui.base;

import android.arch.lifecycle.LifecycleActivity;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Abstract activity that every other Activity in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent survive
 * across configuration changes.
 */
public abstract class BaseActivity extends LifecycleActivity {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";


    protected final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onStop() {
        super.onStop();
        // clear all the subscriptions
        mDisposable.clear();
    }

}
