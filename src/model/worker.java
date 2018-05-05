package model;

public class worker {
	String workerid;
	String worker_name; 
	String worker_gender; 
	String worker_age; 
	String workerpwd; 
	public worker() {
		// TODO Auto-generated constructor stub
	}
	public worker(String workerid,String worker_name,String worker_gender,String worker_age,String workerpwd)
	{
		this.worker_age=worker_age;
		this.worker_gender=worker_gender;
		this.worker_name=worker_name;
		this.workerid= workerid;
		this.workerpwd=workerpwd;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getWorker_gender() {
		return worker_gender;
	}

	public void setWorker_gender(String worker_gender) {
		this.worker_gender = worker_gender;
	}

	public String getWorker_age() {
		return worker_age;
	}

	public void setWorker_age(String worker_age) {
		this.worker_age = worker_age;
	}

	public String getWorkerpwd() {
		return workerpwd;
	}

	public void setWorkerpwd(String workerpwd) {
		this.workerpwd = workerpwd;
	}

}
