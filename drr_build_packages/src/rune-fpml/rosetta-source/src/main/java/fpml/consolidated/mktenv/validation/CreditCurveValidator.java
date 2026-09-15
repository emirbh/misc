package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.DeliverableObligations;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.mktenv.CreditCurve;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditCurveValidator implements Validator<CreditCurve> {

	private List<ComparisonResult> getComparisonResults(CreditCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEntityReference", (LegalEntityReference) o.getCreditEntityReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditEvents", (CreditEvents) o.getCreditEvents() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("secured", (Boolean) o.getSecured() != null ? 1 : 0, 0, 1), 
				checkCardinality("obligationCurrency", (Currency) o.getObligationCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("obligations", (Obligations) o.getObligations() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliverableObligations", (DeliverableObligations) o.getDeliverableObligations() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditCurve", ValidationResult.ValidationType.CARDINALITY, "CreditCurve", path, "", res.getError());
				}
				return success("CreditCurve", ValidationResult.ValidationType.CARDINALITY, "CreditCurve", path, "");
			})
			.collect(toList());
	}

}
