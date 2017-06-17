package org.co.thanhpd56.datecountdown.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import org.co.thanhpd56.datecountdown.dao.EventDao;
import org.co.thanhpd56.datecountdown.entity.Event;

@Database(entities = {Event.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

}
