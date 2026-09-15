package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.Direction2;
import iso20022.auth030.mas.OptionParty3Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Direction2Validator implements Validator<Direction2> {

	private List<ComparisonResult> getComparisonResults(Direction2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("drctnOfTheFrstLeg", (OptionParty3Code) o.getDrctnOfTheFrstLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("drctnOfTheScndLeg", (OptionParty3Code) o.getDrctnOfTheScndLeg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Direction2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Direction2", ValidationResult.ValidationType.CARDINALITY, "Direction2", path, "", res.getError());
				}
				return success("Direction2", ValidationResult.ValidationType.CARDINALITY, "Direction2", path, "");
			})
			.collect(toList());
	}

}
