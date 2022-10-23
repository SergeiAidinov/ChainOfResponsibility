package ru.yandex.incoming34.ChainOfResponsibility.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.ChainOfResponsibility.Command;

import java.util.List;
import java.util.Optional;

@Component
public class Devices {

    @Autowired
    VacuumCleaner vacuumCleaner;

    @Autowired
    AirConditioner airConditioner;

    private int index = 0;

    private List<Equipment> equipmentList = List.of(vacuumCleaner, airConditioner);

    public void handleCommand(Optional<Command> optionalCommand) {
        getNextEquipment().performCommand(optionalCommand);
    }

    private Equipment getNextEquipment() {

        if (index < equipmentList.size()) {
            return equipmentList.get(index++);
        } else {
            return null;
        }


    }
}
