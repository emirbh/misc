package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty1_01_Validation.Counterparty1_01_ValidationDefault.class)
public abstract class Counterparty1_01_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchLeiData getOrFetchLeiData;

	/**
	* @param enrichment 
	* @param counterparty1 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, String counterparty1) {
		Boolean result = doEvaluate(enrichment, counterparty1);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, String counterparty1);

	public static class Counterparty1_01_ValidationDefault extends Counterparty1_01_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, String counterparty1) {
			Boolean result = null;
			return assignOutput(result, enrichment, counterparty1);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, String counterparty1) {
			result = exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), counterparty1))).get();
			
			return result;
		}
	}
}
