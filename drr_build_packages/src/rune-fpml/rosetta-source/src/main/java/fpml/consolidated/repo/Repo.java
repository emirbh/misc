package fpml.consolidated.repo;

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
import fpml.consolidated.asset.GenericSecurity;
import fpml.consolidated.fpmlenum.CallingPartyEnum;
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.RepoDurationEnum;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.repo.meta.RepoMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A Repo, modeled as an FpML:Product. Note: this Repo model is a candidate model for further industry input.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A Repo, modeled as an FpML:Product. Note: this Repo model is a candidate model for further industry input.
 *
 */
@RosettaDataType(value="Repo", builder=Repo.RepoBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Repo", model="fpml", builder=Repo.RepoBuilderImpl.class, version="2.1.1")
public interface Repo extends Product {

	RepoMeta metaData = new RepoMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fixed repo or security lending rate. It is usually fixed rebate rate for the duration of the agreement but can be changed with mid-life events (rate changes).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fixed repo or security lending rate. It is usually fixed rebate rate for the duration of the agreement but can be changed with mid-life events (rate changes).
	 *
	 */
	Schedule getFixedRateSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floating rate index and tenor, with additional definitions relating to the calculation of floating rate amounts, including spread and multiplier. It is used for floating rate repo or security lending. For example, most floating rate repo or security lending on European markets are against EONIA
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floating rate index and tenor, with additional definitions relating to the calculation of floating rate amounts, including spread and multiplier. It is used for floating rate repo or security lending. For example, most floating rate repo or security lending on European markets are against EONIA
	 *
	 */
	FloatingRateCalculation getFloatingRateCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The floating rate reset frequency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The floating rate reset frequency.
	 *
	 */
	Frequency getResetFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A duration code for the repo transaction. This defines a type of a repo transaction with Term, Overnight or Open duration.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A duration code for the repo transaction. This defines a type of a repo transaction with Term, Overnight or Open duration.
	 *
	 */
	RepoDurationEnum getDuration();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Type of extension provision: {Evergreen (close by mutual agreement), Extendable (extend by mutual agreement)}
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Type of extension provision: {Evergreen (close by mutual agreement), Extendable (extend by mutual agreement)}
	 *
	 */
	ExtensionStyleEnum getExtensionStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Extension period for evergreen/extendable term repo or security lending arrangements, as number of days.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Extension period for evergreen/extendable term repo or security lending arrangements, as number of days.
	 *
	 */
	AdjustableOffset getExtensionPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party to the repo transaction that has a right to demand exercise of the far leg of the open repo transaction. This element represents an enumerated list that includes InitialBuyer, InitialSeller, Either, AsDefinedInMasterAgreement. In the default case, either party can call for closing an open repo transaction. If electing parties are in the Master Agreement and not defined in an open repo confirmation, the value AsDefinedInMasterAgreement should be used. Exact buyer/seller related parties, including any third parties who can demand exercise of open repo transactions on behalf of the parties to the trade (calculation agent, executing broker, etc.), can be defined in the relatedParty element (tradeHeader/partyTradeInformation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party to the repo transaction that has a right to demand exercise of the far leg of the open repo transaction. This element represents an enumerated list that includes InitialBuyer, InitialSeller, Either, AsDefinedInMasterAgreement. In the default case, either party can call for closing an open repo transaction. If electing parties are in the Master Agreement and not defined in an open repo confirmation, the value AsDefinedInMasterAgreement should be used. Exact buyer/seller related parties, including any third parties who can demand exercise of open repo transactions on behalf of the parties to the trade (calculation agent, executing broker, etc.), can be defined in the relatedParty element (tradeHeader/partyTradeInformation).
	 *
	 */
	CallingPartyEnum getCallingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision (SFTR related field) The earliest date that the cash lender has the right to call back a portion of the funds or to terminate the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision (SFTR related field) The earliest date that the cash lender has the right to call back a portion of the funds or to terminate the transaction.
	 *
	 */
	AdjustableDate getEarliestCallDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the latest date when the open repo transaction can and must be exercised on demand by a party to the trade indicated in the electingParty element (or in the Master Agreement, if the electingParty element has AsDefinedInMasterAgreement value). For instance, in an open repo transaction with callDate agreed as business day one year after the trade date, the far leg can be settled on any day after the near leg settlement date and before and including the callDate. If the call date is not defined in trade terms and / or not included into the trade confirmation this element can be omitted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the latest date when the open repo transaction can and must be exercised on demand by a party to the trade indicated in the electingParty element (or in the Master Agreement, if the electingParty element has AsDefinedInMasterAgreement value). For instance, in an open repo transaction with callDate agreed as business day one year after the trade date, the far leg can be settled on any day after the near leg settlement date and before and including the callDate. If the call date is not defined in trade terms and / or not included into the trade confirmation this element can be omitted.
	 *
	 */
	AdjustableOrRelativeDate getCallDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notice period for open repo transactions in number of days. This element represents the agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notice period for open repo transactions in number of days. This element represents the agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise.
	 *
	 */
	AdjustableOffset getNoticePeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notice period for open repo transactions referenced to a party to the trade, in number of days. This element represents the agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise and reference to that party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notice period for open repo transactions referenced to a party to the trade, in number of days. This element represents the agreed period of notice to be given in advance before exercise of the repo trade by a party requesting such exercise and reference to that party.
	 *
	 */
	List<? extends PartyNoticePeriod> getPartyNoticePeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines initial margin applied to a repo transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines initial margin applied to a repo transaction.
	 *
	 */
	InitialMargin getInitialMargin();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A repo contract is modeled as two purchase/repurchase transactions which are called legs. This is the near leg, i.e. the transaction that will be executed on the near settlement date of the contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A repo contract is modeled as two purchase/repurchase transactions which are called legs. This is the near leg, i.e. the transaction that will be executed on the near settlement date of the contract.
	 *
	 */
	RepoNearLeg getNearLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The far leg of the repo contract, i.e. the repurchase transaction. The BuyerSeller model in the far leg must be the exact opposite of the one found in the near leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The far leg of the repo contract, i.e. the repurchase transaction. The BuyerSeller model in the far leg must be the exact opposite of the one found in the near leg.
	 *
	 */
	RepoFarLeg getFarLeg();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Time period and multiplier, describing the frequency of payments for the Repo floating rate. SFTR Field 28 and 29.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Time period and multiplier, describing the frequency of payments for the Repo floating rate. SFTR Field 28 and 29.
	 *
	 */
	Frequency getPaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends RepoChoice> getRepoChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Underlying security profile (e.g. security basket).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Underlying security profile (e.g. security basket).
	 *
	 */
	GenericSecurity getSecurity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Triparty information.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Triparty information.
	 *
	 */
	TriParty getTriParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision (SFTR related field) Indicates whether the secured financing transaction is subject to a general collateral arrangement. If generalCollateral = ‘True’, it is 'GENE' (general collateral). If generalCollateral = 'False', it is 'SPEC' (specific collateral). If produced in connection with a triparty agent, the generalCollateral field is expected to be 'True'.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision (SFTR related field) Indicates whether the secured financing transaction is subject to a general collateral arrangement. If generalCollateral = ‘True’, it is 'GENE' (general collateral). If generalCollateral = 'False', it is 'SPEC' (specific collateral). If produced in connection with a triparty agent, the generalCollateral field is expected to be 'True'.
	 *
	 */
	Boolean getGeneralCollateral();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision (SFTR related field) Method used to provide collateral - Indication whether the collateral is subject to a title transfer collateral arrangement, a securities financial collateral arrangement, or a securities financial with the right of use.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision (SFTR related field) Method used to provide collateral - Indication whether the collateral is subject to a title transfer collateral arrangement, a securities financial collateral arrangement, or a securities financial with the right of use.
	 *
	 */
	CollateralArrangement getCollateralArrangement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indication, whether the collateral taker can reuse the securities provided as a collateral.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indication, whether the collateral taker can reuse the securities provided as a collateral.
	 *
	 */
	Boolean getEligibleForRehypothecation();

	/*********************** Build Methods  ***********************/
	Repo build();
	
	Repo.RepoBuilder toBuilder();
	
	static Repo.RepoBuilder builder() {
		return new Repo.RepoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Repo> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Repo> getType() {
		return Repo.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.class, getFixedRateSchedule());
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.class, getResetFrequency());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("duration"), RepoDurationEnum.class, getDuration(), this);
		processor.processBasic(path.newSubPath("extensionStyle"), ExtensionStyleEnum.class, getExtensionStyle(), this);
		processRosetta(path.newSubPath("extensionPeriod"), processor, AdjustableOffset.class, getExtensionPeriod());
		processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
		processRosetta(path.newSubPath("earliestCallDate"), processor, AdjustableDate.class, getEarliestCallDate());
		processRosetta(path.newSubPath("callDate"), processor, AdjustableOrRelativeDate.class, getCallDate());
		processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.class, getNoticePeriod());
		processRosetta(path.newSubPath("partyNoticePeriod"), processor, PartyNoticePeriod.class, getPartyNoticePeriod());
		processRosetta(path.newSubPath("initialMargin"), processor, InitialMargin.class, getInitialMargin());
		processRosetta(path.newSubPath("nearLeg"), processor, RepoNearLeg.class, getNearLeg());
		processRosetta(path.newSubPath("farLeg"), processor, RepoFarLeg.class, getFarLeg());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.class, getPaymentFrequency());
		processRosetta(path.newSubPath("repoChoice"), processor, RepoChoice.class, getRepoChoice());
		processRosetta(path.newSubPath("security"), processor, GenericSecurity.class, getSecurity());
		processRosetta(path.newSubPath("triParty"), processor, TriParty.class, getTriParty());
		processor.processBasic(path.newSubPath("generalCollateral"), Boolean.class, getGeneralCollateral(), this);
		processRosetta(path.newSubPath("collateralArrangement"), processor, CollateralArrangement.class, getCollateralArrangement());
		processor.processBasic(path.newSubPath("eligibleForRehypothecation"), Boolean.class, getEligibleForRehypothecation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepoBuilder extends Repo, Product.ProductBuilder {
		Schedule.ScheduleBuilder getOrCreateFixedRateSchedule();
		@Override
		Schedule.ScheduleBuilder getFixedRateSchedule();
		FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation();
		@Override
		FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation();
		Frequency.FrequencyBuilder getOrCreateResetFrequency();
		@Override
		Frequency.FrequencyBuilder getResetFrequency();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		AdjustableOffset.AdjustableOffsetBuilder getOrCreateExtensionPeriod();
		@Override
		AdjustableOffset.AdjustableOffsetBuilder getExtensionPeriod();
		AdjustableDate.AdjustableDateBuilder getOrCreateEarliestCallDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getEarliestCallDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCallDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCallDate();
		AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod();
		@Override
		AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod();
		PartyNoticePeriod.PartyNoticePeriodBuilder getOrCreatePartyNoticePeriod(int index);
		@Override
		List<? extends PartyNoticePeriod.PartyNoticePeriodBuilder> getPartyNoticePeriod();
		InitialMargin.InitialMarginBuilder getOrCreateInitialMargin();
		@Override
		InitialMargin.InitialMarginBuilder getInitialMargin();
		RepoNearLeg.RepoNearLegBuilder getOrCreateNearLeg();
		@Override
		RepoNearLeg.RepoNearLegBuilder getNearLeg();
		RepoFarLeg.RepoFarLegBuilder getOrCreateFarLeg();
		@Override
		RepoFarLeg.RepoFarLegBuilder getFarLeg();
		Frequency.FrequencyBuilder getOrCreatePaymentFrequency();
		@Override
		Frequency.FrequencyBuilder getPaymentFrequency();
		RepoChoice.RepoChoiceBuilder getOrCreateRepoChoice(int index);
		@Override
		List<? extends RepoChoice.RepoChoiceBuilder> getRepoChoice();
		GenericSecurity.GenericSecurityBuilder getOrCreateSecurity();
		@Override
		GenericSecurity.GenericSecurityBuilder getSecurity();
		TriParty.TriPartyBuilder getOrCreateTriParty();
		@Override
		TriParty.TriPartyBuilder getTriParty();
		CollateralArrangement.CollateralArrangementBuilder getOrCreateCollateralArrangement();
		@Override
		CollateralArrangement.CollateralArrangementBuilder getCollateralArrangement();
		@Override
		Repo.RepoBuilder setId(String id);
		@Override
		Repo.RepoBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		Repo.RepoBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		Repo.RepoBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		Repo.RepoBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Repo.RepoBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Repo.RepoBuilder addProductType(ProductType productType);
		@Override
		Repo.RepoBuilder addProductType(ProductType productType, int idx);
		@Override
		Repo.RepoBuilder addProductType(List<? extends ProductType> productType);
		@Override
		Repo.RepoBuilder setProductType(List<? extends ProductType> productType);
		@Override
		Repo.RepoBuilder addProductId(ProductId productId);
		@Override
		Repo.RepoBuilder addProductId(ProductId productId, int idx);
		@Override
		Repo.RepoBuilder addProductId(List<? extends ProductId> productId);
		@Override
		Repo.RepoBuilder setProductId(List<? extends ProductId> productId);
		@Override
		Repo.RepoBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		Repo.RepoBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		Repo.RepoBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Repo.RepoBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Repo.RepoBuilder addAssetClass(AssetClass assetClass);
		@Override
		Repo.RepoBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		Repo.RepoBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		Repo.RepoBuilder setAssetClass(List<? extends AssetClass> assetClass);
		Repo.RepoBuilder setFixedRateSchedule(Schedule fixedRateSchedule);
		Repo.RepoBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		Repo.RepoBuilder setResetFrequency(Frequency resetFrequency);
		Repo.RepoBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		Repo.RepoBuilder setDuration(RepoDurationEnum duration);
		Repo.RepoBuilder setExtensionStyle(ExtensionStyleEnum extensionStyle);
		Repo.RepoBuilder setExtensionPeriod(AdjustableOffset extensionPeriod);
		Repo.RepoBuilder setCallingParty(CallingPartyEnum callingParty);
		Repo.RepoBuilder setEarliestCallDate(AdjustableDate earliestCallDate);
		Repo.RepoBuilder setCallDate(AdjustableOrRelativeDate callDate);
		Repo.RepoBuilder setNoticePeriod(AdjustableOffset noticePeriod);
		Repo.RepoBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod);
		Repo.RepoBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod, int idx);
		Repo.RepoBuilder addPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriod);
		Repo.RepoBuilder setPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriod);
		Repo.RepoBuilder setInitialMargin(InitialMargin initialMargin);
		Repo.RepoBuilder setNearLeg(RepoNearLeg nearLeg);
		Repo.RepoBuilder setFarLeg(RepoFarLeg farLeg);
		Repo.RepoBuilder setPaymentFrequency(Frequency paymentFrequency);
		Repo.RepoBuilder addRepoChoice(RepoChoice repoChoice);
		Repo.RepoBuilder addRepoChoice(RepoChoice repoChoice, int idx);
		Repo.RepoBuilder addRepoChoice(List<? extends RepoChoice> repoChoice);
		Repo.RepoBuilder setRepoChoice(List<? extends RepoChoice> repoChoice);
		Repo.RepoBuilder setSecurity(GenericSecurity security);
		Repo.RepoBuilder setTriParty(TriParty triParty);
		Repo.RepoBuilder setGeneralCollateral(Boolean generalCollateral);
		Repo.RepoBuilder setCollateralArrangement(CollateralArrangement collateralArrangement);
		Repo.RepoBuilder setEligibleForRehypothecation(Boolean eligibleForRehypothecation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("fixedRateSchedule"), processor, Schedule.ScheduleBuilder.class, getFixedRateSchedule());
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processRosetta(path.newSubPath("resetFrequency"), processor, Frequency.FrequencyBuilder.class, getResetFrequency());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("duration"), RepoDurationEnum.class, getDuration(), this);
			processor.processBasic(path.newSubPath("extensionStyle"), ExtensionStyleEnum.class, getExtensionStyle(), this);
			processRosetta(path.newSubPath("extensionPeriod"), processor, AdjustableOffset.AdjustableOffsetBuilder.class, getExtensionPeriod());
			processor.processBasic(path.newSubPath("callingParty"), CallingPartyEnum.class, getCallingParty(), this);
			processRosetta(path.newSubPath("earliestCallDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getEarliestCallDate());
			processRosetta(path.newSubPath("callDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCallDate());
			processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.AdjustableOffsetBuilder.class, getNoticePeriod());
			processRosetta(path.newSubPath("partyNoticePeriod"), processor, PartyNoticePeriod.PartyNoticePeriodBuilder.class, getPartyNoticePeriod());
			processRosetta(path.newSubPath("initialMargin"), processor, InitialMargin.InitialMarginBuilder.class, getInitialMargin());
			processRosetta(path.newSubPath("nearLeg"), processor, RepoNearLeg.RepoNearLegBuilder.class, getNearLeg());
			processRosetta(path.newSubPath("farLeg"), processor, RepoFarLeg.RepoFarLegBuilder.class, getFarLeg());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Frequency.FrequencyBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("repoChoice"), processor, RepoChoice.RepoChoiceBuilder.class, getRepoChoice());
			processRosetta(path.newSubPath("security"), processor, GenericSecurity.GenericSecurityBuilder.class, getSecurity());
			processRosetta(path.newSubPath("triParty"), processor, TriParty.TriPartyBuilder.class, getTriParty());
			processor.processBasic(path.newSubPath("generalCollateral"), Boolean.class, getGeneralCollateral(), this);
			processRosetta(path.newSubPath("collateralArrangement"), processor, CollateralArrangement.CollateralArrangementBuilder.class, getCollateralArrangement());
			processor.processBasic(path.newSubPath("eligibleForRehypothecation"), Boolean.class, getEligibleForRehypothecation(), this);
		}
		

		Repo.RepoBuilder prune();
	}

	/*********************** Immutable Implementation of Repo  ***********************/
	class RepoImpl extends Product.ProductImpl implements Repo {
		private final Schedule fixedRateSchedule;
		private final FloatingRateCalculation floatingRateCalculation;
		private final Frequency resetFrequency;
		private final DayCountFraction dayCountFraction;
		private final RepoDurationEnum duration;
		private final ExtensionStyleEnum extensionStyle;
		private final AdjustableOffset extensionPeriod;
		private final CallingPartyEnum callingParty;
		private final AdjustableDate earliestCallDate;
		private final AdjustableOrRelativeDate callDate;
		private final AdjustableOffset noticePeriod;
		private final List<? extends PartyNoticePeriod> partyNoticePeriod;
		private final InitialMargin initialMargin;
		private final RepoNearLeg nearLeg;
		private final RepoFarLeg farLeg;
		private final Frequency paymentFrequency;
		private final List<? extends RepoChoice> repoChoice;
		private final GenericSecurity security;
		private final TriParty triParty;
		private final Boolean generalCollateral;
		private final CollateralArrangement collateralArrangement;
		private final Boolean eligibleForRehypothecation;
		
		protected RepoImpl(Repo.RepoBuilder builder) {
			super(builder);
			this.fixedRateSchedule = ofNullable(builder.getFixedRateSchedule()).map(f->f.build()).orElse(null);
			this.floatingRateCalculation = ofNullable(builder.getFloatingRateCalculation()).map(f->f.build()).orElse(null);
			this.resetFrequency = ofNullable(builder.getResetFrequency()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.duration = builder.getDuration();
			this.extensionStyle = builder.getExtensionStyle();
			this.extensionPeriod = ofNullable(builder.getExtensionPeriod()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.earliestCallDate = ofNullable(builder.getEarliestCallDate()).map(f->f.build()).orElse(null);
			this.callDate = ofNullable(builder.getCallDate()).map(f->f.build()).orElse(null);
			this.noticePeriod = ofNullable(builder.getNoticePeriod()).map(f->f.build()).orElse(null);
			this.partyNoticePeriod = ofNullable(builder.getPartyNoticePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialMargin = ofNullable(builder.getInitialMargin()).map(f->f.build()).orElse(null);
			this.nearLeg = ofNullable(builder.getNearLeg()).map(f->f.build()).orElse(null);
			this.farLeg = ofNullable(builder.getFarLeg()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
			this.repoChoice = ofNullable(builder.getRepoChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.security = ofNullable(builder.getSecurity()).map(f->f.build()).orElse(null);
			this.triParty = ofNullable(builder.getTriParty()).map(f->f.build()).orElse(null);
			this.generalCollateral = builder.getGeneralCollateral();
			this.collateralArrangement = ofNullable(builder.getCollateralArrangement()).map(f->f.build()).orElse(null);
			this.eligibleForRehypothecation = builder.getEligibleForRehypothecation();
		}
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateSchedule")
		public Schedule getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateCalculation")
		public FloatingRateCalculation getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetFrequency")
		public Frequency getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public RepoDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("extensionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extensionStyle")
		public ExtensionStyleEnum getExtensionStyle() {
			return extensionStyle;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extensionPeriod")
		public AdjustableOffset getExtensionPeriod() {
			return extensionPeriod;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("earliestCallDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestCallDate")
		public AdjustableDate getEarliestCallDate() {
			return earliestCallDate;
		}
		
		@Override
		@RosettaAttribute("callDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callDate")
		public AdjustableOrRelativeDate getCallDate() {
			return callDate;
		}
		
		@Override
		@RosettaAttribute("noticePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noticePeriod")
		public AdjustableOffset getNoticePeriod() {
			return noticePeriod;
		}
		
		@Override
		@RosettaAttribute("partyNoticePeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyNoticePeriod")
		public List<? extends PartyNoticePeriod> getPartyNoticePeriod() {
			return partyNoticePeriod;
		}
		
		@Override
		@RosettaAttribute("initialMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMargin")
		public InitialMargin getInitialMargin() {
			return initialMargin;
		}
		
		@Override
		@RosettaAttribute("nearLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nearLeg")
		public RepoNearLeg getNearLeg() {
			return nearLeg;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("farLeg")
		public RepoFarLeg getFarLeg() {
			return farLeg;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Frequency getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		@RosettaAttribute("repoChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("repoChoice")
		public List<? extends RepoChoice> getRepoChoice() {
			return repoChoice;
		}
		
		@Override
		@RosettaAttribute("security")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("security")
		public GenericSecurity getSecurity() {
			return security;
		}
		
		@Override
		@RosettaAttribute("triParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triParty")
		public TriParty getTriParty() {
			return triParty;
		}
		
		@Override
		@RosettaAttribute("generalCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalCollateral")
		public Boolean getGeneralCollateral() {
			return generalCollateral;
		}
		
		@Override
		@RosettaAttribute("collateralArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralArrangement")
		public CollateralArrangement getCollateralArrangement() {
			return collateralArrangement;
		}
		
		@Override
		@RosettaAttribute("eligibleForRehypothecation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleForRehypothecation")
		public Boolean getEligibleForRehypothecation() {
			return eligibleForRehypothecation;
		}
		
		@Override
		public Repo build() {
			return this;
		}
		
		@Override
		public Repo.RepoBuilder toBuilder() {
			Repo.RepoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Repo.RepoBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRateSchedule()).ifPresent(builder::setFixedRateSchedule);
			ofNullable(getFloatingRateCalculation()).ifPresent(builder::setFloatingRateCalculation);
			ofNullable(getResetFrequency()).ifPresent(builder::setResetFrequency);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getExtensionStyle()).ifPresent(builder::setExtensionStyle);
			ofNullable(getExtensionPeriod()).ifPresent(builder::setExtensionPeriod);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getEarliestCallDate()).ifPresent(builder::setEarliestCallDate);
			ofNullable(getCallDate()).ifPresent(builder::setCallDate);
			ofNullable(getNoticePeriod()).ifPresent(builder::setNoticePeriod);
			ofNullable(getPartyNoticePeriod()).ifPresent(builder::setPartyNoticePeriod);
			ofNullable(getInitialMargin()).ifPresent(builder::setInitialMargin);
			ofNullable(getNearLeg()).ifPresent(builder::setNearLeg);
			ofNullable(getFarLeg()).ifPresent(builder::setFarLeg);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
			ofNullable(getRepoChoice()).ifPresent(builder::setRepoChoice);
			ofNullable(getSecurity()).ifPresent(builder::setSecurity);
			ofNullable(getTriParty()).ifPresent(builder::setTriParty);
			ofNullable(getGeneralCollateral()).ifPresent(builder::setGeneralCollateral);
			ofNullable(getCollateralArrangement()).ifPresent(builder::setCollateralArrangement);
			ofNullable(getEligibleForRehypothecation()).ifPresent(builder::setEligibleForRehypothecation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repo _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(extensionStyle, _that.getExtensionStyle())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(earliestCallDate, _that.getEarliestCallDate())) return false;
			if (!Objects.equals(callDate, _that.getCallDate())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			if (!ListEquals.listEquals(partyNoticePeriod, _that.getPartyNoticePeriod())) return false;
			if (!Objects.equals(initialMargin, _that.getInitialMargin())) return false;
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(repoChoice, _that.getRepoChoice())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(triParty, _that.getTriParty())) return false;
			if (!Objects.equals(generalCollateral, _that.getGeneralCollateral())) return false;
			if (!Objects.equals(collateralArrangement, _that.getCollateralArrangement())) return false;
			if (!Objects.equals(eligibleForRehypothecation, _that.getEligibleForRehypothecation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionStyle != null ? extensionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (earliestCallDate != null ? earliestCallDate.hashCode() : 0);
			_result = 31 * _result + (callDate != null ? callDate.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			_result = 31 * _result + (partyNoticePeriod != null ? partyNoticePeriod.hashCode() : 0);
			_result = 31 * _result + (initialMargin != null ? initialMargin.hashCode() : 0);
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (repoChoice != null ? repoChoice.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (triParty != null ? triParty.hashCode() : 0);
			_result = 31 * _result + (generalCollateral != null ? generalCollateral.hashCode() : 0);
			_result = 31 * _result + (collateralArrangement != null ? collateralArrangement.hashCode() : 0);
			_result = 31 * _result + (eligibleForRehypothecation != null ? eligibleForRehypothecation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Repo {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"duration=" + this.duration + ", " +
				"extensionStyle=" + this.extensionStyle + ", " +
				"extensionPeriod=" + this.extensionPeriod + ", " +
				"callingParty=" + this.callingParty + ", " +
				"earliestCallDate=" + this.earliestCallDate + ", " +
				"callDate=" + this.callDate + ", " +
				"noticePeriod=" + this.noticePeriod + ", " +
				"partyNoticePeriod=" + this.partyNoticePeriod + ", " +
				"initialMargin=" + this.initialMargin + ", " +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"repoChoice=" + this.repoChoice + ", " +
				"security=" + this.security + ", " +
				"triParty=" + this.triParty + ", " +
				"generalCollateral=" + this.generalCollateral + ", " +
				"collateralArrangement=" + this.collateralArrangement + ", " +
				"eligibleForRehypothecation=" + this.eligibleForRehypothecation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Repo  ***********************/
	class RepoBuilderImpl extends Product.ProductBuilderImpl implements Repo.RepoBuilder {
	
		protected Schedule.ScheduleBuilder fixedRateSchedule;
		protected FloatingRateCalculation.FloatingRateCalculationBuilder floatingRateCalculation;
		protected Frequency.FrequencyBuilder resetFrequency;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected RepoDurationEnum duration;
		protected ExtensionStyleEnum extensionStyle;
		protected AdjustableOffset.AdjustableOffsetBuilder extensionPeriod;
		protected CallingPartyEnum callingParty;
		protected AdjustableDate.AdjustableDateBuilder earliestCallDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder callDate;
		protected AdjustableOffset.AdjustableOffsetBuilder noticePeriod;
		protected List<PartyNoticePeriod.PartyNoticePeriodBuilder> partyNoticePeriod = new ArrayList<>();
		protected InitialMargin.InitialMarginBuilder initialMargin;
		protected RepoNearLeg.RepoNearLegBuilder nearLeg;
		protected RepoFarLeg.RepoFarLegBuilder farLeg;
		protected Frequency.FrequencyBuilder paymentFrequency;
		protected List<RepoChoice.RepoChoiceBuilder> repoChoice = new ArrayList<>();
		protected GenericSecurity.GenericSecurityBuilder security;
		protected TriParty.TriPartyBuilder triParty;
		protected Boolean generalCollateral;
		protected CollateralArrangement.CollateralArrangementBuilder collateralArrangement;
		protected Boolean eligibleForRehypothecation;
		
		@Override
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedRateSchedule")
		public Schedule.ScheduleBuilder getFixedRateSchedule() {
			return fixedRateSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFixedRateSchedule() {
			Schedule.ScheduleBuilder result;
			if (fixedRateSchedule!=null) {
				result = fixedRateSchedule;
			}
			else {
				result = fixedRateSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingRateCalculation")
		public FloatingRateCalculation.FloatingRateCalculationBuilder getFloatingRateCalculation() {
			return floatingRateCalculation;
		}
		
		@Override
		public FloatingRateCalculation.FloatingRateCalculationBuilder getOrCreateFloatingRateCalculation() {
			FloatingRateCalculation.FloatingRateCalculationBuilder result;
			if (floatingRateCalculation!=null) {
				result = floatingRateCalculation;
			}
			else {
				result = floatingRateCalculation = FloatingRateCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resetFrequency")
		public Frequency.FrequencyBuilder getResetFrequency() {
			return resetFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateResetFrequency() {
			Frequency.FrequencyBuilder result;
			if (resetFrequency!=null) {
				result = resetFrequency;
			}
			else {
				result = resetFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("duration")
		public RepoDurationEnum getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("extensionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extensionStyle")
		public ExtensionStyleEnum getExtensionStyle() {
			return extensionStyle;
		}
		
		@Override
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extensionPeriod")
		public AdjustableOffset.AdjustableOffsetBuilder getExtensionPeriod() {
			return extensionPeriod;
		}
		
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder getOrCreateExtensionPeriod() {
			AdjustableOffset.AdjustableOffsetBuilder result;
			if (extensionPeriod!=null) {
				result = extensionPeriod;
			}
			else {
				result = extensionPeriod = AdjustableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callingParty")
		public CallingPartyEnum getCallingParty() {
			return callingParty;
		}
		
		@Override
		@RosettaAttribute("earliestCallDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestCallDate")
		public AdjustableDate.AdjustableDateBuilder getEarliestCallDate() {
			return earliestCallDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateEarliestCallDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (earliestCallDate!=null) {
				result = earliestCallDate;
			}
			else {
				result = earliestCallDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCallDate() {
			return callDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCallDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (callDate!=null) {
				result = callDate;
			}
			else {
				result = callDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noticePeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noticePeriod")
		public AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod() {
			return noticePeriod;
		}
		
		@Override
		public AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod() {
			AdjustableOffset.AdjustableOffsetBuilder result;
			if (noticePeriod!=null) {
				result = noticePeriod;
			}
			else {
				result = noticePeriod = AdjustableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyNoticePeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyNoticePeriod")
		public List<? extends PartyNoticePeriod.PartyNoticePeriodBuilder> getPartyNoticePeriod() {
			return partyNoticePeriod;
		}
		
		@Override
		public PartyNoticePeriod.PartyNoticePeriodBuilder getOrCreatePartyNoticePeriod(int index) {
			if (partyNoticePeriod==null) {
				this.partyNoticePeriod = new ArrayList<>();
			}
			return getIndex(partyNoticePeriod, index, () -> {
						PartyNoticePeriod.PartyNoticePeriodBuilder newPartyNoticePeriod = PartyNoticePeriod.builder();
						return newPartyNoticePeriod;
					});
		}
		
		@Override
		@RosettaAttribute("initialMargin")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialMargin")
		public InitialMargin.InitialMarginBuilder getInitialMargin() {
			return initialMargin;
		}
		
		@Override
		public InitialMargin.InitialMarginBuilder getOrCreateInitialMargin() {
			InitialMargin.InitialMarginBuilder result;
			if (initialMargin!=null) {
				result = initialMargin;
			}
			else {
				result = initialMargin = InitialMargin.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nearLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nearLeg")
		public RepoNearLeg.RepoNearLegBuilder getNearLeg() {
			return nearLeg;
		}
		
		@Override
		public RepoNearLeg.RepoNearLegBuilder getOrCreateNearLeg() {
			RepoNearLeg.RepoNearLegBuilder result;
			if (nearLeg!=null) {
				result = nearLeg;
			}
			else {
				result = nearLeg = RepoNearLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("farLeg")
		public RepoFarLeg.RepoFarLegBuilder getFarLeg() {
			return farLeg;
		}
		
		@Override
		public RepoFarLeg.RepoFarLegBuilder getOrCreateFarLeg() {
			RepoFarLeg.RepoFarLegBuilder result;
			if (farLeg!=null) {
				result = farLeg;
			}
			else {
				result = farLeg = RepoFarLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Frequency.FrequencyBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreatePaymentFrequency() {
			Frequency.FrequencyBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("repoChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("repoChoice")
		public List<? extends RepoChoice.RepoChoiceBuilder> getRepoChoice() {
			return repoChoice;
		}
		
		@Override
		public RepoChoice.RepoChoiceBuilder getOrCreateRepoChoice(int index) {
			if (repoChoice==null) {
				this.repoChoice = new ArrayList<>();
			}
			return getIndex(repoChoice, index, () -> {
						RepoChoice.RepoChoiceBuilder newRepoChoice = RepoChoice.builder();
						return newRepoChoice;
					});
		}
		
		@Override
		@RosettaAttribute("security")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("security")
		public GenericSecurity.GenericSecurityBuilder getSecurity() {
			return security;
		}
		
		@Override
		public GenericSecurity.GenericSecurityBuilder getOrCreateSecurity() {
			GenericSecurity.GenericSecurityBuilder result;
			if (security!=null) {
				result = security;
			}
			else {
				result = security = GenericSecurity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triParty")
		public TriParty.TriPartyBuilder getTriParty() {
			return triParty;
		}
		
		@Override
		public TriParty.TriPartyBuilder getOrCreateTriParty() {
			TriParty.TriPartyBuilder result;
			if (triParty!=null) {
				result = triParty;
			}
			else {
				result = triParty = TriParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("generalCollateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generalCollateral")
		public Boolean getGeneralCollateral() {
			return generalCollateral;
		}
		
		@Override
		@RosettaAttribute("collateralArrangement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralArrangement")
		public CollateralArrangement.CollateralArrangementBuilder getCollateralArrangement() {
			return collateralArrangement;
		}
		
		@Override
		public CollateralArrangement.CollateralArrangementBuilder getOrCreateCollateralArrangement() {
			CollateralArrangement.CollateralArrangementBuilder result;
			if (collateralArrangement!=null) {
				result = collateralArrangement;
			}
			else {
				result = collateralArrangement = CollateralArrangement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eligibleForRehypothecation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eligibleForRehypothecation")
		public Boolean getEligibleForRehypothecation() {
			return eligibleForRehypothecation;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Repo.RepoBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Repo.RepoBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Repo.RepoBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Repo.RepoBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public Repo.RepoBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public Repo.RepoBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public Repo.RepoBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public Repo.RepoBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public Repo.RepoBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public Repo.RepoBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public Repo.RepoBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public Repo.RepoBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixedRateSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedRateSchedule")
		@Override
		public Repo.RepoBuilder setFixedRateSchedule(Schedule _fixedRateSchedule) {
			this.fixedRateSchedule = _fixedRateSchedule == null ? null : _fixedRateSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingRateCalculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingRateCalculation")
		@Override
		public Repo.RepoBuilder setFloatingRateCalculation(FloatingRateCalculation _floatingRateCalculation) {
			this.floatingRateCalculation = _floatingRateCalculation == null ? null : _floatingRateCalculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("resetFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resetFrequency")
		@Override
		public Repo.RepoBuilder setResetFrequency(Frequency _resetFrequency) {
			this.resetFrequency = _resetFrequency == null ? null : _resetFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public Repo.RepoBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("duration")
		@Override
		public Repo.RepoBuilder setDuration(RepoDurationEnum _duration) {
			this.duration = _duration == null ? null : _duration;
			return this;
		}
		
		@RosettaAttribute("extensionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extensionStyle")
		@Override
		public Repo.RepoBuilder setExtensionStyle(ExtensionStyleEnum _extensionStyle) {
			this.extensionStyle = _extensionStyle == null ? null : _extensionStyle;
			return this;
		}
		
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extensionPeriod")
		@Override
		public Repo.RepoBuilder setExtensionPeriod(AdjustableOffset _extensionPeriod) {
			this.extensionPeriod = _extensionPeriod == null ? null : _extensionPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callingParty")
		@Override
		public Repo.RepoBuilder setCallingParty(CallingPartyEnum _callingParty) {
			this.callingParty = _callingParty == null ? null : _callingParty;
			return this;
		}
		
		@RosettaAttribute("earliestCallDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earliestCallDate")
		@Override
		public Repo.RepoBuilder setEarliestCallDate(AdjustableDate _earliestCallDate) {
			this.earliestCallDate = _earliestCallDate == null ? null : _earliestCallDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callDate")
		@Override
		public Repo.RepoBuilder setCallDate(AdjustableOrRelativeDate _callDate) {
			this.callDate = _callDate == null ? null : _callDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("noticePeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noticePeriod")
		@Override
		public Repo.RepoBuilder setNoticePeriod(AdjustableOffset _noticePeriod) {
			this.noticePeriod = _noticePeriod == null ? null : _noticePeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyNoticePeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyNoticePeriod")
		@Override
		public Repo.RepoBuilder addPartyNoticePeriod(PartyNoticePeriod _partyNoticePeriod) {
			if (_partyNoticePeriod != null) {
				this.partyNoticePeriod.add(_partyNoticePeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addPartyNoticePeriod(PartyNoticePeriod _partyNoticePeriod, int idx) {
			getIndex(this.partyNoticePeriod, idx, () -> _partyNoticePeriod.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriods) {
			if (partyNoticePeriods != null) {
				for (final PartyNoticePeriod toAdd : partyNoticePeriods) {
					this.partyNoticePeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyNoticePeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyNoticePeriod")
		@Override
		public Repo.RepoBuilder setPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriods) {
			if (partyNoticePeriods == null) {
				this.partyNoticePeriod = new ArrayList<>();
			} else {
				this.partyNoticePeriod = partyNoticePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("initialMargin")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialMargin")
		@Override
		public Repo.RepoBuilder setInitialMargin(InitialMargin _initialMargin) {
			this.initialMargin = _initialMargin == null ? null : _initialMargin.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nearLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nearLeg")
		@Override
		public Repo.RepoBuilder setNearLeg(RepoNearLeg _nearLeg) {
			this.nearLeg = _nearLeg == null ? null : _nearLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("farLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("farLeg")
		@Override
		public Repo.RepoBuilder setFarLeg(RepoFarLeg _farLeg) {
			this.farLeg = _farLeg == null ? null : _farLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public Repo.RepoBuilder setPaymentFrequency(Frequency _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("repoChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("repoChoice")
		@Override
		public Repo.RepoBuilder addRepoChoice(RepoChoice _repoChoice) {
			if (_repoChoice != null) {
				this.repoChoice.add(_repoChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addRepoChoice(RepoChoice _repoChoice, int idx) {
			getIndex(this.repoChoice, idx, () -> _repoChoice.toBuilder());
			return this;
		}
		
		@Override
		public Repo.RepoBuilder addRepoChoice(List<? extends RepoChoice> repoChoices) {
			if (repoChoices != null) {
				for (final RepoChoice toAdd : repoChoices) {
					this.repoChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("repoChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("repoChoice")
		@Override
		public Repo.RepoBuilder setRepoChoice(List<? extends RepoChoice> repoChoices) {
			if (repoChoices == null) {
				this.repoChoice = new ArrayList<>();
			} else {
				this.repoChoice = repoChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("security")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("security")
		@Override
		public Repo.RepoBuilder setSecurity(GenericSecurity _security) {
			this.security = _security == null ? null : _security.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triParty")
		@Override
		public Repo.RepoBuilder setTriParty(TriParty _triParty) {
			this.triParty = _triParty == null ? null : _triParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("generalCollateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generalCollateral")
		@Override
		public Repo.RepoBuilder setGeneralCollateral(Boolean _generalCollateral) {
			this.generalCollateral = _generalCollateral == null ? null : _generalCollateral;
			return this;
		}
		
		@RosettaAttribute("collateralArrangement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralArrangement")
		@Override
		public Repo.RepoBuilder setCollateralArrangement(CollateralArrangement _collateralArrangement) {
			this.collateralArrangement = _collateralArrangement == null ? null : _collateralArrangement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eligibleForRehypothecation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eligibleForRehypothecation")
		@Override
		public Repo.RepoBuilder setEligibleForRehypothecation(Boolean _eligibleForRehypothecation) {
			this.eligibleForRehypothecation = _eligibleForRehypothecation == null ? null : _eligibleForRehypothecation;
			return this;
		}
		
		@Override
		public Repo build() {
			return new Repo.RepoImpl(this);
		}
		
		@Override
		public Repo.RepoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repo.RepoBuilder prune() {
			super.prune();
			if (fixedRateSchedule!=null && !fixedRateSchedule.prune().hasData()) fixedRateSchedule = null;
			if (floatingRateCalculation!=null && !floatingRateCalculation.prune().hasData()) floatingRateCalculation = null;
			if (resetFrequency!=null && !resetFrequency.prune().hasData()) resetFrequency = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (extensionPeriod!=null && !extensionPeriod.prune().hasData()) extensionPeriod = null;
			if (earliestCallDate!=null && !earliestCallDate.prune().hasData()) earliestCallDate = null;
			if (callDate!=null && !callDate.prune().hasData()) callDate = null;
			if (noticePeriod!=null && !noticePeriod.prune().hasData()) noticePeriod = null;
			partyNoticePeriod = partyNoticePeriod.stream().filter(b->b!=null).<PartyNoticePeriod.PartyNoticePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (initialMargin!=null && !initialMargin.prune().hasData()) initialMargin = null;
			if (nearLeg!=null && !nearLeg.prune().hasData()) nearLeg = null;
			if (farLeg!=null && !farLeg.prune().hasData()) farLeg = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			repoChoice = repoChoice.stream().filter(b->b!=null).<RepoChoice.RepoChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (security!=null && !security.prune().hasData()) security = null;
			if (triParty!=null && !triParty.prune().hasData()) triParty = null;
			if (collateralArrangement!=null && !collateralArrangement.prune().hasData()) collateralArrangement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRateSchedule()!=null && getFixedRateSchedule().hasData()) return true;
			if (getFloatingRateCalculation()!=null && getFloatingRateCalculation().hasData()) return true;
			if (getResetFrequency()!=null && getResetFrequency().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getDuration()!=null) return true;
			if (getExtensionStyle()!=null) return true;
			if (getExtensionPeriod()!=null && getExtensionPeriod().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getEarliestCallDate()!=null && getEarliestCallDate().hasData()) return true;
			if (getCallDate()!=null && getCallDate().hasData()) return true;
			if (getNoticePeriod()!=null && getNoticePeriod().hasData()) return true;
			if (getPartyNoticePeriod()!=null && getPartyNoticePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialMargin()!=null && getInitialMargin().hasData()) return true;
			if (getNearLeg()!=null && getNearLeg().hasData()) return true;
			if (getFarLeg()!=null && getFarLeg().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			if (getRepoChoice()!=null && getRepoChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSecurity()!=null && getSecurity().hasData()) return true;
			if (getTriParty()!=null && getTriParty().hasData()) return true;
			if (getGeneralCollateral()!=null) return true;
			if (getCollateralArrangement()!=null && getCollateralArrangement().hasData()) return true;
			if (getEligibleForRehypothecation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Repo.RepoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Repo.RepoBuilder o = (Repo.RepoBuilder) other;
			
			merger.mergeRosetta(getFixedRateSchedule(), o.getFixedRateSchedule(), this::setFixedRateSchedule);
			merger.mergeRosetta(getFloatingRateCalculation(), o.getFloatingRateCalculation(), this::setFloatingRateCalculation);
			merger.mergeRosetta(getResetFrequency(), o.getResetFrequency(), this::setResetFrequency);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getExtensionPeriod(), o.getExtensionPeriod(), this::setExtensionPeriod);
			merger.mergeRosetta(getEarliestCallDate(), o.getEarliestCallDate(), this::setEarliestCallDate);
			merger.mergeRosetta(getCallDate(), o.getCallDate(), this::setCallDate);
			merger.mergeRosetta(getNoticePeriod(), o.getNoticePeriod(), this::setNoticePeriod);
			merger.mergeRosetta(getPartyNoticePeriod(), o.getPartyNoticePeriod(), this::getOrCreatePartyNoticePeriod);
			merger.mergeRosetta(getInitialMargin(), o.getInitialMargin(), this::setInitialMargin);
			merger.mergeRosetta(getNearLeg(), o.getNearLeg(), this::setNearLeg);
			merger.mergeRosetta(getFarLeg(), o.getFarLeg(), this::setFarLeg);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			merger.mergeRosetta(getRepoChoice(), o.getRepoChoice(), this::getOrCreateRepoChoice);
			merger.mergeRosetta(getSecurity(), o.getSecurity(), this::setSecurity);
			merger.mergeRosetta(getTriParty(), o.getTriParty(), this::setTriParty);
			merger.mergeRosetta(getCollateralArrangement(), o.getCollateralArrangement(), this::setCollateralArrangement);
			
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			merger.mergeBasic(getExtensionStyle(), o.getExtensionStyle(), this::setExtensionStyle);
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			merger.mergeBasic(getGeneralCollateral(), o.getGeneralCollateral(), this::setGeneralCollateral);
			merger.mergeBasic(getEligibleForRehypothecation(), o.getEligibleForRehypothecation(), this::setEligibleForRehypothecation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Repo _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateSchedule, _that.getFixedRateSchedule())) return false;
			if (!Objects.equals(floatingRateCalculation, _that.getFloatingRateCalculation())) return false;
			if (!Objects.equals(resetFrequency, _that.getResetFrequency())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(extensionStyle, _that.getExtensionStyle())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(earliestCallDate, _that.getEarliestCallDate())) return false;
			if (!Objects.equals(callDate, _that.getCallDate())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			if (!ListEquals.listEquals(partyNoticePeriod, _that.getPartyNoticePeriod())) return false;
			if (!Objects.equals(initialMargin, _that.getInitialMargin())) return false;
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			if (!ListEquals.listEquals(repoChoice, _that.getRepoChoice())) return false;
			if (!Objects.equals(security, _that.getSecurity())) return false;
			if (!Objects.equals(triParty, _that.getTriParty())) return false;
			if (!Objects.equals(generalCollateral, _that.getGeneralCollateral())) return false;
			if (!Objects.equals(collateralArrangement, _that.getCollateralArrangement())) return false;
			if (!Objects.equals(eligibleForRehypothecation, _that.getEligibleForRehypothecation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateSchedule != null ? fixedRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingRateCalculation != null ? floatingRateCalculation.hashCode() : 0);
			_result = 31 * _result + (resetFrequency != null ? resetFrequency.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionStyle != null ? extensionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (earliestCallDate != null ? earliestCallDate.hashCode() : 0);
			_result = 31 * _result + (callDate != null ? callDate.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			_result = 31 * _result + (partyNoticePeriod != null ? partyNoticePeriod.hashCode() : 0);
			_result = 31 * _result + (initialMargin != null ? initialMargin.hashCode() : 0);
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			_result = 31 * _result + (repoChoice != null ? repoChoice.hashCode() : 0);
			_result = 31 * _result + (security != null ? security.hashCode() : 0);
			_result = 31 * _result + (triParty != null ? triParty.hashCode() : 0);
			_result = 31 * _result + (generalCollateral != null ? generalCollateral.hashCode() : 0);
			_result = 31 * _result + (collateralArrangement != null ? collateralArrangement.hashCode() : 0);
			_result = 31 * _result + (eligibleForRehypothecation != null ? eligibleForRehypothecation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RepoBuilder {" +
				"fixedRateSchedule=" + this.fixedRateSchedule + ", " +
				"floatingRateCalculation=" + this.floatingRateCalculation + ", " +
				"resetFrequency=" + this.resetFrequency + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"duration=" + this.duration + ", " +
				"extensionStyle=" + this.extensionStyle + ", " +
				"extensionPeriod=" + this.extensionPeriod + ", " +
				"callingParty=" + this.callingParty + ", " +
				"earliestCallDate=" + this.earliestCallDate + ", " +
				"callDate=" + this.callDate + ", " +
				"noticePeriod=" + this.noticePeriod + ", " +
				"partyNoticePeriod=" + this.partyNoticePeriod + ", " +
				"initialMargin=" + this.initialMargin + ", " +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg + ", " +
				"paymentFrequency=" + this.paymentFrequency + ", " +
				"repoChoice=" + this.repoChoice + ", " +
				"security=" + this.security + ", " +
				"triParty=" + this.triParty + ", " +
				"generalCollateral=" + this.generalCollateral + ", " +
				"collateralArrangement=" + this.collateralArrangement + ", " +
				"eligibleForRehypothecation=" + this.eligibleForRehypothecation +
			'}' + " " + super.toString();
		}
	}
}
