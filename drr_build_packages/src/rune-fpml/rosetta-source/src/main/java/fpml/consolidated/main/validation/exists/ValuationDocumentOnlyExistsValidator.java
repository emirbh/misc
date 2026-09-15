package fpml.consolidated.main.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Portfolio;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.main.ValuationDocument;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import fpml.consolidated.valuation.ValuationSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationDocumentOnlyExistsValidator implements ValidatorWithArg<ValuationDocument, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationDocument> ValidationResult<ValuationDocument> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("onBehalfOf", ExistenceChecker.isSet((OnBehalfOf) o.getOnBehalfOf()))
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("trade", ExistenceChecker.isSet((List<? extends Trade>) o.getTrade()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.put("account", ExistenceChecker.isSet((List<? extends Account>) o.getAccount()))
				.put("portfolio", ExistenceChecker.isSet((List<? extends Portfolio>) o.getPortfolio()))
				.put("market", ExistenceChecker.isSet((List<? extends Market>) o.getMarket()))
				.put("valuationSet", ExistenceChecker.isSet((List<? extends ValuationSet>) o.getValuationSet()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationDocument", ValidationResult.ValidationType.ONLY_EXISTS, "ValuationDocument", path, "");
		}
		return failure("ValuationDocument", ValidationResult.ValidationType.ONLY_EXISTS, "ValuationDocument", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
