package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.Direction2__1;
import iso20022.auth030.hkma.dtcc.Direction4Choice__1;
import iso20022.auth030.hkma.dtcc.OptionParty1Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Direction4Choice__1Validator implements Validator<Direction4Choice__1> {

	private List<ComparisonResult> getComparisonResults(Direction4Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("drctn", (Direction2__1) o.getDrctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("ctrPtySd", (OptionParty1Code) o.getCtrPtySd() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Direction4Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Direction4Choice__1", ValidationResult.ValidationType.CARDINALITY, "Direction4Choice__1", path, "", res.getError());
				}
				return success("Direction4Choice__1", ValidationResult.ValidationType.CARDINALITY, "Direction4Choice__1", path, "");
			})
			.collect(toList());
	}

}
