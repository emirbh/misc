package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.PledgeeRepresentativeRider;
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

public class PledgeeRepresentativeRiderTypeFormatValidator implements Validator<PledgeeRepresentativeRider> {

	private List<ComparisonResult> getComparisonResults(PledgeeRepresentativeRider o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PledgeeRepresentativeRider o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PledgeeRepresentativeRider", ValidationResult.ValidationType.TYPE_FORMAT, "PledgeeRepresentativeRider", path, "", res.getError());
				}
				return success("PledgeeRepresentativeRider", ValidationResult.ValidationType.TYPE_FORMAT, "PledgeeRepresentativeRider", path, "");
			})
			.collect(toList());
	}

}
