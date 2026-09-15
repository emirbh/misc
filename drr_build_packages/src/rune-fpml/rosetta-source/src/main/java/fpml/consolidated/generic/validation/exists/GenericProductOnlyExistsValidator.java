package fpml.consolidated.generic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.generic.GenericCommodityDeliveryPeriod;
import fpml.consolidated.generic.GenericCommodityGrade;
import fpml.consolidated.generic.GenericExerciseStyle;
import fpml.consolidated.generic.GenericFrequency;
import fpml.consolidated.generic.GenericOptionStrike;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.generic.GenericProductFeature;
import fpml.consolidated.generic.GenericResetFrequency;
import fpml.consolidated.generic.OptionType;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CashflowNotional;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericProductOnlyExistsValidator implements ValidatorWithArg<GenericProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericProduct> ValidationResult<GenericProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("multiLeg", ExistenceChecker.isSet((Boolean) o.getMultiLeg()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("counterpartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getCounterpartyReference()))
				.put("premium", ExistenceChecker.isSet((SimplePayment) o.getPremium()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableDate2) o.getEffectiveDate()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableDate2) o.getExpirationDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableDate2) o.getTerminationDate()))
				.put("underlyer", ExistenceChecker.isSet((List<? extends TradeUnderlyer2>) o.getUnderlyer()))
				.put("notional", ExistenceChecker.isSet((List<? extends CashflowNotional>) o.getNotional()))
				.put("grade", ExistenceChecker.isSet((List<? extends GenericCommodityGrade>) o.getGrade()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends GenericCommodityDeliveryPeriod>) o.getSettlementPeriods()))
				.put("loadType", ExistenceChecker.isSet((LoadTypeEnum) o.getLoadType()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("quantityFrequency", ExistenceChecker.isSet((CommodityQuantityFrequency) o.getQuantityFrequency()))
				.put("fixedPrice", ExistenceChecker.isSet((CommodityFixedPrice) o.getFixedPrice()))
				.put("interconnectionPoint", ExistenceChecker.isSet((InterconnectionPoint) o.getInterconnectionPoint()))
				.put("optionEntitlement", ExistenceChecker.isSet((BigDecimal) o.getOptionEntitlement()))
				.put("numberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNumberOfOptions()))
				.put("optionType", ExistenceChecker.isSet((OptionType) o.getOptionType()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableDate2) o.getCommencementDate()))
				.put("exerciseStyle", ExistenceChecker.isSet((GenericExerciseStyle) o.getExerciseStyle()))
				.put("strike", ExistenceChecker.isSet((List<? extends GenericOptionStrike>) o.getStrike()))
				.put("feature", ExistenceChecker.isSet((List<? extends GenericProductFeature>) o.getFeature()))
				.put("paymentFrequency", ExistenceChecker.isSet((List<? extends GenericFrequency>) o.getPaymentFrequency()))
				.put("resetFrequency", ExistenceChecker.isSet((List<? extends GenericResetFrequency>) o.getResetFrequency()))
				.put("settlementCurrency", ExistenceChecker.isSet((List<? extends IdentifiedCurrency>) o.getSettlementCurrency()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericProduct", ValidationResult.ValidationType.ONLY_EXISTS, "GenericProduct", path, "");
		}
		return failure("GenericProduct", ValidationResult.ValidationType.ONLY_EXISTS, "GenericProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
