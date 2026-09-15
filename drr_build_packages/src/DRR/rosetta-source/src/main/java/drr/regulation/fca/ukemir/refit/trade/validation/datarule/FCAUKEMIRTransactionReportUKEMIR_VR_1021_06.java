package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiCategoryEnum;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRNonReportable;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1021_06")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1021_06.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1021_06 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1021_06";
	String DEFINITION = "if executionAgentCounterparty1 exists and executionAgentCounterparty2 is absent then (if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty1 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty1 ) -> entityCategory <> LeiCategoryEnum -> Branch) else if executionAgentCounterparty2 exists and executionAgentCounterparty1 is absent then (if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty2 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty2 ) -> entityCategory <> LeiCategoryEnum -> Branch) else if executionAgentCounterparty1 exists and executionAgentCounterparty2 exists then ((if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty1 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty1 ) -> entityCategory <> LeiCategoryEnum -> Branch) and (if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty2 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentCounterparty2 ) -> entityCategory <> LeiCategoryEnum -> Branch else True))";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1021_06 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			try {
				if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1())).andNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()))).getOrDefault(false)) {
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()).get()))).getOrDefault(false)) {
						return notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					}
					return ComparisonResult.ofEmpty();
				}
				if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2())).andNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()))).getOrDefault(false)) {
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get()))).getOrDefault(false)) {
						return notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					}
					return ComparisonResult.ofEmpty();
				}
				if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1())).andNullSafe(exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()).get()))).getOrDefault(false)) {
						ifThenElseResult0 = notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					} else {
						ifThenElseResult0 = ComparisonResult.ofEmpty();
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get()))).getOrDefault(false)) {
						ifThenElseResult1 = notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					} else {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1021_06 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
