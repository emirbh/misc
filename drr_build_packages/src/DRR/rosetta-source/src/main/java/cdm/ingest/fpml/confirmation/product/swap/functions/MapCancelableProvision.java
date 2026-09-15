package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import cdm.product.template.CancelableProvision;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCancelableProvision.MapCancelableProvisionDefault.class)
public abstract class MapCancelableProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;
	@Inject protected MapExerciseTerms mapExerciseTerms;

	/**
	* @param fpmlCancelableProvision 
	* @param cdmCounterpartyList 
	* @return cancelableProvision 
	*/
	public CancelableProvision evaluate(fpml.consolidated.ird.CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList) {
		CancelableProvision.CancelableProvisionBuilder cancelableProvisionBuilder = doEvaluate(fpmlCancelableProvision, cdmCounterpartyList);
		
		final CancelableProvision cancelableProvision;
		if (cancelableProvisionBuilder == null) {
			cancelableProvision = null;
		} else {
			cancelableProvision = cancelableProvisionBuilder.build();
			objectValidator.validate(CancelableProvision.class, cancelableProvision);
		}
		
		return cancelableProvision;
	}

	protected abstract CancelableProvision.CancelableProvisionBuilder doEvaluate(fpml.consolidated.ird.CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCancelableProvisionDefault extends MapCancelableProvision {
		@Override
		protected CancelableProvision.CancelableProvisionBuilder doEvaluate(fpml.consolidated.ird.CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			CancelableProvision.CancelableProvisionBuilder cancelableProvision = CancelableProvision.builder();
			return assignOutput(cancelableProvision, fpmlCancelableProvision, cdmCounterpartyList);
		}
		
		protected CancelableProvision.CancelableProvisionBuilder assignOutput(CancelableProvision.CancelableProvisionBuilder cancelableProvision, fpml.consolidated.ird.CancelableProvision fpmlCancelableProvision, List<? extends Counterparty> cdmCounterpartyList) {
			cancelableProvision = toBuilder(CancelableProvision.builder()
				.setBuyer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlCancelableProvision).<PartyReference>map("getBuyerPartyReference", _cancelableProvision -> _cancelableProvision.getBuyerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.setSeller(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlCancelableProvision).<PartyReference>map("getSellerPartyReference", _cancelableProvision -> _cancelableProvision.getSellerPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.setFollowUpConfirmation(MapperS.of(fpmlCancelableProvision).<Boolean>map("getFollowUpConfirmation", _cancelableProvision -> _cancelableProvision.getFollowUpConfirmation()).get())
				.setExerciseNotice(MapperS.of(fpmlCancelableProvision).<ExerciseNotice>map("getExerciseNotice", _cancelableProvision -> _cancelableProvision.getExerciseNotice())
					.mapSingleToItem(item -> MapperS.of(cdm.product.template.ExerciseNotice.builder()
						.setBusinessCenterValue(item.<BusinessCenter>map("getBusinessCenter", exerciseNotice -> exerciseNotice.getBusinessCenter()).<String>map("getValue", businessCenter -> businessCenter.getValue()).checkedMap("to-enum", BusinessCenterEnum::fromDisplayName, IllegalArgumentException.class).get())
						.setExerciseNoticeGiver(null)
						.build())).get())
				.setExerciseTerms(mapExerciseTerms.evaluate(MapperS.of(fpmlCancelableProvision).<Exercise>map("getExercise", _cancelableProvision -> _cancelableProvision.getExercise()).get(), null, null, null, null, cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(cancelableProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
