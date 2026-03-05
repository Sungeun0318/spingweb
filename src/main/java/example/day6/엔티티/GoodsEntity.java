package example.day6.엔티티;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 롬복
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity // + 영속성
@Table(name = "goods") // 생략시 클래스명으로 자동설정
public class GoodsEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer gno; // 제품번호

    @Column(name = "gname", length = 100, nullable = false, unique = true)
    private String gname; // 제품명

    // @Column // 생략가능 : 자바의 타입 --> SQL 타입, 자바의 변수명 --> SQL 필드명
    private Integer gprice; // 제품가격

    @Column(columnDefinition = "varchar(100) default '제품설명' not null")
    private String gdesc; // 제품설명


    // ** ENTITY --> DTO 변환함수
    public GoodsDto toDto(){
        return GoodsDto
                .builder()
                .gno(gno)
                .gname(gname)
                .gprice(gprice)
                .gdesc(gdesc)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }





}

/*
    @Id : primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column( ), 생략시 기본값 적용
        name = "필드명"              , 기본값은 자바필드명
        nullable = false           , 기본값은 true, not null
        length = 길이               , 기본값은 255, varchar(길이)
        unique = true              , 기본값은 false, 중복여부
        insertable = true          , 기본값은 true, insert 할 때 적용여부
        updatable = true           , 기본값은 true, update 할 때 적용여부
        columnDefinition = "SQL"   , JPA가 아닌 네이티브(실제 SQL) 쿼리 작성
    레코드 생성(회원가입/등록일/주문일 등등) 날짜 / 수정날짜

*/
