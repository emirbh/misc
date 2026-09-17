package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractApplicablePartyProfileObjects;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractApplicablePartyProfileObjectsTypeFormatValidator implements Validator<AbstractApplicablePartyProfileObjects> {

	private List<ComparisonResult> getComparisonResults(AbstractApplicablePartyProfileObjects o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractApplicablePartyProfileObjects o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractApplicablePartyProfileObjects", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractApplicablePartyProfileObjects", path, "", res.getError());
				}
				return success("AbstractApplicablePartyProfileObjects", ValidationResult.ValidationType.TYPE_FORMAT, "AbstractApplicablePartyProfileObjects", path, "");
			})
			.collect(toList());
	}

}
