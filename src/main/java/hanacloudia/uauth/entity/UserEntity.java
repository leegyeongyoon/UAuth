package hanacloudia.uauth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "TB_USER")
public class UserEntity {

    //사번
    @Id
    @Column(name = "HANAPRTLEMPNO")
    private String hanaPrtlEmpNo; // 통합 사번(관계사코드+사번)

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "HFGGRCMCODE")
    private String hfgGrcmCode; // 관계사 코드

    @Column(name = "COMPANYNM")
    private String companyNm; // 관계사 이름

    @Column(name = "HANAPRTLBRNO")
    private String hanaPrtlBrNo; // 부서코드

    @Column(name = "HANAPRTLBRNM")
    private String hanaPrtlBrNm; // 부서명

    @Column(name = "HANAPRTLACTLSBBRNO")
    private String hanaPrtlActlSbBrNo; // 부서코드

    @Column(name = "HANAPRTLACTLSBBRNM")
    private String hanaPrtlActlSbBrNm; // 부서명

    @Column(name = "HANAPRTLPOSNNM")
    private String hanaPrtlPosnNm; // 직책

    @Column(name = "HANAPRTLSLTNNM")
    private String hanaPrtlSltnNm; // 직급

    @Column(name = "HANAPRTLEMPNM")
    private String hanaPrtlEmpNm; // 이름

    @Column(name = "MBPHNO")
    private String mbphNo; //휴대폰번호

    @Column(name = "HANAPRTLEOEXTNTELNO")
    private String hanaPrtlEoExtNTelNo; // 사무실 번호

    @Column(name = "HANAPRTLCHRGBIZNM")
    private String hanaPrtlChrgBizNm; // (위키 X, 은행 클라우드 X)

    @Column(name = "EMALADR")
    private String emalAdr; // 이메일

    @Column(name = "TOKEN")
    private String token; // 인증 토큰

}

