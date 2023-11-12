import jade.core.AgentContainer;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class RunProject {

	public static void main(String[] args) {
		Runtime rt = Runtime.instance();
		Profile p= new ProfileImpl();
		p.setParameter(Profile.MAIN_HOST, "localhost");
		p.setParameter(Profile.GUI, "true");
		ContainerController cc = rt.createMainContainer(p);
		AgentController ac;
		try {
			ac=cc.createNewAgent("BookSellerDenis", "book_trading.BookSellerAgent", null);
			ac.start();
			ac=cc.createNewAgent("BookSellerNick", "book_trading.BookSellerAgent", null);
			ac.start();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
	
	}

}