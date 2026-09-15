package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiStatusEnum;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EntityResponsibleForReporting_05_Validation.EntityResponsibleForReporting_05_ValidationDefault.class)
public abstract class EntityResponsibleForReporting_05_Validation implements RosettaFunction {
	
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

	public static class EntityResponsibleForReporting_05_ValidationDefault extends EntityResponsibleForReporting_05_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, String entityResponsibleForReporting) {
			Boolean result = null;
			return assignOutput(result, enrichment, entityResponsibleForReporting);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, String entityResponsibleForReporting) {
			if (exists(MapperS.of(entityResponsibleForReporting)).getOrDefault(false)) {
				result = exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), entityResponsibleForReporting)).<LeiStatusEnum>map("getEntityStatus", leiData -> leiData.getEntityStatus())).andNullSafe(notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), entityResponsibleForReporting)).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
