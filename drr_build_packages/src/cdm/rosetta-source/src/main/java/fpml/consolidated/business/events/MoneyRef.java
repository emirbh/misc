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
import fpml.consolidated.business.events.meta.MoneyRefMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.PositiveMoney;
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
 * Provision A type defining a currency amount with a reference.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a currency amount with a reference.
 *
 */
@RosettaDataType(value="MoneyRef", builder=MoneyRef.MoneyRefBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MoneyRef", model="fpml", builder=MoneyRef.MoneyRefBuilderImpl.class, version="2.1.1")
public interface MoneyRef extends PositiveMoney {

	MoneyRefMeta metaData = new MoneyRefMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated notional schedule defined elsewhere in the document.
	 *
	 */
	NotionalReference getNotionalReference();

	/*********************** Build Methods  ***********************/
	MoneyRef build();
	
	MoneyRef.MoneyRefBuilder toBuilder();
	
	static MoneyRef.MoneyRefBuilder builder() {
		return new MoneyRef.MoneyRefBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MoneyRef> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MoneyRef> getType() {
		return MoneyRef.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyRefBuilder extends MoneyRef, PositiveMoney.PositiveMoneyBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		@Override
		MoneyRef.MoneyRefBuilder setId(String id);
		@Override
		MoneyRef.MoneyRefBuilder setCurrency(Currency currency);
		@Override
		MoneyRef.MoneyRefBuilder setAmount(BigDecimal amount);
		MoneyRef.MoneyRefBuilder setNotionalReference(NotionalReference notionalReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
		}
		

		MoneyRef.MoneyRefBuilder prune();
	}

	/*********************** Immutable Implementation of MoneyRef  ***********************/
	class MoneyRefImpl extends PositiveMoney.PositiveMoneyImpl implements MoneyRef {
		private final NotionalReference notionalReference;
		
		protected MoneyRefImpl(MoneyRef.MoneyRefBuilder builder) {
			super(builder);
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public MoneyRef build() {
			return this;
		}
		
		@Override
		public MoneyRef.MoneyRefBuilder toBuilder() {
			MoneyRef.MoneyRefBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MoneyRef.MoneyRefBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MoneyRef _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyRef {" +
				"notionalReference=" + this.notionalReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MoneyRef  ***********************/
	class MoneyRefBuilderImpl extends PositiveMoney.PositiveMoneyBuilderImpl implements MoneyRef.MoneyRefBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public MoneyRef.MoneyRefBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public MoneyRef.MoneyRefBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public MoneyRef.MoneyRefBuilder setAmount(BigDecimal _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReference")
		@Override
		public MoneyRef.MoneyRefBuilder setNotionalReference(NotionalReference _notionalReference) {
			this.notionalReference = _notionalReference == null ? null : _notionalReference.toBuilder();
			return this;
		}
		
		@Override
		public MoneyRef build() {
			return new MoneyRef.MoneyRefImpl(this);
		}
		
		@Override
		public MoneyRef.MoneyRefBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyRef.MoneyRefBuilder prune() {
			super.prune();
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyRef.MoneyRefBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MoneyRef.MoneyRefBuilder o = (MoneyRef.MoneyRefBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MoneyRef _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyRefBuilder {" +
				"notionalReference=" + this.notionalReference +
			'}' + " " + super.toString();
		}
	}
}
