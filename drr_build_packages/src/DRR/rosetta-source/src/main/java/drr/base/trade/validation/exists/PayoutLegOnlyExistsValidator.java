package drr.base.trade.validation.exists;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.PayoutLeg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PayoutLegOnlyExistsValidator implements ValidatorWithArg<PayoutLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PayoutLeg> ValidationResult<PayoutLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("creditDefaultPayout", ExistenceChecker.isSet((CreditDefaultPayout) o.getCreditDefaultPayout()))
				.put("optionPayout", ExistenceChecker.isSet((OptionPayout) o.getOptionPayout()))
				.put("settlementPayout", ExistenceChecker.isSet((SettlementPayout) o.getSettlementPayout()))
				.put("performancePayout", ExistenceChecker.isSet((PerformancePayout) o.getPerformancePayout()))
				.put("interestRatePayout", ExistenceChecker.isSet((InterestRatePayout) o.getInterestRatePayout()))
				.put("cashflow", ExistenceChecker.isSet((Cashflow) o.getCashflow()))
				.put("fixedPricePayout", ExistenceChecker.isSet((FixedPricePayout) o.getFixedPricePayout()))
				.put("commodityPayout", ExistenceChecker.isSet((CommodityPayout) o.getCommodityPayout()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PayoutLeg", ValidationResult.ValidationType.ONLY_EXISTS, "PayoutLeg", path, "");
		}
		return failure("PayoutLeg", ValidationResult.ValidationType.ONLY_EXISTS, "PayoutLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
