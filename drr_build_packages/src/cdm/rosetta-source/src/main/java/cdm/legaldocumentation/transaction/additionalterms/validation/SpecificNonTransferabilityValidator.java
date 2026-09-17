package cdm.legaldocumentation.transaction.additionalterms.validation;

import cdm.legaldocumentation.transaction.additionalterms.EscrowArrangement;
import cdm.legaldocumentation.transaction.additionalterms.FxSubstitutionProvisionTypeEnum;
import cdm.legaldocumentation.transaction.additionalterms.NonDeliverableSubstitute;
import cdm.legaldocumentation.transaction.additionalterms.SpecificNonTransferability;
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

public class SpecificNonTransferabilityValidator implements Validator<SpecificNonTransferability> {

	private List<ComparisonResult> getComparisonResults(SpecificNonTransferability o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("specificNonTransferabilityIsApplicable", (Boolean) o.getSpecificNonTransferabilityIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("localSubstituteProvisionType", (FxSubstitutionProvisionTypeEnum) o.getLocalSubstituteProvisionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumDaysOfDisruption", (ValuationPostponement) o.getMaximumDaysOfDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonDeliverableSubstitute", (NonDeliverableSubstitute) o.getNonDeliverableSubstitute() != null ? 1 : 0, 0, 1), 
				checkCardinality("escrowArrangement", (EscrowArrangement) o.getEscrowArrangement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificNonTransferability o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecificNonTransferability", ValidationResult.ValidationType.CARDINALITY, "SpecificNonTransferability", path, "", res.getError());
				}
				return success("SpecificNonTransferability", ValidationResult.ValidationType.CARDINALITY, "SpecificNonTransferability", path, "");
			})
			.collect(toList());
	}

}
