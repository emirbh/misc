package drr.enrichment.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.common.EnrichmentData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EnrichmentDataValidator implements Validator<EnrichmentData> {

	private List<ComparisonResult> getComparisonResults(EnrichmentData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnrichmentData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnrichmentData", ValidationResult.ValidationType.CARDINALITY, "EnrichmentData", path, "", res.getError());
				}
				return success("EnrichmentData", ValidationResult.ValidationType.CARDINALITY, "EnrichmentData", path, "");
			})
			.collect(toList());
	}

}
