package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.observable.asset.ValuationPostponement;
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

public class EscrowArrangementValidator implements Validator<EscrowArrangement> {

	private List<ComparisonResult> getComparisonResults(EscrowArrangement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("escrowArrangementIsApplicable", (Boolean) o.getEscrowArrangementIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("maximumDaysOfDisruption", (ValuationPostponement) o.getMaximumDaysOfDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("bespokeEscrowArrangements", (Clause) o.getBespokeEscrowArrangements() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EscrowArrangement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EscrowArrangement", ValidationResult.ValidationType.CARDINALITY, "EscrowArrangement", path, "", res.getError());
				}
				return success("EscrowArrangement", ValidationResult.ValidationType.CARDINALITY, "EscrowArrangement", path, "");
			})
			.collect(toList());
	}

}
