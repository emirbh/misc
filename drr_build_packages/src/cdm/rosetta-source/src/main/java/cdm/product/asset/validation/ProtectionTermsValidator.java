package cdm.product.asset.validation;

import cdm.base.staticdata.asset.credit.Obligations;
import cdm.observable.event.CreditEvents;
import cdm.product.asset.FloatingAmountEvents;
import cdm.product.asset.ProtectionTerms;
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

public class ProtectionTermsValidator implements Validator<ProtectionTerms> {

	private List<ComparisonResult> getComparisonResults(ProtectionTerms o) {
		return Lists.<ComparisonResult>newArrayList(
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
