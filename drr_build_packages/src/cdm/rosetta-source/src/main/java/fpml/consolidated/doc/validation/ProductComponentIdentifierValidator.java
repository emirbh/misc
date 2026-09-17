package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ProductComponentIdentifier;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.ProductReference;
import fpml.consolidated.shared.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProductComponentIdentifierValidator implements Validator<ProductComponentIdentifier> {

	private List<ComparisonResult> getComparisonResults(ProductComponentIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("premiumProductReference", (ProductReference) o.getPremiumProductReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuer", (IssuerId) o.getIssuer() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductComponentIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductComponentIdentifier", ValidationResult.ValidationType.CARDINALITY, "ProductComponentIdentifier", path, "", res.getError());
				}
				return success("ProductComponentIdentifier", ValidationResult.ValidationType.CARDINALITY, "ProductComponentIdentifier", path, "");
			})
			.collect(toList());
	}

}
