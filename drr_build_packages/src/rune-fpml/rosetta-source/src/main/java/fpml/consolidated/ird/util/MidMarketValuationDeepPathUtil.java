package fpml.consolidated.ird.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.CsaTypeEnum;
import fpml.consolidated.ird.MidMarketValuation;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class MidMarketValuationDeepPathUtil {
	public BenchmarkRate chooseAgreedDiscountRate(MidMarketValuation midMarketValuation) {
		final MapperS<MidMarketValuationMethod> indicativeQuotations = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotations", _midMarketValuation -> _midMarketValuation.getIndicativeQuotations());
		if (exists(indicativeQuotations).getOrDefault(false)) {
			return indicativeQuotations.<BenchmarkRate>map("getAgreedDiscountRate", midMarketValuationMethod -> midMarketValuationMethod.getAgreedDiscountRate()).get();
		}
		final MapperS<MidMarketValuationMethod> indicativeQuotationsAlternate = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", _midMarketValuation -> _midMarketValuation.getIndicativeQuotationsAlternate());
		if (exists(indicativeQuotationsAlternate).getOrDefault(false)) {
			return indicativeQuotationsAlternate.<BenchmarkRate>map("getAgreedDiscountRate", midMarketValuationMethod -> midMarketValuationMethod.getAgreedDiscountRate()).get();
		}
		final MapperS<MidMarketValuationMethod> calculationAgentDetermination = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getCalculationAgentDetermination", _midMarketValuation -> _midMarketValuation.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<BenchmarkRate>map("getAgreedDiscountRate", midMarketValuationMethod -> midMarketValuationMethod.getAgreedDiscountRate()).get();
		}
		return null;
	}
	
	public CsaTypeEnum chooseApplicableCsa(MidMarketValuation midMarketValuation) {
		final MapperS<MidMarketValuationMethod> indicativeQuotations = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotations", _midMarketValuation -> _midMarketValuation.getIndicativeQuotations());
		if (exists(indicativeQuotations).getOrDefault(false)) {
			return indicativeQuotations.<CsaTypeEnum>map("getApplicableCsa", midMarketValuationMethod -> midMarketValuationMethod.getApplicableCsa()).get();
		}
		final MapperS<MidMarketValuationMethod> indicativeQuotationsAlternate = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", _midMarketValuation -> _midMarketValuation.getIndicativeQuotationsAlternate());
		if (exists(indicativeQuotationsAlternate).getOrDefault(false)) {
			return indicativeQuotationsAlternate.<CsaTypeEnum>map("getApplicableCsa", midMarketValuationMethod -> midMarketValuationMethod.getApplicableCsa()).get();
		}
		final MapperS<MidMarketValuationMethod> calculationAgentDetermination = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getCalculationAgentDetermination", _midMarketValuation -> _midMarketValuation.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<CsaTypeEnum>map("getApplicableCsa", midMarketValuationMethod -> midMarketValuationMethod.getApplicableCsa()).get();
		}
		return null;
	}
	
	public BenchmarkRate chooseCashCollateralInterestRate(MidMarketValuation midMarketValuation) {
		final MapperS<MidMarketValuationMethod> indicativeQuotations = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotations", _midMarketValuation -> _midMarketValuation.getIndicativeQuotations());
		if (exists(indicativeQuotations).getOrDefault(false)) {
			return indicativeQuotations.<BenchmarkRate>map("getCashCollateralInterestRate", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralInterestRate()).get();
		}
		final MapperS<MidMarketValuationMethod> indicativeQuotationsAlternate = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", _midMarketValuation -> _midMarketValuation.getIndicativeQuotationsAlternate());
		if (exists(indicativeQuotationsAlternate).getOrDefault(false)) {
			return indicativeQuotationsAlternate.<BenchmarkRate>map("getCashCollateralInterestRate", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralInterestRate()).get();
		}
		final MapperS<MidMarketValuationMethod> calculationAgentDetermination = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getCalculationAgentDetermination", _midMarketValuation -> _midMarketValuation.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<BenchmarkRate>map("getCashCollateralInterestRate", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralInterestRate()).get();
		}
		return null;
	}
	
	public List<Currency> chooseCashSettlementCurrency(MidMarketValuation midMarketValuation) {
		final MapperS<MidMarketValuationMethod> indicativeQuotations = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotations", _midMarketValuation -> _midMarketValuation.getIndicativeQuotations());
		if (exists(indicativeQuotations).getOrDefault(false)) {
			return indicativeQuotations.<Currency>mapC("getCashSettlementCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementCurrency()).getMulti();
		}
		final MapperS<MidMarketValuationMethod> indicativeQuotationsAlternate = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", _midMarketValuation -> _midMarketValuation.getIndicativeQuotationsAlternate());
		if (exists(indicativeQuotationsAlternate).getOrDefault(false)) {
			return indicativeQuotationsAlternate.<Currency>mapC("getCashSettlementCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementCurrency()).getMulti();
		}
		final MapperS<MidMarketValuationMethod> calculationAgentDetermination = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getCalculationAgentDetermination", _midMarketValuation -> _midMarketValuation.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<Currency>mapC("getCashSettlementCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementCurrency()).getMulti();
		}
		return Collections.<Currency>emptyList();
	}
	
	public Currency chooseCashCollateralCurrency(MidMarketValuation midMarketValuation) {
		final MapperS<MidMarketValuationMethod> indicativeQuotations = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotations", _midMarketValuation -> _midMarketValuation.getIndicativeQuotations());
		if (exists(indicativeQuotations).getOrDefault(false)) {
			return indicativeQuotations.<Currency>map("getCashCollateralCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralCurrency()).get();
		}
		final MapperS<MidMarketValuationMethod> indicativeQuotationsAlternate = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", _midMarketValuation -> _midMarketValuation.getIndicativeQuotationsAlternate());
		if (exists(indicativeQuotationsAlternate).getOrDefault(false)) {
			return indicativeQuotationsAlternate.<Currency>map("getCashCollateralCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralCurrency()).get();
		}
		final MapperS<MidMarketValuationMethod> calculationAgentDetermination = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getCalculationAgentDetermination", _midMarketValuation -> _midMarketValuation.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<Currency>map("getCashCollateralCurrency", midMarketValuationMethod -> midMarketValuationMethod.getCashCollateralCurrency()).get();
		}
		return null;
	}
	
	public CashSettlementReferenceBanks chooseCashSettlementReferenceBanks(MidMarketValuation midMarketValuation) {
		final MapperS<MidMarketValuationMethod> indicativeQuotations = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotations", _midMarketValuation -> _midMarketValuation.getIndicativeQuotations());
		if (exists(indicativeQuotations).getOrDefault(false)) {
			return indicativeQuotations.<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementReferenceBanks()).get();
		}
		final MapperS<MidMarketValuationMethod> indicativeQuotationsAlternate = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getIndicativeQuotationsAlternate", _midMarketValuation -> _midMarketValuation.getIndicativeQuotationsAlternate());
		if (exists(indicativeQuotationsAlternate).getOrDefault(false)) {
			return indicativeQuotationsAlternate.<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementReferenceBanks()).get();
		}
		final MapperS<MidMarketValuationMethod> calculationAgentDetermination = MapperS.of(midMarketValuation).<MidMarketValuationMethod>map("getCalculationAgentDetermination", _midMarketValuation -> _midMarketValuation.getCalculationAgentDetermination());
		if (exists(calculationAgentDetermination).getOrDefault(false)) {
			return calculationAgentDetermination.<CashSettlementReferenceBanks>map("getCashSettlementReferenceBanks", midMarketValuationMethod -> midMarketValuationMethod.getCashSettlementReferenceBanks()).get();
		}
		return null;
	}
	
}
