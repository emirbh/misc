package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.IdentifiedCurrencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies Currency with ID attribute.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies Currency with ID attribute.
 *
 */
@RosettaDataType(value="IdentifiedCurrency", builder=IdentifiedCurrency.IdentifiedCurrencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IdentifiedCurrency", model="fpml", builder=IdentifiedCurrency.IdentifiedCurrencyBuilderImpl.class, version="2.1.1")
public interface IdentifiedCurrency extends Currency {

	IdentifiedCurrencyMeta metaData = new IdentifiedCurrencyMeta();

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
	String getId();

	/*********************** Build Methods  ***********************/
	IdentifiedCurrency build();
	
	IdentifiedCurrency.IdentifiedCurrencyBuilder toBuilder();
	
	static IdentifiedCurrency.IdentifiedCurrencyBuilder builder() {
		return new IdentifiedCurrency.IdentifiedCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IdentifiedCurrency> getType() {
		return IdentifiedCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("currencyScheme"), String.class, getCurrencyScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedCurrencyBuilder extends IdentifiedCurrency, Currency.CurrencyBuilder {
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder setValue(String value);
		@Override
		IdentifiedCurrency.IdentifiedCurrencyBuilder setCurrencyScheme(String currencyScheme);
		IdentifiedCurrency.IdentifiedCurrencyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("currencyScheme"), String.class, getCurrencyScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IdentifiedCurrency.IdentifiedCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedCurrency  ***********************/
	class IdentifiedCurrencyImpl extends Currency.CurrencyImpl implements IdentifiedCurrency {
		private final String id;
		
		protected IdentifiedCurrencyImpl(IdentifiedCurrency.IdentifiedCurrencyBuilder builder) {
			super(builder);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public IdentifiedCurrency build() {
			return this;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder toBuilder() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedCurrency.IdentifiedCurrencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedCurrency {" +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedCurrency  ***********************/
	class IdentifiedCurrencyBuilderImpl extends Currency.CurrencyBuilderImpl implements IdentifiedCurrency.IdentifiedCurrencyBuilder {
	
		protected String id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("currencyScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyScheme")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder setCurrencyScheme(String _currencyScheme) {
			this.currencyScheme = _currencyScheme == null ? null : _currencyScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public IdentifiedCurrency build() {
			return new IdentifiedCurrency.IdentifiedCurrencyImpl(this);
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			IdentifiedCurrency.IdentifiedCurrencyBuilder o = (IdentifiedCurrency.IdentifiedCurrencyBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedCurrencyBuilder {" +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}
}
