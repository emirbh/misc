package fpml.consolidated.eqd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.MakeWholeProvisions;
import fpml.consolidated.eqd.EquityAmericanExercise;
import fpml.consolidated.eqd.EquityBermudaExercise;
import fpml.consolidated.eqd.EquityEuropeanExercise;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.eqd.PrePayment;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementPriceDefaultElection;
import fpml.consolidated.shared.SettlementPriceSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class EquityExerciseValuationSettlementValidator implements Validator<EquityExerciseValuationSettlement> {

	private List<ComparisonResult> getComparisonResults(EquityExerciseValuationSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("equityEuropeanExercise", (EquityEuropeanExercise) o.getEquityEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityAmericanExercise", (EquityAmericanExercise) o.getEquityAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityBermudaExercise", (EquityBermudaExercise) o.getEquityBermudaExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticExercise", (Boolean) o.getAutomaticExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("makeWholeProvisions", (MakeWholeProvisions) o.getMakeWholeProvisions() != null ? 1 : 0, 0, 1), 
				checkCardinality("prePayment", (PrePayment) o.getPrePayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityValuation", (EquityValuation) o.getEquityValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrRelativeDate) o.getSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPriceSource", (SettlementPriceSource) o.getSettlementPriceSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementMethodElectionDate", (AdjustableOrRelativeDate) o.getSettlementMethodElectionDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementMethodElectingPartyReference", (PartyReference) o.getSettlementMethodElectingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPriceDefaultElection", (SettlementPriceDefaultElection) o.getSettlementPriceDefaultElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityExerciseValuationSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityExerciseValuationSettlement", ValidationResult.ValidationType.CARDINALITY, "EquityExerciseValuationSettlement", path, "", res.getError());
				}
				return success("EquityExerciseValuationSettlement", ValidationResult.ValidationType.CARDINALITY, "EquityExerciseValuationSettlement", path, "");
			})
			.collect(toList());
	}

}
