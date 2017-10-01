package co.jagu.presentation.ui;

import android.os.Bundle;

import co.jagu.presentation.R;
import co.jagu.presentation.ui.base.BaseActivity;
import co.jagu.presentation.ui.person.detail.PersonDetailFragment;
import co.jagu.presentation.ui.person.detail.PersonDetailFragmentBuilder;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonDetailFragmentBuilder.newPersonDetailFragment(1);
    }

}
