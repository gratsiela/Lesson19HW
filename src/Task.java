
class Task {

	private final String name;// all tasks can have different names, but once a
								// task with name is created, the name can not
								// be changed
	private double workingHours;// the workingHours can be changed, because it
								// is necessary

	Task(String name, double workingHours) {// default
		if (name.trim().length() > 0) {
			this.name = name;
		} else {
			this.name = null;
		}
		if (workingHours > 0) {
			this.workingHours = workingHours;
		} else {
			this.workingHours = 0;
		}
	}

	String getName() {// default
		return this.name;
	}

	double getWorkingHours() {// default
		return this.workingHours;
	}

	void setWorkingHours(double workingHours) {// default
		this.workingHours = workingHours;
	}

	boolean isTaskValid() {
		if (this.name != null && this.workingHours > 0) {
			return true;
		} else {
			return false;
		}
	}
}
