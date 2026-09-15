package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.ApplicableRegulations;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApplicableRegulationsTypeFormatValidator implements Validator<ApplicableRegulations> {

	private List<ComparisonResult> getComparisonResults(ApplicableRegulations o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableRegulations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableRegulations", ValidationResult.ValidationType.TYPE_FORMAT, "ApplicableRegulations", path, "", res.getError());
				}
				return success("ApplicableRegulations", ValidationResult.ValidationType.TYPE_FORMAT, "ApplicableRegulations", path, "");
			})
			.collect(toList());
	}

}
