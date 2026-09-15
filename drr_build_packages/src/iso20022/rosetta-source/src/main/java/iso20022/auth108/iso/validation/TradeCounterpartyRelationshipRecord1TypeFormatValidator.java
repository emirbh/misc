package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeCounterpartyRelationshipRecord1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyRelationshipRecord1TypeFormatValidator implements Validator<TradeCounterpartyRelationshipRecord1> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyRelationshipRecord1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("desc", o.getDesc(), 1, of(1000), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyRelationshipRecord1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyRelationshipRecord1", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyRelationshipRecord1", path, "", res.getError());
				}
				return success("TradeCounterpartyRelationshipRecord1", ValidationResult.ValidationType.TYPE_FORMAT, "TradeCounterpartyRelationshipRecord1", path, "");
			})
			.collect(toList());
	}

}
