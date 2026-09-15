package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.CreditOptionStrike;
import fpml.consolidated.cd.FixedRateReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditOptionStrikeValidator implements Validator<CreditOptionStrike> {

	private List<ComparisonResult> getComparisonResults(CreditOptionStrike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spread", (BigDecimal) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeReference", (FixedRateReference) o.getStrikeReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditOptionStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditOptionStrike", ValidationResult.ValidationType.CARDINALITY, "CreditOptionStrike", path, "", res.getError());
				}
				return success("CreditOptionStrike", ValidationResult.ValidationType.CARDINALITY, "CreditOptionStrike", path, "");
			})
			.collect(toList());
	}

}
