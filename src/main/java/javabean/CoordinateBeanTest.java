package javabean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateBeanTest {

  @Test
  public void canCreateCoordinateBean() {
    assertEquals(39.0, createdCoordinates().getLatitude(), 0.0001);
    assertEquals(36.0, createdCoordinates().getLongitude(), 0.0001);

    CoordinateBean.getInstance().
  }

  private CoordinateBean createdCoordinates() {
    CoordinateBean coordinateBean = new CoordinateBean();
    coordinateBean.setLatitude(39.0);
    coordinateBean.setLongitude(36.0);
    return coordinateBean;
  }
}
