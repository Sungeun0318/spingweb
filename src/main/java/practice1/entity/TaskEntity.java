package practice1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice1.BaseTime;
import practice1.dto.TaskDto;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String requester;

    @Column(nullable = false)
    private String status;

    public TaskDto toDto() {
        return TaskDto
                .builder()
                .id(id)
                .title(title)
                .content(content)
                .requester(requester)
                .status(status)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

}
