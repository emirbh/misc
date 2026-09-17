package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.NotDomesticCurrency;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotDomesticCurrencyValidator implements Validator<NotDomesticCurrency> {

	private List<ComparisonResult> getComparisonResults(NotDomesticCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotDomesticCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotDomesticCurrency", ValidationResult.ValidationType.CARDINALITY, "NotDomesticCurrency", path, "", res.getError());
				}
				return success("NotDomesticCurrency", ValidationResult.ValidationType.CARDINALITY, "NotDomesticCurrency", path, "");
			})
			.collect(toList());
	}

}
