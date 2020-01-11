package demo;

import org.apache.commons.net.ftp.FTPFile;

/**
 * The demo.JesJob class extends the FTPFile class. This
 * allows for <code>JES</code> specific information to
 * be maintained, in addition to the standard <code>FTPFile</code>
 * information.
 * <p>This allows information for the spool files such as:
 * <ul>
 * <li>job name</li> 
 * <li>job id</li> 
 * <li>job ownere</li> 
 * <li>job status</li> 
 * <li>job class</li> 
 * <li>job return code</li> 
 * </ul>
 */
public class JesJob extends FTPFile {

	private static final long serialVersionUID = 1L;

	private String sJobName;
	private String sJobId;
	private String sOwner;
	private String sStatus;
	private String sJobClass;
	private String sReturnCode;
	private String sNumFiles;

	public JesJob() {
		super();
		sJobName = "";
		sJobId = "";
		sOwner = "";
		sStatus = "";
		sJobClass = "";
		sReturnCode = "";
		sNumFiles = "";
	}

	public String getJobName() {
		return sJobName;
	}

	public void setJobName(String jobname) {
		sJobName = jobname;
	}

	public String getJobClass() {
		return sJobClass;
	}

	public void setJobClass(String jobClass) {
		sJobClass = jobClass;
	}

	public String getJobId() {
		return sJobId;
	}

	public void setJobId(String jobId) {
		sJobId = jobId;
	}

	public String getNumFiles() {
		return sNumFiles;
	}

	public void setNumFiles(String numFiles) {
		sNumFiles = numFiles;
	}

	public String getOwner() {
		return sOwner;
	}

	public void setOwner(String owner) {
		sOwner = owner;
	}

	public String getReturnCode() {
		return sReturnCode;
	}

	public void setReturnCode(String returnCode) {
		sReturnCode = returnCode;
	}

	public String getStatus() {
		return sStatus;
	}

	public void setStatus(String status) {
		sStatus = status;
	}

}
