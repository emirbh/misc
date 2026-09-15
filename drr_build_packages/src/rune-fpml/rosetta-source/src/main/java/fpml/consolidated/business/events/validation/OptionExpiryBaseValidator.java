package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExpiryBase;
import fpml.consolidated.doc.PartyTradeIdentifier;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionExpiryBaseValidator implements Validator<OptionExpiryBase> {

	private List<ComparisonResult> getComparisonResults(OptionExpiryBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getTradeIdentifier() == null ? 0 : o.getTradeIdentifier().size(), 1, 0), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("time", (LocalTime) o.getTime() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiryBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExpiryBase", ValidationResult.ValidationType.CARDINALITY, "OptionExpiryBase", path, "", res.getError());
				}
				return success("OptionExpiryBase", ValidationResult.ValidationType.CARDINALITY, "OptionExpiryBase", path, "");
			})
			.collect(toList());
	}

}
