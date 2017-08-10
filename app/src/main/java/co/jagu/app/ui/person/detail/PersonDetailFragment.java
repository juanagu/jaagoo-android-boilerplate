package co.jagu.app.ui.person.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.base.Preconditions;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import co.jagu.app.R;
import co.jagu.app.model.PersonModel;
import co.jagu.app.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
@FragmentWithArgs
public class PersonDetailFragment extends BaseFragment {

    /*--
    Fields
    --*/
    @Arg
    PersonModel mPersonModel;

    /*--
    Constructor
     */

    public PersonDetailFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_detail, container, false);
    }


}
