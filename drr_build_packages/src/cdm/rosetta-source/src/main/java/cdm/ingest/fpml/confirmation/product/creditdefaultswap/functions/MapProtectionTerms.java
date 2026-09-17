package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.asset.credit.NotDomesticCurrency;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapMoney;
import cdm.ingest.fpml.confirmation.other.functions.MapObligationCategoryEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapRestructuringEnum;
import cdm.observable.event.FailureToPay;
import cdm.observable.event.GracePeriodExtension;
import cdm.observable.event.Restructuring;
import cdm.product.asset.ProtectionTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.Obligations;
import fpml.consolidated.fpmlenum.ObligationCategoryEnum;
import fpml.consolidated.option.shared.CreditEventNotice;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.option.shared.RestructuringType;
import fpml.consolidated.shared.Money;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapProtectionTerms.MapProtectionTermsDefault.class)
public abstract class MapProtectionTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditEventNotice mapCreditEventNotice;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapObligationCategoryEnum mapObligationCategoryEnum;
	@Inject protected MapRestructuringEnum mapRestructuringEnum;

	/**
	* @param fpmlProtectionTerms 
	* @param cdmCounterpartyList 
	* @return protectionTerms 
	*/
	public ProtectionTerms evaluate(fpml.consolidated.cd.ProtectionTerms fpmlProtectionTerms, List<? extends Counterparty> cdmCounterpartyList) {
		ProtectionTerms.ProtectionTermsBuilder protectionTermsBuilder = doEvaluate(fpmlProtectionTerms, cdmCounterpartyList);
		
		final ProtectionTerms protectionTerms;
		if (protectionTermsBuilder == null) {
			protectionTerms = null;
		} else {
			protectionTerms = protectionTermsBuilder.build();
			objectValidator.validate(ProtectionTerms.class, protectionTerms);
		}
		
		return protectionTerms;
	}

	protected abstract ProtectionTerms.ProtectionTermsBuilder doEvaluate(fpml.consolidated.cd.ProtectionTerms fpmlProtectionTerms, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends CreditEvents> creditEvents(fpml.consolidated.cd.ProtectionTerms fpmlProtectionTerms, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapProtectionTermsDefault extends MapProtectionTerms {
		@Override
		protected ProtectionTerms.ProtectionTermsBuilder doEvaluate(fpml.consolidated.cd.ProtectionTerms fpmlProtectionTerms, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			ProtectionTerms.ProtectionTermsBuilder protectionTerms = ProtectionTerms.builder();
			return assignOutput(protectionTerms, fpmlProtectionTerms, cdmCounterpartyList);
		}
		
		protected ProtectionTerms.ProtectionTermsBuilder assignOutput(ProtectionTerms.ProtectionTermsBuilder protectionTerms, fpml.consolidated.cd.ProtectionTerms fpmlProtectionTerms, List<? extends Counterparty> cdmCounterpartyList) {
			protectionTerms = toBuilder(ProtectionTerms.builder()
				.setCreditEvents(cdm.observable.event.CreditEvents.builder()
					.setBankruptcy(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<Boolean>map("getBankruptcy", _creditEvents -> _creditEvents.getBankruptcy()).get())
					.setFailureToPay(FailureToPay.builder()
						.setApplicable(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<Boolean>map("getApplicable", failureToPay -> failureToPay.getApplicable()).get())
						.setGracePeriodExtension(GracePeriodExtension.builder()
							.setApplicable(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<fpml.consolidated.option.shared.GracePeriodExtension>map("getGracePeriodExtension", failureToPay -> failureToPay.getGracePeriodExtension()).<Boolean>map("getApplicable", gracePeriodExtension -> gracePeriodExtension.getApplicable()).get())
							.build())
						.setPaymentRequirement(mapMoney.evaluate(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<Money>map("getPaymentRequirement", failureToPay -> failureToPay.getPaymentRequirement()).get()))
						.build())
					.setObligationAcceleration(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<Boolean>map("getObligationAcceleration", _creditEvents -> _creditEvents.getObligationAcceleration()).get())
					.setRepudiationMoratorium(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<Boolean>map("getRepudiationMoratorium", _creditEvents -> _creditEvents.getRepudiationMoratorium()).get())
					.setRestructuring(Restructuring.builder()
						.setApplicable(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getApplicable", restructuring -> restructuring.getApplicable()).get())
						.setRestructuringTypeValue(mapRestructuringEnum.evaluate(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<RestructuringType>map("getRestructuringType", restructuring -> restructuring.getRestructuringType()).<String>map("getValue", restructuringType -> restructuringType.getValue()).get()))
						.setMultipleHolderObligation(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getMultipleHolderObligation", restructuring -> restructuring.getMultipleHolderObligation()).get())
						.setMultipleCreditEventNotices(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<fpml.consolidated.option.shared.Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getMultipleCreditEventNotices", restructuring -> restructuring.getMultipleCreditEventNotices()).get())
						.build())
					.setDefaultRequirement(mapMoney.evaluate(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<Money>map("getDefaultRequirement", _creditEvents -> _creditEvents.getDefaultRequirement()).get()))
					.setCreditEventNotice(mapCreditEventNotice.evaluate(creditEvents(fpmlProtectionTerms, cdmCounterpartyList).<CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).get(), cdmCounterpartyList))
					.build())
				.setObligations(MapperS.of(fpmlProtectionTerms).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations())
					.mapSingleToItem(item -> MapperS.of(cdm.base.staticdata.asset.credit.Obligations.builder()
						.setCategory(mapObligationCategoryEnum.evaluate(item.<ObligationCategoryEnum>map("getCategory", obligations -> obligations.getCategory()).map("to-string", ObligationCategoryEnum::toDisplayString).get()))
						.setNotSubordinated(item.<Boolean>map("getNotSubordinated", obligations -> obligations.getNotSubordinated()).get())
						.setNotSovereignLender(item.<Boolean>map("getNotSovereignLender", obligations -> obligations.getNotSovereignLender()).get())
						.setNotDomesticCurrency(NotDomesticCurrency.builder()
							.setApplicable(item.<fpml.consolidated.cd.NotDomesticCurrency>map("getNotDomesticCurrency", obligations -> obligations.getNotDomesticCurrency()).<Boolean>map("getApplicable", notDomesticCurrency -> notDomesticCurrency.getApplicable()).get())
							.build())
						.setNotDomesticLaw(item.<Boolean>map("getNotDomesticLaw", obligations -> obligations.getNotDomesticLaw()).get())
						.setNotDomesticIssuance(item.<Boolean>map("getNotDomesticIssuance", obligations -> obligations.getNotDomesticIssuance()).get())
						.build())).get())
				.build());
			
			return Optional.ofNullable(protectionTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CreditEvents> creditEvents(fpml.consolidated.cd.ProtectionTerms fpmlProtectionTerms, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlProtectionTerms).<CreditEvents>map("getCreditEvents", protectionTerms -> protectionTerms.getCreditEvents());
		}
	}
}
