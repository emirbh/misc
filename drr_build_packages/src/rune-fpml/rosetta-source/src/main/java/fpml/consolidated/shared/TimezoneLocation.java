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
import fpml.consolidated.shared.meta.TimezoneLocationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A geophraphic location for the purposes of defining a prevailing time according to the tz database.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A geophraphic location for the purposes of defining a prevailing time according to the tz database.
 *
 */
@RosettaDataType(value="TimezoneLocation", builder=TimezoneLocation.TimezoneLocationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TimezoneLocation", model="fpml", builder=TimezoneLocation.TimezoneLocationBuilderImpl.class, version="2.1.1")
public interface TimezoneLocation extends RosettaModelObject {

	TimezoneLocationMeta metaData = new TimezoneLocationMeta();

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
	String getTimezoneLocationScheme();

	/*********************** Build Methods  ***********************/
	TimezoneLocation build();
	
	TimezoneLocation.TimezoneLocationBuilder toBuilder();
	
	static TimezoneLocation.TimezoneLocationBuilder builder() {
		return new TimezoneLocation.TimezoneLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimezoneLocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TimezoneLocation> getType() {
		return TimezoneLocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("timezoneLocationScheme"), String.class, getTimezoneLocationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimezoneLocationBuilder extends TimezoneLocation, RosettaModelObjectBuilder {
		TimezoneLocation.TimezoneLocationBuilder setValue(String value);
		TimezoneLocation.TimezoneLocationBuilder setTimezoneLocationScheme(String timezoneLocationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("timezoneLocationScheme"), String.class, getTimezoneLocationScheme(), this);
		}
		

		TimezoneLocation.TimezoneLocationBuilder prune();
	}

	/*********************** Immutable Implementation of TimezoneLocation  ***********************/
	class TimezoneLocationImpl implements TimezoneLocation {
		private final String value;
		private final String timezoneLocationScheme;
		
		protected TimezoneLocationImpl(TimezoneLocation.TimezoneLocationBuilder builder) {
			this.value = builder.getValue();
			this.timezoneLocationScheme = builder.getTimezoneLocationScheme();
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
		@RosettaAttribute("timezoneLocationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timezoneLocationScheme")
		public String getTimezoneLocationScheme() {
			return timezoneLocationScheme;
		}
		
		@Override
		public TimezoneLocation build() {
			return this;
		}
		
		@Override
		public TimezoneLocation.TimezoneLocationBuilder toBuilder() {
			TimezoneLocation.TimezoneLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimezoneLocation.TimezoneLocationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTimezoneLocationScheme()).ifPresent(builder::setTimezoneLocationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimezoneLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(timezoneLocationScheme, _that.getTimezoneLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (timezoneLocationScheme != null ? timezoneLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimezoneLocation {" +
				"value=" + this.value + ", " +
				"timezoneLocationScheme=" + this.timezoneLocationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TimezoneLocation  ***********************/
	class TimezoneLocationBuilderImpl implements TimezoneLocation.TimezoneLocationBuilder {
	
		protected String value;
		protected String timezoneLocationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("timezoneLocationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timezoneLocationScheme")
		public String getTimezoneLocationScheme() {
			return timezoneLocationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public TimezoneLocation.TimezoneLocationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("timezoneLocationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timezoneLocationScheme")
		@Override
		public TimezoneLocation.TimezoneLocationBuilder setTimezoneLocationScheme(String _timezoneLocationScheme) {
			this.timezoneLocationScheme = _timezoneLocationScheme == null ? null : _timezoneLocationScheme;
			return this;
		}
		
		@Override
		public TimezoneLocation build() {
			return new TimezoneLocation.TimezoneLocationImpl(this);
		}
		
		@Override
		public TimezoneLocation.TimezoneLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimezoneLocation.TimezoneLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTimezoneLocationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimezoneLocation.TimezoneLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimezoneLocation.TimezoneLocationBuilder o = (TimezoneLocation.TimezoneLocationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTimezoneLocationScheme(), o.getTimezoneLocationScheme(), this::setTimezoneLocationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimezoneLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(timezoneLocationScheme, _that.getTimezoneLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (timezoneLocationScheme != null ? timezoneLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimezoneLocationBuilder {" +
				"value=" + this.value + ", " +
				"timezoneLocationScheme=" + this.timezoneLocationScheme +
			'}';
		}
	}
}
