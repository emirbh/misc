package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.PCDeliverableObligationCharac;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PCDeliverableObligationCharacValidator implements Validator<PCDeliverableObligationCharac> {

	private List<ComparisonResult> getComparisonResults(PCDeliverableObligationCharac o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("partialCashSettlement", (Boolean) o.getPartialCashSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PCDeliverableObligationCharac o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PCDeliverableObligationCharac", ValidationResult.ValidationType.CARDINALITY, "PCDeliverableObligationCharac", path, "", res.getError());
				}
				return success("PCDeliverableObligationCharac", ValidationResult.ValidationType.CARDINALITY, "PCDeliverableObligationCharac", path, "");
			})
			.collect(toList());
	}

}
