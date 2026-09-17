package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.FacilityType;
import fpml.consolidated.asset.Lien;
import fpml.consolidated.asset.Loan;
import fpml.consolidated.asset.UnderlyingAssetTranche;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanValidator implements Validator<Loan> {

	private List<ComparisonResult> getComparisonResults(Loan o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentId", (List<? extends InstrumentId>) o.getInstrumentId() == null ? 0 : o.getInstrumentId().size(), 1, 0), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeId", (ExchangeId) o.getExchangeId() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearanceSystem", (ClearanceSystem) o.getClearanceSystem() != null ? 1 : 0, 0, 1), 
				checkCardinality("definition", (ProductReference) o.getDefinition() != null ? 1 : 0, 0, 1), 
				checkCardinality("lien", (Lien) o.getLien() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityType", (FacilityType) o.getFacilityType() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturity", (ZonedDateTime) o.getMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("creditAgreementDate", (ZonedDateTime) o.getCreditAgreementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (UnderlyingAssetTranche) o.getTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Loan o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Loan", ValidationResult.ValidationType.CARDINALITY, "Loan", path, "", res.getError());
				}
				return success("Loan", ValidationResult.ValidationType.CARDINALITY, "Loan", path, "");
			})
			.collect(toList());
	}

}
