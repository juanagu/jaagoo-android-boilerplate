package co.jagu.domain.interactor.person;

import com.fernandocejas.arrow.checks.Preconditions;

import javax.inject.Inject;

import co.jagu.domain.Person;
import co.jagu.domain.executor.PostExecutionThread;
import co.jagu.domain.executor.ThreadExecutor;
import co.jagu.domain.interactor.UseCase;
import co.jagu.domain.repository.PersonRepository;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class GetPersonDetail extends UseCase<Person, GetPersonDetail.Params> {


    private final PersonRepository personRepository;

    @Inject
    GetPersonDetail(PersonRepository personRepository, ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.personRepository = personRepository;
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     *
     * @param params
     */
    @Override
    public Flowable<Person> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return personRepository.getById(params.personId);
    }

    public static final class Params {

        private final long personId;

        private Params(long personId) {
            this.personId = personId;
        }

        public static Params forPerson(long personId) {
            return new Params(personId);
        }
    }
}
