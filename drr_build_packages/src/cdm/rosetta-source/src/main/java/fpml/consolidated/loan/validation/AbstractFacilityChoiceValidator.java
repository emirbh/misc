package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractFacilityChoice;
import fpml.consolidated.loan.FixedRateOption;
import fpml.consolidated.loan.LcOption;
import fpml.consolidated.loan.LegacyFloatingRateOption;
import fpml.consolidated.loan.LoanFloatingRateOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractFacilityChoiceValidator implements Validator<AbstractFacilityChoice> {

	private List<ComparisonResult> getComparisonResults(AbstractFacilityChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRateOption", (FixedRateOption) o.getFixedRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateOption", (LoanFloatingRateOption) o.getFloatingRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyFloatingRateOption", (LegacyFloatingRateOption) o.getLegacyFloatingRateOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcOption", (LcOption) o.getLcOption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractFacilityChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractFacilityChoice", ValidationResult.ValidationType.CARDINALITY, "AbstractFacilityChoice", path, "", res.getError());
				}
				return success("AbstractFacilityChoice", ValidationResult.ValidationType.CARDINALITY, "AbstractFacilityChoice", path, "");
			})
			.collect(toList());
	}

}
