package com.caito.usuarioms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @param <T>
 * @author  caito Vilas
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageableResponseDTO<T> {
    private List<T> content;
    private int page;
    private long results;
    private int totalPages;
}
