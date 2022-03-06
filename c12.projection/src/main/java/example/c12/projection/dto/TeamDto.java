package example.c12.projection.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface TeamDto {
    Long getId();
    String getName();
    LocalDateTime getCreateDate();
    List<TeamDetailDto> getDetails();

    interface TeamDetailDto {
        @Value("#{target.pk.type}")
        String getType();
        String getDesc();
    }
}
