package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.PhysicalSettlementPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PhysicalSettlementPeriodValidator implements Validator<PhysicalSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(PhysicalSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessDaysNotSpecified", (Boolean) o.getBusinessDaysNotSpecified() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessDays", (Integer) o.getBusinessDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumBusinessDays", (Integer) o.getMaximumBusinessDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSettlementPeriod", ValidationResult.ValidationType.CARDINALITY, "PhysicalSettlementPeriod", path, "", res.getError());
				}
				return success("PhysicalSettlementPeriod", ValidationResult.ValidationType.CARDINALITY, "PhysicalSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
