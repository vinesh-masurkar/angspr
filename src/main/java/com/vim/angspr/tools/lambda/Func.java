package com.vim.angspr.tools.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Func {

  public static class Bmi {

    public enum Type {
      UNDER("UnderWeight"),
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
      Map<Predicate<Double>, String> bmiMap = new HashMap<Predicate<Double>, String>(){{
        put(b -> val<=18.5, Type.UNDER.type());
        put(b -> val<=25.0, Type.NORMAL.type());
        put(b -> val<=30.0, Type.OVER.type());
        put(b -> val>30.0, Type.OBESE.type());
      }};

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

//        final Predicate<Integer> uPred = bmi -> val<=18.5;
//      final Supplier<String> uSupp = () -> "UNDER";
//      final Predicate<Integer> nPred = bmi -> val<=25.0;
//      final Supplier<String> nSupp = () -> "NORMAL";
//      final Predicate<Integer> ovPred = bmi -> val<=30.0;
//      final Supplier<String> ovSupp = () -> "OVER";
//      final Predicate<Integer> obPred = bmi -> val>30.0;
//      final Supplier<String> obSupp = () -> "OBESE";



      //Map<Predicate<Integer>, Supplier<Bmi.Type>> bmiMap = new HashMap<Predicate<Integer>,Supplier<Bmi.Type>>(){{
//    Map<Predicate<Integer>, Supplier<String>> bmiMap = new HashMap<Predicate<Integer>, Supplier<String>>(){{
//      put((i) -> val<=18.5, () -> "Bmi.Type.UNDER");//()-> Bmi.Type.UNDER);
//      put((i) -> val<=25, () -> "Bmi.Type.NORMAL");  //()-> Bmi.Type.NORMAL);
//      put((i) -> val<=30, () -> "Bmi.Type.OVER");  //()-> Bmi.Type.OVER);
//      put((i) -> val>30, () -> "Bmi.Type.OBESE");  //()-> Bmi.Type.OBESE);
//      put(uPred, uSupp);
//      put(nPred, nSupp);
//      put(ovPred, ovSupp);
//      put(obPred, obSupp);
//    }};

      //Map<Predicate<Integer>, String> bmi1Map = new HashMap<Predicate<Integer>, String>(){{
//        put(uPred, uSupp.get());
//        put(nPred, nSupp.get());
//        put(ovPred, ovSupp.get());
//        put(obPred, obSupp.get());
//      }};
//
//      System.out.println(">>>>>>>>>>>>>>>>>>>>>>> "+ uSupp.get());
//      String type = (bmi1Map.get(val)); //.get(); //.type();

//    String type1 = bmi1Map.keySet()
//      .stream()
//      .filter((keyCondition)->keyCondition.test(numItems, version))
//      .findFirst()
//      .ifPresent((e)-> bmi1Map.get(e)); //.get();

      //items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
//      bmi1Map.forEach((k,v)->System.out.println("Lambda : " + k + " Result : " + v));
//
//    String result = bmi1Map.forEach((k,v)
//      .filter(k -> k))
//      .map(map -> map.getValue())
//      .findFirst()
//      .ifPresent((e)-> bmi1Map.get(e));


//      System.out.println(">>>>>>>>>>>>>>>>>>>>>>> "+ type);


//    final Function<String, Predicate<Double>> bmitype =
//      (String type1) -> (Double i) -> val<=18.5;
//    bmitype.apply(val)


//    String type1 = bmiMap.keySet()
//      .stream()
//      //.filter((keyCondition)->keyCondition.test(numItems,version))
//      .findFirst()
//      .ifPresent((e)-> bmiMap.get(e).get(); //.type()); //System.out.print(ruleMap.get(e).get()));

//      //String version = new String();
//      String type2 = bmiMap.keySet()
//        .stream()
//        //.filter((keyCondition)->keyCondition.test(val, version))
//        .findFirst()
//        .ifPresent((e)-> System.out.print(bmiMap.get(e).get()));

      //return (val <= 18.5 ? "Under" : "Over");
      //return type;

  } // END: BMI

}
