package practice1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice1.entity.TaskEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String content;
    private String requester;
    private String status;
    private String createDate;
    private String updateDate;

    public TaskEntity toEntity() {
        return TaskEntity
                .builder()
                .title(title)
                .content(content)
                .requester(requester)
                .status(status)
                .build();
    }

}
