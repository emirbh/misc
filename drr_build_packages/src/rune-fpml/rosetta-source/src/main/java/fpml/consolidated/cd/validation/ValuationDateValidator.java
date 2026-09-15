package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.MultipleValuationDates;
import fpml.consolidated.cd.SingleValuationDate;
import fpml.consolidated.cd.ValuationDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationDateValidator implements Validator<ValuationDate> {

	private List<ComparisonResult> getComparisonResults(ValuationDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("singleValuationDate", (SingleValuationDate) o.getSingleValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("multipleValuationDates", (MultipleValuationDates) o.getMultipleValuationDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationDate", ValidationResult.ValidationType.CARDINALITY, "ValuationDate", path, "", res.getError());
				}
				return success("ValuationDate", ValidationResult.ValidationType.CARDINALITY, "ValuationDate", path, "");
			})
			.collect(toList());
	}

}
