package com.fincons.tdd.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SommaServiceTest {

  @InjectMocks public SommaService sommaService;
  private int z;

  @Test
  public void sommaXY() {
    int x = 2;
    int y = 2;
    int result = sommaService.sommaXY(x, y);
    assertThat(result).isEqualTo(4);
  }

  @Test
  public void sommaXYZ() {
    int x = 2;
    int y = 2;
    int z = 3;
    int result = sommaService.sommaXYZ(x, y, z);
    assertThat(result).isEqualTo(7);
  }
}
