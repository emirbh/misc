package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetPool;
import fpml.consolidated.asset.CouponType;
import fpml.consolidated.asset.CreditQuality;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.asset.Mortgage;
import fpml.consolidated.asset.MortgageSector;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditRating;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MortgageOnlyExistsValidator implements ValidatorWithArg<Mortgage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Mortgage> ValidationResult<Mortgage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("instrumentType", ExistenceChecker.isSet((List<? extends InstrumentType>) o.getInstrumentType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("insurer", ExistenceChecker.isSet((LegalEntity) o.getInsurer()))
				.put("insurerReference", ExistenceChecker.isSet((LegalEntityReference) o.getInsurerReference()))
				.put("issuerName", ExistenceChecker.isSet((String) o.getIssuerName()))
				.put("issuerPartyReference", ExistenceChecker.isSet((PartyReference) o.getIssuerPartyReference()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("creditQuality", ExistenceChecker.isSet((List<? extends CreditQuality>) o.getCreditQuality()))
				.put("creditRating", ExistenceChecker.isSet((List<? extends CreditRating>) o.getCreditRating()))
				.put("couponType", ExistenceChecker.isSet((CouponType) o.getCouponType()))
				.put("couponRate", ExistenceChecker.isSet((BigDecimal) o.getCouponRate()))
				.put("maturity", ExistenceChecker.isSet((ZonedDateTime) o.getMaturity()))
				.put("paymentFrequency", ExistenceChecker.isSet((Frequency) o.getPaymentFrequency()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("originalPrincipalAmount", ExistenceChecker.isSet((BigDecimal) o.getOriginalPrincipalAmount()))
				.put("pool", ExistenceChecker.isSet((AssetPool) o.getPool()))
				.put("sector", ExistenceChecker.isSet((MortgageSector) o.getSector()))
				.put("tranche", ExistenceChecker.isSet((String) o.getTranche()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Mortgage", ValidationResult.ValidationType.ONLY_EXISTS, "Mortgage", path, "");
		}
		return failure("Mortgage", ValidationResult.ValidationType.ONLY_EXISTS, "Mortgage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
