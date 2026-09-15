package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeCounterpartyRelationship1Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyRelationship1ChoiceTypeFormatValidator implements Validator<TradeCounterpartyRelationship1Choice> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyRelationship1Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("cd", o.getCd(), 1, of(4), empty()), 
				checkString("prtry", o.getPrtry(), 1, of(100), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyRelationship1Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyRelationship1Choice", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyRelationship1Choice", path, "", res.getError());
				}
				return success("TradeCounterpartyRelationship1Choice", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyRelationship1Choice", path, "");
			})
			.collect(toList());
	}

}
