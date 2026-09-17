package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FxLinkedNotionalAmount;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxLinkedNotionalAmountValidator implements Validator<FxLinkedNotionalAmount> {

	private List<ComparisonResult> getComparisonResults(FxLinkedNotionalAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("resetDate", (ZonedDateTime) o.getResetDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedFxSpotFixingDate", (ZonedDateTime) o.getAdjustedFxSpotFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedFxSpotRate", (BigDecimal) o.getObservedFxSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxLinkedNotionalAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxLinkedNotionalAmount", ValidationResult.ValidationType.CARDINALITY, "FxLinkedNotionalAmount", path, "", res.getError());
				}
				return success("FxLinkedNotionalAmount", ValidationResult.ValidationType.CARDINALITY, "FxLinkedNotionalAmount", path, "");
			})
			.collect(toList());
	}

}
