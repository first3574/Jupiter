	/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.Wait;
import java.util.Vector;


/**
 *
 * @author team3574
 */
public abstract class CommandGroupBetterBase extends CommandBase {

    private Vector m_commands = new Vector();

    public CommandGroupBetterBase() {
    }

    /*
     * we're using initialize to set all the activities
     */
    protected abstract void initialize();

    /*
     * start all tasks at 0
     * loop the tasks, if it's 1, set it to 2
     * (we do this because we need one loop to ensure the sceduler
     *      has kicked it off before we check for finished)
     * if it's 0, set it to 1
     * 
     */
    protected void execute() {
	int groupCountTotal = 0;
	int groupCountEncountered = 0;
	//		System.out.println("e: ");

	// iterate the list of commands
	for (int i = 0; i < m_commands.size(); i++) {
	    CommandEntry ce = (CommandEntry) m_commands.elementAt(i);

	    if (ce.status == CommandEntry.STATUS_STARTING) {
		System.out.println("starting: " + i);
		ce.status++;
	    }
	    
	    if (ce.status == CommandEntry.STATUS_NEW) {
		Scheduler.getInstance().add(ce.command);
		ce.status = CommandEntry.STATUS_STARTING;
		System.out.println("new: " + i);
	    }
	    if (ce.status == CommandEntry.STATUS_RUNNING || ce.status == CommandEntry.STATUS_STARTING) {
		if (ce.type == CommandEntry.TYPE_RUN_UNTIL_DONE) {
		    break;
		} else if (ce.type == CommandEntry.TYPE_GROUP_UNTIL_DONE) {
		    groupCountTotal = ce.typeCount;
		    groupCountEncountered++;

		    if (groupCountEncountered == groupCountTotal) {
			break;
		    }
		}
	    }
	}
	for (int i = 0; i < m_commands.size(); i++) {
	    CommandEntry ce = (CommandEntry) m_commands.elementAt(i);
	    if (ce.status == CommandEntry.STATUS_RUNNING) {
		if (ce.isDone()) {
		    System.out.println("done " + i);
		    ce.status = CommandEntry.STATUS_DONE;
		}
	    }
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	for (int i = 0; i < m_commands.size(); i++) {
	    CommandEntry ce = (CommandEntry) m_commands.elementAt(i);
	    if (ce.command.isRunning()) {
		System.out.println("killed: " + i);
		ce.command.cancel();
	    }
	}
	m_commands = new Vector();
    }

    protected void addParallel(Command command) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_NOW, 1));
    }

    protected void addParallel(Command command, double timeout) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_NOW, 1, timeout));
    }

    protected void addSequential(Command command) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_UNTIL_DONE, 1));
    }

    protected void addSequential(Command command, double timeout) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_RUN_UNTIL_DONE, 1, timeout));
    }

    protected void addSequentialGroup(Command command, int countInGroup) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_GROUP_UNTIL_DONE, countInGroup));
    }

    protected void addSequentialGroup(Command command, int countInGroup, double timeout) {
	this.m_commands.addElement(new CommandEntry(command, CommandEntry.TYPE_GROUP_UNTIL_DONE, countInGroup, timeout));
    }

    protected void addSequentialPair(Command command1, Command command2) {
	this.m_commands.addElement(new CommandEntry(command1, CommandEntry.TYPE_RUN_NOW, 2));
	this.m_commands.addElement(new CommandEntry(command2, CommandEntry.TYPE_RUN_NOW, 2));
    }

    protected void addSequentialPair(Command command1, Command command2, double timeout) {
	this.m_commands.addElement(new CommandEntry(command1, CommandEntry.TYPE_RUN_NOW, 2, timeout));
	this.m_commands.addElement(new CommandEntry(command2, CommandEntry.TYPE_RUN_NOW, 2, timeout));
    }

    private static class CommandEntry {

	private static final int TYPE_RUN_NOW = 0,
		TYPE_RUN_UNTIL_DONE = 1,
		TYPE_GROUP_UNTIL_DONE = 2;
	private static final int STATUS_NEW = 0,
		STATUS_STARTING = 1,
		STATUS_RUNNING = 2,
		STATUS_DONE = 3;
	Command command;
	int type;
	int typeCount;
	double timeout;
	int status;

	CommandEntry(Command command, int type, int typeCount) {
	    this(command, type, typeCount, -1);
	}

	CommandEntry(Command command, int type, int typeCount, double timeout) {
	    this.command = command;
	    this.type = type;
	    this.typeCount = typeCount;
	    this.timeout = timeout;
	    this.status = 0;
	}

	boolean isDone() {
	    if (!command.isRunning()) {
		System.out.println("isnotrunning");
		return true;
	    } else if (timeout == -1 || command.timeSinceInitialized() < timeout) {
		return false;
	    } else { // must be over the timeout
		command.cancel();
		return true;
	    }
	}
    }
}
