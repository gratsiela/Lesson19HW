//Да се създаде клас AllWork, които репрезентира множеството от всички
//задачи, които трябва да свършат работниците в офиса.
class AllWork {

	// Класът да съдържа следните полета:
	// - tasks – масив, съдържащ всички задачи
	// - freePlacesForTasks – числова стойност, която показва колко
	// свободни места за нови задачи има в масива (след създаване на обекта
	// AllWork, в него няма добавени задачи и тази стойност е 10)
	// currentUnassignedTask – указва индекса на текущата свободна(по
	// която няма работник които да работи) задача.
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;

	// Всяка задача може да бъде давана на точно 1 работник, които да
	// работи по нея. Когато някои работник си свърши задачата, той си взима
	// от обекта AllWork първата свободна задача. Това поле указва индекса
	// на текущата такава задача в масива tasks (началната му стойност е 0 –
	// първата задача)
	// Да се направи констуктор без параметри, който инициализира по
	// подходящ начин полетата на AllWork
	// метод addTask, чрез който се добавя задача към множеството от задачи
	// метод getNextTask който връща следващата незаета задача.
	// Метод isAllWorkDone, който проверява, дали всички задачи са
	// направени (една задача е направена, ако по нея остават 0 часа работа)
	AllWork() {
		tasks = new Task[10];
		this.freePlacesForTasks = 10;
		this.currentUnassignedTask = 0;
	}

	void addTask(Task task) {
		if (this.freePlacesForTasks > 0) {
			this.tasks[this.tasks.length - this.freePlacesForTasks] = task;
			this.freePlacesForTasks--;
		}
	}

	Task getNextTask() {
		if (this.currentUnassignedTask < 10) {
			return this.tasks[this.currentUnassignedTask++];
		} else {
			return null;
		}
	}

	boolean isAllWorkDone() {
		for (int i = 0; i < this.tasks.length; i++) {
			if (this.tasks[i].getWorkingHours() != 0) {
				return false;
			}
		}
		return true;
	}

	boolean isAllWorkValid() {
		for (int i = 0; i < this.tasks.length; i++) {
			if (this.tasks[i] == null) {
				return false;
			} else {
				if (this.tasks[i].isTaskValid() == false) {
					return false;
				}
			}
		}
		return true;
	}
}
