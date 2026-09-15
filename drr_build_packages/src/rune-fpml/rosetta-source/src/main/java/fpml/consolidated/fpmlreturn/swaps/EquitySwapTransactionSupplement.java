package fpml.consolidated.fpmlreturn.swaps;

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
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import fpml.consolidated.eq.shared.PrincipalExchangeFeatures;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import fpml.consolidated.eq.shared.ReturnSwapBase;
import fpml.consolidated.fpmlenum.EarlyTerminationDateEnum;
import fpml.consolidated.fpmlenum.FeeElectionEnum;
import fpml.consolidated.fpmlreturn.swaps.meta.EquitySwapTransactionSupplementMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A type for defining Equity Swap Transaction Supplement
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining Equity Swap Transaction Supplement
 *
 */
@RosettaDataType(value="EquitySwapTransactionSupplement", builder=EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquitySwapTransactionSupplement", model="fpml", builder=EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilderImpl.class, version="2.1.1")
public interface EquitySwapTransactionSupplement extends ReturnSwapBase {

	EquitySwapTransactionSupplementMeta metaData = new EquitySwapTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used for specifying whether the Mutual Early Termination Right that is detailed in the Master Confirmation will apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used for specifying whether the Mutual Early Termination Right that is detailed in the Master Confirmation will apply.
	 *
	 */
	Boolean getMutualEarlyTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A Boolean element used for specifying whether the Optional Early Termination clause detailed in the agreement will apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A Boolean element used for specifying whether the Optional Early Termination clause detailed in the agreement will apply.
	 *
	 */
	Boolean getOptionalEarlyTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional Early Termination Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional Early Termination Date
	 *
	 */
	EarlyTerminationDateEnum getOptionalEarlyTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional Early Termination Electing Party Reference
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional Early Termination Electing Party Reference
	 *
	 */
	PartyReference getOptionalEarlyTerminationElectingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A Boolean element used for specifying whether the Break Funding Recovery detailed in the agreement will apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A Boolean element used for specifying whether the Break Funding Recovery detailed in the agreement will apply.
	 *
	 */
	Boolean getBreakFundingRecovery();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the fee type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the fee type.
	 *
	 */
	FeeElectionEnum getBreakFeeElection();
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
	BigDecimal getBreakFeeRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 *
	 */
	Boolean getMultipleExchangeIndexAnnexFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 *
	 */
	Boolean getComponentSecurityIndexAnnexFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Local Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties, and similar charges imposed by the taxing authority of the Local Jurisdiction If this element is not present Local Jurisdiction is Not Applicable.
	 *
	 */
	CountryCode getLocalJurisdiction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Relevent Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties and similar charges that would be imposed by the taxing authority of the Country of Underlyer on a Hypothetical Broker Dealer assuming the Applicable Hedge Positions are held by its office in the Relevant Jurisdiction. If this element is not present Relevant Jurisdiction is Not Applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Relevent Jurisdiction is a term used in the AEJ Master Confirmation, which is used to determine local taxes, which shall mean taxes, duties and similar charges that would be imposed by the taxing authority of the Country of Underlyer on a Hypothetical Broker Dealer assuming the Applicable Hedge Positions are held by its office in the Relevant Jurisdiction. If this element is not present Relevant Jurisdiction is Not Applicable.
	 *
	 */
	CountryCode getRelevantJurisdiction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 *
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	EquitySwapTransactionSupplement build();
	
	EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder toBuilder();
	
	static EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder() {
		return new EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquitySwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquitySwapTransactionSupplement> getType() {
		return EquitySwapTransactionSupplement.class;
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
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.class, getReturnSwapLeg());
		processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.class, getPrincipalExchangeFeatures());
		processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.class, getAdditionalPayment());
		processor.processBasic(path.newSubPath("mutualEarlyTermination"), Boolean.class, getMutualEarlyTermination(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTermination"), Boolean.class, getOptionalEarlyTermination(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTerminationDate"), EarlyTerminationDateEnum.class, getOptionalEarlyTerminationDate(), this);
		processRosetta(path.newSubPath("optionalEarlyTerminationElectingPartyReference"), processor, PartyReference.class, getOptionalEarlyTerminationElectingPartyReference());
		processor.processBasic(path.newSubPath("breakFundingRecovery"), Boolean.class, getBreakFundingRecovery(), this);
		processor.processBasic(path.newSubPath("breakFeeElection"), FeeElectionEnum.class, getBreakFeeElection(), this);
		processor.processBasic(path.newSubPath("breakFeeRate"), BigDecimal.class, getBreakFeeRate(), this);
		processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
		processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.class, getLocalJurisdiction());
		processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.class, getRelevantJurisdiction());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquitySwapTransactionSupplementBuilder extends EquitySwapTransactionSupplement, ReturnSwapBase.ReturnSwapBaseBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateOptionalEarlyTerminationElectingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getOptionalEarlyTerminationElectingPartyReference();
		CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getLocalJurisdiction();
		CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction();
		@Override
		CountryCode.CountryCodeBuilder getRelevantJurisdiction();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		@Override
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setId(String id);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductType(ProductType productType);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductType(ProductType productType, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductType(List<? extends ProductType> productType);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setProductType(List<? extends ProductType> productType);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductId(ProductId productId);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductId(ProductId productId, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductId(List<? extends ProductId> productId);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setProductId(List<? extends ProductId> productId);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAssetClass(AssetClass assetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment, int idx);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment);
		@Override
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setMutualEarlyTermination(Boolean mutualEarlyTermination);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setOptionalEarlyTermination(Boolean optionalEarlyTermination);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setOptionalEarlyTerminationDate(EarlyTerminationDateEnum optionalEarlyTerminationDate);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setOptionalEarlyTerminationElectingPartyReference(PartyReference optionalEarlyTerminationElectingPartyReference);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBreakFundingRecovery(Boolean breakFundingRecovery);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBreakFeeElection(FeeElectionEnum breakFeeElection);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBreakFeeRate(BigDecimal breakFeeRate);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setLocalJurisdiction(CountryCode localJurisdiction);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setRelevantJurisdiction(CountryCode relevantJurisdiction);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.DirectionalLegBuilder.class, getReturnSwapLeg());
			processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder.class, getPrincipalExchangeFeatures());
			processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder.class, getAdditionalPayment());
			processor.processBasic(path.newSubPath("mutualEarlyTermination"), Boolean.class, getMutualEarlyTermination(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTermination"), Boolean.class, getOptionalEarlyTermination(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTerminationDate"), EarlyTerminationDateEnum.class, getOptionalEarlyTerminationDate(), this);
			processRosetta(path.newSubPath("optionalEarlyTerminationElectingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getOptionalEarlyTerminationElectingPartyReference());
			processor.processBasic(path.newSubPath("breakFundingRecovery"), Boolean.class, getBreakFundingRecovery(), this);
			processor.processBasic(path.newSubPath("breakFeeElection"), FeeElectionEnum.class, getBreakFeeElection(), this);
			processor.processBasic(path.newSubPath("breakFeeRate"), BigDecimal.class, getBreakFeeRate(), this);
			processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
			processRosetta(path.newSubPath("localJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getLocalJurisdiction());
			processRosetta(path.newSubPath("relevantJurisdiction"), processor, CountryCode.CountryCodeBuilder.class, getRelevantJurisdiction());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of EquitySwapTransactionSupplement  ***********************/
	class EquitySwapTransactionSupplementImpl extends ReturnSwapBase.ReturnSwapBaseImpl implements EquitySwapTransactionSupplement {
		private final Boolean mutualEarlyTermination;
		private final Boolean optionalEarlyTermination;
		private final EarlyTerminationDateEnum optionalEarlyTerminationDate;
		private final PartyReference optionalEarlyTerminationElectingPartyReference;
		private final Boolean breakFundingRecovery;
		private final FeeElectionEnum breakFeeElection;
		private final BigDecimal breakFeeRate;
		private final Boolean multipleExchangeIndexAnnexFallback;
		private final Boolean componentSecurityIndexAnnexFallback;
		private final CountryCode localJurisdiction;
		private final CountryCode relevantJurisdiction;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected EquitySwapTransactionSupplementImpl(EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder) {
			super(builder);
			this.mutualEarlyTermination = builder.getMutualEarlyTermination();
			this.optionalEarlyTermination = builder.getOptionalEarlyTermination();
			this.optionalEarlyTerminationDate = builder.getOptionalEarlyTerminationDate();
			this.optionalEarlyTerminationElectingPartyReference = ofNullable(builder.getOptionalEarlyTerminationElectingPartyReference()).map(f->f.build()).orElse(null);
			this.breakFundingRecovery = builder.getBreakFundingRecovery();
			this.breakFeeElection = builder.getBreakFeeElection();
			this.breakFeeRate = builder.getBreakFeeRate();
			this.multipleExchangeIndexAnnexFallback = builder.getMultipleExchangeIndexAnnexFallback();
			this.componentSecurityIndexAnnexFallback = builder.getComponentSecurityIndexAnnexFallback();
			this.localJurisdiction = ofNullable(builder.getLocalJurisdiction()).map(f->f.build()).orElse(null);
			this.relevantJurisdiction = ofNullable(builder.getRelevantJurisdiction()).map(f->f.build()).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mutualEarlyTermination")
		public Boolean getMutualEarlyTermination() {
			return mutualEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTermination")
		public Boolean getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTerminationDate")
		public EarlyTerminationDateEnum getOptionalEarlyTerminationDate() {
			return optionalEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationElectingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTerminationElectingPartyReference")
		public PartyReference getOptionalEarlyTerminationElectingPartyReference() {
			return optionalEarlyTerminationElectingPartyReference;
		}
		
		@Override
		@RosettaAttribute("breakFundingRecovery")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakFundingRecovery")
		public Boolean getBreakFundingRecovery() {
			return breakFundingRecovery;
		}
		
		@Override
		@RosettaAttribute("breakFeeElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakFeeElection")
		public FeeElectionEnum getBreakFeeElection() {
			return breakFeeElection;
		}
		
		@Override
		@RosettaAttribute("breakFeeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakFeeRate")
		public BigDecimal getBreakFeeRate() {
			return breakFeeRate;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localJurisdiction")
		public CountryCode getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantJurisdiction")
		public CountryCode getRelevantJurisdiction() {
			return relevantJurisdiction;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public EquitySwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder toBuilder() {
			EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMutualEarlyTermination()).ifPresent(builder::setMutualEarlyTermination);
			ofNullable(getOptionalEarlyTermination()).ifPresent(builder::setOptionalEarlyTermination);
			ofNullable(getOptionalEarlyTerminationDate()).ifPresent(builder::setOptionalEarlyTerminationDate);
			ofNullable(getOptionalEarlyTerminationElectingPartyReference()).ifPresent(builder::setOptionalEarlyTerminationElectingPartyReference);
			ofNullable(getBreakFundingRecovery()).ifPresent(builder::setBreakFundingRecovery);
			ofNullable(getBreakFeeElection()).ifPresent(builder::setBreakFeeElection);
			ofNullable(getBreakFeeRate()).ifPresent(builder::setBreakFeeRate);
			ofNullable(getMultipleExchangeIndexAnnexFallback()).ifPresent(builder::setMultipleExchangeIndexAnnexFallback);
			ofNullable(getComponentSecurityIndexAnnexFallback()).ifPresent(builder::setComponentSecurityIndexAnnexFallback);
			ofNullable(getLocalJurisdiction()).ifPresent(builder::setLocalJurisdiction);
			ofNullable(getRelevantJurisdiction()).ifPresent(builder::setRelevantJurisdiction);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(mutualEarlyTermination, _that.getMutualEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationDate, _that.getOptionalEarlyTerminationDate())) return false;
			if (!Objects.equals(optionalEarlyTerminationElectingPartyReference, _that.getOptionalEarlyTerminationElectingPartyReference())) return false;
			if (!Objects.equals(breakFundingRecovery, _that.getBreakFundingRecovery())) return false;
			if (!Objects.equals(breakFeeElection, _that.getBreakFeeElection())) return false;
			if (!Objects.equals(breakFeeRate, _that.getBreakFeeRate())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (mutualEarlyTermination != null ? mutualEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationDate != null ? optionalEarlyTerminationDate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationElectingPartyReference != null ? optionalEarlyTerminationElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (breakFundingRecovery != null ? breakFundingRecovery.hashCode() : 0);
			_result = 31 * _result + (breakFeeElection != null ? breakFeeElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakFeeRate != null ? breakFeeRate.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquitySwapTransactionSupplement {" +
				"mutualEarlyTermination=" + this.mutualEarlyTermination + ", " +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationDate=" + this.optionalEarlyTerminationDate + ", " +
				"optionalEarlyTerminationElectingPartyReference=" + this.optionalEarlyTerminationElectingPartyReference + ", " +
				"breakFundingRecovery=" + this.breakFundingRecovery + ", " +
				"breakFeeElection=" + this.breakFeeElection + ", " +
				"breakFeeRate=" + this.breakFeeRate + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquitySwapTransactionSupplement  ***********************/
	class EquitySwapTransactionSupplementBuilderImpl extends ReturnSwapBase.ReturnSwapBaseBuilderImpl implements EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder {
	
		protected Boolean mutualEarlyTermination;
		protected Boolean optionalEarlyTermination;
		protected EarlyTerminationDateEnum optionalEarlyTerminationDate;
		protected PartyReference.PartyReferenceBuilder optionalEarlyTerminationElectingPartyReference;
		protected Boolean breakFundingRecovery;
		protected FeeElectionEnum breakFeeElection;
		protected BigDecimal breakFeeRate;
		protected Boolean multipleExchangeIndexAnnexFallback;
		protected Boolean componentSecurityIndexAnnexFallback;
		protected CountryCode.CountryCodeBuilder localJurisdiction;
		protected CountryCode.CountryCodeBuilder relevantJurisdiction;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
		
		@Override
		@RosettaAttribute("mutualEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mutualEarlyTermination")
		public Boolean getMutualEarlyTermination() {
			return mutualEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTermination")
		public Boolean getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTerminationDate")
		public EarlyTerminationDateEnum getOptionalEarlyTerminationDate() {
			return optionalEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationElectingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTerminationElectingPartyReference")
		public PartyReference.PartyReferenceBuilder getOptionalEarlyTerminationElectingPartyReference() {
			return optionalEarlyTerminationElectingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionalEarlyTerminationElectingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (optionalEarlyTerminationElectingPartyReference!=null) {
				result = optionalEarlyTerminationElectingPartyReference;
			}
			else {
				result = optionalEarlyTerminationElectingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("breakFundingRecovery")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakFundingRecovery")
		public Boolean getBreakFundingRecovery() {
			return breakFundingRecovery;
		}
		
		@Override
		@RosettaAttribute("breakFeeElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakFeeElection")
		public FeeElectionEnum getBreakFeeElection() {
			return breakFeeElection;
		}
		
		@Override
		@RosettaAttribute("breakFeeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("breakFeeRate")
		public BigDecimal getBreakFeeRate() {
			return breakFeeRate;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("localJurisdiction")
		public CountryCode.CountryCodeBuilder getLocalJurisdiction() {
			return localJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateLocalJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (localJurisdiction!=null) {
				result = localJurisdiction;
			}
			else {
				result = localJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantJurisdiction")
		public CountryCode.CountryCodeBuilder getRelevantJurisdiction() {
			return relevantJurisdiction;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder getOrCreateRelevantJurisdiction() {
			CountryCode.CountryCodeBuilder result;
			if (relevantJurisdiction!=null) {
				result = relevantJurisdiction;
			}
			else {
				result = relevantJurisdiction = CountryCode.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addProductId(List<? extends ProductId> productIds) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setProductId(List<? extends ProductId> productIds) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg _returnSwapLeg) {
			if (_returnSwapLeg != null) {
				this.returnSwapLeg.add(_returnSwapLeg.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg _returnSwapLeg, int idx) {
			getIndex(this.returnSwapLeg, idx, () -> _returnSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs != null) {
				for (final DirectionalLeg toAdd : returnSwapLegs) {
					this.returnSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("returnSwapLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("returnSwapLeg")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs == null) {
				this.returnSwapLeg = new ArrayList<>();
			} else {
				this.returnSwapLeg = returnSwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("principalExchangeFeatures")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchangeFeatures")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures _principalExchangeFeatures) {
			this.principalExchangeFeatures = _principalExchangeFeatures == null ? null : _principalExchangeFeatures.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments != null) {
				for (final ReturnSwapAdditionalPayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("mutualEarlyTermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mutualEarlyTermination")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setMutualEarlyTermination(Boolean _mutualEarlyTermination) {
			this.mutualEarlyTermination = _mutualEarlyTermination == null ? null : _mutualEarlyTermination;
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionalEarlyTermination")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setOptionalEarlyTermination(Boolean _optionalEarlyTermination) {
			this.optionalEarlyTermination = _optionalEarlyTermination == null ? null : _optionalEarlyTermination;
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionalEarlyTerminationDate")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setOptionalEarlyTerminationDate(EarlyTerminationDateEnum _optionalEarlyTerminationDate) {
			this.optionalEarlyTerminationDate = _optionalEarlyTerminationDate == null ? null : _optionalEarlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationElectingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionalEarlyTerminationElectingPartyReference")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setOptionalEarlyTerminationElectingPartyReference(PartyReference _optionalEarlyTerminationElectingPartyReference) {
			this.optionalEarlyTerminationElectingPartyReference = _optionalEarlyTerminationElectingPartyReference == null ? null : _optionalEarlyTerminationElectingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("breakFundingRecovery")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("breakFundingRecovery")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBreakFundingRecovery(Boolean _breakFundingRecovery) {
			this.breakFundingRecovery = _breakFundingRecovery == null ? null : _breakFundingRecovery;
			return this;
		}
		
		@RosettaAttribute("breakFeeElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("breakFeeElection")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBreakFeeElection(FeeElectionEnum _breakFeeElection) {
			this.breakFeeElection = _breakFeeElection == null ? null : _breakFeeElection;
			return this;
		}
		
		@RosettaAttribute("breakFeeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("breakFeeRate")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBreakFeeRate(BigDecimal _breakFeeRate) {
			this.breakFeeRate = _breakFeeRate == null ? null : _breakFeeRate;
			return this;
		}
		
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExchangeIndexAnnexFallback")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setMultipleExchangeIndexAnnexFallback(Boolean _multipleExchangeIndexAnnexFallback) {
			this.multipleExchangeIndexAnnexFallback = _multipleExchangeIndexAnnexFallback == null ? null : _multipleExchangeIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("componentSecurityIndexAnnexFallback")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setComponentSecurityIndexAnnexFallback(Boolean _componentSecurityIndexAnnexFallback) {
			this.componentSecurityIndexAnnexFallback = _componentSecurityIndexAnnexFallback == null ? null : _componentSecurityIndexAnnexFallback;
			return this;
		}
		
		@RosettaAttribute("localJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("localJurisdiction")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setLocalJurisdiction(CountryCode _localJurisdiction) {
			this.localJurisdiction = _localJurisdiction == null ? null : _localJurisdiction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relevantJurisdiction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantJurisdiction")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setRelevantJurisdiction(CountryCode _relevantJurisdiction) {
			this.relevantJurisdiction = _relevantJurisdiction == null ? null : _relevantJurisdiction.toBuilder();
			return this;
		}
		
		@RosettaAttribute("extraordinaryEvents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extraordinaryEvents")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents _extraordinaryEvents) {
			this.extraordinaryEvents = _extraordinaryEvents == null ? null : _extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement build() {
			return new EquitySwapTransactionSupplement.EquitySwapTransactionSupplementImpl(this);
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder prune() {
			super.prune();
			if (optionalEarlyTerminationElectingPartyReference!=null && !optionalEarlyTerminationElectingPartyReference.prune().hasData()) optionalEarlyTerminationElectingPartyReference = null;
			if (localJurisdiction!=null && !localJurisdiction.prune().hasData()) localJurisdiction = null;
			if (relevantJurisdiction!=null && !relevantJurisdiction.prune().hasData()) relevantJurisdiction = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMutualEarlyTermination()!=null) return true;
			if (getOptionalEarlyTermination()!=null) return true;
			if (getOptionalEarlyTerminationDate()!=null) return true;
			if (getOptionalEarlyTerminationElectingPartyReference()!=null && getOptionalEarlyTerminationElectingPartyReference().hasData()) return true;
			if (getBreakFundingRecovery()!=null) return true;
			if (getBreakFeeElection()!=null) return true;
			if (getBreakFeeRate()!=null) return true;
			if (getMultipleExchangeIndexAnnexFallback()!=null) return true;
			if (getComponentSecurityIndexAnnexFallback()!=null) return true;
			if (getLocalJurisdiction()!=null && getLocalJurisdiction().hasData()) return true;
			if (getRelevantJurisdiction()!=null && getRelevantJurisdiction().hasData()) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder o = (EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getOptionalEarlyTerminationElectingPartyReference(), o.getOptionalEarlyTerminationElectingPartyReference(), this::setOptionalEarlyTerminationElectingPartyReference);
			merger.mergeRosetta(getLocalJurisdiction(), o.getLocalJurisdiction(), this::setLocalJurisdiction);
			merger.mergeRosetta(getRelevantJurisdiction(), o.getRelevantJurisdiction(), this::setRelevantJurisdiction);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			merger.mergeBasic(getMutualEarlyTermination(), o.getMutualEarlyTermination(), this::setMutualEarlyTermination);
			merger.mergeBasic(getOptionalEarlyTermination(), o.getOptionalEarlyTermination(), this::setOptionalEarlyTermination);
			merger.mergeBasic(getOptionalEarlyTerminationDate(), o.getOptionalEarlyTerminationDate(), this::setOptionalEarlyTerminationDate);
			merger.mergeBasic(getBreakFundingRecovery(), o.getBreakFundingRecovery(), this::setBreakFundingRecovery);
			merger.mergeBasic(getBreakFeeElection(), o.getBreakFeeElection(), this::setBreakFeeElection);
			merger.mergeBasic(getBreakFeeRate(), o.getBreakFeeRate(), this::setBreakFeeRate);
			merger.mergeBasic(getMultipleExchangeIndexAnnexFallback(), o.getMultipleExchangeIndexAnnexFallback(), this::setMultipleExchangeIndexAnnexFallback);
			merger.mergeBasic(getComponentSecurityIndexAnnexFallback(), o.getComponentSecurityIndexAnnexFallback(), this::setComponentSecurityIndexAnnexFallback);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(mutualEarlyTermination, _that.getMutualEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationDate, _that.getOptionalEarlyTerminationDate())) return false;
			if (!Objects.equals(optionalEarlyTerminationElectingPartyReference, _that.getOptionalEarlyTerminationElectingPartyReference())) return false;
			if (!Objects.equals(breakFundingRecovery, _that.getBreakFundingRecovery())) return false;
			if (!Objects.equals(breakFeeElection, _that.getBreakFeeElection())) return false;
			if (!Objects.equals(breakFeeRate, _that.getBreakFeeRate())) return false;
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			if (!Objects.equals(localJurisdiction, _that.getLocalJurisdiction())) return false;
			if (!Objects.equals(relevantJurisdiction, _that.getRelevantJurisdiction())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (mutualEarlyTermination != null ? mutualEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationDate != null ? optionalEarlyTerminationDate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationElectingPartyReference != null ? optionalEarlyTerminationElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (breakFundingRecovery != null ? breakFundingRecovery.hashCode() : 0);
			_result = 31 * _result + (breakFeeElection != null ? breakFeeElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakFeeRate != null ? breakFeeRate.hashCode() : 0);
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (localJurisdiction != null ? localJurisdiction.hashCode() : 0);
			_result = 31 * _result + (relevantJurisdiction != null ? relevantJurisdiction.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquitySwapTransactionSupplementBuilder {" +
				"mutualEarlyTermination=" + this.mutualEarlyTermination + ", " +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationDate=" + this.optionalEarlyTerminationDate + ", " +
				"optionalEarlyTerminationElectingPartyReference=" + this.optionalEarlyTerminationElectingPartyReference + ", " +
				"breakFundingRecovery=" + this.breakFundingRecovery + ", " +
				"breakFeeElection=" + this.breakFeeElection + ", " +
				"breakFeeRate=" + this.breakFeeRate + ", " +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback + ", " +
				"localJurisdiction=" + this.localJurisdiction + ", " +
				"relevantJurisdiction=" + this.relevantJurisdiction + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
