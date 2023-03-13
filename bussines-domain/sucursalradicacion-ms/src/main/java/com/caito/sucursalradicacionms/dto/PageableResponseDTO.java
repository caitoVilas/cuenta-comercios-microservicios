package com.caito.sucursalradicacionms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageableResponseDTO <T>{
    private List<T> content;
    private int page;
    private long results;
    private int totalPages;
}
