package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.ReferenceBank;
import fpml.consolidated.shared.ReferenceBankId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceBankValidator implements Validator<ReferenceBank> {

	private List<ComparisonResult> getComparisonResults(ReferenceBank o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceBankId", (ReferenceBankId) o.getReferenceBankId() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceBankName", (String) o.getReferenceBankName() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceBank o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceBank", ValidationResult.ValidationType.CARDINALITY, "ReferenceBank", path, "", res.getError());
				}
				return success("ReferenceBank", ValidationResult.ValidationType.CARDINALITY, "ReferenceBank", path, "");
			})
			.collect(toList());
	}

}
