package se.sundsvall.invoicesender.service.scheduler;

import java.io.IOException;
import org.springframework.stereotype.Component;
import se.sundsvall.dept44.scheduling.Dept44Scheduled;
import se.sundsvall.invoicesender.service.InvoiceProcessor;

@Component
class ArchivingScheduler {
	private final InvoiceProcessor invoiceProcessor;
	private String municipalityId;

	ArchivingScheduler(InvoiceProcessor invoiceProcessor) {
		this.invoiceProcessor = invoiceProcessor;
	}

	@Dept44Scheduled(
		cron = "${scheduler.move-files.cron}",
		name = "${scheduler.move-files.name}",
		lockAtMostFor = "${scheduler.shedlock-at-most-for}",
		maximumExecutionTime = "${scheduler.maximum-execution-time}")
	void writeAndArchiveBatchScheduler() throws IOException {

		invoiceProcessor.writeAndArchiveBatch("READY");
	}
}
