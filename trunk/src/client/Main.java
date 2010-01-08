package client;

import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println(new XMLBibtexProxy().search("ANI", "2006"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
