package com.gms.web.command;


import com.gms.web.constant.Extension;
import com.gms.web.constant.Path;

public class Command implements Commandable{
	protected String directory,action,page,dir,view;

	public String getView() {
		return view;
	}

	public String getDir() {
		return dir;
	}


	public void setDir(String dir) {
		this.dir = dir;
	}


	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public void process() {
		this.view=Path.VIEW+dir+Path.SEPARATOR+page+Extension.JSP;
	}
	public String toString(){
		return String.format("Command[DEST=%s/PAGE=%s/ACTION=%s]", directory,action,page);
	}

}
