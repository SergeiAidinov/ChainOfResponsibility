package ru.yandex.incoming34.ChainOfResponsibility.device;

import org.springframework.stereotype.Component;

import java.util.Optional;

import static ru.yandex.incoming34.ChainOfResponsibility.Data.vacuum;

@Component(value = "VacuumCleaner")
public class VacuumCleaner implements Equipment{

    private String NAME = vacuum;

    private Optional<Equipment> nextEquipment = Optional.empty();

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void setNextEquipment(Optional<Equipment> nextEquipment) {
        this.nextEquipment = nextEquipment;
    }

    @Override
    public Optional<Equipment> getNextEquipment() {
        return nextEquipment;
    }

}
