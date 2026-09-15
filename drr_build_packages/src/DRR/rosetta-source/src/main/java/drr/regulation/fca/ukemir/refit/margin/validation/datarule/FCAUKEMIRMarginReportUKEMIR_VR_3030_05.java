package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

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
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3030_05")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3030_05.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3030_05 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3030_05";
	String DEFINITION = "( if executionAgentOfCounterparty1 exists and executionAgentOfCounterparty2 is absent then (if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty1 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty1 ) -> entityCategory <> LeiCategoryEnum -> Branch) else if executionAgentOfCounterparty2 exists and executionAgentOfCounterparty1 is absent then (if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty2 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty2 ) -> entityCategory <> LeiCategoryEnum -> Branch) else if executionAgentOfCounterparty1 exists and executionAgentOfCounterparty2 exists then ((if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty1 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty1 ) -> entityCategory <> LeiCategoryEnum -> Branch) and (if GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty2 ) exists then GetOrFetchLeiData( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty2 ) -> entityCategory <> LeiCategoryEnum -> Branch else True)))";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3030_05 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			try {
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).getOrDefault(false)) {
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get()))).getOrDefault(false)) {
						return notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					}
					return ComparisonResult.ofEmpty();
				}
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2())).andNullSafe(notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()))).getOrDefault(false)) {
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get()))).getOrDefault(false)) {
						return notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					}
					return ComparisonResult.ofEmpty();
				}
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get()))).getOrDefault(false)) {
						ifThenElseResult0 = notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
					} else {
						ifThenElseResult0 = ComparisonResult.ofEmpty();
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get()))).getOrDefault(false)) {
						ifThenElseResult1 = notEqual(MapperS.of(getOrFetchLeiData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get())).<LeiCategoryEnum>map("getEntityCategory", leiData -> leiData.getEntityCategory()), MapperS.of(LeiCategoryEnum.BRANCH), CardinalityOperator.Any);
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
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3030_05 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
