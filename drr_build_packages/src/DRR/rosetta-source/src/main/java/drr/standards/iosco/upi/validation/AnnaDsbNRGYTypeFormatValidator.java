package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbNRGYTypeFormatValidator implements Validator<AnnaDsbNRGY> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbNRGY o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbNRGY o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbNRGY", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbNRGY", path, "", res.getError());
				}
				return success("AnnaDsbNRGY", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbNRGY", path, "");
			})
			.collect(toList());
	}

}
