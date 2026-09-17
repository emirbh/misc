package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.SettlementDate;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class SettlementDateTypeFormatValidator implements Validator<SettlementDate> {

	private List<ComparisonResult> getComparisonResults(SettlementDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("cashSettlementBusinessDays", o.getCashSettlementBusinessDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementDate", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementDate", path, "", res.getError());
				}
				return success("SettlementDate", ValidationResult.ValidationType.TYPE_FORMAT, "SettlementDate", path, "");
			})
			.collect(toList());
	}

}
