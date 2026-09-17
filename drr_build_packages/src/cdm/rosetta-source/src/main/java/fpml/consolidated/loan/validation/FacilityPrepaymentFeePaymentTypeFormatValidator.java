package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityPrepaymentFeePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class FacilityPrepaymentFeePaymentTypeFormatValidator implements Validator<FacilityPrepaymentFeePayment> {

	private List<ComparisonResult> getComparisonResults(FacilityPrepaymentFeePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityPrepaymentFeePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityPrepaymentFeePayment", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityPrepaymentFeePayment", path, "", res.getError());
				}
				return success("FacilityPrepaymentFeePayment", ValidationResult.ValidationType.TYPE_FORMAT, "FacilityPrepaymentFeePayment", path, "");
			})
			.collect(toList());
	}

}
