package co.jagu.presentation.ui.base;


import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hannesdorfmann.fragmentargs.FragmentArgs;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by juanagu on 9/8/17.
 */

public abstract class BaseFragment extends LifecycleFragment {
    /*--
    Fields
     --*/
    protected final CompositeDisposable mDisposable = new CompositeDisposable();

    /*--
    Lifecycle
    -- */

    /**
     * override on create
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //read args fields
        FragmentArgs.inject(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        // clear all the subscriptions
        mDisposable.clear();
    }

}
