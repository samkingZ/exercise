package com.hihuaning.mixture;

public class PathUtil {
	public static void main(String[] args){
		String os_name = System.getProperties().get("os_name").toString();
		String path = null;
		if(os_name.indexOf("windows")!=-1)
			 path = PathUtil.class.getClassLoader().getResource("\\").getPath();
    else if(os_name.indexOf("linux")!=-1){
    	 path = PathUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    	 }
		System.out.println(path);
	}
}
