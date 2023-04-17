package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl Senzor;
    TrainUser mocTrainUser;
    TrainController mocTrainController;

    @Before
    public void before() {
        mocTrainUser = mock(TrainUser.class);
        mocTrainController = mock(TrainController.class);

        Senzor = new TrainSensorImpl(mocTrainController, mocTrainUser);

    }

    @Test
    public void AbsoluteSpeed_Lower() {
        Senzor.overrideSpeedLimit(-10);

        verify(mocTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void AbsoluteSpeed_Upper() {
        Senzor.overrideSpeedLimit(600);

        verify(mocTrainUser, times(1)).setAlarmState(true);;
    }

    @Test
    public void RelativeSpeed_Lower() {
        Senzor.overrideSpeedLimit(1);

        verify(mocTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeSpeed_Upper() {
        Senzor.overrideSpeedLimit(10);

        verify(mocTrainUser, times(1)).setAlarmState(true);
    }
}

