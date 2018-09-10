import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsConverter {
  private static final Map<Integer, String> BASE_VALUES =
    new HashMap<Integer, String> () {{
      put (1, "I");
      put (4, "IV");
      put (5, "V");
      put (9, "IX");
      put (10, "X");
      put (40, "XL");
      put (50, "L");
      put (90, "XC");
      put (100, "C");
      put (400, "CD");
      put (500, "D");
      put (900, "CM");
      put (1000, "M");
    }};

  public static String convert (Integer arabicNumber) {
    return compareToNearestBaseValue (arabicNumber, "");
  }

  private static String convert (Integer arabicNumber,
                                 String convertedNumberString) {
    return compareToNearestBaseValue (arabicNumber, convertedNumberString);
  }

  private static String compareToNearestBaseValue (Integer arabicNumber,
                                                   String convertedNumberString) {
    Integer nearestBaseValue = findBaseValue (arabicNumber);
    int quotient = arabicNumber / nearestBaseValue;
    int remainder = arabicNumber % nearestBaseValue;
    for (int i = 0; i < quotient; i++) {
      convertedNumberString += BASE_VALUES.get(nearestBaseValue);
    }
    if (remainder != 0) {
      return convert (remainder, convertedNumberString);
    }
    return convertedNumberString;
  }

  private static int findBaseValue (Integer arabicNumber) {
    Integer nearestBaseValue = null;
    Integer minimumDifference = Integer.MAX_VALUE;
    if (BASE_VALUES.get (arabicNumber) != null) {
      nearestBaseValue = arabicNumber;
    } else {
      for (Integer key : BASE_VALUES.keySet ()) {
        int differenceBetweenKeyAndArabicNumber = (arabicNumber - key);
        if (differenceBetweenKeyAndArabicNumber < minimumDifference && differenceBetweenKeyAndArabicNumber > 0) {
          nearestBaseValue = key;
          minimumDifference = differenceBetweenKeyAndArabicNumber;
        }
      }
    }
    return nearestBaseValue;
  }
}
