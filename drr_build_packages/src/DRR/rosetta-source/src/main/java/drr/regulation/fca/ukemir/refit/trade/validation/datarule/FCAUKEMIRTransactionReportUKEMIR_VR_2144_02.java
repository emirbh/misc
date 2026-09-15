package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.qualification.event.functions.IsVRAllowedForActionType;
import drr.base.util.string.functions.StringLength;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.functions.GetOrFetchLeiData;
import drr.enrichment.lei.functions.LeiRegistrationStatusIsValid;
import drr.regulation.common.functions.IsValidRefEntity;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRNonReportable;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_2144_02")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_2144_02.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_2144_02 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_2144_02";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if referenceEntity exists then if GetOrFetchLeiData(empty, referenceEntity) exists then LeiRegistrationStatusIsValid( nonReportable -> enrichment -> leiData, referenceEntity, eventDate, reportingTimestamp -> date ) else if StringLength(referenceEntity) < 7 and IsValidRefEntity( referenceEntity ) = True then True else False";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_2144_02 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Inject protected IsValidRefEntity isValidRefEntity;
		
		@Inject protected LeiRegistrationStatusIsValid leiRegistrationStatusIsValid;
		
		@Inject protected StringLength stringLength;
		
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
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getReferenceEntity", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReferenceEntity())).getOrDefault(false)) {
						if (exists(MapperS.of(getOrFetchLeiData.evaluate(Collections.<LeiData>emptyList(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getReferenceEntity", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReferenceEntity()).get()))).getOrDefault(false)) {
							return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValid.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getReferenceEntity", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReferenceEntity()).get(), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()).get(), MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())));
						}
						if (lessThan(MapperS.of(stringLength.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getReferenceEntity", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReferenceEntity()).get())), MapperS.of(7), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isValidRefEntity.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getReferenceEntity", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReferenceEntity()).get())), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
							return ComparisonResult.ofNullSafe(MapperS.of(true));
						}
						return ComparisonResult.ofNullSafe(MapperS.of(false));
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_2144_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
