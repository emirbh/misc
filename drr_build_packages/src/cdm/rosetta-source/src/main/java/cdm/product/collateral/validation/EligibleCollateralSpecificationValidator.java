package cdm.product.collateral.validation;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Party;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.EligibleCollateralSpecification;
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

public class EligibleCollateralSpecificationValidator implements Validator<EligibleCollateralSpecification> {

	private List<ComparisonResult> getComparisonResults(EligibleCollateralSpecification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : o.getParty().size(), 0, 2), 
				checkCardinality("counterparty", (List<? extends Counterparty>) o.getCounterparty() == null ? 0 : o.getCounterparty().size(), 0, 2), 
				checkCardinality("criteria", (List<? extends EligibleCollateralCriteria>) o.getCriteria() == null ? 0 : o.getCriteria().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibleCollateralSpecification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EligibleCollateralSpecification", ValidationResult.ValidationType.CARDINALITY, "EligibleCollateralSpecification", path, "", res.getError());
				}
				return success("EligibleCollateralSpecification", ValidationResult.ValidationType.CARDINALITY, "EligibleCollateralSpecification", path, "");
			})
			.collect(toList());
	}

}
