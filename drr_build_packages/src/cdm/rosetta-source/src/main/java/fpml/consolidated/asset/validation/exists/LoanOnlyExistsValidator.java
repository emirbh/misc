package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.FacilityType;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.asset.Lien;
import fpml.consolidated.asset.Loan;
import fpml.consolidated.asset.LoanChoice;
import fpml.consolidated.asset.UnderlyingAssetTranche;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanOnlyExistsValidator implements ValidatorWithArg<Loan, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Loan> ValidationResult<Loan> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("instrumentType", ExistenceChecker.isSet((List<? extends InstrumentType>) o.getInstrumentType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("loanChoice", ExistenceChecker.isSet((List<? extends LoanChoice>) o.getLoanChoice()))
				.put("lien", ExistenceChecker.isSet((Lien) o.getLien()))
				.put("facilityType", ExistenceChecker.isSet((FacilityType) o.getFacilityType()))
				.put("maturity", ExistenceChecker.isSet((ZonedDateTime) o.getMaturity()))
				.put("creditAgreementDate", ExistenceChecker.isSet((ZonedDateTime) o.getCreditAgreementDate()))
				.put("tranche", ExistenceChecker.isSet((UnderlyingAssetTranche) o.getTranche()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Loan", ValidationResult.ValidationType.ONLY_EXISTS, "Loan", path, "");
		}
		return failure("Loan", ValidationResult.ValidationType.ONLY_EXISTS, "Loan", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
