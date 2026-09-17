package cdm.ingest.fpml.confirmation.settlement.functions;

import cdm.base.staticdata.asset.credit.SpecifiedCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriod;
import cdm.ingest.fpml.confirmation.other.functions.MapObligationCategoryEnum;
import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.PCDeliverableObligationCharac;
import cdm.product.common.settlement.PhysicalSettlementPeriod;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CashSettlementTerms;
import fpml.consolidated.cd.CreditDefaultSwapChoice;
import fpml.consolidated.cd.PhysicalSettlementTerms;
import fpml.consolidated.fpmlenum.ObligationCategoryEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCreditDefaultSwapChoiceToSettlementTerms.MapCreditDefaultSwapChoiceToSettlementTermsDefault.class)
public abstract class MapCreditDefaultSwapChoiceToSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapObligationCategoryEnum mapObligationCategoryEnum;
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlCreditDefaultSwapChoiceList 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlCreditDefaultSwapChoiceList);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList);

	protected abstract MapperS<? extends PhysicalSettlementTerms> physical(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList);

	protected abstract MapperS<? extends CashSettlementTerms> cash(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList);

	public static class MapCreditDefaultSwapChoiceToSettlementTermsDefault extends MapCreditDefaultSwapChoiceToSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList) {
			if (fpmlCreditDefaultSwapChoiceList == null) {
				fpmlCreditDefaultSwapChoiceList = Collections.emptyList();
			}
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlCreditDefaultSwapChoiceList);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList) {
			if (exists(physical(fpmlCreditDefaultSwapChoiceList)).getOrDefault(false)) {
				settlementTerms = toBuilder(SettlementTerms.builder()
					.setSettlementType(SettlementTypeEnum.PHYSICAL)
					.setSettlementCurrency(mapCurrency.evaluate(physical(fpmlCreditDefaultSwapChoiceList).<Currency>map("getSettlementCurrency", physicalSettlementTerms -> physicalSettlementTerms.getSettlementCurrency()).get()))
					.setPhysicalSettlementTerms(cdm.product.common.settlement.PhysicalSettlementTerms.builder()
						.setPhysicalSettlementPeriod(PhysicalSettlementPeriod.builder()
							.setBusinessDaysNotSpecified(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.PhysicalSettlementPeriod>map("getPhysicalSettlementPeriod", physicalSettlementTerms -> physicalSettlementTerms.getPhysicalSettlementPeriod()).<Boolean>map("getBusinessDaysNotSpecified", physicalSettlementPeriod -> physicalSettlementPeriod.getBusinessDaysNotSpecified()).get())
							.setBusinessDays(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.PhysicalSettlementPeriod>map("getPhysicalSettlementPeriod", physicalSettlementTerms -> physicalSettlementTerms.getPhysicalSettlementPeriod()).<Integer>map("getBusinessDays", physicalSettlementPeriod -> physicalSettlementPeriod.getBusinessDays()).get())
							.setMaximumBusinessDays(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.PhysicalSettlementPeriod>map("getPhysicalSettlementPeriod", physicalSettlementTerms -> physicalSettlementTerms.getPhysicalSettlementPeriod()).<Integer>map("getMaximumBusinessDays", physicalSettlementPeriod -> physicalSettlementPeriod.getMaximumBusinessDays()).get())
							.build())
						.setDeliverableObligations(DeliverableObligations.builder()
							.setAccruedInterest(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getAccruedInterest", deliverableObligations -> deliverableObligations.getAccruedInterest()).get())
							.setCategory(mapObligationCategoryEnum.evaluate(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<ObligationCategoryEnum>map("getCategory", deliverableObligations -> deliverableObligations.getCategory()).map("to-string", ObligationCategoryEnum::toDisplayString).get()))
							.setNotSubordinated(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotSubordinated", deliverableObligations -> deliverableObligations.getNotSubordinated()).get())
							.setNotSovereignLender(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotSovereignLender", deliverableObligations -> deliverableObligations.getNotSovereignLender()).get())
							.setNotDomesticLaw(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotDomesticLaw", deliverableObligations -> deliverableObligations.getNotDomesticLaw()).get())
							.setNotContingent(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotContingent", deliverableObligations -> deliverableObligations.getNotContingent()).get())
							.setNotDomesticIssuance(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotDomesticIssuance", deliverableObligations -> deliverableObligations.getNotDomesticIssuance()).get())
							.setSpecifiedCurrency(SpecifiedCurrency.builder()
								.setApplicable(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<fpml.consolidated.cd.SpecifiedCurrency>map("getSpecifiedCurrency", deliverableObligations -> deliverableObligations.getSpecifiedCurrency()).<Boolean>map("getApplicable", specifiedCurrency -> specifiedCurrency.getApplicable()).get())
								.build())
							.setAssignableLoan(PCDeliverableObligationCharac.builder()
								.setApplicable(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<fpml.consolidated.cd.PCDeliverableObligationCharac>map("getAssignableLoan", deliverableObligations -> deliverableObligations.getAssignableLoan()).<Boolean>map("getApplicable", pCDeliverableObligationCharac -> pCDeliverableObligationCharac.getApplicable()).get())
								.build())
							.setConsentRequiredLoan(PCDeliverableObligationCharac.builder()
								.setApplicable(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<fpml.consolidated.cd.PCDeliverableObligationCharac>map("getConsentRequiredLoan", deliverableObligations -> deliverableObligations.getConsentRequiredLoan()).<Boolean>map("getApplicable", pCDeliverableObligationCharac -> pCDeliverableObligationCharac.getApplicable()).get())
								.build())
							.setTransferable(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getTransferable", deliverableObligations -> deliverableObligations.getTransferable()).get())
							.setMaximumMaturity(mapPeriod.evaluate(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Period>map("getMaximumMaturity", deliverableObligations -> deliverableObligations.getMaximumMaturity()).get()))
							.setNotBearer(physical(fpmlCreditDefaultSwapChoiceList).<fpml.consolidated.cd.DeliverableObligations>map("getDeliverableObligations", physicalSettlementTerms -> physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotBearer", deliverableObligations -> deliverableObligations.getNotBearer()).get())
							.build())
						.setEscrow(physical(fpmlCreditDefaultSwapChoiceList).<Boolean>map("getEscrow", physicalSettlementTerms -> physicalSettlementTerms.getEscrow()).get())
						.setSixtyBusinessDaySettlementCap(physical(fpmlCreditDefaultSwapChoiceList).<Boolean>map("getSixtyBusinessDaySettlementCap", physicalSettlementTerms -> physicalSettlementTerms.getSixtyBusinessDaySettlementCap()).get())
						.build())
					.build());
			} else if (exists(cash(fpmlCreditDefaultSwapChoiceList)).getOrDefault(false)) {
				final cdm.product.common.settlement.CashSettlementTerms cashSettlementTerms = cdm.product.common.settlement.CashSettlementTerms.builder()
					.setRecoveryFactor(cash(fpmlCreditDefaultSwapChoiceList).<BigDecimal>map("getRecoveryFactor", _cashSettlementTerms -> _cashSettlementTerms.getRecoveryFactor()).get())
					.build();
				settlementTerms = toBuilder(SettlementTerms.builder()
					.setSettlementType(SettlementTypeEnum.CASH)
					.setSettlementCurrency(mapCurrency.evaluate(cash(fpmlCreditDefaultSwapChoiceList).<Currency>map("getSettlementCurrency", _cashSettlementTerms -> _cashSettlementTerms.getSettlementCurrency()).get()))
					.setCashSettlementTerms((cashSettlementTerms == null ? Collections.<cdm.product.common.settlement.CashSettlementTerms>emptyList() : Collections.singletonList(cashSettlementTerms)))
					.build());
			} else {
				settlementTerms = null;
			}
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PhysicalSettlementTerms> physical(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList) {
			return MapperC.<CreditDefaultSwapChoice>of(fpmlCreditDefaultSwapChoiceList)
				.first().<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", creditDefaultSwapChoice -> creditDefaultSwapChoice.getPhysicalSettlementTerms());
		}
		
		@Override
		protected MapperS<? extends CashSettlementTerms> cash(List<? extends CreditDefaultSwapChoice> fpmlCreditDefaultSwapChoiceList) {
			return MapperC.<CreditDefaultSwapChoice>of(fpmlCreditDefaultSwapChoiceList)
				.first().<CashSettlementTerms>map("getCashSettlementTerms", creditDefaultSwapChoice -> creditDefaultSwapChoice.getCashSettlementTerms());
		}
	}
}
