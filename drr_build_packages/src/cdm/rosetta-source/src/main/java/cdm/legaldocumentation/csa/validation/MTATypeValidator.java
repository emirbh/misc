package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.MTAFixedAmount;
import cdm.legaldocumentation.csa.MTARatingsBased;
import cdm.legaldocumentation.csa.MTAType;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MTATypeValidator implements Validator<MTAType> {

	private List<ComparisonResult> getComparisonResults(MTAType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedAmount", (MTAFixedAmount) o.getFixedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("ratingsBased", (MTARatingsBased) o.getRatingsBased() != null ? 1 : 0, 0, 1), 
				checkCardinality("other", (String) o.getOther() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MTAType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MTAType", ValidationResult.ValidationType.CARDINALITY, "MTAType", path, "", res.getError());
				}
				return success("MTAType", ValidationResult.ValidationType.CARDINALITY, "MTAType", path, "");
			})
			.collect(toList());
	}

}
