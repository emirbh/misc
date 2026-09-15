package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetPool;
import fpml.consolidated.asset.CouponType;
import fpml.consolidated.asset.Mortgage;
import fpml.consolidated.asset.MortgageSector;
import fpml.consolidated.shared.ClearanceSystem;
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

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MortgageValidator implements Validator<Mortgage> {

	private List<ComparisonResult> getComparisonResults(Mortgage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("insurer", (LegalEntity) o.getInsurer() != null ? 1 : 0, 0, 1), 
				checkCardinality("insurerReference", (LegalEntityReference) o.getInsurerReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuerName", (String) o.getIssuerName() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuerPartyReference", (PartyReference) o.getIssuerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponType", (CouponType) o.getCouponType() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponRate", (BigDecimal) o.getCouponRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturity", (ZonedDateTime) o.getMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentFrequency", (Frequency) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalPrincipalAmount", (BigDecimal) o.getOriginalPrincipalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("pool", (AssetPool) o.getPool() != null ? 1 : 0, 0, 1), 
				checkCardinality("sector", (MortgageSector) o.getSector() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (String) o.getTranche() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Mortgage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Mortgage", ValidationResult.ValidationType.CARDINALITY, "Mortgage", path, "", res.getError());
				}
				return success("Mortgage", ValidationResult.ValidationType.CARDINALITY, "Mortgage", path, "");
			})
			.collect(toList());
	}

}
