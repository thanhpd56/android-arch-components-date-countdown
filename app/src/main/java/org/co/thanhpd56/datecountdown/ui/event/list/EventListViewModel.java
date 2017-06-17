package org.co.thanhpd56.datecountdown.ui.event.list;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
import org.co.thanhpd56.datecountdown.entity.Event;
import org.co.thanhpd56.datecountdown.injection.CountdownComponent;
import org.co.thanhpd56.datecountdown.repository.EventRepository;

public class EventListViewModel extends ViewModel implements CountdownComponent.Injectable {

    @Inject
    EventRepository eventRepository;
    private LiveData<List<Event>> events = new MutableLiveData<>();

    @Override
    public void inject(CountdownComponent countdownComponent) {
        countdownComponent.inject(this);
        events = eventRepository.getEvents();
    }

    public LiveData<List<Event>> getEvents() {
        return events;
    }

    public void deleteEvent(Event event) {
        eventRepository.deleteEvent(event)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete - deleted event");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("OnError - deleted event: ", e);
                    }
                });
    }

}
