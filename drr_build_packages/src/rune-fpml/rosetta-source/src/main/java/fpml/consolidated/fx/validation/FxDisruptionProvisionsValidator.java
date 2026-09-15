package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxDisruptionEvents;
import fpml.consolidated.fx.FxDisruptionFallbacks;
import fpml.consolidated.fx.FxDisruptionProvisions;
import fpml.consolidated.fx.FxTemplateTerms;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxDisruptionProvisionsValidator implements Validator<FxDisruptionProvisions> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("events", (FxDisruptionEvents) o.getEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbacks", (FxDisruptionFallbacks) o.getFallbacks() != null ? 1 : 0, 0, 1), 
				checkCardinality("applicableTerms", (FxTemplateTerms) o.getApplicableTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionProvisions", ValidationResult.ValidationType.CARDINALITY, "FxDisruptionProvisions", path, "", res.getError());
				}
				return success("FxDisruptionProvisions", ValidationResult.ValidationType.CARDINALITY, "FxDisruptionProvisions", path, "");
			})
			.collect(toList());
	}

}
