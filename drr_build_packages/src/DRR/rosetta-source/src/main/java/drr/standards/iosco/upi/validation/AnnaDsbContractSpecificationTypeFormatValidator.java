package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbContractSpecification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbContractSpecificationTypeFormatValidator implements Validator<AnnaDsbContractSpecification> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbContractSpecification o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbContractSpecification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbContractSpecification", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbContractSpecification", path, "", res.getError());
				}
				return success("AnnaDsbContractSpecification", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbContractSpecification", path, "");
			})
			.collect(toList());
	}

}
