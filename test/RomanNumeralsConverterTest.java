import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsConverterTest {

  @Test
  @DisplayName ("Should return V for 5")
  void convert5 () {
    assertEquals ("V", RomanNumeralsConverter.convert(5));
  }

  @Test
  @DisplayName ("Should return XI for 11")
  void convert11 () {
    assertEquals ("XI", RomanNumeralsConverter.convert (11));
  }

  @Test
  @DisplayName ("Should return XX for 20")
  void convert20 () {
    assertEquals ("XX", RomanNumeralsConverter.convert (20));
  }

  @Test
  @DisplayName ("Should return MMMDXLIX for 3549")
  void convert3549 () {
    assertEquals ("MMMDXLIX", RomanNumeralsConverter.convert (3549));
  }

}