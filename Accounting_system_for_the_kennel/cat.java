package Accounting_system_for_the_kennel;

import java.time.LocalDate;

class cat extends domestic_animal {
    public cat(String name, LocalDate birthDate, String breed, String commands) {
        super(name, birthDate, breed, commands);
    }

    @Override
    public String getAnimalType() {
        return "Cat";
    }
}

