package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.Representations;
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

public class RepresentationsValidator implements Validator<Representations> {

	private List<ComparisonResult> getComparisonResults(Representations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonReliance", (Boolean) o.getNonReliance() != null ? 1 : 0, 1, 1), 
				checkCardinality("agreementsRegardingHedging", (Boolean) o.getAgreementsRegardingHedging() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexDisclaimer", (Boolean) o.getIndexDisclaimer() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalAcknowledgements", (Boolean) o.getAdditionalAcknowledgements() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Representations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Representations", ValidationResult.ValidationType.CARDINALITY, "Representations", path, "", res.getError());
				}
				return success("Representations", ValidationResult.ValidationType.CARDINALITY, "Representations", path, "");
			})
			.collect(toList());
	}

}
