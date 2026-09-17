package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.CreditSupportDocumentTermsEnum;
import cdm.legaldocumentation.csa.CreditSupportDocumentElection;
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

public class CreditSupportDocumentElectionValidator implements Validator<CreditSupportDocumentElection> {

	private List<ComparisonResult> getComparisonResults(CreditSupportDocumentElection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", (Party) o.getParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportDocumentTerms", (CreditSupportDocumentTermsEnum) o.getCreditSupportDocumentTerms() != null ? 1 : 0, 1, 1), 
				checkCardinality("bespokeCreditSuppportDocument", (String) o.getBespokeCreditSuppportDocument() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportDocumentElection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportDocumentElection", ValidationResult.ValidationType.CARDINALITY, "CreditSupportDocumentElection", path, "", res.getError());
				}
				return success("CreditSupportDocumentElection", ValidationResult.ValidationType.CARDINALITY, "CreditSupportDocumentElection", path, "");
			})
			.collect(toList());
	}

}
