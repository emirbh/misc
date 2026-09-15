package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.eq.shared.DividendPeriodDividend;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendPeriodDividendValidator implements Validator<DividendPeriodDividend> {

	private List<ComparisonResult> getComparisonResults(DividendPeriodDividend o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedStartDate", (IdentifiedDate) o.getUnadjustedStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedEndDate", (IdentifiedDate) o.getUnadjustedEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerReference", (AssetReference) o.getUnderlyerReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividend", (NonNegativeMoney) o.getDividend() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPeriodDividend o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPeriodDividend", ValidationResult.ValidationType.CARDINALITY, "DividendPeriodDividend", path, "", res.getError());
				}
				return success("DividendPeriodDividend", ValidationResult.ValidationType.CARDINALITY, "DividendPeriodDividend", path, "");
			})
			.collect(toList());
	}

}
