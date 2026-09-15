package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.BasketName;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BasketValidator implements Validator<Basket> {

	private List<ComparisonResult> getComparisonResults(Basket o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("openUnits", (BigDecimal) o.getOpenUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketConstituent", (List<? extends BasketConstituent>) o.getBasketConstituent() == null ? 0 : o.getBasketConstituent().size(), 1, 0), 
				checkCardinality("basketDivisor", (BigDecimal) o.getBasketDivisor() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketVersion", (Integer) o.getBasketVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketName", (BasketName) o.getBasketName() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketCurrency", (Currency) o.getBasketCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Basket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Basket", ValidationResult.ValidationType.CARDINALITY, "Basket", path, "", res.getError());
				}
				return success("Basket", ValidationResult.ValidationType.CARDINALITY, "Basket", path, "");
			})
			.collect(toList());
	}

}
