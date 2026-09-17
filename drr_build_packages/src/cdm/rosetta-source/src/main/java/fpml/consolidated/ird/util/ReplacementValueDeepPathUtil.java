package fpml.consolidated.ird.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.ird.ReplacementValue;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class ReplacementValueDeepPathUtil {
	public PartySelector chooseProtectedParty(ReplacementValue replacementValue) {
		final MapperS<ReplacementValueFirmQuotationsMethod> firmQuotations = MapperS.of(replacementValue).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", _replacementValue -> _replacementValue.getFirmQuotations());
		if (exists(firmQuotations).getOrDefault(false)) {
			return firmQuotations.<PartySelector>map("getProtectedParty", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getProtectedParty()).get();
		}
		final MapperS<ReplacementValueCalculationAgentDeterminationMethod> calculationAgentDetermination = MapperS.of(replacementValue).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", _replacementValue -> _replacementValue.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<PartySelector>map("getProtectedParty", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getProtectedParty()).get();
		}
		return null;
	}
	
	public Currency chooseCashSettlementCurrency(ReplacementValue replacementValue) {
		final MapperS<ReplacementValueFirmQuotationsMethod> firmQuotations = MapperS.of(replacementValue).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", _replacementValue -> _replacementValue.getFirmQuotations());
		if (exists(firmQuotations).getOrDefault(false)) {
			return firmQuotations.<Currency>map("getCashSettlementCurrency", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getCashSettlementCurrency()).get();
		}
		final MapperS<ReplacementValueCalculationAgentDeterminationMethod> calculationAgentDetermination = MapperS.of(replacementValue).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", _replacementValue -> _replacementValue.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<Currency>map("getCashSettlementCurrency", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getCashSettlementCurrency()).get();
		}
		return null;
	}
	
	public Currency chooseCashCollateralCurrency(ReplacementValue replacementValue) {
		final MapperS<ReplacementValueFirmQuotationsMethod> firmQuotations = MapperS.of(replacementValue).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", _replacementValue -> _replacementValue.getFirmQuotations());
		if (exists(firmQuotations).getOrDefault(false)) {
			return firmQuotations.<Currency>map("getCashCollateralCurrency", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getCashCollateralCurrency()).get();
		}
		final MapperS<ReplacementValueCalculationAgentDeterminationMethod> calculationAgentDetermination = MapperS.of(replacementValue).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", _replacementValue -> _replacementValue.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<Currency>map("getCashCollateralCurrency", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getCashCollateralCurrency()).get();
		}
		return null;
	}
	
	public CashSettlementReferenceBanks chooseCashSettlementReferenceBanks(ReplacementValue replacementValue) {
		final MapperS<ReplacementValueFirmQuotationsMethod> firmQuotations = MapperS.of(replacementValue).<ReplacementValueFirmQuotationsMethod>map("getFirmQuotations", _replacementValue -> _replacementValue.getFirmQuotations());
		if (exists(firmQuotations).getOrDefault(false)) {
			return firmQuotations.<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", replacementValueFirmQuotationsMethod -> replacementValueFirmQuotationsMethod.getCashSettlementReferenceBanks()).get();
		}
		final MapperS<ReplacementValueCalculationAgentDeterminationMethod> calculationAgentDetermination = MapperS.of(replacementValue).<ReplacementValueCalculationAgentDeterminationMethod>map("getCalculationAgentDetermination", _replacementValue -> _replacementValue.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", replacementValueCalculationAgentDeterminationMethod -> replacementValueCalculationAgentDeterminationMethod.getCashSettlementReferenceBanks()).get();
		}
		return null;
	}
	
}
