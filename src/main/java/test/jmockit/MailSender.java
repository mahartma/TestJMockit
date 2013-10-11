package test.jmockit;

public class MailSender {

	private EmailService mailService;

	public boolean send(String msgToSend) {
		if (msgToSend.length() > 0) {
			return mailService.send(msgToSend);
		}
		return false;
	}
}