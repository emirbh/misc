package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.BespokeTransferTiming;
import cdm.legaldocumentation.csa.CSAMinimumTransferAmount;
import cdm.legaldocumentation.csa.CSAThreshold;
import cdm.legaldocumentation.csa.CollateralRounding;
import cdm.legaldocumentation.csa.CollateralTransferTiming;
import cdm.legaldocumentation.csa.CreditSupportAmount;
import cdm.legaldocumentation.csa.CreditSupportObligations;
import cdm.legaldocumentation.csa.CreditSupportObligationsVariationMargin;
import cdm.legaldocumentation.csa.LegacyDeliveryAmount;
import cdm.legaldocumentation.csa.LegacyReturnAmount;
import cdm.legaldocumentation.csa.MarginApproach;
import cdm.legaldocumentation.csa.MinimumTransferAmount;
import cdm.legaldocumentation.csa.Threshold;
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

public class CreditSupportObligationsValidator implements Validator<CreditSupportObligations> {

	private List<ComparisonResult> getComparisonResults(CreditSupportObligations o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryAmount", (String) o.getDeliveryAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("returnAmount", (String) o.getReturnAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("marginApproach", (MarginApproach) o.getMarginApproach() != null ? 1 : 0, 0, 1), 
				checkCardinality("otherEligibleSupport", (String) o.getOtherEligibleSupport() != null ? 1 : 0, 0, 1), 
				checkCardinality("threshold", (Threshold) o.getThreshold() != null ? 1 : 0, 1, 1), 
				checkCardinality("minimumTransferAmount", (MinimumTransferAmount) o.getMinimumTransferAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("rounding", (CollateralRounding) o.getRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("bespokeTransferTiming", (BespokeTransferTiming) o.getBespokeTransferTiming() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditSupportObligationsVariationMargin", (CreditSupportObligationsVariationMargin) o.getCreditSupportObligationsVariationMargin() != null ? 1 : 0, 0, 1), 
				checkCardinality("legacyThreshold", (List<? extends CSAThreshold>) o.getLegacyThreshold() == null ? 0 : o.getLegacyThreshold().size(), 0, 2), 
				checkCardinality("legacyMinimumTransferAmount", (List<? extends CSAMinimumTransferAmount>) o.getLegacyMinimumTransferAmount() == null ? 0 : o.getLegacyMinimumTransferAmount().size(), 0, 2), 
				checkCardinality("legacyDeliveryAmount", (LegacyDeliveryAmount) o.getLegacyDeliveryAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("legacyReturnAmount", (LegacyReturnAmount) o.getLegacyReturnAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportAmount", (CreditSupportAmount) o.getCreditSupportAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("collateralTransferTiming", (CollateralTransferTiming) o.getCollateralTransferTiming() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditSupportObligations o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditSupportObligations", ValidationResult.ValidationType.CARDINALITY, "CreditSupportObligations", path, "", res.getError());
				}
				return success("CreditSupportObligations", ValidationResult.ValidationType.CARDINALITY, "CreditSupportObligations", path, "");
			})
			.collect(toList());
	}

}
