package Accounting_system_for_the_kennel;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class main {
    private static List<animal> animals = new ArrayList<>();
    private static final String FILE_NAME = "animals.dat";
    private static Scanner scanner = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        loadAnimals();

        if (animals.isEmpty()) {
            inputInitialData();
        }

        boolean exit = false;
        while (!exit) {
            print_menu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    add_new_animal();
                    break;
                case 2:
                    remove_animal_by_id();
                    break;
                case 3:
                    list_animals_by_birth_date();
                    break;
                case 4:
                    list_animal_commands();
                    break;
                case 5:
                    train_animal();
                    break;
                case 6:
                    list_all_animals();
                    break;
                case 7:
                    saveAnimals();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void inputInitialData() {
        animals.add(new cat("Мурка", LocalDate.of(2019, 1, 15), "Шотландская вислоухая", "Прыгать, кушать, спать"));
        animals.add(new cat("Барсик", LocalDate.of(2018, 6, 20), "Персидская", "Ласкаться, спать на коленях"));
        animals.add(new dog("Бобик", LocalDate.of(2017, 7, 20), "Джек-рассел-терьер", "Сидеть, лежать, апорт"));
        animals.add(new dog("Рекс", LocalDate.of(2019, 3, 10), "Лабрадор", "Фас, в положение, место"));
        animals.add(new dog("Макс", LocalDate.of(2016, 11, 5), "Немецкая овчарка", "Фу, к ноге, апорт"));
        animals.add(new hamster("Хома", LocalDate.of(2020, 4, 22), "Сирийский хомяк", "Крутиться в колесе, кушать семечки"));
        animals.add(new hamster("Буся", LocalDate.of(2021, 2, 12), "Роборовский хомяк", "Бегать по трубочке, кушать овощи"));
        animals.add(new horse("Буран", LocalDate.of(2014, 8, 28), "Арабская скаковая лошадь", "Верховая езда, рыскание"));
        animals.add(new horse("Амур", LocalDate.of(2017, 5, 10), "Фризский конь", "Верховая езда, выездка"));
        animals.add(new horse("Гроза", LocalDate.of(2018, 12, 1), "Тройцкий скакун", "Верховая езда, скакать по препятствиям"));
        animals.add(new horse("Зорька", LocalDate.of(2016, 2, 20), "Белорусская упряжная", "Тянуть плуг, возить грузы"));
        animals.add(new horse("Пегас", LocalDate.of(2015, 9, 15), "Андалузский скакун", "Верховая езда, выступление на шоу"));
        animals.add(new camel("Маруся", LocalDate.of(2016, 11, 12), "Двугорбый верблюд", "Переносить грузы, переносить людей"));
        animals.add(new camel("Баклажан", LocalDate.of(2019, 3, 24), "Барханец", "Перевозка грузов, использование шерсти и мяса"));
        animals.add(new camel("Жемчуг", LocalDate.of(2017, 5, 28), "Дромадер", "Длительные походы, перенос песка и воды"));
        animals.add(new camel("Сафари", LocalDate.of(2018, 10, 10), "Каракумский верблюд", "Туристические поездки, перевозка туристов"));
        animals.add(new donkey("Иван", LocalDate.of(2019, 9, 5), "Американский миниатюрный ослик", "Тянуть повозки, нести грузы"));
        animals.add(new donkey("Матильда", LocalDate.of(2020, 12, 18), "Андалузский ослик", "Переносить грузы, работать в сельском хозяйстве"));
        animals.add(new donkey("Грейси", LocalDate.of(2018, 4, 3), "Малтезский ослик", "Тянуть плуги, работать на ферме"));
        animals.add(new donkey("Барней", LocalDate.of(2017, 8, 22), "Каракульский ослик", "Нести грузы, использоваться в туризме"));
    }

    private static void print_menu() {
        System.out.println("Меню для выбора команнд");
        System.out.println("Введите 1, что бы добавить новое животное");
        System.out.println("Введите 2, что бы удалить животное по id");
        System.out.println("Введите 3, чтобы показать животных по дате рождения");
        System.out.println("Введите 4, чтобы увидеть список команд, которые выполняет животное");
        System.out.println("Введите 5, чтобы обучить животное новым командам");
        System.out.println("Введите 6, чтобы отобразить всех животных");
        System.out.println("Введите 7, чтобы выйти");
    }

    private static int generateUniqueId() {
        int maxId = 0;
        for (animal animal : animals) {
            if (animal.getId() > maxId) {
                maxId = animal.getId();
            }
        }
        return maxId + 1;
    }

    private static void add_new_animal() {
        System.out.print("Введите тип животного (Кот, Собака, Хомяк, Лошадь, Верблюд, Осел): ");
        String type = scanner.nextLine();
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите породу: ");
        String breed = scanner.nextLine();
        System.out.print("Введите начальные команды (через запятую): ");
        String commands = scanner.nextLine();

        animal animal = null;
        switch (type.toLowerCase()) {
            case "кот":
                animal = new cat(name, birthDate, breed, commands);
                break;
            case "собака":
                animal = new dog(name, birthDate, breed, commands);
                break;
            case "хомяк":
                animal = new hamster(name, birthDate, breed, commands);
                break;
            case "лошадь":
                animal = new horse(name, birthDate, breed, commands);
                break;
            case "верблюд":
                animal = new camel(name, birthDate, breed, commands);
                break;
            case "осел":
                animal = new donkey(name, birthDate, breed, commands);
                break;
            default:
                System.out.println("Неизвестный тип животного. Попробуйте снова.");
                return;
        }

        // Генерация уникального ID
        int id = generateUniqueId();
        animal.setId(id);

        animals.add(animal);
        System.out.println("Животное успешно добавлено. ID: " + id);
    }

    private static void remove_animal_by_id() {
        System.out.print("Введите ID животного для удаления: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = animals.removeIf(animal -> animal.getId() == id);
        if (removed) {
            System.out.println("Животное с ID " + id + " успешно удалено.");
        } else {
            System.out.println("Животное с ID " + id + " не найдено.");
        }
    }

    private static void list_animals_by_birth_date() {
        Collections.sort(animals, Comparator.comparing(animal::getBirth_date));

        for (animal animal : animals) {
            System.out.println("Тип: " + animal.getAnimalType() + ", Имя: " + animal.getName() +
                    ", Дата рождения: " + animal.getBirth_date() +
                    ", Порода: " + animal.getBreed() +
                    ", Команды: " + animal.getCommands());
        }
    }

    private static animal findAnimalByName(String name) {
        for (animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    private static void list_animal_commands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        animal animal = findAnimalByName(name);

        if (animal != null) {
                System.out.println("Команды для " + animal.getName() + ": " + animal.getCommands());
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private static void train_animal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        animal animal = findAnimalByName(name);

        if (animal != null) {
            System.out.print("Введите новую команду, чтобы научить: ");
            String newCommand = scanner.nextLine();
            animal.addCommand(newCommand);
            System.out.println("Команды-а успешно добавлена.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private static void list_all_animals() {
        // Создаем отдельные списки для каждого типа животных
        List<animal> cats = new ArrayList<>();
        List<animal> dogs = new ArrayList<>();
        List<animal> hamsters = new ArrayList<>();
        List<animal> horses = new ArrayList<>();
        List<animal> camels = new ArrayList<>();
        List<animal> donkeys = new ArrayList<>();

        // Распределяем животных по соответствующим спискам
        for (animal animal : animals) {
            if (animal instanceof cat) {
                cats.add(animal);
            } else if (animal instanceof dog) {
                dogs.add(animal);
            } else if (animal instanceof hamster) {
                hamsters.add(animal);
            } else if (animal instanceof horse) {
                horses.add(animal);
            } else if (animal instanceof camel) {
                camels.add(animal);
            } else if (animal instanceof donkey) {
                donkeys.add(animal);
            }
        }

        // Выводим каждый тип животных в нужной последовательности
        printAnimalList("Кошки", cats);
        printAnimalList("Собаки", dogs);
        printAnimalList("Хомяки", hamsters);
        printAnimalList("Лошади", horses);
        printAnimalList("Верблюды", camels);
        printAnimalList("Ослы", donkeys);
    }

    private static void printAnimalList(String type, List<animal> animalList) {
        if (!animalList.isEmpty()) {
            System.out.println("Тип: " + type);
            for (animal animal : animalList) {
                System.out.println("ID: " + animal.getId() +
                        ", Имя: " + animal.getName() +
                        ", Возраст в месяцах: " + animal.calculateAgeInMonths() +
                        ", Порода: " + animal.getBreed() +
                        ", Команды: " + animal.getCommands());
            }
        }
    }

    private static void saveAnimals() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(animals);
            System.out.println("Животные успешно сохранены.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении животных: " + e.getMessage());
        }
    }

    private static void loadAnimals() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            animals = (List<animal>) ois.readObject();
            System.out.println("Животные успешно загружены.");
        } catch (FileNotFoundException e) {
            System.out.println("Сохраненные данные не найдены. Начинаем с пустого списка животных.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка загрузки животных: " + e.getMessage());
        }
    }
}


