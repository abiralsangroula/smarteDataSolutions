package bqtest.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import bqtest.service.Member;

class TestSplitMembersByState {
	
	MemberFileProcessorImpl impl= new MemberFileProcessorImpl();
	List<Member> memberList= new ArrayList<>();
	
	@Test
	void splitMembersByState() {
		Member mem= new Member();
		mem.setId("11");
		mem.setFirstName("Member 1");
		mem.setState("NY");
		memberList.add(mem);
		
		Member mem2= new Member();
		mem2.setId("12");
		mem2.setFirstName("Member 2");
		mem2.setState("OK");
		memberList.add(mem2);
		
		Member mem3= new Member();
		mem3.setId("13");
		mem3.setFirstName("Member 3");
		mem3.setState("NY");
		memberList.add(mem3);
		
		Member mem4= new Member();
		mem4.setId("14");
		mem4.setFirstName("Member 4");
		mem4.setState("OK");
		memberList.add(mem4);
		
		Member mem5= new Member();
		mem5.setId("35");
		mem5.setFirstName("Member 5");
		mem5.setState("OK");
		memberList.add(mem5);
		
		Map<String, List<Member>> splitedMembers= impl.splitMembersByState(memberList);
		assertEquals(3, splitedMembers.get("OK").size());
		assertEquals(2, splitedMembers.get("NY").size());
	}

}

