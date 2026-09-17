package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.AmountRefMeta;
import fpml.consolidated.shared.AmountReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a nominal amount with a reference.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a nominal amount with a reference.
 *
 */
@RosettaDataType(value="AmountRef", builder=AmountRef.AmountRefBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AmountRef", model="fpml", builder=AmountRef.AmountRefBuilderImpl.class, version="2.1.1")
public interface AmountRef extends RosettaModelObject {

	AmountRefMeta metaData = new AmountRefMeta();

	/*********************** Getter Methods  ***********************/
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
	BigDecimal getAmount();
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
	AmountReference getAmountReference();

	/*********************** Build Methods  ***********************/
	AmountRef build();
	
	AmountRef.AmountRefBuilder toBuilder();
	
	static AmountRef.AmountRefBuilder builder() {
		return new AmountRef.AmountRefBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountRef> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmountRef> getType() {
		return AmountRef.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processRosetta(path.newSubPath("amountReference"), processor, AmountReference.class, getAmountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountRefBuilder extends AmountRef, RosettaModelObjectBuilder {
		AmountReference.AmountReferenceBuilder getOrCreateAmountReference();
		@Override
		AmountReference.AmountReferenceBuilder getAmountReference();
		AmountRef.AmountRefBuilder setAmount(BigDecimal amount);
		AmountRef.AmountRefBuilder setAmountReference(AmountReference amountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processRosetta(path.newSubPath("amountReference"), processor, AmountReference.AmountReferenceBuilder.class, getAmountReference());
		}
		

		AmountRef.AmountRefBuilder prune();
	}

	/*********************** Immutable Implementation of AmountRef  ***********************/
	class AmountRefImpl implements AmountRef {
		private final BigDecimal amount;
		private final AmountReference amountReference;
		
		protected AmountRefImpl(AmountRef.AmountRefBuilder builder) {
			this.amount = builder.getAmount();
			this.amountReference = ofNullable(builder.getAmountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("amountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountReference")
		public AmountReference getAmountReference() {
			return amountReference;
		}
		
		@Override
		public AmountRef build() {
			return this;
		}
		
		@Override
		public AmountRef.AmountRefBuilder toBuilder() {
			AmountRef.AmountRefBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountRef.AmountRefBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAmountReference()).ifPresent(builder::setAmountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountRef _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(amountReference, _that.getAmountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (amountReference != null ? amountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountRef {" +
				"amount=" + this.amount + ", " +
				"amountReference=" + this.amountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of AmountRef  ***********************/
	class AmountRefBuilderImpl implements AmountRef.AmountRefBuilder {
	
		protected BigDecimal amount;
		protected AmountReference.AmountReferenceBuilder amountReference;
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("amountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountReference")
		public AmountReference.AmountReferenceBuilder getAmountReference() {
			return amountReference;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateAmountReference() {
			AmountReference.AmountReferenceBuilder result;
			if (amountReference!=null) {
				result = amountReference;
			}
			else {
				result = amountReference = AmountReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public AmountRef.AmountRefBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("amountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountReference")
		@Override
		public AmountRef.AmountRefBuilder setAmountReference(AmountReference _amountReference) {
			this.amountReference = _amountReference == null ? null : _amountReference.toBuilder();
			return this;
		}
		
		@Override
		public AmountRef build() {
			return new AmountRef.AmountRefImpl(this);
		}
		
		@Override
		public AmountRef.AmountRefBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountRef.AmountRefBuilder prune() {
			if (amountReference!=null && !amountReference.prune().hasData()) amountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null) return true;
			if (getAmountReference()!=null && getAmountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountRef.AmountRefBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmountRef.AmountRefBuilder o = (AmountRef.AmountRefBuilder) other;
			
			merger.mergeRosetta(getAmountReference(), o.getAmountReference(), this::setAmountReference);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountRef _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(amountReference, _that.getAmountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (amountReference != null ? amountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountRefBuilder {" +
				"amount=" + this.amount + ", " +
				"amountReference=" + this.amountReference +
			'}';
		}
	}
}
