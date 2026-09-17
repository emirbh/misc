package cdm.regulation.validation;

import cdm.regulation.Indx;
import cdm.regulation.Sngl;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SnglValidator implements Validator<Sngl> {

	private List<ComparisonResult> getComparisonResults(Sngl o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isin", (String) o.getIsin() != null ? 1 : 0, 1, 1), 
				checkCardinality("indx", (Indx) o.getIndx() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Sngl o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Sngl", ValidationResult.ValidationType.CARDINALITY, "Sngl", path, "", res.getError());
				}
				return success("Sngl", ValidationResult.ValidationType.CARDINALITY, "Sngl", path, "");
			})
			.collect(toList());
	}

}
