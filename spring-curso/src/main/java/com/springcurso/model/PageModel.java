package com.springcurso.model;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = -1605648343765703951L;
    private int totalElements;
    private int pageSeize;
    private int totalPages;
    private List<T> elements;

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSeize() {
        return pageSeize;
    }

    public void setPageSeize(int pageSeize) {
        this.pageSeize = pageSeize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public PageModel() {

    }

    public PageModel(int totalElements, int pageSeize, int totalPages,
            List<T> elements) {
        super();
        this.totalElements = totalElements;
        this.pageSeize = pageSeize;
        this.totalPages = totalPages;
        this.elements = elements;
    }

}
