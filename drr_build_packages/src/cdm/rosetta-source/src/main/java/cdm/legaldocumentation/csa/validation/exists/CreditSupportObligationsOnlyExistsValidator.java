package cdm.legaldocumentation.csa.validation.exists;

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
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditSupportObligationsOnlyExistsValidator implements ValidatorWithArg<CreditSupportObligations, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportObligations> ValidationResult<CreditSupportObligations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryAmount", ExistenceChecker.isSet((String) o.getDeliveryAmount()))
				.put("returnAmount", ExistenceChecker.isSet((String) o.getReturnAmount()))
				.put("marginApproach", ExistenceChecker.isSet((MarginApproach) o.getMarginApproach()))
				.put("otherEligibleSupport", ExistenceChecker.isSet((String) o.getOtherEligibleSupport()))
				.put("threshold", ExistenceChecker.isSet((Threshold) o.getThreshold()))
				.put("minimumTransferAmount", ExistenceChecker.isSet((MinimumTransferAmount) o.getMinimumTransferAmount()))
				.put("rounding", ExistenceChecker.isSet((CollateralRounding) o.getRounding()))
				.put("bespokeTransferTiming", ExistenceChecker.isSet((BespokeTransferTiming) o.getBespokeTransferTiming()))
				.put("creditSupportObligationsVariationMargin", ExistenceChecker.isSet((CreditSupportObligationsVariationMargin) o.getCreditSupportObligationsVariationMargin()))
				.put("legacyThreshold", ExistenceChecker.isSet((List<? extends CSAThreshold>) o.getLegacyThreshold()))
				.put("legacyMinimumTransferAmount", ExistenceChecker.isSet((List<? extends CSAMinimumTransferAmount>) o.getLegacyMinimumTransferAmount()))
				.put("legacyDeliveryAmount", ExistenceChecker.isSet((LegacyDeliveryAmount) o.getLegacyDeliveryAmount()))
				.put("legacyReturnAmount", ExistenceChecker.isSet((LegacyReturnAmount) o.getLegacyReturnAmount()))
				.put("creditSupportAmount", ExistenceChecker.isSet((CreditSupportAmount) o.getCreditSupportAmount()))
				.put("collateralTransferTiming", ExistenceChecker.isSet((CollateralTransferTiming) o.getCollateralTransferTiming()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportObligations", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportObligations", path, "");
		}
		return failure("CreditSupportObligations", ValidationResult.ValidationType.ONLY_EXISTS, "CreditSupportObligations", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
