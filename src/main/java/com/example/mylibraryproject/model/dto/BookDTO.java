package com.example.mylibraryproject.model.dto;

import com.example.mylibraryproject.model.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String name;
    private Genre genre;
}
