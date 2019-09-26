package com.interfaces;

import java.util.List;

import com.beans.ClearingMember;

public interface ClearingMemberDao {
	public List<ClearingMember> getAllClearingMembers();
	public String getNameById(int clearingMemberId);
	public boolean updateIsSubmitted(ClearingMember clearingMember);
	public boolean updateIsReportGenerated();
}
