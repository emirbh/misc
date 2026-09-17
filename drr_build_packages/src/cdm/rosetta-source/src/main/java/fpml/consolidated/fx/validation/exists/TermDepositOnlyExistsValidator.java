package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.FxTenorPeriodEnum;
import fpml.consolidated.fx.TermDeposit;
import fpml.consolidated.fx.TermDepositFeatures;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TermDepositOnlyExistsValidator implements ValidatorWithArg<TermDeposit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TermDeposit> ValidationResult<TermDeposit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("maturityDate", ExistenceChecker.isSet((ZonedDateTime) o.getMaturityDate()))
				.put("tenorName", ExistenceChecker.isSet((FxTenorPeriodEnum) o.getTenorName()))
				.put("tenorPeriod", ExistenceChecker.isSet((Period) o.getTenorPeriod()))
				.put("principal", ExistenceChecker.isSet((PositiveMoney) o.getPrincipal()))
				.put("fixedRate", ExistenceChecker.isSet((BigDecimal) o.getFixedRate()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("features", ExistenceChecker.isSet((TermDepositFeatures) o.getFeatures()))
				.put("interest", ExistenceChecker.isSet((Money) o.getInterest()))
				.put("payment", ExistenceChecker.isSet((List<? extends Payment>) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TermDeposit", ValidationResult.ValidationType.ONLY_EXISTS, "TermDeposit", path, "");
		}
		return failure("TermDeposit", ValidationResult.ValidationType.ONLY_EXISTS, "TermDeposit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
