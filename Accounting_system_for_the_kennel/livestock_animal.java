package Accounting_system_for_the_kennel;

import java.time.LocalDate;

abstract class livestock_animal extends animal{
    public livestock_animal(String name, LocalDate birthDate, String breed, String commands) {
        super(name, birthDate, breed, commands);
    }

}