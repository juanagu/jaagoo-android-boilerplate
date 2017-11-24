package co.jagu.presentation.ui.person.detail;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
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
import co.jagu.presentation.binding.FragmentDataBindingComponent;
import co.jagu.presentation.ui.base.BaseFragment;
import co.jagu.presentation.util.AutoClearedValue;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
@FragmentWithArgs
public class PersonDetailFragment extends BaseFragment {

    /*--
    Dependency
    -- */
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    /*--
    Fields
    --*/
    @Arg
    long mPersonId;

    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    private AutoClearedValue<ViewDataBinding> binding;
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

    }


    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout
                        .fragment_person_detail,
                container, false, dataBindingComponent);
        binding = new AutoClearedValue<>(this, dataBinding);
        View view = dataBinding.getRoot();
        //inject view components
        ButterKnife.bind(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        PersonDetailViewModel personDetailViewModel = ViewModelProviders
                .of(this, viewModelFactory).get(PersonDetailViewModel.class);

        personDetailViewModel.setPersonId(mPersonId);

        //personDetailViewModel.getPerson().subscribe(p -> binding.get().setVariable()});
    }
}
