package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.Composite;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CompositeValidator implements Validator<Composite> {

	private List<ComparisonResult> getComparisonResults(Composite o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDate", (RelativeDateOffset) o.getRelativeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxSpotRateSource", (FxSpotRateSource) o.getFxSpotRateSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Composite o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Composite", ValidationResult.ValidationType.CARDINALITY, "Composite", path, "", res.getError());
				}
				return success("Composite", ValidationResult.ValidationType.CARDINALITY, "Composite", path, "");
			})
			.collect(toList());
	}

}
