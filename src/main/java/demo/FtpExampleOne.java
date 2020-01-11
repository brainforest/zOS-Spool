package demo;

import org.apache.commons.net.ftp.*;
import java.io.IOException;

/**
 * This class provides a simple example of how to access
 * JES files via an FTP server from Java code.
 * <p>The userid and password must be valid for the server
 * accessed.
 */
public class FtpExampleOne {

	public FtpExampleOne() {
	}

	public static void main(String[] args) {

		FTPClient ftp = null;

		String sUserid = "ISIELW";
		String sPassword = "PASSWD";
		String sHost = "192.168.152.2";
		String replyText;

		ftp = new FTPClient();

		try {

			// Connect to the server

			ftp.connect(sHost);
			replyText = ftp.getReplyString();
			System.out.println(replyText);

			// Login to the server

			ftp.login(sUserid, sPassword);
			replyText = ftp.getReplyString();
			System.out.println(replyText);

			// Tell server that we will use the JES interface

			ftp.site("filetype=jes");
			replyText = ftp.getReplyString();
			System.out.println(replyText);

			// Get a list of jobs

			String[] names = ftp.listNames("*");
			for (int i = 0; i < names.length; i++) {
				System.out.println("file " + i + " is " + names[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ftp.quit();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}