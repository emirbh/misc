package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.PartyProfileDocumentation;
import fpml.consolidated.loan.TaxForm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyProfileDocumentationValidator implements Validator<PartyProfileDocumentation> {

	private List<ComparisonResult> getComparisonResults(PartyProfileDocumentation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("taxForm", (TaxForm) o.getTaxForm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyProfileDocumentation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyProfileDocumentation", ValidationResult.ValidationType.CARDINALITY, "PartyProfileDocumentation", path, "", res.getError());
				}
				return success("PartyProfileDocumentation", ValidationResult.ValidationType.CARDINALITY, "PartyProfileDocumentation", path, "");
			})
			.collect(toList());
	}

}
