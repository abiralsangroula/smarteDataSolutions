package bqtest.web;

import bqtest.service.Member;
import bqtest.service.MemberFileProcessor;
import bqtest.service.impl.MemberFileProcessorImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {

	private static final Logger log = LoggerFactory.getLogger(FileController.class);

	@GetMapping(value = "/api/load-data/{state}")
	public List<Member> loadData(@Value("${config.file-to-load}") String fileToLoad,
			@PathVariable("state") String state) throws Exception {
		log.info("Got an request to load file {}", fileToLoad);

		File uploadedFile = new File(fileToLoad);

		Map<String, List<Member>> groupedMembers = processFile(uploadedFile);

		log.info("Successfully grouped to {} states ", groupedMembers.keySet().size());

		return groupedMembers.get(state);
	}

	private Map<String, List<Member>> processFile(File uploadedFile) throws Exception {
		/**
		 * Use MemberFileProcessor to process the file
		 */
		MemberFileProcessor processor = new MemberFileProcessorImpl();
		return processor.processFile(uploadedFile);
	}
}
