import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ahmad.config.ApplicationConfig;
import com.ahmad.persistent.Employee;

public class Test {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId(4);
		e.setName("Thanks");

		Session session = ApplicationConfig.getInstance().openSession();
		Transaction t = session.beginTransaction();
		//session.persist(e);
		session.saveOrUpdate(e);
		t.commit();
		session.close();

	}

}
