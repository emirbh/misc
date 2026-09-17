package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.CouponType;
import fpml.consolidated.asset.EquityAsset;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ConvertibleBondValidator implements Validator<ConvertibleBond> {

	private List<ComparisonResult> getComparisonResults(ConvertibleBond o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuerName", (String) o.getIssuerName() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuerPartyReference", (PartyReference) o.getIssuerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponType", (CouponType) o.getCouponType() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponRate", (BigDecimal) o.getCouponRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturity", (ZonedDateTime) o.getMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("parValue", (BigDecimal) o.getParValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("faceAmount", (BigDecimal) o.getFaceAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentFrequency", (Frequency) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingEquity", (EquityAsset) o.getUnderlyingEquity() != null ? 1 : 0, 0, 1), 
				checkCardinality("redemptionDate", (ZonedDateTime) o.getRedemptionDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConvertibleBond o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConvertibleBond", ValidationResult.ValidationType.CARDINALITY, "ConvertibleBond", path, "", res.getError());
				}
				return success("ConvertibleBond", ValidationResult.ValidationType.CARDINALITY, "ConvertibleBond", path, "");
			})
			.collect(toList());
	}

}
