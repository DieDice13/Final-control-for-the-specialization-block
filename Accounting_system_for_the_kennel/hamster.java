package Accounting_system_for_the_kennel;

import java.time.LocalDate;

class hamster extends domestic_animal {
    public hamster(String name, LocalDate birthDate, String breed, String commands) {
        super(name, birthDate, breed, commands);
    }

    @Override
    public String getAnimalType() {
        return "Hamster";
    }
}

