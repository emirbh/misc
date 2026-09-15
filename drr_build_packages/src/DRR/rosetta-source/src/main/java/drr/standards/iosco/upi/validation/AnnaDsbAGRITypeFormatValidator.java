package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbAGRITypeFormatValidator implements Validator<AnnaDsbAGRI> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbAGRI o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbAGRI o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbAGRI", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbAGRI", path, "", res.getError());
				}
				return success("AnnaDsbAGRI", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbAGRI", path, "");
			})
			.collect(toList());
	}

}
