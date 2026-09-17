package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityPremiumMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The commodity option premium payable by the buyer to the seller.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The commodity option premium payable by the buyer to the seller.
 *
 */
@RosettaDataType(value="CommodityPremium", builder=CommodityPremium.CommodityPremiumBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPremium", model="fpml", builder=CommodityPremium.CommodityPremiumBuilderImpl.class, version="2.1.1")
public interface CommodityPremium extends NonNegativePayment {

	CommodityPremiumMeta metaData = new CommodityPremiumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency amount of premium to be paid per Unit of the Total Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount of premium to be paid per Unit of the Total Notional Quantity.
	 *
	 */
	NonNegativeMoney getPremiumPerUnit();

	/*********************** Build Methods  ***********************/
	CommodityPremium build();
	
	CommodityPremium.CommodityPremiumBuilder toBuilder();
	
	static CommodityPremium.CommodityPremiumBuilder builder() {
		return new CommodityPremium.CommodityPremiumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPremium> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPremium> getType() {
		return CommodityPremium.class;
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
		processRosetta(path.newSubPath("premiumPerUnit"), processor, NonNegativeMoney.class, getPremiumPerUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPremiumBuilder extends CommodityPremium, NonNegativePayment.NonNegativePaymentBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePremiumPerUnit();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getPremiumPerUnit();
		@Override
		CommodityPremium.CommodityPremiumBuilder setId(String id);
		@Override
		CommodityPremium.CommodityPremiumBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		CommodityPremium.CommodityPremiumBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		CommodityPremium.CommodityPremiumBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		CommodityPremium.CommodityPremiumBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		CommodityPremium.CommodityPremiumBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		@Override
		CommodityPremium.CommodityPremiumBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		CommodityPremium.CommodityPremiumBuilder setPremiumPerUnit(NonNegativeMoney premiumPerUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("premiumPerUnit"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPremiumPerUnit());
		}
		

		CommodityPremium.CommodityPremiumBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPremium  ***********************/
	class CommodityPremiumImpl extends NonNegativePayment.NonNegativePaymentImpl implements CommodityPremium {
		private final NonNegativeMoney premiumPerUnit;
		
		protected CommodityPremiumImpl(CommodityPremium.CommodityPremiumBuilder builder) {
			super(builder);
			this.premiumPerUnit = ofNullable(builder.getPremiumPerUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("premiumPerUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumPerUnit")
		public NonNegativeMoney getPremiumPerUnit() {
			return premiumPerUnit;
		}
		
		@Override
		public CommodityPremium build() {
			return this;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder toBuilder() {
			CommodityPremium.CommodityPremiumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPremium.CommodityPremiumBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPremiumPerUnit()).ifPresent(builder::setPremiumPerUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPremium _that = getType().cast(o);
		
			if (!Objects.equals(premiumPerUnit, _that.getPremiumPerUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumPerUnit != null ? premiumPerUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPremium {" +
				"premiumPerUnit=" + this.premiumPerUnit +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPremium  ***********************/
	class CommodityPremiumBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl implements CommodityPremium.CommodityPremiumBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder premiumPerUnit;
		
		@Override
		@RosettaAttribute("premiumPerUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("premiumPerUnit")
		public NonNegativeMoney.NonNegativeMoneyBuilder getPremiumPerUnit() {
			return premiumPerUnit;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreatePremiumPerUnit() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (premiumPerUnit!=null) {
				result = premiumPerUnit;
			}
			else {
				result = premiumPerUnit = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premiumPerUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("premiumPerUnit")
		@Override
		public CommodityPremium.CommodityPremiumBuilder setPremiumPerUnit(NonNegativeMoney _premiumPerUnit) {
			this.premiumPerUnit = _premiumPerUnit == null ? null : _premiumPerUnit.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPremium build() {
			return new CommodityPremium.CommodityPremiumImpl(this);
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPremium.CommodityPremiumBuilder prune() {
			super.prune();
			if (premiumPerUnit!=null && !premiumPerUnit.prune().hasData()) premiumPerUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPremiumPerUnit()!=null && getPremiumPerUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPremium.CommodityPremiumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityPremium.CommodityPremiumBuilder o = (CommodityPremium.CommodityPremiumBuilder) other;
			
			merger.mergeRosetta(getPremiumPerUnit(), o.getPremiumPerUnit(), this::setPremiumPerUnit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPremium _that = getType().cast(o);
		
			if (!Objects.equals(premiumPerUnit, _that.getPremiumPerUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (premiumPerUnit != null ? premiumPerUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPremiumBuilder {" +
				"premiumPerUnit=" + this.premiumPerUnit +
			'}' + " " + super.toString();
		}
	}
}
