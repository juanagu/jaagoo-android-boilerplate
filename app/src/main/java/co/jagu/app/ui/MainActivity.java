package co.jagu.app.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import co.jagu.app.R;
import co.jagu.app.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
