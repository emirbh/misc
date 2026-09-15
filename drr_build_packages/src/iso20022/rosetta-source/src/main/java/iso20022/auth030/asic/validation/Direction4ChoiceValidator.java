package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.Direction2;
import iso20022.auth030.asic.Direction4Choice;
import iso20022.auth030.asic.OptionParty1Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Direction4ChoiceValidator implements Validator<Direction4Choice> {

	private List<ComparisonResult> getComparisonResults(Direction4Choice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("drctn", (Direction2) o.getDrctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("ctrPtySd", (OptionParty1Code) o.getCtrPtySd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Direction4Choice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Direction4Choice", ValidationResult.ValidationType.CARDINALITY, "Direction4Choice", path, "", res.getError());
				}
				return success("Direction4Choice", ValidationResult.ValidationType.CARDINALITY, "Direction4Choice", path, "");
			})
			.collect(toList());
	}

}
