package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Lien;
import fpml.consolidated.cd.NotDomesticCurrency;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.cd.SpecifiedCurrency;
import fpml.consolidated.fpmlenum.ObligationCategoryEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObligationsValidator implements Validator<Obligations> {

	private List<ComparisonResult> getComparisonResults(Obligations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("category", (ObligationCategoryEnum) o.getCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("notSubordinated", (Boolean) o.getNotSubordinated() != null ? 1 : 0, 0, 1), 
				checkCardinality("specifiedCurrency", (SpecifiedCurrency) o.getSpecifiedCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("notSovereignLender", (Boolean) o.getNotSovereignLender() != null ? 1 : 0, 0, 1), 
				checkCardinality("notDomesticCurrency", (NotDomesticCurrency) o.getNotDomesticCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("notDomesticLaw", (Boolean) o.getNotDomesticLaw() != null ? 1 : 0, 0, 1), 
				checkCardinality("listed", (Boolean) o.getListed() != null ? 1 : 0, 0, 1), 
				checkCardinality("notDomesticIssuance", (Boolean) o.getNotDomesticIssuance() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullFaithAndCreditObLiability", (Boolean) o.getFullFaithAndCreditObLiability() != null ? 1 : 0, 0, 1), 
				checkCardinality("generalFundObligationLiability", (Boolean) o.getGeneralFundObligationLiability() != null ? 1 : 0, 0, 1), 
				checkCardinality("revenueObligationLiability", (Boolean) o.getRevenueObligationLiability() != null ? 1 : 0, 0, 1), 
				checkCardinality("notContingent", (Boolean) o.getNotContingent() != null ? 1 : 0, 0, 1), 
				checkCardinality("excluded", (String) o.getExcluded() != null ? 1 : 0, 0, 1), 
				checkCardinality("othReferenceEntityObligations", (String) o.getOthReferenceEntityObligations() != null ? 1 : 0, 0, 1), 
				checkCardinality("designatedPriority", (Lien) o.getDesignatedPriority() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementOnly", (Boolean) o.getCashSettlementOnly() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryOfCommitments", (Boolean) o.getDeliveryOfCommitments() != null ? 1 : 0, 0, 1), 
				checkCardinality("continuity", (Boolean) o.getContinuity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Obligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Obligations", ValidationResult.ValidationType.CARDINALITY, "Obligations", path, "", res.getError());
				}
				return success("Obligations", ValidationResult.ValidationType.CARDINALITY, "Obligations", path, "");
			})
			.collect(toList());
	}

}
