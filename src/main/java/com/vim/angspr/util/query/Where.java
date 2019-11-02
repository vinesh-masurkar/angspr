package com.vim.angspr.util.query;

public class Where {

  private Expression.Equals equals;

  public static class builder {

    private Expression.Equals equals;

    public builder equals(Expression.Equals equals) {
      this.equals = equals;
      return this;
    }

    public Where build() {
      return new Where(this);
    }
  }

  private Where(builder bldr) {
    this.equals = bldr.equals;
  }

  public String where(){
    return this.equals.evaluate();
  }

}
