package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.MoneyRef;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NotionalReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MoneyRefValidator implements Validator<MoneyRef> {

	private List<ComparisonResult> getComparisonResults(MoneyRef o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalReference", (NotionalReference) o.getNotionalReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MoneyRef o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MoneyRef", ValidationResult.ValidationType.CARDINALITY, "MoneyRef", path, "", res.getError());
				}
				return success("MoneyRef", ValidationResult.ValidationType.CARDINALITY, "MoneyRef", path, "");
			})
			.collect(toList());
	}

}
