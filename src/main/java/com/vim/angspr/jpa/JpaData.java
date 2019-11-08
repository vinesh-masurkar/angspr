package com.vim.angspr.jpa;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Table(name = "APPDATA", schema = "")
@Data
public class JpaData {
  @Id
  private Long num;

  @Column(name="dataname")
  private String dataname;
}
