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
import fpml.consolidated.shared.meta.CountryCodeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The code representation of a country or an area of special sovereignty. By default it is a valid 2 character country code as defined by the ISO standard 3166-1 alpha-2 - Codes for representation of countries http://www.niso.org/standards/resources/3166.html.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The code representation of a country or an area of special sovereignty. By default it is a valid 2 character country code as defined by the ISO standard 3166-1 alpha-2 - Codes for representation of countries http://www.niso.org/standards/resources/3166.html.
 *
 */
@RosettaDataType(value="CountryCode", builder=CountryCode.CountryCodeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CountryCode", model="fpml", builder=CountryCode.CountryCodeBuilderImpl.class, version="2.1.1")
public interface CountryCode extends RosettaModelObject {

	CountryCodeMeta metaData = new CountryCodeMeta();

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
	String getCountryScheme();

	/*********************** Build Methods  ***********************/
	CountryCode build();
	
	CountryCode.CountryCodeBuilder toBuilder();
	
	static CountryCode.CountryCodeBuilder builder() {
		return new CountryCode.CountryCodeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CountryCode> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CountryCode> getType() {
		return CountryCode.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("countryScheme"), String.class, getCountryScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CountryCodeBuilder extends CountryCode, RosettaModelObjectBuilder {
		CountryCode.CountryCodeBuilder setValue(String value);
		CountryCode.CountryCodeBuilder setCountryScheme(String countryScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("countryScheme"), String.class, getCountryScheme(), this);
		}
		

		CountryCode.CountryCodeBuilder prune();
	}

	/*********************** Immutable Implementation of CountryCode  ***********************/
	class CountryCodeImpl implements CountryCode {
		private final String value;
		private final String countryScheme;
		
		protected CountryCodeImpl(CountryCode.CountryCodeBuilder builder) {
			this.value = builder.getValue();
			this.countryScheme = builder.getCountryScheme();
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
		@RosettaAttribute("countryScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryScheme")
		public String getCountryScheme() {
			return countryScheme;
		}
		
		@Override
		public CountryCode build() {
			return this;
		}
		
		@Override
		public CountryCode.CountryCodeBuilder toBuilder() {
			CountryCode.CountryCodeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CountryCode.CountryCodeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCountryScheme()).ifPresent(builder::setCountryScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CountryCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(countryScheme, _that.getCountryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (countryScheme != null ? countryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CountryCode {" +
				"value=" + this.value + ", " +
				"countryScheme=" + this.countryScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CountryCode  ***********************/
	class CountryCodeBuilderImpl implements CountryCode.CountryCodeBuilder {
	
		protected String value;
		protected String countryScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("countryScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryScheme")
		public String getCountryScheme() {
			return countryScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CountryCode.CountryCodeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("countryScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryScheme")
		@Override
		public CountryCode.CountryCodeBuilder setCountryScheme(String _countryScheme) {
			this.countryScheme = _countryScheme == null ? null : _countryScheme;
			return this;
		}
		
		@Override
		public CountryCode build() {
			return new CountryCode.CountryCodeImpl(this);
		}
		
		@Override
		public CountryCode.CountryCodeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CountryCode.CountryCodeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCountryScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CountryCode.CountryCodeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CountryCode.CountryCodeBuilder o = (CountryCode.CountryCodeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCountryScheme(), o.getCountryScheme(), this::setCountryScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CountryCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(countryScheme, _that.getCountryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (countryScheme != null ? countryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CountryCodeBuilder {" +
				"value=" + this.value + ", " +
				"countryScheme=" + this.countryScheme +
			'}';
		}
	}
}
