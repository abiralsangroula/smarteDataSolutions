package bqtest.service.impl;

import bqtest.service.Member;
import bqtest.service.MemberFileProcessor;
import bqtest.service.MemberImporter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MemberFileProcessorImpl extends MemberFileProcessor {

    /*
     * Implement methods here
     */

    @Override
    protected MemberImporter getMemberImporter() {
        return new MemberImporterImpl();
    }

    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
    	Set<String> nameSet = new HashSet<>();
    	return membersFromFile.stream()
		            .filter(e -> nameSet.add(e.getId()))
		            .collect(Collectors.toList());
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
    	return validMembers.stream()
        		  .collect(Collectors.groupingBy(Member::getState));
    }
}
