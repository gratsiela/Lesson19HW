//Да се създаде програма в която се създава обект от клас AllWork, който
//се запълва със задачи(10-12 задачи) с различно време. Да се създадът
//и няколко (3-4) работника. В един безкраен цикъл, да се даде старт на
//работата и всички работници да започнат да си теглят задачи и да
//работят по тях. Всяка итерация на цикъла е 1 ден в офиса и приключва
//когато всичките работници си изработят 8те часа за деня.
class Demo {

	public static void main(String[] args) {

		AllWork allWork = new AllWork();
		allWork.addTask(new Task("task 1", 10));
		allWork.addTask(new Task("task 2", 10));
		allWork.addTask(new Task("task 3", 5));
		allWork.addTask(new Task("task 4", 20));
		allWork.addTask(new Task("task 5", 5.5));
		allWork.addTask(new Task("task 6", 3));
		allWork.addTask(new Task("task 7", 3.5));
		allWork.addTask(new Task("task 8", 4));
		allWork.addTask(new Task("task 9", 4.5));
		allWork.addTask(new Task("task 10", 2));

		Employee[] employees = new Employee[4];
		employees[0] = new Employee("Employee 1");
		employees[1] = new Employee("Employee 2");
		employees[2] = new Employee("Employee 3");
		employees[3] = new Employee("Employee 4");

		// След като се стартира програмата, да започнат да текът дните, всички
		// работници трябва да започват да работят и да се извежда съобщение за
		// това в кой ден, кой работник какво да прави.
		boolean areAllEmployeesValid = true;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				areAllEmployeesValid = false;
				break;
			} else {
				if (employees[i].isEmployeeValid() == false) {
					areAllEmployeesValid = false;
					break;
				}
			}
		}

		if (areAllEmployeesValid && allWork.isAllWorkValid()) {
			for (int i = 0; i < employees.length; i++) {
				employees[i].setCurrentTask(allWork.getNextTask());
				employees[i].setAllWork(allWork);
			}

			for (int day = 1;; day++) {
				System.out.println();
				System.out.println("||||||||||");
				System.out.println("Start NEW DAY N" + day + ": ");
				System.out.println("||||||||||");
				for (int i = 0; i < employees.length; i++) {// for every
															// employee
															// start new day
					employees[i].startWorkingDay();
				}
				boolean endOfTheDay = true;
				for (int i = 0; i < employees.length; i++) {
					if (employees[i].getCurrentTask() == null) {// if there is
																// no
																// more tasks to
																// get
						continue;
					}
					employees[i].work();
					if (employees[i].getHoursLeft() != 0) {// if the working day
															// of
															// at least one
															// employee
															// is not finished
						endOfTheDay = false;
					}
					if (allWork.isAllWorkDone() == true) {// if the all work is
															// done
															// break
						break;
					}
				}
				if (endOfTheDay == true) {// if the working days of all
											// employees
											// are finished continue to the next
											// day
					System.out.println();
					System.out.println("||||||||||");
					System.out.println("END of DAY N" + day + ". ");
					System.out.println("||||||||||");
				}
				if (allWork.isAllWorkDone() == true) {
					System.out.println();
					System.out.println("----------");
					System.out.println("The all work is done.");
					System.out.println("----------");
					break;
				}
			}
		} else {
			System.out.println("There is invalid information about the tasks or about the employees.");
		}
	}

}
