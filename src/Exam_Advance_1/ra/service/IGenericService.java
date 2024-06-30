package Exam_Advance_1.ra.service;

public interface IGenericService<T,E>{
    T findById(E id);

    void addNew();

    void showAll();

    void edit();

    void delete();





}
