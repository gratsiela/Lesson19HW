
class Employee {

	private final String name;// the name of an employee can not be changed
	private Task currentTask;
	private double hoursLeft;

	// поле allWork – референция към множеството от всичките задачи.
	// Всички работници работят с едно множество от задачи
	static private AllWork allWork;

	Employee(String name) {
		if (name.trim().length() > 0) {
			this.name = name;
		} else {
			this.name = null;
		}
	}

	String getName() {
		return this.name;
	}

	Task getCurrentTask() {
		return this.currentTask;
	}

	void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	double getHoursLeft() {
		return this.hoursLeft;
	}

	void setHoursLeft(double hoursLeft) {
		this.hoursLeft = hoursLeft;
	}

	AllWork getAllWork() {
		return this.allWork;
	}

	void setAllWork(AllWork allWork) {
		this.allWork = allWork;
	}

	// Всеки работник разполага всеки ден с 8 часа за работа.
	// Целта е да се направи симулация на работен процес в офис, където има
	// много работници които целят да свършат всичката работа (AllWork).
	// Всеки един работник работи всеки ден, докато не му свърши времето за
	// деня, или докато всички задачи не са направени. Ако работник свърши
	// цялата работа по текущата му задача, той взима следващата свободна
	// задача (метода getNextTask) и продължава да работи.
	// Симулацията ще се разиграва на дни, като деня ще свършва когато
	// всички работници си изработят часовете. Тогава ще започва и нов ден.
	// Направете метод на класа Employee startWorkingDay() който просто
	// задава нови 8 часа за работа на работник (това ще става в началото на
	// всеки ден)
	// Променете метода work(), така, че да отговаря на условията описани
	// по-горе: във всеки един момент всеки работник има 1 текуща задача
	// (ако няма такава, си взима следващата свободна). Той работи по нея
	// докато не му свърши времето за деня (края на деня). На другия ден
	// продължава работа по нея. И така докато не завърши задачата. След
	// това взема следващата свободна задача. Възможно е да свърши новата
	// задача в рамките на същият ден, тогава отново си тегли задача. И така
	// това се повтаря, ден след ден, докато не свършат свободните задачи.
	// Методите в класа Employee да се допълнят с подходящи съобщения,
	// така че да се извеждат съобщения при всяко действие от страна на
	// някой работник (взимане на нова задача, работене по текущата
	// задача), за начало на нов работен ден и всичко необходимо за да се
	// проследи изпълнението на програмата.
	void work() {// работи ако има задача и ако не му е свършил работния ден..
		if (this.currentTask != null && this.hoursLeft > 0) {
			if (this.currentTask.getWorkingHours() > 0) {// ако задачата не е
															// вече изпълнена, в
															// противен случай
															// взима нова и
															// работи
				if (this.hoursLeft >= this.currentTask.getWorkingHours()) {
					this.hoursLeft -= this.currentTask.getWorkingHours();
					this.currentTask.setWorkingHours(0);
				} else {
					this.currentTask.setWorkingHours(this.currentTask.getWorkingHours() - this.hoursLeft);
					this.hoursLeft = 0;
				}
				showReport();
				work();
			} else {
				this.currentTask = this.allWork.getNextTask();
				work();
			}
		}
	}

	private void showReport() {
		System.out.println("\nReport: ");
		System.out.println("employee: " + this.name);
		System.out.println("worked on: " + this.currentTask.getName());
		if (this.hoursLeft > 0) {
			System.out
					.println(this.hoursLeft + " working hours left till the end of the working day of this employee.");
		} else {
			System.out.println("The working day of this employee finished.");
		}
		if (this.currentTask.getWorkingHours() > 0) {
			System.out.println(this.currentTask.getWorkingHours() + " working hours left till this task is done.");
		} else {
			System.out.println("This task is done.");
		}
	}

	void startWorkingDay() {
		this.hoursLeft = 8;
	}

	boolean isEmployeeValid() {
		if (this.name != null) {
			return true;
		} else {
			return false;
		}
	}
}
