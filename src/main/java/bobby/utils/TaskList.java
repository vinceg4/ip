package bobby.utils;

import java.util.ArrayList;

import bobby.exception.BobbyException;
import bobby.tasks.Task;


/**
 * The TaskList class manages the Task operations.
 */
public class TaskList {
    private final ArrayList<Task> listOfTasks;
    private final ArrayList<Task> listOfArchivedTasks;

    /**
     * Constructs a TaskList with the specified ArrayList of Task.
     *
     * @param taskList The list of tasks in Bobby.
     */
    public TaskList(ArrayList<Task> taskList, ArrayList<Task> archivedList) {
        this.listOfTasks = taskList;
        this.listOfArchivedTasks = archivedList;
    }

    /**
     * Returns total number of tasks in the list.
     * @return Number of tasks in the list.
     */
    public int getNumberOfTasks() {
        return this.listOfTasks.size();
    }

    /**
     * Returns a Task at the desired index.
     *
     * @param x The index of the desired task.
     * @return Task at index x of the list.
     */
    public Task getTask(int x) throws BobbyException {
        if (x >= this.listOfTasks.size() || x < 0) {
            throw new BobbyException("My apologies. There is no task at that number!");
        }

        return this.listOfTasks.get(x);
    }

    /**
     * Returns the list of tasks.
     *
     * @return List of tasks.
     */
    public ArrayList<Task> getListOfTasks() {
        return this.listOfTasks;
    }

    /**
     * Returns the list of archived tasks.
     *
     * @return List of archived tasks.
     */
    public ArrayList<Task> getListOfArchivedTasks() {
        return this.listOfArchivedTasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param t Task to be added to the list.
     */
    public void addTask(Task t) {
        this.listOfTasks.add(t);
    }

    /**
     * Archives a task.
     *
     * @param t Task to be archived.
     */
    public void archiveTask(Task t) {
        this.listOfArchivedTasks.add(t);
    }

    /**
     * Indicates a task as completed.
     *
     * @param x The index of the task as shown in the list to be indicated as completed.
     * @throws BobbyException If the user does not enter a valid index
     */
    public void mark(int x) throws BobbyException {
        if (x > this.listOfTasks.size() || x <= 0) {
            throw new BobbyException("My apologies. There is no task at that number!");
        }
        Task t = this.listOfTasks.get(x - 1);
        t.indComplete();
    }

    /**
     * Indicates a task to be incomplete.
     *
     * @param x The index of the task as shown in the list to be indicated as incomplete.
     * @throws BobbyException If the user does not enter a valid index
     */
    public void unmark(int x) throws BobbyException {
        if (x > this.listOfTasks.size() || x <= 0) {
            throw new BobbyException("My apologies. There is no task at that number!");
        }
        Task t = this.listOfTasks.get(x - 1);
        t.indIncomplete();
    }

    /**
     * Removes a task from the list
     *
     * @param x The index of the task as shown in the list to be removed.
     */
    public void deleteTask(int x) throws BobbyException {
        if (x > this.listOfTasks.size() || x <= 0) {
            throw new BobbyException("My apologies. There is no task at that number!");
        }

        this.listOfTasks.remove(x - 1);
    }

    /**
     * Returns a lists of tasks that is matching with a certain keyword.
     *
     * @param keyword Keyword representing the tasks to match to.
     * @return List of matching tasks.
     */
    public ArrayList<Task> findMatchingTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();

        for (Task task : this.listOfTasks) {
            if (task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
