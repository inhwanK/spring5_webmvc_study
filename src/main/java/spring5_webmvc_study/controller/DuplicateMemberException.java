package spring5_webmvc_study.controller;

@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}

}
