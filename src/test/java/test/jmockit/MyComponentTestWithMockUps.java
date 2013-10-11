package test.jmockit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyComponentTestWithMockUps {
	
	@Injectable
	private EmailService emailServiceMock;
	
	@Tested
	private MailSender mailSender = new MailSender();
	
	@Test
	public void shouldCallSend() {
		
		new MockUp<EmailService>() {
			private final Logger LOGGER = LoggerFactory.getLogger("MockedEmailService");
			@Mock(minInvocations = 1)
			boolean send(String msgToSend) {
				LOGGER.info("I'm a mock...");
				return true;
			}
		};
		assertThat(mailSender.send("Hello JMockit"), is(true));
	}
}