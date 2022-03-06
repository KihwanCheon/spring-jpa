package example.c12.projection.dto;

import java.util.List;

public interface TeamDescDto {
    List<DescDto> getDetails();

    interface DescDto {
        String getDesc();
    }
}
