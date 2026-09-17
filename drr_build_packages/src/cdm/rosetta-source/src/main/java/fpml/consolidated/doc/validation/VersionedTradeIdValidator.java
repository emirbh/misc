package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.VersionedTradeId;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VersionedTradeIdValidator implements Validator<VersionedTradeId> {

	private List<ComparisonResult> getComparisonResults(VersionedTradeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("version", (Integer) o.getVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (IdentifiedDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VersionedTradeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VersionedTradeId", ValidationResult.ValidationType.CARDINALITY, "VersionedTradeId", path, "", res.getError());
				}
				return success("VersionedTradeId", ValidationResult.ValidationType.CARDINALITY, "VersionedTradeId", path, "");
			})
			.collect(toList());
	}

}
