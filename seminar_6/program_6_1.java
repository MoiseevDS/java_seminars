package seminar_6;

import java.util.*;

public class program_6_1 {
    public static void main(String[] args) {
        Notebook notebook_1 = new Notebook(128, 500, "Windows", "silver");
        Notebook notebook_2 = new Notebook(256, 1000, "Linux", "silver");
        Notebook notebook_3 = new Notebook(64, 250, "Windows", "black");
        Notebook notebook_4 = new Notebook(256, 1000, "Windows", "white");
        Notebook notebook_5 = new Notebook(512, 3000, "Linux", "black");
        Notebook notebook_6 = new Notebook(256, 500, "Linux", "black");
        ArrayList<Notebook> notebooks = new ArrayList<>(
                Arrays.asList(notebook_1, notebook_2, notebook_3, notebook_4, notebook_5, notebook_6));
        System.out.println(
                "Здравствуйте! Для подбора параметров ноутбука введите последовательно критерии вашего выбора!");
        Map<String, Integer> mapOptions = new HashMap<>();
        mapOptions.put("amountRam", 0);
        mapOptions.put("hardDiskCapacity", 0);
        mapOptions.put("systemOperating", 0);
        mapOptions.put("colour", 0);
        Notebook.printInvitationForUser(mapOptions);
        Scanner scn = new Scanner(System.in);

        int numberOption = -1;
        Set<Integer> setNumbersOptions = new HashSet<>();

        while (numberOption != 0) {
            if (setNumbersOptions.size() == 0) {
                numberOption = scn.nextInt();
                if (!Notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                    break;
                }
                setNumbersOptions.add(numberOption);
            }

            if (numberOption == 1) {
                System.out.println("Введите минимальный объем ОЗУ! ");
                int minAmountRam = scn.nextInt();
                mapOptions.put("amountRam", minAmountRam);
                Notebook.printInvitationForUser(mapOptions);
                numberOption = scn.nextInt();

                if (!Notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                    break;
                }
                setNumbersOptions.add(numberOption);
            }

            if (numberOption == 2) {
                System.out.println("Введите минимальный объем ЖД! ");
                int minHardDiskCapacity = scn.nextInt();
                mapOptions.put("hardDiskCapacity", minHardDiskCapacity);
                Notebook.printInvitationForUser(mapOptions);
                numberOption = scn.nextInt();

                if (!Notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                    break;
                }
                setNumbersOptions.add(numberOption);
            }

            if (numberOption == 3) {
                System.out.println("Для выбора \"Windows\" введите 1,\n для выбора \"Linux\" введите 2:\n");
                int numberSystemOperating = scn.nextInt();
                if (numberSystemOperating != 1 && numberSystemOperating != 2) {
                    System.out.println("Ввели некорректный номер системы!!!");
                } else {
                    mapOptions.put("systemOperating", numberSystemOperating);
                    Notebook.printInvitationForUser(mapOptions);
                    numberOption = scn.nextInt();

                    if (!Notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                        break;
                    }
                    setNumbersOptions.add(numberOption);
                }
            }

            if (numberOption == 4) {
                System.out.println(
                        "Для выбора цвета \"серебристый\" введите 1,\n для выбора \"белый\" введите 2:\n, для выбора \"черный\" введите 3:\n");
                int numberColour = scn.nextInt();
                if (numberColour < 1 && numberColour > 3) {
                    System.out.println("Ввели некорректный номер цвета!!!");
                } else {
                    mapOptions.put("colour", numberColour);
                    if (setNumbersOptions.size() == 4) {
                        break;
                    }
                    Notebook.printInvitationForUser(mapOptions);
                    numberOption = scn.nextInt();
                    if (!Notebook.checkNumberOption(numberOption, setNumbersOptions)) {
                        break;
                    }
                }
            }
        }

        ArrayList<Notebook> setResult = Notebook.getNotebookSetByOptions(notebooks, mapOptions);
        if (setResult.size() == 0) {
            System.out.println("К сожалению, по выбранным вами критериям ноутбуков нет!!!");
        } else {
            System.out.println("По выбранным вами критериям мы можем предложить следующий список ноутбуков:");
            System.out.println(setResult);
        }
        scn.close();
    }
}
