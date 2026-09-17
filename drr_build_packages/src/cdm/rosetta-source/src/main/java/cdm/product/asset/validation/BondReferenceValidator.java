package cdm.product.asset.validation;

import cdm.base.staticdata.asset.common.Security;
import cdm.product.asset.BondReference;
import cdm.product.asset.FixedRateSpecification;
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

public class BondReferenceValidator implements Validator<BondReference> {

	private List<ComparisonResult> getComparisonResults(BondReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("bond", (Security) o.getBond() != null ? 1 : 0, 1, 1), 
				checkCardinality("conditionPrecedentBond", (Boolean) o.getConditionPrecedentBond() != null ? 1 : 0, 1, 1), 
				checkCardinality("discrepancyClause", (Boolean) o.getDiscrepancyClause() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponRate", (FixedRateSpecification) o.getCouponRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BondReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BondReference", ValidationResult.ValidationType.CARDINALITY, "BondReference", path, "", res.getError());
				}
				return success("BondReference", ValidationResult.ValidationType.CARDINALITY, "BondReference", path, "");
			})
			.collect(toList());
	}

}
