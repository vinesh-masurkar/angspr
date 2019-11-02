package com.vim.angspr.util.query.temp;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class Term implements Expression {

  private String value;

  @Override
  public String evaluate() {
    return value.toString();
  }
}
