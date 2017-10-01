package co.jagu.presentation.ui.person.detail;

import javax.inject.Inject;

import co.jagu.domain.Person;
import co.jagu.domain.interactor.person.GetPersonDetail;
import co.jagu.presentation.ui.base.BaseViewModel;
import io.reactivex.Flowable;


public class PersonDetailViewModel extends BaseViewModel {

    /*--
    Dependency
    --*/
    private GetPersonDetail mGetPersonDetail;
    /*--
    Binding
    --*/
    private Flowable<Person> mPerson = Flowable.empty();

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
        mPerson = mGetPersonDetail
                .buildUseCaseObservable(GetPersonDetail.Params.forPerson(personId));
    }


    /*--
    Getters
    --*/

    Flowable<Person> getPerson() {
        return mPerson;
    }

}
