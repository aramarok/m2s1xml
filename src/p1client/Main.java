package p1client;

import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) {

		try {
			String outcome = new ServiciiBibtexProxy().getServiciiBibtex()
					.search("ANI", "2007");

			System.out.println("outcome: \n\n" + outcome);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}