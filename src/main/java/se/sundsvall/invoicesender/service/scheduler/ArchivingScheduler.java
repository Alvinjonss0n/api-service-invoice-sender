package se.sundsvall.invoicesender.service.scheduler;

import org.springframework.stereotype.Component;
import se.sundsvall.dept44.scheduling.Dept44Scheduled;
import se.sundsvall.invoicesender.service.InvoiceProcessor;

import java.io.IOException;

import static se.sundsvall.invoicesender.integration.db.entity.BatchStatus.READY;

@Component
class ArchivingScheduler {
    private final InvoiceProcessor invoiceProcessor;

    ArchivingScheduler(InvoiceProcessor invoiceProcessor) {
        this.invoiceProcessor = invoiceProcessor;
    }

    @Dept44Scheduled(
            cron = "${scheduler.move-files.cron}",
            name = "${scheduler.move-files.name}",
            lockAtMostFor = "${scheduler.shedlock-at-most-for}",
            maximumExecutionTime = "${scheduler.maximum-execution-time}")
    void writeAndArchiveBatchScheduler() throws IOException {

        invoiceProcessor.writeAndArchiveBatch(READY);
    }
}
