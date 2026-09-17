package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.PostedCreditSupportItem;
import cdm.observable.asset.Money;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PostedCreditSupportItemValidator implements Validator<PostedCreditSupportItem> {

	private List<ComparisonResult> getComparisonResults(PostedCreditSupportItem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashOrSecurityValue", (Money) o.getCashOrSecurityValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("haircutPercentage", (BigDecimal) o.getHaircutPercentage() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxHaircutPercentage", (BigDecimal) o.getFxHaircutPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalHaircutPercentage", (BigDecimal) o.getAdditionalHaircutPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("disputedCashOrSecurityValue", (Money) o.getDisputedCashOrSecurityValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PostedCreditSupportItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PostedCreditSupportItem", ValidationResult.ValidationType.CARDINALITY, "PostedCreditSupportItem", path, "", res.getError());
				}
				return success("PostedCreditSupportItem", ValidationResult.ValidationType.CARDINALITY, "PostedCreditSupportItem", path, "");
			})
			.collect(toList());
	}

}
