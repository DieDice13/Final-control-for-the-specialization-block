package Accounting_system_for_the_kennel;

import java.time.LocalDate;

class camel extends livestock_animal {
    public camel(String name, LocalDate birthDate, String breed, String commands) {
        super(name, birthDate, breed, commands);
    }

    @Override
    public String getAnimalType() {
        return "Camel";
    }
}

