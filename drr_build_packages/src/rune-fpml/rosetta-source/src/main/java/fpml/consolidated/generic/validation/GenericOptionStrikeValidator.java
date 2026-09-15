package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericOptionStrike;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericOptionStrikeValidator implements Validator<GenericOptionStrike> {

	private List<ComparisonResult> getComparisonResults(GenericOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strikePrice", (BigDecimal) o.getStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePercentage", (BigDecimal) o.getStrikePercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeDeterminationDate", (AdjustableOrRelativeDate) o.getStrikeDeterminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("units", (String) o.getUnits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericOptionStrike", ValidationResult.ValidationType.CARDINALITY, "GenericOptionStrike", path, "", res.getError());
				}
				return success("GenericOptionStrike", ValidationResult.ValidationType.CARDINALITY, "GenericOptionStrike", path, "");
			})
			.collect(toList());
	}

}
