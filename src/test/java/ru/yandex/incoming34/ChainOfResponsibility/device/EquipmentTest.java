package ru.yandex.incoming34.ChainOfResponsibility.device;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.incoming34.ChainOfResponsibility.Command;

import javax.annotation.PostConstruct;
import java.util.Optional;

import static ru.yandex.incoming34.ChainOfResponsibility.Data.*;

@SpringBootTest(classes = {Equipment.class, VacuumCleaner.class, AirConditioner.class, WashingMachine.class})
class EquipmentTest {

    @Autowired
    @Qualifier("VacuumCleaner")
    Equipment vacuumCleaner;

    @Autowired
    @Qualifier("AirConditioner")
    Equipment airConditioner;

    @Autowired
    @Qualifier("WashingMachine")
    Equipment washingMachine;

    @PostConstruct
    private void init(){
        airConditioner.setNextEquipment(Optional.of(washingMachine));
        vacuumCleaner.setNextEquipment(Optional.of(airConditioner));

    }


    @Test
    public void test() {
        Optional<Command> commandOptionalVacuumOn = Optional.of(new Command(vacuum, Command.CommandCode.ON));
        Optional<Command> commandOptionalAirConditionerOn = Optional.of(new Command(airCond, Command.CommandCode.ON));
        Optional<Command> commandOptionalWashMachOn = Optional.of(new Command(washMach, Command.CommandCode.ON));
        Optional<Command> commandOptionalUnknown = Optional.of(new Command("Unknown", Command.CommandCode.ON));
        Optional<Command> commandOptionalVacuumOff = Optional.of(new Command(vacuum, Command.CommandCode.OFF));
        Optional<Command> commandOptionalAirCondOff = Optional.of(new Command(airCond, Command.CommandCode.OFF));
        Optional<Command> commandOptionalWashMachOff = Optional.of(new Command(washMach, Command.CommandCode.OFF));


        vacuumCleaner.acceptCommand(commandOptionalVacuumOn);
        vacuumCleaner.acceptCommand(commandOptionalAirConditionerOn);
        vacuumCleaner.acceptCommand(commandOptionalWashMachOn);
        vacuumCleaner.acceptCommand(commandOptionalUnknown);
        vacuumCleaner.acceptCommand(commandOptionalWashMachOff);
        vacuumCleaner.acceptCommand(commandOptionalAirCondOff);

    }


}