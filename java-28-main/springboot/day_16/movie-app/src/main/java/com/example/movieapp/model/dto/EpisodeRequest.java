package com.example.movieapp.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EpisodeRequest {
    @NotEmpty(message = "Tên tập không được để trống")
    String name;

    @NotNull(message = "Thứ tự hiển thị không được để trống")
    Integer displayOrder;

    @NotNull(message = "Trạng thái không được để trống")
    Boolean status;

    @NotNull(message = "Movie ID không được để trống")
    Integer movieId;
}