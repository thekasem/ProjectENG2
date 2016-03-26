package com.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAUMByBranchArchive;
import com.contact.action.ContactAUMByCIFArchive;
import com.contact.action.ContactPortHoldingBySubAccountArchive;
import com.entity.archive.ArchiveAUMByCIFMini;

public class AUMBYCIFArchiveAction extends ActionClass<ArchiveAUMByCIFMini> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3243711053882134978L;
	private ContactAUMByCIFArchive archiveController;
	private ContactAUMByBranchArchive contactAUMByBranchArchive;
	private ContactPortHoldingBySubAccountArchive contactPortHoldingBySubAccountArchive;

	@Override
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		archiveController = (ContactAUMByCIFArchive) context
				.getBean("aumByCIFArchive");
		contactAUMByBranchArchive = (ContactAUMByBranchArchive) context
				.getBean("aumByBranchArchive");
		contactPortHoldingBySubAccountArchive = (ContactPortHoldingBySubAccountArchive) context
				.getBean("portHoldingBySubAccountArchive");
		session();
	}

	@Override
	public String list() {
		ContactController();
		int record = 15;
		count = archiveController.getCount(entity);
		totalPage = totalPage(count, record);
		list = archiveController.getList(entity, true, false, page*record, record);

		return LIST;
	}

	@Override
	public String addArchive() {
		ContactController();
		archiveController.addArchive(date, condition);
		contactAUMByBranchArchive.addArchive(date, condition);
		contactPortHoldingBySubAccountArchive.addArchive(date, condition);
		list();
		return LIST;
	}

}