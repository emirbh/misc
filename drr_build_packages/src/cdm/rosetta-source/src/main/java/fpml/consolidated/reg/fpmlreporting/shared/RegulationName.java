package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.RegulationNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An identifier of a regulation used for regulatory reporting, for example CFTC_PART43, CFTC_PART45, CSA_2013, etc.
 *
 */
@RosettaDataType(value="RegulationName", builder=RegulationName.RegulationNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulationName", model="fpml", builder=RegulationName.RegulationNameBuilderImpl.class, version="2.1.1")
public interface RegulationName extends RosettaModelObject {

	RegulationNameMeta metaData = new RegulationNameMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	String getRegulationNameScheme();

	/*********************** Build Methods  ***********************/
	RegulationName build();
	
	RegulationName.RegulationNameBuilder toBuilder();
	
	static RegulationName.RegulationNameBuilder builder() {
		return new RegulationName.RegulationNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulationName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulationName> getType() {
		return RegulationName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("regulationNameScheme"), String.class, getRegulationNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulationNameBuilder extends RegulationName, RosettaModelObjectBuilder {
		RegulationName.RegulationNameBuilder setValue(String value);
		RegulationName.RegulationNameBuilder setRegulationNameScheme(String regulationNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("regulationNameScheme"), String.class, getRegulationNameScheme(), this);
		}
		

		RegulationName.RegulationNameBuilder prune();
	}

	/*********************** Immutable Implementation of RegulationName  ***********************/
	class RegulationNameImpl implements RegulationName {
		private final String value;
		private final String regulationNameScheme;
		
		protected RegulationNameImpl(RegulationName.RegulationNameBuilder builder) {
			this.value = builder.getValue();
			this.regulationNameScheme = builder.getRegulationNameScheme();
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
		@RosettaAttribute("regulationNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regulationNameScheme")
		public String getRegulationNameScheme() {
			return regulationNameScheme;
		}
		
		@Override
		public RegulationName build() {
			return this;
		}
		
		@Override
		public RegulationName.RegulationNameBuilder toBuilder() {
			RegulationName.RegulationNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulationName.RegulationNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRegulationNameScheme()).ifPresent(builder::setRegulationNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulationName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regulationNameScheme, _that.getRegulationNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regulationNameScheme != null ? regulationNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulationName {" +
				"value=" + this.value + ", " +
				"regulationNameScheme=" + this.regulationNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulationName  ***********************/
	class RegulationNameBuilderImpl implements RegulationName.RegulationNameBuilder {
	
		protected String value;
		protected String regulationNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("regulationNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("regulationNameScheme")
		public String getRegulationNameScheme() {
			return regulationNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public RegulationName.RegulationNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("regulationNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("regulationNameScheme")
		@Override
		public RegulationName.RegulationNameBuilder setRegulationNameScheme(String _regulationNameScheme) {
			this.regulationNameScheme = _regulationNameScheme == null ? null : _regulationNameScheme;
			return this;
		}
		
		@Override
		public RegulationName build() {
			return new RegulationName.RegulationNameImpl(this);
		}
		
		@Override
		public RegulationName.RegulationNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulationName.RegulationNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRegulationNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulationName.RegulationNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulationName.RegulationNameBuilder o = (RegulationName.RegulationNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRegulationNameScheme(), o.getRegulationNameScheme(), this::setRegulationNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulationName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(regulationNameScheme, _that.getRegulationNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (regulationNameScheme != null ? regulationNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulationNameBuilder {" +
				"value=" + this.value + ", " +
				"regulationNameScheme=" + this.regulationNameScheme +
			'}';
		}
	}
}
