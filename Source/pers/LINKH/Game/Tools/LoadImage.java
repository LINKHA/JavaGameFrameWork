package pers.LINKH.Game.Tools;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

public class LoadImage {
	static Map<String, Image> images = new HashMap<String, Image>();
/////////////////////////////////////////////////////////////////////////////////////////////
//暴露给应用层的接口
//类:LoadImage
/////////////////////////////////////////////////////////////////////////////////////////////
	public static Image load(String imageName) {
		if(images.containsKey(imageName)) {
			return images.get(imageName);
		}
		Image image =Toolkit.getDefaultToolkit().getImage(imageName);
		images.put(imageName,image);
		return image;
	}
}
