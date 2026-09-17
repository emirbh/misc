package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.CollateralArrangement;
import fpml.consolidated.repo.CollateralType;
import fpml.consolidated.repo.TriParty;
import fpml.consolidated.sec.lending.SecLendCollateralProvisions;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxRate;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendCollateralProvisionsValidator implements Validator<SecLendCollateralProvisions> {

	private List<ComparisonResult> getComparisonResults(SecLendCollateralProvisions o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralType", (CollateralType) o.getCollateralType() != null ? 1 : 0, 0, 1), 
				checkCardinality("triParty", (TriParty) o.getTriParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("marginRatio", (BigDecimal) o.getMarginRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("haircut", (BigDecimal) o.getHaircut() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralCurrency", (Currency) o.getCollateralCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxRate", (FxRate) o.getFxRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralArrangement", (CollateralArrangement) o.getCollateralArrangement() != null ? 1 : 0, 0, 1), 
				checkCardinality("exclusiveArrangements", (Boolean) o.getExclusiveArrangements() != null ? 1 : 0, 0, 1), 
				checkCardinality("eligibleForRehypothecation", (Boolean) o.getEligibleForRehypothecation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendCollateralProvisions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendCollateralProvisions", ValidationResult.ValidationType.CARDINALITY, "SecLendCollateralProvisions", path, "", res.getError());
				}
				return success("SecLendCollateralProvisions", ValidationResult.ValidationType.CARDINALITY, "SecLendCollateralProvisions", path, "");
			})
			.collect(toList());
	}

}
