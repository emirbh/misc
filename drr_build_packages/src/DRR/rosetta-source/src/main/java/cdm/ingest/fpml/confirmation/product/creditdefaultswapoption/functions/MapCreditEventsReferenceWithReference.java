package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.party.functions.MapMultipleCounterpartyRoleEnum;
import cdm.observable.asset.Money;
import cdm.observable.event.CreditEventNotice;
import cdm.observable.event.FailureToPay;
import cdm.observable.event.PubliclyAvailableInformation;
import cdm.observable.event.Restructuring;
import cdm.observable.event.metafields.ReferenceWithMetaCreditEvents;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.option.shared.CreditEventsReference;
import fpml.consolidated.option.shared.Knock;
import fpml.consolidated.option.shared.NotifyingParty;
import fpml.consolidated.option.shared.OptionFeature;
import fpml.consolidated.option.shared.Trigger;
import fpml.consolidated.option.shared.TriggerEvent;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditEventsReferenceWithReference.MapCreditEventsReferenceWithReferenceDefault.class)
public abstract class MapCreditEventsReferenceWithReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapMultipleCounterpartyRoleEnum mapMultipleCounterpartyRoleEnum;

	/**
	* @param fpmlCreditEventsReference 
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @return creditEventsReference 
	*/
	public ReferenceWithMetaCreditEvents evaluate(CreditEventsReference fpmlCreditEventsReference, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
		ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder creditEventsReferenceBuilder = doEvaluate(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		
		final ReferenceWithMetaCreditEvents creditEventsReference;
		if (creditEventsReferenceBuilder == null) {
			creditEventsReference = null;
		} else {
			creditEventsReference = creditEventsReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaCreditEvents.class, creditEventsReference);
		}
		
		return creditEventsReference;
	}

	protected abstract ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder doEvaluate(CreditEventsReference fpmlCreditEventsReference, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends CreditEvents> creditEvents(CreditEventsReference fpmlCreditEventsReference, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditEventsReferenceWithReferenceDefault extends MapCreditEventsReferenceWithReference {
		@Override
		protected ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder doEvaluate(CreditEventsReference fpmlCreditEventsReference, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder creditEventsReference = ReferenceWithMetaCreditEvents.builder();
			return assignOutput(creditEventsReference, fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList);
		}
		
		protected ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder assignOutput(ReferenceWithMetaCreditEvents.ReferenceWithMetaCreditEventsBuilder creditEventsReference, CreditEventsReference fpmlCreditEventsReference, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			final cdm.observable.event.CreditEvents.CreditEventsBuilder withMetaArgument = cdm.observable.event.CreditEvents.builder()
				.setFailureToPay(FailureToPay.builder()
					.setApplicable(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<Boolean>map("getApplicable", failureToPay -> failureToPay.getApplicable()).get())
					.setPaymentRequirement(Money.builder()
						.setValue(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<fpml.consolidated.shared.Money>map("getPaymentRequirement", failureToPay -> failureToPay.getPaymentRequirement()).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
						.setUnit(UnitType.builder()
							.setCurrency(mapCurrency.evaluate(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<fpml.consolidated.shared.Money>map("getPaymentRequirement", failureToPay -> failureToPay.getPaymentRequirement()).<Currency>map("getCurrency", money -> money.getCurrency()).get()))
							.build())
						.build())
					.build())
				.setRestructuring(Restructuring.builder()
					.setApplicable(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getApplicable", restructuring -> restructuring.getApplicable()).get())
					.build())
				.setDefaultRequirement(Money.builder()
					.setValue(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.shared.Money>map("getDefaultRequirement", _creditEvents -> _creditEvents.getDefaultRequirement()).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.shared.Money>map("getDefaultRequirement", _creditEvents -> _creditEvents.getDefaultRequirement()).<Currency>map("getCurrency", money -> money.getCurrency()).get()))
						.build())
					.build())
				.setCreditEventNotice(CreditEventNotice.builder()
					.setNotifyingParty(mapMultipleCounterpartyRoleEnum.evaluate(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<NotifyingParty>map("getNotifyingParty", creditEventNotice -> creditEventNotice.getNotifyingParty()).<PartyReference>map("getBuyerPartyReference", notifyingParty -> notifyingParty.getBuyerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<NotifyingParty>map("getNotifyingParty", creditEventNotice -> creditEventNotice.getNotifyingParty()).<PartyReference>map("getSellerPartyReference", notifyingParty -> notifyingParty.getSellerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
					.setPubliclyAvailableInformation(PubliclyAvailableInformation.builder()
						.setPublicSource(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<fpml.consolidated.option.shared.PubliclyAvailableInformation>map("getPubliclyAvailableInformation", creditEventNotice -> creditEventNotice.getPubliclyAvailableInformation()).<String>mapC("getPublicSource", publiclyAvailableInformation -> publiclyAvailableInformation.getPublicSource()).getMulti())
						.setSpecifiedNumber(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<fpml.consolidated.option.shared.PubliclyAvailableInformation>map("getPubliclyAvailableInformation", creditEventNotice -> creditEventNotice.getPubliclyAvailableInformation()).<Integer>map("getSpecifiedNumber", publiclyAvailableInformation -> publiclyAvailableInformation.getSpecifiedNumber()).get())
						.build())
					.build())
				.build() == null ? null : cdm.observable.event.CreditEvents.builder()
				.setFailureToPay(FailureToPay.builder()
					.setApplicable(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<Boolean>map("getApplicable", failureToPay -> failureToPay.getApplicable()).get())
					.setPaymentRequirement(Money.builder()
						.setValue(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<fpml.consolidated.shared.Money>map("getPaymentRequirement", failureToPay -> failureToPay.getPaymentRequirement()).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
						.setUnit(UnitType.builder()
							.setCurrency(mapCurrency.evaluate(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.FailureToPay>map("getFailureToPay", _creditEvents -> _creditEvents.getFailureToPay()).<fpml.consolidated.shared.Money>map("getPaymentRequirement", failureToPay -> failureToPay.getPaymentRequirement()).<Currency>map("getCurrency", money -> money.getCurrency()).get()))
							.build())
						.build())
					.build())
				.setRestructuring(Restructuring.builder()
					.setApplicable(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getApplicable", restructuring -> restructuring.getApplicable()).get())
					.build())
				.setDefaultRequirement(Money.builder()
					.setValue(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.shared.Money>map("getDefaultRequirement", _creditEvents -> _creditEvents.getDefaultRequirement()).<BigDecimal>map("getAmount", money -> money.getAmount()).get())
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.shared.Money>map("getDefaultRequirement", _creditEvents -> _creditEvents.getDefaultRequirement()).<Currency>map("getCurrency", money -> money.getCurrency()).get()))
						.build())
					.build())
				.setCreditEventNotice(CreditEventNotice.builder()
					.setNotifyingParty(mapMultipleCounterpartyRoleEnum.evaluate(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<NotifyingParty>map("getNotifyingParty", creditEventNotice -> creditEventNotice.getNotifyingParty()).<PartyReference>map("getBuyerPartyReference", notifyingParty -> notifyingParty.getBuyerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<NotifyingParty>map("getNotifyingParty", creditEventNotice -> creditEventNotice.getNotifyingParty()).<PartyReference>map("getSellerPartyReference", notifyingParty -> notifyingParty.getSellerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
					.setPubliclyAvailableInformation(PubliclyAvailableInformation.builder()
						.setPublicSource(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<fpml.consolidated.option.shared.PubliclyAvailableInformation>map("getPubliclyAvailableInformation", creditEventNotice -> creditEventNotice.getPubliclyAvailableInformation()).<String>mapC("getPublicSource", publiclyAvailableInformation -> publiclyAvailableInformation.getPublicSource()).getMulti())
						.setSpecifiedNumber(creditEvents(fpmlCreditEventsReference, fpmlCreditDefaultSwapOption, cdmCounterpartyList).<fpml.consolidated.option.shared.CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<fpml.consolidated.option.shared.PubliclyAvailableInformation>map("getPubliclyAvailableInformation", creditEventNotice -> creditEventNotice.getPubliclyAvailableInformation()).<Integer>map("getSpecifiedNumber", publiclyAvailableInformation -> publiclyAvailableInformation.getSpecifiedNumber()).get())
						.build())
					.build())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<CreditEvents>map("getCreditEvents", protectionTerms -> protectionTerms.getCreditEvents()).<String>map("getId", _creditEvents -> _creditEvents.getId())
				.first().get());
			creditEventsReference = toBuilder(ReferenceWithMetaCreditEvents.builder().setValue(withMetaArgument == null ? null : withMetaArgument.toBuilder()).setExternalReference(MapperS.of(fpmlCreditDefaultSwapOption).<OptionFeature>map("getFeature", creditDefaultSwapOption -> creditDefaultSwapOption.getFeature()).<Knock>map("getKnock", optionFeature -> optionFeature.getKnock()).<TriggerEvent>map("getKnockOut", knock -> knock.getKnockOut()).<Trigger>map("getTrigger", triggerEvent -> triggerEvent.getTrigger()).<CreditEventsReference>map("getCreditEventsReference", trigger -> trigger.getCreditEventsReference()).<String>map("getHref", _creditEventsReference -> _creditEventsReference.getHref()).get()).build());
			
			return Optional.ofNullable(creditEventsReference)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CreditEvents> creditEvents(CreditEventsReference fpmlCreditEventsReference, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<CreditEvents>map("getCreditEvents", protectionTerms -> protectionTerms.getCreditEvents())
				.first();
		}
	}
}
