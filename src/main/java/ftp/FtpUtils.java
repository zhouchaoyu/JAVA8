package ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FtpUtils {
	private static final Logger log=LoggerFactory.getLogger(FtpUtils.class);
	// ftp鏈嶅姟鍣ㄥ湴鍧�
	public String hostname = "192.168.0.127";
	// ftp鏈嶅姟鍣ㄧ鍙ｅ彿榛樿涓�21
	public Integer port = 21;
	// ftp鐧诲綍璐�?�?
	public String username = "root";
	// ftp鐧诲綍�?�嗙�?
	public String password = "123";

	public FTPClient ftpClient = null;

	/**
	 * 鍒濆鍖杅tp鏈嶅姟鍣�?
	 */
	public boolean initFtpClient() {
		ftpClient = new FTPClient();// 1.鏂板缓鏈嶅姟鍣╢tp瀹㈡埛绔璞�
		ftpClient.setControlEncoding("utf-8");// 璁剧疆閾炬帴缂栫�?
		boolean flag = false;
		try {
			log.info("connecting...ftp鏈嶅姟鍣�?:{}:{}", this.hostname, this.port);
			ftpClient.connect(hostname, port); // 杩炴帴ftp鏈嶅姟鍣�?
			if (ftpClient.login(username, password)) {// 鐧诲綍ftp鏈嶅姟鍣�?
				log.info("FTP--------login...SUCCESS  {}:{}", this.hostname, this.port);
				flag = true;
			} else {
				log.info("FTP--------login...FAIL  {}:{}", this.hostname, this.port);
			}
			int replyCode = ftpClient.getReplyCode(); // 鏄惁鎴愬姛鐧诲綍鏈嶅姟鍣�
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				log.info("FTP Schema...isPositive");
			} else {
				log.info("FTP Schema...standard");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 涓婁紶鏂囦欢
	 * 
	 * @param pathname       ftp鏈嶅姟淇濆瓨鍦板�?
	 * @param fileName       涓婁紶鍒癴tp鐨勬枃浠跺悕
	 * @param originfilename 寰呬笂浼犳枃浠剁殑鍚嶇О锛堢粷瀵瑰湴鍧�锛�? *
	 * @return
	 */
	public boolean uploadFile(String pathname, String fileName, String originfilename) {
		boolean flag = false;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(originfilename));
			if (uploadFile(pathname,fileName,inputStream)) {
				flag=true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 涓婁紶鏂囦欢
	 * 
	 * @param pathname    ftp鏈嶅姟淇濆瓨鍦板�?
	 * @param fileName    涓婁紶鍒癴tp鐨勬枃浠跺悕
	 * @param inputStream 杈撳叆鏂囦欢娴�
	 * @return
	 */
	public boolean uploadFile(String pathname, String fileName, InputStream inputStream) {
		boolean flag = false;
		try {
			if (initFtpClient()) {// 鍒濆鍖杅tp瀹㈡埛绔�? 锛涢摼鎺ユ湇鍔＄�?
				ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);//璁剧疆鏂囦欢绫诲�?
				CreateDirecroty(pathname);
				ftpClient.makeDirectory(pathname);
				ftpClient.changeWorkingDirectory(pathname);
				if (ftpClient.storeFile(fileName, inputStream)) {
					flag = true;
					log.info("鏂囦欢涓婁紶鎴愬姛銆嬨�嬨�嬨�嬨�嬨�嬨��?");
				}else {
					log.info("鏂囦欢涓婁紶澶辫触銆嬨�嬨�嬨�嬨�嬨�嬨��?");
				}
				}
				ftpClient.logout();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	// �?瑰彉鐩綍璺緞
	public boolean changeWorkingDirectory(String directory) {
		boolean flag = true;
		try {
			flag = ftpClient.changeWorkingDirectory(directory);
			if (flag) {
				System.out.println("杩涘叆鏂囦欢澶�" + directory + " 鎴愬姛锛�?");

			} else {
				System.out.println("杩涘叆鏂囦欢澶�" + directory + " 澶辫触锛佸紑濮嬪垱寤烘枃浠跺�?");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return flag;
	}

	// 鍒涘缓澶氬眰鐩綍鏂囦欢锛屽鏋滄湁ftp鏈嶅姟鍣ㄥ凡瀛樺湪璇ユ枃浠讹紝鍒欎笉鍒涘缓锛屽鏋滄棤锛屽垯鍒涘�?
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote + "/";
		// 濡傛灉杩滅▼鐩綍涓嶅瓨鍦紝鍒欓�掑綊鍒涘缓杩滅▼鏈嶅姟鍣ㄧ洰褰�
		if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			String path = "";
			String paths = "";
			while (true) {
				String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
				path = path + "/" + subDirectory;
				if (!existFile(path)) {
					if (makeDirectory(subDirectory)) {
						changeWorkingDirectory(subDirectory);
					} else {
						log.error("鍒涘缓鐩綍 : { } 澶辫�?",subDirectory);
						changeWorkingDirectory(subDirectory);
					}
				} else {
					changeWorkingDirectory(subDirectory);
				}

				paths = paths + "/" + subDirectory;
				start = end + 1;
				end = directory.indexOf("/", start);
				// 妫�鏌ユ墍鏈夌洰褰曟槸鍚�?垱寤哄畬姣�
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}

	// 鍒ゆ柇ftp鏈嶅姟鍣ㄦ枃浠舵槸鍚�?瓨鍦�?
	public boolean existFile(String path) throws IOException {
		boolean flag = false;
		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
		if (ftpFileArr.length > 0) {
			flag = true;
		}
		return flag;
	}

	// 鍒涘缓鐩綍
	public boolean makeDirectory(String dir) {
		boolean flag = true;
		try {
			flag = ftpClient.makeDirectory(dir);
			if (flag) {
				log.info("鍒涘缓鏂囦欢澶�   { } 鎴愬姛锛�?",dir);
			} else {
				log.error("鍒涘缓鏂囦欢澶�   { }   澶辫触锛�?",dir);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * * 涓嬭浇鏂囦欢 *
	 * 
	 * @param pathname  FTP鏈嶅姟鍣ㄦ枃浠剁洰褰�? *
	 * @param filename  鏂囦欢鍚嶇�? *
	 * @param localpath 涓嬭浇鍚庣殑鏂囦欢璺緞 *
	 * @return
	 */
	public boolean downloadFile(String pathname, String filename, String localpath) {
		boolean flag = false;
		OutputStream os = null;
		try {
			initFtpClient();
			// 鍒囨崲FTP鐩�?
			ftpClient.changeWorkingDirectory(pathname);
			FTPFile[] ftpFiles = ftpClient.listFiles();
			for (FTPFile file : ftpFiles) {
				if (filename.equalsIgnoreCase(file.getName())) {
					File localFile = new File(localpath + "/" + file.getName());
					os = new FileOutputStream(localFile);
					ftpClient.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			ftpClient.logout();
			flag = true;
			System.out.println("涓嬭浇鏂囦欢鎴愬�?");
		} catch (Exception e) {
			System.out.println("涓嬭浇鏂囦欢澶辫�?");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	/**
	 * * 鍒犻櫎鏂囦欢 *
	 * 
	 * @param pathname FTP鏈嶅姟鍣ㄤ繚瀛樼洰褰�? *
	 * @param filename 瑕佸垹闄ょ殑鏂囦欢鍚嶇�? *
	 * @return
	 */
	public boolean deleteFile(String pathname, String filename) {
		boolean flag = false;
		try {
			System.out.println("寮�濮嬪垹闄ゆ枃浠�");
			initFtpClient();
			// 鍒囨崲FTP鐩�?
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.dele(filename);
			ftpClient.logout();
			flag = true;
			System.out.println("鍒犻櫎鏂囦欢鎴愬�?");
		} catch (Exception e) {
			System.out.println("鍒犻櫎鏂囦欢澶辫�?");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		FtpUtils ftp = new FtpUtils();
		ftp.uploadFile("ftpFile/data", "Log.txt", "D://Log.txt");
		// ftp.downloadFile("ftpFile/data", "Log.txt", "C://Log.txt");
		// ftp.deleteFile("ftpFile/data", "123.docx");

	}
}
