package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Warrant;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class WarrantTypeFormatValidator implements Validator<Warrant> {

	private List<ComparisonResult> getComparisonResults(Warrant o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 1, empty(), empty()), 
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkString("contractReference", o.getContractReference(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Warrant o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Warrant", ValidationResult.ValidationType.TYPE_FORMAT, "Warrant", path, "", res.getError());
				}
				return success("Warrant", ValidationResult.ValidationType.TYPE_FORMAT, "Warrant", path, "");
			})
			.collect(toList());
	}

}
