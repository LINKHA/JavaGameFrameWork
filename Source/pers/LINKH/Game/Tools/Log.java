package pers.LINKH.Game.Tools;

public class Log {
	public static void Print(Object object) {
		 StackTraceElement[] trace = new Throwable().getStackTrace();
	        StackTraceElement tmp = trace[1];
	        System.out.print( tmp.getClassName() + "." + tmp.getMethodName() 
	            + "(" + tmp.getFileName() + ":" + tmp.getLineNumber() + ")" );
			System.out.println("  :"+object);
	}
	public static void Print(Object...args) {
		 StackTraceElement[] trace = new Throwable().getStackTrace();
	        StackTraceElement tmp = trace[1];
	        System.out.print( tmp.getClassName() + "." + tmp.getMethodName() 
	            + "(" + tmp.getFileName() + ":" + tmp.getLineNumber() + ")" );
		if(args.length>1) {
			if(args[args.length-1]=="Writting") {
				System.out.print(" Writting:");
				for (int i=0;i<args.length-1;i++) {
					System.out.print(args[i]);
				}
			}
			else if(args[args.length-1]=="Error") {
				System.out.print(" Error:");
				for (int i=0;i<args.length-1;i++) {
					System.out.print(args[i]);
				}
			}else {
				for (int i=0;i<args.length;i++) {
					System.out.print(args[i]);
				}
			}
		}
		
		System.out.println();
	}
}
