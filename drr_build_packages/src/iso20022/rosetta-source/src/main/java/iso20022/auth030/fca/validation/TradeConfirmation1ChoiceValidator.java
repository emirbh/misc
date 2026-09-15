package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.TradeConfirmation1Choice;
import iso20022.auth030.fca.TradeConfirmation2;
import iso20022.auth030.fca.TradeNonConfirmation1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeConfirmation1ChoiceValidator implements Validator<TradeConfirmation1Choice> {

	private List<ComparisonResult> getComparisonResults(TradeConfirmation1Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("confd", (TradeConfirmation2) o.getConfd() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonConfd", (TradeNonConfirmation1) o.getNonConfd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeConfirmation1Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeConfirmation1Choice", ValidationResult.ValidationType.CARDINALITY, "TradeConfirmation1Choice", path, "", res.getError());
				}
				return success("TradeConfirmation1Choice", ValidationResult.ValidationType.CARDINALITY, "TradeConfirmation1Choice", path, "");
			})
			.collect(toList());
	}

}
