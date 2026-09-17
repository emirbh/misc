package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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

public class PhysicalSettlementPeriodTypeFormatValidator implements Validator<PhysicalSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(PhysicalSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("businessDays", o.getBusinessDays(), empty(), of(0), empty(), empty()), 
				checkNumber("maximumBusinessDays", o.getMaximumBusinessDays(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSettlementPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "PhysicalSettlementPeriod", path, "", res.getError());
				}
				return success("PhysicalSettlementPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "PhysicalSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
