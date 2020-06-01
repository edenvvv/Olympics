package graphics;

import java.awt.*;

public interface IDrawable
{
    public final static String FOLDER_PATH = System.getProperty("user.dir");
    public final static String PICTURE_PATH = FOLDER_PATH + "\\src\\graphics\\";
    public void loadImages(String nm);
    public void drawObject (Graphics g);
}
