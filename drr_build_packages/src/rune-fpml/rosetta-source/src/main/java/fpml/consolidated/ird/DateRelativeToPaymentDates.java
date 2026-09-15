package fpml.consolidated.ird;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.ird.meta.DateRelativeToPaymentDatesMeta;
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
 * Provision A type to provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 *
 */
@RosettaDataType(value="DateRelativeToPaymentDates", builder=DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DateRelativeToPaymentDates", model="fpml", builder=DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl.class, version="2.1.1")
public interface DateRelativeToPaymentDates extends RosettaModelObject {

	DateRelativeToPaymentDatesMeta metaData = new DateRelativeToPaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of href pointers to payment dates defined somewhere else in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of href pointers to payment dates defined somewhere else in the document.
	 *
	 */
	List<? extends PaymentDatesReference> getPaymentDatesReference();

	/*********************** Build Methods  ***********************/
	DateRelativeToPaymentDates build();
	
	DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder();
	
	static DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder() {
		return new DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateRelativeToPaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateRelativeToPaymentDates> getType() {
		return DateRelativeToPaymentDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentDatesReference"), processor, PaymentDatesReference.class, getPaymentDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateRelativeToPaymentDatesBuilder extends DateRelativeToPaymentDates, RosettaModelObjectBuilder {
		PaymentDatesReference.PaymentDatesReferenceBuilder getOrCreatePaymentDatesReference(int index);
		@Override
		List<? extends PaymentDatesReference.PaymentDatesReferenceBuilder> getPaymentDatesReference();
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference paymentDatesReference, int idx);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReference);
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentDatesReference"), processor, PaymentDatesReference.PaymentDatesReferenceBuilder.class, getPaymentDatesReference());
		}
		

		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of DateRelativeToPaymentDates  ***********************/
	class DateRelativeToPaymentDatesImpl implements DateRelativeToPaymentDates {
		private final List<? extends PaymentDatesReference> paymentDatesReference;
		
		protected DateRelativeToPaymentDatesImpl(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder) {
			this.paymentDatesReference = ofNullable(builder.getPaymentDatesReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("paymentDatesReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentDatesReference")
		public List<? extends PaymentDatesReference> getPaymentDatesReference() {
			return paymentDatesReference;
		}
		
		@Override
		public DateRelativeToPaymentDates build() {
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder() {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder builder) {
			ofNullable(getPaymentDatesReference()).ifPresent(builder::setPaymentDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToPaymentDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDatesReference, _that.getPaymentDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesReference != null ? paymentDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToPaymentDates {" +
				"paymentDatesReference=" + this.paymentDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DateRelativeToPaymentDates  ***********************/
	class DateRelativeToPaymentDatesBuilderImpl implements DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder {
	
		protected List<PaymentDatesReference.PaymentDatesReferenceBuilder> paymentDatesReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("paymentDatesReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("paymentDatesReference")
		public List<? extends PaymentDatesReference.PaymentDatesReferenceBuilder> getPaymentDatesReference() {
			return paymentDatesReference;
		}
		
		@Override
		public PaymentDatesReference.PaymentDatesReferenceBuilder getOrCreatePaymentDatesReference(int index) {
			if (paymentDatesReference==null) {
				this.paymentDatesReference = new ArrayList<>();
			}
			return getIndex(paymentDatesReference, index, () -> {
						PaymentDatesReference.PaymentDatesReferenceBuilder newPaymentDatesReference = PaymentDatesReference.builder();
						return newPaymentDatesReference;
					});
		}
		
		@RosettaAttribute("paymentDatesReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("paymentDatesReference")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference _paymentDatesReference) {
			if (_paymentDatesReference != null) {
				this.paymentDatesReference.add(_paymentDatesReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(PaymentDatesReference _paymentDatesReference, int idx) {
			getIndex(this.paymentDatesReference, idx, () -> _paymentDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder addPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReferences) {
			if (paymentDatesReferences != null) {
				for (final PaymentDatesReference toAdd : paymentDatesReferences) {
					this.paymentDatesReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("paymentDatesReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("paymentDatesReference")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder setPaymentDatesReference(List<? extends PaymentDatesReference> paymentDatesReferences) {
			if (paymentDatesReferences == null) {
				this.paymentDatesReference = new ArrayList<>();
			} else {
				this.paymentDatesReference = paymentDatesReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DateRelativeToPaymentDates build() {
			return new DateRelativeToPaymentDates.DateRelativeToPaymentDatesImpl(this);
		}
		
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder prune() {
			paymentDatesReference = paymentDatesReference.stream().filter(b->b!=null).<PaymentDatesReference.PaymentDatesReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentDatesReference()!=null && getPaymentDatesReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder o = (DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentDatesReference(), o.getPaymentDatesReference(), this::getOrCreatePaymentDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToPaymentDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(paymentDatesReference, _that.getPaymentDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesReference != null ? paymentDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToPaymentDatesBuilder {" +
				"paymentDatesReference=" + this.paymentDatesReference +
			'}';
		}
	}
}
