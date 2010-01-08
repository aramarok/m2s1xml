package m2s1xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util {
	/**
	 * Returns the contents of the file in a byte array
	 * 
	 * @param file
	 *            File this method should read
	 * @return Returns a byte[] array of the contents of the file
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {

		InputStream is = new FileInputStream(file);
		System.out.println("\nDEBUG: FileInputStream is " + file);

		// Get the size of the file
		long length = file.length();
		System.out.println("DEBUG: Length of " + file + " is " + length + "\n");

		/*
		 * You cannot create an array using a long type. It needs to be an int
		 * type. Before converting to an int type, check to ensure that file is
		 * not loarger than Integer.MAX_VALUE;
		 */
		if (length > Integer.MAX_VALUE) {
			System.out.println("File is too large to process");
			return null;
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while ((offset < bytes.length)
				&& ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)) {

			offset += numRead;

		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;

	}

}
