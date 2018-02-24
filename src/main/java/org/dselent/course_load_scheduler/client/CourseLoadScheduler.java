package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.AdminRequestPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.MainPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.SchedulePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.UserRequestPresenterImpl;
import org.dselent.course_load_scheduler.client.service.impl.AccountServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.ScheduleServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.MainView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CourseLoadScheduler implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		RootLayoutPanel root = RootLayoutPanel.get();

		// Get the injector, which injected objects can be retrieved from
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		indexPresenter.init();
		IndexView indexView = indexPresenter.getView();		
		
		MainPresenterImpl mainPresenter = injector.getMainPresenter();
		mainPresenter.init();
		LoginPresenterImpl loginPresenter = injector.getLoginPresenter();
		loginPresenter.init();
		AccountPresenterImpl accountPresenter = injector.getAccountPresenter();
		accountPresenter.init();
		SchedulePresenterImpl schedulePresenter = injector.getSchedulePresenter();
		schedulePresenter.init();
		AdminRequestPresenterImpl requestPresenter = injector.getAdminRequestPresenter();
		requestPresenter.init();
		
		UserServiceImpl userService = injector.getUserService();
		userService.init();
		ScheduleServiceImpl scheduleService = injector.getScheduleService();
		scheduleService.init();
		AccountServiceImpl accountService = injector.getAccountService();
		accountService.init();
		
		indexPresenter.go(root);
		loginPresenter.go(indexView.getViewRootPanel());
		//mainPresenter.go(indexView.getViewRootPanel());
		schedulePresenter.go(mainPresenter.getSchedulePanel());
		requestPresenter.go(mainPresenter.getRequestPanel());
		accountPresenter.go(mainPresenter.getAccountPanel());
	}
}
