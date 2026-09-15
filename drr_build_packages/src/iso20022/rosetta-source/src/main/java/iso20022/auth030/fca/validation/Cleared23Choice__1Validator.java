package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.Cleared23Choice__1;
import iso20022.auth030.fca.ClearingExceptionOrExemption3Choice__1;
import iso20022.auth030.fca.ClearingPartyAndTime21Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Cleared23Choice__1Validator implements Validator<Cleared23Choice__1> {

	private List<ComparisonResult> getComparisonResults(Cleared23Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("clrd", (ClearingPartyAndTime21Choice__1) o.getClrd() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonClrd", (ClearingExceptionOrExemption3Choice__1) o.getNonClrd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Cleared23Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Cleared23Choice__1", ValidationResult.ValidationType.CARDINALITY, "Cleared23Choice__1", path, "", res.getError());
				}
				return success("Cleared23Choice__1", ValidationResult.ValidationType.CARDINALITY, "Cleared23Choice__1", path, "");
			})
			.collect(toList());
	}

}
