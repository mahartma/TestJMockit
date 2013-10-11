package test.jmockit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import mockit.Tested;

import org.junit.Test;


public class EmailServiceTest {

	@Tested
	private EmailService emailService = new EmailService();
	
	@Test
	public void shouldSendMessage() {
		boolean success = emailService.send("Hello JMockit");
		assertThat(success, is(true));
	}
}
