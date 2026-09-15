package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.functions.LeiRegistrationStatusIsValidForStatus;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(Counterparty1_02_Validation.Counterparty1_02_ValidationDefault.class)
public abstract class Counterparty1_02_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected LeiRegistrationStatusIsValidForStatus leiRegistrationStatusIsValidForStatus;

	/**
	* @param enrichment 
	* @param counterparty1 
	* @param eventDate 
	* @param reportingTimestamp 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, String counterparty1, Date eventDate, ZonedDateTime reportingTimestamp) {
		Boolean result = doEvaluate(enrichment, counterparty1, eventDate, reportingTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, String counterparty1, Date eventDate, ZonedDateTime reportingTimestamp);

	public static class Counterparty1_02_ValidationDefault extends Counterparty1_02_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, String counterparty1, Date eventDate, ZonedDateTime reportingTimestamp) {
			Boolean result = null;
			return assignOutput(result, enrichment, counterparty1, eventDate, reportingTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, String counterparty1, Date eventDate, ZonedDateTime reportingTimestamp) {
			result = leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), counterparty1, eventDate, MapperS.of(reportingTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti());
			
			return result;
		}
	}
}
