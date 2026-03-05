package example.day6.엔티티;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GoodsDto {
    private Integer gno; // 제품번호
    private String gname; // 제품명
    private Integer gprice; // 제품가격
    private String gdesc; // 제품설명

    // + BaseTime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수
    public GoodsEntity toEntity(){
        // 빌더패턴이란? new 생성자가 아닌 함수로 객체 생성
        // this란? 해당 메소드/함수 실행한 객체
        return GoodsEntity
                .builder()
                .gno(gno) // this 안넣어도됨
                .gname(gname)
                .gprice(this.gprice)
                .gdesc(this.gdesc)
                .build();
    }

}
