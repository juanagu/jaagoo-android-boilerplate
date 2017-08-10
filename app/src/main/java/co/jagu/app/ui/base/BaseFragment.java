package co.jagu.app.ui.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hannesdorfmann.fragmentargs.FragmentArgs;

/**
 * Created by juanagu on 9/8/17.
 */

public abstract class BaseFragment extends Fragment {

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

}
