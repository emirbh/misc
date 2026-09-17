package cdm.product.collateral.validation;

import cdm.product.collateral.DistributionAndInterestPayment;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DistributionAndInterestPaymentValidator implements Validator<DistributionAndInterestPayment> {

	private List<ComparisonResult> getComparisonResults(DistributionAndInterestPayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DistributionAndInterestPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DistributionAndInterestPayment", ValidationResult.ValidationType.CARDINALITY, "DistributionAndInterestPayment", path, "", res.getError());
				}
				return success("DistributionAndInterestPayment", ValidationResult.ValidationType.CARDINALITY, "DistributionAndInterestPayment", path, "");
			})
			.collect(toList());
	}

}
