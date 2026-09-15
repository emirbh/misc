package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.BuyerSellerAmounts;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BuyerSellerAmountsValidator implements Validator<BuyerSellerAmounts> {

	private List<ComparisonResult> getComparisonResults(BuyerSellerAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyersAmount", (NonNegativeMoney) o.getBuyersAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellersAmount", (NonNegativeMoney) o.getSellersAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BuyerSellerAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BuyerSellerAmounts", ValidationResult.ValidationType.CARDINALITY, "BuyerSellerAmounts", path, "", res.getError());
				}
				return success("BuyerSellerAmounts", ValidationResult.ValidationType.CARDINALITY, "BuyerSellerAmounts", path, "");
			})
			.collect(toList());
	}

}
