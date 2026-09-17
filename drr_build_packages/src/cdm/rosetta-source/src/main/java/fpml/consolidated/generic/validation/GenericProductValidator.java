package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityQuantityFrequency;
import fpml.consolidated.com.InterconnectionPoint;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.generic.GenericExerciseStyle;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.generic.OptionType;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SimplePayment;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericProductValidator implements Validator<GenericProduct> {

	private List<ComparisonResult> getComparisonResults(GenericProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("multiLeg", (Boolean) o.getMultiLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterpartyReference", (List<? extends PartyReference>) o.getCounterpartyReference() == null ? 0 : o.getCounterpartyReference().size(), 0, 2), 
				checkCardinality("premium", (SimplePayment) o.getPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableDate2) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (AdjustableDate2) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableDate2) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("loadType", (LoadTypeEnum) o.getLoadType() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityFrequency", (CommodityQuantityFrequency) o.getQuantityFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPrice", (CommodityFixedPrice) o.getFixedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEntitlement", (BigDecimal) o.getOptionEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfOptions", (BigDecimal) o.getNumberOfOptions() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (OptionType) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDate", (AdjustableDate2) o.getCommencementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseStyle", (GenericExerciseStyle) o.getExerciseStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProduct", ValidationResult.ValidationType.CARDINALITY, "GenericProduct", path, "", res.getError());
				}
				return success("GenericProduct", ValidationResult.ValidationType.CARDINALITY, "GenericProduct", path, "");
			})
			.collect(toList());
	}

}
