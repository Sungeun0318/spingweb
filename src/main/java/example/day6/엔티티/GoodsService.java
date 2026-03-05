package example.day6.엔티티;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    // 저장
    public boolean 저장(GoodsDto goodsDto){
        // Dto --> entity 변환
//        GoodsEntity goodsEntity = goodsDto.toEntity();
//        GoodsEntity saved = goodsRepository.save(goodsEntity); // 이 두줄이랑 바로 아래 줄이랑 같은 의미

        // JPA save 이용하여 엔티티 insert하기
        System.out.println("goodsDto = " + goodsDto);
        GoodsEntity saved = goodsRepository.save(goodsDto.toEntity());
        System.out.println("saved = " + saved);

        // save 결과에 pk 여부 성공판단
        if(saved.getGno() >= 1){
            return true;
        }
        return false;

    }

    // 수정 ** @Transactional 필수 **
    @Transactional // 수정시 여러개 setter 사용함으로 단일 실행
    public boolean 수정(GoodsDto goodsDto){
        // 1] 수정할 엔티티의 pk번호 확인한다.
        int updatePk = goodsDto.getGno();
        // 2] 수정할 엔티티 찾기 --> 영속성, Optional 반환
        goodsRepository.findById(updatePk);
        Optional<GoodsEntity> optional = goodsRepository.findById(updatePk);
        // 3] 만약에 찾은 엔티티가 존재하면
        if(optional.isPresent()){
            GoodsEntity updateEntity = optional.get(); // 4] 엔티티 꺼내기
            updateEntity.setGname(goodsDto.getGname());
            updateEntity.setGdesc(goodsDto.getGdesc());
            updateEntity.setGprice(goodsDto.getGprice()); // 3개중에 setter에서 하나라도 오류 발생시 전체 취소
        }else {
            return false;
        }
        return true;

    }
}
