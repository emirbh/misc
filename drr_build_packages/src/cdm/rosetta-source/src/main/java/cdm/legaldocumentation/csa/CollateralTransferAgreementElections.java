package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CollateralTransferAgreementElectionsMeta;
import cdm.product.collateral.ContactElection;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The set of elections which specify a Collateral Transfer Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="CollateralTransferAgreementElections", builder=CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralTransferAgreementElections", model="cdm", builder=CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilderImpl.class, version="6.23.0")
public interface CollateralTransferAgreementElections extends RosettaModelObject {

	CollateralTransferAgreementElectionsMeta metaData = new CollateralTransferAgreementElectionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Regime Table provision , which determines the regulatory regime(s) applicable to each of the parties to the agreement.
	 */
	Regime getRegime();
	/**
	 * The determination of whether the One Way Provisions are applicable (true) or not applicable (false).
	 */
	OneWayProvisions getOneWayProvisions();
	/**
	 * The specification of the ISDA SIMM Method for all Covered Transactions with respect to all Regimes.
	 */
	GeneralSimmElections getGeneralSimmElections();
	/**
	 * The qualification of whether cross-currency swaps need to be identified in the Confirmation so that the obligations to exchange principal be disregarded for the purpose of determining the Delivery Amount or Return Amount.
	 */
	Boolean getIdentifiedCrossCurrencySwap();
	/**
	 * The specification of methodologies to compute sensitivities specific to the agreement.
	 */
	SensitivityMethodologies getSensitivityMethodologies();
	/**
	 * The reference currency for the purpose of specifying the FX Haircut relating to a posting obligation, as being either the Termination Currency or an FX Designated Currency.
	 */
	FxHaircutCurrency getFxHaircutCurrency();
	/**
	 * The security providers posting obligations.
	 */
	PostingObligations getPostingObligations();
	/**
	 * The specification of Additional regimes for purposes of determining whether a Regulatory Event has occurred.
	 */
	List<? extends SubstitutedRegime> getSubstitutedRegime();
	/**
	 * The base and eligible currency(ies) for the document as specified by the parties to the agreement.
	 */
	BaseAndEligibleCurrency getBaseAndEligibleCurrency();
	/**
	 * The Credit Support Obligations applicable to the agreement.
	 */
	CreditSupportObligations getCreditSupportObligations();
	/**
	 * The set of elections for determining Valuation and Timing terms specific to the agreement.
	 */
	CalculationAndTiming getCalculationAndTiming();
	/**
	 * The set of elections that may overwrite the default Condition Precedent provision, and the set of provisions that are deemed Access Condition.
	 */
	ConditionsPrecedent getConditionsPrecedent();
	/**
	 * The conditions under which the Security Provider can substitute posted collateral.
	 */
	Substitution getSubstitution();
	/**
	 * The election terms under which a party disputes (i) the Calculation Agents calculation of a Delivery Amount or a Return Amount, or (ii) the Value of any Transfer of Eligible Credit Support or Posted Credit Support.
	 */
	DisputeResolution getDisputeResolution();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred.
	 */
	RightsEvents getRightsEvents();
	/**
	 * The Custodian and Segregated Account details in respect of each party to the agreement.
	 */
	CustodyArrangements getCustodyArrangements();
	/**
	 * The specification Additional Representations that may be applicable to the agreement.
	 */
	AdditionalRepresentations getAdditionalRepresentations();
	/**
	 * The optional specification of address where the demands, specifications and notices will be communicated to for each of the parties to the agreement.
	 */
	ContactElection getDemandsAndNotices();
	/**
	 * The optional specification of address for transfer as specified by the respective parties to the agreement.
	 */
	ContactElection getAddressesForTransfer();
	/**
	 * The bespoke definition of Other CSA as specified by the parties to the agreement.
	 */
	String getOtherCsa();
	/**
	 * The bespoke provision that might be specified by the parties to the agreement applicable to Termination Currency.  Unless specified the definition of Termination Currency has the meaning specified in the Schedule to the ISDA Master Agreement.
	 */
	TerminationCurrencyAmendment getTerminationCurrencyAmendment();
	/**
	 * The bespoke provision that might be specified by the parties to the agreement applicable to Minimum Transfer Amount.  Unless specified the definition of Minimum Transfer Amount in any Other Regulatory CSA has the meaning specified in such Other Regulatory CSA.
	 */
	MinimumTransferAmountAmendment getMinimumTransferAmountAmendment();
	/**
	 * The bespoke provision that might be specified by the parties to the agreement applicable to Interpretations.
	 */
	String getInterpretationTerms();
	/**
	 * The Process Agent that might be appointed by the parties to the agreement.
	 */
	ProcessAgent getProcessAgent();
	/**
	 * The jurisdiction specific terms relevant to the agreement.
	 */
	JurisdictionRelatedTerms getJurisdictionRelatedTerms();
	/**
	 * Any additional amendments that might be specified by the parties to the agreement.
	 */
	String getAdditionalAmendments();
	/**
	 * Any additional terms that might be specified applicable.
	 */
	String getAdditionalBespokeTerms();
	/**
	 * The terms of the Rider for the ISDA Euroclear 2019 Collateral Transfer Agreement with respect to the use of a Pledgee Representative attached to this Agreement.
	 */
	PledgeeRepresentativeRider getPledgeeRepresentativeRider();
	/**
	 * A clause providing that final return collateral is to be provided without consideration of any Minimum Transfer Amount and collateral haircut.
	 */
	FinalReturns getFinalReturns();

	/*********************** Build Methods  ***********************/
	CollateralTransferAgreementElections build();
	
	CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder toBuilder();
	
