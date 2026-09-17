package fpml.consolidated.bond.option.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.bond.option.BondOptionStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BondOptionStrikeTypeFormatValidator implements Validator<BondOptionStrike> {

	private List<ComparisonResult> getComparisonResults(BondOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BondOptionStrike", ValidationResult.ValidationType.TYPE_FORMAT, "BondOptionStrike", path, "", res.getError());
				}
				return success("BondOptionStrike", ValidationResult.ValidationType.TYPE_FORMAT, "BondOptionStrike", path, "");
			})
			.collect(toList());
	}

}
