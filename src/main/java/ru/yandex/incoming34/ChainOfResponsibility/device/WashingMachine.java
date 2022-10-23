package ru.yandex.incoming34.ChainOfResponsibility.device;

import org.springframework.stereotype.Component;

import java.util.Optional;

import static ru.yandex.incoming34.ChainOfResponsibility.Data.washMach;

@Component(value = "WashingMachine")
public class WashingMachine implements Equipment {

    private String NAME = washMach;

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
