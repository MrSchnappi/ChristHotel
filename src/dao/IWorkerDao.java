package dao;

import java.util.List;

import model.worker;
import until.Pagination;
public interface IWorkerDao {
     public List<worker> getAllWorker(Pagination pagination);
     public void insertWorker(worker worker);
     public void deleteWorker(String wno);
     public void updateWorker(worker  people);
     public worker getWorker(String wno);
}
