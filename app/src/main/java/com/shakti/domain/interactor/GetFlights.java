package com.shakti.domain.interactor;

import com.shakti.domain.executor.PostExecutionThread;
import com.shakti.domain.executor.ThreadExecutor;
import com.shakti.domain.repository.IFlightSearchRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetFlights extends BaseUseCase {
    private final String Tag = "GetMyBooks";
    private IFlightSearchRepository repository;

    @Inject
    public GetFlights(IFlightSearchRepository repository, ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }


    @Override
    public Observable buildUseCaseObservable() {
        return repository.getFlights();
    }
}