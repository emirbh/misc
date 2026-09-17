package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ExceptionEnum;
import cdm.legaldocumentation.csa.SimmException;
import cdm.legaldocumentation.csa.SimmExceptionApplicableEnum;
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

public class SimmExceptionValidator implements Validator<SimmException> {

	private List<ComparisonResult> getComparisonResults(SimmException o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardisedException", (ExceptionEnum) o.getStandardisedException() != null ? 1 : 0, 0, 1), 
				checkCardinality("simmExceptionApplicable", (SimmExceptionApplicableEnum) o.getSimmExceptionApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("asSpecified", (String) o.getAsSpecified() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimmException o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimmException", ValidationResult.ValidationType.CARDINALITY, "SimmException", path, "", res.getError());
				}
				return success("SimmException", ValidationResult.ValidationType.CARDINALITY, "SimmException", path, "");
			})
			.collect(toList());
	}

}
