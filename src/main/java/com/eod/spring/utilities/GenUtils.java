package com.eod.spring.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.eod.entities.FileDownload;
import com.eod.spring.def.EodDefault;

public class GenUtils {

	private static final int BUFFER_SIZE = 4096;

	public void URLDnldFile(URL urlink, String fileName) throws IOException {
		try {
			URL link = new URL(
					"https://www.nseindia.com/api/live-analysis-oi-spurts-underlyings?type=underlying&csv=true&partialFileName=By-Underlying");
			InputStream ins = link.openStream();
			ReadableByteChannel chh = Channels.newChannel(link.openStream());
			FileOutputStream fos = new FileOutputStream(new File(
					"C:\\Users\\Ram\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring-batch-example-main\\spring-batch-example-main\\eod.csv"));
			fos.getChannel().transferFrom(chh, 0, Long.MAX_VALUE);
			fos.close();
			chh.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getTodayDate() {
		String pattern = "dd-MM-yyyy";
		String todayDate = new SimpleDateFormat(pattern).format(new Date());
		return todayDate;
	}

	public static String eodFileName(FileDownload fileDownload) {
		if (fileDownload.getDownloadDate().isBlank())
			return "EOD-" + getTodayDate() + ".csv";
		else
			return "EOD-" + fileDownload.getDownloadDate() + ".csv";
	}

	public static String getDateTimeNow() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime timeNow = LocalDateTime.now();
		return dtf.format(timeNow);
	}

	public static String oiSpurtsName() {
		return "SPRUT-" + getDateTimeNow() + ".csv";
	}

	// sorting a map in descending order
	public static LinkedHashMap<String, Long> descendingMapSort(Map<String, Long> unsortedValues) {
		LinkedHashMap<String, Long> sortedValues = new LinkedHashMap<>();
		unsortedValues.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sortedValues.put(x.getKey(), x.getValue()));
		return sortedValues;
	}

	public static boolean downloadFile(URL url, String outputFileName) throws IOException {
		System.out.println(outputFileName);
		try (InputStream in = url.openStream();
				ReadableByteChannel rbc = Channels.newChannel(in);
				FileOutputStream fos = new FileOutputStream(outputFileName)) {
			System.out.println(in.toString());
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			System.out.println("File " + outputFileName + " downloaded successfully!");
			return true;
		}
	}

	public static boolean moveFile(FileDownload fileDownload) {
		boolean fileMoved = true;
		String uri = EodDefault.filePath + GenUtils.eodFileName(fileDownload);
		try {
			Files.move(Paths.get(uri), Paths.get(EodDefault.eodDataSavePath + GenUtils.eodFileName(fileDownload)),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			fileMoved = false;
			e.printStackTrace();
		}
		return fileMoved;
	}

	public static String getEodBhavUrl(String fileName) {
		// https://archives.nseindia.com/content/historical/EQUITIES/2023/MAR/cm10MAR2023bhav.csv.zip
		String eodBhavUrl = null;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate localDate = LocalDate.now();
		String todayDate = dateFormatter.format(localDate).toString().toUpperCase();
		//for delayed download
		if (fileName.isEmpty()) {
			eodBhavUrl = "https://archives.nseindia.com/content/historical/EQUITIES/" + todayDate.substring(5) + "/"
					+ todayDate.substring(2, 5) + "/cm" + todayDate + "bhav.csv.zip";
			return eodBhavUrl;
		} else
			eodBhavUrl = "https://archives.nseindia.com/content/historical/EQUITIES/"+fileName;
		return eodBhavUrl;
	}

	private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}

	public static boolean unzip(String zipFilePath, String destDirectory) throws IOException {
		File destDir = new File(destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
		ZipEntry entry = zipIn.getNextEntry();
		// iterates over entries in the zip file
		while (entry != null) {
			String filePath = destDirectory + File.separator + entry.getName();
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				extractFile(zipIn, filePath);
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath);
				dir.mkdirs();
			}
			zipIn.closeEntry();
			entry = zipIn.getNextEntry();
		}
		zipIn.close();
		return true;
	}

	public static boolean deleteFile(String filePath) throws URISyntaxException {

		try {
			File file = new File(filePath);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
