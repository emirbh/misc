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
import fpml.consolidated.doc.meta.OtcClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Indicator as to the type of transaction in accordance with Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Indicator as to the type of transaction in accordance with Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014.
 *
 */
@RosettaDataType(value="OtcClassification", builder=OtcClassification.OtcClassificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OtcClassification", model="fpml", builder=OtcClassification.OtcClassificationBuilderImpl.class, version="2.1.1")
public interface OtcClassification extends RosettaModelObject {

	OtcClassificationMeta metaData = new OtcClassificationMeta();

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
	String getOtcClassificationScheme();

	/*********************** Build Methods  ***********************/
	OtcClassification build();
	
	OtcClassification.OtcClassificationBuilder toBuilder();
	
	static OtcClassification.OtcClassificationBuilder builder() {
		return new OtcClassification.OtcClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtcClassification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtcClassification> getType() {
		return OtcClassification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("otcClassificationScheme"), String.class, getOtcClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtcClassificationBuilder extends OtcClassification, RosettaModelObjectBuilder {
		OtcClassification.OtcClassificationBuilder setValue(String value);
		OtcClassification.OtcClassificationBuilder setOtcClassificationScheme(String otcClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("otcClassificationScheme"), String.class, getOtcClassificationScheme(), this);
		}
		

		OtcClassification.OtcClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of OtcClassification  ***********************/
	class OtcClassificationImpl implements OtcClassification {
		private final String value;
		private final String otcClassificationScheme;
		
		protected OtcClassificationImpl(OtcClassification.OtcClassificationBuilder builder) {
			this.value = builder.getValue();
			this.otcClassificationScheme = builder.getOtcClassificationScheme();
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
		@RosettaAttribute("otcClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otcClassificationScheme")
		public String getOtcClassificationScheme() {
			return otcClassificationScheme;
		}
		
		@Override
		public OtcClassification build() {
			return this;
		}
		
		@Override
		public OtcClassification.OtcClassificationBuilder toBuilder() {
			OtcClassification.OtcClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtcClassification.OtcClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOtcClassificationScheme()).ifPresent(builder::setOtcClassificationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtcClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(otcClassificationScheme, _that.getOtcClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (otcClassificationScheme != null ? otcClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtcClassification {" +
				"value=" + this.value + ", " +
				"otcClassificationScheme=" + this.otcClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtcClassification  ***********************/
	class OtcClassificationBuilderImpl implements OtcClassification.OtcClassificationBuilder {
	
		protected String value;
		protected String otcClassificationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("otcClassificationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otcClassificationScheme")
		public String getOtcClassificationScheme() {
			return otcClassificationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OtcClassification.OtcClassificationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("otcClassificationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otcClassificationScheme")
		@Override
		public OtcClassification.OtcClassificationBuilder setOtcClassificationScheme(String _otcClassificationScheme) {
			this.otcClassificationScheme = _otcClassificationScheme == null ? null : _otcClassificationScheme;
			return this;
		}
		
		@Override
		public OtcClassification build() {
			return new OtcClassification.OtcClassificationImpl(this);
		}
		
		@Override
		public OtcClassification.OtcClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtcClassification.OtcClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOtcClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtcClassification.OtcClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtcClassification.OtcClassificationBuilder o = (OtcClassification.OtcClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOtcClassificationScheme(), o.getOtcClassificationScheme(), this::setOtcClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtcClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(otcClassificationScheme, _that.getOtcClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (otcClassificationScheme != null ? otcClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtcClassificationBuilder {" +
				"value=" + this.value + ", " +
				"otcClassificationScheme=" + this.otcClassificationScheme +
			'}';
		}
	}
}
