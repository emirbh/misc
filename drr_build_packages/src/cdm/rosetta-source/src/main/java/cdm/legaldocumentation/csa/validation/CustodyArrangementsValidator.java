package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CollateralAccessBreach;
import cdm.legaldocumentation.csa.CollateralManagementAgreement;
import cdm.legaldocumentation.csa.ControlAgreement;
import cdm.legaldocumentation.csa.Custodian;
import cdm.legaldocumentation.csa.CustodianEvent;
import cdm.legaldocumentation.csa.CustodianRisk;
import cdm.legaldocumentation.csa.CustodyArrangements;
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

public class CustodyArrangementsValidator implements Validator<CustodyArrangements> {

	private List<ComparisonResult> getComparisonResults(CustodyArrangements o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isCreditSupportDocument", (Boolean) o.getIsCreditSupportDocument() != null ? 1 : 0, 0, 1), 
				checkCardinality("hasControlAgreementLanguage", (Boolean) o.getHasControlAgreementLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherProvisions", (String) o.getOtherProvisions() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralAccessBreach", (CollateralAccessBreach) o.getCollateralAccessBreach() != null ? 1 : 0, 0, 1), 
				checkCardinality("custodianRisk", (CustodianRisk) o.getCustodianRisk() != null ? 1 : 0, 0, 1), 
				checkCardinality("controlAgreement", (ControlAgreement) o.getControlAgreement() != null ? 1 : 0, 0, 1), 
				checkCardinality("custodianEvent", (CustodianEvent) o.getCustodianEvent() != null ? 1 : 0, 1, 1), 
				checkCardinality("custodian", (Custodian) o.getCustodian() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralManagementAgreement", (CollateralManagementAgreement) o.getCollateralManagementAgreement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustodyArrangements o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustodyArrangements", ValidationResult.ValidationType.CARDINALITY, "CustodyArrangements", path, "", res.getError());
				}
				return success("CustodyArrangements", ValidationResult.ValidationType.CARDINALITY, "CustodyArrangements", path, "");
			})
			.collect(toList());
	}

}
