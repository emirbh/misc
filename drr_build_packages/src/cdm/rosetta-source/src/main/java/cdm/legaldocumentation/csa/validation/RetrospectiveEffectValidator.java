package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.RetrospectiveEffect;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RetrospectiveEffectValidator implements Validator<RetrospectiveEffect> {

	private List<ComparisonResult> getComparisonResults(RetrospectiveEffect o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardisedException", (ExceptionEnum) o.getStandardisedException() != null ? 1 : 0, 0, 1), 
				checkCardinality("asSpecified", (String) o.getAsSpecified() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RetrospectiveEffect o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RetrospectiveEffect", ValidationResult.ValidationType.CARDINALITY, "RetrospectiveEffect", path, "", res.getError());
				}
				return success("RetrospectiveEffect", ValidationResult.ValidationType.CARDINALITY, "RetrospectiveEffect", path, "");
			})
			.collect(toList());
	}

}
