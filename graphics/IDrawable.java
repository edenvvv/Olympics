package graphics;

import java.awt.*;
import java.io.IOException;
/**
 * Class that describes an IDrawable attributes
 * @author eden dadon id:207279183
 * @author Eliran Dagan id: 208061580
 */
public interface IDrawable
{
    public final static String FOLDER_PATH = System.getProperty("user.dir");
    public final static String PICTURE_PATH = FOLDER_PATH + "\\src\\graphics\\";
    public void loadImages(String nm) throws IOException;
    public void drawObject (Graphics g);
}
