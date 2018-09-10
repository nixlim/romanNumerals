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

}