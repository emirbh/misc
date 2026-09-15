package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.CompressionActivity;
import fpml.consolidated.business.events.CompressionType;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CompressionActivityValidator implements Validator<CompressionActivity> {

	private List<ComparisonResult> getComparisonResults(CompressionActivity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("compressionType", (CompressionType) o.getCompressionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("replacementTradeIdentifier", (TradeIdentifier) o.getReplacementTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("replacementTradeId", (TradeId) o.getReplacementTradeId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionActivity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompressionActivity", ValidationResult.ValidationType.CARDINALITY, "CompressionActivity", path, "", res.getError());
				}
				return success("CompressionActivity", ValidationResult.ValidationType.CARDINALITY, "CompressionActivity", path, "");
			})
			.collect(toList());
	}

}
