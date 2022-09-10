import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Employee dSazonova = new Employee("Дарья Васильевна Сазонова", 1, 47000);
        Employee iVoronzov = new Employee("Игорь Борисович Воронцов", 1, 63000);
        Employee mIvanova = new Employee("Мария Павловна Иванова", 2, 55000);
        Employee dBorisov = new Employee("Денис Иванович Борисов", 2, 57000);
        Employee jEliseeva = new Employee("Юлия Николаевна Елисеева", 3, 65000);
        Employee pFirsov = new Employee("Павел Иванович Фирсов", 3, 48000);
        Employee gPokidov = new Employee("Григорий Николаевич Покидов", 4, 50000);
        Employee oGoraynova = new Employee("Оксана Михайловна Горяйнова", 4, 45000);
        Employee iGoncharov = new Employee("Игорь Денисович Гончаров", 4, 65000);
        Employee sLivanova = new Employee("Светлана Савельевна Ливанова", 5, 53000);

        Employee[] list = new Employee[10];
        list[0] = dSazonova;
        list[1] = iVoronzov;
        list[2] = mIvanova;
        list[3] = dBorisov;
        list[4] = jEliseeva;
        list[5] = pFirsov;
        list[6] = gPokidov;
        list[7] = oGoraynova;
        list[8] = iGoncharov;
        list[9] = sLivanova;

        printAll(list);

        int sum = countSum (list);
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum + " руб");

        String nameMaxExpense = getToKnowNameMaxExpense(list);
        System.out.println("Сотрудник с максимальной зарплатой: " + nameMaxExpense);

        String nameMinExpense = getToKnowNameMinExpense(list);
        System.out.println("Сотрудник с минимальной зарплатой: " + nameMinExpense);

        int averageSalary = countAverageSalary (list);
        System.out.println("Средняя зарплата: " + averageSalary + " руб");

        getToKnowName(list);
        countId(list);

        //Повышенная сложность

        increaseSalary(5, list);

        printAllInDepartment (4, list);

        getToKnowNameMaxExpenseInDepartment(4, list);
        getToKnowNameMinExpenseInDepartment(4, list);
        getToKnowSumInDepartment(4, 3, list);
        getToKnowAverageSalaryInDepartment(4, 3, list);
        increaseSalaryInDepartment(4, 3,5,list);

        getToKnowPersonInDepartmentWithSalaryLessThan(4,50000,list);
        getToKnowPersonInDepartmentWithSalaryMoreThan(4,50000,list);

    }

    //Статические методы

    // список всех сотрудников со всеми имеющимися по ним данными

    private static void printAll (Employee list[]) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    //сумма затрат на зарплаты в месяц

    private static int countSum (Employee list[]) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
                sum = sum + list[i].getSalary();
        }
        return sum;
    }

    //найти сотрудника с максимальной зарплатой

    private static String getToKnowNameMaxExpense (Employee list[]) {
        int maxExpense = -1;
        String nameMaxExpense = null;

        for (int i = 0; i < list.length; i++) {
            if (list[i].getSalary() > maxExpense) {
                maxExpense = list[i].getSalary();
               nameMaxExpense = list[i].getName();
            }
        }

        return nameMaxExpense;
    }

    //найти сотрудника с минимальной зарплатой

    private static String getToKnowNameMinExpense (Employee list[]) {
        int minExpense = list[0].getSalary();
        String nameMinExpense = list[0].getName();

        for (int i = 0; i < list.length; i++) {
            if (list[i].getSalary() < minExpense){
                minExpense = list[i].getSalary();
                nameMinExpense = list[i].getName();
            }
        }
        return nameMinExpense;
    }

    //найти среднюю зарплату

    private static int countAverageSalary (Employee list[]) {
        int sum = countSum (list);
        int averageSalary = sum / list.length;

        return averageSalary;
    }

    //получить Ф. И. О. всех сотрудников

    private static void getToKnowName (Employee list[]) {

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].getName());
        }
    }

    //вывести Ф. И. О. сотрудников и их Id

    private static void countId (Employee list[]) {

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].getId() + " " + list[i].getName());
        }
    }

    //Повышенная сложность

    //проиндексировать зарплату

    private static void increaseSalary (int percent, Employee list[]) {
        for (int i = 0; i < list.length; i++) {
            list[i].setSalary(list[i].getSalary() + list[i].getSalary()/100 * percent);
            System.out.println(list[i].getId() + " " + list[i].getSalary());
        }
    }

    //напечатать всех сотрудников отдела

    private static void printAllInDepartment (int department, Employee list[]) {

        for (int i = 0; i < list.length; i++)  {
            if (list[i].getDepartment() == department){
                System.out.println(list[i].getId() + " " + list[i].getName() + ", зарплата: " + list[i].getSalary() + " руб");
            }
        }
    }

    //найти сотрудника с максимальной зарплатой

    //Не выводит нужного сотрудника, хотя логика такая же, как в методе для всех отделов, и там она работает

    private static void getToKnowNameMaxExpenseInDepartment (int department, Employee list[]) {
        int maxExpense = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getDepartment() == department && list[i].getSalary() > maxExpense) {
                maxExpense = list[i].getSalary();
                System.out.println("Сотрудник в отделе с максимальной зарплатой: " + list[i].getName());
            }
        }
    }


    //найти сотрудника с минимальной зарплатой

    private static void getToKnowNameMinExpenseInDepartment (int department, Employee list[]) {
        int minExpense = list[0].getSalary();
        for (int i = 0; i < list.length; i++)  {
            if (list[i].getDepartment() == department && list[i].getSalary() < minExpense){
                minExpense = list[i].getSalary();
                System.out.println("Сотрудник в отделе с минимальной зарплатой: " + list[i].getName());
            }
        }
    }

    //найти сумму затрат на зарплату по отделу

    private static void getToKnowSumInDepartment (int department, int numberOfPeople, Employee list[]) {
        for (int i = 0; i < list.length; i++)  {
            int [] sum = new int [numberOfPeople];
            sum[0] = list[i].getSalary();

            for(int j = 1 ; j <= sum.length-1; j++) {
                sum[numberOfPeople - j] = list[i + (numberOfPeople-j)].getSalary();
            }

            int result = IntStream.of(sum).sum();

            if (list[i].getDepartment() == department){
                System.out.println("Сумма затрат на зарплату по отделу: " + result);
                break;
            }
        }
    }

    //найти среднюю зарплату по отделу

    private static void getToKnowAverageSalaryInDepartment (int department, int numberOfPeople, Employee list[]) {
        for (int i = 0; i < list.length; i++)  {

            int [] sum = new int [numberOfPeople];
            sum[0] = list[i].getSalary();

            for(int j = 1 ; j <= sum.length-1; j++) {
            sum[numberOfPeople - j] = list[i + (numberOfPeople-j)].getSalary();
            }

            int result = IntStream.of(sum).sum();

            if (list[i].getDepartment() == department){
                int averageSalary = result/ numberOfPeople;
                System.out.println("Средняя зарплата по отделу: " + averageSalary);
                break;
            }
        }
    }

    //проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра

    private static void increaseSalaryInDepartment (int department, int numberOfPeople, int percent, Employee list[]) {
        for (int i = 0; i < list.length; i++)  {
            if (list[i].getDepartment() == department){
                int [] newSalary = new int [numberOfPeople];
                newSalary[numberOfPeople-1] = list[i].getSalary() + list[i].getSalary()/100 * percent;

                System.out.println("Зарплата после индексирования: " + newSalary[numberOfPeople-1] + " руб (" + list[i].getName()+ ")");
            }
        }
    }

    //вывести всех сотрудников с зарплатой меньше числа

    private static void getToKnowPersonInDepartmentWithSalaryLessThan (int department, int number, Employee list[]) {
        for (int i = 0; i < list.length; i++)  {
            if (list[i].getDepartment() == department && list[i].getSalary() < number){
                System.out.println(list[i].getId() + " " + list[i].getName() + ", зарплата: " + list[i].getSalary() + " руб");
            }
        }
    }

    //вывести всех сотрудников с зарплатой больше числа

    private static void getToKnowPersonInDepartmentWithSalaryMoreThan (int department, int number, Employee list[]) {
        for (int i = 0; i < list.length; i++)  {
            if (list[i].getDepartment() == department && list[i].getSalary() > number){
                System.out.println(list[i].getId() + " " + list[i].getName() + ", зарплата: " + list[i].getSalary() + " руб");
            }
        }
    }

}