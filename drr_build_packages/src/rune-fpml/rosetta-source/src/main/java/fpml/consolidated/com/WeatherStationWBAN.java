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
import fpml.consolidated.com.meta.WeatherStationWBANMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A code identifying a Weather Station WBAN.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A code identifying a Weather Station WBAN.
 *
 */
@RosettaDataType(value="WeatherStationWBAN", builder=WeatherStationWBAN.WeatherStationWBANBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherStationWBAN", model="fpml", builder=WeatherStationWBAN.WeatherStationWBANBuilderImpl.class, version="2.1.1")
public interface WeatherStationWBAN extends RosettaModelObject {

	WeatherStationWBANMeta metaData = new WeatherStationWBANMeta();

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
	String getWeatherStationWBANScheme();
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
	WeatherStationWBAN build();
	
	WeatherStationWBAN.WeatherStationWBANBuilder toBuilder();
	
	static WeatherStationWBAN.WeatherStationWBANBuilder builder() {
		return new WeatherStationWBAN.WeatherStationWBANBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherStationWBAN> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherStationWBAN> getType() {
		return WeatherStationWBAN.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherStationWBANScheme"), String.class, getWeatherStationWBANScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherStationWBANBuilder extends WeatherStationWBAN, RosettaModelObjectBuilder {
		WeatherStationWBAN.WeatherStationWBANBuilder setValue(String value);
		WeatherStationWBAN.WeatherStationWBANBuilder setWeatherStationWBANScheme(String weatherStationWBANScheme);
		WeatherStationWBAN.WeatherStationWBANBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherStationWBANScheme"), String.class, getWeatherStationWBANScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		WeatherStationWBAN.WeatherStationWBANBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherStationWBAN  ***********************/
	class WeatherStationWBANImpl implements WeatherStationWBAN {
		private final String value;
		private final String weatherStationWBANScheme;
		private final String id;
		
		protected WeatherStationWBANImpl(WeatherStationWBAN.WeatherStationWBANBuilder builder) {
			this.value = builder.getValue();
			this.weatherStationWBANScheme = builder.getWeatherStationWBANScheme();
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
		@RosettaAttribute("weatherStationWBANScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationWBANScheme")
		public String getWeatherStationWBANScheme() {
			return weatherStationWBANScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherStationWBAN build() {
			return this;
		}
		
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder toBuilder() {
			WeatherStationWBAN.WeatherStationWBANBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherStationWBAN.WeatherStationWBANBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherStationWBANScheme()).ifPresent(builder::setWeatherStationWBANScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationWBAN _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationWBANScheme, _that.getWeatherStationWBANScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBANScheme != null ? weatherStationWBANScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationWBAN {" +
				"value=" + this.value + ", " +
				"weatherStationWBANScheme=" + this.weatherStationWBANScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherStationWBAN  ***********************/
	class WeatherStationWBANBuilderImpl implements WeatherStationWBAN.WeatherStationWBANBuilder {
	
		protected String value;
		protected String weatherStationWBANScheme;
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
		@RosettaAttribute("weatherStationWBANScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationWBANScheme")
		public String getWeatherStationWBANScheme() {
			return weatherStationWBANScheme;
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
		public WeatherStationWBAN.WeatherStationWBANBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("weatherStationWBANScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationWBANScheme")
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder setWeatherStationWBANScheme(String _weatherStationWBANScheme) {
			this.weatherStationWBANScheme = _weatherStationWBANScheme == null ? null : _weatherStationWBANScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public WeatherStationWBAN build() {
			return new WeatherStationWBAN.WeatherStationWBANImpl(this);
		}
		
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherStationWBANScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherStationWBAN.WeatherStationWBANBuilder o = (WeatherStationWBAN.WeatherStationWBANBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherStationWBANScheme(), o.getWeatherStationWBANScheme(), this::setWeatherStationWBANScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationWBAN _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationWBANScheme, _that.getWeatherStationWBANScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBANScheme != null ? weatherStationWBANScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationWBANBuilder {" +
				"value=" + this.value + ", " +
				"weatherStationWBANScheme=" + this.weatherStationWBANScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
