package com.gms.web.factory;

import com.gms.web.command.Command;
import com.gms.web.command.MoveCommand;
import com.gms.web.constant.Action;

public class CommandFactory {
	public static Command createCommand(String dir,String action,String page){
		Command cmd=null;
		switch (action) {
		case Action.MOVE:case Action.LOGIN:case Action.JOIN:case "dbtest":case Action.LOGOUT:case Action.LIST:case Action.DETAIL:
		case Action.UPDATE:
			cmd=new MoveCommand(dir, action, page);
			break;
		default:
			System.out.println("Command Fail..");
			break;
		}
		return cmd;
		
	}
}