package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.com.meta.WeatherStationMeta;
import fpml.consolidated.shared.BusinessCenter;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Weather Station.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Weather Station.
 *
 */
@RosettaDataType(value="WeatherStation", builder=WeatherStation.WeatherStationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherStation", model="fpml", builder=WeatherStation.WeatherStationBuilderImpl.class, version="2.1.1")
public interface WeatherStation extends RosettaModelObject {

	WeatherStationMeta metaData = new WeatherStationMeta();

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
	BusinessCenter getWeatherStationCity();
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
	WeatherStationAirport getWeatherStationAirport();
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
	WeatherStationWBAN getWeatherStationWBAN();
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
	WeatherStationWMO getWeatherStationWMO();

	/*********************** Build Methods  ***********************/
	WeatherStation build();
	
	WeatherStation.WeatherStationBuilder toBuilder();
	
	static WeatherStation.WeatherStationBuilder builder() {
		return new WeatherStation.WeatherStationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherStation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherStation> getType() {
		return WeatherStation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("weatherStationCity"), processor, BusinessCenter.class, getWeatherStationCity());
		processRosetta(path.newSubPath("weatherStationAirport"), processor, WeatherStationAirport.class, getWeatherStationAirport());
		processRosetta(path.newSubPath("weatherStationWBAN"), processor, WeatherStationWBAN.class, getWeatherStationWBAN());
		processRosetta(path.newSubPath("weatherStationWMO"), processor, WeatherStationWMO.class, getWeatherStationWMO());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherStationBuilder extends WeatherStation, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateWeatherStationCity();
		@Override
		BusinessCenter.BusinessCenterBuilder getWeatherStationCity();
		WeatherStationAirport.WeatherStationAirportBuilder getOrCreateWeatherStationAirport();
		@Override
		WeatherStationAirport.WeatherStationAirportBuilder getWeatherStationAirport();
		WeatherStationWBAN.WeatherStationWBANBuilder getOrCreateWeatherStationWBAN();
		@Override
		WeatherStationWBAN.WeatherStationWBANBuilder getWeatherStationWBAN();
		WeatherStationWMO.WeatherStationWMOBuilder getOrCreateWeatherStationWMO();
		@Override
		WeatherStationWMO.WeatherStationWMOBuilder getWeatherStationWMO();
		WeatherStation.WeatherStationBuilder setWeatherStationCity(BusinessCenter weatherStationCity);
		WeatherStation.WeatherStationBuilder setWeatherStationAirport(WeatherStationAirport weatherStationAirport);
		WeatherStation.WeatherStationBuilder setWeatherStationWBAN(WeatherStationWBAN weatherStationWBAN);
		WeatherStation.WeatherStationBuilder setWeatherStationWMO(WeatherStationWMO weatherStationWMO);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("weatherStationCity"), processor, BusinessCenter.BusinessCenterBuilder.class, getWeatherStationCity());
			processRosetta(path.newSubPath("weatherStationAirport"), processor, WeatherStationAirport.WeatherStationAirportBuilder.class, getWeatherStationAirport());
			processRosetta(path.newSubPath("weatherStationWBAN"), processor, WeatherStationWBAN.WeatherStationWBANBuilder.class, getWeatherStationWBAN());
			processRosetta(path.newSubPath("weatherStationWMO"), processor, WeatherStationWMO.WeatherStationWMOBuilder.class, getWeatherStationWMO());
		}
		

		WeatherStation.WeatherStationBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherStation  ***********************/
	class WeatherStationImpl implements WeatherStation {
		private final BusinessCenter weatherStationCity;
		private final WeatherStationAirport weatherStationAirport;
		private final WeatherStationWBAN weatherStationWBAN;
		private final WeatherStationWMO weatherStationWMO;
		
		protected WeatherStationImpl(WeatherStation.WeatherStationBuilder builder) {
			this.weatherStationCity = ofNullable(builder.getWeatherStationCity()).map(f->f.build()).orElse(null);
			this.weatherStationAirport = ofNullable(builder.getWeatherStationAirport()).map(f->f.build()).orElse(null);
			this.weatherStationWBAN = ofNullable(builder.getWeatherStationWBAN()).map(f->f.build()).orElse(null);
			this.weatherStationWMO = ofNullable(builder.getWeatherStationWMO()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("weatherStationCity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationCity")
		public BusinessCenter getWeatherStationCity() {
			return weatherStationCity;
		}
		
		@Override
		@RosettaAttribute("weatherStationAirport")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationAirport")
		public WeatherStationAirport getWeatherStationAirport() {
			return weatherStationAirport;
		}
		
		@Override
		@RosettaAttribute("weatherStationWBAN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationWBAN")
		public WeatherStationWBAN getWeatherStationWBAN() {
			return weatherStationWBAN;
		}
		
		@Override
		@RosettaAttribute("weatherStationWMO")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationWMO")
		public WeatherStationWMO getWeatherStationWMO() {
			return weatherStationWMO;
		}
		
		@Override
		public WeatherStation build() {
			return this;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder toBuilder() {
			WeatherStation.WeatherStationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherStation.WeatherStationBuilder builder) {
			ofNullable(getWeatherStationCity()).ifPresent(builder::setWeatherStationCity);
			ofNullable(getWeatherStationAirport()).ifPresent(builder::setWeatherStationAirport);
			ofNullable(getWeatherStationWBAN()).ifPresent(builder::setWeatherStationWBAN);
			ofNullable(getWeatherStationWMO()).ifPresent(builder::setWeatherStationWMO);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStation _that = getType().cast(o);
		
			if (!Objects.equals(weatherStationCity, _that.getWeatherStationCity())) return false;
			if (!Objects.equals(weatherStationAirport, _that.getWeatherStationAirport())) return false;
			if (!Objects.equals(weatherStationWBAN, _that.getWeatherStationWBAN())) return false;
			if (!Objects.equals(weatherStationWMO, _that.getWeatherStationWMO())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weatherStationCity != null ? weatherStationCity.hashCode() : 0);
			_result = 31 * _result + (weatherStationAirport != null ? weatherStationAirport.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBAN != null ? weatherStationWBAN.hashCode() : 0);
			_result = 31 * _result + (weatherStationWMO != null ? weatherStationWMO.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStation {" +
				"weatherStationCity=" + this.weatherStationCity + ", " +
				"weatherStationAirport=" + this.weatherStationAirport + ", " +
				"weatherStationWBAN=" + this.weatherStationWBAN + ", " +
				"weatherStationWMO=" + this.weatherStationWMO +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherStation  ***********************/
	class WeatherStationBuilderImpl implements WeatherStation.WeatherStationBuilder {
	
		protected BusinessCenter.BusinessCenterBuilder weatherStationCity;
		protected WeatherStationAirport.WeatherStationAirportBuilder weatherStationAirport;
		protected WeatherStationWBAN.WeatherStationWBANBuilder weatherStationWBAN;
		protected WeatherStationWMO.WeatherStationWMOBuilder weatherStationWMO;
		
		@Override
		@RosettaAttribute("weatherStationCity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationCity")
		public BusinessCenter.BusinessCenterBuilder getWeatherStationCity() {
			return weatherStationCity;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateWeatherStationCity() {
			BusinessCenter.BusinessCenterBuilder result;
			if (weatherStationCity!=null) {
				result = weatherStationCity;
			}
			else {
				result = weatherStationCity = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationAirport")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationAirport")
		public WeatherStationAirport.WeatherStationAirportBuilder getWeatherStationAirport() {
			return weatherStationAirport;
		}
		
		@Override
		public WeatherStationAirport.WeatherStationAirportBuilder getOrCreateWeatherStationAirport() {
			WeatherStationAirport.WeatherStationAirportBuilder result;
			if (weatherStationAirport!=null) {
				result = weatherStationAirport;
			}
			else {
				result = weatherStationAirport = WeatherStationAirport.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationWBAN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationWBAN")
		public WeatherStationWBAN.WeatherStationWBANBuilder getWeatherStationWBAN() {
			return weatherStationWBAN;
		}
		
		@Override
		public WeatherStationWBAN.WeatherStationWBANBuilder getOrCreateWeatherStationWBAN() {
			WeatherStationWBAN.WeatherStationWBANBuilder result;
			if (weatherStationWBAN!=null) {
				result = weatherStationWBAN;
			}
			else {
				result = weatherStationWBAN = WeatherStationWBAN.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationWMO")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationWMO")
		public WeatherStationWMO.WeatherStationWMOBuilder getWeatherStationWMO() {
			return weatherStationWMO;
		}
		
		@Override
		public WeatherStationWMO.WeatherStationWMOBuilder getOrCreateWeatherStationWMO() {
			WeatherStationWMO.WeatherStationWMOBuilder result;
			if (weatherStationWMO!=null) {
				result = weatherStationWMO;
			}
			else {
				result = weatherStationWMO = WeatherStationWMO.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("weatherStationCity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationCity")
		@Override
		public WeatherStation.WeatherStationBuilder setWeatherStationCity(BusinessCenter _weatherStationCity) {
			this.weatherStationCity = _weatherStationCity == null ? null : _weatherStationCity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherStationAirport")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationAirport")
		@Override
		public WeatherStation.WeatherStationBuilder setWeatherStationAirport(WeatherStationAirport _weatherStationAirport) {
			this.weatherStationAirport = _weatherStationAirport == null ? null : _weatherStationAirport.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherStationWBAN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationWBAN")
		@Override
		public WeatherStation.WeatherStationBuilder setWeatherStationWBAN(WeatherStationWBAN _weatherStationWBAN) {
			this.weatherStationWBAN = _weatherStationWBAN == null ? null : _weatherStationWBAN.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherStationWMO")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationWMO")
		@Override
		public WeatherStation.WeatherStationBuilder setWeatherStationWMO(WeatherStationWMO _weatherStationWMO) {
			this.weatherStationWMO = _weatherStationWMO == null ? null : _weatherStationWMO.toBuilder();
			return this;
		}
		
		@Override
		public WeatherStation build() {
			return new WeatherStation.WeatherStationImpl(this);
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStation.WeatherStationBuilder prune() {
			if (weatherStationCity!=null && !weatherStationCity.prune().hasData()) weatherStationCity = null;
			if (weatherStationAirport!=null && !weatherStationAirport.prune().hasData()) weatherStationAirport = null;
			if (weatherStationWBAN!=null && !weatherStationWBAN.prune().hasData()) weatherStationWBAN = null;
			if (weatherStationWMO!=null && !weatherStationWMO.prune().hasData()) weatherStationWMO = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWeatherStationCity()!=null && getWeatherStationCity().hasData()) return true;
			if (getWeatherStationAirport()!=null && getWeatherStationAirport().hasData()) return true;
			if (getWeatherStationWBAN()!=null && getWeatherStationWBAN().hasData()) return true;
			if (getWeatherStationWMO()!=null && getWeatherStationWMO().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherStation.WeatherStationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherStation.WeatherStationBuilder o = (WeatherStation.WeatherStationBuilder) other;
			
			merger.mergeRosetta(getWeatherStationCity(), o.getWeatherStationCity(), this::setWeatherStationCity);
			merger.mergeRosetta(getWeatherStationAirport(), o.getWeatherStationAirport(), this::setWeatherStationAirport);
			merger.mergeRosetta(getWeatherStationWBAN(), o.getWeatherStationWBAN(), this::setWeatherStationWBAN);
			merger.mergeRosetta(getWeatherStationWMO(), o.getWeatherStationWMO(), this::setWeatherStationWMO);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherStation _that = getType().cast(o);
		
			if (!Objects.equals(weatherStationCity, _that.getWeatherStationCity())) return false;
			if (!Objects.equals(weatherStationAirport, _that.getWeatherStationAirport())) return false;
			if (!Objects.equals(weatherStationWBAN, _that.getWeatherStationWBAN())) return false;
			if (!Objects.equals(weatherStationWMO, _that.getWeatherStationWMO())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (weatherStationCity != null ? weatherStationCity.hashCode() : 0);
			_result = 31 * _result + (weatherStationAirport != null ? weatherStationAirport.hashCode() : 0);
			_result = 31 * _result + (weatherStationWBAN != null ? weatherStationWBAN.hashCode() : 0);
			_result = 31 * _result + (weatherStationWMO != null ? weatherStationWMO.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherStationBuilder {" +
				"weatherStationCity=" + this.weatherStationCity + ", " +
				"weatherStationAirport=" + this.weatherStationAirport + ", " +
				"weatherStationWBAN=" + this.weatherStationWBAN + ", " +
				"weatherStationWMO=" + this.weatherStationWMO +
			'}';
		}
	}
}
