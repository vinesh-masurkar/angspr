package com.vim.angspr.tools.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bmi {

  public enum Type {
    UNDER("Underweight"),
    NORMAL("Normal"),
    OVER("Overweight"),
    OBESE("Obese");

    private final String type;

    Type(String t) {
      this.type = t;
    }

    public String type() {
      return this.type;
    }
  }

  private static Double calculateBmi(int lbs, int inches) {
    // 703 x weight (lbs) / [height (in)]^2
    return (703 * lbs) / Math.pow(inches, 2);
  }

  private static Map<Predicate<Double>, String> getBmiPredicateStringMap(Double val) {
    return new HashMap<Predicate<Double>, String>(){{
      put(b -> val<=18.5, Type.UNDER.type());
      put(b -> val<=25.0, Type.NORMAL.type());
      put(b -> val<=30.0, Type.OVER.type());
      put(b -> val>30.0, Type.OBESE.type());
    }};
  }

  public static String imperativeBmi(int lbs, int inches) {
    Double val = calculateBmi(lbs, inches);
    String result = new String();
    if (val <= 18.5) {
      result = Type.UNDER.type();
    } else if (val <= 25.0) {
      result = Type.NORMAL.type();
    } else if (val <= 30.0) {
      result = Type.OVER.type();
    } else if (val > 30.0) {
      result = Type.OBESE.type();
    }
    return result;
  }

  public static String declarativeIfElseBmi(int lbs, int inches) {
    Double val = calculateBmi(lbs, inches);
    final Predicate<Double> uPred = b -> val<=18.5;
    final Predicate<Double> nPred = b -> val<=25.0;
    final Predicate<Double> ovPred = b -> val<=30.0;
    final Predicate<Double> obPred = b -> val>30.0;

    String result = new String();
    if (uPred.test(val)) {
      result = Type.UNDER.type();
    } else if (nPred.test(val)) {
      result = Type.NORMAL.type();
    } else if (ovPred.test(val)) {
      result = Type.OVER.type();
    } else if (obPred.test(val)) {
      result = Type.OBESE.type();
    }
    return result;
  }

  public static String declarativeMapForBmi(int lbs, int inches) {
    Double val = calculateBmi(lbs, inches);
    Map<Predicate<Double>, String> bmiMap = getBmiPredicateStringMap(val);

    String result = new String();
    for (Map.Entry<Predicate<Double>, String> entry : bmiMap.entrySet()) {
      if(entry.getKey().test(val)) {
        result = entry.getValue();
        break;
      }
    }
    return result;
  }

  public static String declarativeStreamLambdaBmi(int lbs, int inches) {
    Double val = calculateBmi(lbs, inches);
    Map<Predicate<Double>, String> bmiMap = getBmiPredicateStringMap(val);

    String result = bmiMap.entrySet().stream()
      .filter(e -> e.getKey().test(val))
      .findFirst()
      .map(e  -> {return e.getValue();})
      .get();

    return result;
  }

  public static String declarativeStreamLambdaCollectBmi(int lbs, int inches) {
    Double val = calculateBmi(lbs, inches);
    Map<Predicate<Double>, String> bmiMap = getBmiPredicateStringMap(val);

    String result = bmiMap.entrySet().stream()
      .filter(e -> e.getKey().test(val))
      .map(e  -> {return e.getValue();})
      .collect(Collectors.toList())
      .get(0);

    return result;
  }

}
