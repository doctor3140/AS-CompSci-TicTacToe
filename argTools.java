public class argTools{

	public String[] cliArgs = {"--help", "-h", "--rules", "--worksCited", "--interact", "--setGames"};


	private String[] args;

	public argTools(String[] args){
	this.args = args;
	}

	public boolean hasArg(String arg){
		return ((args.length>0)&&((args[0].equals(arg))));
	}
		

	public boolean invalidArg(){
    		boolean arg=true;
    		for(int argsI=0; argsI<args.length; argsI++){
			for(int cliArgsI=0; cliArgsI<cliArgs.length; cliArgsI++){
			if(cliArgs[cliArgsI].equals(args[argsI]))
			arg=false;
			}
		}
		return arg;
   	}

    	public int indexArg(String arg){
    		int index=-1;
    		for(int argsI=0; argsI<args.length; argsI++){
		if(arg.equals(args[argsI]))
			index=argsI;
		}
		return index;
    	}

}
