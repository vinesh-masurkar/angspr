package com.vim.angspr.repository;

import com.vim.angspr.dto.TestData;
import com.vim.angspr.jpa.JpaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository { //extends JpaRepository<JpaData, Integer> {
  TestData getData();
}
