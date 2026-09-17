package cdm.product.common.settlement.validation;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.PhysicalSettlementPeriod;
import cdm.product.common.settlement.PhysicalSettlementTerms;
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

public class PhysicalSettlementTermsValidator implements Validator<PhysicalSettlementTerms> {

	private List<ComparisonResult> getComparisonResults(PhysicalSettlementTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("clearedPhysicalSettlement", (Boolean) o.getClearedPhysicalSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("predeterminedClearingOrganizationParty", (AncillaryRoleEnum) o.getPredeterminedClearingOrganizationParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlementPeriod", (PhysicalSettlementPeriod) o.getPhysicalSettlementPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliverableObligations", (DeliverableObligations) o.getDeliverableObligations() != null ? 1 : 0, 0, 1), 
				checkCardinality("escrow", (Boolean) o.getEscrow() != null ? 1 : 0, 0, 1), 
				checkCardinality("sixtyBusinessDaySettlementCap", (Boolean) o.getSixtyBusinessDaySettlementCap() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PhysicalSettlementTerms", ValidationResult.ValidationType.CARDINALITY, "PhysicalSettlementTerms", path, "", res.getError());
				}
				return success("PhysicalSettlementTerms", ValidationResult.ValidationType.CARDINALITY, "PhysicalSettlementTerms", path, "");
			})
			.collect(toList());
	}

}
