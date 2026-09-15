package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbEmptyValidator implements Validator<AnnaDsbEmpty> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbEmpty o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("emptyField", (String) o.getEmptyField() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbEmpty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbEmpty", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbEmpty", path, "", res.getError());
				}
				return success("AnnaDsbEmpty", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbEmpty", path, "");
			})
			.collect(toList());
	}

}
