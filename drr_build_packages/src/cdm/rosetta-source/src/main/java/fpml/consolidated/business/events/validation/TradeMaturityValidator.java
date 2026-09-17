package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeMaturity;
import fpml.consolidated.doc.PartyTradeIdentifier;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeMaturityValidator implements Validator<TradeMaturity> {

	private List<ComparisonResult> getComparisonResults(TradeMaturity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getTradeIdentifier() == null ? 0 : o.getTradeIdentifier().size(), 1, 0), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeMaturity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeMaturity", ValidationResult.ValidationType.CARDINALITY, "TradeMaturity", path, "", res.getError());
				}
				return success("TradeMaturity", ValidationResult.ValidationType.CARDINALITY, "TradeMaturity", path, "");
			})
			.collect(toList());
	}

}
