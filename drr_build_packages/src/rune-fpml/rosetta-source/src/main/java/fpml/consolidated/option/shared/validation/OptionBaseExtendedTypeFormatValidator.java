package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.OptionBaseExtended;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class OptionBaseExtendedTypeFormatValidator implements Validator<OptionBaseExtended> {

	private List<ComparisonResult> getComparisonResults(OptionBaseExtended o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("optionEntitlement", o.getOptionEntitlement(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("numberOfOptions", o.getNumberOfOptions(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionBaseExtended o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionBaseExtended", ValidationResult.ValidationType.TYPE_FORMAT, "OptionBaseExtended", path, "", res.getError());
				}
				return success("OptionBaseExtended", ValidationResult.ValidationType.TYPE_FORMAT, "OptionBaseExtended", path, "");
			})
			.collect(toList());
	}

}
