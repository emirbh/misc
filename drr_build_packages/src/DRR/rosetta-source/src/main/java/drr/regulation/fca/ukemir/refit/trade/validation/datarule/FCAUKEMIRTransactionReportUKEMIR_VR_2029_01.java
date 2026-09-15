package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

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
import drr.regulation.common.functions.IsFCAThirdCountryEquivalentMarket;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRNonReportable;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2029_01")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2029_01.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2029_01 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2029_01";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if (venueOfExecution exists and GetOrFetchMicData( nonReportable -> enrichment -> micData, venueOfExecution ) extract (marketCategory = MicMarketCategoryEnum -> RMKT or IsFCAThirdCountryEquivalentMarket(mic) = True)) = False and cleared = N and [ConfirmationEnum -> YCNF, ConfirmationEnum -> NCNF, ConfirmationEnum -> ECNF] any = confirmed then True else confirmed is absent";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2029_01 {
	
		@Inject protected GetOrFetchMicData getOrFetchMicData;
		
		@Inject protected IsFCAThirdCountryEquivalentMarket isFCAThirdCountryEquivalentMarket;
		
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
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
				final Boolean _boolean = isVRAllowedForActionType.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()).get());
				if ((_boolean == null ? false : _boolean)) {
					if (areEqual(exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getVenueOfExecution", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getVenueOfExecution())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(getOrFetchMicData.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getVenueOfExecution", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getVenueOfExecution()).get()))
						.mapSingleToItem(item -> areEqual(item.<MicMarketCategoryEnum>map("getMarketCategory", micData -> micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.RMKT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isFCAThirdCountryEquivalentMarket.evaluate(item.<String>map("getMic", micData -> micData.getMic()).get())), MapperS.of(true), CardinalityOperator.All)).asMapper()))), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(fCAUKEMIRTransactionReport).<ClearedEnum>map("getCleared", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<ConfirmationEnum>of(MapperS.of(ConfirmationEnum.YCNF), MapperS.of(ConfirmationEnum.NCNF), MapperS.of(ConfirmationEnum.ECNF)), MapperS.of(fCAUKEMIRTransactionReport).<ConfirmationEnum>map("getConfirmed", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getConfirmed()), CardinalityOperator.Any)).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return notExists(MapperS.of(fCAUKEMIRTransactionReport).<ConfirmationEnum>map("getConfirmed", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getConfirmed()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2029_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
