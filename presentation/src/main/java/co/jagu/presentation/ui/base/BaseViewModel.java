package co.jagu.presentation.ui.base;

import android.arch.lifecycle.ViewModel;

public class BaseViewModel<T extends BaseView> extends ViewModel
        implements co.jagu.presentation.ui.base.ViewModel<T> {

    /*--
    Fields
    --*/

    private T mView;


    /*--
    Implementation of {@link co.jagu.presentation.ui.base.ViewModel}
    --*/

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }
}
