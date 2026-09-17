package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Allocations;
import fpml.consolidated.doc.Approvals;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeOnlyExistsValidator implements ValidatorWithArg<Trade, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Trade> ValidationResult<Trade> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("tradeHeader", ExistenceChecker.isSet((TradeHeader) o.getTradeHeader()))
				.put("product", ExistenceChecker.isSet((Product) o.getProduct()))
				.put("otherPartyPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getOtherPartyPayment()))
				.put("brokerPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getBrokerPartyReference()))
				.put("calculationAgent", ExistenceChecker.isSet((CalculationAgent) o.getCalculationAgent()))
				.put("calculationAgentBusinessCenter", ExistenceChecker.isSet((BusinessCenter) o.getCalculationAgentBusinessCenter()))
				.put("determiningParty", ExistenceChecker.isSet((List<? extends PartyReference>) o.getDeterminingParty()))
				.put("barrierDeterminationAgent", ExistenceChecker.isSet((PartyReference) o.getBarrierDeterminationAgent()))
				.put("hedgingParty", ExistenceChecker.isSet((List<? extends PartyReference>) o.getHedgingParty()))
				.put("collateral", ExistenceChecker.isSet((Collateral) o.getCollateral()))
				.put("documentation", ExistenceChecker.isSet((Documentation) o.getDocumentation()))
				.put("governingLaw", ExistenceChecker.isSet((GoverningLaw) o.getGoverningLaw()))
				.put("allocations", ExistenceChecker.isSet((List<? extends Allocations>) o.getAllocations()))
				.put("approvals", ExistenceChecker.isSet((Approvals) o.getApprovals()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Trade", ValidationResult.ValidationType.ONLY_EXISTS, "Trade", path, "");
		}
		return failure("Trade", ValidationResult.ValidationType.ONLY_EXISTS, "Trade", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
