package example.c12.projection.dto;

import java.util.List;

public interface ReservationDto {
    Long getId();
    AccountDto getAccount();
    List<ReservationSeatDto> getSeats();

    interface AccountDto {
        String getName();
    }

    interface ReservationSeatDto {
        SeatDto getSeat();
        long getPrice();
    }

    interface SeatDto {
        String getRows();
        int getCols();
    }
}
