package jpabook.jpashop.repository.academy;

import jpabook.jpashop.domain.Academy;

import java.util.List;

public interface AcademyRepositoryCustom {
    List<Academy> findByName(String name);
}