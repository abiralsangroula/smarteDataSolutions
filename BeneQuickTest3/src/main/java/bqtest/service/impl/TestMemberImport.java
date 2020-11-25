package bqtest.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import bqtest.service.Member;
import bqtest.service.MemberFileProcessor;
import bqtest.service.MemberImporter;

class TestMemberImport {

	MemberImporter memberImport = new MemberImporterImpl();
	List<Member> memberList = new ArrayList<>();
//	MemberFileProcessorImpl impl= new MemberFileProcessorImpl();

	@Test
	void importMembersTest() throws Exception {
		File uploadedFile = new File("Members.txt");
		memberList = memberImport.importMembers(uploadedFile);
		assertEquals(108, memberList.size());
	}
}
