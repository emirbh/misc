package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.PubliclyAvailableInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PubliclyAvailableInformationValidator implements Validator<PubliclyAvailableInformation> {

	private List<ComparisonResult> getComparisonResults(PubliclyAvailableInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardPublicSources", (Boolean) o.getStandardPublicSources() != null ? 1 : 0, 0, 1), 
				checkCardinality("specifiedNumber", (Integer) o.getSpecifiedNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PubliclyAvailableInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PubliclyAvailableInformation", ValidationResult.ValidationType.CARDINALITY, "PubliclyAvailableInformation", path, "", res.getError());
				}
				return success("PubliclyAvailableInformation", ValidationResult.ValidationType.CARDINALITY, "PubliclyAvailableInformation", path, "");
			})
			.collect(toList());
	}

}
