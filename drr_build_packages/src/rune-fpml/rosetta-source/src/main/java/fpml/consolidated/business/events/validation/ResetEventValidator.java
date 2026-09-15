package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ResetCalculationDetails;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.RequiredIdentifierDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResetEventValidator implements Validator<ResetEvent> {

	private List<ComparisonResult> getComparisonResults(ResetEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeReference", (PartyTradeIdentifiers) o.getTradeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (RequiredIdentifierDate) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("resetValue", (IdentifiedRate) o.getResetValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDetails", (ResetCalculationDetails) o.getCalculationDetails() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetEvent", ValidationResult.ValidationType.CARDINALITY, "ResetEvent", path, "", res.getError());
				}
				return success("ResetEvent", ValidationResult.ValidationType.CARDINALITY, "ResetEvent", path, "");
			})
			.collect(toList());
	}

}
