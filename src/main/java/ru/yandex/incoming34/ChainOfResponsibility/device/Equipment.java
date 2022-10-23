package ru.yandex.incoming34.ChainOfResponsibility.device;

import ru.yandex.incoming34.ChainOfResponsibility.Command;

import java.util.Optional;

public interface Equipment {

    String getName();

    void setNextEquipment(Optional<Equipment> nextEquipment);
    Optional<Equipment> getNextEquipment();

    default Optional<Command> performCommand(Optional<Command> optionalCommand) {

        switch (optionalCommand.get().getCommandCode()) {
            case ON:
                System.out.println(getName() + " включен(а)");
                return Optional.empty();
            case OFF:
                System.out.println(getName() + " выключен(а)");
                return Optional.empty();

            default:
                return Optional.empty();
        }

    }

    default Optional<Command> acceptCommand(Optional<Command> optionalCommand) {

        if (optionalCommand.get().getACCEPTER().equals(getName())) {

            return performCommand(optionalCommand);

        } else {

            System.out.println("Команда передана  " + getNextEquipment());
            if (getNextEquipment().isPresent()) {
                return getNextEquipment().get().acceptCommand(optionalCommand);
            } else {
                System.out.println("Достигнут конец цепочки. Команда " + optionalCommand.get() + " осталась необработанной.");
                return Optional.empty();
            }

        }

    }


}
