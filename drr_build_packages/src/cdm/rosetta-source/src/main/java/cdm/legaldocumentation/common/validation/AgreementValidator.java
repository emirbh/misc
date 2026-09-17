package cdm.legaldocumentation.common.validation;

import cdm.legaldocumentation.common.Agreement;
import cdm.legaldocumentation.csa.CollateralTransferAgreementElections;
import cdm.legaldocumentation.csa.CreditSupportAgreementElections;
import cdm.legaldocumentation.csa.SecurityAgreementElections;
import cdm.legaldocumentation.master.MasterAgreementElections;
import cdm.legaldocumentation.master.MasterAgreementSchedule;
import cdm.legaldocumentation.transaction.TransactionAdditionalTerms;
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

public class AgreementValidator implements Validator<Agreement> {

	private List<ComparisonResult> getComparisonResults(Agreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditSupportAgreementElections", (CreditSupportAgreementElections) o.getCreditSupportAgreementElections() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralTransferAgreementElections", (CollateralTransferAgreementElections) o.getCollateralTransferAgreementElections() != null ? 1 : 0, 0, 1), 
				checkCardinality("securityAgreementElections", (SecurityAgreementElections) o.getSecurityAgreementElections() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementSchedule", (MasterAgreementSchedule) o.getMasterAgreementSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("transactionAdditionalTerms", (TransactionAdditionalTerms) o.getTransactionAdditionalTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementElections", (MasterAgreementElections) o.getMasterAgreementElections() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Agreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Agreement", ValidationResult.ValidationType.CARDINALITY, "Agreement", path, "", res.getError());
				}
				return success("Agreement", ValidationResult.ValidationType.CARDINALITY, "Agreement", path, "");
			})
			.collect(toList());
	}

}
