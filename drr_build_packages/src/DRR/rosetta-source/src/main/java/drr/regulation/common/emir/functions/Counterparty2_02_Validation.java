package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.LeiRegistrationStatusIsValid;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2_02_Validation.Counterparty2_02_ValidationDefault.class)
public abstract class Counterparty2_02_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected LeiRegistrationStatusIsValid leiRegistrationStatusIsValid;

	/**
	* @param enrichment 
	* @param counterparty2IdentifierType 
	* @param counterparty2 
	* @param eventDate 
	* @param reportingTimestamp 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2, Date eventDate, ZonedDateTime reportingTimestamp) {
		Boolean result = doEvaluate(enrichment, counterparty2IdentifierType, counterparty2, eventDate, reportingTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2, Date eventDate, ZonedDateTime reportingTimestamp);

	public static class Counterparty2_02_ValidationDefault extends Counterparty2_02_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2, Date eventDate, ZonedDateTime reportingTimestamp) {
			Boolean result = null;
			return assignOutput(result, enrichment, counterparty2IdentifierType, counterparty2, eventDate, reportingTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2, Date eventDate, ZonedDateTime reportingTimestamp) {
			if (areEqual(MapperS.of(counterparty2IdentifierType), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				result = leiRegistrationStatusIsValid.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), counterparty2, eventDate, MapperS.of(reportingTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get());
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
