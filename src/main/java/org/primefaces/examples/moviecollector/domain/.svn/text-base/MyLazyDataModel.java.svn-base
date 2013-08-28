/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.examples.moviecollector.domain;

import java.util.List;
import java.util.Map;
import org.primefaces.examples.moviecollector.service.MovieService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author levent
 */
public class MyLazyDataModel extends LazyDataModel<Movie> {

    
    private MovieService service;
    
    private Map<String, String> filters;

    public MovieService getService() {
        return service;
    }

    public void setService(MovieService service) {
        this.service = service;
    }

    @Override
    public int getRowCount() {
        return service.getRowCount(filters).intValue();
    }
    
    @Override
    public List<Movie> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) {
        
        //store data filters
        this.filters = filters;
        
        return getService().loadLazy(first, pageSize, sortField, sortOrder, filters);
    }
    
    public MyLazyDataModel( MovieService service){
        setService(service);
    }
    
    @Override
    public Object getRowKey(Movie m) {
        return m.getId();
    }
    
    @Override
    public Movie getRowData(String rowKey) {
        return service.findById(Long.parseLong(rowKey));
    }
}
