package jpabook.jpashop.repository.academy;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.Academy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jpabook.jpashop.domain.QAcademy.academy;

@RequiredArgsConstructor
@Repository
public class AcademyQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Academy> findByName(String name) {
        return queryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

//    @Override
//    public List<StudentCount> findAllStudentCount() {
//        return queryFactory
//                .select(Projections.fields(StudentCount.class,
//                        academy.name.as("academyName"),
//                        ExpressionUtils.as(
//                                JPAExpressions.select(count(student.id))
//                                        .from(student)
//                                        .where(student.academy.eq(academy)),
//                                "studentCount")
//                ))
//                .from(academy)
//                .fetch();
//    }
}