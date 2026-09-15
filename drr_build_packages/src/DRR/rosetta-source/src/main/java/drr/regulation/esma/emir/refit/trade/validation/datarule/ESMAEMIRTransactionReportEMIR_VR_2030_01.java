package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.functions.IsESMAThirdCountryEquivalentMarket;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearingObligationEnum;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2030_01")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2030_01.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2030_01 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2030_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if (venueOfExecution exists and GetOrFetchMicData( nonReportable -> enrichment -> micData, venueOfExecution ) extract (marketCategory = MicMarketCategoryEnum -> RMKT or IsESMAThirdCountryEquivalentMarket(mic) = True)) = False then clearingObligation exists and [ClearingObligationEnum -> TRUE, ClearingObligationEnum -> FLSE, ClearingObligationEnum -> UKWN] any = clearingObligation";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2030_01 {
	
		@Inject protected GetOrFetchMicData getOrFetchMicData;
		
		@Inject protected IsESMAThirdCountryEquivalentMarket isESMAThirdCountryEquivalentMarket;
		
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
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
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(eSMAEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					if (areEqual(exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getVenueOfExecution", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getVenueOfExecution())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(getOrFetchMicData.evaluate(MapperS.of(eSMAEMIRTransactionReport).<NonReportable>map("getNonReportable", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), MapperS.of(eSMAEMIRTransactionReport).<String>map("getVenueOfExecution", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getVenueOfExecution()).get()))
						.mapSingleToItem(item -> areEqual(item.<MicMarketCategoryEnum>map("getMarketCategory", micData -> micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isESMAThirdCountryEquivalentMarket.evaluate(item.<String>map("getMic", micData -> micData.getMic()).get())), MapperS.of(true), CardinalityOperator.All)).asMapper()))), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return exists(MapperS.of(eSMAEMIRTransactionReport).<ClearingObligationEnum>map("getClearingObligation", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getClearingObligation())).andNullSafe(areEqual(MapperC.<ClearingObligationEnum>of(MapperS.of(ClearingObligationEnum.TRUE), MapperS.of(ClearingObligationEnum.FLSE), MapperS.of(ClearingObligationEnum.UKWN)), MapperS.of(eSMAEMIRTransactionReport).<ClearingObligationEnum>map("getClearingObligation", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getClearingObligation()), CardinalityOperator.Any));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2030_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
