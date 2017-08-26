package co.jagu.data.source.local;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;


public abstract class BaseLocalDataSourceTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

}
