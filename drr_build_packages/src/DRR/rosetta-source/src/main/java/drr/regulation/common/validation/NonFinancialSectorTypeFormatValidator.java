package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.NonFinancialSector;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class NonFinancialSectorTypeFormatValidator implements Validator<NonFinancialSector> {

	private List<ComparisonResult> getComparisonResults(NonFinancialSector o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("ordinal", o.getOrdinal(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonFinancialSector o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonFinancialSector", ValidationResult.ValidationType.TYPE_FORMAT, "NonFinancialSector", path, "", res.getError());
				}
				return success("NonFinancialSector", ValidationResult.ValidationType.TYPE_FORMAT, "NonFinancialSector", path, "");
			})
			.collect(toList());
	}

}
