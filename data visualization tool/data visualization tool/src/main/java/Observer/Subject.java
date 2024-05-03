package Observer;
//main GUI is implementing the Subject 
public interface Subject {
	void subscribe (Viewer viewer);
	void unSubscribe(Viewer viewer);
	void notifySubscriber();
	// void upload (String title); 
}
