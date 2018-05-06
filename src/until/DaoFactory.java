package until;
import dao.CheckInDao;
import dao.ClientDao;
import dao.PaymentDao;
import dao.RoomDao;
import dao.WorkerDao;
public class DaoFactory {
	
	 public static CheckInDao getCheckInDao() {
	        return new CheckInDao();
	    }
	 
	 public static ClientDao getClientDao() {
	        return new ClientDao();
	    }
	 
	 public static RoomDao getRoomDao() {
	        return new RoomDao();
	    }
	 public static WorkerDao getWorkerDao() {
	        return new WorkerDao();
	    }
	 
	 public static PaymentDao getPaymentDao()
	 {
		 return new PaymentDao();
	 }
}
