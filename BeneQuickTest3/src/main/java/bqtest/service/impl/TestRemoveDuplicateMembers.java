package bqtest.service.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bqtest.service.Member;

class TestRemoveDuplicateMembers {
	
	MemberFileProcessorImpl impl= new MemberFileProcessorImpl();
	List<Member> memberList= new ArrayList<>();
	
	@Test
	void removeDuplicateMembers() {
		Member mem= new Member();
		mem.setId("11");
		mem.setFirstName("Abiral");
		memberList.add(mem);
		
		Member mem2= new Member();
		mem.setId("22");
		mem.setFirstName("Member 2");
		memberList.add(mem2);
		
		Member mem3= new Member();
		mem.setId("11");
		mem.setFirstName("Member 3");
		memberList.add(mem3);
		
		Member mem4= new Member();
		mem.setId("11");
		mem.setFirstName("Member 4");
		memberList.add(mem4);
		
		Member mem5= new Member();
		mem.setId("33");
		mem.setFirstName("Member 5");
		memberList.add(mem5);
		
		List<Member> nonDuplicateMembers= impl.getNonDuplicateMembers(memberList);
		assertEquals(2, nonDuplicateMembers.size());
	}

}

