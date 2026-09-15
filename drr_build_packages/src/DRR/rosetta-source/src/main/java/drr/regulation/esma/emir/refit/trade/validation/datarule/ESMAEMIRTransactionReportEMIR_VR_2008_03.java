package drr.regulation.esma.emir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.functions.IsEU;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2008_03")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2008_03.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2008_03 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2008_03";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if isin is absent and (venueOfExecution exists and GetOrFetchMicData( nonReportable -> enrichment -> micData, venueOfExecution ) extract marketCategory = MicMarketCategoryEnum -> OTFS and IsEU(countryCode) = False) = True then (uniqueProductIdentifier exists or uniqueProductIdentifier is absent)";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2008_03 {
	
		@Inject protected GetOrFetchMicData getOrFetchMicData;
		
		@Inject protected IsEU isEU;
		
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
					if (notExists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getIsin", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getIsin())).andNullSafe(areEqual(exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getVenueOfExecution", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getVenueOfExecution())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(getOrFetchMicData.evaluate(MapperS.of(eSMAEMIRTransactionReport).<NonReportable>map("getNonReportable", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), MapperS.of(eSMAEMIRTransactionReport).<String>map("getVenueOfExecution", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getVenueOfExecution()).get()))
						.mapSingleToItem(item -> areEqual(item.<MicMarketCategoryEnum>map("getMarketCategory", micData -> micData.getMarketCategory()), MapperS.of(MicMarketCategoryEnum.OTFS), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isEU.evaluate(item.<String>map("getCountryCode", micData -> micData.getCountryCode()).get())), MapperS.of(false), CardinalityOperator.All)).asMapper()))), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
						return exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getUniqueProductIdentifier", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getUniqueProductIdentifier())).orNullSafe(notExists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getUniqueProductIdentifier", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getUniqueProductIdentifier())));
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2008_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
