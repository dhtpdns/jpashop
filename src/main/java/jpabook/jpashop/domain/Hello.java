package jpabook.jpashop.domain;

import lombok.*;


@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hello {
    private String name;
    private Integer age;

    //public Hello() {};

}
