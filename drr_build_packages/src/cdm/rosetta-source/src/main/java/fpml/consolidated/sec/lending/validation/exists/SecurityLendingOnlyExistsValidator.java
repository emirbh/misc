package fpml.consolidated.sec.lending.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.SecLendCallingPartyEnum;
import fpml.consolidated.fpmlenum.SecurityLendingDurationEnum;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.PartyNoticePeriod;
import fpml.consolidated.repo.SecurityValuation;
import fpml.consolidated.sec.lending.SecLendCollateralProvisions;
import fpml.consolidated.sec.lending.SecLendFeeCalculation;
import fpml.consolidated.sec.lending.SecLendInitiation;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.sec.lending.SecLendTermination;
import fpml.consolidated.sec.lending.SecurityLending;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SecurityLendingOnlyExistsValidator implements ValidatorWithArg<SecurityLending, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SecurityLending> ValidationResult<SecurityLending> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("lenderPartyReference", ExistenceChecker.isSet((PartyReference) o.getLenderPartyReference()))
				.put("lenderAccountReference", ExistenceChecker.isSet((AccountReference) o.getLenderAccountReference()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBorrowerPartyReference()))
				.put("borrowerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBorrowerAccountReference()))
				.put("principal", ExistenceChecker.isSet((SecurityValuation) o.getPrincipal()))
				.put("initiation", ExistenceChecker.isSet((SecLendInitiation) o.getInitiation()))
				.put("termination", ExistenceChecker.isSet((SecLendTermination) o.getTermination()))
				.put("duration", ExistenceChecker.isSet((SecurityLendingDurationEnum) o.getDuration()))
				.put("extensionStyle", ExistenceChecker.isSet((ExtensionStyleEnum) o.getExtensionStyle()))
				.put("extensionPeriod", ExistenceChecker.isSet((AdjustableOffset) o.getExtensionPeriod()))
				.put("callingParty", ExistenceChecker.isSet((SecLendCallingPartyEnum) o.getCallingParty()))
				.put("callDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCallDate()))
				.put("noticePeriod", ExistenceChecker.isSet((AdjustableOffset) o.getNoticePeriod()))
				.put("partyNoticePeriod", ExistenceChecker.isSet((List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod()))
				.put("fee", ExistenceChecker.isSet((SecLendFeeCalculation) o.getFee()))
				.put("rebate", ExistenceChecker.isSet((SecLendRebateCalculation) o.getRebate()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("dividendRate", ExistenceChecker.isSet((BigDecimal) o.getDividendRate()))
				.put("minimumBillingAmount", ExistenceChecker.isSet((PositiveMoney) o.getMinimumBillingAmount()))
				.put("rebatePaymentFrequency", ExistenceChecker.isSet((Frequency) o.getRebatePaymentFrequency()))
				.put("collateralProvisions", ExistenceChecker.isSet((SecLendCollateralProvisions) o.getCollateralProvisions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityLending", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityLending", path, "");
		}
		return failure("SecurityLending", ValidationResult.ValidationType.ONLY_EXISTS, "SecurityLending", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
