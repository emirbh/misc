package drr.regulation.esma.emir.refit.trade.validation.datarule;

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
import drr.regulation.common.trade.NonReportable;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_1003_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_1003_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_1003_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_1003_01";
	String DEFINITION = "if (GetOrFetchMicData(nonReportable -> enrichment -> micData, venueOfExecution) extract marketCategory = MicMarketCategoryEnum -> RMKT or IsESMAThirdCountryEquivalentMarket(mic) = True) then entityResponsibleForReporting is absent else entityResponsibleForReporting exists";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_1003_01 {
	
		@Inject protected GetOrFetchMicData getOrFetchMicData;
		
		@Inject protected IsESMAThirdCountryEquivalentMarket isESMAThirdCountryEquivalentMarket;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			ComparisonResult result = executeDataRule(eSMAEMIRTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAEMIRTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			try {
				if (MapperS.of(getOrFetchMicData.evaluate(MapperS.of(eSMAEMIRTransactionReport).<NonReportable>map("getNonReportable", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), MapperS.of(eSMAEMIRTransactionReport).<String>map("getVenueOfExecution", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getVenueOfExecution()).get()))
					.mapSingleToItem(item -> areEqual(item.<MicMarketCategoryEnum>map("getMarketCategory", micData -> micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isESMAThirdCountryEquivalentMarket.evaluate(item.<String>map("getMic", micData -> micData.getMic()).get())), MapperS.of(true), CardinalityOperator.All)).asMapper()).getOrDefault(false)) {
					return notExists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getEntityResponsibleForReporting", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEntityResponsibleForReporting()));
				}
				return exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getEntityResponsibleForReporting", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEntityResponsibleForReporting()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_1003_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
