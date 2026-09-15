package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.EEPParameters;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.com.EnvironmentalProduct;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.fpmlenum.EnvironmentalAbandonmentOfSchemeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnvironmentalPhysicalLegOnlyExistsValidator implements ValidatorWithArg<EnvironmentalPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnvironmentalPhysicalLeg> ValidationResult<EnvironmentalPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commodityClassification", ExistenceChecker.isSet((List<? extends CommodityClassification>) o.getCommodityClassification()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("numberOfAllowances", ExistenceChecker.isSet((UnitQuantity) o.getNumberOfAllowances()))
				.put("environmental", ExistenceChecker.isSet((EnvironmentalProduct) o.getEnvironmental()))
				.put("abandonmentOfScheme", ExistenceChecker.isSet((EnvironmentalAbandonmentOfSchemeEnum) o.getAbandonmentOfScheme()))
				.put("deliveryDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getDeliveryDate()))
				.put("paymentDate", ExistenceChecker.isSet((DateOffset) o.getPaymentDate()))
				.put("businessCentersReference", ExistenceChecker.isSet((BusinessCentersReference) o.getBusinessCentersReference()))
				.put("businessCenters", ExistenceChecker.isSet((BusinessCenters) o.getBusinessCenters()))
				.put("failureToDeliverApplicable", ExistenceChecker.isSet((Boolean) o.getFailureToDeliverApplicable()))
				.put("eEPParameters", ExistenceChecker.isSet((EEPParameters) o.getEEPParameters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnvironmentalPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "EnvironmentalPhysicalLeg", path, "");
		}
		return failure("EnvironmentalPhysicalLeg", ValidationResult.ValidationType.ONLY_EXISTS, "EnvironmentalPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
