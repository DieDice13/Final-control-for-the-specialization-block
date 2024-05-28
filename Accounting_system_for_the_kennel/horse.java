package Accounting_system_for_the_kennel;

import java.time.LocalDate;

class horse extends livestock_animal {
    public horse(String name, LocalDate birthDate, String breed, String commands) {
        super(name, birthDate, breed, commands);
    }

    @Override
    public String getAnimalType() {
        return "Horse";
    }
}

