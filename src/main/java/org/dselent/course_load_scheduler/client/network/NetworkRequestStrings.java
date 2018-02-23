package org.dselent.course_load_scheduler.client.network;

public final class NetworkRequestStrings
{
	public static final String SERVER_LOCATION = "http://localhost:8080/";
	public static final String BASE_REQUEST = "course_load_scheduler/";
	public static String LOGIN = "user/login";
	public static String REGISTER = "user/register";
	public static String CLICK_SCHEDULE_TAB = "scheduler/page";
	public static String EDIT_INSTRUCTOR = "scheduler/instructors/edit";
	public static String EDIT_COURSE = "scheduler/courses/edit";
	public static String EDIT_SECTION = "scheduler/sections/edit";
	public static String SELECT_INSTRUCTOR = "scheduler/instructors/select";
	public static String SELECT_COURSE = "scheduler/courses/select";
	public static String VALIDATE = "scheduler/schedule/validate";
	public static String CHANGE_PASSWORD = "account/change/password";
	public static String CLICK_ACCOUNT_TAB = "account/page";
	public static String EDIT_USER = "account/user/edit";
	public static String SUBMIT_RESPONSE = "requests/submit/response";
	public static String SUBMIT_USER_REQUEST = "/requests/submit/request";
	public static String SELECT_REQUEST = "/requests/select/request";

	
	private NetworkRequestStrings() {};
}
