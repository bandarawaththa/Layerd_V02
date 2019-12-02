package dao;

import java.util.ArrayList;

public interface CrudDAO<T, ID> extends SuperDAO {
    public boolean add(T t);

    public boolean delete(ID id);

    public T search(ID id);

    public boolean update(T t);

    public ArrayList<T> getAll();

    public ArrayList<T> searchAll(ID sql);
}