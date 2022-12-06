package FranciscoRamirez.CarreraHilos;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Caballo extends Thread {
	private PagineController log;
	public static Double c = 0d;
	private ProgressBar p1;
	private ArrayList<Thread> listC;
	public boolean suspendido = false;
	String name1;
	Label label11;

	
	public Caballo(PagineController l, ProgressBar p,String name,Label l1) {
		log = l;
		p1 = p;
		name1=name;
		label11=l1;
	}

	public ArrayList<Thread> getListC() {
		return listC;
	}

	public void setListC(ArrayList<Thread> listC) {
		this.listC = listC;
	}

	public double aleatorio() {
		int c11 = (int) (Math.random() * (11));
		double c111 = c11 / 100d;
		return c111;

	}

	public void setea() {

		c = c + aleatorio();
		p1.setProgress(c);
		//log.aa.setText(name1);

	}
	public void seteaLabel() {

		label11.setText(name1);

	}


	@Override
	public void run() {
		while (!isInterrupted()) {
			try {
				while (c < 1.00) {
					if (suspendido) {
						synchronized (log) {
							log.wait();
						}
					}
						Thread.sleep(1000);
					setea();
					if (c >= 1.00) {
					System.out.println("El ganador es: "+name1);
					
						for (Thread thread : listC) {
							thread.interrupt();
							
						}
					}
					
					
				}
				
			} catch (InterruptedException e) {
				System.out.println("he perdido");
				
			}
		}
	

	}
	
}
