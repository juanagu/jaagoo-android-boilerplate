package co.jagu.presentation.ui.person.detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;

import javax.inject.Inject;

import butterknife.ButterKnife;
import co.jagu.presentation.R;
import co.jagu.presentation.model.PersonModel;
import co.jagu.presentation.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
@FragmentWithArgs
public class PersonDetailFragment extends BaseFragment implements PersonDetailView {

    /*--
    Fields
    --*/
    @Arg
    long mPersonId;

    @Inject
    PersonDetailViewModel mPersonDetailViewModel;
    /*--
    Constructor
    --*/

    public PersonDetailFragment() {
        // Required empty public constructor
    }

    /*--
    Lifecycle
    --*/

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPersonDetailViewModel.setPersonId(mPersonId);
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person_detail, container, false);
        //inject view components
        ButterKnife.bind(view);
        return view;
    }


    /*--
    Implementation of {@link PersonDetailView}
    --*/

    /**
     * Render a person in the UI
     *
     * @param personModel
     */
    @Override
    public void renderPerson(PersonModel personModel) {

    }
}
