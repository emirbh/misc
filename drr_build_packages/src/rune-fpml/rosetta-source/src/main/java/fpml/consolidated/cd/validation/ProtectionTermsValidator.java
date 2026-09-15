package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FloatingAmountEvents;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.shared.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProtectionTermsValidator implements Validator<ProtectionTerms> {

	private List<ComparisonResult> getComparisonResults(ProtectionTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAmount", (Money) o.getCalculationAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditEvents", (CreditEvents) o.getCreditEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("obligations", (Obligations) o.getObligations() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingAmountEvents", (FloatingAmountEvents) o.getFloatingAmountEvents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProtectionTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProtectionTerms", ValidationResult.ValidationType.CARDINALITY, "ProtectionTerms", path, "", res.getError());
				}
				return success("ProtectionTerms", ValidationResult.ValidationType.CARDINALITY, "ProtectionTerms", path, "");
			})
			.collect(toList());
	}

}
