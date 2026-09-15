package drr.regulation.common.valuation.validation;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.valuation.CriticalDataElement;
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

public class CriticalDataElementValidator implements Validator<CriticalDataElement> {

	private List<ComparisonResult> getComparisonResults(CriticalDataElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportingTimestamp", (ZonedDateTime) o.getReportingTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty1", (String) o.getCounterparty1() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty2IdentifierType", (Boolean) o.getCounterparty2IdentifierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2", (String) o.getCounterparty2() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationAmount", (BigDecimal) o.getValuationAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationCurrency", (ISOCurrencyCodeEnum) o.getValuationCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationTimestamp", (ZonedDateTime) o.getValuationTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationMethod", (ValuationType1Code) o.getValuationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("delta", (BigDecimal) o.getDelta() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionTypeEnum) o.getActionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("level", (ReportLevelEnum) o.getLevel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CriticalDataElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CriticalDataElement", ValidationResult.ValidationType.CARDINALITY, "CriticalDataElement", path, "", res.getError());
				}
				return success("CriticalDataElement", ValidationResult.ValidationType.CARDINALITY, "CriticalDataElement", path, "");
			})
			.collect(toList());
	}

}
