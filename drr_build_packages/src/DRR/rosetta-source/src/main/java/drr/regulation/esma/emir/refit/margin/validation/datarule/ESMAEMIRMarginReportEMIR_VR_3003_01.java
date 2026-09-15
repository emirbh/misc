package drr.regulation.esma.emir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.functions.IsESMAThirdCountryEquivalentMarket;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRNonReportableCollateralData;
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
@RosettaDataRule("ESMAEMIRMarginReportEMIR_VR_3003_01")
@ImplementedBy(ESMAEMIRMarginReportEMIR_VR_3003_01.Default.class)
public interface ESMAEMIRMarginReportEMIR_VR_3003_01 extends Validator<ESMAEMIRMarginReport> {
	
	String NAME = "ESMAEMIRMarginReportEMIR_VR_3003_01";
	String DEFINITION = "if (GetOrFetchMicData(nonReportable -> enrichment -> micData, nonReportable -> mic) extract marketCategory = MicMarketCategoryEnum -> RMKT or IsESMAThirdCountryEquivalentMarket(mic)) = False then True else entityResponsibleForReporting is absent";
	
	class Default implements ESMAEMIRMarginReportEMIR_VR_3003_01 {
	
		@Inject protected GetOrFetchMicData getOrFetchMicData;
		
		@Inject protected IsESMAThirdCountryEquivalentMarket isESMAThirdCountryEquivalentMarket;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			try {
				if (areEqual(MapperS.of(getOrFetchMicData.evaluate(MapperS.of(eSMAEMIRMarginReport).<ESMAEMIRNonReportableCollateralData>map("getNonReportable", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", eSMAEMIRNonReportableCollateralData -> eSMAEMIRNonReportableCollateralData.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), MapperS.of(eSMAEMIRMarginReport).<ESMAEMIRNonReportableCollateralData>map("getNonReportable", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getNonReportable()).<String>map("getMic", eSMAEMIRNonReportableCollateralData -> eSMAEMIRNonReportableCollateralData.getMic()).get()))
					.mapSingleToItem(item -> areEqual(item.<MicMarketCategoryEnum>map("getMarketCategory", micData -> micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isESMAThirdCountryEquivalentMarket.evaluate(item.<String>map("getMic", micData -> micData.getMic()).get())))).asMapper()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return notExists(MapperS.of(eSMAEMIRMarginReport).<String>map("getEntityResponsibleForReporting", _eSMAEMIRMarginReport -> _eSMAEMIRMarginReport.getEntityResponsibleForReporting()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRMarginReportEMIR_VR_3003_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRMarginReport eSMAEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
