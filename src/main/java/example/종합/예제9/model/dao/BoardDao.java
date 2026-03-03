package example.종합.예제9.model.dao;

import example.종합.예제9.model.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component // 빈 등록
public class BoardDao {
    public BoardDao() {connect();}
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
    private String username = "root"; private String password = "1208";
    private Connection conn;
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("[준비] 데이터베이스 연동 성공");
        }catch(Exception e){
            System.out.println("[경고] 데이터베이스 연동 실패 : 관리자에게 문의");
        }
    }

    public List<BoardDto> findAll(){
        List<BoardDto> list = new ArrayList<>();                   // 1] 조회 결과 레코드들을 DTO로 저장하기 위한 리스트 선언
        try {
            String sql = "select * from board";                    // 2] SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql);     // 3] SQL 등록
            ResultSet rs = ps.executeQuery();                      // 4] SQL 실행하고 결과받기
            while(rs.next()){                                      // 5] 첫번째 레코드부터 마지막 레코드까지 반복
                BoardDto boardDto = new BoardDto(                  // 6] 조회중인 레코드의 속성정보들을 DTO 구성
                        rs.getInt("bno"),
                        rs.getString("bcontent"),
                        rs.getString("bwriter"),
                        rs.getString("bdate")
                );
                list.add(boardDto);                                // 7] 구성한 DTO를 리스트 저장

            }
        }catch(Exception e){
            System.out.println(e);
        }
        return list;                                               // 8] 리스트 반환
    }

    public boolean write(BoardDto boardDto){
        try {
            String sql = "insert into board(bcontent,bwriter) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set bcontent=?,bwriter=? where bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setString(2, boardDto.getBwriter());
            ps.setInt(3, boardDto.getBno());
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(Integer bno){
        try {
            String sql = "delete from board where bno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }






}
