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
import fpml.consolidated.com.meta.WeatherStationAirportMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A code identifying a Weather Station Airport (based on the the IATA standard).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A code identifying a Weather Station Airport (based on the the IATA standard).
 *
 */
@RosettaDataType(value="WeatherStationAirport", builder=WeatherStationAirport.WeatherStationAirportBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherStationAirport", model="fpml", builder=WeatherStationAirport.WeatherStationAirportBuilderImpl.class, version="2.1.1")
public interface WeatherStationAirport extends RosettaModelObject {

	WeatherStationAirportMeta metaData = new WeatherStationAirportMeta();

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
	String getWeatherStationAirportScheme();
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
	WeatherStationAirport build();
	
	WeatherStationAirport.WeatherStationAirportBuilder toBuilder();
	
	static WeatherStationAirport.WeatherStationAirportBuilder builder() {
		return new WeatherStationAirport.WeatherStationAirportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherStationAirport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherStationAirport> getType() {
		return WeatherStationAirport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("weatherStationAirportScheme"), String.class, getWeatherStationAirportScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherStationAirportBuilder extends WeatherStationAirport, RosettaModelObjectBuilder {
		WeatherStationAirport.WeatherStationAirportBuilder setValue(String value);
		WeatherStationAirport.WeatherStationAirportBuilder setWeatherStationAirportScheme(String weatherStationAirportScheme);
		WeatherStationAirport.WeatherStationAirportBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("weatherStationAirportScheme"), String.class, getWeatherStationAirportScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		WeatherStationAirport.WeatherStationAirportBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherStationAirport  ***********************/
	class WeatherStationAirportImpl implements WeatherStationAirport {
		private final String value;
		private final String weatherStationAirportScheme;
		private final String id;
		
		protected WeatherStationAirportImpl(WeatherStationAirport.WeatherStationAirportBuilder builder) {
			this.value = builder.getValue();
			this.weatherStationAirportScheme = builder.getWeatherStationAirportScheme();
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
		@RosettaAttribute("weatherStationAirportScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationAirportScheme")
		public String getWeatherStationAirportScheme() {
			return weatherStationAirportScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public WeatherStationAirport build() {
			return this;
		}
		
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder toBuilder() {
			WeatherStationAirport.WeatherStationAirportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherStationAirport.WeatherStationAirportBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getWeatherStationAirportScheme()).ifPresent(builder::setWeatherStationAirportScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationAirport _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationAirportScheme, _that.getWeatherStationAirportScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationAirportScheme != null ? weatherStationAirportScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationAirport {" +
				"value=" + this.value + ", " +
				"weatherStationAirportScheme=" + this.weatherStationAirportScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherStationAirport  ***********************/
	class WeatherStationAirportBuilderImpl implements WeatherStationAirport.WeatherStationAirportBuilder {
	
		protected String value;
		protected String weatherStationAirportScheme;
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
		@RosettaAttribute("weatherStationAirportScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationAirportScheme")
		public String getWeatherStationAirportScheme() {
			return weatherStationAirportScheme;
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
		public WeatherStationAirport.WeatherStationAirportBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("weatherStationAirportScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationAirportScheme")
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder setWeatherStationAirportScheme(String _weatherStationAirportScheme) {
			this.weatherStationAirportScheme = _weatherStationAirportScheme == null ? null : _weatherStationAirportScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public WeatherStationAirport build() {
			return new WeatherStationAirport.WeatherStationAirportImpl(this);
		}
		
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getWeatherStationAirportScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherStationAirport.WeatherStationAirportBuilder o = (WeatherStationAirport.WeatherStationAirportBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getWeatherStationAirportScheme(), o.getWeatherStationAirportScheme(), this::setWeatherStationAirportScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStationAirport _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(weatherStationAirportScheme, _that.getWeatherStationAirportScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (weatherStationAirportScheme != null ? weatherStationAirportScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationAirportBuilder {" +
				"value=" + this.value + ", " +
				"weatherStationAirportScheme=" + this.weatherStationAirportScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
