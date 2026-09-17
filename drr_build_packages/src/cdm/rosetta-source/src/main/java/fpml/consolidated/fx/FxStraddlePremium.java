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
import fpml.consolidated.fx.meta.FxStraddlePremiumMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentBaseExtended;
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
 * Provision The Currency and Amount to be paid by the Buyer to the Seller. The straddle premium is calculated on the Fixing Date using the Forward Volatility Agreement parameters.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The Currency and Amount to be paid by the Buyer to the Seller. The straddle premium is calculated on the Fixing Date using the Forward Volatility Agreement parameters.
 *
 */
@RosettaDataType(value="FxStraddlePremium", builder=FxStraddlePremium.FxStraddlePremiumBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxStraddlePremium", model="fpml", builder=FxStraddlePremium.FxStraddlePremiumBuilderImpl.class, version="2.1.1")
public interface FxStraddlePremium extends PaymentBaseExtended {

	FxStraddlePremiumMeta metaData = new FxStraddlePremiumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Premium Payment Currency.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Premium Payment Currency.
	 *
	 */
	IdentifiedCurrency getPaymentCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Seller details for settling the FxStraddlePremium.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Seller details for settling the FxStraddlePremium.
	 *
	 */
	SettlementInformation getSettlementInformation();

	/*********************** Build Methods  ***********************/
	FxStraddlePremium build();
	
	FxStraddlePremium.FxStraddlePremiumBuilder toBuilder();
	
	static FxStraddlePremium.FxStraddlePremiumBuilder builder() {
		return new FxStraddlePremium.FxStraddlePremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxStraddlePremium> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxStraddlePremium> getType() {
		return FxStraddlePremium.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
		processRosetta(path.newSubPath("paymentCurrency"), processor, IdentifiedCurrency.class, getPaymentCurrency());
		processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.class, getSettlementInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxStraddlePremiumBuilder extends FxStraddlePremium, PaymentBaseExtended.PaymentBaseExtendedBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreatePaymentCurrency();
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder getPaymentCurrency();
		SettlementInformation.SettlementInformationBuilder getOrCreateSettlementInformation();
		@Override
		SettlementInformation.SettlementInformationBuilder getSettlementInformation();
		@Override
		FxStraddlePremium.FxStraddlePremiumBuilder setId(String id);
		@Override
		FxStraddlePremium.FxStraddlePremiumBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FxStraddlePremium.FxStraddlePremiumBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FxStraddlePremium.FxStraddlePremiumBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FxStraddlePremium.FxStraddlePremiumBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		FxStraddlePremium.FxStraddlePremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		FxStraddlePremium.FxStraddlePremiumBuilder setPaymentCurrency(IdentifiedCurrency paymentCurrency);
		FxStraddlePremium.FxStraddlePremiumBuilder setSettlementInformation(SettlementInformation settlementInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getPaymentCurrency());
			processRosetta(path.newSubPath("settlementInformation"), processor, SettlementInformation.SettlementInformationBuilder.class, getSettlementInformation());
		}
		

		FxStraddlePremium.FxStraddlePremiumBuilder prune();
	}

	/*********************** Immutable Implementation of FxStraddlePremium  ***********************/
	class FxStraddlePremiumImpl extends PaymentBaseExtended.PaymentBaseExtendedImpl implements FxStraddlePremium {
		private final IdentifiedCurrency paymentCurrency;
		private final SettlementInformation settlementInformation;
		
		protected FxStraddlePremiumImpl(FxStraddlePremium.FxStraddlePremiumBuilder builder) {
			super(builder);
			this.paymentCurrency = ofNullable(builder.getPaymentCurrency()).map(f->f.build()).orElse(null);
			this.settlementInformation = ofNullable(builder.getSettlementInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentCurrency")
		public IdentifiedCurrency getPaymentCurrency() {
			return paymentCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementInformation")
		public SettlementInformation getSettlementInformation() {
			return settlementInformation;
		}
		
		@Override
		public FxStraddlePremium build() {
			return this;
		}
		
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder toBuilder() {
			FxStraddlePremium.FxStraddlePremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxStraddlePremium.FxStraddlePremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentCurrency()).ifPresent(builder::setPaymentCurrency);
			ofNullable(getSettlementInformation()).ifPresent(builder::setSettlementInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxStraddlePremium _that = getType().cast(o);
		
			if (!Objects.equals(paymentCurrency, _that.getPaymentCurrency())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentCurrency != null ? paymentCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddlePremium {" +
				"paymentCurrency=" + this.paymentCurrency + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxStraddlePremium  ***********************/
	class FxStraddlePremiumBuilderImpl extends PaymentBaseExtended.PaymentBaseExtendedBuilderImpl implements FxStraddlePremium.FxStraddlePremiumBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder paymentCurrency;
		protected SettlementInformation.SettlementInformationBuilder settlementInformation;
		
		@Override
		@RosettaAttribute("paymentCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("paymentCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getPaymentCurrency() {
			return paymentCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreatePaymentCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (paymentCurrency!=null) {
				result = paymentCurrency;
			}
			else {
				result = paymentCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentCurrency")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setPaymentCurrency(IdentifiedCurrency _paymentCurrency) {
			this.paymentCurrency = _paymentCurrency == null ? null : _paymentCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementInformation")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder setSettlementInformation(SettlementInformation _settlementInformation) {
			this.settlementInformation = _settlementInformation == null ? null : _settlementInformation.toBuilder();
			return this;
		}
		
		@Override
		public FxStraddlePremium build() {
			return new FxStraddlePremium.FxStraddlePremiumImpl(this);
		}
		
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder prune() {
			super.prune();
			if (paymentCurrency!=null && !paymentCurrency.prune().hasData()) paymentCurrency = null;
			if (settlementInformation!=null && !settlementInformation.prune().hasData()) settlementInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentCurrency()!=null && getPaymentCurrency().hasData()) return true;
			if (getSettlementInformation()!=null && getSettlementInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxStraddlePremium.FxStraddlePremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxStraddlePremium.FxStraddlePremiumBuilder o = (FxStraddlePremium.FxStraddlePremiumBuilder) other;
			
			merger.mergeRosetta(getPaymentCurrency(), o.getPaymentCurrency(), this::setPaymentCurrency);
			merger.mergeRosetta(getSettlementInformation(), o.getSettlementInformation(), this::setSettlementInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxStraddlePremium _that = getType().cast(o);
		
			if (!Objects.equals(paymentCurrency, _that.getPaymentCurrency())) return false;
			if (!Objects.equals(settlementInformation, _that.getSettlementInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentCurrency != null ? paymentCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementInformation != null ? settlementInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxStraddlePremiumBuilder {" +
				"paymentCurrency=" + this.paymentCurrency + ", " +
				"settlementInformation=" + this.settlementInformation +
			'}' + " " + super.toString();
		}
	}
}
