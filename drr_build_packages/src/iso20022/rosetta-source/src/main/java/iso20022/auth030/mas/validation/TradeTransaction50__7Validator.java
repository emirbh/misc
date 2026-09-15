package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.DerivativeEvent6__1;
import iso20022.auth030.mas.TradeTransaction50__7;
import iso20022.auth030.mas.UniqueTransactionIdentifier2Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction50__7Validator implements Validator<TradeTransaction50__7> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction50__7 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", (UniqueTransactionIdentifier2Choice__1) o.getTxId() != null ? 1 : 0, 1, 1), 
				checkCardinality("derivEvt", (DerivativeEvent6__1) o.getDerivEvt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction50__7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction50__7", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__7", path, "", res.getError());
				}
				return success("TradeTransaction50__7", ValidationResult.ValidationType.CARDINALITY, "TradeTransaction50__7", path, "");
			})
			.collect(toList());
	}

}
