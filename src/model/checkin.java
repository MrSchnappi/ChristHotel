package model;

public class checkin {
		String checkin_roomid;
		String checkin_clientid; 
		String checkinnum;
		String checkintime; 
		String checkinmoney;
		String checkininfo; 
		String  departuretime;
		String clientname;
		public String getClientname() {
			return clientname;
		}

		public void setClientname(String clientname) {
			this.clientname = clientname;
		}

		public checkin(){
			
		}
		
		public checkin(	String checkin_roomid,String checkin_clientid,String checkintime, 
				String checkinnum,String checkininfo,String  departuretime,String checkinmoney)
		{
			this.checkin_clientid=checkin_clientid;
			this.checkin_roomid=checkin_roomid;
			this.checkininfo=checkininfo;
			this.checkinmoney=checkinmoney;
			this.checkinnum=checkinnum; 
			this.departuretime=departuretime;
			this.checkintime=checkintime;
}

		public String getCheckin_roomid() {
			return checkin_roomid;
		}

		public void setCheckin_roomid(String checkin_roomid) {
			this.checkin_roomid = checkin_roomid;
		}

		public String getCheckin_clientid() {
			return checkin_clientid;
		}

		public void setCheckin_clientid(String checkin_clientid) {
			this.checkin_clientid = checkin_clientid;
		}

		public String getCheckinnum() {
			return checkinnum;
		}

		public void setCheckinnum(String checkinnum) {
			this.checkinnum = checkinnum;
		}

		public String getCheckintime() {
			return checkintime;
		}

		public void setCheckintime(String checkintime) {
			this.checkintime = checkintime;
		}

		public String getCheckinmoney() {
			return checkinmoney;
		}

		public void setCheckinmoney(String checkinmoney) {
			this.checkinmoney = checkinmoney;
		}

		public String getCheckininfo() {
			return checkininfo;
		}

		public void setCheckininfo(String checkininfo) {
			this.checkininfo = checkininfo;
		}

		public String getDeparturetime() {
			return departuretime;
		}

		public void setDeparturetime(String departuretime) {
			this.departuretime = departuretime;
		}
		
}
