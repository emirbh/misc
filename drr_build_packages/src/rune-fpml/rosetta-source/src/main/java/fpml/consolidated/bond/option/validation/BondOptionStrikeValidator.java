package fpml.consolidated.bond.option.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.bond.option.BondOptionStrike;
import fpml.consolidated.bond.option.ReferenceSwapCurve;
import fpml.consolidated.option.shared.OptionStrike;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BondOptionStrikeValidator implements Validator<BondOptionStrike> {

	private List<ComparisonResult> getComparisonResults(BondOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceSwapCurve", (ReferenceSwapCurve) o.getReferenceSwapCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("price", (OptionStrike) o.getPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BondOptionStrike", ValidationResult.ValidationType.CARDINALITY, "BondOptionStrike", path, "", res.getError());
				}
				return success("BondOptionStrike", ValidationResult.ValidationType.CARDINALITY, "BondOptionStrike", path, "");
			})
			.collect(toList());
	}

}
