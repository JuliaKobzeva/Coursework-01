import java.util.Arrays;

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
        Employee iGoncharov = new Employee("Игорь Денисович Гончаров", 5, 65000);
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

        int maxExpense = countMaxExpense(list);
        System.out.println("Максимальная зарплата " + maxExpense + " руб");

        String nameMinExpense = getToKnowNameMinExpense(list);
        System.out.println("Сотрудник с минимальной зарплатой: " + nameMinExpense);

        int minExpense = countMinExpense(list);
        System.out.println("Минимальная зарплата " + minExpense + " руб");

        int averageSalary = countAverageSalary (list);
        System.out.println("Средняя зарплата: " + averageSalary + " руб");

        getToKnowName(list);

    }

    //Статические методы

    private static void printAll (Employee list[]) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    private static int countSum (Employee list[]) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
                sum = sum + list[i].getSalary();
        }
        return sum;
    }

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

    private static int countMaxExpense (Employee list[]) {
        int maxExpense = -1;

        for (int i = 0; i < list.length; i++) {
            if (list[i].getSalary() > maxExpense) {
                maxExpense = list[i].getSalary();
            }
        }

        return maxExpense;
    }

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

    private static int countMinExpense (Employee list[]) {
        int minExpense = list[0].getSalary();

        for (int i = 0; i < list.length; i++) {
            if (list[i].getSalary() < minExpense){
                minExpense = list[i].getSalary();
            }
        }
        return minExpense;
    }

    private static int countAverageSalary (Employee list[]) {
        int sum = countSum (list);
        int averageSalary = sum / list.length;

        return averageSalary;
    }

    private static void getToKnowName (Employee list[]) {

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].getName());
        }
    }

}