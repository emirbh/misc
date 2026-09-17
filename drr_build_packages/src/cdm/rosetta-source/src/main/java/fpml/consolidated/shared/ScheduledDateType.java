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
import fpml.consolidated.shared.meta.ScheduledDateTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme used to identify the type of a stream scheduled servicing date.
 *
 */
@RosettaDataType(value="ScheduledDateType", builder=ScheduledDateType.ScheduledDateTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ScheduledDateType", model="fpml", builder=ScheduledDateType.ScheduledDateTypeBuilderImpl.class, version="2.1.1")
public interface ScheduledDateType extends RosettaModelObject {

	ScheduledDateTypeMeta metaData = new ScheduledDateTypeMeta();

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
	String getScheduledDateTypeScheme();

	/*********************** Build Methods  ***********************/
	ScheduledDateType build();
	
	ScheduledDateType.ScheduledDateTypeBuilder toBuilder();
	
	static ScheduledDateType.ScheduledDateTypeBuilder builder() {
		return new ScheduledDateType.ScheduledDateTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ScheduledDateType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ScheduledDateType> getType() {
		return ScheduledDateType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("scheduledDateTypeScheme"), String.class, getScheduledDateTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ScheduledDateTypeBuilder extends ScheduledDateType, RosettaModelObjectBuilder {
		ScheduledDateType.ScheduledDateTypeBuilder setValue(String value);
		ScheduledDateType.ScheduledDateTypeBuilder setScheduledDateTypeScheme(String scheduledDateTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("scheduledDateTypeScheme"), String.class, getScheduledDateTypeScheme(), this);
		}
		

		ScheduledDateType.ScheduledDateTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ScheduledDateType  ***********************/
	class ScheduledDateTypeImpl implements ScheduledDateType {
		private final String value;
		private final String scheduledDateTypeScheme;
		
		protected ScheduledDateTypeImpl(ScheduledDateType.ScheduledDateTypeBuilder builder) {
			this.value = builder.getValue();
			this.scheduledDateTypeScheme = builder.getScheduledDateTypeScheme();
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
		@RosettaAttribute("scheduledDateTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scheduledDateTypeScheme")
		public String getScheduledDateTypeScheme() {
			return scheduledDateTypeScheme;
		}
		
		@Override
		public ScheduledDateType build() {
			return this;
		}
		
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder toBuilder() {
			ScheduledDateType.ScheduledDateTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ScheduledDateType.ScheduledDateTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getScheduledDateTypeScheme()).ifPresent(builder::setScheduledDateTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ScheduledDateType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(scheduledDateTypeScheme, _that.getScheduledDateTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (scheduledDateTypeScheme != null ? scheduledDateTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ScheduledDateType {" +
				"value=" + this.value + ", " +
				"scheduledDateTypeScheme=" + this.scheduledDateTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ScheduledDateType  ***********************/
	class ScheduledDateTypeBuilderImpl implements ScheduledDateType.ScheduledDateTypeBuilder {
	
		protected String value;
		protected String scheduledDateTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("scheduledDateTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scheduledDateTypeScheme")
		public String getScheduledDateTypeScheme() {
			return scheduledDateTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("scheduledDateTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scheduledDateTypeScheme")
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder setScheduledDateTypeScheme(String _scheduledDateTypeScheme) {
			this.scheduledDateTypeScheme = _scheduledDateTypeScheme == null ? null : _scheduledDateTypeScheme;
			return this;
		}
		
		@Override
		public ScheduledDateType build() {
			return new ScheduledDateType.ScheduledDateTypeImpl(this);
		}
		
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getScheduledDateTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ScheduledDateType.ScheduledDateTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ScheduledDateType.ScheduledDateTypeBuilder o = (ScheduledDateType.ScheduledDateTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getScheduledDateTypeScheme(), o.getScheduledDateTypeScheme(), this::setScheduledDateTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ScheduledDateType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(scheduledDateTypeScheme, _that.getScheduledDateTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (scheduledDateTypeScheme != null ? scheduledDateTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ScheduledDateTypeBuilder {" +
				"value=" + this.value + ", " +
				"scheduledDateTypeScheme=" + this.scheduledDateTypeScheme +
			'}';
		}
	}
}
