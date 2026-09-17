package fpml.consolidated.fx;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.fx.meta.FxOptionPremiumMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInformation;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that specifies the premium exchanged for a single option trade or option strategy.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that specifies the premium exchanged for a single option trade or option strategy.
 *
 */
@RosettaDataType(value="FxOptionPremium", builder=FxOptionPremium.FxOptionPremiumBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxOptionPremium", model="fpml", builder=FxOptionPremium.FxOptionPremiumBuilderImpl.class, version="2.1.1")
public interface FxOptionPremium extends NonNegativePayment {

	FxOptionPremiumMeta metaData = new FxOptionPremiumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information required to settle a currency payment that results from a trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information required to settle a currency payment that results from a trade.
	 *
	 */
	SettlementInformation getSettlementInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This is the option premium as quoted. It is expected to be consistent with the premiumAmount and is for information only.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This is the option premium as quoted. It is expected to be consistent with the premiumAmount and is for information only.
	 *
	 */
	PremiumQuote getQuote();

	/*********************** Build Methods  ***********************/
	FxOptionPremium build();
	
	FxOptionPremium.FxOptionPremiumBuilder toBuilder();
	
	static FxOptionPremium.FxOptionPremiumBuilder builder() {
		return new FxOptionPremium.FxOptionPremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionPremium> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxOptionPremium> getType() {
		return FxOptionPremium.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.class, getPaymentAmount());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
		processRosetta(path.newSubPath("quote"), processor, PremiumQuote.class, getQuote());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionPremiumBuilder extends FxOptionPremium, NonNegativePayment.NonNegativePaymentBuilder {
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		@Override
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		PremiumQuote.PremiumQuoteBuilder getOrCreateQuote();
		@Override
		PremiumQuote.PremiumQuoteBuilder getQuote();
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setId(String id);
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		@Override
		FxOptionPremium.FxOptionPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		FxOptionPremium.FxOptionPremiumBuilder setSettlementInformation(SettlementInformation settlementInformation);
		FxOptionPremium.FxOptionPremiumBuilder setQuote(PremiumQuote quote);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
			processRosetta(path.newSubPath("quote"), processor, PremiumQuote.PremiumQuoteBuilder.class, getQuote());
		}
		

		FxOptionPremium.FxOptionPremiumBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionPremium  ***********************/
	class FxOptionPremiumImpl extends NonNegativePayment.NonNegativePaymentImpl implements FxOptionPremium {
		private final SettlementInformation settlementInformation;
		private final PremiumQuote quote;
		
		protected FxOptionPremiumImpl(FxOptionPremium.FxOptionPremiumBuilder builder) {
			super(builder);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quote")
		public PremiumQuote getQuote() {
			return quote;
		}
		
		@Override
		public FxOptionPremium build() {
			return this;
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder toBuilder() {
			FxOptionPremium.FxOptionPremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionPremium.FxOptionPremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPremium _that = getType().cast(o);
		
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPremium {" +
				"settlementInformation=" + this.settlementInformation + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxOptionPremium  ***********************/
	class FxOptionPremiumBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl implements FxOptionPremium.FxOptionPremiumBuilder {
	
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
		protected PremiumQuote.PremiumQuoteBuilder quote;
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation.SettlementInformationBuilder getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation() {
			SettlementInformation.SettlementInformationBuilder result;
			if (settlementInformation!=null) {
				result = settlementInformation;
			}
			else {
				result = settlementInformation = SettlementInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quote")
		public PremiumQuote.PremiumQuoteBuilder getQuote() {
			return quote;
		}
		
		@Override
		public PremiumQuote.PremiumQuoteBuilder getOrCreateQuote() {
			PremiumQuote.PremiumQuoteBuilder result;
			if (quote!=null) {
				result = quote;
			}
			else {
				result = quote = PremiumQuote.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementInformation")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setSettlementInformation(SettlementInformation _settlementInformation) {
			this.settlementInformation = _settlementInformation == null ? null : _settlementInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quote")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder setQuote(PremiumQuote _quote) {
			this.quote = _quote == null ? null : _quote.toBuilder();
			return this;
		}
		
		@Override
		public FxOptionPremium build() {
			return new FxOptionPremium.FxOptionPremiumImpl(this);
		}
		
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder prune() {
			super.prune();
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			if (quote!=null && !quote.prune().hasData()) quote = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			if (getQuote()!=null && getQuote().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionPremium.FxOptionPremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxOptionPremium.FxOptionPremiumBuilder o = (FxOptionPremium.FxOptionPremiumBuilder) other;
			
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::setQuote);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxOptionPremium _that = getType().cast(o);
		
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			if (!Objects.equals(quote, _that.getQuote())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionPremiumBuilder {" +
				"settlementInformation=" + this.settlementInformation + ", " +
				"quote=" + this.quote +
			'}' + " " + super.toString();
		}
	}
}
