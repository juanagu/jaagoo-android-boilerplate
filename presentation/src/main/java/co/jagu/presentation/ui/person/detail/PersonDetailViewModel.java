package co.jagu.presentation.ui.person.detail;

import javax.inject.Inject;

import co.jagu.domain.interactor.person.GetPersonDetail;
import co.jagu.presentation.model.PersonModel;
import co.jagu.presentation.ui.base.BaseViewModel;


public class PersonDetailViewModel extends BaseViewModel {

    /*--
    Dependency
    --*/
    private GetPersonDetail mGetPersonDetail;
    /*--
    Fields
    --*/


    /*--
    Constructor
    --*/
    @Inject
    public PersonDetailViewModel(GetPersonDetail getPersonDetail) {
        this.mGetPersonDetail = getPersonDetail;
    }

    /*--
    Setter
    -- */
    public void setPersonId(long personId) {
        mGetPersonDetail.buildUseCaseObservable(GetPersonDetail.Params.forPerson(personId));
    }
}
