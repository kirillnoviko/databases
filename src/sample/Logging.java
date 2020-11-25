package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;










public class Logging {

    static Logger LOGGER;
   // static Logger log = Logger.getLogger(Logging.class.getName());

    public Logging(){


            try(FileInputStream ins = new FileInputStream("C:\\Users\\kiril\\IdeaProjects\\diplom\\src\\sample\\logger.properties")){ //полный путь до файла с конфигами
                LogManager.getLogManager().readConfiguration(ins);
                LOGGER = Logger.getLogger(Main.class.getName());
            }catch (Exception ignore){
                ignore.printStackTrace();
            }

    }
    public void someMethod(String a) {

        LOGGER.log(Level.INFO,a);
    }
}
