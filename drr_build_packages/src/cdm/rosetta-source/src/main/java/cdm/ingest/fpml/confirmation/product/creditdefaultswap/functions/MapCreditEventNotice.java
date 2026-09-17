package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.datetime.metafields.FieldWithMetaBusinessCenterEnum;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenter;
import cdm.observable.event.CreditEventNotice;
import cdm.observable.event.PubliclyAvailableInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.NotifyingParty;
import fpml.consolidated.shared.BusinessCenter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditEventNotice.MapCreditEventNoticeDefault.class)
public abstract class MapCreditEventNotice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenter mapBusinessCenter;
	@Inject protected MapNotifyingPartyList mapNotifyingPartyList;

	/**
	* @param fpmlCreditEventNotice 
	* @param cdmCounterpartyList 
	* @return creditEventNotice 
	*/
	public CreditEventNotice evaluate(fpml.consolidated.option.shared.CreditEventNotice fpmlCreditEventNotice, List<? extends Counterparty> cdmCounterpartyList) {
		CreditEventNotice.CreditEventNoticeBuilder creditEventNoticeBuilder = doEvaluate(fpmlCreditEventNotice, cdmCounterpartyList);
		
		final CreditEventNotice creditEventNotice;
		if (creditEventNoticeBuilder == null) {
			creditEventNotice = null;
		} else {
			creditEventNotice = creditEventNoticeBuilder.build();
			objectValidator.validate(CreditEventNotice.class, creditEventNotice);
		}
		
		return creditEventNotice;
	}

	protected abstract CreditEventNotice.CreditEventNoticeBuilder doEvaluate(fpml.consolidated.option.shared.CreditEventNotice fpmlCreditEventNotice, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditEventNoticeDefault extends MapCreditEventNotice {
		@Override
		protected CreditEventNotice.CreditEventNoticeBuilder doEvaluate(fpml.consolidated.option.shared.CreditEventNotice fpmlCreditEventNotice, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			CreditEventNotice.CreditEventNoticeBuilder creditEventNotice = CreditEventNotice.builder();
			return assignOutput(creditEventNotice, fpmlCreditEventNotice, cdmCounterpartyList);
		}
		
		protected CreditEventNotice.CreditEventNoticeBuilder assignOutput(CreditEventNotice.CreditEventNoticeBuilder creditEventNotice, fpml.consolidated.option.shared.CreditEventNotice fpmlCreditEventNotice, List<? extends Counterparty> cdmCounterpartyList) {
			final FieldWithMetaBusinessCenterEnum fieldWithMetaBusinessCenterEnum = mapBusinessCenter.evaluate(MapperS.of(fpmlCreditEventNotice).<BusinessCenter>map("getBusinessCenter", _creditEventNotice -> _creditEventNotice.getBusinessCenter()).get());
			creditEventNotice = toBuilder(CreditEventNotice.builder()
				.setNotifyingParty(mapNotifyingPartyList.evaluate(MapperS.of(fpmlCreditEventNotice).<NotifyingParty>map("getNotifyingParty", _creditEventNotice -> _creditEventNotice.getNotifyingParty()).get(), cdmCounterpartyList))
				.setBusinessCenter((fieldWithMetaBusinessCenterEnum == null ? null : fieldWithMetaBusinessCenterEnum.getValue()))
				.setPubliclyAvailableInformation(PubliclyAvailableInformation.builder()
					.setStandardPublicSources(MapperS.of(fpmlCreditEventNotice).<fpml.consolidated.option.shared.PubliclyAvailableInformation>map("getPubliclyAvailableInformation", _creditEventNotice -> _creditEventNotice.getPubliclyAvailableInformation()).<Boolean>map("getStandardPublicSources", publiclyAvailableInformation -> publiclyAvailableInformation.getStandardPublicSources()).get())
					.setSpecifiedNumber(MapperS.of(fpmlCreditEventNotice).<fpml.consolidated.option.shared.PubliclyAvailableInformation>map("getPubliclyAvailableInformation", _creditEventNotice -> _creditEventNotice.getPubliclyAvailableInformation()).<Integer>map("getSpecifiedNumber", publiclyAvailableInformation -> publiclyAvailableInformation.getSpecifiedNumber()).get())
					.build())
				.build());
			
			return Optional.ofNullable(creditEventNotice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
