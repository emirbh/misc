package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CreditSupportAgreementElectionsMeta;
import cdm.product.collateral.ContactElection;
import cdm.product.collateral.DistributionAndInterestPayment;
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
 * The set of elections which specify a Credit Support Annex or Deed.
 * @version 6.23.0
 */
@RosettaDataType(value="CreditSupportAgreementElections", builder=CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportAgreementElections", model="cdm", builder=CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl.class, version="6.23.0")
public interface CreditSupportAgreementElections extends RosettaModelObject {

	CreditSupportAgreementElectionsMeta metaData = new CreditSupportAgreementElectionsMeta();

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
	 * The additional obligations that might be specified by the parties to a Credit Support Agreement.
	 */
	String getAdditionalObligations();
	/**
	 * The specification of transactions covered by the terms of the agreement.
	 */
	CoveredTransactions getCoveredTransactions();
	/**
	 * The Credit Support Obligations applicable to the agreement.
	 */
	CreditSupportObligations getCreditSupportObligations();
	/**
	 * The bespoke exchange date terms that might be specified by the parties to the agreement.
	 */
	String getExchangeDate();
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
	 * The elections for the holding and using of posted collateral by the respective parties to the Credit Support Annex for Variation Margin.
	 */
	HoldingAndUsingPostedCollateral getHoldingAndUsingPostedCollateral();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred.
	 */
	RightsEvents getRightsEvents();
	/**
	 * The Custodian and Segregated Account details in respect of each party to the agreement.
	 */
	CustodyArrangements getCustodyArrangements();
	/**
	 * The Distributions and Interest Payment terms specified as part of the agreement.
	 */
	DistributionAndInterestPayment getDistributionAndInterestPayment();
	/**
	 * The specification of whether the standard Credit Support Offset provisions are applicable (true) or not applicable (false).
	 */
	Boolean getCreditSupportOffsets();
	/**
	 * The specification Additional Representations that may be applicable to the agreement.
	 */
	AdditionalRepresentations getAdditionalRepresentations();
	/**
	 * The Other Eligible Support elections associated with margin agreements.
	 */
	OtherEligibleAndPostedSupport getOtherEligibleAndPostedSupport();
	/**
	 * The optional specification of address where the demands, specifications and notices will be communicated to for each of the parties to the agreement.
	 */
	ContactElection getDemandsAndNotices();
	/**
	 * The optional specification of address for transfer as specified by the respective parties to the agreement.
	 */
	ContactElection getAddressesForTransfer();
	/**
	 * The bespoke definition of other agreement terms as specified by the parties to the agreement.
	 */
	OtherAgreements getOtherAgreements();
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
	 * The election for the Valuation of Appropriate Collateral.
	 */
	AppropriatedCollateralValuation getAppropriatedCollateralValuation();
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
	 * The qualification of whether Trust Scheme Addendum is applicable (True) or not applicable (False).
	 */
	Boolean getTrustSchemeAddendum();
	/**
	 * The party to whom obligations under the Master Agreement are owed and secured by the credit support arrangements. Applicable to 1994 NY CSA, 1995 English Law CSD and 2016 New York Law VM CSA.
	 */
	SecurityInterestForObligations getSecurityInterestForObligations();
	/**
	 * Where only a single  party is explicitly designated to post collateral, the party which is specified as the sole poster of collateral.
	 */
	SinglePostingParty getSinglePostingParty();
	/**
	 * Defines the dates agreed by the parties as the date of the Credit Support Annex or Credit Support Deed.
	 */
	DatedAsOfDate getDatedAsOfDate();
	/**
	 * Details of language relating to Client Asset and Money Rules.
	 */
	String getCass();
	/**
	 * A clause detailing the prescence of another collateralisation arrangement within the Master Agreement between the parties to this Collateral Arrangement.
	 */
	String getOtherCSA();
	/**
	 * Details of any Additional Representations given by the relevant parties in relation to the collateral arrangement.
	 */
	String getLegacyAdditionalRepresentations();
	/**
	 * Details how particular types of collateral are valued (other than in respect of a default).
	 */
	CollateralValueMethod getValue();

	/*********************** Build Methods  ***********************/
	CreditSupportAgreementElections build();
	
	CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder();
	
	static CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder() {
		return new CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAgreementElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportAgreementElections> getType() {
		return CreditSupportAgreementElections.class;
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
		processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
		processRosetta(path.newSubPath("coveredTransactions"), processor, CoveredTransactions.class, getCoveredTransactions());
		processRosetta(path.newSubPath("creditSupportObligations"), processor, CreditSupportObligations.class, getCreditSupportObligations());
		processor.processBasic(path.newSubPath("exchangeDate"), String.class, getExchangeDate(), this);
		processRosetta(path.newSubPath("calculationAndTiming"), processor, CalculationAndTiming.class, getCalculationAndTiming());
		processRosetta(path.newSubPath("conditionsPrecedent"), processor, ConditionsPrecedent.class, getConditionsPrecedent());
		processRosetta(path.newSubPath("substitution"), processor, Substitution.class, getSubstitution());
		processRosetta(path.newSubPath("disputeResolution"), processor, DisputeResolution.class, getDisputeResolution());
		processRosetta(path.newSubPath("holdingAndUsingPostedCollateral"), processor, HoldingAndUsingPostedCollateral.class, getHoldingAndUsingPostedCollateral());
		processRosetta(path.newSubPath("rightsEvents"), processor, RightsEvents.class, getRightsEvents());
		processRosetta(path.newSubPath("custodyArrangements"), processor, CustodyArrangements.class, getCustodyArrangements());
		processRosetta(path.newSubPath("distributionAndInterestPayment"), processor, DistributionAndInterestPayment.class, getDistributionAndInterestPayment());
		processor.processBasic(path.newSubPath("creditSupportOffsets"), Boolean.class, getCreditSupportOffsets(), this);
		processRosetta(path.newSubPath("additionalRepresentations"), processor, AdditionalRepresentations.class, getAdditionalRepresentations());
		processRosetta(path.newSubPath("otherEligibleAndPostedSupport"), processor, OtherEligibleAndPostedSupport.class, getOtherEligibleAndPostedSupport());
		processRosetta(path.newSubPath("demandsAndNotices"), processor, ContactElection.class, getDemandsAndNotices());
		processRosetta(path.newSubPath("addressesForTransfer"), processor, ContactElection.class, getAddressesForTransfer());
		processRosetta(path.newSubPath("otherAgreements"), processor, OtherAgreements.class, getOtherAgreements());
		processRosetta(path.newSubPath("terminationCurrencyAmendment"), processor, TerminationCurrencyAmendment.class, getTerminationCurrencyAmendment());
		processRosetta(path.newSubPath("minimumTransferAmountAmendment"), processor, MinimumTransferAmountAmendment.class, getMinimumTransferAmountAmendment());
		processor.processBasic(path.newSubPath("interpretationTerms"), String.class, getInterpretationTerms(), this);
		processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.class, getProcessAgent());
		processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.class, getAppropriatedCollateralValuation());
		processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.class, getJurisdictionRelatedTerms());
		processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
		processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
		processor.processBasic(path.newSubPath("trustSchemeAddendum"), Boolean.class, getTrustSchemeAddendum(), this);
		processRosetta(path.newSubPath("securityInterestForObligations"), processor, SecurityInterestForObligations.class, getSecurityInterestForObligations());
		processRosetta(path.newSubPath("singlePostingParty"), processor, SinglePostingParty.class, getSinglePostingParty());
		processRosetta(path.newSubPath("datedAsOfDate"), processor, DatedAsOfDate.class, getDatedAsOfDate());
		processor.processBasic(path.newSubPath("cass"), String.class, getCass(), this);
		processor.processBasic(path.newSubPath("otherCSA"), String.class, getOtherCSA(), this);
		processor.processBasic(path.newSubPath("legacyAdditionalRepresentations"), String.class, getLegacyAdditionalRepresentations(), this);
		processRosetta(path.newSubPath("value"), processor, CollateralValueMethod.class, getValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAgreementElectionsBuilder extends CreditSupportAgreementElections, RosettaModelObjectBuilder {
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
		CoveredTransactions.CoveredTransactionsBuilder getOrCreateCoveredTransactions();
		@Override
		CoveredTransactions.CoveredTransactionsBuilder getCoveredTransactions();
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
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getOrCreateHoldingAndUsingPostedCollateral();
		@Override
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getHoldingAndUsingPostedCollateral();
		RightsEvents.RightsEventsBuilder getOrCreateRightsEvents();
		@Override
		RightsEvents.RightsEventsBuilder getRightsEvents();
		CustodyArrangements.CustodyArrangementsBuilder getOrCreateCustodyArrangements();
		@Override
		CustodyArrangements.CustodyArrangementsBuilder getCustodyArrangements();
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getOrCreateDistributionAndInterestPayment();
		@Override
		DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getDistributionAndInterestPayment();
		AdditionalRepresentations.AdditionalRepresentationsBuilder getOrCreateAdditionalRepresentations();
		@Override
		AdditionalRepresentations.AdditionalRepresentationsBuilder getAdditionalRepresentations();
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOrCreateOtherEligibleAndPostedSupport();
		@Override
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOtherEligibleAndPostedSupport();
		ContactElection.ContactElectionBuilder getOrCreateDemandsAndNotices();
		@Override
		ContactElection.ContactElectionBuilder getDemandsAndNotices();
		ContactElection.ContactElectionBuilder getOrCreateAddressesForTransfer();
		@Override
		ContactElection.ContactElectionBuilder getAddressesForTransfer();
		OtherAgreements.OtherAgreementsBuilder getOrCreateOtherAgreements();
		@Override
		OtherAgreements.OtherAgreementsBuilder getOtherAgreements();
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getOrCreateTerminationCurrencyAmendment();
		@Override
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder getTerminationCurrencyAmendment();
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getOrCreateMinimumTransferAmountAmendment();
		@Override
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder getMinimumTransferAmountAmendment();
		ProcessAgent.ProcessAgentBuilder getOrCreateProcessAgent();
		@Override
		ProcessAgent.ProcessAgentBuilder getProcessAgent();
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation();
		@Override
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getOrCreateJurisdictionRelatedTerms();
		@Override
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder getJurisdictionRelatedTerms();
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder getOrCreateSecurityInterestForObligations();
		@Override
		SecurityInterestForObligations.SecurityInterestForObligationsBuilder getSecurityInterestForObligations();
		SinglePostingParty.SinglePostingPartyBuilder getOrCreateSinglePostingParty();
		@Override
		SinglePostingParty.SinglePostingPartyBuilder getSinglePostingParty();
		DatedAsOfDate.DatedAsOfDateBuilder getOrCreateDatedAsOfDate();
		@Override
		DatedAsOfDate.DatedAsOfDateBuilder getDatedAsOfDate();
		CollateralValueMethod.CollateralValueMethodBuilder getOrCreateValue();
		@Override
		CollateralValueMethod.CollateralValueMethodBuilder getValue();
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRegime(Regime regime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOneWayProvisions(OneWayProvisions oneWayProvisions);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setGeneralSimmElections(GeneralSimmElections generalSimmElections);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setIdentifiedCrossCurrencySwap(Boolean identifiedCrossCurrencySwap);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSensitivityMethodologies(SensitivityMethodologies sensitivityMethodologies);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setFxHaircutCurrency(FxHaircutCurrency fxHaircutCurrency);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setPostingObligations(PostingObligations postingObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime substitutedRegime, int idx);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegime);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setBaseAndEligibleCurrency(BaseAndEligibleCurrency baseAndEligibleCurrency);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalObligations(String additionalObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCoveredTransactions(CoveredTransactions coveredTransactions);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportObligations(CreditSupportObligations creditSupportObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setExchangeDate(String exchangeDate);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCalculationAndTiming(CalculationAndTiming calculationAndTiming);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setConditionsPrecedent(ConditionsPrecedent conditionsPrecedent);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitution(Substitution substitution);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDisputeResolution(DisputeResolution disputeResolution);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setHoldingAndUsingPostedCollateral(HoldingAndUsingPostedCollateral holdingAndUsingPostedCollateral);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRightsEvents(RightsEvents rightsEvents);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCustodyArrangements(CustodyArrangements custodyArrangements);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDistributionAndInterestPayment(DistributionAndInterestPayment distributionAndInterestPayment);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportOffsets(Boolean creditSupportOffsets);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalRepresentations(AdditionalRepresentations additionalRepresentations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherEligibleAndPostedSupport(OtherEligibleAndPostedSupport otherEligibleAndPostedSupport);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDemandsAndNotices(ContactElection demandsAndNotices);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAddressesForTransfer(ContactElection addressesForTransfer);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherAgreements(OtherAgreements otherAgreements);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTerminationCurrencyAmendment(TerminationCurrencyAmendment terminationCurrencyAmendment);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setMinimumTransferAmountAmendment(MinimumTransferAmountAmendment minimumTransferAmountAmendment);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setInterpretationTerms(String interpretationTerms);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setProcessAgent(ProcessAgent processAgent);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation appropriatedCollateralValuation);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms jurisdictionRelatedTerms);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalAmendments(String additionalAmendments);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalBespokeTerms(String additionalBespokeTerms);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTrustSchemeAddendum(Boolean trustSchemeAddendum);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSecurityInterestForObligations(SecurityInterestForObligations securityInterestForObligations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSinglePostingParty(SinglePostingParty singlePostingParty);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDatedAsOfDate(DatedAsOfDate datedAsOfDate);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCass(String cass);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherCSA(String otherCSA);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setLegacyAdditionalRepresentations(String legacyAdditionalRepresentations);
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setValue(CollateralValueMethod value);

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
			processor.processBasic(path.newSubPath("additionalObligations"), String.class, getAdditionalObligations(), this);
			processRosetta(path.newSubPath("coveredTransactions"), processor, CoveredTransactions.CoveredTransactionsBuilder.class, getCoveredTransactions());
			processRosetta(path.newSubPath("creditSupportObligations"), processor, CreditSupportObligations.CreditSupportObligationsBuilder.class, getCreditSupportObligations());
			processor.processBasic(path.newSubPath("exchangeDate"), String.class, getExchangeDate(), this);
			processRosetta(path.newSubPath("calculationAndTiming"), processor, CalculationAndTiming.CalculationAndTimingBuilder.class, getCalculationAndTiming());
			processRosetta(path.newSubPath("conditionsPrecedent"), processor, ConditionsPrecedent.ConditionsPrecedentBuilder.class, getConditionsPrecedent());
			processRosetta(path.newSubPath("substitution"), processor, Substitution.SubstitutionBuilder.class, getSubstitution());
			processRosetta(path.newSubPath("disputeResolution"), processor, DisputeResolution.DisputeResolutionBuilder.class, getDisputeResolution());
			processRosetta(path.newSubPath("holdingAndUsingPostedCollateral"), processor, HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder.class, getHoldingAndUsingPostedCollateral());
			processRosetta(path.newSubPath("rightsEvents"), processor, RightsEvents.RightsEventsBuilder.class, getRightsEvents());
			processRosetta(path.newSubPath("custodyArrangements"), processor, CustodyArrangements.CustodyArrangementsBuilder.class, getCustodyArrangements());
			processRosetta(path.newSubPath("distributionAndInterestPayment"), processor, DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder.class, getDistributionAndInterestPayment());
			processor.processBasic(path.newSubPath("creditSupportOffsets"), Boolean.class, getCreditSupportOffsets(), this);
			processRosetta(path.newSubPath("additionalRepresentations"), processor, AdditionalRepresentations.AdditionalRepresentationsBuilder.class, getAdditionalRepresentations());
			processRosetta(path.newSubPath("otherEligibleAndPostedSupport"), processor, OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder.class, getOtherEligibleAndPostedSupport());
			processRosetta(path.newSubPath("demandsAndNotices"), processor, ContactElection.ContactElectionBuilder.class, getDemandsAndNotices());
			processRosetta(path.newSubPath("addressesForTransfer"), processor, ContactElection.ContactElectionBuilder.class, getAddressesForTransfer());
			processRosetta(path.newSubPath("otherAgreements"), processor, OtherAgreements.OtherAgreementsBuilder.class, getOtherAgreements());
			processRosetta(path.newSubPath("terminationCurrencyAmendment"), processor, TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder.class, getTerminationCurrencyAmendment());
			processRosetta(path.newSubPath("minimumTransferAmountAmendment"), processor, MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder.class, getMinimumTransferAmountAmendment());
			processor.processBasic(path.newSubPath("interpretationTerms"), String.class, getInterpretationTerms(), this);
			processRosetta(path.newSubPath("processAgent"), processor, ProcessAgent.ProcessAgentBuilder.class, getProcessAgent());
			processRosetta(path.newSubPath("appropriatedCollateralValuation"), processor, AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder.class, getAppropriatedCollateralValuation());
			processRosetta(path.newSubPath("jurisdictionRelatedTerms"), processor, JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder.class, getJurisdictionRelatedTerms());
			processor.processBasic(path.newSubPath("additionalAmendments"), String.class, getAdditionalAmendments(), this);
			processor.processBasic(path.newSubPath("additionalBespokeTerms"), String.class, getAdditionalBespokeTerms(), this);
			processor.processBasic(path.newSubPath("trustSchemeAddendum"), Boolean.class, getTrustSchemeAddendum(), this);
			processRosetta(path.newSubPath("securityInterestForObligations"), processor, SecurityInterestForObligations.SecurityInterestForObligationsBuilder.class, getSecurityInterestForObligations());
			processRosetta(path.newSubPath("singlePostingParty"), processor, SinglePostingParty.SinglePostingPartyBuilder.class, getSinglePostingParty());
			processRosetta(path.newSubPath("datedAsOfDate"), processor, DatedAsOfDate.DatedAsOfDateBuilder.class, getDatedAsOfDate());
			processor.processBasic(path.newSubPath("cass"), String.class, getCass(), this);
			processor.processBasic(path.newSubPath("otherCSA"), String.class, getOtherCSA(), this);
			processor.processBasic(path.newSubPath("legacyAdditionalRepresentations"), String.class, getLegacyAdditionalRepresentations(), this);
			processRosetta(path.newSubPath("value"), processor, CollateralValueMethod.CollateralValueMethodBuilder.class, getValue());
		}
		

		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAgreementElections  ***********************/
	class CreditSupportAgreementElectionsImpl implements CreditSupportAgreementElections {
		private final Regime regime;
		private final OneWayProvisions oneWayProvisions;
		private final GeneralSimmElections generalSimmElections;
		private final Boolean identifiedCrossCurrencySwap;
		private final SensitivityMethodologies sensitivityMethodologies;
		private final FxHaircutCurrency fxHaircutCurrency;
		private final PostingObligations postingObligations;
		private final List<? extends SubstitutedRegime> substitutedRegime;
		private final BaseAndEligibleCurrency baseAndEligibleCurrency;
		private final String additionalObligations;
		private final CoveredTransactions coveredTransactions;
		private final CreditSupportObligations creditSupportObligations;
		private final String exchangeDate;
		private final CalculationAndTiming calculationAndTiming;
		private final ConditionsPrecedent conditionsPrecedent;
		private final Substitution substitution;
		private final DisputeResolution disputeResolution;
		private final HoldingAndUsingPostedCollateral holdingAndUsingPostedCollateral;
		private final RightsEvents rightsEvents;
		private final CustodyArrangements custodyArrangements;
		private final DistributionAndInterestPayment distributionAndInterestPayment;
		private final Boolean creditSupportOffsets;
		private final AdditionalRepresentations additionalRepresentations;
		private final OtherEligibleAndPostedSupport otherEligibleAndPostedSupport;
		private final ContactElection demandsAndNotices;
		private final ContactElection addressesForTransfer;
		private final OtherAgreements otherAgreements;
		private final TerminationCurrencyAmendment terminationCurrencyAmendment;
		private final MinimumTransferAmountAmendment minimumTransferAmountAmendment;
		private final String interpretationTerms;
		private final ProcessAgent processAgent;
		private final AppropriatedCollateralValuation appropriatedCollateralValuation;
		private final JurisdictionRelatedTerms jurisdictionRelatedTerms;
		private final String additionalAmendments;
		private final String additionalBespokeTerms;
		private final Boolean trustSchemeAddendum;
		private final SecurityInterestForObligations securityInterestForObligations;
		private final SinglePostingParty singlePostingParty;
		private final DatedAsOfDate datedAsOfDate;
		private final String cass;
		private final String otherCSA;
		private final String legacyAdditionalRepresentations;
		private final CollateralValueMethod value;
		
		protected CreditSupportAgreementElectionsImpl(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder) {
			this.regime = ofNullable(builder.getRegime()).map(f->f.build()).orElse(null);
			this.oneWayProvisions = ofNullable(builder.getOneWayProvisions()).map(f->f.build()).orElse(null);
			this.generalSimmElections = ofNullable(builder.getGeneralSimmElections()).map(f->f.build()).orElse(null);
			this.identifiedCrossCurrencySwap = builder.getIdentifiedCrossCurrencySwap();
			this.sensitivityMethodologies = ofNullable(builder.getSensitivityMethodologies()).map(f->f.build()).orElse(null);
			this.fxHaircutCurrency = ofNullable(builder.getFxHaircutCurrency()).map(f->f.build()).orElse(null);
			this.postingObligations = ofNullable(builder.getPostingObligations()).map(f->f.build()).orElse(null);
			this.substitutedRegime = ofNullable(builder.getSubstitutedRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.baseAndEligibleCurrency = ofNullable(builder.getBaseAndEligibleCurrency()).map(f->f.build()).orElse(null);
			this.additionalObligations = builder.getAdditionalObligations();
			this.coveredTransactions = ofNullable(builder.getCoveredTransactions()).map(f->f.build()).orElse(null);
			this.creditSupportObligations = ofNullable(builder.getCreditSupportObligations()).map(f->f.build()).orElse(null);
			this.exchangeDate = builder.getExchangeDate();
			this.calculationAndTiming = ofNullable(builder.getCalculationAndTiming()).map(f->f.build()).orElse(null);
			this.conditionsPrecedent = ofNullable(builder.getConditionsPrecedent()).map(f->f.build()).orElse(null);
			this.substitution = ofNullable(builder.getSubstitution()).map(f->f.build()).orElse(null);
			this.disputeResolution = ofNullable(builder.getDisputeResolution()).map(f->f.build()).orElse(null);
			this.holdingAndUsingPostedCollateral = ofNullable(builder.getHoldingAndUsingPostedCollateral()).map(f->f.build()).orElse(null);
			this.rightsEvents = ofNullable(builder.getRightsEvents()).map(f->f.build()).orElse(null);
			this.custodyArrangements = ofNullable(builder.getCustodyArrangements()).map(f->f.build()).orElse(null);
			this.distributionAndInterestPayment = ofNullable(builder.getDistributionAndInterestPayment()).map(f->f.build()).orElse(null);
			this.creditSupportOffsets = builder.getCreditSupportOffsets();
			this.additionalRepresentations = ofNullable(builder.getAdditionalRepresentations()).map(f->f.build()).orElse(null);
			this.otherEligibleAndPostedSupport = ofNullable(builder.getOtherEligibleAndPostedSupport()).map(f->f.build()).orElse(null);
			this.demandsAndNotices = ofNullable(builder.getDemandsAndNotices()).map(f->f.build()).orElse(null);
			this.addressesForTransfer = ofNullable(builder.getAddressesForTransfer()).map(f->f.build()).orElse(null);
			this.otherAgreements = ofNullable(builder.getOtherAgreements()).map(f->f.build()).orElse(null);
			this.terminationCurrencyAmendment = ofNullable(builder.getTerminationCurrencyAmendment()).map(f->f.build()).orElse(null);
			this.minimumTransferAmountAmendment = ofNullable(builder.getMinimumTransferAmountAmendment()).map(f->f.build()).orElse(null);
			this.interpretationTerms = builder.getInterpretationTerms();
			this.processAgent = ofNullable(builder.getProcessAgent()).map(f->f.build()).orElse(null);
			this.appropriatedCollateralValuation = ofNullable(builder.getAppropriatedCollateralValuation()).map(f->f.build()).orElse(null);
			this.jurisdictionRelatedTerms = ofNullable(builder.getJurisdictionRelatedTerms()).map(f->f.build()).orElse(null);
			this.additionalAmendments = builder.getAdditionalAmendments();
			this.additionalBespokeTerms = builder.getAdditionalBespokeTerms();
			this.trustSchemeAddendum = builder.getTrustSchemeAddendum();
			this.securityInterestForObligations = ofNullable(builder.getSecurityInterestForObligations()).map(f->f.build()).orElse(null);
			this.singlePostingParty = ofNullable(builder.getSinglePostingParty()).map(f->f.build()).orElse(null);
			this.datedAsOfDate = ofNullable(builder.getDatedAsOfDate()).map(f->f.build()).orElse(null);
			this.cass = builder.getCass();
			this.otherCSA = builder.getOtherCSA();
			this.legacyAdditionalRepresentations = builder.getLegacyAdditionalRepresentations();
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalObligations")
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coveredTransactions")
		public CoveredTransactions getCoveredTransactions() {
			return coveredTransactions;
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
		@RosettaAttribute("exchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeDate")
		public String getExchangeDate() {
			return exchangeDate;
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
		@RuneAttribute("conditionsPrecedent")
		public ConditionsPrecedent getConditionsPrecedent() {
			return conditionsPrecedent;
		}
		
		@Override
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("holdingAndUsingPostedCollateral")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("holdingAndUsingPostedCollateral")
		public HoldingAndUsingPostedCollateral getHoldingAndUsingPostedCollateral() {
			return holdingAndUsingPostedCollateral;
		}
		
		@Override
		@RosettaAttribute("rightsEvents")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rightsEvents")
		public RightsEvents getRightsEvents() {
			return rightsEvents;
		}
		
		@Override
		@RosettaAttribute("custodyArrangements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("custodyArrangements")
		public CustodyArrangements getCustodyArrangements() {
			return custodyArrangements;
		}
		
		@Override
		@RosettaAttribute("distributionAndInterestPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("distributionAndInterestPayment")
		public DistributionAndInterestPayment getDistributionAndInterestPayment() {
			return distributionAndInterestPayment;
		}
		
		@Override
		@RosettaAttribute("creditSupportOffsets")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportOffsets")
		public Boolean getCreditSupportOffsets() {
			return creditSupportOffsets;
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
		@RosettaAttribute("otherEligibleAndPostedSupport")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("otherEligibleAndPostedSupport")
		public OtherEligibleAndPostedSupport getOtherEligibleAndPostedSupport() {
			return otherEligibleAndPostedSupport;
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
		@RosettaAttribute("otherAgreements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherAgreements")
		public OtherAgreements getOtherAgreements() {
			return otherAgreements;
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
		@Required
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
		@RosettaAttribute("appropriatedCollateralValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("appropriatedCollateralValuation")
		public AppropriatedCollateralValuation getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
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
		@RosettaAttribute("trustSchemeAddendum")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trustSchemeAddendum")
		public Boolean getTrustSchemeAddendum() {
			return trustSchemeAddendum;
		}
		
		@Override
		@RosettaAttribute("securityInterestForObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("securityInterestForObligations")
		public SecurityInterestForObligations getSecurityInterestForObligations() {
			return securityInterestForObligations;
		}
		
		@Override
		@RosettaAttribute("singlePostingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("singlePostingParty")
		public SinglePostingParty getSinglePostingParty() {
			return singlePostingParty;
		}
		
		@Override
		@RosettaAttribute("datedAsOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("datedAsOfDate")
		public DatedAsOfDate getDatedAsOfDate() {
			return datedAsOfDate;
		}
		
		@Override
		@RosettaAttribute("cass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cass")
		public String getCass() {
			return cass;
		}
		
		@Override
		@RosettaAttribute("otherCSA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCSA")
		public String getOtherCSA() {
			return otherCSA;
		}
		
		@Override
		@RosettaAttribute("legacyAdditionalRepresentations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyAdditionalRepresentations")
		public String getLegacyAdditionalRepresentations() {
			return legacyAdditionalRepresentations;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public CollateralValueMethod getValue() {
			return value;
		}
		
		@Override
		public CreditSupportAgreementElections build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder() {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder builder) {
			ofNullable(getRegime()).ifPresent(builder::setRegime);
			ofNullable(getOneWayProvisions()).ifPresent(builder::setOneWayProvisions);
			ofNullable(getGeneralSimmElections()).ifPresent(builder::setGeneralSimmElections);
			ofNullable(getIdentifiedCrossCurrencySwap()).ifPresent(builder::setIdentifiedCrossCurrencySwap);
			ofNullable(getSensitivityMethodologies()).ifPresent(builder::setSensitivityMethodologies);
			ofNullable(getFxHaircutCurrency()).ifPresent(builder::setFxHaircutCurrency);
			ofNullable(getPostingObligations()).ifPresent(builder::setPostingObligations);
			ofNullable(getSubstitutedRegime()).ifPresent(builder::setSubstitutedRegime);
			ofNullable(getBaseAndEligibleCurrency()).ifPresent(builder::setBaseAndEligibleCurrency);
			ofNullable(getAdditionalObligations()).ifPresent(builder::setAdditionalObligations);
			ofNullable(getCoveredTransactions()).ifPresent(builder::setCoveredTransactions);
			ofNullable(getCreditSupportObligations()).ifPresent(builder::setCreditSupportObligations);
			ofNullable(getExchangeDate()).ifPresent(builder::setExchangeDate);
			ofNullable(getCalculationAndTiming()).ifPresent(builder::setCalculationAndTiming);
			ofNullable(getConditionsPrecedent()).ifPresent(builder::setConditionsPrecedent);
			ofNullable(getSubstitution()).ifPresent(builder::setSubstitution);
			ofNullable(getDisputeResolution()).ifPresent(builder::setDisputeResolution);
			ofNullable(getHoldingAndUsingPostedCollateral()).ifPresent(builder::setHoldingAndUsingPostedCollateral);
			ofNullable(getRightsEvents()).ifPresent(builder::setRightsEvents);
			ofNullable(getCustodyArrangements()).ifPresent(builder::setCustodyArrangements);
			ofNullable(getDistributionAndInterestPayment()).ifPresent(builder::setDistributionAndInterestPayment);
			ofNullable(getCreditSupportOffsets()).ifPresent(builder::setCreditSupportOffsets);
			ofNullable(getAdditionalRepresentations()).ifPresent(builder::setAdditionalRepresentations);
			ofNullable(getOtherEligibleAndPostedSupport()).ifPresent(builder::setOtherEligibleAndPostedSupport);
			ofNullable(getDemandsAndNotices()).ifPresent(builder::setDemandsAndNotices);
			ofNullable(getAddressesForTransfer()).ifPresent(builder::setAddressesForTransfer);
			ofNullable(getOtherAgreements()).ifPresent(builder::setOtherAgreements);
			ofNullable(getTerminationCurrencyAmendment()).ifPresent(builder::setTerminationCurrencyAmendment);
			ofNullable(getMinimumTransferAmountAmendment()).ifPresent(builder::setMinimumTransferAmountAmendment);
			ofNullable(getInterpretationTerms()).ifPresent(builder::setInterpretationTerms);
			ofNullable(getProcessAgent()).ifPresent(builder::setProcessAgent);
			ofNullable(getAppropriatedCollateralValuation()).ifPresent(builder::setAppropriatedCollateralValuation);
			ofNullable(getJurisdictionRelatedTerms()).ifPresent(builder::setJurisdictionRelatedTerms);
			ofNullable(getAdditionalAmendments()).ifPresent(builder::setAdditionalAmendments);
			ofNullable(getAdditionalBespokeTerms()).ifPresent(builder::setAdditionalBespokeTerms);
			ofNullable(getTrustSchemeAddendum()).ifPresent(builder::setTrustSchemeAddendum);
			ofNullable(getSecurityInterestForObligations()).ifPresent(builder::setSecurityInterestForObligations);
			ofNullable(getSinglePostingParty()).ifPresent(builder::setSinglePostingParty);
			ofNullable(getDatedAsOfDate()).ifPresent(builder::setDatedAsOfDate);
			ofNullable(getCass()).ifPresent(builder::setCass);
			ofNullable(getOtherCSA()).ifPresent(builder::setOtherCSA);
			ofNullable(getLegacyAdditionalRepresentations()).ifPresent(builder::setLegacyAdditionalRepresentations);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(oneWayProvisions, _that.getOneWayProvisions())) return false;
			if (!Objects.equals(generalSimmElections, _that.getGeneralSimmElections())) return false;
			if (!Objects.equals(identifiedCrossCurrencySwap, _that.getIdentifiedCrossCurrencySwap())) return false;
			if (!Objects.equals(sensitivityMethodologies, _that.getSensitivityMethodologies())) return false;
			if (!Objects.equals(fxHaircutCurrency, _that.getFxHaircutCurrency())) return false;
			if (!Objects.equals(postingObligations, _that.getPostingObligations())) return false;
			if (!ListEquals.listEquals(substitutedRegime, _that.getSubstitutedRegime())) return false;
			if (!Objects.equals(baseAndEligibleCurrency, _that.getBaseAndEligibleCurrency())) return false;
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!Objects.equals(creditSupportObligations, _that.getCreditSupportObligations())) return false;
			if (!Objects.equals(exchangeDate, _that.getExchangeDate())) return false;
			if (!Objects.equals(calculationAndTiming, _that.getCalculationAndTiming())) return false;
			if (!Objects.equals(conditionsPrecedent, _that.getConditionsPrecedent())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(disputeResolution, _that.getDisputeResolution())) return false;
			if (!Objects.equals(holdingAndUsingPostedCollateral, _that.getHoldingAndUsingPostedCollateral())) return false;
			if (!Objects.equals(rightsEvents, _that.getRightsEvents())) return false;
			if (!Objects.equals(custodyArrangements, _that.getCustodyArrangements())) return false;
			if (!Objects.equals(distributionAndInterestPayment, _that.getDistributionAndInterestPayment())) return false;
			if (!Objects.equals(creditSupportOffsets, _that.getCreditSupportOffsets())) return false;
			if (!Objects.equals(additionalRepresentations, _that.getAdditionalRepresentations())) return false;
			if (!Objects.equals(otherEligibleAndPostedSupport, _that.getOtherEligibleAndPostedSupport())) return false;
			if (!Objects.equals(demandsAndNotices, _that.getDemandsAndNotices())) return false;
			if (!Objects.equals(addressesForTransfer, _that.getAddressesForTransfer())) return false;
			if (!Objects.equals(otherAgreements, _that.getOtherAgreements())) return false;
			if (!Objects.equals(terminationCurrencyAmendment, _that.getTerminationCurrencyAmendment())) return false;
			if (!Objects.equals(minimumTransferAmountAmendment, _that.getMinimumTransferAmountAmendment())) return false;
			if (!Objects.equals(interpretationTerms, _that.getInterpretationTerms())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(trustSchemeAddendum, _that.getTrustSchemeAddendum())) return false;
			if (!Objects.equals(securityInterestForObligations, _that.getSecurityInterestForObligations())) return false;
			if (!Objects.equals(singlePostingParty, _that.getSinglePostingParty())) return false;
			if (!Objects.equals(datedAsOfDate, _that.getDatedAsOfDate())) return false;
			if (!Objects.equals(cass, _that.getCass())) return false;
			if (!Objects.equals(otherCSA, _that.getOtherCSA())) return false;
			if (!Objects.equals(legacyAdditionalRepresentations, _that.getLegacyAdditionalRepresentations())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
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
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligations != null ? creditSupportObligations.hashCode() : 0);
			_result = 31 * _result + (exchangeDate != null ? exchangeDate.hashCode() : 0);
			_result = 31 * _result + (calculationAndTiming != null ? calculationAndTiming.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedent != null ? conditionsPrecedent.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (disputeResolution != null ? disputeResolution.hashCode() : 0);
			_result = 31 * _result + (holdingAndUsingPostedCollateral != null ? holdingAndUsingPostedCollateral.hashCode() : 0);
			_result = 31 * _result + (rightsEvents != null ? rightsEvents.hashCode() : 0);
			_result = 31 * _result + (custodyArrangements != null ? custodyArrangements.hashCode() : 0);
			_result = 31 * _result + (distributionAndInterestPayment != null ? distributionAndInterestPayment.hashCode() : 0);
			_result = 31 * _result + (creditSupportOffsets != null ? creditSupportOffsets.hashCode() : 0);
			_result = 31 * _result + (additionalRepresentations != null ? additionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (otherEligibleAndPostedSupport != null ? otherEligibleAndPostedSupport.hashCode() : 0);
			_result = 31 * _result + (demandsAndNotices != null ? demandsAndNotices.hashCode() : 0);
			_result = 31 * _result + (addressesForTransfer != null ? addressesForTransfer.hashCode() : 0);
			_result = 31 * _result + (otherAgreements != null ? otherAgreements.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyAmendment != null ? terminationCurrencyAmendment.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmountAmendment != null ? minimumTransferAmountAmendment.hashCode() : 0);
			_result = 31 * _result + (interpretationTerms != null ? interpretationTerms.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (trustSchemeAddendum != null ? trustSchemeAddendum.hashCode() : 0);
			_result = 31 * _result + (securityInterestForObligations != null ? securityInterestForObligations.hashCode() : 0);
			_result = 31 * _result + (singlePostingParty != null ? singlePostingParty.hashCode() : 0);
			_result = 31 * _result + (datedAsOfDate != null ? datedAsOfDate.hashCode() : 0);
			_result = 31 * _result + (cass != null ? cass.hashCode() : 0);
			_result = 31 * _result + (otherCSA != null ? otherCSA.hashCode() : 0);
			_result = 31 * _result + (legacyAdditionalRepresentations != null ? legacyAdditionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementElections {" +
				"regime=" + this.regime + ", " +
				"oneWayProvisions=" + this.oneWayProvisions + ", " +
				"generalSimmElections=" + this.generalSimmElections + ", " +
				"identifiedCrossCurrencySwap=" + this.identifiedCrossCurrencySwap + ", " +
				"sensitivityMethodologies=" + this.sensitivityMethodologies + ", " +
				"fxHaircutCurrency=" + this.fxHaircutCurrency + ", " +
				"postingObligations=" + this.postingObligations + ", " +
				"substitutedRegime=" + this.substitutedRegime + ", " +
				"baseAndEligibleCurrency=" + this.baseAndEligibleCurrency + ", " +
				"additionalObligations=" + this.additionalObligations + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"creditSupportObligations=" + this.creditSupportObligations + ", " +
				"exchangeDate=" + this.exchangeDate + ", " +
				"calculationAndTiming=" + this.calculationAndTiming + ", " +
				"conditionsPrecedent=" + this.conditionsPrecedent + ", " +
				"substitution=" + this.substitution + ", " +
				"disputeResolution=" + this.disputeResolution + ", " +
				"holdingAndUsingPostedCollateral=" + this.holdingAndUsingPostedCollateral + ", " +
				"rightsEvents=" + this.rightsEvents + ", " +
				"custodyArrangements=" + this.custodyArrangements + ", " +
				"distributionAndInterestPayment=" + this.distributionAndInterestPayment + ", " +
				"creditSupportOffsets=" + this.creditSupportOffsets + ", " +
				"additionalRepresentations=" + this.additionalRepresentations + ", " +
				"otherEligibleAndPostedSupport=" + this.otherEligibleAndPostedSupport + ", " +
				"demandsAndNotices=" + this.demandsAndNotices + ", " +
				"addressesForTransfer=" + this.addressesForTransfer + ", " +
				"otherAgreements=" + this.otherAgreements + ", " +
				"terminationCurrencyAmendment=" + this.terminationCurrencyAmendment + ", " +
				"minimumTransferAmountAmendment=" + this.minimumTransferAmountAmendment + ", " +
				"interpretationTerms=" + this.interpretationTerms + ", " +
				"processAgent=" + this.processAgent + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"trustSchemeAddendum=" + this.trustSchemeAddendum + ", " +
				"securityInterestForObligations=" + this.securityInterestForObligations + ", " +
				"singlePostingParty=" + this.singlePostingParty + ", " +
				"datedAsOfDate=" + this.datedAsOfDate + ", " +
				"cass=" + this.cass + ", " +
				"otherCSA=" + this.otherCSA + ", " +
				"legacyAdditionalRepresentations=" + this.legacyAdditionalRepresentations + ", " +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAgreementElections  ***********************/
	class CreditSupportAgreementElectionsBuilderImpl implements CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder {
	
		protected Regime.RegimeBuilder regime;
		protected OneWayProvisions.OneWayProvisionsBuilder oneWayProvisions;
		protected GeneralSimmElections.GeneralSimmElectionsBuilder generalSimmElections;
		protected Boolean identifiedCrossCurrencySwap;
		protected SensitivityMethodologies.SensitivityMethodologiesBuilder sensitivityMethodologies;
		protected FxHaircutCurrency.FxHaircutCurrencyBuilder fxHaircutCurrency;
		protected PostingObligations.PostingObligationsBuilder postingObligations;
		protected List<SubstitutedRegime.SubstitutedRegimeBuilder> substitutedRegime = new ArrayList<>();
		protected BaseAndEligibleCurrency.BaseAndEligibleCurrencyBuilder baseAndEligibleCurrency;
		protected String additionalObligations;
		protected CoveredTransactions.CoveredTransactionsBuilder coveredTransactions;
		protected CreditSupportObligations.CreditSupportObligationsBuilder creditSupportObligations;
		protected String exchangeDate;
		protected CalculationAndTiming.CalculationAndTimingBuilder calculationAndTiming;
		protected ConditionsPrecedent.ConditionsPrecedentBuilder conditionsPrecedent;
		protected Substitution.SubstitutionBuilder substitution;
		protected DisputeResolution.DisputeResolutionBuilder disputeResolution;
		protected HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder holdingAndUsingPostedCollateral;
		protected RightsEvents.RightsEventsBuilder rightsEvents;
		protected CustodyArrangements.CustodyArrangementsBuilder custodyArrangements;
		protected DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder distributionAndInterestPayment;
		protected Boolean creditSupportOffsets;
		protected AdditionalRepresentations.AdditionalRepresentationsBuilder additionalRepresentations;
		protected OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder otherEligibleAndPostedSupport;
		protected ContactElection.ContactElectionBuilder demandsAndNotices;
		protected ContactElection.ContactElectionBuilder addressesForTransfer;
		protected OtherAgreements.OtherAgreementsBuilder otherAgreements;
		protected TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder terminationCurrencyAmendment;
		protected MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder minimumTransferAmountAmendment;
		protected String interpretationTerms;
		protected ProcessAgent.ProcessAgentBuilder processAgent;
		protected AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder appropriatedCollateralValuation;
		protected JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder jurisdictionRelatedTerms;
		protected String additionalAmendments;
		protected String additionalBespokeTerms;
		protected Boolean trustSchemeAddendum;
		protected SecurityInterestForObligations.SecurityInterestForObligationsBuilder securityInterestForObligations;
		protected SinglePostingParty.SinglePostingPartyBuilder singlePostingParty;
		protected DatedAsOfDate.DatedAsOfDateBuilder datedAsOfDate;
		protected String cass;
		protected String otherCSA;
		protected String legacyAdditionalRepresentations;
		protected CollateralValueMethod.CollateralValueMethodBuilder value;
		
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
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalObligations")
		public String getAdditionalObligations() {
			return additionalObligations;
		}
		
		@Override
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("coveredTransactions")
		public CoveredTransactions.CoveredTransactionsBuilder getCoveredTransactions() {
			return coveredTransactions;
		}
		
		@Override
		public CoveredTransactions.CoveredTransactionsBuilder getOrCreateCoveredTransactions() {
			CoveredTransactions.CoveredTransactionsBuilder result;
			if (coveredTransactions!=null) {
				result = coveredTransactions;
			}
			else {
				result = coveredTransactions = CoveredTransactions.builder();
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
		@RosettaAttribute("exchangeDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeDate")
		public String getExchangeDate() {
			return exchangeDate;
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
		@Required
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
		@RosettaAttribute("holdingAndUsingPostedCollateral")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("holdingAndUsingPostedCollateral")
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getHoldingAndUsingPostedCollateral() {
			return holdingAndUsingPostedCollateral;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder getOrCreateHoldingAndUsingPostedCollateral() {
			HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder result;
			if (holdingAndUsingPostedCollateral!=null) {
				result = holdingAndUsingPostedCollateral;
			}
			else {
				result = holdingAndUsingPostedCollateral = HoldingAndUsingPostedCollateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rightsEvents")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("distributionAndInterestPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("distributionAndInterestPayment")
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getDistributionAndInterestPayment() {
			return distributionAndInterestPayment;
		}
		
		@Override
		public DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder getOrCreateDistributionAndInterestPayment() {
			DistributionAndInterestPayment.DistributionAndInterestPaymentBuilder result;
			if (distributionAndInterestPayment!=null) {
				result = distributionAndInterestPayment;
			}
			else {
				result = distributionAndInterestPayment = DistributionAndInterestPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportOffsets")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportOffsets")
		public Boolean getCreditSupportOffsets() {
			return creditSupportOffsets;
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
		@RosettaAttribute("otherEligibleAndPostedSupport")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("otherEligibleAndPostedSupport")
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOtherEligibleAndPostedSupport() {
			return otherEligibleAndPostedSupport;
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder getOrCreateOtherEligibleAndPostedSupport() {
			OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder result;
			if (otherEligibleAndPostedSupport!=null) {
				result = otherEligibleAndPostedSupport;
			}
			else {
				result = otherEligibleAndPostedSupport = OtherEligibleAndPostedSupport.builder();
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
		@RosettaAttribute("otherAgreements")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherAgreements")
		public OtherAgreements.OtherAgreementsBuilder getOtherAgreements() {
			return otherAgreements;
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder getOrCreateOtherAgreements() {
			OtherAgreements.OtherAgreementsBuilder result;
			if (otherAgreements!=null) {
				result = otherAgreements;
			}
			else {
				result = otherAgreements = OtherAgreements.builder();
			}
			
			return result;
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
		@Required
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
		@RosettaAttribute("appropriatedCollateralValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("appropriatedCollateralValuation")
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getAppropriatedCollateralValuation() {
			return appropriatedCollateralValuation;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder getOrCreateAppropriatedCollateralValuation() {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder result;
			if (appropriatedCollateralValuation!=null) {
				result = appropriatedCollateralValuation;
			}
			else {
				result = appropriatedCollateralValuation = AppropriatedCollateralValuation.builder();
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
		@RosettaAttribute("trustSchemeAddendum")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trustSchemeAddendum")
		public Boolean getTrustSchemeAddendum() {
			return trustSchemeAddendum;
		}
		
		@Override
		@RosettaAttribute("securityInterestForObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("securityInterestForObligations")
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder getSecurityInterestForObligations() {
			return securityInterestForObligations;
		}
		
		@Override
		public SecurityInterestForObligations.SecurityInterestForObligationsBuilder getOrCreateSecurityInterestForObligations() {
			SecurityInterestForObligations.SecurityInterestForObligationsBuilder result;
			if (securityInterestForObligations!=null) {
				result = securityInterestForObligations;
			}
			else {
				result = securityInterestForObligations = SecurityInterestForObligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("singlePostingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("singlePostingParty")
		public SinglePostingParty.SinglePostingPartyBuilder getSinglePostingParty() {
			return singlePostingParty;
		}
		
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder getOrCreateSinglePostingParty() {
			SinglePostingParty.SinglePostingPartyBuilder result;
			if (singlePostingParty!=null) {
				result = singlePostingParty;
			}
			else {
				result = singlePostingParty = SinglePostingParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("datedAsOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("datedAsOfDate")
		public DatedAsOfDate.DatedAsOfDateBuilder getDatedAsOfDate() {
			return datedAsOfDate;
		}
		
		@Override
		public DatedAsOfDate.DatedAsOfDateBuilder getOrCreateDatedAsOfDate() {
			DatedAsOfDate.DatedAsOfDateBuilder result;
			if (datedAsOfDate!=null) {
				result = datedAsOfDate;
			}
			else {
				result = datedAsOfDate = DatedAsOfDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cass")
		public String getCass() {
			return cass;
		}
		
		@Override
		@RosettaAttribute("otherCSA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherCSA")
		public String getOtherCSA() {
			return otherCSA;
		}
		
		@Override
		@RosettaAttribute("legacyAdditionalRepresentations")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyAdditionalRepresentations")
		public String getLegacyAdditionalRepresentations() {
			return legacyAdditionalRepresentations;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public CollateralValueMethod.CollateralValueMethodBuilder getValue() {
			return value;
		}
		
		@Override
		public CollateralValueMethod.CollateralValueMethodBuilder getOrCreateValue() {
			CollateralValueMethod.CollateralValueMethodBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = CollateralValueMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("regime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("regime")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRegime(Regime _regime) {
			this.regime = _regime == null ? null : _regime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oneWayProvisions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("oneWayProvisions")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOneWayProvisions(OneWayProvisions _oneWayProvisions) {
			this.oneWayProvisions = _oneWayProvisions == null ? null : _oneWayProvisions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("generalSimmElections")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generalSimmElections")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setGeneralSimmElections(GeneralSimmElections _generalSimmElections) {
			this.generalSimmElections = _generalSimmElections == null ? null : _generalSimmElections.toBuilder();
			return this;
		}
		
		@RosettaAttribute("identifiedCrossCurrencySwap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifiedCrossCurrencySwap")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setIdentifiedCrossCurrencySwap(Boolean _identifiedCrossCurrencySwap) {
			this.identifiedCrossCurrencySwap = _identifiedCrossCurrencySwap == null ? null : _identifiedCrossCurrencySwap;
			return this;
		}
		
		@RosettaAttribute("sensitivityMethodologies")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sensitivityMethodologies")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSensitivityMethodologies(SensitivityMethodologies _sensitivityMethodologies) {
			this.sensitivityMethodologies = _sensitivityMethodologies == null ? null : _sensitivityMethodologies.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fxHaircutCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxHaircutCurrency")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setFxHaircutCurrency(FxHaircutCurrency _fxHaircutCurrency) {
			this.fxHaircutCurrency = _fxHaircutCurrency == null ? null : _fxHaircutCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postingObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("postingObligations")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setPostingObligations(PostingObligations _postingObligations) {
			this.postingObligations = _postingObligations == null ? null : _postingObligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("substitutedRegime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("substitutedRegime")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime _substitutedRegime) {
			if (_substitutedRegime != null) {
				this.substitutedRegime.add(_substitutedRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(SubstitutedRegime _substitutedRegime, int idx) {
			getIndex(this.substitutedRegime, idx, () -> _substitutedRegime.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder addSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegimes) {
			if (substitutedRegimes != null) {
				for (final SubstitutedRegime toAdd : substitutedRegimes) {
					this.substitutedRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("substitutedRegime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("substitutedRegime")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitutedRegime(List<? extends SubstitutedRegime> substitutedRegimes) {
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
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setBaseAndEligibleCurrency(BaseAndEligibleCurrency _baseAndEligibleCurrency) {
			this.baseAndEligibleCurrency = _baseAndEligibleCurrency == null ? null : _baseAndEligibleCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalObligations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalObligations")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalObligations(String _additionalObligations) {
			this.additionalObligations = _additionalObligations == null ? null : _additionalObligations;
			return this;
		}
		
		@RosettaAttribute("coveredTransactions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("coveredTransactions")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCoveredTransactions(CoveredTransactions _coveredTransactions) {
			this.coveredTransactions = _coveredTransactions == null ? null : _coveredTransactions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportObligations")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportObligations(CreditSupportObligations _creditSupportObligations) {
			this.creditSupportObligations = _creditSupportObligations == null ? null : _creditSupportObligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeDate")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setExchangeDate(String _exchangeDate) {
			this.exchangeDate = _exchangeDate == null ? null : _exchangeDate;
			return this;
		}
		
		@RosettaAttribute("calculationAndTiming")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculationAndTiming")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCalculationAndTiming(CalculationAndTiming _calculationAndTiming) {
			this.calculationAndTiming = _calculationAndTiming == null ? null : _calculationAndTiming.toBuilder();
			return this;
		}
		
		@RosettaAttribute("conditionsPrecedent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conditionsPrecedent")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setConditionsPrecedent(ConditionsPrecedent _conditionsPrecedent) {
			this.conditionsPrecedent = _conditionsPrecedent == null ? null : _conditionsPrecedent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("substitution")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSubstitution(Substitution _substitution) {
			this.substitution = _substitution == null ? null : _substitution.toBuilder();
			return this;
		}
		
		@RosettaAttribute("disputeResolution")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("disputeResolution")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDisputeResolution(DisputeResolution _disputeResolution) {
			this.disputeResolution = _disputeResolution == null ? null : _disputeResolution.toBuilder();
			return this;
		}
		
		@RosettaAttribute("holdingAndUsingPostedCollateral")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("holdingAndUsingPostedCollateral")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setHoldingAndUsingPostedCollateral(HoldingAndUsingPostedCollateral _holdingAndUsingPostedCollateral) {
			this.holdingAndUsingPostedCollateral = _holdingAndUsingPostedCollateral == null ? null : _holdingAndUsingPostedCollateral.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rightsEvents")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rightsEvents")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setRightsEvents(RightsEvents _rightsEvents) {
			this.rightsEvents = _rightsEvents == null ? null : _rightsEvents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("custodyArrangements")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("custodyArrangements")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCustodyArrangements(CustodyArrangements _custodyArrangements) {
			this.custodyArrangements = _custodyArrangements == null ? null : _custodyArrangements.toBuilder();
			return this;
		}
		
		@RosettaAttribute("distributionAndInterestPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("distributionAndInterestPayment")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDistributionAndInterestPayment(DistributionAndInterestPayment _distributionAndInterestPayment) {
			this.distributionAndInterestPayment = _distributionAndInterestPayment == null ? null : _distributionAndInterestPayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportOffsets")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportOffsets")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCreditSupportOffsets(Boolean _creditSupportOffsets) {
			this.creditSupportOffsets = _creditSupportOffsets == null ? null : _creditSupportOffsets;
			return this;
		}
		
		@RosettaAttribute("additionalRepresentations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("additionalRepresentations")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalRepresentations(AdditionalRepresentations _additionalRepresentations) {
			this.additionalRepresentations = _additionalRepresentations == null ? null : _additionalRepresentations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherEligibleAndPostedSupport")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("otherEligibleAndPostedSupport")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherEligibleAndPostedSupport(OtherEligibleAndPostedSupport _otherEligibleAndPostedSupport) {
			this.otherEligibleAndPostedSupport = _otherEligibleAndPostedSupport == null ? null : _otherEligibleAndPostedSupport.toBuilder();
			return this;
		}
		
		@RosettaAttribute("demandsAndNotices")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("demandsAndNotices")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDemandsAndNotices(ContactElection _demandsAndNotices) {
			this.demandsAndNotices = _demandsAndNotices == null ? null : _demandsAndNotices.toBuilder();
			return this;
		}
		
		@RosettaAttribute("addressesForTransfer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addressesForTransfer")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAddressesForTransfer(ContactElection _addressesForTransfer) {
			this.addressesForTransfer = _addressesForTransfer == null ? null : _addressesForTransfer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherAgreements")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherAgreements")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherAgreements(OtherAgreements _otherAgreements) {
			this.otherAgreements = _otherAgreements == null ? null : _otherAgreements.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationCurrencyAmendment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("terminationCurrencyAmendment")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTerminationCurrencyAmendment(TerminationCurrencyAmendment _terminationCurrencyAmendment) {
			this.terminationCurrencyAmendment = _terminationCurrencyAmendment == null ? null : _terminationCurrencyAmendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumTransferAmountAmendment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("minimumTransferAmountAmendment")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setMinimumTransferAmountAmendment(MinimumTransferAmountAmendment _minimumTransferAmountAmendment) {
			this.minimumTransferAmountAmendment = _minimumTransferAmountAmendment == null ? null : _minimumTransferAmountAmendment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interpretationTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interpretationTerms")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setInterpretationTerms(String _interpretationTerms) {
			this.interpretationTerms = _interpretationTerms == null ? null : _interpretationTerms;
			return this;
		}
		
		@RosettaAttribute("processAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("processAgent")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setProcessAgent(ProcessAgent _processAgent) {
			this.processAgent = _processAgent == null ? null : _processAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("appropriatedCollateralValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("appropriatedCollateralValuation")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAppropriatedCollateralValuation(AppropriatedCollateralValuation _appropriatedCollateralValuation) {
			this.appropriatedCollateralValuation = _appropriatedCollateralValuation == null ? null : _appropriatedCollateralValuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("jurisdictionRelatedTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("jurisdictionRelatedTerms")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setJurisdictionRelatedTerms(JurisdictionRelatedTerms _jurisdictionRelatedTerms) {
			this.jurisdictionRelatedTerms = _jurisdictionRelatedTerms == null ? null : _jurisdictionRelatedTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalAmendments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalAmendments")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalAmendments(String _additionalAmendments) {
			this.additionalAmendments = _additionalAmendments == null ? null : _additionalAmendments;
			return this;
		}
		
		@RosettaAttribute("additionalBespokeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalBespokeTerms")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setAdditionalBespokeTerms(String _additionalBespokeTerms) {
			this.additionalBespokeTerms = _additionalBespokeTerms == null ? null : _additionalBespokeTerms;
			return this;
		}
		
		@RosettaAttribute("trustSchemeAddendum")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trustSchemeAddendum")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setTrustSchemeAddendum(Boolean _trustSchemeAddendum) {
			this.trustSchemeAddendum = _trustSchemeAddendum == null ? null : _trustSchemeAddendum;
			return this;
		}
		
		@RosettaAttribute("securityInterestForObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("securityInterestForObligations")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSecurityInterestForObligations(SecurityInterestForObligations _securityInterestForObligations) {
			this.securityInterestForObligations = _securityInterestForObligations == null ? null : _securityInterestForObligations.toBuilder();
			return this;
		}
		
		@RosettaAttribute("singlePostingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("singlePostingParty")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setSinglePostingParty(SinglePostingParty _singlePostingParty) {
			this.singlePostingParty = _singlePostingParty == null ? null : _singlePostingParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("datedAsOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("datedAsOfDate")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setDatedAsOfDate(DatedAsOfDate _datedAsOfDate) {
			this.datedAsOfDate = _datedAsOfDate == null ? null : _datedAsOfDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cass")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setCass(String _cass) {
			this.cass = _cass == null ? null : _cass;
			return this;
		}
		
		@RosettaAttribute("otherCSA")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherCSA")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setOtherCSA(String _otherCSA) {
			this.otherCSA = _otherCSA == null ? null : _otherCSA;
			return this;
		}
		
		@RosettaAttribute("legacyAdditionalRepresentations")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyAdditionalRepresentations")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setLegacyAdditionalRepresentations(String _legacyAdditionalRepresentations) {
			this.legacyAdditionalRepresentations = _legacyAdditionalRepresentations == null ? null : _legacyAdditionalRepresentations;
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder setValue(CollateralValueMethod _value) {
			this.value = _value == null ? null : _value.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportAgreementElections build() {
			return new CreditSupportAgreementElections.CreditSupportAgreementElectionsImpl(this);
		}
		
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder prune() {
			if (regime!=null && !regime.prune().hasData()) regime = null;
			if (oneWayProvisions!=null && !oneWayProvisions.prune().hasData()) oneWayProvisions = null;
			if (generalSimmElections!=null && !generalSimmElections.prune().hasData()) generalSimmElections = null;
			if (sensitivityMethodologies!=null && !sensitivityMethodologies.prune().hasData()) sensitivityMethodologies = null;
			if (fxHaircutCurrency!=null && !fxHaircutCurrency.prune().hasData()) fxHaircutCurrency = null;
			if (postingObligations!=null && !postingObligations.prune().hasData()) postingObligations = null;
			substitutedRegime = substitutedRegime.stream().filter(b->b!=null).<SubstitutedRegime.SubstitutedRegimeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (baseAndEligibleCurrency!=null && !baseAndEligibleCurrency.prune().hasData()) baseAndEligibleCurrency = null;
			if (coveredTransactions!=null && !coveredTransactions.prune().hasData()) coveredTransactions = null;
			if (creditSupportObligations!=null && !creditSupportObligations.prune().hasData()) creditSupportObligations = null;
			if (calculationAndTiming!=null && !calculationAndTiming.prune().hasData()) calculationAndTiming = null;
			if (conditionsPrecedent!=null && !conditionsPrecedent.prune().hasData()) conditionsPrecedent = null;
			if (substitution!=null && !substitution.prune().hasData()) substitution = null;
			if (disputeResolution!=null && !disputeResolution.prune().hasData()) disputeResolution = null;
			if (holdingAndUsingPostedCollateral!=null && !holdingAndUsingPostedCollateral.prune().hasData()) holdingAndUsingPostedCollateral = null;
			if (rightsEvents!=null && !rightsEvents.prune().hasData()) rightsEvents = null;
			if (custodyArrangements!=null && !custodyArrangements.prune().hasData()) custodyArrangements = null;
			if (distributionAndInterestPayment!=null && !distributionAndInterestPayment.prune().hasData()) distributionAndInterestPayment = null;
			if (additionalRepresentations!=null && !additionalRepresentations.prune().hasData()) additionalRepresentations = null;
			if (otherEligibleAndPostedSupport!=null && !otherEligibleAndPostedSupport.prune().hasData()) otherEligibleAndPostedSupport = null;
			if (demandsAndNotices!=null && !demandsAndNotices.prune().hasData()) demandsAndNotices = null;
			if (addressesForTransfer!=null && !addressesForTransfer.prune().hasData()) addressesForTransfer = null;
			if (otherAgreements!=null && !otherAgreements.prune().hasData()) otherAgreements = null;
			if (terminationCurrencyAmendment!=null && !terminationCurrencyAmendment.prune().hasData()) terminationCurrencyAmendment = null;
			if (minimumTransferAmountAmendment!=null && !minimumTransferAmountAmendment.prune().hasData()) minimumTransferAmountAmendment = null;
			if (processAgent!=null && !processAgent.prune().hasData()) processAgent = null;
			if (appropriatedCollateralValuation!=null && !appropriatedCollateralValuation.prune().hasData()) appropriatedCollateralValuation = null;
			if (jurisdictionRelatedTerms!=null && !jurisdictionRelatedTerms.prune().hasData()) jurisdictionRelatedTerms = null;
			if (securityInterestForObligations!=null && !securityInterestForObligations.prune().hasData()) securityInterestForObligations = null;
			if (singlePostingParty!=null && !singlePostingParty.prune().hasData()) singlePostingParty = null;
			if (datedAsOfDate!=null && !datedAsOfDate.prune().hasData()) datedAsOfDate = null;
			if (value!=null && !value.prune().hasData()) value = null;
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
			if (getAdditionalObligations()!=null) return true;
			if (getCoveredTransactions()!=null && getCoveredTransactions().hasData()) return true;
			if (getCreditSupportObligations()!=null && getCreditSupportObligations().hasData()) return true;
			if (getExchangeDate()!=null) return true;
			if (getCalculationAndTiming()!=null && getCalculationAndTiming().hasData()) return true;
			if (getConditionsPrecedent()!=null && getConditionsPrecedent().hasData()) return true;
			if (getSubstitution()!=null && getSubstitution().hasData()) return true;
			if (getDisputeResolution()!=null && getDisputeResolution().hasData()) return true;
			if (getHoldingAndUsingPostedCollateral()!=null && getHoldingAndUsingPostedCollateral().hasData()) return true;
			if (getRightsEvents()!=null && getRightsEvents().hasData()) return true;
			if (getCustodyArrangements()!=null && getCustodyArrangements().hasData()) return true;
			if (getDistributionAndInterestPayment()!=null && getDistributionAndInterestPayment().hasData()) return true;
			if (getCreditSupportOffsets()!=null) return true;
			if (getAdditionalRepresentations()!=null && getAdditionalRepresentations().hasData()) return true;
			if (getOtherEligibleAndPostedSupport()!=null && getOtherEligibleAndPostedSupport().hasData()) return true;
			if (getDemandsAndNotices()!=null && getDemandsAndNotices().hasData()) return true;
			if (getAddressesForTransfer()!=null && getAddressesForTransfer().hasData()) return true;
			if (getOtherAgreements()!=null && getOtherAgreements().hasData()) return true;
			if (getTerminationCurrencyAmendment()!=null && getTerminationCurrencyAmendment().hasData()) return true;
			if (getMinimumTransferAmountAmendment()!=null && getMinimumTransferAmountAmendment().hasData()) return true;
			if (getInterpretationTerms()!=null) return true;
			if (getProcessAgent()!=null && getProcessAgent().hasData()) return true;
			if (getAppropriatedCollateralValuation()!=null && getAppropriatedCollateralValuation().hasData()) return true;
			if (getJurisdictionRelatedTerms()!=null && getJurisdictionRelatedTerms().hasData()) return true;
			if (getAdditionalAmendments()!=null) return true;
			if (getAdditionalBespokeTerms()!=null) return true;
			if (getTrustSchemeAddendum()!=null) return true;
			if (getSecurityInterestForObligations()!=null && getSecurityInterestForObligations().hasData()) return true;
			if (getSinglePostingParty()!=null && getSinglePostingParty().hasData()) return true;
			if (getDatedAsOfDate()!=null && getDatedAsOfDate().hasData()) return true;
			if (getCass()!=null) return true;
			if (getOtherCSA()!=null) return true;
			if (getLegacyAdditionalRepresentations()!=null) return true;
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder o = (CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder) other;
			
			merger.mergeRosetta(getRegime(), o.getRegime(), this::setRegime);
			merger.mergeRosetta(getOneWayProvisions(), o.getOneWayProvisions(), this::setOneWayProvisions);
			merger.mergeRosetta(getGeneralSimmElections(), o.getGeneralSimmElections(), this::setGeneralSimmElections);
			merger.mergeRosetta(getSensitivityMethodologies(), o.getSensitivityMethodologies(), this::setSensitivityMethodologies);
			merger.mergeRosetta(getFxHaircutCurrency(), o.getFxHaircutCurrency(), this::setFxHaircutCurrency);
			merger.mergeRosetta(getPostingObligations(), o.getPostingObligations(), this::setPostingObligations);
			merger.mergeRosetta(getSubstitutedRegime(), o.getSubstitutedRegime(), this::getOrCreateSubstitutedRegime);
			merger.mergeRosetta(getBaseAndEligibleCurrency(), o.getBaseAndEligibleCurrency(), this::setBaseAndEligibleCurrency);
			merger.mergeRosetta(getCoveredTransactions(), o.getCoveredTransactions(), this::setCoveredTransactions);
			merger.mergeRosetta(getCreditSupportObligations(), o.getCreditSupportObligations(), this::setCreditSupportObligations);
			merger.mergeRosetta(getCalculationAndTiming(), o.getCalculationAndTiming(), this::setCalculationAndTiming);
			merger.mergeRosetta(getConditionsPrecedent(), o.getConditionsPrecedent(), this::setConditionsPrecedent);
			merger.mergeRosetta(getSubstitution(), o.getSubstitution(), this::setSubstitution);
			merger.mergeRosetta(getDisputeResolution(), o.getDisputeResolution(), this::setDisputeResolution);
			merger.mergeRosetta(getHoldingAndUsingPostedCollateral(), o.getHoldingAndUsingPostedCollateral(), this::setHoldingAndUsingPostedCollateral);
			merger.mergeRosetta(getRightsEvents(), o.getRightsEvents(), this::setRightsEvents);
			merger.mergeRosetta(getCustodyArrangements(), o.getCustodyArrangements(), this::setCustodyArrangements);
			merger.mergeRosetta(getDistributionAndInterestPayment(), o.getDistributionAndInterestPayment(), this::setDistributionAndInterestPayment);
			merger.mergeRosetta(getAdditionalRepresentations(), o.getAdditionalRepresentations(), this::setAdditionalRepresentations);
			merger.mergeRosetta(getOtherEligibleAndPostedSupport(), o.getOtherEligibleAndPostedSupport(), this::setOtherEligibleAndPostedSupport);
			merger.mergeRosetta(getDemandsAndNotices(), o.getDemandsAndNotices(), this::setDemandsAndNotices);
			merger.mergeRosetta(getAddressesForTransfer(), o.getAddressesForTransfer(), this::setAddressesForTransfer);
			merger.mergeRosetta(getOtherAgreements(), o.getOtherAgreements(), this::setOtherAgreements);
			merger.mergeRosetta(getTerminationCurrencyAmendment(), o.getTerminationCurrencyAmendment(), this::setTerminationCurrencyAmendment);
			merger.mergeRosetta(getMinimumTransferAmountAmendment(), o.getMinimumTransferAmountAmendment(), this::setMinimumTransferAmountAmendment);
			merger.mergeRosetta(getProcessAgent(), o.getProcessAgent(), this::setProcessAgent);
			merger.mergeRosetta(getAppropriatedCollateralValuation(), o.getAppropriatedCollateralValuation(), this::setAppropriatedCollateralValuation);
			merger.mergeRosetta(getJurisdictionRelatedTerms(), o.getJurisdictionRelatedTerms(), this::setJurisdictionRelatedTerms);
			merger.mergeRosetta(getSecurityInterestForObligations(), o.getSecurityInterestForObligations(), this::setSecurityInterestForObligations);
			merger.mergeRosetta(getSinglePostingParty(), o.getSinglePostingParty(), this::setSinglePostingParty);
			merger.mergeRosetta(getDatedAsOfDate(), o.getDatedAsOfDate(), this::setDatedAsOfDate);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			merger.mergeBasic(getIdentifiedCrossCurrencySwap(), o.getIdentifiedCrossCurrencySwap(), this::setIdentifiedCrossCurrencySwap);
			merger.mergeBasic(getAdditionalObligations(), o.getAdditionalObligations(), this::setAdditionalObligations);
			merger.mergeBasic(getExchangeDate(), o.getExchangeDate(), this::setExchangeDate);
			merger.mergeBasic(getCreditSupportOffsets(), o.getCreditSupportOffsets(), this::setCreditSupportOffsets);
			merger.mergeBasic(getInterpretationTerms(), o.getInterpretationTerms(), this::setInterpretationTerms);
			merger.mergeBasic(getAdditionalAmendments(), o.getAdditionalAmendments(), this::setAdditionalAmendments);
			merger.mergeBasic(getAdditionalBespokeTerms(), o.getAdditionalBespokeTerms(), this::setAdditionalBespokeTerms);
			merger.mergeBasic(getTrustSchemeAddendum(), o.getTrustSchemeAddendum(), this::setTrustSchemeAddendum);
			merger.mergeBasic(getCass(), o.getCass(), this::setCass);
			merger.mergeBasic(getOtherCSA(), o.getOtherCSA(), this::setOtherCSA);
			merger.mergeBasic(getLegacyAdditionalRepresentations(), o.getLegacyAdditionalRepresentations(), this::setLegacyAdditionalRepresentations);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(regime, _that.getRegime())) return false;
			if (!Objects.equals(oneWayProvisions, _that.getOneWayProvisions())) return false;
			if (!Objects.equals(generalSimmElections, _that.getGeneralSimmElections())) return false;
			if (!Objects.equals(identifiedCrossCurrencySwap, _that.getIdentifiedCrossCurrencySwap())) return false;
			if (!Objects.equals(sensitivityMethodologies, _that.getSensitivityMethodologies())) return false;
			if (!Objects.equals(fxHaircutCurrency, _that.getFxHaircutCurrency())) return false;
			if (!Objects.equals(postingObligations, _that.getPostingObligations())) return false;
			if (!ListEquals.listEquals(substitutedRegime, _that.getSubstitutedRegime())) return false;
			if (!Objects.equals(baseAndEligibleCurrency, _that.getBaseAndEligibleCurrency())) return false;
			if (!Objects.equals(additionalObligations, _that.getAdditionalObligations())) return false;
			if (!Objects.equals(coveredTransactions, _that.getCoveredTransactions())) return false;
			if (!Objects.equals(creditSupportObligations, _that.getCreditSupportObligations())) return false;
			if (!Objects.equals(exchangeDate, _that.getExchangeDate())) return false;
			if (!Objects.equals(calculationAndTiming, _that.getCalculationAndTiming())) return false;
			if (!Objects.equals(conditionsPrecedent, _that.getConditionsPrecedent())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(disputeResolution, _that.getDisputeResolution())) return false;
			if (!Objects.equals(holdingAndUsingPostedCollateral, _that.getHoldingAndUsingPostedCollateral())) return false;
			if (!Objects.equals(rightsEvents, _that.getRightsEvents())) return false;
			if (!Objects.equals(custodyArrangements, _that.getCustodyArrangements())) return false;
			if (!Objects.equals(distributionAndInterestPayment, _that.getDistributionAndInterestPayment())) return false;
			if (!Objects.equals(creditSupportOffsets, _that.getCreditSupportOffsets())) return false;
			if (!Objects.equals(additionalRepresentations, _that.getAdditionalRepresentations())) return false;
			if (!Objects.equals(otherEligibleAndPostedSupport, _that.getOtherEligibleAndPostedSupport())) return false;
			if (!Objects.equals(demandsAndNotices, _that.getDemandsAndNotices())) return false;
			if (!Objects.equals(addressesForTransfer, _that.getAddressesForTransfer())) return false;
			if (!Objects.equals(otherAgreements, _that.getOtherAgreements())) return false;
			if (!Objects.equals(terminationCurrencyAmendment, _that.getTerminationCurrencyAmendment())) return false;
			if (!Objects.equals(minimumTransferAmountAmendment, _that.getMinimumTransferAmountAmendment())) return false;
			if (!Objects.equals(interpretationTerms, _that.getInterpretationTerms())) return false;
			if (!Objects.equals(processAgent, _that.getProcessAgent())) return false;
			if (!Objects.equals(appropriatedCollateralValuation, _that.getAppropriatedCollateralValuation())) return false;
			if (!Objects.equals(jurisdictionRelatedTerms, _that.getJurisdictionRelatedTerms())) return false;
			if (!Objects.equals(additionalAmendments, _that.getAdditionalAmendments())) return false;
			if (!Objects.equals(additionalBespokeTerms, _that.getAdditionalBespokeTerms())) return false;
			if (!Objects.equals(trustSchemeAddendum, _that.getTrustSchemeAddendum())) return false;
			if (!Objects.equals(securityInterestForObligations, _that.getSecurityInterestForObligations())) return false;
			if (!Objects.equals(singlePostingParty, _that.getSinglePostingParty())) return false;
			if (!Objects.equals(datedAsOfDate, _that.getDatedAsOfDate())) return false;
			if (!Objects.equals(cass, _that.getCass())) return false;
			if (!Objects.equals(otherCSA, _that.getOtherCSA())) return false;
			if (!Objects.equals(legacyAdditionalRepresentations, _that.getLegacyAdditionalRepresentations())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
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
			_result = 31 * _result + (additionalObligations != null ? additionalObligations.hashCode() : 0);
			_result = 31 * _result + (coveredTransactions != null ? coveredTransactions.hashCode() : 0);
			_result = 31 * _result + (creditSupportObligations != null ? creditSupportObligations.hashCode() : 0);
			_result = 31 * _result + (exchangeDate != null ? exchangeDate.hashCode() : 0);
			_result = 31 * _result + (calculationAndTiming != null ? calculationAndTiming.hashCode() : 0);
			_result = 31 * _result + (conditionsPrecedent != null ? conditionsPrecedent.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (disputeResolution != null ? disputeResolution.hashCode() : 0);
			_result = 31 * _result + (holdingAndUsingPostedCollateral != null ? holdingAndUsingPostedCollateral.hashCode() : 0);
			_result = 31 * _result + (rightsEvents != null ? rightsEvents.hashCode() : 0);
			_result = 31 * _result + (custodyArrangements != null ? custodyArrangements.hashCode() : 0);
			_result = 31 * _result + (distributionAndInterestPayment != null ? distributionAndInterestPayment.hashCode() : 0);
			_result = 31 * _result + (creditSupportOffsets != null ? creditSupportOffsets.hashCode() : 0);
			_result = 31 * _result + (additionalRepresentations != null ? additionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (otherEligibleAndPostedSupport != null ? otherEligibleAndPostedSupport.hashCode() : 0);
			_result = 31 * _result + (demandsAndNotices != null ? demandsAndNotices.hashCode() : 0);
			_result = 31 * _result + (addressesForTransfer != null ? addressesForTransfer.hashCode() : 0);
			_result = 31 * _result + (otherAgreements != null ? otherAgreements.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyAmendment != null ? terminationCurrencyAmendment.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmountAmendment != null ? minimumTransferAmountAmendment.hashCode() : 0);
			_result = 31 * _result + (interpretationTerms != null ? interpretationTerms.hashCode() : 0);
			_result = 31 * _result + (processAgent != null ? processAgent.hashCode() : 0);
			_result = 31 * _result + (appropriatedCollateralValuation != null ? appropriatedCollateralValuation.hashCode() : 0);
			_result = 31 * _result + (jurisdictionRelatedTerms != null ? jurisdictionRelatedTerms.hashCode() : 0);
			_result = 31 * _result + (additionalAmendments != null ? additionalAmendments.hashCode() : 0);
			_result = 31 * _result + (additionalBespokeTerms != null ? additionalBespokeTerms.hashCode() : 0);
			_result = 31 * _result + (trustSchemeAddendum != null ? trustSchemeAddendum.hashCode() : 0);
			_result = 31 * _result + (securityInterestForObligations != null ? securityInterestForObligations.hashCode() : 0);
			_result = 31 * _result + (singlePostingParty != null ? singlePostingParty.hashCode() : 0);
			_result = 31 * _result + (datedAsOfDate != null ? datedAsOfDate.hashCode() : 0);
			_result = 31 * _result + (cass != null ? cass.hashCode() : 0);
			_result = 31 * _result + (otherCSA != null ? otherCSA.hashCode() : 0);
			_result = 31 * _result + (legacyAdditionalRepresentations != null ? legacyAdditionalRepresentations.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementElectionsBuilder {" +
				"regime=" + this.regime + ", " +
				"oneWayProvisions=" + this.oneWayProvisions + ", " +
				"generalSimmElections=" + this.generalSimmElections + ", " +
				"identifiedCrossCurrencySwap=" + this.identifiedCrossCurrencySwap + ", " +
				"sensitivityMethodologies=" + this.sensitivityMethodologies + ", " +
				"fxHaircutCurrency=" + this.fxHaircutCurrency + ", " +
				"postingObligations=" + this.postingObligations + ", " +
				"substitutedRegime=" + this.substitutedRegime + ", " +
				"baseAndEligibleCurrency=" + this.baseAndEligibleCurrency + ", " +
				"additionalObligations=" + this.additionalObligations + ", " +
				"coveredTransactions=" + this.coveredTransactions + ", " +
				"creditSupportObligations=" + this.creditSupportObligations + ", " +
				"exchangeDate=" + this.exchangeDate + ", " +
				"calculationAndTiming=" + this.calculationAndTiming + ", " +
				"conditionsPrecedent=" + this.conditionsPrecedent + ", " +
				"substitution=" + this.substitution + ", " +
				"disputeResolution=" + this.disputeResolution + ", " +
				"holdingAndUsingPostedCollateral=" + this.holdingAndUsingPostedCollateral + ", " +
				"rightsEvents=" + this.rightsEvents + ", " +
				"custodyArrangements=" + this.custodyArrangements + ", " +
				"distributionAndInterestPayment=" + this.distributionAndInterestPayment + ", " +
				"creditSupportOffsets=" + this.creditSupportOffsets + ", " +
				"additionalRepresentations=" + this.additionalRepresentations + ", " +
				"otherEligibleAndPostedSupport=" + this.otherEligibleAndPostedSupport + ", " +
				"demandsAndNotices=" + this.demandsAndNotices + ", " +
				"addressesForTransfer=" + this.addressesForTransfer + ", " +
				"otherAgreements=" + this.otherAgreements + ", " +
				"terminationCurrencyAmendment=" + this.terminationCurrencyAmendment + ", " +
				"minimumTransferAmountAmendment=" + this.minimumTransferAmountAmendment + ", " +
				"interpretationTerms=" + this.interpretationTerms + ", " +
				"processAgent=" + this.processAgent + ", " +
				"appropriatedCollateralValuation=" + this.appropriatedCollateralValuation + ", " +
				"jurisdictionRelatedTerms=" + this.jurisdictionRelatedTerms + ", " +
				"additionalAmendments=" + this.additionalAmendments + ", " +
				"additionalBespokeTerms=" + this.additionalBespokeTerms + ", " +
				"trustSchemeAddendum=" + this.trustSchemeAddendum + ", " +
				"securityInterestForObligations=" + this.securityInterestForObligations + ", " +
				"singlePostingParty=" + this.singlePostingParty + ", " +
				"datedAsOfDate=" + this.datedAsOfDate + ", " +
				"cass=" + this.cass + ", " +
				"otherCSA=" + this.otherCSA + ", " +
				"legacyAdditionalRepresentations=" + this.legacyAdditionalRepresentations + ", " +
				"value=" + this.value +
			'}';
		}
	}
}
