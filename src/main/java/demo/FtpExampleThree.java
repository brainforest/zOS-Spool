package demo;

import org.apache.commons.net.ftp.*;
import java.io.*;

/**
 * This class provides an example of how to access
 * JES files via an FTP server from Java code.
 * <p>A special File Parser is used to parse the JES file
 * listings. This allows specific job related information
 * to be captured in a <code>demo.JesJob</code> object.
 * <p>The userid and password must be valid for the server
 * accessed.
 */
public class FtpExampleThree {

	public FtpExampleThree() {
	}

	public static void main(String[] args) {

		FTPClient ftp = null;

		String sUserid = "ISIELW";
		String sPassword = "PASSWD";
		String sHost = "192.168.152.2";
		String sJobPrefix = "ISIELW*";

		ftp = new FTPClient();

		FTPClientConfig conf = new FTPClientConfig("evan.org.demo.SimpleJesFileParser");
		ftp.configure(conf);

		try {

			String replyText;
			// Connect to the server

			ftp.connect(sHost);
			replyText = ftp.getReplyString();
			System.out.println(replyText);

			// Login to the server

			ftp.login(sUserid, sPassword);
			replyText = ftp.getReplyString();
			System.out.println(replyText);

			// Tell server that the file will have JCL records

			ftp.site("filetype=jes");
			replyText = ftp.getReplyString();
			System.out.println(replyText);

			ftp.site("jesowner=*");
			ftp.site("jesjobname=" + sJobPrefix);

			FTPFile[] result = ftp.listFiles("*");
			for (int i = 0; i < result.length; i++) {
				JesJob job = (JesJob) result[i];
				System.out.println("file " + i  
						+ " is " + job.getName()
						+ " jobname is " + job.getJobName() 
						+ " class is " + job.getJobClass() 
						+ " status is " + job.getStatus()
						+ " rc is " + job.getReturnCode());
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