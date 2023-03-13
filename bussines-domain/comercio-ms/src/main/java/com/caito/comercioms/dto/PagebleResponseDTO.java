package com.caito.comercioms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagebleResponseDTO<T> {
    private List<T> content;
    private int page;
    private long results;
    private int totalPages;
}
