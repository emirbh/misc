package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UnderlyerValidator implements Validator<Underlyer> {

	private List<ComparisonResult> getComparisonResults(Underlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("singleUnderlyer", (SingleUnderlyer) o.getSingleUnderlyer() != null ? 1 : 0, 0, 1), 
				checkCardinality("basket", (Basket) o.getBasket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Underlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Underlyer", ValidationResult.ValidationType.CARDINALITY, "Underlyer", path, "", res.getError());
				}
				return success("Underlyer", ValidationResult.ValidationType.CARDINALITY, "Underlyer", path, "");
			})
			.collect(toList());
	}

}
