package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPayerReceiverToAccountPartyReference.MapPayerReceiverToAccountPartyReferenceDefault.class)
public abstract class MapPayerReceiverToAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlAccount 
	* @param fpmlPayerAccountReference 
	* @param fpmlReceiverAccountReference 
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference);

	protected abstract MapperS<String> payerPartyReference(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference);

	protected abstract MapperS<String> receiverPartyReference(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference);

	protected abstract MapperS<String> selectedPartyHref(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference);

	public static class MapPayerReceiverToAccountPartyReferenceDefault extends MapPayerReceiverToAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			partyReference = toBuilder(ReferenceWithMetaParty.builder().setValue(null).setExternalReference(selectedPartyHref(fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference).get()).build());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> payerPartyReference(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			if (areEqual(MapperS.of(fpmlPayerAccountReference).<String>map("getHref", accountReference -> accountReference.getHref()), MapperS.of(fpmlAccount).<String>map("getId", account -> account.getId()), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(fpmlPayerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref());
			}
			return MapperS.<String>ofNull();
		}
		
		@Override
		protected MapperS<String> receiverPartyReference(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			if (areEqual(MapperS.of(fpmlReceiverAccountReference).<String>map("getHref", accountReference -> accountReference.getHref()), MapperS.of(fpmlAccount).<String>map("getId", account -> account.getId()), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(fpmlReceiverPartyReference).<String>map("getHref", partyReference -> partyReference.getHref());
			}
			return MapperS.<String>ofNull();
		}
		
		@Override
		protected MapperS<String> selectedPartyHref(Account fpmlAccount, AccountReference fpmlPayerAccountReference, AccountReference fpmlReceiverAccountReference, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			if (exists(payerPartyReference(fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference)).getOrDefault(false)) {
				return payerPartyReference(fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference);
			}
			if (exists(receiverPartyReference(fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference)).getOrDefault(false)) {
				return receiverPartyReference(fpmlAccount, fpmlPayerAccountReference, fpmlReceiverAccountReference, fpmlPayerPartyReference, fpmlReceiverPartyReference);
			}
			return MapperS.<String>ofNull();
		}
	}
}
