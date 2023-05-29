package seminar_6;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

//1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//2. Создать множество ноутбуков.
//3. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
//NoteBook notebook1 = new NoteBook
//NoteBook notebook2 = new NoteBook
//NoteBook notebook3 = new NoteBook
//NoteBook notebook4 = new NoteBook
//NoteBook notebook5 = new NoteBook
//        Например:	“Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет
// 4. Далее нужно запросить минимальные значения для указанных критериев -
//   сохранить параметры фильтрации можно также в Map.
// 5. Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
//   Класс сделать в отдельном файле: приветствие
//                                   Выбор параметра
//                                   выбор конкретнее
//                                   вывод подходящих
public class Notebook {
    private int amountRam;
    private int hardDiskCapacity;
    private String systemOperating;
    private String colour;

    public void setAmountRam(int amountRam) {
        this.amountRam = amountRam;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public void setSystemOperating(String systemOperating) {
        this.systemOperating = systemOperating;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAmountRam() {
        return amountRam;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getSystemOperating() {
        return systemOperating;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return String.format("amountRam = %d, hardDiskCapacity = %d, systemOperating = %s, colour = %s\n", amountRam,
                hardDiskCapacity, systemOperating, colour);
    }

    public Notebook(int amountRam, int hardDiskCapacity, String systemOperating, String colour) {
        this.amountRam = amountRam;
        this.hardDiskCapacity = hardDiskCapacity;
        this.systemOperating = systemOperating;
        this.colour = colour;
    }

    public static int getIndexSystemOperating(String sysOper) {
        if (sysOper.equals("Windows")) {
            return 1;
        }
        if (sysOper.equals("Linux")) {
            return 2;
        }
        return 0;
    }

    public static int getIndexColour(String colour) {
        if (colour.equals("silver")) {
            return 1;
        }
        if (colour.equals("white")) {
            return 2;
        }
        if (colour.equals("black")) {
            return 3;
        }
        return 0;
    }

    public static boolean checkNumberOption(int numberOption, Set<Integer> setNumbersOptions) {
        if (numberOption == 0) {
            return false;
        }
        if (numberOption < 0 && numberOption > 4) {
            System.out.println("Ввели некорректный номер критерия выбора!!!");
            return false;
        }
        if (setNumbersOptions.contains(numberOption)) {
            System.out.println("Такой номер критерия уже выбран!!!");
            return false;
        }
        return true;
    }

    public static void printInvitationForUser(Map<String, Integer> mapOptions) {
        int indexAmountRam = mapOptions.get("amountRam");
        int indexHardDiskCapacity = mapOptions.get("hardDiskCapacity");
        int indexSystemOperating = mapOptions.get("systemOperating");
        int indexColour = mapOptions.get("colour");
        StringBuilder strb = new StringBuilder();
        if (indexAmountRam == 0 || indexHardDiskCapacity == 0 && indexSystemOperating == 0 && indexColour == 0) {
            strb.append("Введите цифру, соответствующую необходимому критерию:\n");
        }

        if (indexAmountRam == 0) {
            strb.append(" 1 - ОЗУ\n");
        }
        if (indexHardDiskCapacity == 0) {
            strb.append(" 2 - Объем ЖД\n");
        }
        if (indexSystemOperating == 0) {
            strb.append(" 3 - Операционная система\n");
        }
        if (indexColour == 0) {
            strb.append(" 4 - Цвет\n");
        }
        System.out.println(strb.append(" 0 - для завершения выбора\n").toString());
    }

    public static ArrayList<Notebook> getNotebookSetByOptions(ArrayList<Notebook> setNotebooks,
            Map<String, Integer> mapOptions) {
        int indexSystemOperating = mapOptions.get("systemOperating");
        int indexColour = mapOptions.get("colour");
        int minAmountRam = 0;
        if (mapOptions.containsKey("amountRam")) {
            minAmountRam = mapOptions.get("amountRam");
        }
        int minHardDiskCapacity = 0;
        if (mapOptions.containsKey("hardDiskCapacity")) {
            minHardDiskCapacity = mapOptions.get("hardDiskCapacity");
        }
        ArrayList<Notebook> setResult = new ArrayList<>();
        for (int i = 0; i < setNotebooks.size(); i++) {
            if (setNotebooks.get(i).amountRam >= minAmountRam &&
                    setNotebooks.get(i).hardDiskCapacity >= minHardDiskCapacity) {
                if (indexSystemOperating == 0 && indexColour == 0) {
                    setResult.add(setNotebooks.get(i));
                } else if (indexSystemOperating == 0
                        && getIndexColour(setNotebooks.get(i).colour) == mapOptions.get("colour")) {
                    setResult.add(setNotebooks.get(i));
                } else if (indexColour == 0
                        && getIndexSystemOperating(setNotebooks.get(i).systemOperating) == mapOptions
                                .get("systemOperating")) {
                    setResult.add(setNotebooks.get(i));
                } else if (getIndexSystemOperating(setNotebooks.get(i).systemOperating) == mapOptions
                        .get("systemOperating")
                        && getIndexColour(setNotebooks.get(i).colour) == mapOptions.get("colour")) {
                    setResult.add(setNotebooks.get(i));
                }
            }
        }
        return setResult;
    }
}