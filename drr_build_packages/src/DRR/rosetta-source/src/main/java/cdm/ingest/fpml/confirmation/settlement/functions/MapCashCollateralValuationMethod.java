package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.observable.asset.CashCollateralValuationMethod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.consolidated.fpmlenum.CsaTypeEnum;
import fpml.consolidated.fpmlenum.PartyDeterminationEnum;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.Currency;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashCollateralValuationMethod.MapCashCollateralValuationMethodDefault.class)
public abstract class MapCashCollateralValuationMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlApplicableCsa 
	* @param fpmlCashCollateralCurrency 
	* @param fpmlCashCollateralInterestRate 
	* @param fpmlAgreedDiscountRate 
	* @param fpmlProtectedPartyList 
	* @param fpmlPrescribedDocumentationAdjustment 
	* @return cashCollateralValuationMethod 
	*/
	public CashCollateralValuationMethod evaluate(CsaTypeEnum fpmlApplicableCsa, Currency fpmlCashCollateralCurrency, BenchmarkRate fpmlCashCollateralInterestRate, BenchmarkRate fpmlAgreedDiscountRate, List<? extends PartySelector> fpmlProtectedPartyList, Boolean fpmlPrescribedDocumentationAdjustment) {
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder cashCollateralValuationMethodBuilder = doEvaluate(fpmlApplicableCsa, fpmlCashCollateralCurrency, fpmlCashCollateralInterestRate, fpmlAgreedDiscountRate, fpmlProtectedPartyList, fpmlPrescribedDocumentationAdjustment);
		
		final CashCollateralValuationMethod cashCollateralValuationMethod;
		if (cashCollateralValuationMethodBuilder == null) {
			cashCollateralValuationMethod = null;
		} else {
			cashCollateralValuationMethod = cashCollateralValuationMethodBuilder.build();
			objectValidator.validate(CashCollateralValuationMethod.class, cashCollateralValuationMethod);
		}
		
		return cashCollateralValuationMethod;
	}

	protected abstract CashCollateralValuationMethod.CashCollateralValuationMethodBuilder doEvaluate(CsaTypeEnum fpmlApplicableCsa, Currency fpmlCashCollateralCurrency, BenchmarkRate fpmlCashCollateralInterestRate, BenchmarkRate fpmlAgreedDiscountRate, List<? extends PartySelector> fpmlProtectedPartyList, Boolean fpmlPrescribedDocumentationAdjustment);

	public static class MapCashCollateralValuationMethodDefault extends MapCashCollateralValuationMethod {
		@Override
		protected CashCollateralValuationMethod.CashCollateralValuationMethodBuilder doEvaluate(CsaTypeEnum fpmlApplicableCsa, Currency fpmlCashCollateralCurrency, BenchmarkRate fpmlCashCollateralInterestRate, BenchmarkRate fpmlAgreedDiscountRate, List<? extends PartySelector> fpmlProtectedPartyList, Boolean fpmlPrescribedDocumentationAdjustment) {
			if (fpmlProtectedPartyList == null) {
				fpmlProtectedPartyList = Collections.emptyList();
			}
			CashCollateralValuationMethod.CashCollateralValuationMethodBuilder cashCollateralValuationMethod = CashCollateralValuationMethod.builder();
			return assignOutput(cashCollateralValuationMethod, fpmlApplicableCsa, fpmlCashCollateralCurrency, fpmlCashCollateralInterestRate, fpmlAgreedDiscountRate, fpmlProtectedPartyList, fpmlPrescribedDocumentationAdjustment);
		}
		
		protected CashCollateralValuationMethod.CashCollateralValuationMethodBuilder assignOutput(CashCollateralValuationMethod.CashCollateralValuationMethodBuilder cashCollateralValuationMethod, CsaTypeEnum fpmlApplicableCsa, Currency fpmlCashCollateralCurrency, BenchmarkRate fpmlCashCollateralInterestRate, BenchmarkRate fpmlAgreedDiscountRate, List<? extends PartySelector> fpmlProtectedPartyList, Boolean fpmlPrescribedDocumentationAdjustment) {
			final FieldWithMetaString fieldWithMetaString = mapCurrency.evaluate(fpmlCashCollateralCurrency);
			cashCollateralValuationMethod = toBuilder(CashCollateralValuationMethod.builder()
				.setApplicableCsa(MapperS.of(fpmlApplicableCsa).checkedMap("to-enum", e -> cdm.observable.asset.CsaTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setCashCollateralCurrency((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))
				.setCashCollateralInterestRate(mapStringWithScheme.evaluate(MapperS.of(fpmlCashCollateralInterestRate).<String>map("getValue", benchmarkRate -> benchmarkRate.getValue()).get(), MapperS.of(fpmlCashCollateralInterestRate).<String>map("getBenchmarkRateScheme", benchmarkRate -> benchmarkRate.getBenchmarkRateScheme()).get()))
				.setAgreedDiscountRate(mapStringWithScheme.evaluate(MapperS.of(fpmlAgreedDiscountRate).<String>map("getValue", benchmarkRate -> benchmarkRate.getValue()).get(), MapperS.of(fpmlAgreedDiscountRate).<String>map("getBenchmarkRateScheme", benchmarkRate -> benchmarkRate.getBenchmarkRateScheme()).get()))
				.setProtectedParty(MapperC.<PartySelector>of(fpmlProtectedPartyList)
					.mapItem(item -> item.<PartyDeterminationEnum>map("getPartyDetermination", partySelector -> partySelector.getPartyDetermination()).checkedMap("to-enum", e -> cdm.observable.asset.PartyDeterminationEnum.valueOf(e.name()), IllegalArgumentException.class)).getMulti())
				.setPrescribedDocumentationAdjustment(fpmlPrescribedDocumentationAdjustment)
				.build());
			
			return Optional.ofNullable(cashCollateralValuationMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
