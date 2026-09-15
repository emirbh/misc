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


@ImplementedBy(EntityResponsibleForReporting_03_Validation.EntityResponsibleForReporting_03_ValidationDefault.class)
public abstract class EntityResponsibleForReporting_03_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected LeiRegistrationStatusIsValidForStatus leiRegistrationStatusIsValidForStatus;

	/**
	* @param enrichment 
	* @param entityResponsibleForReporting 
	* @param reportingTimestamp 
	* @param eventDate 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, String entityResponsibleForReporting, ZonedDateTime reportingTimestamp, Date eventDate) {
		Boolean result = doEvaluate(enrichment, entityResponsibleForReporting, reportingTimestamp, eventDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, String entityResponsibleForReporting, ZonedDateTime reportingTimestamp, Date eventDate);

	public static class EntityResponsibleForReporting_03_ValidationDefault extends EntityResponsibleForReporting_03_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, String entityResponsibleForReporting, ZonedDateTime reportingTimestamp, Date eventDate) {
			Boolean result = null;
			return assignOutput(result, enrichment, entityResponsibleForReporting, reportingTimestamp, eventDate);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, String entityResponsibleForReporting, ZonedDateTime reportingTimestamp, Date eventDate) {
			result = leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), entityResponsibleForReporting, eventDate, MapperS.of(reportingTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti());
			
			return result;
		}
	}
}
