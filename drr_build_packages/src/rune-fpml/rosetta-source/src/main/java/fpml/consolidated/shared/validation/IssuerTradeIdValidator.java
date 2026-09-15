package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.IssuerTradeId;
import fpml.consolidated.shared.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class IssuerTradeIdValidator implements Validator<IssuerTradeId> {

	private List<ComparisonResult> getComparisonResults(IssuerTradeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuer", (IssuerId) o.getIssuer() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerTradeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerTradeId", ValidationResult.ValidationType.CARDINALITY, "IssuerTradeId", path, "", res.getError());
				}
				return success("IssuerTradeId", ValidationResult.ValidationType.CARDINALITY, "IssuerTradeId", path, "");
			})
			.collect(toList());
	}

}
