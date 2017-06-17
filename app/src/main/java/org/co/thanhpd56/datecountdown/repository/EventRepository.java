package org.co.thanhpd56.datecountdown.repository;


import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Completable;
import org.co.thanhpd56.datecountdown.entity.Event;

/**
 * @author rebeccafranks
 * @since 2017/04/21.
 */
public interface EventRepository {

    Completable addEvent(Event event);

    LiveData<List<Event>> getEvents();

    Completable deleteEvent(Event event);


}
