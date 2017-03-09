package Service;

import java.util.List;

import javax.ejb.Remote;

import Entity.Report;

@Remote
public interface ReportEJBRemote {
	public List<Report> findAllReports();
}
