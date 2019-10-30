package logic.command;

import common.DukeException;
import model.Model;
import java.util.Date;

public class RenameTaskCommand extends Command {

    private static final String SUCCESS_MESSAGE = "The task has been renamed to: ";
    public static final String INDEX_NOT_IN_TASKlIST_MESSAGE = "Index is not within the task list";
    public int taskIndex;
    public String newName;

    public RenameTaskCommand(int taskIndex, String newName) {
        this.taskIndex = taskIndex;
        this.newName = newName;
    }

    @Override
    public CommandOutput execute(Model model) throws DukeException {
        if (taskIndex < 1 || taskIndex > model.getTaskListSize()) {
            return new CommandOutput(INDEX_NOT_IN_TASKlIST_MESSAGE);
        } else {
            model.getTaskList().get(taskIndex - 1).setName(newName);
            return new CommandOutput(SUCCESS_MESSAGE + newName);
        }
    }
}
