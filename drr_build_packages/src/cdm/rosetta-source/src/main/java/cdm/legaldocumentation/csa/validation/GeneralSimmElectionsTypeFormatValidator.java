package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.GeneralSimmElections;
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

public class GeneralSimmElectionsTypeFormatValidator implements Validator<GeneralSimmElections> {

	private List<ComparisonResult> getComparisonResults(GeneralSimmElections o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralSimmElections o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GeneralSimmElections", ValidationResult.ValidationType.TYPE_FORMAT, "GeneralSimmElections", path, "", res.getError());
				}
				return success("GeneralSimmElections", ValidationResult.ValidationType.TYPE_FORMAT, "GeneralSimmElections", path, "");
			})
			.collect(toList());
	}

}
