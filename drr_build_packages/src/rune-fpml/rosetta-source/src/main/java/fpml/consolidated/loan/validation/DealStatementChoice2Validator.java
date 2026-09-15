package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealStatementChoice2;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DealStatementChoice2Validator implements Validator<DealStatementChoice2> {

	private List<ComparisonResult> getComparisonResults(DealStatementChoice2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityIdentifier", (FacilityIdentifier) o.getFacilityIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilitySummary", (FacilitySummary) o.getFacilitySummary() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatementChoice2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealStatementChoice2", ValidationResult.ValidationType.CARDINALITY, "DealStatementChoice2", path, "", res.getError());
				}
				return success("DealStatementChoice2", ValidationResult.ValidationType.CARDINALITY, "DealStatementChoice2", path, "");
			})
			.collect(toList());
	}

}
