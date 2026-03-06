package example.종합.예제10.board.entity;

import example.종합.예제10.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board")

public class BoardEntity extends BaseTime {
    @Id // PK
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private Integer bno;
    @Column( length = 255, nullable = false  ) // not null
    private String btitle;
    @Column( columnDefinition = "longtext not null") // 직접 SQL 설정
    private String bcontent;
    @Column( length = 30 , nullable = false ) // not null
    private String bwriter;
    // + 생성/수정 날짜/시간은 BaseTime 으로 상속받기

    // + entity --> dto 변환함수 : 주로 조회 +
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno( bno ).btitle( btitle )
                .bcontent( bcontent ).bwriter( bwriter )
                .createDate( getCreateDate().toString() )
                .updateDate( getUpdateDate().toString() )
                .build();
    }


}
