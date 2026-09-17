package cdm.regulation.validation;

import cdm.regulation.OrdrTrnsmssn;
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

public class OrdrTrnsmssnTypeFormatValidator implements Validator<OrdrTrnsmssn> {

	private List<ComparisonResult> getComparisonResults(OrdrTrnsmssn o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OrdrTrnsmssn o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OrdrTrnsmssn", ValidationResult.ValidationType.TYPE_FORMAT, "OrdrTrnsmssn", path, "", res.getError());
				}
				return success("OrdrTrnsmssn", ValidationResult.ValidationType.TYPE_FORMAT, "OrdrTrnsmssn", path, "");
			})
			.collect(toList());
	}

}
