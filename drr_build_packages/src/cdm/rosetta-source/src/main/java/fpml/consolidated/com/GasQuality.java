package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.GasQualityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The quantity of gas to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The quantity of gas to be delivered.
 *
 */
@RosettaDataType(value="GasQuality", builder=GasQuality.GasQualityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasQuality", model="fpml", builder=GasQuality.GasQualityBuilderImpl.class, version="2.1.1")
public interface GasQuality extends RosettaModelObject {

	GasQualityMeta metaData = new GasQualityMeta();

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
	String getGasQualityScheme();

	/*********************** Build Methods  ***********************/
	GasQuality build();
	
	GasQuality.GasQualityBuilder toBuilder();
	
	static GasQuality.GasQualityBuilder builder() {
		return new GasQuality.GasQualityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasQuality> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasQuality> getType() {
		return GasQuality.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("gasQualityScheme"), String.class, getGasQualityScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasQualityBuilder extends GasQuality, RosettaModelObjectBuilder {
		GasQuality.GasQualityBuilder setValue(String value);
		GasQuality.GasQualityBuilder setGasQualityScheme(String gasQualityScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("gasQualityScheme"), String.class, getGasQualityScheme(), this);
		}
		

		GasQuality.GasQualityBuilder prune();
	}

	/*********************** Immutable Implementation of GasQuality  ***********************/
	class GasQualityImpl implements GasQuality {
		private final String value;
		private final String gasQualityScheme;
		
		protected GasQualityImpl(GasQuality.GasQualityBuilder builder) {
			this.value = builder.getValue();
			this.gasQualityScheme = builder.getGasQualityScheme();
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
		@RosettaAttribute("gasQualityScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gasQualityScheme")
		public String getGasQualityScheme() {
			return gasQualityScheme;
		}
		
		@Override
		public GasQuality build() {
			return this;
		}
		
		@Override
		public GasQuality.GasQualityBuilder toBuilder() {
			GasQuality.GasQualityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasQuality.GasQualityBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getGasQualityScheme()).ifPresent(builder::setGasQualityScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasQuality _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(gasQualityScheme, _that.getGasQualityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (gasQualityScheme != null ? gasQualityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasQuality {" +
				"value=" + this.value + ", " +
				"gasQualityScheme=" + this.gasQualityScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GasQuality  ***********************/
	class GasQualityBuilderImpl implements GasQuality.GasQualityBuilder {
	
		protected String value;
		protected String gasQualityScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("gasQualityScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("gasQualityScheme")
		public String getGasQualityScheme() {
			return gasQualityScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public GasQuality.GasQualityBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("gasQualityScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("gasQualityScheme")
		@Override
		public GasQuality.GasQualityBuilder setGasQualityScheme(String _gasQualityScheme) {
			this.gasQualityScheme = _gasQualityScheme == null ? null : _gasQualityScheme;
			return this;
		}
		
		@Override
		public GasQuality build() {
			return new GasQuality.GasQualityImpl(this);
		}
		
		@Override
		public GasQuality.GasQualityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasQuality.GasQualityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getGasQualityScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasQuality.GasQualityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasQuality.GasQualityBuilder o = (GasQuality.GasQualityBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getGasQualityScheme(), o.getGasQualityScheme(), this::setGasQualityScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasQuality _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(gasQualityScheme, _that.getGasQualityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (gasQualityScheme != null ? gasQualityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasQualityBuilder {" +
				"value=" + this.value + ", " +
				"gasQualityScheme=" + this.gasQualityScheme +
			'}';
		}
	}
}