	static CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder builder() {
		return new CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralTransferAgreementElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralTransferAgreementElections> getType() {
		return CollateralTransferAgreementElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("regime"), processor, Regime.class, getRegime());
		processRosetta(path.newSubPath("oneWayProvisions"), processor, OneWayProvisions.class, getOneWayProvisions());
		processRosetta(path.newSubPath("generalSimmElections"), processor, GeneralSimmElections.class, getGeneralSimmElections());
		processor.processBasic(path.newSubPath("identifiedCrossCurrencySwap"), Boolean.class, getIdentifiedCrossCurrencySwap(), this);
		processRosetta(path.newSubPath("sensitivityMethodologies"), processor, SensitivityMethodologies.class, getSensitivityMethodologies());
		processRosetta(path.newSubPath("fxHaircutCurrency"), processor, FxHaircutCurrency.class, getFxHaircutCurrency());
		processRosetta(path.newSubPath("postingObligations"), processor, PostingObligations.class, getPostingObligations());
		processRosetta(path.newSubPath("substitutedRegime"), processor, SubstitutedRegime.class, getSubstitutedRegime());
		processRosetta(path.newSubPath("baseAndEligibleCurrency"), processor, BaseAndEligibleCurrency.class, getBaseAndEligibleCurrency());
		processRosetta(path.newSubPath("creditSupportObligations"), processor, CreditSupportObligations.class, getCreditSupportObligations());
		processRosetta(path.newSubPath("calculationAndTiming"), processor, CalculationAndTiming.class, getCalculationAndTiming());
		processRosetta(path.newSubPath("conditionsPrecedent"), processor, ConditionsPrecedent.class, getConditionsPrecedent());
		processRosetta(path.newSubPath("substitution"), processor, Substitution.class, getSubstitution());
		processRosetta(path.newSubPath("disputeResolution"), processor, DisputeResolution.class, getDisputeResolution());
		processRosetta(path.newSubPath("rightsEvents"), processor, RightsEvents.class, getRightsEvents());
		processRosetta(path.newSubPath("custodyArrangements"), processor, CustodyArrangements.class, getCustodyArrangements());
		processRosetta(path.newSubPath("additionalRepresentations"), processor, AdditionalRepresentations.class, getAdditionalRepresentations());
		processRosetta(path.newSubPath("demandsAndNotices"), processor, ContactElection.class, getDemandsAndNotices());
		processRosetta(path.newSubPath("addressesForTransfer"), processor, ContactElection.class, getAddressesForTransfer());
		processor.processBasic(path.newSubPath("otherCsa"), String.class, getOtherCsa(), this);
		processRosetta(path.newSubPath("terminationCurrencyAmendment"), processor, TerminationCurrencyAmendment.class, getTerminationCurrencyAmendment());
		processRosetta(path.newSubPath("minimumTransferAmountAmendment"), processor, MinimumTransferAmountAmendment.class, getMinimumTransferAmountAmendment());
		processor.processBasic(path.newSubPath("interpretationTerms"), String.class, getInterpretationTerms(), this);
		processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.class, getProcessAgent());
		processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.class, getJurisdictionRelatedTerms());
		processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
		processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
		processRosetta(path.newSubPath("pledgeeRepresentativeRider"), processor, PledgeeRepresentativeRider.class, getPledgeeRepresentativeRider());
		processRosetta(path.newSubPath("finalReturns"), processor, FinalReturns.class, getFinalReturns());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralTransferAgreementElectionsBuilder extends CollateralTransferAgreementElections, RosettaModelObjectBuilder {
		Regime.RegimeBuilder getOrCreateRegime();
		@Override
		Regime.RegimeBuilder getRegime();
		OneWayProvisions.OneWayProvisionsBuilder getOrCreateOneWayProvisions();
		@Override
		OneWayProvisions.OneWayProvisionsBuilder getOneWayProvisions();
		GeneralSimmElections.GeneralSimmElectionsBuilder getOrCreateGeneralSimmElections();
		@Override
		GeneralSimmElections.GeneralSimmElectionsBuilder getGeneralSimmElections();
		SensitivityMethodologies.SensitivityMethodologiesBuilder getOrCreateSensitivityMethodologies();
		@Override
		SensitivityMethodologies.SensitivityMethodologiesBuilder getSensitivityMethodologies();
		FxHaircutCurrency.FxHaircutCurrencyBuilder getOrCreateFxHaircutCurrency();
		@Override
		FxHaircutCurrency.FxHaircutCurrencyBuilder getFxHaircutCurrency();
		PostingObligations.PostingObligationsBuilder getOrCreatePostingObligations();
		@Override
		PostingObligations.PostingObligationsBuilder getPostingObligations();
		SubstitutedRegime.SubstitutedRegimeBuilder getOrCreateSubstitutedRegime(int index);
		@Override
		List<? extends SubstitutedRegime.SubstitutedRegimeBuilder> getSubstitutedRegime();
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getOrCreateBaseAndEligibleCurrency();
		@Override
		BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getBaseAndEligibleCurrency();
		CreditSupportObligations.CreditSupportObligationsBuilder getOrCreateCreditSupportObligations();
		@Override
		CreditSupportObligations.CreditSupportObligationsBuilder getCreditSupportObligations();
		CalculationAndTiming.CalculationAndTimingBuilder getOrCreateCalculationAndTiming();
		@Override
		CalculationAndTiming.CalculationAndTimingBuilder getCalculationAndTiming();
		ConditionsPrecedent.ConditionsPrecedentBuilder getOrCreateConditionsPrecedent();
		@Override
		ConditionsPrecedent.ConditionsPrecedentBuilder getConditionsPrecedent();
		Substitution.SubstitutionBuilder getOrCreateSubstitution();
		@Override
		Substitution.SubstitutionBuilder getSubstitution();
		DisputeResolution.DisputeResolutionBuilder getOrCreateDisputeResolution();
		@Override
		DisputeResolution.DisputeResolutionBuilder getDisputeResolution();
		RightsEvents.RightsEventsBuilder getOrCreateRightsEvents();
		@Override
		RightsEvents.RightsEventsBuilder getRightsEvents();
		CustodyArrangements.CustodyArrangementsBuilder getOrCreateCustodyArrangements();
		@Override
		CustodyArrangements.CustodyArrangementsBuilder getCustodyArrangements();
		AdditionalRepresentations.AdditionalRepresentationsBuilder getOrCreateAdditionalRepresentations();
		@Override
		AdditionalRepresentations.AdditionalRepresentationsBuilder getAdditionalRepresentations();
		ContactElection.ContactElectionBuilder getOrCreateDemandsAndNotices();
		@Override
		ContactElection.ContactElectionBuilder getDemandsAndNotices();
		ContactElection.ContactElectionBuilder getOrCreateAddressesForTransfer();
		@Override
		ContactElection.ContactElectionBuilder getAddressesForTransfer();
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getOrCreateTerminationCurrencyAmendment();
		@Override
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getTerminationCurrencyAmendment();
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getOrCreateMinimumTransferAmountAmendment();
		@Override
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getMinimumTransferAmountAmendment();
		ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent();
		@Override
		ProcessAgent.ProcessAgentBuilder getProcessAgent();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms();
		@Override
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms();
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder getOrCreatePledgeeRepresentativeRider();
		@Override
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder getPledgeeRepresentativeRider();
		FinalReturns.FinalReturnsBuilder getOrCreateFinalReturns();
		@Override
		FinalReturns.FinalReturnsBuilder getFinalReturns();
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setRegime(Regime regime);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setOneWayProvisions(OneWayProvisions oneWayProvisions);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setGeneralSimmElections(GeneralSimmElections generalSimmElections);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setIdentifiedCrossCurrencySwap(Boolean identifiedCrossCurrencySwap);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setSensitivityMethodologies(SensitivityMethodologies sensitivityMethodologies);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setFxHaircutCurrency(FxHaircutCurrency fxHaircutCurrency);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setPostingObligations(PostingObligations postingObligations);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime, int idx);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder addSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegime);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegime);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setBaseAndEligibleCurrency(BaseAndEligibleCurrency baseAndEligibleCurrency);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setCreditSupportObligations(CreditSupportObligations creditSupportObligations);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setCalculationAndTiming(CalculationAndTiming calculationAndTiming);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setConditionsPrecedent(ConditionsPrecedent conditionsPrecedent);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setSubstitution(Substitution substitution);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setDisputeResolution(DisputeResolution disputeResolution);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setRightsEvents(RightsEvents rightsEvents);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setCustodyArrangements(CustodyArrangements custodyArrangements);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAdditionalRepresentations(AdditionalRepresentations additionalRepresentations);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setDemandsAndNotices(ContactElection demandsAndNotices);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAddressesForTransfer(ContactElection addressesForTransfer);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setOtherCsa(String otherCsa);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setTerminationCurrencyAmendment(TerminationCurrencyAmendment terminationCurrencyAmendment);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setMinimumTransferAmountAmendment(MinimumTransferAmountAmendment minimumTransferAmountAmendment);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setInterpretationTerms(String interpretationTerms);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setPledgeeRepresentativeRider(PledgeeRepresentativeRider pledgeeRepresentativeRider);
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setFinalReturns(FinalReturns finalReturns);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("regime"), processor, Regime.RegimeBuilder.class, getRegime());
			processRosetta(path.newSubPath("oneWayProvisions"), processor, OneWayProvisions.OneWayProvisionsBuilder.class, getOneWayProvisions());
			processRosetta(path.newSubPath("generalSimmElections"), processor, GeneralSimmElections.GeneralSimmElectionsBuilder.class, getGeneralSimmElections());
			processor.processBasic(path.newSubPath("identifiedCrossCurrencySwap"), Boolean.class, getIdentifiedCrossCurrencySwap(), this);
			processRosetta(path.newSubPath("sensitivityMethodologies"), processor, SensitivityMethodologies.SensitivityMethodologiesBuilder.class, getSensitivityMethodologies());
			processRosetta(path.newSubPath("fxHaircutCurrency"), processor, FxHaircutCurrency.FxHaircutCurrencyBuilder.class, getFxHaircutCurrency());
			processRosetta(path.newSubPath("postingObligations"), processor, PostingObligations.PostingObligationsBuilder.class, getPostingObligations());
			processRosetta(path.newSubPath("substitutedRegime"), processor, SubstitutedRegime.SubstitutedRegimeBuilder.class, getSubstitutedRegime());
			processRosetta(path.newSubPath("baseAndEligibleCurrency"), processor, BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder.class, getBaseAndEligibleCurrency());
			processRosetta(path.newSubPath("creditSupportObligations"), processor, CreditSupportObligations.CreditSupportObligationsBuilder.class, getCreditSupportObligations());
			processRosetta(path.newSubPath("calculationAndTiming"), processor, CalculationAndTiming.CalculationAndTimingBuilder.class, getCalculationAndTiming());
			processRosetta(path.newSubPath("conditionsPrecedent"), processor, ConditionsPrecedent.ConditionsPrecedentBuilder.class, getConditionsPrecedent());
			processRosetta(path.newSubPath("substitution"), processor, Substitution.SubstitutionBuilder.class, getSubstitution());
			processRosetta(path.newSubPath("disputeResolution"), processor, DisputeResolution.DisputeResolutionBuilder.class, getDisputeResolution());
			processRosetta(path.newSubPath("rightsEvents"), processor, RightsEvents.RightsEventsBuilder.class, getRightsEvents());
			processRosetta(path.newSubPath("custodyArrangements"), processor, CustodyArrangements.CustodyArrangementsBuilder.class, getCustodyArrangements());
			processRosetta(path.newSubPath("additionalRepresentations"), processor, AdditionalRepresentations.AdditionalRepresentationsBuilder.class, getAdditionalRepresentations());
			processRosetta(path.newSubPath("demandsAndNotices"), processor, ContactElection.ContactElectionBuilder.class, getDemandsAndNotices());
			processRosetta(path.newSubPath("addressesForTransfer"), processor, ContactElection.ContactElectionBuilder.class, getAddressesForTransfer());
			processor.processBasic(path.newSubPath("otherCsa"), String.class, getOtherCsa(), this);
			processRosetta(path.newSubPath("terminationCurrencyAmendment"), processor, TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder.class, getTerminationCurrencyAmendment());
			processRosetta(path.newSubPath("minimumTransferAmountAmendment"), processor, MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder.class, getMinimumTransferAmountAmendment());
			processor.processBasic(path.newSubPath("interpretationTerms"), String.class, getInterpretationTerms(), this);
			processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.ProcessAgentBuilder.class, getProcessAgent());
			processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder.class, getJurisdictionRelatedTerms());
			processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
			processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
			processRosetta(path.newSubPath("pledgeeRepresentativeRider"), processor, PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder.class, getPledgeeRepresentativeRider());
			processRosetta(path.newSubPath("finalReturns"), processor, FinalReturns.FinalReturnsBuilder.class, getFinalReturns());
		}
		

		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralTransferAgreementElections  ***********************/
	class CollateralTransferAgreementElectionsImpl implements CollateralTransferAgreementElections {
		private final Regime regime;
		private final OneWayProvisions oneWayProvisions;
		private final GeneralSimmElections generalSimmElections;
		private final Boolean identifiedCrossCurrencySwap;
		private final SensitivityMethodologies sensitivityMethodologies;
		private final FxHaircutCurrency fxHaircutCurrency;
		private final PostingObligations postingObligations;
		private final List<? extends SubstitutedRegime> substitutedRegime;
		private final BaseAndEligibleCurrency baseAndEligibleCurrency;
		private final CreditSupportObligations creditSupportObligations;
		private final CalculationAndTiming calculationAndTiming;
		private final ConditionsPrecedent conditionsPrecedent;
		private final Substitution substitution;
		private final DisputeResolution disputeResolution;
		private final RightsEvents rightsEvents;
		private final CustodyArrangements custodyArrangements;
		private final AdditionalRepresentations additionalRepresentations;
		private final ContactElection demandsAndNotices;
		private final ContactElection addressesForTransfer;
		private final String otherCsa;
		private final TerminationCurrencyAmendment terminationCurrencyAmendment;
		private final MinimumTransferAmountAmendment minimumTransferAmountAmendment;
		private final String interpretationTerms;
		private final ProcessAgent processAgent;
		private final JurisdictionRelatedTerms jurisdictionRelatedTerms;
		private final String additionalAmendments;
		private final String additionalBespokeTerms;
		private final PledgeeRepresentativeRider pledgeeRepresentativeRider;
		private final FinalReturns finalReturns;
		
		protected CollateralTransferAgreementElectionsImpl(CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder builder) {
			this.regime = ofNullable(builder.getRegime()).map(f->f.build()).orElse(null);
			this.oneWayProvisions = ofNullable(builder.getOneWayProvisions()).map(f->f.build()).orElse(null);
			this.generalSimmElections = ofNullable(builder.getGeneralSimmElections()).map(f->f.build()).orElse(null);
			this.identifiedCrossCurrencySwap = builder.getIdentifiedCrossCurrencySwap();
			this.sensitivityMethodologies = ofNullable(builder.getSensitivityMethodologies()).map(f->f.build()).orElse(null);
			this.fxHaircutCurrency = ofNullable(builder.getFxHaircutCurrency()).map(f->f.build()).orElse(null);
			this.postingObligations = ofNullable(builder.getPostingObligations()).map(f->f.build()).orElse(null);
			this.substitutedRegime = ofNullable(builder.getSubstitutedRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.baseAndEligibleCurrency = ofNullable(builder.getBaseAndEligibleCurrency()).map(f->f.build()).orElse(null);
			this.creditSupportObligations = ofNullable(builder.getCreditSupportObligations()).map(f->f.build()).orElse(null);
			this.calculationAndTiming = ofNullable(builder.getCalculationAndTiming()).map(f->f.build()).orElse(null);
			this.conditionsPrecedent = ofNullable(builder.getConditionsPrecedent()).map(f->f.build()).orElse(null);
			this.substitution = ofNullable(builder.getSubstitution()).map(f->f.build()).orElse(null);
			this.disputeResolution = ofNullable(builder.getDisputeResolution()).map(f->f.build()).orElse(null);
			this.rightsEvents = ofNullable(builder.getRightsEvents()).map(f->f.build()).orElse(null);
			this.custodyArrangements = ofNullable(builder.getCustodyArrangements()).map(f->f.build()).orElse(null);
			this.additionalRepresentations = ofNullable(builder.getAdditionalRepresentations()).map(f->f.build()).orElse(null);
			this.demandsAndNotices = ofNullable(builder.getDemandsAndNotices()).map(f->f.build()).orElse(null);
			this.addressesForTransfer = ofNullable(builder.getAddressesForTransfer()).map(f->f.build()).orElse(null);
			this.otherCsa = builder.getOtherCsa();
			this.terminationCurrencyAmendment = ofNullable(builder.getTerminationCurrencyAmendment()).map(f->f.build()).orElse(null);
			this.minimumTransferAmountAmendment = ofNullable(builder.getMinimumTransferAmountAmendment()).map(f->f.build()).orElse(null);
			this.interpretationTerms = builder.getInterpretationTerms();
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
			this.jurisdictionRelatedTerms = ofNullable(builder.getJurisdictionRelatedTerms()).map(f->f.build()).orElse(null);
			this.additionalAmendments = builder.getAdditionalAmendments();
			this.additionalBespokeTerms = builder.getAdditionalBespokeTerms();
			this.pledgeeRepresentativeRider = ofNullable(builder.getPledgeeRepresentativeRider()).map(f->f.build()).orElse(null);
			this.finalReturns = ofNullable(builder.getFinalReturns()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("regime")
		public Regime getRegime() {
			return regime;
		}
		
		@Override
		@RosettaAttribute("oneWayProvisions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("oneWayProvisions")
		public OneWayProvisions getOneWayProvisions() {
			return oneWayProvisions;
		}
		
		@Override
		@RosettaAttribute("generalSimmElections")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("generalSimmElections")
		public GeneralSimmElections getGeneralSimmElections() {
			return generalSimmElections;
		}
		
		@Override
		@RosettaAttribute("identifiedCrossCurrencySwap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifiedCrossCurrencySwap")
		public Boolean getIdentifiedCrossCurrencySwap() {
			return identifiedCrossCurrencySwap;
		}
		
		@Override
		@RosettaAttribute("sensitivityMethodologies")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sensitivityMethodologies")
		public SensitivityMethodologies getSensitivityMethodologies() {
			return sensitivityMethodologies;
		}
		
		@Override
		@RosettaAttribute("fxHaircutCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxHaircutCurrency")
		public FxHaircutCurrency getFxHaircutCurrency() {
			return fxHaircutCurrency;
		}
		
		@Override
		@RosettaAttribute("postingObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postingObligations")
		public PostingObligations getPostingObligations() {
			return postingObligations;
		}
		
		@Override
		@RosettaAttribute("substitutedRegime")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("substitutedRegime")
		public List<? extends SubstitutedRegime> getSubstitutedRegime() {
			return substitutedRegime;
		}
		
		@Override
		@RosettaAttribute("baseAndEligibleCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseAndEligibleCurrency")
		public BaseAndEligibleCurrency getBaseAndEligibleCurrency() {
			return baseAndEligibleCurrency;
		}
		
		@Override
		@RosettaAttribute("creditSupportObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportObligations")
		public CreditSupportObligations getCreditSupportObligations() {
			return creditSupportObligations;
		}
		
		@Override
		@RosettaAttribute("calculationAndTiming")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationAndTiming")
		public CalculationAndTiming getCalculationAndTiming() {
			return calculationAndTiming;
		}
		
		@Override
		@RosettaAttribute("conditionsPrecedent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("conditionsPrecedent")
		public ConditionsPrecedent getConditionsPrecedent() {
			return conditionsPrecedent;
		}
		
		@Override
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("substitution")
		public Substitution getSubstitution() {
			return substitution;
		}
		
		@Override
		@RosettaAttribute("disputeResolution")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("disputeResolution")
		public DisputeResolution getDisputeResolution() {
			return disputeResolution;
		}
		
		@Override
		@RosettaAttribute("rightsEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rightsEvents")
		public RightsEvents getRightsEvents() {
			return rightsEvents;
		}
		
		@Override
		@RosettaAttribute("custodyArrangements")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("custodyArrangements")
		public CustodyArrangements getCustodyArrangements() {
			return custodyArrangements;
		}
		
		@Override
		@RosettaAttribute("additionalRepresentations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("additionalRepresentations")
		public AdditionalRepresentations getAdditionalRepresentations() {
			return additionalRepresentations;
		}
		
		@Override
		@RosettaAttribute("demandsAndNotices")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("demandsAndNotices")
		public ContactElection getDemandsAndNotices() {
			return demandsAndNotices;
		}
		
		@Override
		@RosettaAttribute("addressesForTransfer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addressesForTransfer")
		public ContactElection getAddressesForTransfer() {
			return addressesForTransfer;
		}
		
		@Override
		@RosettaAttribute("otherCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCsa")
		public String getOtherCsa() {
			return otherCsa;
		}
		
		@Override
		@RosettaAttribute("terminationCurrencyAmendment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationCurrencyAmendment")
		public TerminationCurrencyAmendment getTerminationCurrencyAmendment() {
			return terminationCurrencyAmendment;
		}
		
		@Override
		@RosettaAttribute("minimumTransferAmountAmendment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumTransferAmountAmendment")
		public MinimumTransferAmountAmendment getMinimumTransferAmountAmendment() {
			return minimumTransferAmountAmendment;
		}
		
		@Override
		@RosettaAttribute("interpretationTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpretationTerms")
		public String getInterpretationTerms() {
			return interpretationTerms;
		}
		
		@Override
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processAgent")
		public ProcessAgent getProcessAgent() {
			return processAgent;
		}
		
		@Override
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		public JurisdictionRelatedTerms getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalAmendments")
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalBespokeTerms")
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		@RosettaAttribute("pledgeeRepresentativeRider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pledgeeRepresentativeRider")
		public PledgeeRepresentativeRider getPledgeeRepresentativeRider() {
			return pledgeeRepresentativeRider;
		}
		
		@Override
		@RosettaAttribute("finalReturns")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("finalReturns")
		public FinalReturns getFinalReturns() {
			return finalReturns;
		}
		
		@Override
		public CollateralTransferAgreementElections build() {
			return this;
		}
		
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder toBuilder() {
			CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder builder) {
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getOneWayProvisions()).ifPresent(builder::setOneWayProvisions);
			ofNullable(getGeneralSimmElections()).ifPresent(builder::setGeneralSimmElections);
			ofNullable(getIdentifiedCrossCurrencySwap()).ifPresent(builder::setIdentifiedCrossCurrencySwap);
			ofNullable(getSensitivityMethodologies()).ifPresent(builder::setSensitivityMethodologies);
			ofNullable(getFxHaircutCurrency()).ifPresent(builder::setFxHaircutCurrency);
			ofNullable(getPostingObligations()).ifPresent(builder::setPostingObligations);
			ofNullable(getSubstitutedRegime()).ifPresent(builder::setSubstitutedRegime);
			ofNullable(getBaseAndEligibleCurrency()).ifPresent(builder::setBaseAndEligibleCurrency);
			ofNullable(getCreditSupportObligations()).ifPresent(builder::setCreditSupportObligations);
			ofNullable(getCalculationAndTiming()).ifPresent(builder::setCalculationAndTiming);
			ofNullable(getConditionsPrecedent()).ifPresent(builder::setConditionsPrecedent);
			ofNullable(getSubstitution()).ifPresent(builder::setSubstitution);
			ofNullable(getDisputeResolution()).ifPresent(builder::setDisputeResolution);
			ofNullable(getRightsEvents()).ifPresent(builder::setRightsEvents);
			ofNullable(getCustodyArrangements()).ifPresent(builder::setCustodyArrangements);
			ofNullable(getAdditionalRepresentations()).ifPresent(builder::setAdditionalRepresentations);
			ofNullable(getDemandsAndNotices()).ifPresent(builder::setDemandsAndNotices);
			ofNullable(getAddressesForTransfer()).ifPresent(builder::setAddressesForTransfer);
			ofNullable(getOtherCsa()).ifPresent(builder::setOtherCsa);
			ofNullable(getTerminationCurrencyAmendment()).ifPresent(builder::setTerminationCurrencyAmendment);
			ofNullable(getMinimumTransferAmountAmendment()).ifPresent(builder::setMinimumTransferAmountAmendment);
			ofNullable(getInterpretationTerms()).ifPresent(builder::setInterpretationTerms);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
			ofNullable(getJurisdictionRelatedTerms()).ifPresent(builder::setJurisdictionRelatedTerms);
			ofNullable(getAdditionalAmendments()).ifPresent(builder::setAdditionalAmendments);
			ofNullable(getAdditionalBespokeTerms()).ifPresent(builder::setAdditionalBespokeTerms);
			ofNullable(getPledgeeRepresentativeRider()).ifPresent(builder::setPledgeeRepresentativeRider);
			ofNullable(getFinalReturns()).ifPresent(builder::setFinalReturns);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTransferAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(oneWayProvisions, _that.getOneWayProvisions())) return false;
			if (!Objects.equals(generalSimmElections, _that.getGeneralSimmElections())) return false;
			if (!Objects.equals(identifiedCrossCurrencySwap, _that.getIdentifiedCrossCurrencySwap())) return false;
			if (!Objects.equals(sensitivityMethodologies, _that.getSensitivityMethodologies())) return false;
			if (!Objects.equals(fxHaircutCurrency, _that.getFxHaircutCurrency())) return false;
			if (!Objects.equals(postingObligations, _that.getPostingObligations())) return false;
			if (!ListEquals.listEquals(substitutedRegime, _that.getSubstitutedRegime())) return false;
			if (!Objects.equals(baseAndEligibleCurrency, _that.getBaseAndEligibleCurrency())) return false;
			if (!Objects.equals(creditSupportObligations, _that.getCreditSupportObligations())) return false;
			if (!Objects.equals(calculationAndTiming, _that.getCalculationAndTiming())) return false;
			if (!Objects.equals(conditionsPrecedent, _that.getConditionsPrecedent())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(disputeResolution, _that.getDisputeResolution())) return false;
			if (!Objects.equals(rightsEvents, _that.getRightsEvents())) return false;
			if (!Objects.equals(custodyArrangements, _that.getCustodyArrangements())) return false;
			if (!Objects.equals(additionalRepresentations, _that.getAdditionalRepresentations())) return false;
			if (!Objects.equals(demandsAndNotices, _that.getDemandsAndNotices())) return false;
			if (!Objects.equals(addressesForTransfer, _that.getAddressesForTransfer())) return false;
			if (!Objects.equals(otherCsa, _that.getOtherCsa())) return false;
			if (!Objects.equals(terminationCurrencyAmendment, _that.getTerminationCurrencyAmendment())) return false;
			if (!Objects.equals(minimumTransferAmountAmendment, _that.getMinimumTransferAmountAmendment())) return false;
			if (!Objects.equals(interpretationTerms, _that.getInterpretationTerms())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(pledgeeRepresentativeRider, _that.getPledgeeRepresentativeRider())) return false;
			if (!Objects.equals(finalReturns, _that.getFinalReturns())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regime != null ? regime.hashCode() : 0);
			_result = 31 * _result + (oneWayProvisions != null ? oneWayProvisions.hashCode() : 0);
			_result = 31 * _result + (generalSimmElections != null ? generalSimmElections.hashCode() : 0);
			_result = 31 * _result + (identifiedCrossCurrencySwap != null ? identifiedCrossCurrencySwap.hashCode() : 0);
			_result = 31 * _result + (sensitivityMethodologies != null ? sensitivityMethodologies.hashCode() : 0);
			_result = 31 * _result + (fxHaircutCurrency != null ? fxHaircutCurrency.hashCode() : 0);
			_result = 31 * _result + (postingObligations != null ? postingObligations.hashCode() : 0);
			_result = 31 * _result + (substitutedRegime != null ? substitutedRegime.hashCode() : 0);
			_result = 31 * _result + (baseAndEligibleCurrency != null ? baseAndEligibleCurrency.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligations != null ? creditSupportObligations.hashCode() : 0);
			_result = 31 * _result + (calculationAndTiming != null ? calculationAndTiming.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedent != null ? conditionsPrecedent.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (disputeResolution != null ? disputeResolution.hashCode() : 0);
			_result = 31 * _result + (rightsEvents != null ? rightsEvents.hashCode() : 0);
			_result = 31 * _result + (custodyArrangements != null ? custodyArrangements.hashCode() : 0);
			_result = 31 * _result + (additionalRepresentations != null ? additionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (demandsAndNotices != null ? demandsAndNotices.hashCode() : 0);
			_result = 31 * _result + (addressesForTransfer != null ? addressesForTransfer.hashCode() : 0);
			_result = 31 * _result + (otherCsa != null ? otherCsa.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyAmendment != null ? terminationCurrencyAmendment.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmountAmendment != null ? minimumTransferAmountAmendment.hashCode() : 0);
			_result = 31 * _result + (interpretationTerms != null ? interpretationTerms.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (pledgeeRepresentativeRider != null ? pledgeeRepresentativeRider.hashCode() : 0);
			_result = 31 * _result + (finalReturns != null ? finalReturns.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTransferAgreementElections {" +
				"regime=" + this.regime + ", " +
				"oneWayProvisions=" + this.oneWayProvisions + ", " +
				"generalSimmElections=" + this.generalSimmElections + ", " +
				"identifiedCrossCurrencySwap=" + this.identifiedCrossCurrencySwap + ", " +
				"sensitivityMethodologies=" + this.sensitivityMethodologies + ", " +
				"fxHaircutCurrency=" + this.fxHaircutCurrency + ", " +
				"postingObligations=" + this.postingObligations + ", " +
				"substitutedRegime=" + this.substitutedRegime + ", " +
				"baseAndEligibleCurrency=" + this.baseAndEligibleCurrency + ", " +
				"creditSupportObligations=" + this.creditSupportObligations + ", " +
				"calculationAndTiming=" + this.calculationAndTiming + ", " +
				"conditionsPrecedent=" + this.conditionsPrecedent + ", " +
				"substitution=" + this.substitution + ", " +
				"disputeResolution=" + this.disputeResolution + ", " +
				"rightsEvents=" + this.rightsEvents + ", " +
				"custodyArrangements=" + this.custodyArrangements + ", " +
				"additionalRepresentations=" + this.additionalRepresentations + ", " +
				"demandsAndNotices=" + this.demandsAndNotices + ", " +
				"addressesForTransfer=" + this.addressesForTransfer + ", " +
				"otherCsa=" + this.otherCsa + ", " +
				"terminationCurrencyAmendment=" + this.terminationCurrencyAmendment + ", " +
				"minimumTransferAmountAmendment=" + this.minimumTransferAmountAmendment + ", " +
				"interpretationTerms=" + this.interpretationTerms + ", " +
				"processAgent=" + this.processAgent + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"pledgeeRepresentativeRider=" + this.pledgeeRepresentativeRider + ", " +
				"finalReturns=" + this.finalReturns +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralTransferAgreementElections  ***********************/
	class CollateralTransferAgreementElectionsBuilderImpl implements CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder {
	
		protected Regime.RegimeBuilder regime;
		protected OneWayProvisions.OneWayProvisionsBuilder oneWayProvisions;
		protected GeneralSimmElections.GeneralSimmElectionsBuilder generalSimmElections;
		protected Boolean identifiedCrossCurrencySwap;
		protected SensitivityMethodologies.SensitivityMethodologiesBuilder sensitivityMethodologies;
		protected FxHaircutCurrency.FxHaircutCurrencyBuilder fxHaircutCurrency;
		protected PostingObligations.PostingObligationsBuilder postingObligations;
		protected List<SubstitutedRegime.SubstitutedRegimeBuilder> substitutedRegime = new ArrayList<>();
		protected BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder baseAndEligibleCurrency;
		protected CreditSupportObligations.CreditSupportObligationsBuilder creditSupportObligations;
		protected CalculationAndTiming.CalculationAndTimingBuilder calculationAndTiming;
		protected ConditionsPrecedent.ConditionsPrecedentBuilder conditionsPrecedent;
		protected Substitution.SubstitutionBuilder substitution;
		protected DisputeResolution.DisputeResolutionBuilder disputeResolution;
		protected RightsEvents.RightsEventsBuilder rightsEvents;
		protected CustodyArrangements.CustodyArrangementsBuilder custodyArrangements;
		protected AdditionalRepresentations.AdditionalRepresentationsBuilder additionalRepresentations;
		protected ContactElection.ContactElectionBuilder demandsAndNotices;
		protected ContactElection.ContactElectionBuilder addressesForTransfer;
		protected String otherCsa;
		protected TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder terminationCurrencyAmendment;
		protected MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder minimumTransferAmountAmendment;
		protected String interpretationTerms;
		protected ProcessAgent.ProcessAgentBuilder processAgent;
		protected JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder jurisdictionRelatedTerms;
		protected String additionalAmendments;
		protected String additionalBespokeTerms;
		protected PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder pledgeeRepresentativeRider;
		protected FinalReturns.FinalReturnsBuilder finalReturns;
		
		@Override
		@RosettaAttribute("regime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("regime")
		public Regime.RegimeBuilder getRegime() {
			return regime;
		}
		
		@Override
		public Regime.RegimeBuilder getOrCreateRegime() {
			Regime.RegimeBuilder result;
			if (regime!=null) {
				result = regime;
			}
			else {
				result = regime = Regime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oneWayProvisions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("oneWayProvisions")
		public OneWayProvisions.OneWayProvisionsBuilder getOneWayProvisions() {
			return oneWayProvisions;
		}
		
		@Override
		public OneWayProvisions.OneWayProvisionsBuilder getOrCreateOneWayProvisions() {
			OneWayProvisions.OneWayProvisionsBuilder result;
			if (oneWayProvisions!=null) {
				result = oneWayProvisions;
			}
			else {
				result = oneWayProvisions = OneWayProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("generalSimmElections")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("generalSimmElections")
		public GeneralSimmElections.GeneralSimmElectionsBuilder getGeneralSimmElections() {
			return generalSimmElections;
		}
		
		@Override
		public GeneralSimmElections.GeneralSimmElectionsBuilder getOrCreateGeneralSimmElections() {
			GeneralSimmElections.GeneralSimmElectionsBuilder result;
			if (generalSimmElections!=null) {
				result = generalSimmElections;
			}
			else {
				result = generalSimmElections = GeneralSimmElections.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifiedCrossCurrencySwap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifiedCrossCurrencySwap")
		public Boolean getIdentifiedCrossCurrencySwap() {
			return identifiedCrossCurrencySwap;
		}
		
		@Override
		@RosettaAttribute("sensitivityMethodologies")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sensitivityMethodologies")
		public SensitivityMethodologies.SensitivityMethodologiesBuilder getSensitivityMethodologies() {
			return sensitivityMethodologies;
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder getOrCreateSensitivityMethodologies() {
			SensitivityMethodologies.SensitivityMethodologiesBuilder result;
			if (sensitivityMethodologies!=null) {
				result = sensitivityMethodologies;
			}
			else {
				result = sensitivityMethodologies = SensitivityMethodologies.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxHaircutCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxHaircutCurrency")
		public FxHaircutCurrency.FxHaircutCurrencyBuilder getFxHaircutCurrency() {
			return fxHaircutCurrency;
		}
		
		@Override
		public FxHaircutCurrency.FxHaircutCurrencyBuilder getOrCreateFxHaircutCurrency() {
			FxHaircutCurrency.FxHaircutCurrencyBuilder result;
			if (fxHaircutCurrency!=null) {
				result = fxHaircutCurrency;
			}
			else {
				result = fxHaircutCurrency = FxHaircutCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postingObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("postingObligations")
		public PostingObligations.PostingObligationsBuilder getPostingObligations() {
			return postingObligations;
		}
		
		@Override
		public PostingObligations.PostingObligationsBuilder getOrCreatePostingObligations() {
			PostingObligations.PostingObligationsBuilder result;
			if (postingObligations!=null) {
				result = postingObligations;
			}
			else {
				result = postingObligations = PostingObligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("substitutedRegime")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("substitutedRegime")
		public List<? extends SubstitutedRegime.SubstitutedRegimeBuilder> getSubstitutedRegime() {
			return substitutedRegime;
		}
		
		@Override
		public SubstitutedRegime.SubstitutedRegimeBuilder getOrCreateSubstitutedRegime(int index) {
			if (substitutedRegime==null) {
				this.substitutedRegime = new ArrayList<>();
			}
			return getIndex(substitutedRegime, index, () -> {
						SubstitutedRegime.SubstitutedRegimeBuilder newSubstitutedRegime = SubstitutedRegime.builder();
						return newSubstitutedRegime;
					});
		}
		
		@Override
		@RosettaAttribute("baseAndEligibleCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseAndEligibleCurrency")
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getBaseAndEligibleCurrency() {
			return baseAndEligibleCurrency;
		}
		
		@Override
		public BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder getOrCreateBaseAndEligibleCurrency() {
			BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder result;
			if (baseAndEligibleCurrency!=null) {
				result = baseAndEligibleCurrency;
			}
			else {
				result = baseAndEligibleCurrency = BaseAndEligibleCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportObligations")
		public CreditSupportObligations.CreditSupportObligationsBuilder getCreditSupportObligations() {
			return creditSupportObligations;
		}
		
		@Override
		public CreditSupportObligations.CreditSupportObligationsBuilder getOrCreateCreditSupportObligations() {
			CreditSupportObligations.CreditSupportObligationsBuilder result;
			if (creditSupportObligations!=null) {
				result = creditSupportObligations;
			}
			else {
				result = creditSupportObligations = CreditSupportObligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAndTiming")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculationAndTiming")
		public CalculationAndTiming.CalculationAndTimingBuilder getCalculationAndTiming() {
			return calculationAndTiming;
		}
		
		@Override
		public CalculationAndTiming.CalculationAndTimingBuilder getOrCreateCalculationAndTiming() {
			CalculationAndTiming.CalculationAndTimingBuilder result;
			if (calculationAndTiming!=null) {
				result = calculationAndTiming;
			}
			else {
				result = calculationAndTiming = CalculationAndTiming.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conditionsPrecedent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("conditionsPrecedent")
		public ConditionsPrecedent.ConditionsPrecedentBuilder getConditionsPrecedent() {
			return conditionsPrecedent;
		}
		
		@Override
		public ConditionsPrecedent.ConditionsPrecedentBuilder getOrCreateConditionsPrecedent() {
			ConditionsPrecedent.ConditionsPrecedentBuilder result;
			if (conditionsPrecedent!=null) {
				result = conditionsPrecedent;
			}
			else {
				result = conditionsPrecedent = ConditionsPrecedent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("substitution")
		public Substitution.SubstitutionBuilder getSubstitution() {
			return substitution;
		}
		
		@Override
		public Substitution.SubstitutionBuilder getOrCreateSubstitution() {
			Substitution.SubstitutionBuilder result;
			if (substitution!=null) {
				result = substitution;
			}
			else {
				result = substitution = Substitution.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("disputeResolution")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("disputeResolution")
		public DisputeResolution.DisputeResolutionBuilder getDisputeResolution() {
			return disputeResolution;
		}
		
		@Override
		public DisputeResolution.DisputeResolutionBuilder getOrCreateDisputeResolution() {
			DisputeResolution.DisputeResolutionBuilder result;
			if (disputeResolution!=null) {
				result = disputeResolution;
			}
			else {
				result = disputeResolution = DisputeResolution.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rightsEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rightsEvents")
		public RightsEvents.RightsEventsBuilder getRightsEvents() {
			return rightsEvents;
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder getOrCreateRightsEvents() {
			RightsEvents.RightsEventsBuilder result;
			if (rightsEvents!=null) {
				result = rightsEvents;
			}
			else {
				result = rightsEvents = RightsEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("custodyArrangements")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("custodyArrangements")
		public CustodyArrangements.CustodyArrangementsBuilder getCustodyArrangements() {
			return custodyArrangements;
		}
		
		@Override
		public CustodyArrangements.CustodyArrangementsBuilder getOrCreateCustodyArrangements() {
			CustodyArrangements.CustodyArrangementsBuilder result;
			if (custodyArrangements!=null) {
				result = custodyArrangements;
			}
			else {
				result = custodyArrangements = CustodyArrangements.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalRepresentations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("additionalRepresentations")
		public AdditionalRepresentations.AdditionalRepresentationsBuilder getAdditionalRepresentations() {
			return additionalRepresentations;
		}
		
		@Override
		public AdditionalRepresentations.AdditionalRepresentationsBuilder getOrCreateAdditionalRepresentations() {
			AdditionalRepresentations.AdditionalRepresentationsBuilder result;
			if (additionalRepresentations!=null) {
				result = additionalRepresentations;
			}
			else {
				result = additionalRepresentations = AdditionalRepresentations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("demandsAndNotices")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("demandsAndNotices")
		public ContactElection.ContactElectionBuilder getDemandsAndNotices() {
			return demandsAndNotices;
		}
		
		@Override
		public ContactElection.ContactElectionBuilder getOrCreateDemandsAndNotices() {
			ContactElection.ContactElectionBuilder result;
			if (demandsAndNotices!=null) {
				result = demandsAndNotices;
			}
			else {
				result = demandsAndNotices = ContactElection.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("addressesForTransfer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addressesForTransfer")
		public ContactElection.ContactElectionBuilder getAddressesForTransfer() {
			return addressesForTransfer;
		}
		
		@Override
		public ContactElection.ContactElectionBuilder getOrCreateAddressesForTransfer() {
			ContactElection.ContactElectionBuilder result;
			if (addressesForTransfer!=null) {
				result = addressesForTransfer;
			}
			else {
				result = addressesForTransfer = ContactElection.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherCsa")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCsa")
		public String getOtherCsa() {
			return otherCsa;
		}
		
		@Override
		@RosettaAttribute("terminationCurrencyAmendment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationCurrencyAmendment")
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getTerminationCurrencyAmendment() {
			return terminationCurrencyAmendment;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getOrCreateTerminationCurrencyAmendment() {
			TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder result;
			if (terminationCurrencyAmendment!=null) {
				result = terminationCurrencyAmendment;
			}
			else {
				result = terminationCurrencyAmendment = TerminationCurrencyAmendment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumTransferAmountAmendment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumTransferAmountAmendment")
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getMinimumTransferAmountAmendment() {
			return minimumTransferAmountAmendment;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getOrCreateMinimumTransferAmountAmendment() {
			MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder result;
			if (minimumTransferAmountAmendment!=null) {
				result = minimumTransferAmountAmendment;
			}
			else {
				result = minimumTransferAmountAmendment = MinimumTransferAmountAmendment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpretationTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interpretationTerms")
		public String getInterpretationTerms() {
			return interpretationTerms;
		}
		
		@Override
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("processAgent")
		public ProcessAgent.ProcessAgentBuilder getProcessAgent() {
			return processAgent;
		}
		
		@Override
		public ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent() {
			ProcessAgent.ProcessAgentBuilder result;
			if (processAgent!=null) {
				result = processAgent;
			}
			else {
				result = processAgent = ProcessAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms() {
			return jurisdictionRelatedTerms;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms() {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder result;
			if (jurisdictionRelatedTerms!=null) {
				result = jurisdictionRelatedTerms;
			}
			else {
				result = jurisdictionRelatedTerms = JurisdictionRelatedTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalAmendments")
		public String getAdditionalAmendments() {
			return additionalAmendments;
		}
		
		@Override
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalBespokeTerms")
		public String getAdditionalBespokeTerms() {
			return additionalBespokeTerms;
		}
		
		@Override
		@RosettaAttribute("pledgeeRepresentativeRider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pledgeeRepresentativeRider")
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder getPledgeeRepresentativeRider() {
			return pledgeeRepresentativeRider;
		}
		
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder getOrCreatePledgeeRepresentativeRider() {
			PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder result;
			if (pledgeeRepresentativeRider!=null) {
				result = pledgeeRepresentativeRider;
			}
			else {
				result = pledgeeRepresentativeRider = PledgeeRepresentativeRider.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalReturns")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("finalReturns")
		public FinalReturns.FinalReturnsBuilder getFinalReturns() {
			return finalReturns;
		}
		
		@Override
		public FinalReturns.FinalReturnsBuilder getOrCreateFinalReturns() {
			FinalReturns.FinalReturnsBuilder result;
			if (finalReturns!=null) {
				result = finalReturns;
			}
			else {
				result = finalReturns = FinalReturns.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("regime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("regime")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setRegime(Regime _regime) {
			this.regime = _regime == null ? null : _regime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oneWayProvisions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("oneWayProvisions")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setOneWayProvisions(OneWayProvisions _oneWayProvisions) {
			this.oneWayProvisions = _oneWayProvisions == null ? null : _oneWayProvisions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("generalSimmElections")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("generalSimmElections")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setGeneralSimmElections(GeneralSimmElections _generalSimmElections) {
			this.generalSimmElections = _generalSimmElections == null ? null : _generalSimmElections.toBuilder();
			return this;
		}
		
		@RosettaAttribute("identifiedCrossCurrencySwap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifiedCrossCurrencySwap")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setIdentifiedCrossCurrencySwap(Boolean _identifiedCrossCurrencySwap) {
			this.identifiedCrossCurrencySwap = _identifiedCrossCurrencySwap == null ? null : _identifiedCrossCurrencySwap;
			return this;
		}
		
		@RosettaAttribute("sensitivityMethodologies")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sensitivityMethodologies")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setSensitivityMethodologies(SensitivityMethodologies _sensitivityMethodologies) {
			this.sensitivityMethodologies = _sensitivityMethodologies == null ? null : _sensitivityMethodologies.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxHaircutCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxHaircutCurrency")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setFxHaircutCurrency(FxHaircutCurrency _fxHaircutCurrency) {
			this.fxHaircutCurrency = _fxHaircutCurrency == null ? null : _fxHaircutCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postingObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("postingObligations")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setPostingObligations(PostingObligations _postingObligations) {
			this.postingObligations = _postingObligations == null ? null : _postingObligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("substitutedRegime")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("substitutedRegime")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime _substitutedRegime) {
			if (_substitutedRegime != null) {
				this.substitutedRegime.add(_substitutedRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime _substitutedRegime, int idx) {
			getIndex(this.substitutedRegime, idx, () -> _substitutedRegime.toBuilder());
			return this;
		}
		
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder addSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegimes) {
			if (substitutedRegimes != null) {
				for (final SubstitutedRegime toAdd : substitutedRegimes) {
					this.substitutedRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("substitutedRegime")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("substitutedRegime")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegimes) {
			if (substitutedRegimes == null) {
				this.substitutedRegime = new ArrayList<>();
			} else {
				this.substitutedRegime = substitutedRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("baseAndEligibleCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("baseAndEligibleCurrency")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setBaseAndEligibleCurrency(BaseAndEligibleCurrency _baseAndEligibleCurrency) {
			this.baseAndEligibleCurrency = _baseAndEligibleCurrency == null ? null : _baseAndEligibleCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportObligations")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setCreditSupportObligations(CreditSupportObligations _creditSupportObligations) {
			this.creditSupportObligations = _creditSupportObligations == null ? null : _creditSupportObligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAndTiming")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculationAndTiming")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setCalculationAndTiming(CalculationAndTiming _calculationAndTiming) {
			this.calculationAndTiming = _calculationAndTiming == null ? null : _calculationAndTiming.toBuilder();
			return this;
		}
		
		@RosettaAttribute("conditionsPrecedent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("conditionsPrecedent")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setConditionsPrecedent(ConditionsPrecedent _conditionsPrecedent) {
			this.conditionsPrecedent = _conditionsPrecedent == null ? null : _conditionsPrecedent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("substitution")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setSubstitution(Substitution _substitution) {
			this.substitution = _substitution == null ? null : _substitution.toBuilder();
			return this;
		}
		
		@RosettaAttribute("disputeResolution")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("disputeResolution")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setDisputeResolution(DisputeResolution _disputeResolution) {
			this.disputeResolution = _disputeResolution == null ? null : _disputeResolution.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rightsEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rightsEvents")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setRightsEvents(RightsEvents _rightsEvents) {
			this.rightsEvents = _rightsEvents == null ? null : _rightsEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("custodyArrangements")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("custodyArrangements")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setCustodyArrangements(CustodyArrangements _custodyArrangements) {
			this.custodyArrangements = _custodyArrangements == null ? null : _custodyArrangements.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalRepresentations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("additionalRepresentations")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAdditionalRepresentations(AdditionalRepresentations _additionalRepresentations) {
			this.additionalRepresentations = _additionalRepresentations == null ? null : _additionalRepresentations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("demandsAndNotices")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("demandsAndNotices")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setDemandsAndNotices(ContactElection _demandsAndNotices) {
			this.demandsAndNotices = _demandsAndNotices == null ? null : _demandsAndNotices.toBuilder();
			return this;
		}
		
		@RosettaAttribute("addressesForTransfer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addressesForTransfer")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAddressesForTransfer(ContactElection _addressesForTransfer) {
			this.addressesForTransfer = _addressesForTransfer == null ? null : _addressesForTransfer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherCsa")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherCsa")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setOtherCsa(String _otherCsa) {
			this.otherCsa = _otherCsa == null ? null : _otherCsa;
			return this;
		}
		
		@RosettaAttribute("terminationCurrencyAmendment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("terminationCurrencyAmendment")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setTerminationCurrencyAmendment(TerminationCurrencyAmendment _terminationCurrencyAmendment) {
			this.terminationCurrencyAmendment = _terminationCurrencyAmendment == null ? null : _terminationCurrencyAmendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumTransferAmountAmendment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumTransferAmountAmendment")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setMinimumTransferAmountAmendment(MinimumTransferAmountAmendment _minimumTransferAmountAmendment) {
			this.minimumTransferAmountAmendment = _minimumTransferAmountAmendment == null ? null : _minimumTransferAmountAmendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interpretationTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpretationTerms")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setInterpretationTerms(String _interpretationTerms) {
			this.interpretationTerms = _interpretationTerms == null ? null : _interpretationTerms;
			return this;
		}
		
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("processAgent")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setProcessAgent(ProcessAgent _processAgent) {
			this.processAgent = _processAgent == null ? null : _processAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms _jurisdictionRelatedTerms) {
			this.jurisdictionRelatedTerms = _jurisdictionRelatedTerms == null ? null : _jurisdictionRelatedTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalAmendments")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAdditionalAmendments(String _additionalAmendments) {
			this.additionalAmendments = _additionalAmendments == null ? null : _additionalAmendments;
			return this;
		}
		
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalBespokeTerms")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setAdditionalBespokeTerms(String _additionalBespokeTerms) {
			this.additionalBespokeTerms = _additionalBespokeTerms == null ? null : _additionalBespokeTerms;
			return this;
		}
		
		@RosettaAttribute("pledgeeRepresentativeRider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pledgeeRepresentativeRider")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setPledgeeRepresentativeRider(PledgeeRepresentativeRider _pledgeeRepresentativeRider) {
			this.pledgeeRepresentativeRider = _pledgeeRepresentativeRider == null ? null : _pledgeeRepresentativeRider.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalReturns")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("finalReturns")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder setFinalReturns(FinalReturns _finalReturns) {
			this.finalReturns = _finalReturns == null ? null : _finalReturns.toBuilder();
			return this;
		}
		
		@Override
		public CollateralTransferAgreementElections build() {
			return new CollateralTransferAgreementElections.CollateralTransferAgreementElectionsImpl(this);
		}
		
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder prune() {
			if (regime!=null && !regime.prune().hasData()) regime = null;
			if (oneWayProvisions!=null && !oneWayProvisions.prune().hasData()) oneWayProvisions = null;
			if (generalSimmElections!=null && !generalSimmElections.prune().hasData()) generalSimmElections = null;
			if (sensitivityMethodologies!=null && !sensitivityMethodologies.prune().hasData()) sensitivityMethodologies = null;
			if (fxHaircutCurrency!=null && !fxHaircutCurrency.prune().hasData()) fxHaircutCurrency = null;
			if (postingObligations!=null && !postingObligations.prune().hasData()) postingObligations = null;
			substitutedRegime = substitutedRegime.stream().filter(b->b!=null).<SubstitutedRegime.SubstitutedRegimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (baseAndEligibleCurrency!=null && !baseAndEligibleCurrency.prune().hasData()) baseAndEligibleCurrency = null;
			if (creditSupportObligations!=null && !creditSupportObligations.prune().hasData()) creditSupportObligations = null;
			if (calculationAndTiming!=null && !calculationAndTiming.prune().hasData()) calculationAndTiming = null;
			if (conditionsPrecedent!=null && !conditionsPrecedent.prune().hasData()) conditionsPrecedent = null;
			if (substitution!=null && !substitution.prune().hasData()) substitution = null;
			if (disputeResolution!=null && !disputeResolution.prune().hasData()) disputeResolution = null;
			if (rightsEvents!=null && !rightsEvents.prune().hasData()) rightsEvents = null;
			if (custodyArrangements!=null && !custodyArrangements.prune().hasData()) custodyArrangements = null;
			if (additionalRepresentations!=null && !additionalRepresentations.prune().hasData()) additionalRepresentations = null;
			if (demandsAndNotices!=null && !demandsAndNotices.prune().hasData()) demandsAndNotices = null;
			if (addressesForTransfer!=null && !addressesForTransfer.prune().hasData()) addressesForTransfer = null;
			if (terminationCurrencyAmendment!=null && !terminationCurrencyAmendment.prune().hasData()) terminationCurrencyAmendment = null;
			if (minimumTransferAmountAmendment!=null && !minimumTransferAmountAmendment.prune().hasData()) minimumTransferAmountAmendment = null;
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			if (jurisdictionRelatedTerms!=null && !jurisdictionRelatedTerms.prune().hasData()) jurisdictionRelatedTerms = null;
			if (pledgeeRepresentativeRider!=null && !pledgeeRepresentativeRider.prune().hasData()) pledgeeRepresentativeRider = null;
			if (finalReturns!=null && !finalReturns.prune().hasData()) finalReturns = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegime()!=null && getRegime().hasData()) return true;
			if (getOneWayProvisions()!=null && getOneWayProvisions().hasData()) return true;
			if (getGeneralSimmElections()!=null && getGeneralSimmElections().hasData()) return true;
			if (getIdentifiedCrossCurrencySwap()!=null) return true;
			if (getSensitivityMethodologies()!=null && getSensitivityMethodologies().hasData()) return true;
			if (getFxHaircutCurrency()!=null && getFxHaircutCurrency().hasData()) return true;
			if (getPostingObligations()!=null && getPostingObligations().hasData()) return true;
			if (getSubstitutedRegime()!=null && getSubstitutedRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBaseAndEligibleCurrency()!=null && getBaseAndEligibleCurrency().hasData()) return true;
			if (getCreditSupportObligations()!=null && getCreditSupportObligations().hasData()) return true;
			if (getCalculationAndTiming()!=null && getCalculationAndTiming().hasData()) return true;
			if (getConditionsPrecedent()!=null && getConditionsPrecedent().hasData()) return true;
			if (getSubstitution()!=null && getSubstitution().hasData()) return true;
			if (getDisputeResolution()!=null && getDisputeResolution().hasData()) return true;
			if (getRightsEvents()!=null && getRightsEvents().hasData()) return true;
			if (getCustodyArrangements()!=null && getCustodyArrangements().hasData()) return true;
			if (getAdditionalRepresentations()!=null && getAdditionalRepresentations().hasData()) return true;
			if (getDemandsAndNotices()!=null && getDemandsAndNotices().hasData()) return true;
			if (getAddressesForTransfer()!=null && getAddressesForTransfer().hasData()) return true;
			if (getOtherCsa()!=null) return true;
			if (getTerminationCurrencyAmendment()!=null && getTerminationCurrencyAmendment().hasData()) return true;
			if (getMinimumTransferAmountAmendment()!=null && getMinimumTransferAmountAmendment().hasData()) return true;
			if (getInterpretationTerms()!=null) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			if (getJurisdictionRelatedTerms()!=null && getJurisdictionRelatedTerms().hasData()) return true;
			if (getAdditionalAmendments()!=null) return true;
			if (getAdditionalBespokeTerms()!=null) return true;
			if (getPledgeeRepresentativeRider()!=null && getPledgeeRepresentativeRider().hasData()) return true;
			if (getFinalReturns()!=null && getFinalReturns().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder o = (CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder) other;
			
			merger.mergeRosetta(getRegime(), o.getRegime(), this::setRegime);
			merger.mergeRosetta(getOneWayProvisions(), o.getOneWayProvisions(), this::setOneWayProvisions);
			merger.mergeRosetta(getGeneralSimmElections(), o.getGeneralSimmElections(), this::setGeneralSimmElections);
			merger.mergeRosetta(getSensitivityMethodologies(), o.getSensitivityMethodologies(), this::setSensitivityMethodologies);
			merger.mergeRosetta(getFxHaircutCurrency(), o.getFxHaircutCurrency(), this::setFxHaircutCurrency);
			merger.mergeRosetta(getPostingObligations(), o.getPostingObligations(), this::setPostingObligations);
			merger.mergeRosetta(getSubstitutedRegime(), o.getSubstitutedRegime(), this::getOrCreateSubstitutedRegime);
			merger.mergeRosetta(getBaseAndEligibleCurrency(), o.getBaseAndEligibleCurrency(), this::setBaseAndEligibleCurrency);
			merger.mergeRosetta(getCreditSupportObligations(), o.getCreditSupportObligations(), this::setCreditSupportObligations);
			merger.mergeRosetta(getCalculationAndTiming(), o.getCalculationAndTiming(), this::setCalculationAndTiming);
			merger.mergeRosetta(getConditionsPrecedent(), o.getConditionsPrecedent(), this::setConditionsPrecedent);
			merger.mergeRosetta(getSubstitution(), o.getSubstitution(), this::setSubstitution);
			merger.mergeRosetta(getDisputeResolution(), o.getDisputeResolution(), this::setDisputeResolution);
			merger.mergeRosetta(getRightsEvents(), o.getRightsEvents(), this::setRightsEvents);
			merger.mergeRosetta(getCustodyArrangements(), o.getCustodyArrangements(), this::setCustodyArrangements);
			merger.mergeRosetta(getAdditionalRepresentations(), o.getAdditionalRepresentations(), this::setAdditionalRepresentations);
			merger.mergeRosetta(getDemandsAndNotices(), o.getDemandsAndNotices(), this::setDemandsAndNotices);
			merger.mergeRosetta(getAddressesForTransfer(), o.getAddressesForTransfer(), this::setAddressesForTransfer);
			merger.mergeRosetta(getTerminationCurrencyAmendment(), o.getTerminationCurrencyAmendment(), this::setTerminationCurrencyAmendment);
			merger.mergeRosetta(getMinimumTransferAmountAmendment(), o.getMinimumTransferAmountAmendment(), this::setMinimumTransferAmountAmendment);
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			merger.mergeRosetta(getJurisdictionRelatedTerms(), o.getJurisdictionRelatedTerms(), this::setJurisdictionRelatedTerms);
			merger.mergeRosetta(getPledgeeRepresentativeRider(), o.getPledgeeRepresentativeRider(), this::setPledgeeRepresentativeRider);
			merger.mergeRosetta(getFinalReturns(), o.getFinalReturns(), this::setFinalReturns);
			
			merger.mergeBasic(getIdentifiedCrossCurrencySwap(), o.getIdentifiedCrossCurrencySwap(), this::setIdentifiedCrossCurrencySwap);
			merger.mergeBasic(getOtherCsa(), o.getOtherCsa(), this::setOtherCsa);
			merger.mergeBasic(getInterpretationTerms(), o.getInterpretationTerms(), this::setInterpretationTerms);
			merger.mergeBasic(getAdditionalAmendments(), o.getAdditionalAmendments(), this::setAdditionalAmendments);
			merger.mergeBasic(getAdditionalBespokeTerms(), o.getAdditionalBespokeTerms(), this::setAdditionalBespokeTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralTransferAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(oneWayProvisions, _that.getOneWayProvisions())) return false;
			if (!Objects.equals(generalSimmElections, _that.getGeneralSimmElections())) return false;
			if (!Objects.equals(identifiedCrossCurrencySwap, _that.getIdentifiedCrossCurrencySwap())) return false;
			if (!Objects.equals(sensitivityMethodologies, _that.getSensitivityMethodologies())) return false;
			if (!Objects.equals(fxHaircutCurrency, _that.getFxHaircutCurrency())) return false;
			if (!Objects.equals(postingObligations, _that.getPostingObligations())) return false;
			if (!ListEquals.listEquals(substitutedRegime, _that.getSubstitutedRegime())) return false;
			if (!Objects.equals(baseAndEligibleCurrency, _that.getBaseAndEligibleCurrency())) return false;
			if (!Objects.equals(creditSupportObligations, _that.getCreditSupportObligations())) return false;
			if (!Objects.equals(calculationAndTiming, _that.getCalculationAndTiming())) return false;
			if (!Objects.equals(conditionsPrecedent, _that.getConditionsPrecedent())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(disputeResolution, _that.getDisputeResolution())) return false;
			if (!Objects.equals(rightsEvents, _that.getRightsEvents())) return false;
			if (!Objects.equals(custodyArrangements, _that.getCustodyArrangements())) return false;
			if (!Objects.equals(additionalRepresentations, _that.getAdditionalRepresentations())) return false;
			if (!Objects.equals(demandsAndNotices, _that.getDemandsAndNotices())) return false;
			if (!Objects.equals(addressesForTransfer, _that.getAddressesForTransfer())) return false;
			if (!Objects.equals(otherCsa, _that.getOtherCsa())) return false;
			if (!Objects.equals(terminationCurrencyAmendment, _that.getTerminationCurrencyAmendment())) return false;
			if (!Objects.equals(minimumTransferAmountAmendment, _that.getMinimumTransferAmountAmendment())) return false;
			if (!Objects.equals(interpretationTerms, _that.getInterpretationTerms())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(pledgeeRepresentativeRider, _that.getPledgeeRepresentativeRider())) return false;
			if (!Objects.equals(finalReturns, _that.getFinalReturns())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regime != null ? regime.hashCode() : 0);
			_result = 31 * _result + (oneWayProvisions != null ? oneWayProvisions.hashCode() : 0);
			_result = 31 * _result + (generalSimmElections != null ? generalSimmElections.hashCode() : 0);
			_result = 31 * _result + (identifiedCrossCurrencySwap != null ? identifiedCrossCurrencySwap.hashCode() : 0);
			_result = 31 * _result + (sensitivityMethodologies != null ? sensitivityMethodologies.hashCode() : 0);
			_result = 31 * _result + (fxHaircutCurrency != null ? fxHaircutCurrency.hashCode() : 0);
			_result = 31 * _result + (postingObligations != null ? postingObligations.hashCode() : 0);
			_result = 31 * _result + (substitutedRegime != null ? substitutedRegime.hashCode() : 0);
			_result = 31 * _result + (baseAndEligibleCurrency != null ? baseAndEligibleCurrency.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligations != null ? creditSupportObligations.hashCode() : 0);
			_result = 31 * _result + (calculationAndTiming != null ? calculationAndTiming.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedent != null ? conditionsPrecedent.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (disputeResolution != null ? disputeResolution.hashCode() : 0);
			_result = 31 * _result + (rightsEvents != null ? rightsEvents.hashCode() : 0);
			_result = 31 * _result + (custodyArrangements != null ? custodyArrangements.hashCode() : 0);
			_result = 31 * _result + (additionalRepresentations != null ? additionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (demandsAndNotices != null ? demandsAndNotices.hashCode() : 0);
			_result = 31 * _result + (addressesForTransfer != null ? addressesForTransfer.hashCode() : 0);
			_result = 31 * _result + (otherCsa != null ? otherCsa.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyAmendment != null ? terminationCurrencyAmendment.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmountAmendment != null ? minimumTransferAmountAmendment.hashCode() : 0);
			_result = 31 * _result + (interpretationTerms != null ? interpretationTerms.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (pledgeeRepresentativeRider != null ? pledgeeRepresentativeRider.hashCode() : 0);
			_result = 31 * _result + (finalReturns != null ? finalReturns.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralTransferAgreementElectionsBuilder {" +
				"regime=" + this.regime + ", " +
				"oneWayProvisions=" + this.oneWayProvisions + ", " +
				"generalSimmElections=" + this.generalSimmElections + ", " +
				"identifiedCrossCurrencySwap=" + this.identifiedCrossCurrencySwap + ", " +
				"sensitivityMethodologies=" + this.sensitivityMethodologies + ", " +
				"fxHaircutCurrency=" + this.fxHaircutCurrency + ", " +
				"postingObligations=" + this.postingObligations + ", " +
				"substitutedRegime=" + this.substitutedRegime + ", " +
				"baseAndEligibleCurrency=" + this.baseAndEligibleCurrency + ", " +
				"creditSupportObligations=" + this.creditSupportObligations + ", " +
				"calculationAndTiming=" + this.calculationAndTiming + ", " +
				"conditionsPrecedent=" + this.conditionsPrecedent + ", " +
				"substitution=" + this.substitution + ", " +
				"disputeResolution=" + this.disputeResolution + ", " +
				"rightsEvents=" + this.rightsEvents + ", " +
				"custodyArrangements=" + this.custodyArrangements + ", " +
				"additionalRepresentations=" + this.additionalRepresentations + ", " +
				"demandsAndNotices=" + this.demandsAndNotices + ", " +
				"addressesForTransfer=" + this.addressesForTransfer + ", " +
				"otherCsa=" + this.otherCsa + ", " +
				"terminationCurrencyAmendment=" + this.terminationCurrencyAmendment + ", " +
				"minimumTransferAmountAmendment=" + this.minimumTransferAmountAmendment + ", " +
				"interpretationTerms=" + this.interpretationTerms + ", " +
				"processAgent=" + this.processAgent + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"pledgeeRepresentativeRider=" + this.pledgeeRepresentativeRider + ", " +
				"finalReturns=" + this.finalReturns +
			'}';
		}
	}
}
