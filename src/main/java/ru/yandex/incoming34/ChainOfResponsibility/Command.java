package ru.yandex.incoming34.ChainOfResponsibility;

public class Command {

    public enum CommandCode {ON, OFF};

    private final String ACCEPTER;
    private final CommandCode commandCode;

    public Command(String ACCEPTER, CommandCode commandCode) {
        this.ACCEPTER = ACCEPTER;
        this.commandCode = commandCode;
    }

    public String getACCEPTER() {
        return ACCEPTER;
    }

    public CommandCode getCommandCode() {
        return commandCode;
    }
}
