package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.ird.CalculationPeriodDates;
import fpml.consolidated.ird.Cashflows;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.ResetDates;
import fpml.consolidated.ird.SettlementProvision;
import fpml.consolidated.ird.StubCalculationPeriodAmount;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PrincipalExchanges;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestRateStreamOnlyExistsValidator implements ValidatorWithArg<InterestRateStream, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestRateStream> ValidationResult<InterestRateStream> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("calculationPeriodDates", ExistenceChecker.isSet((CalculationPeriodDates) o.getCalculationPeriodDates()))
				.put("paymentDates", ExistenceChecker.isSet((PaymentDates) o.getPaymentDates()))
				.put("resetDates", ExistenceChecker.isSet((ResetDates) o.getResetDates()))
				.put("calculationPeriodAmount", ExistenceChecker.isSet((CalculationPeriodAmount) o.getCalculationPeriodAmount()))
				.put("stubCalculationPeriodAmount", ExistenceChecker.isSet((StubCalculationPeriodAmount) o.getStubCalculationPeriodAmount()))
				.put("principalExchanges", ExistenceChecker.isSet((PrincipalExchanges) o.getPrincipalExchanges()))
				.put("cashflows", ExistenceChecker.isSet((Cashflows) o.getCashflows()))
				.put("settlementProvision", ExistenceChecker.isSet((SettlementProvision) o.getSettlementProvision()))
				.put("formula", ExistenceChecker.isSet((Formula) o.getFormula()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestRateStream", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRateStream", path, "");
		}
		return failure("InterestRateStream", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRateStream", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
