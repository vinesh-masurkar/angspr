package com.vim.angspr.tools.pojo.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Boost<T> implements Booster {

  @Override
  public <T> T trim(T entrant) throws Exception {
//    Field field = entrant.getClass().getDeclaredField("name");
//    field.setAccessible(true);
//    Object value = field.get(entrant);
//    System.out.println("Name >>> " + value);
    for (Field field : entrant.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      System.out.print("Field: " + field.getName() + " - ");
      Type type = field.getGenericType();
      if (type instanceof ParameterizedType) {
        ParameterizedType pType = (ParameterizedType)type;
        System.out.print("Raw type: " + pType.getRawType() + " - ");
        System.out.print("Type args: " + pType.getActualTypeArguments()[0]+ " - ");
      } else {
        System.out.print("Type: " + field.getType()+ " - ");
      }
      Object value = field.get(entrant);
      if(field.getType().getName().equals("java.lang.String")) {
        String trimVal = value.toString().trim();
        field.set(entrant, trimVal);
      }
      System.out.println("Value: '" + field.get(entrant)+"'");
    }
   return (T) entrant;
  }
}
