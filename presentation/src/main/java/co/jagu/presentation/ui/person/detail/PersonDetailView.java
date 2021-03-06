package co.jagu.presentation.ui.person.detail;


import co.jagu.presentation.model.PersonModel;
import co.jagu.presentation.ui.base.BaseView;

/**
 * Interface representing a View in a Model-View-ViewModel (MVVM) pattern.
 * In this case is a used as view representing a person detail.
 */
public interface PersonDetailView extends BaseView {

    /**
     * Render a person in the UI
     *
     * @param personModel
     */
    void renderPerson(PersonModel personModel);
}
