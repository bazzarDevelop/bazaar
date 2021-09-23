package com.qyfou.bazaar.common.config;

import com.qyfou.bazaar.common.jpa.BaseRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class, basePackages = {"com.qyfou.bazaar.common.jpa", "com.qyfou"})
public class JpaConfig {
}
