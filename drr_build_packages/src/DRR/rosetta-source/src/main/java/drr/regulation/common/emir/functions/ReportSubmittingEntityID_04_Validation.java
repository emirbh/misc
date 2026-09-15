package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportSubmittingEntityID_04_Validation.ReportSubmittingEntityID_04_ValidationDefault.class)
public abstract class ReportSubmittingEntityID_04_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchLeiData getOrFetchLeiData;

	/**
	* @param enrichment 
	* @param reportSubmittingEntityID 
	* @return result 
	*/
	public Boolean evaluate(EnrichmentData enrichment, String reportSubmittingEntityID) {
		Boolean result = doEvaluate(enrichment, reportSubmittingEntityID);
		
		return result;
	}

	protected abstract Boolean doEvaluate(EnrichmentData enrichment, String reportSubmittingEntityID);

	public static class ReportSubmittingEntityID_04_ValidationDefault extends ReportSubmittingEntityID_04_Validation {
		@Override
		protected Boolean doEvaluate(EnrichmentData enrichment, String reportSubmittingEntityID) {
			Boolean result = null;
			return assignOutput(result, enrichment, reportSubmittingEntityID);
		}
		
		protected Boolean assignOutput(Boolean result, EnrichmentData enrichment, String reportSubmittingEntityID) {
			result = notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(enrichment).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), reportSubmittingEntityID)).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any).get();
			
			return result;
		}
	}
}
