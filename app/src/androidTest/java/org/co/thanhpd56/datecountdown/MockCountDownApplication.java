package org.co.thanhpd56.datecountdown;

import org.co.thanhpd56.datecountdown.dao.DaggerEventDaoTest_MockCountdownComponent;
import org.co.thanhpd56.datecountdown.injection.CountdownComponent;
import org.co.thanhpd56.datecountdown.injection.MockCountdownModule;

/**
 * @author rebeccafranks
 * @since 2017/05/12.
 */

public class MockCountDownApplication extends CountdownApplication {

    @Override
    public CountdownComponent createCountdownComponent() {
        return DaggerEventDaoTest_MockCountdownComponent.builder()
                .mockCountdownModule(new MockCountdownModule(this)).build();
    }
}
