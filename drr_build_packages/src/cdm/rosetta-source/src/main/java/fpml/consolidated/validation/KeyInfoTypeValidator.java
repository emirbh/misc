package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyInfoType;
import fpml.consolidated.KeyInfoTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class KeyInfoTypeValidator implements Validator<KeyInfoType> {

	private List<ComparisonResult> getComparisonResults(KeyInfoType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("keyInfoTypeChoice", (List<? extends KeyInfoTypeChoice>) o.getKeyInfoTypeChoice() == null ? 0 : o.getKeyInfoTypeChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfoType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyInfoType", ValidationResult.ValidationType.CARDINALITY, "KeyInfoType", path, "", res.getError());
				}
				return success("KeyInfoType", ValidationResult.ValidationType.CARDINALITY, "KeyInfoType", path, "");
			})
			.collect(toList());
	}

}
