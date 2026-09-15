package drr.regulation.mas.rewrite.valuation.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MASValuationReportValidator implements Validator<MASValuationReport> {

	private List<ComparisonResult> getComparisonResults(MASValuationReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingTimestamp", (ZonedDateTime) o.getReportingTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty1", (String) o.getCounterparty1() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty2IdentifierType", (Boolean) o.getCounterparty2IdentifierType() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty2", (String) o.getCounterparty2() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationAmount", (BigDecimal) o.getValuationAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationCurrency", (ISOCurrencyCodeEnum) o.getValuationCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationTimestamp", (ZonedDateTime) o.getValuationTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationMethod", (ValuationType1Code) o.getValuationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("delta", (BigDecimal) o.getDelta() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionTypeEnum) o.getActionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("level", (ReportLevelEnum) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("technicalRecordId", (String) o.getTechnicalRecordId() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportSubmittingEntityID", (String) o.getReportSubmittingEntityID() != null ? 1 : 0, 1, 1), 
				checkCardinality("entityResponsibleForReporting", (String) o.getEntityResponsibleForReporting() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2IdentifierSource", (String) o.getCounterparty2IdentifierSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("nextFloatingReferenceResetDateLeg1", (Date) o.getNextFloatingReferenceResetDateLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("nextFloatingReferenceResetDateLeg2", (Date) o.getNextFloatingReferenceResetDateLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("uniqueTransactionIdentifier", (String) o.getUniqueTransactionIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("uniqueTransactionIdentifierProprietary", (String) o.getUniqueTransactionIdentifierProprietary() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventDate", (Date) o.getEventDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollateralPortfolioCode", (String) o.getVariationMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollateralPortfolioCode", (String) o.getInitialMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceValueLeg1", (BigDecimal) o.getLastFloatingReferenceValueLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceValueLeg2", (BigDecimal) o.getLastFloatingReferenceValueLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceResetDateLeg1", (Date) o.getLastFloatingReferenceResetDateLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastFloatingReferenceResetDateLeg2", (Date) o.getLastFloatingReferenceResetDateLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionAgentOfTheCounterparty1", (String) o.getExecutionAgentOfTheCounterparty1() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionAgentOfTheCounterparty2", (String) o.getExecutionAgentOfTheCounterparty2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MASValuationReport", ValidationResult.ValidationType.CARDINALITY, "MASValuationReport", path, "", res.getError());
				}
				return success("MASValuationReport", ValidationResult.ValidationType.CARDINALITY, "MASValuationReport", path, "");
			})
			.collect(toList());
	}

}
