package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbDerived;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbDerivedTypeFormatValidator implements Validator<AnnaDsbDerived> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbDerived o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbDerived o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbDerived", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbDerived", path, "", res.getError());
				}
				return success("AnnaDsbDerived", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbDerived", path, "");
			})
			.collect(toList());
	}

}
