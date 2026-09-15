package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ASICPartyInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ASICPartyInformationValidator implements Validator<ASICPartyInformation> {

	private List<ComparisonResult> getComparisonResults(ASICPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonReportedTradePortfolio", (Boolean) o.getNonReportedTradePortfolio() != null ? 1 : 0, 0, 1), 
				checkCardinality("smallScaleBuySideIndicator", (Boolean) o.getSmallScaleBuySideIndicator() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ASICPartyInformation", ValidationResult.ValidationType.CARDINALITY, "ASICPartyInformation", path, "", res.getError());
				}
				return success("ASICPartyInformation", ValidationResult.ValidationType.CARDINALITY, "ASICPartyInformation", path, "");
			})
			.collect(toList());
	}

}
