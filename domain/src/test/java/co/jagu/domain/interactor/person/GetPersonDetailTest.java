package co.jagu.domain.interactor.person;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import co.jagu.domain.Person;
import co.jagu.domain.executor.PostExecutionThread;
import co.jagu.domain.executor.ThreadExecutor;
import co.jagu.domain.repository.PersonRepository;
import io.reactivex.Flowable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetPersonDetailTest {

    /*--
    Constants
    --*/
    private static final long FAKE_PERSON_ID = 1;
    /*--
    Dependency
    --*/
    @Mock
    private PersonRepository userRepository;
    @Mock
    private ThreadExecutor mockThreadExecutor;
    @Mock
    private PostExecutionThread mockPostExecutionThread;

    /*--
    Fields
    --*/
    private GetPersonDetail getPersonDetail;

    /*--
    Config
    --*/
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        getPersonDetail = new GetPersonDetail(userRepository,
                mockThreadExecutor,
                mockPostExecutionThread);
    }

    /*--
    Tests
    --*/
    @Test
    public void getPersonDetailByIdTest() {

        Person person = new Person();
        person.setId(FAKE_PERSON_ID);

        //stubbed
        Mockito.when(userRepository.getById(FAKE_PERSON_ID))
                .thenReturn(Flowable.just(person));

        getPersonDetail
                .buildUseCaseObservable(GetPersonDetail.Params.forPerson(FAKE_PERSON_ID))
                .test()
                .assertNoErrors()
                .assertComplete()
                .assertValue(person1 -> person1 != null && person.getId() == FAKE_PERSON_ID);

        verify(userRepository).getById(FAKE_PERSON_ID);
        verifyNoMoreInteractions(userRepository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }


    @Test
    public void testShouldFailWhenNoOrEmptyParameters() {
        expectedException.expect(NullPointerException.class);
        getPersonDetail.buildUseCaseObservable(null);
    }
}
