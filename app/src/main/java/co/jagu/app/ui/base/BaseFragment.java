package co.jagu.app.ui.base;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hannesdorfmann.fragmentargs.FragmentArgs;

/**
 * Created by juanagu on 9/8/17.
 */

public abstract class BaseFragment<Params> extends Fragment {

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

    /**
     * create a new instance of the fragment
     *
     * @param params
     * @return
     */
    abstract Fragment newInstance(Params params);

}
