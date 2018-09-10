import java.util.Hashtable;
import java.util.Map;

public class RomanNumeralsConverter {
  private static final Map<String, Integer> BASE_VALUES =
    new Hashtable<String, Integer> () {{
      put ("I", 1);
      put ("IV", 4);
      put ("V", 5);
      put ("IX", 9);
      put ("X", 10);
      put ("XL", 40);
      put ("L", 50);
      put ("XC", 90);
      put ("C", 100);
      put ("CD", 400);
      put ("D", 500);
      put ("CM", 900);
      put ("M", 1000);
    }};

  public static String convert (int arabicNumber) {
    return "Empty method";
  }
}
