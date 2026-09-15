package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.NonFinancialSector;
import drr.regulation.common.NonFinancialSectorEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonFinancialSectorValidator implements Validator<NonFinancialSector> {

	private List<ComparisonResult> getComparisonResults(NonFinancialSector o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ordinal", (Integer) o.getOrdinal() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonFinancialSectorIndicator", (NonFinancialSectorEnum) o.getNonFinancialSectorIndicator() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonFinancialSector o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonFinancialSector", ValidationResult.ValidationType.CARDINALITY, "NonFinancialSector", path, "", res.getError());
				}
				return success("NonFinancialSector", ValidationResult.ValidationType.CARDINALITY, "NonFinancialSector", path, "");
			})
			.collect(toList());
	}

}
