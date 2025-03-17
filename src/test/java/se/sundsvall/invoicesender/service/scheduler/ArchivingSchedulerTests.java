package se.sundsvall.invoicesender.service.scheduler;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sundsvall.invoicesender.service.InvoiceProcessor;

@ExtendWith(MockitoExtension.class)
class ArchivingSchedulerTests {

	@Mock
	private InvoiceProcessor invoiceProcessor;

	@InjectMocks
	private ArchivingScheduler archivingScheduler;

	@Test
	void testWriteAndArchiveBatchScheduler() throws IOException {
		archivingScheduler.writeAndArchiveBatchScheduler();

		verify(invoiceProcessor, times(1)).writeAndArchiveBatch("READY");
	}
}
