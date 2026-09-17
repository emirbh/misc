package cdm.regulation.validation;

import cdm.regulation.InvstmtDcsnPrsn;
import cdm.regulation.Prsn;
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

public class InvstmtDcsnPrsnValidator implements Validator<InvstmtDcsnPrsn> {

	private List<ComparisonResult> getComparisonResults(InvstmtDcsnPrsn o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("prsn", (Prsn) o.getPrsn() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InvstmtDcsnPrsn o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InvstmtDcsnPrsn", ValidationResult.ValidationType.CARDINALITY, "InvstmtDcsnPrsn", path, "", res.getError());
				}
				return success("InvstmtDcsnPrsn", ValidationResult.ValidationType.CARDINALITY, "InvstmtDcsnPrsn", path, "");
			})
			.collect(toList());
	}

}
