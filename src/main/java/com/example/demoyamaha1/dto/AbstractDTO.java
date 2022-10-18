package com.example.demoyamaha1.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDTO<T> {
    private Long id;
}
