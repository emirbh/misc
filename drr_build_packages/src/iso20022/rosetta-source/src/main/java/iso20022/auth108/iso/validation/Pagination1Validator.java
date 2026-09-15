package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.Pagination1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Pagination1Validator implements Validator<Pagination1> {

	private List<ComparisonResult> getComparisonResults(Pagination1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pgNb", (String) o.getPgNb() != null ? 1 : 0, 1, 1), 
				checkCardinality("lastPgInd", (Boolean) o.getLastPgInd() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Pagination1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Pagination1", ValidationResult.ValidationType.CARDINALITY, "Pagination1", path, "", res.getError());
				}
				return success("Pagination1", ValidationResult.ValidationType.CARDINALITY, "Pagination1", path, "");
			})
			.collect(toList());
	}

}
