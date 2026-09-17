package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.CreditSupportDocument;
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

public class CreditSupportDocumentValidator implements Validator<CreditSupportDocument> {

	private List<ComparisonResult> getComparisonResults(CreditSupportDocument o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditSupportDocumentElection", (List<? extends CreditSupportDocumentElection>) o.getCreditSupportDocumentElection() == null ? 0 : o.getCreditSupportDocumentElection().size(), 2, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportDocument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportDocument", ValidationResult.ValidationType.CARDINALITY, "CreditSupportDocument", path, "", res.getError());
				}
				return success("CreditSupportDocument", ValidationResult.ValidationType.CARDINALITY, "CreditSupportDocument", path, "");
			})
			.collect(toList());
	}

}
