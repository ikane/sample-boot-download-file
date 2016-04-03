package org.ikane;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile() {
		System.out.println("\n********** Download File : ************\n");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		File file = FileUtils.getFile("/home/ubuntu/Documents/perrot2.jpeg");
		
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		
		return new ResponseEntity<>(fileSystemResource, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/downloadPDF", method=RequestMethod.GET)
	public ResponseEntity<Resource> downloadPDFFile() {
		System.out.println("\n********** Download PDF File : ************\n");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		
		File file = FileUtils.getFile("/home/ubuntu/Documents/103-2016Joumada2.pdf");
		
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		
		return new ResponseEntity<>(fileSystemResource, headers, HttpStatus.OK);
	}
}
