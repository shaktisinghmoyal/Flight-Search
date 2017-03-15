package com.shakti.data.repository;


import android.util.Log;

import com.shakti.data.entity.BookEntity;
import com.shakti.data.entity.mapper.book.EntityDataMapper;
import com.shakti.data.networking.DummyRestApi;
import com.shakti.domain.model.Flights;
import com.shakti.domain.repository.IHomeRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class HomeRepository implements IHomeRepository {

    private final String Tag = "HomeRepository";
    private final EntityDataMapper bookEntityDataMapper;
    private DummyRestApi dri;

    @Inject
    public HomeRepository(EntityDataMapper bookEntityDataMapper, DummyRestApi dri) {
        this.bookEntityDataMapper = bookEntityDataMapper;
        this.dri = dri;

    }

    @Override
    public Observable<Flights> getFlights() {

        return dri.recentlyAddedBookList().map(new Func1<List<BookEntity>, List<Book>>() {
            @Override
            public List<Flights> call(List<BookEntity> bookEntities) {
                Log.e(Tag, "recentlyAddedBookList call");
                return bookEntityDataMapper.transform(bookEntities);
            }
        });
    }

}
