package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.SubstitutedRegimeTerms;
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

public class SubstitutedRegimeTermsTypeFormatValidator implements Validator<SubstitutedRegimeTerms> {

	private List<ComparisonResult> getComparisonResults(SubstitutedRegimeTerms o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SubstitutedRegimeTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SubstitutedRegimeTerms", ValidationResult.ValidationType.TYPE_FORMAT, "SubstitutedRegimeTerms", path, "", res.getError());
				}
				return success("SubstitutedRegimeTerms", ValidationResult.ValidationType.TYPE_FORMAT, "SubstitutedRegimeTerms", path, "");
			})
			.collect(toList());
	}

}
