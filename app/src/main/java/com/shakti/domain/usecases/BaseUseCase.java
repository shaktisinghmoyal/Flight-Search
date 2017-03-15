package com.shakti.domain.usecases;


import com.shakti.domain.executor.PostExecutionThread;
import com.shakti.domain.executor.ThreadExecutor;
import com.shakti.domain.model.Flights;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 * <p/>
 * By convention each UseCase implementation will return the result using a Subscriber
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class BaseUseCase {
    final ThreadExecutor threadExecutor;
    final PostExecutionThread postExecutionThread;
    private final String Tag = "BaseUseCase";
    int id;
    String username;
    String password;
    String fullName;
    String recentSearchString;
    Flights flights;
    Subscription subscription = Subscriptions.empty();
    private Subscriber useCaseSubscriber;

    protected BaseUseCase(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an Observable which will be used when executing the current UseCase.
     */
    public abstract Observable buildUseCaseObservable();

    /**
     * Executes the current use case.
     *
     * @param UseCaseSubscriber The guy who will be listen to the observable build
     *                          with {@link #buildUseCaseObservable()}.
     */

    @SuppressWarnings("unchecked")
    public void execute(Subscriber UseCaseSubscriber) {
        useCaseSubscriber = UseCaseSubscriber;
        execute();
    }

    @SuppressWarnings("unchecked")
    public void execute(int id, Subscriber UseCaseSubscriber) {
        useCaseSubscriber = UseCaseSubscriber;
        this.id = id;
        execute();
    }

    @SuppressWarnings("unchecked")
    public void execute(Flights flights, Subscriber UseCaseSubscriber) {
        useCaseSubscriber = UseCaseSubscriber;
        this.flights = flights;
        execute();
    }


    @SuppressWarnings("unchecked")
    public void execute(String string, Subscriber UseCaseSubscriber) {
        useCaseSubscriber = UseCaseSubscriber;
        this.username = string;
        this.recentSearchString = string;
        execute();
    }

    @SuppressWarnings("unchecked")
    public void execute(String username, String password, Subscriber UseCaseSubscriber) {
        this.username = username;
        this.password = password;
        useCaseSubscriber = UseCaseSubscriber;
        execute();
    }

    @SuppressWarnings("unchecked")
    public void execute(String username, String password, String fullName, Subscriber UseCaseSubscriber) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        useCaseSubscriber = UseCaseSubscriber;
        execute();
    }


    @SuppressWarnings("unchecked")
    public void execute() {
        subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);

    }

    /**
     * Unsubscribes from current Subscription.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
