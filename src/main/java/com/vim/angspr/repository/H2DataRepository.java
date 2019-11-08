package com.vim.angspr.repository;

import com.vim.angspr.dto.TestData;
import com.vim.angspr.jpa.JpaData;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

@Transactional
@Slf4j
@Setter
public class H2DataRepository implements DataRepository {

  @Bean
  @Profile("local")
  public DataSource getDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).build();
  }

  @Bean
  @Profile("local")
  public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
    return getEntityManagerFactory(true, dataSource);
  }

  private EntityManagerFactory getEntityManagerFactory(boolean generatedDDL, DataSource dataSource) {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(generatedDDL);
    vendorAdapter.setShowSql(true);
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com.vim.angspr.jpa");
    factory.setDataSource(dataSource);
    factory.afterPropertiesSet();
    return factory.getObject();
  }

  @PersistenceContext
  private EntityManager em = getEntityManagerFactory(true, getDataSource()).createEntityManager();

  //@Autowired
  private DozerBeanMapper mapper = new DozerBeanMapper();

  public TestData getData() {
    JpaData jd = em.find(JpaData.class, new Long (1));
    if (jd == null) {
      throw new RuntimeException("No data found!");
    }
    TestData td = mapper.map(jd, TestData.class);
    return td;
  }
}
