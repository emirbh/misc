package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EntityResponsibleForReporting_02_Validation.EntityResponsibleForReporting_02_ValidationDefault.class)
public abstract class EntityResponsibleForReporting_02_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchLeiData getOrFetchLeiData;

	/**
	* @param enrichment 
	* @param entityResponsibleForReporting 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, String entityResponsibleForReporting) {
		Boolean result = doEvaluate(enrichment, entityResponsibleForReporting);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, String entityResponsibleForReporting);

	public static class EntityResponsibleForReporting_02_ValidationDefault extends EntityResponsibleForReporting_02_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, String entityResponsibleForReporting) {
			Boolean result = null;
			return assignOutput(result, enrichment, entityResponsibleForReporting);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, String entityResponsibleForReporting) {
			result = exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), entityResponsibleForReporting))).get();
			
			return result;
		}
	}
}
