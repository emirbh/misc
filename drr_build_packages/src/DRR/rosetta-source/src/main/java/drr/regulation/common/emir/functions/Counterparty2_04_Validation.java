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

@ImplementedBy(Counterparty2_04_Validation.Counterparty2_04_ValidationDefault.class)
public abstract class Counterparty2_04_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchLeiData getOrFetchLeiData;

	/**
	* @param enrichment 
	* @param counterparty2IdentifierType 
	* @param counterparty2 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2) {
		Boolean result = doEvaluate(enrichment, counterparty2IdentifierType, counterparty2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2);

	public static class Counterparty2_04_ValidationDefault extends Counterparty2_04_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2) {
			Boolean result = null;
			return assignOutput(result, enrichment, counterparty2IdentifierType, counterparty2);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, Boolean counterparty2IdentifierType, String counterparty2) {
			if (areEqual(MapperS.of(counterparty2IdentifierType), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				result = exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), counterparty2)).<LeiStatusEnum>map("getEntityStatus", leiData -> leiData.getEntityStatus())).andNullSafe(notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), counterparty2)).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
