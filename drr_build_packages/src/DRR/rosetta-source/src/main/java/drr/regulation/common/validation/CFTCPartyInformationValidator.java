package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CFTCEntityClassificationEnum;
import drr.regulation.common.CFTCFederalEntityClassificationEnum;
import drr.regulation.common.CFTCFinancialEntityClassificationEnum;
import drr.regulation.common.CFTCPartyInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CFTCPartyInformationValidator implements Validator<CFTCPartyInformation> {

	private List<ComparisonResult> getComparisonResults(CFTCPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("organizationType", (CFTCEntityClassificationEnum) o.getOrganizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("federalEntity", (CFTCFederalEntityClassificationEnum) o.getFederalEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("financialEntity", (CFTCFinancialEntityClassificationEnum) o.getFinancialEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalCommodityContractIndicator", (Boolean) o.getPhysicalCommodityContractIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("isUSPerson", (Boolean) o.getIsUSPerson() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonReportedTradePortfolio", (Boolean) o.getNonReportedTradePortfolio() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CFTCPartyInformation", ValidationResult.ValidationType.CARDINALITY, "CFTCPartyInformation", path, "", res.getError());
				}
				return success("CFTCPartyInformation", ValidationResult.ValidationType.CARDINALITY, "CFTCPartyInformation", path, "");
			})
			.collect(toList());
	}

}
