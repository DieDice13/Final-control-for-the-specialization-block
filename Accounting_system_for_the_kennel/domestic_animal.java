package Accounting_system_for_the_kennel;

import java.time.LocalDate;

abstract class domestic_animal extends animal{
    public domestic_animal(String name, LocalDate birth_date, String breed, String commands) {
        super(name, birth_date, breed, commands);
    }

}
