package com.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAUMByBranchArchive;
import com.entity.archive.ArchiveAUMByBranchMini;

public class AUMBYBranchArchiveAction extends ActionClass<ArchiveAUMByBranchMini> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3136644907368783094L;
	private ContactAUMByBranchArchive archiveController;

	@Override
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		archiveController = (ContactAUMByBranchArchive)context.getBean("aumByBranchArchive");
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
		try {
			archiveController.addArchive(date, condition);
			list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LIST;
	}
}

