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
import fpml.consolidated.shared.meta.ExchangeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A short form unique identifier for an exchange. If the element is not present then the exchange shall be the primary exchange on which the underlying is listed. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A short form unique identifier for an exchange. If the element is not present then the exchange shall be the primary exchange on which the underlying is listed. The term "Exchange" is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
 *
 */
@RosettaDataType(value="ExchangeId", builder=ExchangeId.ExchangeIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeId", model="fpml", builder=ExchangeId.ExchangeIdBuilderImpl.class, version="2.1.1")
public interface ExchangeId extends RosettaModelObject {

	ExchangeIdMeta metaData = new ExchangeIdMeta();

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
	String getValue();
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
	String getExchangeIdScheme();

	/*********************** Build Methods  ***********************/
	ExchangeId build();
	
	ExchangeId.ExchangeIdBuilder toBuilder();
	
	static ExchangeId.ExchangeIdBuilder builder() {
		return new ExchangeId.ExchangeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeId> getType() {
		return ExchangeId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("exchangeIdScheme"), String.class, getExchangeIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeIdBuilder extends ExchangeId, RosettaModelObjectBuilder {
		ExchangeId.ExchangeIdBuilder setValue(String value);
		ExchangeId.ExchangeIdBuilder setExchangeIdScheme(String exchangeIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("exchangeIdScheme"), String.class, getExchangeIdScheme(), this);
		}
		

		ExchangeId.ExchangeIdBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeId  ***********************/
	class ExchangeIdImpl implements ExchangeId {
		private final String value;
		private final String exchangeIdScheme;
		
		protected ExchangeIdImpl(ExchangeId.ExchangeIdBuilder builder) {
			this.value = builder.getValue();
			this.exchangeIdScheme = builder.getExchangeIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("exchangeIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeIdScheme")
		public String getExchangeIdScheme() {
			return exchangeIdScheme;
		}
		
		@Override
		public ExchangeId build() {
			return this;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder toBuilder() {
			ExchangeId.ExchangeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeId.ExchangeIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getExchangeIdScheme()).ifPresent(builder::setExchangeIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(exchangeIdScheme, _that.getExchangeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (exchangeIdScheme != null ? exchangeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeId {" +
				"value=" + this.value + ", " +
				"exchangeIdScheme=" + this.exchangeIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeId  ***********************/
	class ExchangeIdBuilderImpl implements ExchangeId.ExchangeIdBuilder {
	
		protected String value;
		protected String exchangeIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("exchangeIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeIdScheme")
		public String getExchangeIdScheme() {
			return exchangeIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ExchangeId.ExchangeIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("exchangeIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeIdScheme")
		@Override
		public ExchangeId.ExchangeIdBuilder setExchangeIdScheme(String _exchangeIdScheme) {
			this.exchangeIdScheme = _exchangeIdScheme == null ? null : _exchangeIdScheme;
			return this;
		}
		
		@Override
		public ExchangeId build() {
			return new ExchangeId.ExchangeIdImpl(this);
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeId.ExchangeIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getExchangeIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeId.ExchangeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeId.ExchangeIdBuilder o = (ExchangeId.ExchangeIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getExchangeIdScheme(), o.getExchangeIdScheme(), this::setExchangeIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(exchangeIdScheme, _that.getExchangeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (exchangeIdScheme != null ? exchangeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeIdBuilder {" +
				"value=" + this.value + ", " +
				"exchangeIdScheme=" + this.exchangeIdScheme +
			'}';
		}
	}
}
