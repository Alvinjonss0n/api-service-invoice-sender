package se.sundsvall.invoicesender.integration.db;

import static org.assertj.core.api.Assertions.assertThat;
import static se.sundsvall.invoicesender.integration.db.entity.BatchStatus.HANDLED;
import static se.sundsvall.invoicesender.integration.db.entity.BatchStatus.NEW;
import static se.sundsvall.invoicesender.integration.db.entity.BatchStatus.READY;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import se.sundsvall.invoicesender.integration.db.entity.BatchStatus;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("junit")
@Sql(scripts = {
	"/db/scripts/truncate.sql",
	"/db/scripts/testdata.sql"
})
class BatchRepositoryTest {
	@Autowired
	private BatchRepository batchRepositoryMock;

	@ParameterizedTest
	@MethodSource(value = "findAllByBatchStatusArgumentProvider")
	void testFindAllByBatchStatusHandled(final BatchStatus status, final Integer numberOfHits) {
		var result = batchRepositoryMock.findAllByBatchStatus(status);

		assertThat(result).allSatisfy(batch -> assertThat(batch.getBatchStatus()).isEqualTo(status)).hasSize(numberOfHits);
	}

	private static Stream<Arguments> findAllByBatchStatusArgumentProvider() {
		return Stream.of(
			Arguments.of(READY, 2),
			Arguments.of(NEW, 1),
			Arguments.of(HANDLED, 1));
	}
}
