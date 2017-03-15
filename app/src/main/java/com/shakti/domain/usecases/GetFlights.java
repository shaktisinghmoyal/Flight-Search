package com.shakti.domain.usecases;

import com.shakti.domain.executor.PostExecutionThread;
import com.shakti.domain.executor.ThreadExecutor;
import com.shakti.domain.repository.IHomeRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetFlights extends BaseUseCase {
    private final String Tag = "GetMyBooks";
    private IHomeRepository repository;

    @Inject
    public GetFlights(IHomeRepository repository, ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }


    @Override
    public Observable buildUseCaseObservable() {
        return repository.getFlights();
    }
}