package p1client;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			HashMap<String, String> outcome = new CautareProxy().getCautare()
					.search("ANI", "2009");

			Iterator it = outcome.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				Object val = outcome.get(key);

				System.out.println(val);
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
