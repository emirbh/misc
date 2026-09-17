package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapPaymentDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapPaymentDatesValidator implements Validator<ReturnSwapPaymentDates> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapPaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDatesInterim", (AdjustableOrRelativeDates) o.getPaymentDatesInterim() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDateFinal", (AdjustableOrRelativeDate) o.getPaymentDateFinal() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapPaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapPaymentDates", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapPaymentDates", path, "", res.getError());
				}
				return success("ReturnSwapPaymentDates", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapPaymentDates", path, "");
			})
			.collect(toList());
	}

}
