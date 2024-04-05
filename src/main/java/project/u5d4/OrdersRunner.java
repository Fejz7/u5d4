package project.u5d4;

import com.epicode.U5D2.entities.Menu;
import com.epicode.U5D2.entities.Pizza;
//import com.epicode.U5D2.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class OrdersRunner implements CommandLineRunner {

	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public void run(String... args) throws Exception {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D2Application.class);
		try {
			Menu m = (Menu) ctx.getBean("menu");
			m.printMenu();


			pizzaRepository.saveAll(m.getPizzas());


		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			ctx.close();
		}
	}
}
