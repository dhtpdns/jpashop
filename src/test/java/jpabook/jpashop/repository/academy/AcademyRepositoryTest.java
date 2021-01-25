package jpabook.jpashop.repository.academy;

import jpabook.jpashop.domain.Academy;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyRepositoryTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;


    @After
    public void tearDown() throws Exception {
        academyRepository.deleteAllInBatch();
    }

    @Autowired
    private AcademyQueryRepository academyQueryRepository;

    @Test
    public void querydsl_기본_기능_확인2() {
        //given
        String name = "ose";
        String address = "yd1505@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyQueryRepository.findByName(name);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));
    }

    @Test
    public void querydsl_Custom설정_기능_확인() {
        //given
        String name = "ose";
        String address = "yd1505@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepository.findByName(name);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));
    }

    @Test
    public void querydsl_기본_기능_확인() {
        //given
        String name = "ose";
        String address = "yd1505@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepositorySupport.findByName(name);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));
    }
}