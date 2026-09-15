package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbSingleName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbSingleNameTypeFormatValidator implements Validator<AnnaDsbSingleName> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbSingleName o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbSingleName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbSingleName", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbSingleName", path, "", res.getError());
				}
				return success("AnnaDsbSingleName", ValidationResult.ValidationType.TYPE_FORMAT, "AnnaDsbSingleName", path, "");
			})
			.collect(toList());
	}

}
