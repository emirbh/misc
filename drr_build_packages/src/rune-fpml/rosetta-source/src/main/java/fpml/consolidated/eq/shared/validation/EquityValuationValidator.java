package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.AdjustableDateOrRelativeDateSequence;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.fpmlenum.FPVFinalPriceElectionFallbackEnum;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.BusinessCenterTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityValuationValidator implements Validator<EquityValuation> {

	private List<ComparisonResult> getComparisonResults(EquityValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDate", (AdjustableDateOrRelativeDateSequence) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDates", (AdjustableRelativeOrPeriodicDates) o.getValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationTimeType", (TimeTypeEnum) o.getValuationTimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationTime", (BusinessCenterTime) o.getValuationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("futuresPriceValuation", (Boolean) o.getFuturesPriceValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsPriceValuation", (Boolean) o.getOptionsPriceValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfValuationDates", (Integer) o.getNumberOfValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendValuationDates", (AdjustableRelativeOrPeriodicDates) o.getDividendValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("fPVFinalPriceElectionFallback", (FPVFinalPriceElectionFallbackEnum) o.getFPVFinalPriceElectionFallback() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityValuation", ValidationResult.ValidationType.CARDINALITY, "EquityValuation", path, "", res.getError());
				}
				return success("EquityValuation", ValidationResult.ValidationType.CARDINALITY, "EquityValuation", path, "");
			})
			.collect(toList());
	}

}
