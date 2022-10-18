package com.example.demoyamaha1.api.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class AbstractPagingOutput<T> {
    private int page;
    private int totalPage;
    private List<T> listResult;
}
