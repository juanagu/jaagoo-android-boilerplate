package co.jagu.presentation.ui.base;

public interface ViewModel<T extends BaseView> {

    void attachView(T view);

    boolean isViewAttached();
}
