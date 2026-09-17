package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.BespokeTransferTiming;
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

public class BespokeTransferTimingValidator implements Validator<BespokeTransferTiming> {

	private List<ComparisonResult> getComparisonResults(BespokeTransferTiming o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("bespokeTransferTimingTerms", (String) o.getBespokeTransferTimingTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BespokeTransferTiming o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BespokeTransferTiming", ValidationResult.ValidationType.CARDINALITY, "BespokeTransferTiming", path, "", res.getError());
				}
				return success("BespokeTransferTiming", ValidationResult.ValidationType.CARDINALITY, "BespokeTransferTiming", path, "");
			})
			.collect(toList());
	}

}
