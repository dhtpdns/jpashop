package jpabook.jpashop.repository.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.Academy;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static jpabook.jpashop.domain.QAcademy.academy;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }
}