package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CustodianTerms;
import cdm.legaldocumentation.csa.EligibilityToHoldCollateral;
import cdm.legaldocumentation.csa.HoldingPostedCollateralEnum;
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

public class EligibilityToHoldCollateralValidator implements Validator<EligibilityToHoldCollateral> {

	private List<ComparisonResult> getComparisonResults(EligibilityToHoldCollateral o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyTerms", (List<HoldingPostedCollateralEnum>) o.getPartyTerms() == null ? 0 : o.getPartyTerms().size(), 1, 0), 
				checkCardinality("custodianTerms", (CustodianTerms) o.getCustodianTerms() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibilityToHoldCollateral o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EligibilityToHoldCollateral", ValidationResult.ValidationType.CARDINALITY, "EligibilityToHoldCollateral", path, "", res.getError());
				}
				return success("EligibilityToHoldCollateral", ValidationResult.ValidationType.CARDINALITY, "EligibilityToHoldCollateral", path, "");
			})
			.collect(toList());
	}

}
