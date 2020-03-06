import com.synerzip.manager.AirportManager;
import java.io.IOException;
import org.apache.log4j.BasicConfigurator;

public class SkyScheduleApplication {

  public static void main(String args[]) {

    BasicConfigurator.configure();
    //init manager profile start configuration
    AirportManager.getInstance().startAppService();
  }

}
