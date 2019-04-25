package com.vim.angspr.util.queryUtil;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class Select {
  String select;
  String from;
  String where;
}
