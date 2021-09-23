package com.qyfou.bazaar.common.jpa;

import com.qyfou.bazaar.common.jpa.form.PageRequestForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements com.framework.jpa.BaseRepository<T, ID> {

    private final EntityManager em;


    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }


    @Override
    public List<T> list(PageRequestForm form) {
        return super.findAll(PageRequest.of(form.getPageNum(), form.getPageSize())).getContent();
    }

    @Override
    public Page<T> find(PageRequestForm form) {
        return super.findAll(PageRequest.of(form.getPageNum(), form.getPageSize()));
    }


//
//    @Override
//    public List<Object[]> listBySQL(String sql) {
//        return em.createNativeQuery(sql).getResultList();
//    }


}