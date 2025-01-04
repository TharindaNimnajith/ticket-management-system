package config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.InvalidConfigurationException;
import org.junit.jupiter.api.Test;

public class ConfigurationTest {

  @Test
  public void testConfiguration() {
    InvalidConfigurationException exception = assertThrows(InvalidConfigurationException.class, () -> new Configuration(-50, 4, 5, 100));
    assertEquals("values must be positive", exception.getMessage());
  }
}
