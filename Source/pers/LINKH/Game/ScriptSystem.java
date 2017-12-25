package pers.LINKH.Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.Tools.Log;

public class ScriptSystem implements FrameSystem {
	
	public static String ScriptPackName;
	private static ScriptSystem instance;
	
	private  List<Class<?>> classes = new ArrayList<Class<?>>();
	private  List<ScriptSuper> scripts = new ArrayList<ScriptSuper>();
	private ScriptSystem() throws Exception {
		scan(ScriptPackName,classes);
		for(Class<?> c : classes ) {
			ScriptSuper aScriptSuper =(ScriptSuper) c.newInstance();
			addScript(aScriptSuper);
		}
	}
	
	
	public void scan(String packageName ,List<Class<?>> list) throws Exception{
	    if(packageName==null) {
	    	Log.Print("File to loading scripts");
	    	return;
	    }
		String path=getSrcPath()+packageToDir(packageName);
	    File dir=new File(path);
	    File[] files=dir.listFiles();
	    Class<?> cla=null;
	    for(File f:files){
	        if(f.isDirectory()){
	            String childName=packageName+"."+f.getName();
	            scan(childName, list);
	 
	        }else{
	            cla=Class.forName(packageName+"."+f.getName().split("\\.")[0]);
	            list.add(cla);
	        }
	    }
	}
	/**
	获取当前路径
	*/
	public  String getSrcPath() throws IOException{
	   File file=new File("");
	   String path=file.getCanonicalPath()+File.separator+"Game";
	   return path;
	}
	/**
	 *package转换为路径格式
	 */
	public  String packageToDir(String packageName){
	    String[] array=packageName.split("\\.");
	    StringBuffer sb=new StringBuffer();
	    for(String str:array){
	        sb.append(File.separator).append(str);
	    }
	    return sb.toString();
	}
	
	
	
	
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		for(ScriptSuper s : scripts) {
			s.Init();
		}
	}

	@Override
	public void addSystemRunLoop() {
		// TODO Auto-generated method stub
		for(ScriptSuper s : scripts) {
			s.RunLoop();
		}
	}

	@Override
	public void addSystemDestruction() {
		// TODO Auto-generated method stub
		for(ScriptSuper s : scripts) {
			s.Destruction();
		}
	}

	public static ScriptSystem getSystem() throws Exception {
		if(instance==null) {
			instance = new ScriptSystem();
		}
		return instance;
	}

	public void addScript(ScriptSuper s) {
		scripts.add(s);
	}
}
