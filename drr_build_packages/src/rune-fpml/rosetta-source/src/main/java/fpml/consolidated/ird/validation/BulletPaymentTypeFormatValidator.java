package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.BulletPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BulletPaymentTypeFormatValidator implements Validator<BulletPayment> {

	private List<ComparisonResult> getComparisonResults(BulletPayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BulletPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BulletPayment", ValidationResult.ValidationType.TYPE_FORMAT, "BulletPayment", path, "", res.getError());
				}
				return success("BulletPayment", ValidationResult.ValidationType.TYPE_FORMAT, "BulletPayment", path, "");
			})
			.collect(toList());
	}

}
