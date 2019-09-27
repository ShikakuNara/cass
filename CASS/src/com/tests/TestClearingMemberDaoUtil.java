package com.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.beans.ClearingMember;
import com.dao.ClearingMemberDaoUtil;

public class TestClearingMemberDaoUtil {

	@Test
	public final void testGetAllClearingMembers() {
		
		ClearingMemberDaoUtil cmd = new ClearingMemberDaoUtil();
		List<ClearingMember> actual = cmd.getAllClearingMembers();
		assertEquals(6, actual.size());
	
		ClearingMember cm = actual.get(2);
	    assertEquals(3 , actual.get(2).getClearingMemberID());
	    
	    assertEquals("DeutscheBank", actual.get(2).getClearingMemberName());
	    assertEquals(false, actual.get(2).isReportGenerated());
	    assertEquals(false, actual.get(2).isSubmitted());
	}

	@Test
	public final void testGetNameById() {
		ClearingMemberDaoUtil cmd = new ClearingMemberDaoUtil();
		String actual = cmd.getNameById(5);
		assertEquals("Barclays", actual);
		
	}

	@Test
	public final void testUpdateIsSubmitted() {
		ClearingMemberDaoUtil cmd = new ClearingMemberDaoUtil();
		ClearingMember cm = new ClearingMember();
		cm.setClearingMemberID(3);
		cm.setSubmitted(false);
		Boolean actual = cmd.updateIsSubmitted(cm);
		assertEquals(true, actual);
		
	}

	@Test
	public final void testUpdateIsReportGenerated() {
		ClearingMemberDaoUtil cmd = new ClearingMemberDaoUtil();
	}

}
