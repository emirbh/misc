package drr.regulation.esma.emir.refit.trade.validation.datarule;

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
import drr.regulation.common.trade.NonReportable;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
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
@RosettaDataRule("ESMAEMIRTransactionReportEMIR_VR_2144_02")
@ImplementedBy(ESMAEMIRTransactionReportEMIR_VR_2144_02.Default.class)
public interface ESMAEMIRTransactionReportEMIR_VR_2144_02 extends Validator<ESMAEMIRTransactionReport> {
	
	String NAME = "ESMAEMIRTransactionReportEMIR_VR_2144_02";
	String DEFINITION = "if IsVRAllowedForActionType(actionType) then if referenceEntity exists then if GetOrFetchLeiData(empty, referenceEntity) exists then LeiRegistrationStatusIsValid( nonReportable -> enrichment -> leiData, referenceEntity, eventDate, reportingTimestamp -> date ) else if StringLength(referenceEntity) < 7 and IsValidRefEntity( referenceEntity ) = True then True else False";
	
	class Default implements ESMAEMIRTransactionReportEMIR_VR_2144_02 {
	
		@Inject protected GetOrFetchLeiData getOrFetchLeiData;
		
		@Inject protected IsVRAllowedForActionType isVRAllowedForActionType;
		
		@Inject protected IsValidRefEntity isValidRefEntity;
		
		@Inject protected LeiRegistrationStatusIsValid leiRegistrationStatusIsValid;
		
		@Inject protected StringLength stringLength;
		
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
					if (exists(MapperS.of(eSMAEMIRTransactionReport).<String>map("getReferenceEntity", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReferenceEntity())).getOrDefault(false)) {
						if (exists(MapperS.of(getOrFetchLeiData.evaluate(Collections.<LeiData>emptyList(), MapperS.of(eSMAEMIRTransactionReport).<String>map("getReferenceEntity", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReferenceEntity()).get()))).getOrDefault(false)) {
							return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValid.evaluate(MapperS.of(eSMAEMIRTransactionReport).<NonReportable>map("getNonReportable", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", nonReportable -> nonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(eSMAEMIRTransactionReport).<String>map("getReferenceEntity", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReferenceEntity()).get(), MapperS.of(eSMAEMIRTransactionReport).<Date>map("getEventDate", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getEventDate()).get(), MapperS.of(eSMAEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())));
						}
						if (lessThan(MapperS.of(stringLength.evaluate(MapperS.of(eSMAEMIRTransactionReport).<String>map("getReferenceEntity", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReferenceEntity()).get())), MapperS.of(7), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isValidRefEntity.evaluate(MapperS.of(eSMAEMIRTransactionReport).<String>map("getReferenceEntity", _eSMAEMIRTransactionReport -> _eSMAEMIRTransactionReport.getReferenceEntity()).get())), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
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
	class NoOp implements ESMAEMIRTransactionReportEMIR_VR_2144_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAEMIRTransactionReport eSMAEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
