package co.jagu.presentation.injection.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import co.jagu.presentation.injection.ViewModelKey;
import co.jagu.presentation.ui.person.detail.PersonDetailViewModel;
import co.jagu.presentation.viewmodel.ViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PersonDetailViewModel.class)
    abstract ViewModel bindRepoViewModel(PersonDetailViewModel personDetailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
