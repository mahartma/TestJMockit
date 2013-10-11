package test.jmockit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;

import org.junit.Test;

public class MailSenderTest {
	
	@Injectable
	private EmailService email;
	
	@Tested
	private MailSender mailSender = new MailSender();
	
	@Test
	public void shouldCallSend() {
		new NonStrictExpectations() {
			{ 
				email.send("Hello JMockit");
				result = true;
			}
		};
		mailSender.send("Hello JMockit");
		new Verifications() {

			{
				String msgToSend;
				email.send(msgToSend = withCapture());
				assertThat(msgToSend, is("Hello JMockit"));
			}
		};
	}
	
	@Test
	public void shouldReturnFalseIfMessageIsEmpty() {
		assertThat(mailSender.send(""), is(false));
	}
}