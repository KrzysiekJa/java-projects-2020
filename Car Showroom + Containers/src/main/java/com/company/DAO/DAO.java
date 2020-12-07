package com.company.DAO;

import java.util.List;


public interface DAO<T> {
    public T get(long id);
    public List<T> getAll();
    public List<T> getAllparam(long id);
    public void save(T entity);
    public void delete(T entity);
    public void deleteByModel(String model);
    public int count(long id);
    public int sum(long id);
    public double showAmount(long id);
}
