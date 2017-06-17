package org.co.thanhpd56.datecountdown.injection;

import javax.inject.Singleton;

import dagger.Component;
import org.co.thanhpd56.datecountdown.ui.event.add.AddEventViewModel;
import org.co.thanhpd56.datecountdown.ui.event.list.EventListViewModel;

/**
 * @author rebeccafranks
 * @since 2017/05/11.
 */
@Singleton
@Component(modules = {CountdownModule.class})
public interface CountdownComponent {

    void inject(EventListViewModel eventListViewModel);

    void inject(AddEventViewModel addEventViewModel);

    interface Injectable {
        void inject(CountdownComponent countdownComponent);
    }
}
