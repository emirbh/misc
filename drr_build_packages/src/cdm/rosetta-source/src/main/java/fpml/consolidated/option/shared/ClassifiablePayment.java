package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.ClassifiablePaymentMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentType;
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
 * Provision A classified non negative payment.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A classified non negative payment.
 *
 */
@RosettaDataType(value="ClassifiablePayment", builder=ClassifiablePayment.ClassifiablePaymentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClassifiablePayment", model="fpml", builder=ClassifiablePayment.ClassifiablePaymentBuilderImpl.class, version="2.1.1")
public interface ClassifiablePayment extends NonNegativePayment {

	ClassifiablePaymentMeta metaData = new ClassifiablePaymentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Payment classification.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Payment classification.
	 *
	 */
	List<? extends PaymentType> getPaymentType();

	/*********************** Build Methods  ***********************/
	ClassifiablePayment build();
	
	ClassifiablePayment.ClassifiablePaymentBuilder toBuilder();
	
	static ClassifiablePayment.ClassifiablePaymentBuilder builder() {
		return new ClassifiablePayment.ClassifiablePaymentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClassifiablePayment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClassifiablePayment> getType() {
		return ClassifiablePayment.class;
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
		processRosetta(path.newSubPath("paymentType"), processor, PaymentType.class, getPaymentType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClassifiablePaymentBuilder extends ClassifiablePayment, NonNegativePayment.NonNegativePaymentBuilder {
		PaymentType.PaymentTypeBuilder getOrCreatePaymentType(int index);
		@Override
		List<? extends PaymentType.PaymentTypeBuilder> getPaymentType();
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setId(String id);
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		@Override
		ClassifiablePayment.ClassifiablePaymentBuilder setPaymentAmount(NonNegativeMoney paymentAmount);
		ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType paymentType);
		ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType paymentType, int idx);
		ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(List<? extends PaymentType> paymentType);
		ClassifiablePayment.ClassifiablePaymentBuilder setPaymentType(List<? extends PaymentType> paymentType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("paymentAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getPaymentAmount());
			processRosetta(path.newSubPath("paymentType"), processor, PaymentType.PaymentTypeBuilder.class, getPaymentType());
		}
		

		ClassifiablePayment.ClassifiablePaymentBuilder prune();
	}

	/*********************** Immutable Implementation of ClassifiablePayment  ***********************/
	class ClassifiablePaymentImpl extends NonNegativePayment.NonNegativePaymentImpl implements ClassifiablePayment {
		private final List<? extends PaymentType> paymentType;
		
		protected ClassifiablePaymentImpl(ClassifiablePayment.ClassifiablePaymentBuilder builder) {
			super(builder);
			this.paymentType = ofNullable(builder.getPaymentType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentType")
		public List<? extends PaymentType> getPaymentType() {
			return paymentType;
		}
		
		@Override
		public ClassifiablePayment build() {
			return this;
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder toBuilder() {
			ClassifiablePayment.ClassifiablePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClassifiablePayment.ClassifiablePaymentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPaymentType()).ifPresent(builder::setPaymentType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClassifiablePayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClassifiablePayment {" +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClassifiablePayment  ***********************/
	class ClassifiablePaymentBuilderImpl extends NonNegativePayment.NonNegativePaymentBuilderImpl implements ClassifiablePayment.ClassifiablePaymentBuilder {
	
		protected List<PaymentType.PaymentTypeBuilder> paymentType = new ArrayList<>();
		
		@Override
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentType")
		public List<? extends PaymentType.PaymentTypeBuilder> getPaymentType() {
			return paymentType;
		}
		
		@Override
		public PaymentType.PaymentTypeBuilder getOrCreatePaymentType(int index) {
			if (paymentType==null) {
				this.paymentType = new ArrayList<>();
			}
			return getIndex(paymentType, index, () -> {
						PaymentType.PaymentTypeBuilder newPaymentType = PaymentType.builder();
						return newPaymentType;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setPaymentDate(AdjustableOrRelativeDate _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("paymentAmount")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setPaymentAmount(NonNegativeMoney _paymentAmount) {
			this.paymentAmount = _paymentAmount == null ? null : _paymentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentType")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType _paymentType) {
			if (_paymentType != null) {
				this.paymentType.add(_paymentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(PaymentType _paymentType, int idx) {
			getIndex(this.paymentType, idx, () -> _paymentType.toBuilder());
			return this;
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder addPaymentType(List<? extends PaymentType> paymentTypes) {
			if (paymentTypes != null) {
				for (final PaymentType toAdd : paymentTypes) {
					this.paymentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("paymentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("paymentType")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder setPaymentType(List<? extends PaymentType> paymentTypes) {
			if (paymentTypes == null) {
				this.paymentType = new ArrayList<>();
			} else {
				this.paymentType = paymentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ClassifiablePayment build() {
			return new ClassifiablePayment.ClassifiablePaymentImpl(this);
		}
		
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder prune() {
			super.prune();
			paymentType = paymentType.stream().filter(b->b!=null).<PaymentType.PaymentTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPaymentType()!=null && getPaymentType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClassifiablePayment.ClassifiablePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ClassifiablePayment.ClassifiablePaymentBuilder o = (ClassifiablePayment.ClassifiablePaymentBuilder) other;
			
			merger.mergeRosetta(getPaymentType(), o.getPaymentType(), this::getOrCreatePaymentType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClassifiablePayment _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentType, _that.getPaymentType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (paymentType != null ? paymentType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClassifiablePaymentBuilder {" +
				"paymentType=" + this.paymentType +
			'}' + " " + super.toString();
		}
	}
}
