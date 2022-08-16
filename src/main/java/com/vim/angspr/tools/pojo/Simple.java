package com.vim.angspr.tools.pojo;

import com.vim.angspr.tools.pojo.utils.Boost;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Simple {
  private int no;
  private Long num;
  private List coll;
  private String name;
  private String address;

  public <T> T trim() throws Exception {
    Boost boost = new Boost();
    return (T) boost.trim(this);
  }
}
