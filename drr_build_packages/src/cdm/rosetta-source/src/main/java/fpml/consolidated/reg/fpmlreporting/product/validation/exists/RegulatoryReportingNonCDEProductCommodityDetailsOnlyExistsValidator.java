package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.generic.GenericCommodityDeliveryPeriod;
import fpml.consolidated.generic.GenericCommodityGrade;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingNonCDEProductCommodityDetails;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingNonCDEProductCommodityDetailsOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingNonCDEProductCommodityDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingNonCDEProductCommodityDetails> ValidationResult<RegulatoryReportingNonCDEProductCommodityDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("grade", ExistenceChecker.isSet((List<? extends GenericCommodityGrade>) o.getGrade()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends GenericCommodityDeliveryPeriod>) o.getSettlementPeriods()))
				.put("loadType", ExistenceChecker.isSet((LoadTypeEnum) o.getLoadType()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("quantityFrequency", ExistenceChecker.isSet((CommodityQuantityFrequency) o.getQuantityFrequency()))
				.put("fixedPrice", ExistenceChecker.isSet((CommodityFixedPrice) o.getFixedPrice()))
				.put("interconnectionPoint", ExistenceChecker.isSet((InterconnectionPoint) o.getInterconnectionPoint()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingNonCDEProductCommodityDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingNonCDEProductCommodityDetails", path, "");
		}
		return failure("RegulatoryReportingNonCDEProductCommodityDetails", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingNonCDEProductCommodityDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
