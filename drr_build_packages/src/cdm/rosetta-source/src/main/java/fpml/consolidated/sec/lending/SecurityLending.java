package fpml.consolidated.sec.lending;

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
import fpml.consolidated.fpmlenum.ExtensionStyleEnum;
import fpml.consolidated.fpmlenum.SecLendCallingPartyEnum;
import fpml.consolidated.fpmlenum.SecurityLendingDurationEnum;
import fpml.consolidated.repo.AdjustableOffset;
import fpml.consolidated.repo.PartyNoticePeriod;
import fpml.consolidated.repo.SecurityValuation;
import fpml.consolidated.sec.lending.meta.SecurityLendingMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import java.math.BigDecimal;
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
 * Provision Global element representing a Security Lending transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Global element representing a Security Lending transaction.
 *
 */
@RosettaDataType(value="SecurityLending", builder=SecurityLending.SecurityLendingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecurityLending", model="fpml", builder=SecurityLending.SecurityLendingBuilderImpl.class, version="2.1.1")
public interface SecurityLending extends Product {

	SecurityLendingMeta metaData = new SecurityLendingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that lends the asset(s) exchanged in the context of the containing structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that lends the asset(s) exchanged in the context of the containing structure.
	 *
	 */
	PartyReference getLenderPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that lends the asset(s) exchanged in the context of the containing structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that lends the asset(s) exchanged in the context of the containing structure.
	 *
	 */
	AccountReference getLenderAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that borrows the asset(s) exchanged in the context of the containing structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that borrows the asset(s) exchanged in the context of the containing structure.
	 *
	 */
	PartyReference getBorrowerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that borrows the asset(s) exchanged in the context of the containing structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that borrows the asset(s) exchanged in the context of the containing structure.
	 *
	 */
	AccountReference getBorrowerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The security (principal) which is the subject of the lending transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The security (principal) which is the subject of the lending transaction.
	 *
	 */
	SecurityValuation getPrincipal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Initiation of the security lending transaction: initial transfer of principal.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Initiation of the security lending transaction: initial transfer of principal.
	 *
	 */
	SecLendInitiation getInitiation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Termination of the security lending transaction: return of principal.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Termination of the security lending transaction: return of principal.
	 *
	 */
	SecLendTermination getTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Duration of the security lending transaction. {e.g. Open, Term}.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Duration of the security lending transaction. {e.g. Open, Term}.
	 *
	 */
	SecurityLendingDurationEnum getDuration();
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
	 * Provision The party to the open security lending transaction that has a right to demand exercise of the far leg of the open security lending transaction. This element represents an enumerated list that includes: Borrower, Lender, Either and AsDefinedInMasterAgreement. In the default case, either party can call for closing an open security lending transaction. If electing parties are defined in the Master Agreement and not in the open security lending confirmation, the value AsDefinedInMasterAgreement should be used. Exact borrower/lender related parties, including any third parties who can demand exercise of open security lending transactions on behalf of the parties to the trade (calculation agent, executing broker, etc.), can be defined in the relatedParty element (tradeHeader/partyTradeInformation).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party to the open security lending transaction that has a right to demand exercise of the far leg of the open security lending transaction. This element represents an enumerated list that includes: Borrower, Lender, Either and AsDefinedInMasterAgreement. In the default case, either party can call for closing an open security lending transaction. If electing parties are defined in the Master Agreement and not in the open security lending confirmation, the value AsDefinedInMasterAgreement should be used. Exact borrower/lender related parties, including any third parties who can demand exercise of open security lending transactions on behalf of the parties to the trade (calculation agent, executing broker, etc.), can be defined in the relatedParty element (tradeHeader/partyTradeInformation).
	 *
	 */
	SecLendCallingPartyEnum getCallingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the latest date when the open security lending transaction can and must be exercised on demand by a party to the trade indicated in the electingParty element (or in the Master Agreement, if the electingParty element has AsDefinedInMasterAgreement value). For instance, in an open security lending transaction with the callDate agreed as business day one year after the trade date, the far leg can be settled on any day after the near leg settlement date and before and including the callDate. If the call date is not defined in trade terms and / or not included into the trade confirmation this element can be omitted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the latest date when the open security lending transaction can and must be exercised on demand by a party to the trade indicated in the electingParty element (or in the Master Agreement, if the electingParty element has AsDefinedInMasterAgreement value). For instance, in an open security lending transaction with the callDate agreed as business day one year after the trade date, the far leg can be settled on any day after the near leg settlement date and before and including the callDate. If the call date is not defined in trade terms and / or not included into the trade confirmation this element can be omitted.
	 *
	 */
	AdjustableOrRelativeDate getCallDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notice period for open security lending transactions in number of days. This element represents the agreed period of notice to be given in advance before exercise of the security lending trade by a party requesting such exercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notice period for open security lending transactions in number of days. This element represents the agreed period of notice to be given in advance before exercise of the security lending trade by a party requesting such exercise.
	 *
	 */
	AdjustableOffset getNoticePeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Notice period for open security lending transactions referenced to a party to the trade, in number of days. This element represents the agreed period of notice to be given in advance before exercise of the security lending trade by a party requesting such exercise and the reference to that party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notice period for open security lending transactions referenced to a party to the trade, in number of days. This element represents the agreed period of notice to be given in advance before exercise of the security lending trade by a party requesting such exercise and the reference to that party.
	 *
	 */
	List<? extends PartyNoticePeriod> getPartyNoticePeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Under a non-cash collateralized transaction, the borrower pays a fee on the security being lent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Under a non-cash collateralized transaction, the borrower pays a fee on the security being lent.
	 *
	 */
	SecLendFeeCalculation getFee();
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
	SecLendRebateCalculation getRebate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count fraction for calculating a fee or a rebate on an SBL transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count fraction for calculating a fee or a rebate on an SBL transaction.
	 *
	 */
	DayCountFraction getDayCountFraction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the proportion of the value of the dividend on the borrowed shares that the borrower is legally obligated to return to the lender.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the proportion of the value of the dividend on the borrowed shares that the borrower is legally obligated to return to the lender.
	 *
	 */
	BigDecimal getDividendRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A minimum billable amount (daily fee increments accrue until a threshold is crossed, at which point payment becomes due)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A minimum billable amount (daily fee increments accrue until a threshold is crossed, at which point payment becomes due)
	 *
	 */
	PositiveMoney getMinimumBillingAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Time "period" and "periodMultiplier", describing frequency of payments for the floating rebate rate. Usually, the payment frequency is monthly, or daily. Business rule: Floating Rate Payment Frequency may be specified, in case of Floating Rebate Rate. (The assumption is that fee payment and rebate fixed rate payment are term payments, and rebate floating rate payment is periodic payment.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Time "period" and "periodMultiplier", describing frequency of payments for the floating rebate rate. Usually, the payment frequency is monthly, or daily. Business rule: Floating Rate Payment Frequency may be specified, in case of Floating Rebate Rate. (The assumption is that fee payment and rebate fixed rate payment are term payments, and rebate floating rate payment is periodic payment.)
	 *
	 */
	Frequency getRebatePaymentFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Collateral provisions component derives collateral information from the Master Agreement documentation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Collateral provisions component derives collateral information from the Master Agreement documentation.
	 *
	 */
	SecLendCollateralProvisions getCollateralProvisions();

	/*********************** Build Methods  ***********************/
	SecurityLending build();
	
	SecurityLending.SecurityLendingBuilder toBuilder();
	
	static SecurityLending.SecurityLendingBuilder builder() {
		return new SecurityLending.SecurityLendingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecurityLending> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecurityLending> getType() {
		return SecurityLending.class;
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
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("lenderAccountReference"), processor, AccountReference.class, getLenderAccountReference());
		processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.class, getBorrowerPartyReference());
		processRosetta(path.newSubPath("borrowerAccountReference"), processor, AccountReference.class, getBorrowerAccountReference());
		processRosetta(path.newSubPath("principal"), processor, SecurityValuation.class, getPrincipal());
		processRosetta(path.newSubPath("initiation"), processor, SecLendInitiation.class, getInitiation());
		processRosetta(path.newSubPath("termination"), processor, SecLendTermination.class, getTermination());
		processor.processBasic(path.newSubPath("duration"), SecurityLendingDurationEnum.class, getDuration(), this);
		processor.processBasic(path.newSubPath("extensionStyle"), ExtensionStyleEnum.class, getExtensionStyle(), this);
		processRosetta(path.newSubPath("extensionPeriod"), processor, AdjustableOffset.class, getExtensionPeriod());
		processor.processBasic(path.newSubPath("callingParty"), SecLendCallingPartyEnum.class, getCallingParty(), this);
		processRosetta(path.newSubPath("callDate"), processor, AdjustableOrRelativeDate.class, getCallDate());
		processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.class, getNoticePeriod());
		processRosetta(path.newSubPath("partyNoticePeriod"), processor, PartyNoticePeriod.class, getPartyNoticePeriod());
		processRosetta(path.newSubPath("fee"), processor, SecLendFeeCalculation.class, getFee());
		processRosetta(path.newSubPath("rebate"), processor, SecLendRebateCalculation.class, getRebate());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processor.processBasic(path.newSubPath("dividendRate"), BigDecimal.class, getDividendRate(), this);
		processRosetta(path.newSubPath("minimumBillingAmount"), processor, PositiveMoney.class, getMinimumBillingAmount());
		processRosetta(path.newSubPath("rebatePaymentFrequency"), processor, Frequency.class, getRebatePaymentFrequency());
		processRosetta(path.newSubPath("collateralProvisions"), processor, SecLendCollateralProvisions.class, getCollateralProvisions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecurityLendingBuilder extends SecurityLending, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateLenderPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getLenderPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateLenderAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getLenderAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBorrowerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBorrowerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBorrowerAccountReference();
		SecurityValuation.SecurityValuationBuilder getOrCreatePrincipal();
		@Override
		SecurityValuation.SecurityValuationBuilder getPrincipal();
		SecLendInitiation.SecLendInitiationBuilder getOrCreateInitiation();
		@Override
		SecLendInitiation.SecLendInitiationBuilder getInitiation();
		SecLendTermination.SecLendTerminationBuilder getOrCreateTermination();
		@Override
		SecLendTermination.SecLendTerminationBuilder getTermination();
		AdjustableOffset.AdjustableOffsetBuilder getOrCreateExtensionPeriod();
		@Override
		AdjustableOffset.AdjustableOffsetBuilder getExtensionPeriod();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCallDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCallDate();
		AdjustableOffset.AdjustableOffsetBuilder getOrCreateNoticePeriod();
		@Override
		AdjustableOffset.AdjustableOffsetBuilder getNoticePeriod();
		PartyNoticePeriod.PartyNoticePeriodBuilder getOrCreatePartyNoticePeriod(int index);
		@Override
		List<? extends PartyNoticePeriod.PartyNoticePeriodBuilder> getPartyNoticePeriod();
		SecLendFeeCalculation.SecLendFeeCalculationBuilder getOrCreateFee();
		@Override
		SecLendFeeCalculation.SecLendFeeCalculationBuilder getFee();
		SecLendRebateCalculation.SecLendRebateCalculationBuilder getOrCreateRebate();
		@Override
		SecLendRebateCalculation.SecLendRebateCalculationBuilder getRebate();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumBillingAmount();
		@Override
		PositiveMoney.PositiveMoneyBuilder getMinimumBillingAmount();
		Frequency.FrequencyBuilder getOrCreateRebatePaymentFrequency();
		@Override
		Frequency.FrequencyBuilder getRebatePaymentFrequency();
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder getOrCreateCollateralProvisions();
		@Override
		SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder getCollateralProvisions();
		@Override
		SecurityLending.SecurityLendingBuilder setId(String id);
		@Override
		SecurityLending.SecurityLendingBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		SecurityLending.SecurityLendingBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		SecurityLending.SecurityLendingBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		SecurityLending.SecurityLendingBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		SecurityLending.SecurityLendingBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		SecurityLending.SecurityLendingBuilder addProductType(ProductType productType);
		@Override
		SecurityLending.SecurityLendingBuilder addProductType(ProductType productType, int idx);
		@Override
		SecurityLending.SecurityLendingBuilder addProductType(List<? extends ProductType> productType);
		@Override
		SecurityLending.SecurityLendingBuilder setProductType(List<? extends ProductType> productType);
		@Override
		SecurityLending.SecurityLendingBuilder addProductId(ProductId productId);
		@Override
		SecurityLending.SecurityLendingBuilder addProductId(ProductId productId, int idx);
		@Override
		SecurityLending.SecurityLendingBuilder addProductId(List<? extends ProductId> productId);
		@Override
		SecurityLending.SecurityLendingBuilder setProductId(List<? extends ProductId> productId);
		@Override
		SecurityLending.SecurityLendingBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		SecurityLending.SecurityLendingBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		SecurityLending.SecurityLendingBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		SecurityLending.SecurityLendingBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		SecurityLending.SecurityLendingBuilder addAssetClass(AssetClass assetClass);
		@Override
		SecurityLending.SecurityLendingBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		SecurityLending.SecurityLendingBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		SecurityLending.SecurityLendingBuilder setAssetClass(List<? extends AssetClass> assetClass);
		SecurityLending.SecurityLendingBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		SecurityLending.SecurityLendingBuilder setLenderAccountReference(AccountReference lenderAccountReference);
		SecurityLending.SecurityLendingBuilder setBorrowerPartyReference(PartyReference borrowerPartyReference);
		SecurityLending.SecurityLendingBuilder setBorrowerAccountReference(AccountReference borrowerAccountReference);
		SecurityLending.SecurityLendingBuilder setPrincipal(SecurityValuation principal);
		SecurityLending.SecurityLendingBuilder setInitiation(SecLendInitiation initiation);
		SecurityLending.SecurityLendingBuilder setTermination(SecLendTermination termination);
		SecurityLending.SecurityLendingBuilder setDuration(SecurityLendingDurationEnum duration);
		SecurityLending.SecurityLendingBuilder setExtensionStyle(ExtensionStyleEnum extensionStyle);
		SecurityLending.SecurityLendingBuilder setExtensionPeriod(AdjustableOffset extensionPeriod);
		SecurityLending.SecurityLendingBuilder setCallingParty(SecLendCallingPartyEnum callingParty);
		SecurityLending.SecurityLendingBuilder setCallDate(AdjustableOrRelativeDate callDate);
		SecurityLending.SecurityLendingBuilder setNoticePeriod(AdjustableOffset noticePeriod);
		SecurityLending.SecurityLendingBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod);
		SecurityLending.SecurityLendingBuilder addPartyNoticePeriod(PartyNoticePeriod partyNoticePeriod, int idx);
		SecurityLending.SecurityLendingBuilder addPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriod);
		SecurityLending.SecurityLendingBuilder setPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriod);
		SecurityLending.SecurityLendingBuilder setFee(SecLendFeeCalculation fee);
		SecurityLending.SecurityLendingBuilder setRebate(SecLendRebateCalculation rebate);
		SecurityLending.SecurityLendingBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		SecurityLending.SecurityLendingBuilder setDividendRate(BigDecimal dividendRate);
		SecurityLending.SecurityLendingBuilder setMinimumBillingAmount(PositiveMoney minimumBillingAmount);
		SecurityLending.SecurityLendingBuilder setRebatePaymentFrequency(Frequency rebatePaymentFrequency);
		SecurityLending.SecurityLendingBuilder setCollateralProvisions(SecLendCollateralProvisions collateralProvisions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("lenderAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getLenderAccountReference());
			processRosetta(path.newSubPath("borrowerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBorrowerPartyReference());
			processRosetta(path.newSubPath("borrowerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBorrowerAccountReference());
			processRosetta(path.newSubPath("principal"), processor, SecurityValuation.SecurityValuationBuilder.class, getPrincipal());
			processRosetta(path.newSubPath("initiation"), processor, SecLendInitiation.SecLendInitiationBuilder.class, getInitiation());
			processRosetta(path.newSubPath("termination"), processor, SecLendTermination.SecLendTerminationBuilder.class, getTermination());
			processor.processBasic(path.newSubPath("duration"), SecurityLendingDurationEnum.class, getDuration(), this);
			processor.processBasic(path.newSubPath("extensionStyle"), ExtensionStyleEnum.class, getExtensionStyle(), this);
			processRosetta(path.newSubPath("extensionPeriod"), processor, AdjustableOffset.AdjustableOffsetBuilder.class, getExtensionPeriod());
			processor.processBasic(path.newSubPath("callingParty"), SecLendCallingPartyEnum.class, getCallingParty(), this);
			processRosetta(path.newSubPath("callDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCallDate());
			processRosetta(path.newSubPath("noticePeriod"), processor, AdjustableOffset.AdjustableOffsetBuilder.class, getNoticePeriod());
			processRosetta(path.newSubPath("partyNoticePeriod"), processor, PartyNoticePeriod.PartyNoticePeriodBuilder.class, getPartyNoticePeriod());
			processRosetta(path.newSubPath("fee"), processor, SecLendFeeCalculation.SecLendFeeCalculationBuilder.class, getFee());
			processRosetta(path.newSubPath("rebate"), processor, SecLendRebateCalculation.SecLendRebateCalculationBuilder.class, getRebate());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processor.processBasic(path.newSubPath("dividendRate"), BigDecimal.class, getDividendRate(), this);
			processRosetta(path.newSubPath("minimumBillingAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getMinimumBillingAmount());
			processRosetta(path.newSubPath("rebatePaymentFrequency"), processor, Frequency.FrequencyBuilder.class, getRebatePaymentFrequency());
			processRosetta(path.newSubPath("collateralProvisions"), processor, SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder.class, getCollateralProvisions());
		}
		

		SecurityLending.SecurityLendingBuilder prune();
	}

	/*********************** Immutable Implementation of SecurityLending  ***********************/
	class SecurityLendingImpl extends Product.ProductImpl implements SecurityLending {
		private final PartyReference lenderPartyReference;
		private final AccountReference lenderAccountReference;
		private final PartyReference borrowerPartyReference;
		private final AccountReference borrowerAccountReference;
		private final SecurityValuation principal;
		private final SecLendInitiation initiation;
		private final SecLendTermination termination;
		private final SecurityLendingDurationEnum duration;
		private final ExtensionStyleEnum extensionStyle;
		private final AdjustableOffset extensionPeriod;
		private final SecLendCallingPartyEnum callingParty;
		private final AdjustableOrRelativeDate callDate;
		private final AdjustableOffset noticePeriod;
		private final List<? extends PartyNoticePeriod> partyNoticePeriod;
		private final SecLendFeeCalculation fee;
		private final SecLendRebateCalculation rebate;
		private final DayCountFraction dayCountFraction;
		private final BigDecimal dividendRate;
		private final PositiveMoney minimumBillingAmount;
		private final Frequency rebatePaymentFrequency;
		private final SecLendCollateralProvisions collateralProvisions;
		
		protected SecurityLendingImpl(SecurityLending.SecurityLendingBuilder builder) {
			super(builder);
			this.lenderPartyReference = ofNullable(builder.getLenderPartyReference()).map(f->f.build()).orElse(null);
			this.lenderAccountReference = ofNullable(builder.getLenderAccountReference()).map(f->f.build()).orElse(null);
			this.borrowerPartyReference = ofNullable(builder.getBorrowerPartyReference()).map(f->f.build()).orElse(null);
			this.borrowerAccountReference = ofNullable(builder.getBorrowerAccountReference()).map(f->f.build()).orElse(null);
			this.principal = ofNullable(builder.getPrincipal()).map(f->f.build()).orElse(null);
			this.initiation = ofNullable(builder.getInitiation()).map(f->f.build()).orElse(null);
			this.termination = ofNullable(builder.getTermination()).map(f->f.build()).orElse(null);
			this.duration = builder.getDuration();
			this.extensionStyle = builder.getExtensionStyle();
			this.extensionPeriod = ofNullable(builder.getExtensionPeriod()).map(f->f.build()).orElse(null);
			this.callingParty = builder.getCallingParty();
			this.callDate = ofNullable(builder.getCallDate()).map(f->f.build()).orElse(null);
			this.noticePeriod = ofNullable(builder.getNoticePeriod()).map(f->f.build()).orElse(null);
			this.partyNoticePeriod = ofNullable(builder.getPartyNoticePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.fee = ofNullable(builder.getFee()).map(f->f.build()).orElse(null);
			this.rebate = ofNullable(builder.getRebate()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.dividendRate = builder.getDividendRate();
			this.minimumBillingAmount = ofNullable(builder.getMinimumBillingAmount()).map(f->f.build()).orElse(null);
			this.rebatePaymentFrequency = ofNullable(builder.getRebatePaymentFrequency()).map(f->f.build()).orElse(null);
			this.collateralProvisions = ofNullable(builder.getCollateralProvisions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lenderPartyReference")
		public PartyReference getLenderPartyReference() {
			return lenderPartyReference;
		}
		
		@Override
		@RosettaAttribute("lenderAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lenderAccountReference")
		public AccountReference getLenderAccountReference() {
			return lenderAccountReference;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		public PartyReference getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		@RosettaAttribute("borrowerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("borrowerAccountReference")
		public AccountReference getBorrowerAccountReference() {
			return borrowerAccountReference;
		}
		
		@Override
		@RosettaAttribute("principal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("principal")
		public SecurityValuation getPrincipal() {
			return principal;
		}
		
		@Override
		@RosettaAttribute("initiation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initiation")
		public SecLendInitiation getInitiation() {
			return initiation;
		}
		
		@Override
		@RosettaAttribute("termination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termination")
		public SecLendTermination getTermination() {
			return termination;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("duration")
		public SecurityLendingDurationEnum getDuration() {
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
		public SecLendCallingPartyEnum getCallingParty() {
			return callingParty;
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
		@RosettaAttribute("fee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fee")
		public SecLendFeeCalculation getFee() {
			return fee;
		}
		
		@Override
		@RosettaAttribute("rebate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebate")
		public SecLendRebateCalculation getRebate() {
			return rebate;
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
		@RosettaAttribute("dividendRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendRate")
		public BigDecimal getDividendRate() {
			return dividendRate;
		}
		
		@Override
		@RosettaAttribute("minimumBillingAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumBillingAmount")
		public PositiveMoney getMinimumBillingAmount() {
			return minimumBillingAmount;
		}
		
		@Override
		@RosettaAttribute("rebatePaymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebatePaymentFrequency")
		public Frequency getRebatePaymentFrequency() {
			return rebatePaymentFrequency;
		}
		
		@Override
		@RosettaAttribute("collateralProvisions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralProvisions")
		public SecLendCollateralProvisions getCollateralProvisions() {
			return collateralProvisions;
		}
		
		@Override
		public SecurityLending build() {
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder toBuilder() {
			SecurityLending.SecurityLendingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityLending.SecurityLendingBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLenderPartyReference()).ifPresent(builder::setLenderPartyReference);
			ofNullable(getLenderAccountReference()).ifPresent(builder::setLenderAccountReference);
			ofNullable(getBorrowerPartyReference()).ifPresent(builder::setBorrowerPartyReference);
			ofNullable(getBorrowerAccountReference()).ifPresent(builder::setBorrowerAccountReference);
			ofNullable(getPrincipal()).ifPresent(builder::setPrincipal);
			ofNullable(getInitiation()).ifPresent(builder::setInitiation);
			ofNullable(getTermination()).ifPresent(builder::setTermination);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getExtensionStyle()).ifPresent(builder::setExtensionStyle);
			ofNullable(getExtensionPeriod()).ifPresent(builder::setExtensionPeriod);
			ofNullable(getCallingParty()).ifPresent(builder::setCallingParty);
			ofNullable(getCallDate()).ifPresent(builder::setCallDate);
			ofNullable(getNoticePeriod()).ifPresent(builder::setNoticePeriod);
			ofNullable(getPartyNoticePeriod()).ifPresent(builder::setPartyNoticePeriod);
			ofNullable(getFee()).ifPresent(builder::setFee);
			ofNullable(getRebate()).ifPresent(builder::setRebate);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getDividendRate()).ifPresent(builder::setDividendRate);
			ofNullable(getMinimumBillingAmount()).ifPresent(builder::setMinimumBillingAmount);
			ofNullable(getRebatePaymentFrequency()).ifPresent(builder::setRebatePaymentFrequency);
			ofNullable(getCollateralProvisions()).ifPresent(builder::setCollateralProvisions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecurityLending _that = getType().cast(o);
		
			if (!Objects.equals(lenderPartyReference, _that.getLenderPartyReference())) return false;
			if (!Objects.equals(lenderAccountReference, _that.getLenderAccountReference())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(borrowerAccountReference, _that.getBorrowerAccountReference())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			if (!Objects.equals(initiation, _that.getInitiation())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(extensionStyle, _that.getExtensionStyle())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(callDate, _that.getCallDate())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			if (!ListEquals.listEquals(partyNoticePeriod, _that.getPartyNoticePeriod())) return false;
			if (!Objects.equals(fee, _that.getFee())) return false;
			if (!Objects.equals(rebate, _that.getRebate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(dividendRate, _that.getDividendRate())) return false;
			if (!Objects.equals(minimumBillingAmount, _that.getMinimumBillingAmount())) return false;
			if (!Objects.equals(rebatePaymentFrequency, _that.getRebatePaymentFrequency())) return false;
			if (!Objects.equals(collateralProvisions, _that.getCollateralProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lenderPartyReference != null ? lenderPartyReference.hashCode() : 0);
			_result = 31 * _result + (lenderAccountReference != null ? lenderAccountReference.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (borrowerAccountReference != null ? borrowerAccountReference.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			_result = 31 * _result + (initiation != null ? initiation.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionStyle != null ? extensionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callDate != null ? callDate.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			_result = 31 * _result + (partyNoticePeriod != null ? partyNoticePeriod.hashCode() : 0);
			_result = 31 * _result + (fee != null ? fee.hashCode() : 0);
			_result = 31 * _result + (rebate != null ? rebate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (dividendRate != null ? dividendRate.hashCode() : 0);
			_result = 31 * _result + (minimumBillingAmount != null ? minimumBillingAmount.hashCode() : 0);
			_result = 31 * _result + (rebatePaymentFrequency != null ? rebatePaymentFrequency.hashCode() : 0);
			_result = 31 * _result + (collateralProvisions != null ? collateralProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityLending {" +
				"lenderPartyReference=" + this.lenderPartyReference + ", " +
				"lenderAccountReference=" + this.lenderAccountReference + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"borrowerAccountReference=" + this.borrowerAccountReference + ", " +
				"principal=" + this.principal + ", " +
				"initiation=" + this.initiation + ", " +
				"termination=" + this.termination + ", " +
				"duration=" + this.duration + ", " +
				"extensionStyle=" + this.extensionStyle + ", " +
				"extensionPeriod=" + this.extensionPeriod + ", " +
				"callingParty=" + this.callingParty + ", " +
				"callDate=" + this.callDate + ", " +
				"noticePeriod=" + this.noticePeriod + ", " +
				"partyNoticePeriod=" + this.partyNoticePeriod + ", " +
				"fee=" + this.fee + ", " +
				"rebate=" + this.rebate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"dividendRate=" + this.dividendRate + ", " +
				"minimumBillingAmount=" + this.minimumBillingAmount + ", " +
				"rebatePaymentFrequency=" + this.rebatePaymentFrequency + ", " +
				"collateralProvisions=" + this.collateralProvisions +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SecurityLending  ***********************/
	class SecurityLendingBuilderImpl extends Product.ProductBuilderImpl implements SecurityLending.SecurityLendingBuilder {
	
		protected PartyReference.PartyReferenceBuilder lenderPartyReference;
		protected AccountReference.AccountReferenceBuilder lenderAccountReference;
		protected PartyReference.PartyReferenceBuilder borrowerPartyReference;
		protected AccountReference.AccountReferenceBuilder borrowerAccountReference;
		protected SecurityValuation.SecurityValuationBuilder principal;
		protected SecLendInitiation.SecLendInitiationBuilder initiation;
		protected SecLendTermination.SecLendTerminationBuilder termination;
		protected SecurityLendingDurationEnum duration;
		protected ExtensionStyleEnum extensionStyle;
		protected AdjustableOffset.AdjustableOffsetBuilder extensionPeriod;
		protected SecLendCallingPartyEnum callingParty;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder callDate;
		protected AdjustableOffset.AdjustableOffsetBuilder noticePeriod;
		protected List<PartyNoticePeriod.PartyNoticePeriodBuilder> partyNoticePeriod = new ArrayList<>();
		protected SecLendFeeCalculation.SecLendFeeCalculationBuilder fee;
		protected SecLendRebateCalculation.SecLendRebateCalculationBuilder rebate;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected BigDecimal dividendRate;
		protected PositiveMoney.PositiveMoneyBuilder minimumBillingAmount;
		protected Frequency.FrequencyBuilder rebatePaymentFrequency;
		protected SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder collateralProvisions;
		
		@Override
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lenderPartyReference")
		public PartyReference.PartyReferenceBuilder getLenderPartyReference() {
			return lenderPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateLenderPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (lenderPartyReference!=null) {
				result = lenderPartyReference;
			}
			else {
				result = lenderPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lenderAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lenderAccountReference")
		public AccountReference.AccountReferenceBuilder getLenderAccountReference() {
			return lenderAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateLenderAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (lenderAccountReference!=null) {
				result = lenderAccountReference;
			}
			else {
				result = lenderAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		public PartyReference.PartyReferenceBuilder getBorrowerPartyReference() {
			return borrowerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBorrowerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (borrowerPartyReference!=null) {
				result = borrowerPartyReference;
			}
			else {
				result = borrowerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("borrowerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("borrowerAccountReference")
		public AccountReference.AccountReferenceBuilder getBorrowerAccountReference() {
			return borrowerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBorrowerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (borrowerAccountReference!=null) {
				result = borrowerAccountReference;
			}
			else {
				result = borrowerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("principal")
		public SecurityValuation.SecurityValuationBuilder getPrincipal() {
			return principal;
		}
		
		@Override
		public SecurityValuation.SecurityValuationBuilder getOrCreatePrincipal() {
			SecurityValuation.SecurityValuationBuilder result;
			if (principal!=null) {
				result = principal;
			}
			else {
				result = principal = SecurityValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initiation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("initiation")
		public SecLendInitiation.SecLendInitiationBuilder getInitiation() {
			return initiation;
		}
		
		@Override
		public SecLendInitiation.SecLendInitiationBuilder getOrCreateInitiation() {
			SecLendInitiation.SecLendInitiationBuilder result;
			if (initiation!=null) {
				result = initiation;
			}
			else {
				result = initiation = SecLendInitiation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termination")
		public SecLendTermination.SecLendTerminationBuilder getTermination() {
			return termination;
		}
		
		@Override
		public SecLendTermination.SecLendTerminationBuilder getOrCreateTermination() {
			SecLendTermination.SecLendTerminationBuilder result;
			if (termination!=null) {
				result = termination;
			}
			else {
				result = termination = SecLendTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("duration")
		public SecurityLendingDurationEnum getDuration() {
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
		public SecLendCallingPartyEnum getCallingParty() {
			return callingParty;
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
		@RosettaAttribute("fee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fee")
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder getFee() {
			return fee;
		}
		
		@Override
		public SecLendFeeCalculation.SecLendFeeCalculationBuilder getOrCreateFee() {
			SecLendFeeCalculation.SecLendFeeCalculationBuilder result;
			if (fee!=null) {
				result = fee;
			}
			else {
				result = fee = SecLendFeeCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rebate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebate")
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder getRebate() {
			return rebate;
		}
		
		@Override
		public SecLendRebateCalculation.SecLendRebateCalculationBuilder getOrCreateRebate() {
			SecLendRebateCalculation.SecLendRebateCalculationBuilder result;
			if (rebate!=null) {
				result = rebate;
			}
			else {
				result = rebate = SecLendRebateCalculation.builder();
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
		@RosettaAttribute("dividendRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dividendRate")
		public BigDecimal getDividendRate() {
			return dividendRate;
		}
		
		@Override
		@RosettaAttribute("minimumBillingAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumBillingAmount")
		public PositiveMoney.PositiveMoneyBuilder getMinimumBillingAmount() {
			return minimumBillingAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateMinimumBillingAmount() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (minimumBillingAmount!=null) {
				result = minimumBillingAmount;
			}
			else {
				result = minimumBillingAmount = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rebatePaymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rebatePaymentFrequency")
		public Frequency.FrequencyBuilder getRebatePaymentFrequency() {
			return rebatePaymentFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateRebatePaymentFrequency() {
			Frequency.FrequencyBuilder result;
			if (rebatePaymentFrequency!=null) {
				result = rebatePaymentFrequency;
			}
			else {
				result = rebatePaymentFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralProvisions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralProvisions")
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder getCollateralProvisions() {
			return collateralProvisions;
		}
		
		@Override
		public SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder getOrCreateCollateralProvisions() {
			SecLendCollateralProvisions.SecLendCollateralProvisionsBuilder result;
			if (collateralProvisions!=null) {
				result = collateralProvisions;
			}
			else {
				result = collateralProvisions = SecLendCollateralProvisions.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SecurityLending.SecurityLendingBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public SecurityLending.SecurityLendingBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public SecurityLending.SecurityLendingBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public SecurityLending.SecurityLendingBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public SecurityLending.SecurityLendingBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public SecurityLending.SecurityLendingBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public SecurityLending.SecurityLendingBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addProductId(List<? extends ProductId> productIds) {
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
		public SecurityLending.SecurityLendingBuilder setProductId(List<? extends ProductId> productIds) {
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
		public SecurityLending.SecurityLendingBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public SecurityLending.SecurityLendingBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public SecurityLending.SecurityLendingBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public SecurityLending.SecurityLendingBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lenderPartyReference")
		@Override
		public SecurityLending.SecurityLendingBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderAccountReference")
		@Override
		public SecurityLending.SecurityLendingBuilder setLenderAccountReference(AccountReference _lenderAccountReference) {
			this.lenderAccountReference = _lenderAccountReference == null ? null : _lenderAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("borrowerPartyReference")
		@Override
		public SecurityLending.SecurityLendingBuilder setBorrowerPartyReference(PartyReference _borrowerPartyReference) {
			this.borrowerPartyReference = _borrowerPartyReference == null ? null : _borrowerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("borrowerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("borrowerAccountReference")
		@Override
		public SecurityLending.SecurityLendingBuilder setBorrowerAccountReference(AccountReference _borrowerAccountReference) {
			this.borrowerAccountReference = _borrowerAccountReference == null ? null : _borrowerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principal")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("principal")
		@Override
		public SecurityLending.SecurityLendingBuilder setPrincipal(SecurityValuation _principal) {
			this.principal = _principal == null ? null : _principal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("initiation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initiation")
		@Override
		public SecurityLending.SecurityLendingBuilder setInitiation(SecLendInitiation _initiation) {
			this.initiation = _initiation == null ? null : _initiation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public SecurityLending.SecurityLendingBuilder setTermination(SecLendTermination _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("duration")
		@Override
		public SecurityLending.SecurityLendingBuilder setDuration(SecurityLendingDurationEnum _duration) {
			this.duration = _duration == null ? null : _duration;
			return this;
		}
		
		@RosettaAttribute("extensionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extensionStyle")
		@Override
		public SecurityLending.SecurityLendingBuilder setExtensionStyle(ExtensionStyleEnum _extensionStyle) {
			this.extensionStyle = _extensionStyle == null ? null : _extensionStyle;
			return this;
		}
		
		@RosettaAttribute("extensionPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extensionPeriod")
		@Override
		public SecurityLending.SecurityLendingBuilder setExtensionPeriod(AdjustableOffset _extensionPeriod) {
			this.extensionPeriod = _extensionPeriod == null ? null : _extensionPeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callingParty")
		@Override
		public SecurityLending.SecurityLendingBuilder setCallingParty(SecLendCallingPartyEnum _callingParty) {
			this.callingParty = _callingParty == null ? null : _callingParty;
			return this;
		}
		
		@RosettaAttribute("callDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callDate")
		@Override
		public SecurityLending.SecurityLendingBuilder setCallDate(AdjustableOrRelativeDate _callDate) {
			this.callDate = _callDate == null ? null : _callDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("noticePeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noticePeriod")
		@Override
		public SecurityLending.SecurityLendingBuilder setNoticePeriod(AdjustableOffset _noticePeriod) {
			this.noticePeriod = _noticePeriod == null ? null : _noticePeriod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyNoticePeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyNoticePeriod")
		@Override
		public SecurityLending.SecurityLendingBuilder addPartyNoticePeriod(PartyNoticePeriod _partyNoticePeriod) {
			if (_partyNoticePeriod != null) {
				this.partyNoticePeriod.add(_partyNoticePeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addPartyNoticePeriod(PartyNoticePeriod _partyNoticePeriod, int idx) {
			getIndex(this.partyNoticePeriod, idx, () -> _partyNoticePeriod.toBuilder());
			return this;
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder addPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriods) {
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
		public SecurityLending.SecurityLendingBuilder setPartyNoticePeriod(List<? extends PartyNoticePeriod> partyNoticePeriods) {
			if (partyNoticePeriods == null) {
				this.partyNoticePeriod = new ArrayList<>();
			} else {
				this.partyNoticePeriod = partyNoticePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fee")
		@Override
		public SecurityLending.SecurityLendingBuilder setFee(SecLendFeeCalculation _fee) {
			this.fee = _fee == null ? null : _fee.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rebate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rebate")
		@Override
		public SecurityLending.SecurityLendingBuilder setRebate(SecLendRebateCalculation _rebate) {
			this.rebate = _rebate == null ? null : _rebate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dayCountFraction")
		@Override
		public SecurityLending.SecurityLendingBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dividendRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dividendRate")
		@Override
		public SecurityLending.SecurityLendingBuilder setDividendRate(BigDecimal _dividendRate) {
			this.dividendRate = _dividendRate == null ? null : _dividendRate;
			return this;
		}
		
		@RosettaAttribute("minimumBillingAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumBillingAmount")
		@Override
		public SecurityLending.SecurityLendingBuilder setMinimumBillingAmount(PositiveMoney _minimumBillingAmount) {
			this.minimumBillingAmount = _minimumBillingAmount == null ? null : _minimumBillingAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rebatePaymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rebatePaymentFrequency")
		@Override
		public SecurityLending.SecurityLendingBuilder setRebatePaymentFrequency(Frequency _rebatePaymentFrequency) {
			this.rebatePaymentFrequency = _rebatePaymentFrequency == null ? null : _rebatePaymentFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralProvisions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralProvisions")
		@Override
		public SecurityLending.SecurityLendingBuilder setCollateralProvisions(SecLendCollateralProvisions _collateralProvisions) {
			this.collateralProvisions = _collateralProvisions == null ? null : _collateralProvisions.toBuilder();
			return this;
		}
		
		@Override
		public SecurityLending build() {
			return new SecurityLending.SecurityLendingImpl(this);
		}
		
		@Override
		public SecurityLending.SecurityLendingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityLending.SecurityLendingBuilder prune() {
			super.prune();
			if (lenderPartyReference!=null && !lenderPartyReference.prune().hasData()) lenderPartyReference = null;
			if (lenderAccountReference!=null && !lenderAccountReference.prune().hasData()) lenderAccountReference = null;
			if (borrowerPartyReference!=null && !borrowerPartyReference.prune().hasData()) borrowerPartyReference = null;
			if (borrowerAccountReference!=null && !borrowerAccountReference.prune().hasData()) borrowerAccountReference = null;
			if (principal!=null && !principal.prune().hasData()) principal = null;
			if (initiation!=null && !initiation.prune().hasData()) initiation = null;
			if (termination!=null && !termination.prune().hasData()) termination = null;
			if (extensionPeriod!=null && !extensionPeriod.prune().hasData()) extensionPeriod = null;
			if (callDate!=null && !callDate.prune().hasData()) callDate = null;
			if (noticePeriod!=null && !noticePeriod.prune().hasData()) noticePeriod = null;
			partyNoticePeriod = partyNoticePeriod.stream().filter(b->b!=null).<PartyNoticePeriod.PartyNoticePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (fee!=null && !fee.prune().hasData()) fee = null;
			if (rebate!=null && !rebate.prune().hasData()) rebate = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (minimumBillingAmount!=null && !minimumBillingAmount.prune().hasData()) minimumBillingAmount = null;
			if (rebatePaymentFrequency!=null && !rebatePaymentFrequency.prune().hasData()) rebatePaymentFrequency = null;
			if (collateralProvisions!=null && !collateralProvisions.prune().hasData()) collateralProvisions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLenderPartyReference()!=null && getLenderPartyReference().hasData()) return true;
			if (getLenderAccountReference()!=null && getLenderAccountReference().hasData()) return true;
			if (getBorrowerPartyReference()!=null && getBorrowerPartyReference().hasData()) return true;
			if (getBorrowerAccountReference()!=null && getBorrowerAccountReference().hasData()) return true;
			if (getPrincipal()!=null && getPrincipal().hasData()) return true;
			if (getInitiation()!=null && getInitiation().hasData()) return true;
			if (getTermination()!=null && getTermination().hasData()) return true;
			if (getDuration()!=null) return true;
			if (getExtensionStyle()!=null) return true;
			if (getExtensionPeriod()!=null && getExtensionPeriod().hasData()) return true;
			if (getCallingParty()!=null) return true;
			if (getCallDate()!=null && getCallDate().hasData()) return true;
			if (getNoticePeriod()!=null && getNoticePeriod().hasData()) return true;
			if (getPartyNoticePeriod()!=null && getPartyNoticePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFee()!=null && getFee().hasData()) return true;
			if (getRebate()!=null && getRebate().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getDividendRate()!=null) return true;
			if (getMinimumBillingAmount()!=null && getMinimumBillingAmount().hasData()) return true;
			if (getRebatePaymentFrequency()!=null && getRebatePaymentFrequency().hasData()) return true;
			if (getCollateralProvisions()!=null && getCollateralProvisions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityLending.SecurityLendingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SecurityLending.SecurityLendingBuilder o = (SecurityLending.SecurityLendingBuilder) other;
			
			merger.mergeRosetta(getLenderPartyReference(), o.getLenderPartyReference(), this::setLenderPartyReference);
			merger.mergeRosetta(getLenderAccountReference(), o.getLenderAccountReference(), this::setLenderAccountReference);
			merger.mergeRosetta(getBorrowerPartyReference(), o.getBorrowerPartyReference(), this::setBorrowerPartyReference);
			merger.mergeRosetta(getBorrowerAccountReference(), o.getBorrowerAccountReference(), this::setBorrowerAccountReference);
			merger.mergeRosetta(getPrincipal(), o.getPrincipal(), this::setPrincipal);
			merger.mergeRosetta(getInitiation(), o.getInitiation(), this::setInitiation);
			merger.mergeRosetta(getTermination(), o.getTermination(), this::setTermination);
			merger.mergeRosetta(getExtensionPeriod(), o.getExtensionPeriod(), this::setExtensionPeriod);
			merger.mergeRosetta(getCallDate(), o.getCallDate(), this::setCallDate);
			merger.mergeRosetta(getNoticePeriod(), o.getNoticePeriod(), this::setNoticePeriod);
			merger.mergeRosetta(getPartyNoticePeriod(), o.getPartyNoticePeriod(), this::getOrCreatePartyNoticePeriod);
			merger.mergeRosetta(getFee(), o.getFee(), this::setFee);
			merger.mergeRosetta(getRebate(), o.getRebate(), this::setRebate);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getMinimumBillingAmount(), o.getMinimumBillingAmount(), this::setMinimumBillingAmount);
			merger.mergeRosetta(getRebatePaymentFrequency(), o.getRebatePaymentFrequency(), this::setRebatePaymentFrequency);
			merger.mergeRosetta(getCollateralProvisions(), o.getCollateralProvisions(), this::setCollateralProvisions);
			
			merger.mergeBasic(getDuration(), o.getDuration(), this::setDuration);
			merger.mergeBasic(getExtensionStyle(), o.getExtensionStyle(), this::setExtensionStyle);
			merger.mergeBasic(getCallingParty(), o.getCallingParty(), this::setCallingParty);
			merger.mergeBasic(getDividendRate(), o.getDividendRate(), this::setDividendRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecurityLending _that = getType().cast(o);
		
			if (!Objects.equals(lenderPartyReference, _that.getLenderPartyReference())) return false;
			if (!Objects.equals(lenderAccountReference, _that.getLenderAccountReference())) return false;
			if (!Objects.equals(borrowerPartyReference, _that.getBorrowerPartyReference())) return false;
			if (!Objects.equals(borrowerAccountReference, _that.getBorrowerAccountReference())) return false;
			if (!Objects.equals(principal, _that.getPrincipal())) return false;
			if (!Objects.equals(initiation, _that.getInitiation())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(duration, _that.getDuration())) return false;
			if (!Objects.equals(extensionStyle, _that.getExtensionStyle())) return false;
			if (!Objects.equals(extensionPeriod, _that.getExtensionPeriod())) return false;
			if (!Objects.equals(callingParty, _that.getCallingParty())) return false;
			if (!Objects.equals(callDate, _that.getCallDate())) return false;
			if (!Objects.equals(noticePeriod, _that.getNoticePeriod())) return false;
			if (!ListEquals.listEquals(partyNoticePeriod, _that.getPartyNoticePeriod())) return false;
			if (!Objects.equals(fee, _that.getFee())) return false;
			if (!Objects.equals(rebate, _that.getRebate())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(dividendRate, _that.getDividendRate())) return false;
			if (!Objects.equals(minimumBillingAmount, _that.getMinimumBillingAmount())) return false;
			if (!Objects.equals(rebatePaymentFrequency, _that.getRebatePaymentFrequency())) return false;
			if (!Objects.equals(collateralProvisions, _that.getCollateralProvisions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lenderPartyReference != null ? lenderPartyReference.hashCode() : 0);
			_result = 31 * _result + (lenderAccountReference != null ? lenderAccountReference.hashCode() : 0);
			_result = 31 * _result + (borrowerPartyReference != null ? borrowerPartyReference.hashCode() : 0);
			_result = 31 * _result + (borrowerAccountReference != null ? borrowerAccountReference.hashCode() : 0);
			_result = 31 * _result + (principal != null ? principal.hashCode() : 0);
			_result = 31 * _result + (initiation != null ? initiation.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionStyle != null ? extensionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (extensionPeriod != null ? extensionPeriod.hashCode() : 0);
			_result = 31 * _result + (callingParty != null ? callingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callDate != null ? callDate.hashCode() : 0);
			_result = 31 * _result + (noticePeriod != null ? noticePeriod.hashCode() : 0);
			_result = 31 * _result + (partyNoticePeriod != null ? partyNoticePeriod.hashCode() : 0);
			_result = 31 * _result + (fee != null ? fee.hashCode() : 0);
			_result = 31 * _result + (rebate != null ? rebate.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (dividendRate != null ? dividendRate.hashCode() : 0);
			_result = 31 * _result + (minimumBillingAmount != null ? minimumBillingAmount.hashCode() : 0);
			_result = 31 * _result + (rebatePaymentFrequency != null ? rebatePaymentFrequency.hashCode() : 0);
			_result = 31 * _result + (collateralProvisions != null ? collateralProvisions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityLendingBuilder {" +
				"lenderPartyReference=" + this.lenderPartyReference + ", " +
				"lenderAccountReference=" + this.lenderAccountReference + ", " +
				"borrowerPartyReference=" + this.borrowerPartyReference + ", " +
				"borrowerAccountReference=" + this.borrowerAccountReference + ", " +
				"principal=" + this.principal + ", " +
				"initiation=" + this.initiation + ", " +
				"termination=" + this.termination + ", " +
				"duration=" + this.duration + ", " +
				"extensionStyle=" + this.extensionStyle + ", " +
				"extensionPeriod=" + this.extensionPeriod + ", " +
				"callingParty=" + this.callingParty + ", " +
				"callDate=" + this.callDate + ", " +
				"noticePeriod=" + this.noticePeriod + ", " +
				"partyNoticePeriod=" + this.partyNoticePeriod + ", " +
				"fee=" + this.fee + ", " +
				"rebate=" + this.rebate + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"dividendRate=" + this.dividendRate + ", " +
				"minimumBillingAmount=" + this.minimumBillingAmount + ", " +
				"rebatePaymentFrequency=" + this.rebatePaymentFrequency + ", " +
				"collateralProvisions=" + this.collateralProvisions +
			'}' + " " + super.toString();
		}
	}
}
