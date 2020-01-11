package demo;

import org.apache.commons.net.ftp.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class provides a simple example of how to access
 * a specific JES sysout file via an FTP server from Java code.
 * <p>The userid and password must be valid for the server
 * accessed.
 */
public class FtpExampleTwo {

	public FtpExampleTwo() {
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

			// Retrieve part of a JES Job

			String sRemoteFilename = "TSU00629.2";
			
			InputStream is = ftp.retrieveFileStream(sRemoteFilename);
			BufferedReader br = new BufferedReader(new InputStreamReader((is)));
			boolean bContinue = true;
			while (bContinue) {
				String sLine = br.readLine();
				if (sLine != null) {
					System.out.println(sLine);
				} else {
					bContinue = false;
					is.close();
					br.close();
				}
			}
			ftp.completePendingCommand();

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