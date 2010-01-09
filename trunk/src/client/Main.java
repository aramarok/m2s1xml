package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) {

		// test search
		try {
			System.out.println(new XMLBibtexProxy().search("ANI", "2006"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		// test download pdf
		String strFilePath = "D://Images//pedefe.pdf";
		File fPDF = new File(strFilePath);
		if (!fPDF.exists())
			try {
				if (!fPDF.getParentFile().exists()) {
					fPDF.getParentFile().createNewFile();
				}
				fPDF.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(strFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		try {
			fos.write(new XMLBibtexProxy().getPDFReport());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
