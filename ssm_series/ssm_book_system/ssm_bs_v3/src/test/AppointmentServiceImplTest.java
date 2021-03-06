import com.weng.bean.request.AppointmentRequest;
import com.weng.service.AppointmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AppointmentServiceImplTest extends BaseTest {

  @Autowired
  private AppointmentService appointmentService;

  /**
   * 测试预约功能
   */
  @Test
  public void insertApponit() {
    AppointmentRequest form = new AppointmentRequest();
    form.setHoldDay("10");
    form.setBookId(103);
    form.setUserNumber(20080808);
    int appoint = appointmentService.appoint(form);
    System.out.println(appoint);
  }
}
