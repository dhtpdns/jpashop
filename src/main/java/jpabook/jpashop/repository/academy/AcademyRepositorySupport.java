package jpabook.jpashop.repository.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.Academy;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jpabook.jpashop.domain.QAcademy.academy;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
        super(Academy.class);
        this.queryFactory = queryFactory;
    }

    public List<Academy> findByName(String name) {
        return queryFactory
                .selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

}