package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.CurrencyPairClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type containing a code representing the risk classification of a currency pair, as specified by a regulator.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type containing a code representing the risk classification of a currency pair, as specified by a regulator.
 *
 */
@RosettaDataType(value="CurrencyPairClassification", builder=CurrencyPairClassification.CurrencyPairClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CurrencyPairClassification", model="fpml", builder=CurrencyPairClassification.CurrencyPairClassificationBuilderImpl.class, version="2.1.1")
public interface CurrencyPairClassification extends RosettaModelObject {

	CurrencyPairClassificationMeta metaData = new CurrencyPairClassificationMeta();

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
	String getCurrencyPairClassificationScheme();
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
	CurrencyPairClassification build();
	
	CurrencyPairClassification.CurrencyPairClassificationBuilder toBuilder();
	
	static CurrencyPairClassification.CurrencyPairClassificationBuilder builder() {
		return new CurrencyPairClassification.CurrencyPairClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CurrencyPairClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CurrencyPairClassification> getType() {
		return CurrencyPairClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("currencyPairClassificationScheme"), String.class, getCurrencyPairClassificationScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurrencyPairClassificationBuilder extends CurrencyPairClassification, RosettaModelObjectBuilder {
		CurrencyPairClassification.CurrencyPairClassificationBuilder setValue(String value);
		CurrencyPairClassification.CurrencyPairClassificationBuilder setCurrencyPairClassificationScheme(String currencyPairClassificationScheme);
		CurrencyPairClassification.CurrencyPairClassificationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("currencyPairClassificationScheme"), String.class, getCurrencyPairClassificationScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CurrencyPairClassification.CurrencyPairClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of CurrencyPairClassification  ***********************/
	class CurrencyPairClassificationImpl implements CurrencyPairClassification {
		private final String value;
		private final String currencyPairClassificationScheme;
		private final String id;
		
		protected CurrencyPairClassificationImpl(CurrencyPairClassification.CurrencyPairClassificationBuilder builder) {
			this.value = builder.getValue();
			this.currencyPairClassificationScheme = builder.getCurrencyPairClassificationScheme();
			this.id = builder.getId();
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
		@RosettaAttribute("currencyPairClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyPairClassificationScheme")
		public String getCurrencyPairClassificationScheme() {
			return currencyPairClassificationScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CurrencyPairClassification build() {
			return this;
		}
		
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder toBuilder() {
			CurrencyPairClassification.CurrencyPairClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CurrencyPairClassification.CurrencyPairClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCurrencyPairClassificationScheme()).ifPresent(builder::setCurrencyPairClassificationScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyPairClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(currencyPairClassificationScheme, _that.getCurrencyPairClassificationScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassificationScheme != null ? currencyPairClassificationScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyPairClassification {" +
				"value=" + this.value + ", " +
				"currencyPairClassificationScheme=" + this.currencyPairClassificationScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CurrencyPairClassification  ***********************/
	class CurrencyPairClassificationBuilderImpl implements CurrencyPairClassification.CurrencyPairClassificationBuilder {
	
		protected String value;
		protected String currencyPairClassificationScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyPairClassificationScheme")
		public String getCurrencyPairClassificationScheme() {
			return currencyPairClassificationScheme;
		}
		
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
		public CurrencyPairClassification.CurrencyPairClassificationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("currencyPairClassificationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyPairClassificationScheme")
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder setCurrencyPairClassificationScheme(String _currencyPairClassificationScheme) {
			this.currencyPairClassificationScheme = _currencyPairClassificationScheme == null ? null : _currencyPairClassificationScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public CurrencyPairClassification build() {
			return new CurrencyPairClassification.CurrencyPairClassificationImpl(this);
		}
		
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCurrencyPairClassificationScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CurrencyPairClassification.CurrencyPairClassificationBuilder o = (CurrencyPairClassification.CurrencyPairClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCurrencyPairClassificationScheme(), o.getCurrencyPairClassificationScheme(), this::setCurrencyPairClassificationScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyPairClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(currencyPairClassificationScheme, _that.getCurrencyPairClassificationScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassificationScheme != null ? currencyPairClassificationScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyPairClassificationBuilder {" +
				"value=" + this.value + ", " +
				"currencyPairClassificationScheme=" + this.currencyPairClassificationScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
