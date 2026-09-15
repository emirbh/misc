package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

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
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import drr.standards.iso.MarginActionEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3030_04")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3030_04.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3030_04 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3030_04";
	String DEFINITION = "if [MarginActionEnum -> MARU, MarginActionEnum -> CORR] any = actionType then ( if executionAgentOfCounterparty1 exists and executionAgentOfCounterparty2 is absent then LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty1, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] ) else if executionAgentOfCounterparty2 exists and executionAgentOfCounterparty1 is absent then LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty2, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> PendingArchival] ) else if executionAgentOfCounterparty1 exists and executionAgentOfCounterparty2 exists then LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty1, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingArchival] ) and LeiRegistrationStatusIsValidForStatus( nonReportable -> enrichment -> leiData, executionAgentOfCounterparty2, eventDate, reportingTimestamp -> date, [LeiRegistrationStatusEnum -> Issued, LeiRegistrationStatusEnum -> PendingTransfer, LeiRegistrationStatusEnum -> Lapsed, LeiRegistrationStatusEnum -> PendingArchival] ))";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3030_04 {
	
		@Inject protected LeiRegistrationStatusIsValidForStatus leiRegistrationStatusIsValidForStatus;
		
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
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.MARU), MapperS.of(MarginActionEnum.CORR)), MapperS.of(fCAUKEMIRMarginReport).<MarginActionEnum>map("getActionType", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get(), MapperS.of(fCAUKEMIRMarginReport).<Date>map("getEventDate", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getEventDate()).get(), MapperS.of(fCAUKEMIRMarginReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti())));
					}
					if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2())).andNullSafe(notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get(), MapperS.of(fCAUKEMIRMarginReport).<Date>map("getEventDate", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getEventDate()).get(), MapperS.of(fCAUKEMIRMarginReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti())));
					}
					if (exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1())).andNullSafe(exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()))).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty1", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty1()).get(), MapperS.of(fCAUKEMIRMarginReport).<Date>map("getEventDate", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getEventDate()).get(), MapperS.of(fCAUKEMIRMarginReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(leiRegistrationStatusIsValidForStatus.evaluate(MapperS.of(fCAUKEMIRMarginReport).<FCAUKEMIRNonReportableCollateralData>map("getNonReportable", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getNonReportable()).<EnrichmentData>map("getEnrichment", fCAUKEMIRNonReportableCollateralData -> fCAUKEMIRNonReportableCollateralData.getEnrichment()).<LeiData>mapC("getLeiData", enrichmentData -> enrichmentData.getLeiData()).getMulti(), MapperS.of(fCAUKEMIRMarginReport).<String>map("getExecutionAgentOfCounterparty2", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getExecutionAgentOfCounterparty2()).get(), MapperS.of(fCAUKEMIRMarginReport).<Date>map("getEventDate", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getEventDate()).get(), MapperS.of(fCAUKEMIRMarginReport).<ZonedDateTime>map("getReportingTimestamp", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getReportingTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperC.<LeiRegistrationStatusEnum>of(MapperS.of(LeiRegistrationStatusEnum.ISSUED), MapperS.of(LeiRegistrationStatusEnum.PENDING_TRANSFER), MapperS.of(LeiRegistrationStatusEnum.LAPSED), MapperS.of(LeiRegistrationStatusEnum.PENDING_ARCHIVAL)).getMulti()))));
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
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3030_04 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
