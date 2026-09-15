package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.doc.VersionedTradeId;
import fpml.consolidated.shared.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeIdentifierChoiceValidator implements Validator<TradeIdentifierChoice> {

	private List<ComparisonResult> getComparisonResults(TradeIdentifierChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("versionedTradeId", (VersionedTradeId) o.getVersionedTradeId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifierChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeIdentifierChoice", ValidationResult.ValidationType.CARDINALITY, "TradeIdentifierChoice", path, "", res.getError());
				}
				return success("TradeIdentifierChoice", ValidationResult.ValidationType.CARDINALITY, "TradeIdentifierChoice", path, "");
			})
			.collect(toList());
	}

}
