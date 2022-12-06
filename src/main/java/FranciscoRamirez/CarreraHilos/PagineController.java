package FranciscoRamirez.CarreraHilos;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PagineController implements Initializable {

	@FXML
	ProgressBar c1;
	@FXML
	ProgressBar c2;
	@FXML
	ProgressBar c3;
	@FXML
	ProgressBar c4;
	@FXML
	Button b1;
	@FXML
	Button b2;
	@FXML
	Button b3;
	@FXML
	Label label1;
	@FXML
	TextField aa;

	Caballo cab1;
	Caballo cab2;
	Caballo cab3;
	Caballo cab4;
	Thread t1;
	Thread t2;
	Thread t3;
	Thread t4;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		b1.setOnAction(e -> {
			ArrayList<Thread> pro = new ArrayList<>();
			cab1=new Caballo(this, c1,"Caballo 1",label1);
			cab2=new Caballo(this, c2,"Caballo 2",label1);
			cab3=new Caballo(this, c3,"Caballo 3",label1);
			cab4=new Caballo(this, c4,"Caballo 4",label1);

			t1=new Thread(cab1);
			t2=new Thread(cab2);
			t3=new Thread(cab3);
			t4=new Thread(cab4);
			
			pro.add(t1);
			pro.add(t2);
			pro.add(t3);
			pro.add(t4);
			
			cab1.setListC(pro);
			cab2.setListC(pro);
			cab3.setListC(pro);
			cab4.setListC(pro);
			
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			

		});
		b2.setOnAction(e -> {
			cab1.suspendido=true;
			cab2.suspendido=true;
			cab3.suspendido=true;
			cab4.suspendido=true;
		});
		b3.setOnAction(e -> {
			cab1.suspendido=false;
			cab2.suspendido=false;
			cab3.suspendido=false;
			cab4.suspendido=false;
			synchronized (this) {
				notifyAll();
			}
		});

	}
}