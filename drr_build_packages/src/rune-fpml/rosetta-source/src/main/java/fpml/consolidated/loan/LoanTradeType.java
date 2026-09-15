package fpml.consolidated.loan;

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
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.fpmlenum.BuySellEnum;
import fpml.consolidated.fpmlenum.LoanTradingAccrualSettlementEnum;
import fpml.consolidated.fpmlenum.LoanTradingAssocEnum;
import fpml.consolidated.fpmlenum.LoanTradingDocTypeEnum;
import fpml.consolidated.fpmlenum.LoanTradingFormOfPurchaseEnum;
import fpml.consolidated.fpmlenum.LoanTradingTypeEnum;
import fpml.consolidated.fpmlenum.LoanTradingVotingRightsEnum;
import fpml.consolidated.loan.meta.LoanTradeTypeMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
 * version "confirmation-5.13"
 *
 * Provision A structure that defines party-to-party loan trade information. This structure contains the main (e.g. fund manager/main counterparty) trade details.
 *
 */
@RosettaDataType(value="LoanTradeType", builder=LoanTradeType.LoanTradeTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeType", model="fpml", builder=LoanTradeType.LoanTradeTypeBuilderImpl.class, version="2.1.1")
public interface LoanTradeType extends LoanTradeSummary {

	LoanTradeTypeMeta metaData = new LoanTradeTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade date associated with a specified trade record.
	 *
	 */
	ZonedDateTime getTradeDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Primary or Secondary.
	 *
	 */
	LoanTradingTypeEnum getMarketType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A flag to indicate the dependency of a secondary market loan trade upon the closing of a primary market loan structuring and syndication process.
	 *
	 */
	Boolean getWhenIssuedFlag();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the trading association under which the loan trade documentation is governed.
	 *
	 */
	LoanTradingAssocEnum getTradingAssociation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the trade is being settled by assignment or participation (i.e. sub-participation).
	 *
	 */
	LoanTradingFormOfPurchaseEnum getFormOfPurchase();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party responsible for remitting the transfer fee to the admin agent (buyer or seller).
	 *
	 */
	BuySellEnum getRemittedBy();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The trade price, notated as a decimal, to be expressed as a percentage multiplied by the commitment amount.
	 *
	 */
	BigDecimal getPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Details of the transfer fee owed to the admin agent.
	 *
	 */
	LoanTransferFee getTransferFee();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether the loan trade is being settled under par or distressed documentation.
	 *
	 */
	LoanTradingDocTypeEnum getDocumentationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the way in which interest (and accruing fees) will be handled between the buyer and seller of the loan.
	 *
	 */
	LoanTradingAccrualSettlementEnum getAccrualSettlementType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines whether delayed compensation is due at settlement of the loan trade.
	 *
	 */
	Boolean getDelayedCompensationFlag();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the benefit of all amendment fees, consent, waiver, and other one-off fees occurring between trade date and settlement date.
	 *
	 */
	BuySellEnum getOtherFeesBenefactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies whether the buyer is to supply collateral in the case the trade involves a revolver and the trade settles as a participation.
	 *
	 */
	Boolean getCollateralRequiredFlag();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies whether the buyer is to receive voting rights or be retained by the seller.
	 *
	 */
	LoanTradingVotingRightsEnum getVotingRights();

	/*********************** Build Methods  ***********************/
	LoanTradeType build();
	
	LoanTradeType.LoanTradeTypeBuilder toBuilder();
	
	static LoanTradeType.LoanTradeTypeBuilder builder() {
		return new LoanTradeType.LoanTradeTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeType> getType() {
		return LoanTradeType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("issuer"), processor, IssuerId.class, getIssuer());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.class, getTradeIdentifierChoice());
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processor.processBasic(path.newSubPath("tradeDate"), ZonedDateTime.class, getTradeDate(), this);
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processor.processBasic(path.newSubPath("marketType"), LoanTradingTypeEnum.class, getMarketType(), this);
		processor.processBasic(path.newSubPath("whenIssuedFlag"), Boolean.class, getWhenIssuedFlag(), this);
		processor.processBasic(path.newSubPath("tradingAssociation"), LoanTradingAssocEnum.class, getTradingAssociation(), this);
		processor.processBasic(path.newSubPath("formOfPurchase"), LoanTradingFormOfPurchaseEnum.class, getFormOfPurchase(), this);
		processor.processBasic(path.newSubPath("remittedBy"), BuySellEnum.class, getRemittedBy(), this);
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processRosetta(path.newSubPath("transferFee"), processor, LoanTransferFee.class, getTransferFee());
		processor.processBasic(path.newSubPath("documentationType"), LoanTradingDocTypeEnum.class, getDocumentationType(), this);
		processor.processBasic(path.newSubPath("accrualSettlementType"), LoanTradingAccrualSettlementEnum.class, getAccrualSettlementType(), this);
		processor.processBasic(path.newSubPath("delayedCompensationFlag"), Boolean.class, getDelayedCompensationFlag(), this);
		processor.processBasic(path.newSubPath("otherFeesBenefactor"), BuySellEnum.class, getOtherFeesBenefactor(), this);
		processor.processBasic(path.newSubPath("collateralRequiredFlag"), Boolean.class, getCollateralRequiredFlag(), this);
		processor.processBasic(path.newSubPath("votingRights"), LoanTradingVotingRightsEnum.class, getVotingRights(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTypeBuilder extends LoanTradeType, LoanTradeSummary.LoanTradeSummaryBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		LoanTransferFee.LoanTransferFeeBuilder getOrCreateTransferFee();
		@Override
		LoanTransferFee.LoanTransferFeeBuilder getTransferFee();
		@Override
		LoanTradeType.LoanTradeTypeBuilder setId(String id);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setIssuer(IssuerId issuer);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setTradeId(TradeId tradeId);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setAccountReference(AccountReference accountReference);
		@Override
		LoanTradeType.LoanTradeTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice);
		@Override
		LoanTradeType.LoanTradeTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice tradeIdentifierChoice, int idx);
		@Override
		LoanTradeType.LoanTradeTypeBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoice);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setFacilityReference(FacilityReference facilityReference);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setAmount(NonNegativeMoney amount);
		@Override
		LoanTradeType.LoanTradeTypeBuilder setComment(String comment);
		LoanTradeType.LoanTradeTypeBuilder setTradeDate(ZonedDateTime tradeDate);
		LoanTradeType.LoanTradeTypeBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		LoanTradeType.LoanTradeTypeBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		LoanTradeType.LoanTradeTypeBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		LoanTradeType.LoanTradeTypeBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		LoanTradeType.LoanTradeTypeBuilder setMarketType(LoanTradingTypeEnum marketType);
		LoanTradeType.LoanTradeTypeBuilder setWhenIssuedFlag(Boolean whenIssuedFlag);
		LoanTradeType.LoanTradeTypeBuilder setTradingAssociation(LoanTradingAssocEnum tradingAssociation);
		LoanTradeType.LoanTradeTypeBuilder setFormOfPurchase(LoanTradingFormOfPurchaseEnum formOfPurchase);
		LoanTradeType.LoanTradeTypeBuilder setRemittedBy(BuySellEnum remittedBy);
		LoanTradeType.LoanTradeTypeBuilder setPrice(BigDecimal price);
		LoanTradeType.LoanTradeTypeBuilder setTransferFee(LoanTransferFee transferFee);
		LoanTradeType.LoanTradeTypeBuilder setDocumentationType(LoanTradingDocTypeEnum documentationType);
		LoanTradeType.LoanTradeTypeBuilder setAccrualSettlementType(LoanTradingAccrualSettlementEnum accrualSettlementType);
		LoanTradeType.LoanTradeTypeBuilder setDelayedCompensationFlag(Boolean delayedCompensationFlag);
		LoanTradeType.LoanTradeTypeBuilder setOtherFeesBenefactor(BuySellEnum otherFeesBenefactor);
		LoanTradeType.LoanTradeTypeBuilder setCollateralRequiredFlag(Boolean collateralRequiredFlag);
		LoanTradeType.LoanTradeTypeBuilder setVotingRights(LoanTradingVotingRightsEnum votingRights);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("issuer"), processor, IssuerId.IssuerIdBuilder.class, getIssuer());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("tradeIdentifierChoice"), processor, TradeIdentifierChoice.TradeIdentifierChoiceBuilder.class, getTradeIdentifierChoice());
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processor.processBasic(path.newSubPath("tradeDate"), ZonedDateTime.class, getTradeDate(), this);
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processor.processBasic(path.newSubPath("marketType"), LoanTradingTypeEnum.class, getMarketType(), this);
			processor.processBasic(path.newSubPath("whenIssuedFlag"), Boolean.class, getWhenIssuedFlag(), this);
			processor.processBasic(path.newSubPath("tradingAssociation"), LoanTradingAssocEnum.class, getTradingAssociation(), this);
			processor.processBasic(path.newSubPath("formOfPurchase"), LoanTradingFormOfPurchaseEnum.class, getFormOfPurchase(), this);
			processor.processBasic(path.newSubPath("remittedBy"), BuySellEnum.class, getRemittedBy(), this);
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processRosetta(path.newSubPath("transferFee"), processor, LoanTransferFee.LoanTransferFeeBuilder.class, getTransferFee());
			processor.processBasic(path.newSubPath("documentationType"), LoanTradingDocTypeEnum.class, getDocumentationType(), this);
			processor.processBasic(path.newSubPath("accrualSettlementType"), LoanTradingAccrualSettlementEnum.class, getAccrualSettlementType(), this);
			processor.processBasic(path.newSubPath("delayedCompensationFlag"), Boolean.class, getDelayedCompensationFlag(), this);
			processor.processBasic(path.newSubPath("otherFeesBenefactor"), BuySellEnum.class, getOtherFeesBenefactor(), this);
			processor.processBasic(path.newSubPath("collateralRequiredFlag"), Boolean.class, getCollateralRequiredFlag(), this);
			processor.processBasic(path.newSubPath("votingRights"), LoanTradingVotingRightsEnum.class, getVotingRights(), this);
		}
		

		LoanTradeType.LoanTradeTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeType  ***********************/
	class LoanTradeTypeImpl extends LoanTradeSummary.LoanTradeSummaryImpl implements LoanTradeType {
		private final ZonedDateTime tradeDate;
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final LoanTradingTypeEnum marketType;
		private final Boolean whenIssuedFlag;
		private final LoanTradingAssocEnum tradingAssociation;
		private final LoanTradingFormOfPurchaseEnum formOfPurchase;
		private final BuySellEnum remittedBy;
		private final BigDecimal price;
		private final LoanTransferFee transferFee;
		private final LoanTradingDocTypeEnum documentationType;
		private final LoanTradingAccrualSettlementEnum accrualSettlementType;
		private final Boolean delayedCompensationFlag;
		private final BuySellEnum otherFeesBenefactor;
		private final Boolean collateralRequiredFlag;
		private final LoanTradingVotingRightsEnum votingRights;
		
		protected LoanTradeTypeImpl(LoanTradeType.LoanTradeTypeBuilder builder) {
			super(builder);
			this.tradeDate = builder.getTradeDate();
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.marketType = builder.getMarketType();
			this.whenIssuedFlag = builder.getWhenIssuedFlag();
			this.tradingAssociation = builder.getTradingAssociation();
			this.formOfPurchase = builder.getFormOfPurchase();
			this.remittedBy = builder.getRemittedBy();
			this.price = builder.getPrice();
			this.transferFee = ofNullable(builder.getTransferFee()).map(f->f.build()).orElse(null);
			this.documentationType = builder.getDocumentationType();
			this.accrualSettlementType = builder.getAccrualSettlementType();
			this.delayedCompensationFlag = builder.getDelayedCompensationFlag();
			this.otherFeesBenefactor = builder.getOtherFeesBenefactor();
			this.collateralRequiredFlag = builder.getCollateralRequiredFlag();
			this.votingRights = builder.getVotingRights();
		}
		
		@Override
		@RosettaAttribute("tradeDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeDate")
		public ZonedDateTime getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		@RosettaAttribute("marketType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marketType")
		public LoanTradingTypeEnum getMarketType() {
			return marketType;
		}
		
		@Override
		@RosettaAttribute("whenIssuedFlag")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("whenIssuedFlag")
		public Boolean getWhenIssuedFlag() {
			return whenIssuedFlag;
		}
		
		@Override
		@RosettaAttribute("tradingAssociation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradingAssociation")
		public LoanTradingAssocEnum getTradingAssociation() {
			return tradingAssociation;
		}
		
		@Override
		@RosettaAttribute("formOfPurchase")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("formOfPurchase")
		public LoanTradingFormOfPurchaseEnum getFormOfPurchase() {
			return formOfPurchase;
		}
		
		@Override
		@RosettaAttribute("remittedBy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("remittedBy")
		public BuySellEnum getRemittedBy() {
			return remittedBy;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("transferFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferFee")
		public LoanTransferFee getTransferFee() {
			return transferFee;
		}
		
		@Override
		@RosettaAttribute("documentationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentationType")
		public LoanTradingDocTypeEnum getDocumentationType() {
			return documentationType;
		}
		
		@Override
		@RosettaAttribute("accrualSettlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualSettlementType")
		public LoanTradingAccrualSettlementEnum getAccrualSettlementType() {
			return accrualSettlementType;
		}
		
		@Override
		@RosettaAttribute("delayedCompensationFlag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delayedCompensationFlag")
		public Boolean getDelayedCompensationFlag() {
			return delayedCompensationFlag;
		}
		
		@Override
		@RosettaAttribute("otherFeesBenefactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherFeesBenefactor")
		public BuySellEnum getOtherFeesBenefactor() {
			return otherFeesBenefactor;
		}
		
		@Override
		@RosettaAttribute("collateralRequiredFlag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralRequiredFlag")
		public Boolean getCollateralRequiredFlag() {
			return collateralRequiredFlag;
		}
		
		@Override
		@RosettaAttribute("votingRights")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("votingRights")
		public LoanTradingVotingRightsEnum getVotingRights() {
			return votingRights;
		}
		
		@Override
		public LoanTradeType build() {
			return this;
		}
		
		@Override
		public LoanTradeType.LoanTradeTypeBuilder toBuilder() {
			LoanTradeType.LoanTradeTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeType.LoanTradeTypeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeDate()).ifPresent(builder::setTradeDate);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getMarketType()).ifPresent(builder::setMarketType);
			ofNullable(getWhenIssuedFlag()).ifPresent(builder::setWhenIssuedFlag);
			ofNullable(getTradingAssociation()).ifPresent(builder::setTradingAssociation);
			ofNullable(getFormOfPurchase()).ifPresent(builder::setFormOfPurchase);
			ofNullable(getRemittedBy()).ifPresent(builder::setRemittedBy);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getTransferFee()).ifPresent(builder::setTransferFee);
			ofNullable(getDocumentationType()).ifPresent(builder::setDocumentationType);
			ofNullable(getAccrualSettlementType()).ifPresent(builder::setAccrualSettlementType);
			ofNullable(getDelayedCompensationFlag()).ifPresent(builder::setDelayedCompensationFlag);
			ofNullable(getOtherFeesBenefactor()).ifPresent(builder::setOtherFeesBenefactor);
			ofNullable(getCollateralRequiredFlag()).ifPresent(builder::setCollateralRequiredFlag);
			ofNullable(getVotingRights()).ifPresent(builder::setVotingRights);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeType _that = getType().cast(o);
		
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(marketType, _that.getMarketType())) return false;
			if (!Objects.equals(whenIssuedFlag, _that.getWhenIssuedFlag())) return false;
			if (!Objects.equals(tradingAssociation, _that.getTradingAssociation())) return false;
			if (!Objects.equals(formOfPurchase, _that.getFormOfPurchase())) return false;
			if (!Objects.equals(remittedBy, _that.getRemittedBy())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!Objects.equals(documentationType, _that.getDocumentationType())) return false;
			if (!Objects.equals(accrualSettlementType, _that.getAccrualSettlementType())) return false;
			if (!Objects.equals(delayedCompensationFlag, _that.getDelayedCompensationFlag())) return false;
			if (!Objects.equals(otherFeesBenefactor, _that.getOtherFeesBenefactor())) return false;
			if (!Objects.equals(collateralRequiredFlag, _that.getCollateralRequiredFlag())) return false;
			if (!Objects.equals(votingRights, _that.getVotingRights())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (marketType != null ? marketType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (whenIssuedFlag != null ? whenIssuedFlag.hashCode() : 0);
			_result = 31 * _result + (tradingAssociation != null ? tradingAssociation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (formOfPurchase != null ? formOfPurchase.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (remittedBy != null ? remittedBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (documentationType != null ? documentationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (accrualSettlementType != null ? accrualSettlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delayedCompensationFlag != null ? delayedCompensationFlag.hashCode() : 0);
			_result = 31 * _result + (otherFeesBenefactor != null ? otherFeesBenefactor.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (collateralRequiredFlag != null ? collateralRequiredFlag.hashCode() : 0);
			_result = 31 * _result + (votingRights != null ? votingRights.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeType {" +
				"tradeDate=" + this.tradeDate + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"marketType=" + this.marketType + ", " +
				"whenIssuedFlag=" + this.whenIssuedFlag + ", " +
				"tradingAssociation=" + this.tradingAssociation + ", " +
				"formOfPurchase=" + this.formOfPurchase + ", " +
				"remittedBy=" + this.remittedBy + ", " +
				"price=" + this.price + ", " +
				"transferFee=" + this.transferFee + ", " +
				"documentationType=" + this.documentationType + ", " +
				"accrualSettlementType=" + this.accrualSettlementType + ", " +
				"delayedCompensationFlag=" + this.delayedCompensationFlag + ", " +
				"otherFeesBenefactor=" + this.otherFeesBenefactor + ", " +
				"collateralRequiredFlag=" + this.collateralRequiredFlag + ", " +
				"votingRights=" + this.votingRights +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeType  ***********************/
	class LoanTradeTypeBuilderImpl extends LoanTradeSummary.LoanTradeSummaryBuilderImpl implements LoanTradeType.LoanTradeTypeBuilder {
	
		protected ZonedDateTime tradeDate;
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected LoanTradingTypeEnum marketType;
		protected Boolean whenIssuedFlag;
		protected LoanTradingAssocEnum tradingAssociation;
		protected LoanTradingFormOfPurchaseEnum formOfPurchase;
		protected BuySellEnum remittedBy;
		protected BigDecimal price;
		protected LoanTransferFee.LoanTransferFeeBuilder transferFee;
		protected LoanTradingDocTypeEnum documentationType;
		protected LoanTradingAccrualSettlementEnum accrualSettlementType;
		protected Boolean delayedCompensationFlag;
		protected BuySellEnum otherFeesBenefactor;
		protected Boolean collateralRequiredFlag;
		protected LoanTradingVotingRightsEnum votingRights;
		
		@Override
		@RosettaAttribute("tradeDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeDate")
		public ZonedDateTime getTradeDate() {
			return tradeDate;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marketType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marketType")
		public LoanTradingTypeEnum getMarketType() {
			return marketType;
		}
		
		@Override
		@RosettaAttribute("whenIssuedFlag")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("whenIssuedFlag")
		public Boolean getWhenIssuedFlag() {
			return whenIssuedFlag;
		}
		
		@Override
		@RosettaAttribute("tradingAssociation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradingAssociation")
		public LoanTradingAssocEnum getTradingAssociation() {
			return tradingAssociation;
		}
		
		@Override
		@RosettaAttribute("formOfPurchase")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("formOfPurchase")
		public LoanTradingFormOfPurchaseEnum getFormOfPurchase() {
			return formOfPurchase;
		}
		
		@Override
		@RosettaAttribute("remittedBy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("remittedBy")
		public BuySellEnum getRemittedBy() {
			return remittedBy;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("transferFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferFee")
		public LoanTransferFee.LoanTransferFeeBuilder getTransferFee() {
			return transferFee;
		}
		
		@Override
		public LoanTransferFee.LoanTransferFeeBuilder getOrCreateTransferFee() {
			LoanTransferFee.LoanTransferFeeBuilder result;
			if (transferFee!=null) {
				result = transferFee;
			}
			else {
				result = transferFee = LoanTransferFee.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("documentationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentationType")
		public LoanTradingDocTypeEnum getDocumentationType() {
			return documentationType;
		}
		
		@Override
		@RosettaAttribute("accrualSettlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accrualSettlementType")
		public LoanTradingAccrualSettlementEnum getAccrualSettlementType() {
			return accrualSettlementType;
		}
		
		@Override
		@RosettaAttribute("delayedCompensationFlag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delayedCompensationFlag")
		public Boolean getDelayedCompensationFlag() {
			return delayedCompensationFlag;
		}
		
		@Override
		@RosettaAttribute("otherFeesBenefactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherFeesBenefactor")
		public BuySellEnum getOtherFeesBenefactor() {
			return otherFeesBenefactor;
		}
		
		@Override
		@RosettaAttribute("collateralRequiredFlag")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralRequiredFlag")
		public Boolean getCollateralRequiredFlag() {
			return collateralRequiredFlag;
		}
		
		@Override
		@RosettaAttribute("votingRights")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("votingRights")
		public LoanTradingVotingRightsEnum getVotingRights() {
			return votingRights;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("issuer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuer")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setIssuer(IssuerId _issuer) {
			this.issuer = _issuer == null ? null : _issuer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeId")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setTradeId(TradeId _tradeId) {
			this.tradeId = _tradeId == null ? null : _tradeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice) {
			if (_tradeIdentifierChoice != null) {
				this.tradeIdentifierChoice.add(_tradeIdentifierChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeType.LoanTradeTypeBuilder addTradeIdentifierChoice(TradeIdentifierChoice _tradeIdentifierChoice, int idx) {
			getIndex(this.tradeIdentifierChoice, idx, () -> _tradeIdentifierChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeType.LoanTradeTypeBuilder addTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices != null) {
				for (final TradeIdentifierChoice toAdd : tradeIdentifierChoices) {
					this.tradeIdentifierChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifierChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifierChoice")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setTradeIdentifierChoice(List<? extends TradeIdentifierChoice> tradeIdentifierChoices) {
			if (tradeIdentifierChoices == null) {
				this.tradeIdentifierChoice = new ArrayList<>();
			} else {
				this.tradeIdentifierChoice = tradeIdentifierChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setAmount(NonNegativeMoney _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("tradeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeDate")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setTradeDate(ZonedDateTime _tradeDate) {
			this.tradeDate = _tradeDate == null ? null : _tradeDate;
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("marketType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("marketType")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setMarketType(LoanTradingTypeEnum _marketType) {
			this.marketType = _marketType == null ? null : _marketType;
			return this;
		}
		
		@RosettaAttribute("whenIssuedFlag")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("whenIssuedFlag")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setWhenIssuedFlag(Boolean _whenIssuedFlag) {
			this.whenIssuedFlag = _whenIssuedFlag == null ? null : _whenIssuedFlag;
			return this;
		}
		
		@RosettaAttribute("tradingAssociation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradingAssociation")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setTradingAssociation(LoanTradingAssocEnum _tradingAssociation) {
			this.tradingAssociation = _tradingAssociation == null ? null : _tradingAssociation;
			return this;
		}
		
		@RosettaAttribute("formOfPurchase")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("formOfPurchase")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setFormOfPurchase(LoanTradingFormOfPurchaseEnum _formOfPurchase) {
			this.formOfPurchase = _formOfPurchase == null ? null : _formOfPurchase;
			return this;
		}
		
		@RosettaAttribute("remittedBy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("remittedBy")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setRemittedBy(BuySellEnum _remittedBy) {
			this.remittedBy = _remittedBy == null ? null : _remittedBy;
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setPrice(BigDecimal _price) {
			this.price = _price == null ? null : _price;
			return this;
		}
		
		@RosettaAttribute("transferFee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferFee")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setTransferFee(LoanTransferFee _transferFee) {
			this.transferFee = _transferFee == null ? null : _transferFee.toBuilder();
			return this;
		}
		
		@RosettaAttribute("documentationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("documentationType")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setDocumentationType(LoanTradingDocTypeEnum _documentationType) {
			this.documentationType = _documentationType == null ? null : _documentationType;
			return this;
		}
		
		@RosettaAttribute("accrualSettlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accrualSettlementType")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setAccrualSettlementType(LoanTradingAccrualSettlementEnum _accrualSettlementType) {
			this.accrualSettlementType = _accrualSettlementType == null ? null : _accrualSettlementType;
			return this;
		}
		
		@RosettaAttribute("delayedCompensationFlag")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delayedCompensationFlag")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setDelayedCompensationFlag(Boolean _delayedCompensationFlag) {
			this.delayedCompensationFlag = _delayedCompensationFlag == null ? null : _delayedCompensationFlag;
			return this;
		}
		
		@RosettaAttribute("otherFeesBenefactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherFeesBenefactor")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setOtherFeesBenefactor(BuySellEnum _otherFeesBenefactor) {
			this.otherFeesBenefactor = _otherFeesBenefactor == null ? null : _otherFeesBenefactor;
			return this;
		}
		
		@RosettaAttribute("collateralRequiredFlag")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralRequiredFlag")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setCollateralRequiredFlag(Boolean _collateralRequiredFlag) {
			this.collateralRequiredFlag = _collateralRequiredFlag == null ? null : _collateralRequiredFlag;
			return this;
		}
		
		@RosettaAttribute("votingRights")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("votingRights")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder setVotingRights(LoanTradingVotingRightsEnum _votingRights) {
			this.votingRights = _votingRights == null ? null : _votingRights;
			return this;
		}
		
		@Override
		public LoanTradeType build() {
			return new LoanTradeType.LoanTradeTypeImpl(this);
		}
		
		@Override
		public LoanTradeType.LoanTradeTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (transferFee!=null && !transferFee.prune().hasData()) transferFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeDate()!=null) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getMarketType()!=null) return true;
			if (getWhenIssuedFlag()!=null) return true;
			if (getTradingAssociation()!=null) return true;
			if (getFormOfPurchase()!=null) return true;
			if (getRemittedBy()!=null) return true;
			if (getPrice()!=null) return true;
			if (getTransferFee()!=null && getTransferFee().hasData()) return true;
			if (getDocumentationType()!=null) return true;
			if (getAccrualSettlementType()!=null) return true;
			if (getDelayedCompensationFlag()!=null) return true;
			if (getOtherFeesBenefactor()!=null) return true;
			if (getCollateralRequiredFlag()!=null) return true;
			if (getVotingRights()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeType.LoanTradeTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeType.LoanTradeTypeBuilder o = (LoanTradeType.LoanTradeTypeBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getTransferFee(), o.getTransferFee(), this::setTransferFee);
			
			merger.mergeBasic(getTradeDate(), o.getTradeDate(), this::setTradeDate);
			merger.mergeBasic(getMarketType(), o.getMarketType(), this::setMarketType);
			merger.mergeBasic(getWhenIssuedFlag(), o.getWhenIssuedFlag(), this::setWhenIssuedFlag);
			merger.mergeBasic(getTradingAssociation(), o.getTradingAssociation(), this::setTradingAssociation);
			merger.mergeBasic(getFormOfPurchase(), o.getFormOfPurchase(), this::setFormOfPurchase);
			merger.mergeBasic(getRemittedBy(), o.getRemittedBy(), this::setRemittedBy);
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeBasic(getDocumentationType(), o.getDocumentationType(), this::setDocumentationType);
			merger.mergeBasic(getAccrualSettlementType(), o.getAccrualSettlementType(), this::setAccrualSettlementType);
			merger.mergeBasic(getDelayedCompensationFlag(), o.getDelayedCompensationFlag(), this::setDelayedCompensationFlag);
			merger.mergeBasic(getOtherFeesBenefactor(), o.getOtherFeesBenefactor(), this::setOtherFeesBenefactor);
			merger.mergeBasic(getCollateralRequiredFlag(), o.getCollateralRequiredFlag(), this::setCollateralRequiredFlag);
			merger.mergeBasic(getVotingRights(), o.getVotingRights(), this::setVotingRights);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeType _that = getType().cast(o);
		
			if (!Objects.equals(tradeDate, _that.getTradeDate())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(marketType, _that.getMarketType())) return false;
			if (!Objects.equals(whenIssuedFlag, _that.getWhenIssuedFlag())) return false;
			if (!Objects.equals(tradingAssociation, _that.getTradingAssociation())) return false;
			if (!Objects.equals(formOfPurchase, _that.getFormOfPurchase())) return false;
			if (!Objects.equals(remittedBy, _that.getRemittedBy())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!Objects.equals(documentationType, _that.getDocumentationType())) return false;
			if (!Objects.equals(accrualSettlementType, _that.getAccrualSettlementType())) return false;
			if (!Objects.equals(delayedCompensationFlag, _that.getDelayedCompensationFlag())) return false;
			if (!Objects.equals(otherFeesBenefactor, _that.getOtherFeesBenefactor())) return false;
			if (!Objects.equals(collateralRequiredFlag, _that.getCollateralRequiredFlag())) return false;
			if (!Objects.equals(votingRights, _that.getVotingRights())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeDate != null ? tradeDate.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (marketType != null ? marketType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (whenIssuedFlag != null ? whenIssuedFlag.hashCode() : 0);
			_result = 31 * _result + (tradingAssociation != null ? tradingAssociation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (formOfPurchase != null ? formOfPurchase.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (remittedBy != null ? remittedBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (documentationType != null ? documentationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (accrualSettlementType != null ? accrualSettlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delayedCompensationFlag != null ? delayedCompensationFlag.hashCode() : 0);
			_result = 31 * _result + (otherFeesBenefactor != null ? otherFeesBenefactor.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (collateralRequiredFlag != null ? collateralRequiredFlag.hashCode() : 0);
			_result = 31 * _result + (votingRights != null ? votingRights.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTypeBuilder {" +
				"tradeDate=" + this.tradeDate + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"marketType=" + this.marketType + ", " +
				"whenIssuedFlag=" + this.whenIssuedFlag + ", " +
				"tradingAssociation=" + this.tradingAssociation + ", " +
				"formOfPurchase=" + this.formOfPurchase + ", " +
				"remittedBy=" + this.remittedBy + ", " +
				"price=" + this.price + ", " +
				"transferFee=" + this.transferFee + ", " +
				"documentationType=" + this.documentationType + ", " +
				"accrualSettlementType=" + this.accrualSettlementType + ", " +
				"delayedCompensationFlag=" + this.delayedCompensationFlag + ", " +
				"otherFeesBenefactor=" + this.otherFeesBenefactor + ", " +
				"collateralRequiredFlag=" + this.collateralRequiredFlag + ", " +
				"votingRights=" + this.votingRights +
			'}' + " " + super.toString();
		}
	}
}
