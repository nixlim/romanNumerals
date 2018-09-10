import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsConverter {
  private static final Map<Integer, String> BASE_VALUES_MAP =
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
    return constructRomanNumeralStringUsingBaseValues (arabicNumber, "");
  }

  private static String convert (Integer arabicNumber,
                                 String convertedNumberString) {
    return constructRomanNumeralStringUsingBaseValues (arabicNumber, convertedNumberString);
  }

  private static String constructRomanNumeralStringUsingBaseValues(Integer arabicNumber,
                                                                   String convertedNumberString) {
    Integer nearestBaseValue = findBaseValue (arabicNumber);
    int numberOfBasesInTheArabicNumber = arabicNumber / nearestBaseValue;
    int numberRemainingAfterLargestBaseHasBeenDeducted = arabicNumber % nearestBaseValue;

    convertedNumberString = buildRomanNumeralString (
                                              convertedNumberString,
                                              nearestBaseValue,
                                              numberOfBasesInTheArabicNumber);
    return numberRemainingAfterLargestBaseHasBeenDeducted != 0 ?
      convert (numberRemainingAfterLargestBaseHasBeenDeducted,
        convertedNumberString) : convertedNumberString;
  }

  private static String buildRomanNumeralString(String convertedNumberString,
                                                Integer nearestBaseValue,
                                                int numberOfBasesInTheArabicNumber) {
    for (int i = 0; i < numberOfBasesInTheArabicNumber; i++) {
      convertedNumberString += BASE_VALUES_MAP.get(nearestBaseValue);
    }
    return convertedNumberString;
  }

  private static int findBaseValue (Integer arabicNumber) {
    Integer nearestBaseValue = null;
    Integer minimumDifference = Integer.MAX_VALUE;
    if (BASE_VALUES_MAP.get (arabicNumber) != null) {
      nearestBaseValue = arabicNumber;
    } else {
      for (Integer key : BASE_VALUES_MAP.keySet ()) {
        int differenceBetweenBaseValueMapKeyAndArabicNumber = (arabicNumber - key);
        if (differenceBetweenBaseValueMapKeyAndArabicNumber < minimumDifference
          && differenceBetweenBaseValueMapKeyAndArabicNumber > 0) {
          nearestBaseValue = key;
          minimumDifference = differenceBetweenBaseValueMapKeyAndArabicNumber;
        }
      }
    }
    return nearestBaseValue;
  }
}
