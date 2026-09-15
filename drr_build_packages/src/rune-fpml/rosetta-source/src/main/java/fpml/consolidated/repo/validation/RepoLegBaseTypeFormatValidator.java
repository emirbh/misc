package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.RepoLegBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RepoLegBaseTypeFormatValidator implements Validator<RepoLegBase> {

	private List<ComparisonResult> getComparisonResults(RepoLegBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoLegBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoLegBase", ValidationResult.ValidationType.TYPE_FORMAT, "RepoLegBase", path, "", res.getError());
				}
				return success("RepoLegBase", ValidationResult.ValidationType.TYPE_FORMAT, "RepoLegBase", path, "");
			})
			.collect(toList());
	}

}
