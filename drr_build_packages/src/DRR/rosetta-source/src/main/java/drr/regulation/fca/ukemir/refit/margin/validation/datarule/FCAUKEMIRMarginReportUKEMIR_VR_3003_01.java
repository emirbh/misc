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
import drr.regulation.common.functions.IsFCAThirdCountryEquivalentMarket;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import drr.standards.iso.MicData;
import drr.standards.iso.MicMarketCategoryEnum;
import drr.standards.iso.functions.GetOrFetchMicData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3003_01")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3003_01.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3003_01 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3003_01";
	String DEFINITION = "if (GetOrFetchMicData(nonReportable -> enrichment -> micData, nonReportable -> mic) extract marketCategory = MicMarketCategoryEnum -> RMKT or IsFCAThirdCountryEquivalentMarket(mic)) = False then True";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3003_01 {
	
		@Inject protected GetOrFetchMicData getOrFetchMicData;
		
		@Inject protected IsFCAThirdCountryEquivalentMarket isFCAThirdCountryEquivalentMarket;
		
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
				if (areEqual(MapperS.of(getOrFetchMicData.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<String>map("getMic", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getMic()).get()))
					.mapSingleToItem(item -> areEqual(item.<MicMarketCategoryEnum>map("getMarketCategory", micData -> micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFCAThirdCountryEquivalentMarket.evaluate(item.<String>map("getMic", micData -> micData.getMic()).get())))).asMapper()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3003_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
