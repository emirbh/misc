package drr.regulation.fca.ukemir.refit.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.lei.LeiData;
import drr.enrichment.lei.LeiRegistrationStatusEnum;
import drr.enrichment.lei.functions.LeiRegistrationStatusIsValidForStatus;
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
@RosettaDataRule("FCAUKEMIRTransactionReportUKEMIR_VR_1021_04")
@ImplementedBy(FCAUKEMIRTransactionReportUKEMIR_VR_1021_04.Default.class)
public interface FCAUKEMIRTransactionReportUKEMIR_VR_1021_04 extends Validator<FCAUKEMIRTransactionReport> {
	
	String NAME = "FCAUKEMIRTransactionReportUKEMIR_VR_1021_04";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> POSC] any = actionType then ( if executionAgentCounterparty1 exists and executionAgentCounterparty2 is absent then LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentCounterparty1, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] ) else if executionAgentCounterparty2 exists and executionAgentCounterparty1 is absent then LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentCounterparty2, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] ) else if executionAgentCounterparty1 exists and executionAgentCounterparty2 exists then LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentCounterparty2, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] ) and LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentCounterparty2, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] ))";
	
	class Default implements FCAUKEMIRTransactionReportUKEMIR_VR_1021_04 {
	
		@Inject protected LeiRegistrationStatusIsValidForStatus leiRegistrationStatusIsValidForStatus;
		
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.POSC)), MapperS.of(fCAUKEMIRTransactionReport).<ActionTypeEnum>map("getActionType", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1())).andNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()).get(), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()).get(), MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti())));
					}
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2())).andNullSafe(notExists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1()))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get(), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()).get(), MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti())));
					}
					if (exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty1", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty1())).andNullSafe(exists(MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get(), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()).get(), MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRTransactionReport).<FCAUKEMIRNonReportable>map("getNonReportable", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportable -> fCAUKEMIRNonReportable.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRTransactionReport).<String>map("getExecutionAgentCounterparty2", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getExecutionAgentCounterparty2()).get(), MapperS.of(fCAUKEMIRTransactionReport).<Date>map("getEventDate", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getEventDate()).get(), MapperS.of(fCAUKEMIRTransactionReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRTransactionReport -> _fCAUKEMIRTransactionReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti()))));
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
	class NoOp implements FCAUKEMIRTransactionReportUKEMIR_VR_1021_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRTransactionReport fCAUKEMIRTransactionReport) {
			return Collections.emptyList();
		}
	}
}
