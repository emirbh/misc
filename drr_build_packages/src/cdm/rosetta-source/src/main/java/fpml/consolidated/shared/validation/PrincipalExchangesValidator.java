package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.PrincipalExchanges;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangesValidator implements Validator<PrincipalExchanges> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchanges o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialExchange", (Boolean) o.getInitialExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalExchange", (Boolean) o.getFinalExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("intermediateExchange", (Boolean) o.getIntermediateExchange() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchanges o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchanges", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchanges", path, "", res.getError());
				}
				return success("PrincipalExchanges", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchanges", path, "");
			})
			.collect(toList());
	}

}
