package com.framework.jpa;

import com.qyfou.bazaar.common.jpa.form.PageRequestForm;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean       //注解 不实例化该类，否则启动报错
public interface BaseRepository<T, V> extends JpaRepository<T, V>, JpaSpecificationExecutor<T> {

    //public void update(T t);
    List<T> list(PageRequestForm form);

    Page<T> find(PageRequestForm form);


}
