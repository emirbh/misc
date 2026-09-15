package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.DenominatorTerm;
import fpml.consolidated.riskdef.DerivativeFormula;
import fpml.consolidated.riskdef.FormulaTerm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativeFormulaValidator implements Validator<DerivativeFormula> {

	private List<ComparisonResult> getComparisonResults(DerivativeFormula o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("term", (FormulaTerm) o.getTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("denominatorTerm", (DenominatorTerm) o.getDenominatorTerm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeFormula o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeFormula", ValidationResult.ValidationType.CARDINALITY, "DerivativeFormula", path, "", res.getError());
				}
				return success("DerivativeFormula", ValidationResult.ValidationType.CARDINALITY, "DerivativeFormula", path, "");
			})
			.collect(toList());
	}

}
