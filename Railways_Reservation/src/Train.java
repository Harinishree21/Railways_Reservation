
public class Train {
	private int trainNo;
	private boolean ac;
	private int capacity;
	
	Train(int no,boolean ac,int cap){
		this.trainNo =no;
		this.ac = ac;
		this.capacity = cap;
	}
	
	public int getTrainNo() {
		return trainNo;
	}
	public boolean isAc() {
		return ac;
	}

	public int getCapacity() { 
		return capacity;
	}

	public void setAc(boolean val) { 
		ac = val;
	}

	public void setCapacity(int cap) { 
		capacity = cap;
	}

}


