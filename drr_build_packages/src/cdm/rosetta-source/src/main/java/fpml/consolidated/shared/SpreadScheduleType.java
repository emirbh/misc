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
import fpml.consolidated.shared.meta.SpreadScheduleTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines a Spread Type Scheme to identify a long or short spread value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a Spread Type Scheme to identify a long or short spread value.
 *
 */
@RosettaDataType(value="SpreadScheduleType", builder=SpreadScheduleType.SpreadScheduleTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SpreadScheduleType", model="fpml", builder=SpreadScheduleType.SpreadScheduleTypeBuilderImpl.class, version="2.1.1")
public interface SpreadScheduleType extends RosettaModelObject {

	SpreadScheduleTypeMeta metaData = new SpreadScheduleTypeMeta();

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
	String getSpreadScheduleTypeScheme();

	/*********************** Build Methods  ***********************/
	SpreadScheduleType build();
	
	SpreadScheduleType.SpreadScheduleTypeBuilder toBuilder();
	
	static SpreadScheduleType.SpreadScheduleTypeBuilder builder() {
		return new SpreadScheduleType.SpreadScheduleTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpreadScheduleType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpreadScheduleType> getType() {
		return SpreadScheduleType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("spreadScheduleTypeScheme"), String.class, getSpreadScheduleTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpreadScheduleTypeBuilder extends SpreadScheduleType, RosettaModelObjectBuilder {
		SpreadScheduleType.SpreadScheduleTypeBuilder setValue(String value);
		SpreadScheduleType.SpreadScheduleTypeBuilder setSpreadScheduleTypeScheme(String spreadScheduleTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("spreadScheduleTypeScheme"), String.class, getSpreadScheduleTypeScheme(), this);
		}
		

		SpreadScheduleType.SpreadScheduleTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SpreadScheduleType  ***********************/
	class SpreadScheduleTypeImpl implements SpreadScheduleType {
		private final String value;
		private final String spreadScheduleTypeScheme;
		
		protected SpreadScheduleTypeImpl(SpreadScheduleType.SpreadScheduleTypeBuilder builder) {
			this.value = builder.getValue();
			this.spreadScheduleTypeScheme = builder.getSpreadScheduleTypeScheme();
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
		@RosettaAttribute("spreadScheduleTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadScheduleTypeScheme")
		public String getSpreadScheduleTypeScheme() {
			return spreadScheduleTypeScheme;
		}
		
		@Override
		public SpreadScheduleType build() {
			return this;
		}
		
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder toBuilder() {
			SpreadScheduleType.SpreadScheduleTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpreadScheduleType.SpreadScheduleTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSpreadScheduleTypeScheme()).ifPresent(builder::setSpreadScheduleTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpreadScheduleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(spreadScheduleTypeScheme, _that.getSpreadScheduleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (spreadScheduleTypeScheme != null ? spreadScheduleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleType {" +
				"value=" + this.value + ", " +
				"spreadScheduleTypeScheme=" + this.spreadScheduleTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SpreadScheduleType  ***********************/
	class SpreadScheduleTypeBuilderImpl implements SpreadScheduleType.SpreadScheduleTypeBuilder {
	
		protected String value;
		protected String spreadScheduleTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("spreadScheduleTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadScheduleTypeScheme")
		public String getSpreadScheduleTypeScheme() {
			return spreadScheduleTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("spreadScheduleTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadScheduleTypeScheme")
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder setSpreadScheduleTypeScheme(String _spreadScheduleTypeScheme) {
			this.spreadScheduleTypeScheme = _spreadScheduleTypeScheme == null ? null : _spreadScheduleTypeScheme;
			return this;
		}
		
		@Override
		public SpreadScheduleType build() {
			return new SpreadScheduleType.SpreadScheduleTypeImpl(this);
		}
		
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSpreadScheduleTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadScheduleType.SpreadScheduleTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpreadScheduleType.SpreadScheduleTypeBuilder o = (SpreadScheduleType.SpreadScheduleTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSpreadScheduleTypeScheme(), o.getSpreadScheduleTypeScheme(), this::setSpreadScheduleTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpreadScheduleType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(spreadScheduleTypeScheme, _that.getSpreadScheduleTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (spreadScheduleTypeScheme != null ? spreadScheduleTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleTypeBuilder {" +
				"value=" + this.value + ", " +
				"spreadScheduleTypeScheme=" + this.spreadScheduleTypeScheme +
			'}';
		}
	}
}
