package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.GeneralInconvertibility;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
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

public class GeneralInconvertibilityValidator implements Validator<GeneralInconvertibility> {

	private List<ComparisonResult> getComparisonResults(GeneralInconvertibility o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("generalInconvertibilityIsApplicable", (Boolean) o.getGeneralInconvertibilityIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("localSubstituteProvisionType", (FxSubstitutionProvisionTypeEnum) o.getLocalSubstituteProvisionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumDaysOfDisruption", (ValuationPostponement) o.getMaximumDaysOfDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonDeliverableSubstitute", (NonDeliverableSubstitute) o.getNonDeliverableSubstitute() != null ? 1 : 0, 0, 1), 
				checkCardinality("escrowArrangement", (EscrowArrangement) o.getEscrowArrangement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GeneralInconvertibility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GeneralInconvertibility", ValidationResult.ValidationType.CARDINALITY, "GeneralInconvertibility", path, "", res.getError());
				}
				return success("GeneralInconvertibility", ValidationResult.ValidationType.CARDINALITY, "GeneralInconvertibility", path, "");
			})
			.collect(toList());
	}

}
