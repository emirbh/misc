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
import fpml.consolidated.com.meta.WeatherIndexDataMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="WeatherIndexData", builder=WeatherIndexData.WeatherIndexDataBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherIndexData", model="fpml", builder=WeatherIndexData.WeatherIndexDataBuilderImpl.class, version="2.1.1")
public interface WeatherIndexData extends RosettaModelObject {

	WeatherIndexDataMeta metaData = new WeatherIndexDataMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference level is the number of degree-days (in the case of HDD and CDD) or inches/millimeters (in the case of CPD) on which the differential is calculated. In the case of HDD it is the number of degree-days below this reference level. In the case of CDD it is the number of degree days above this reference level. In the case of CPD it is number of inches/millimeters above this reference level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference level is the number of degree-days (in the case of HDD and CDD) or inches/millimeters (in the case of CPD) on which the differential is calculated. In the case of HDD it is the number of degree-days below this reference level. In the case of CDD it is the number of degree days above this reference level. In the case of CPD it is number of inches/millimeters above this reference level.
	 *
	 */
	ReferenceLevel getReferenceLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The provider of either temperature data or precipitation data specified by the parties in the related Confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The provider of either temperature data or precipitation data specified by the parties in the related Confirmation.
	 *
	 */
	DataProvider getDataProvider();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If specified by the parties to apply in the related Confirmation, Final Edited Data means that the parties will have recourse to Primary Disruption Fallbacks even if relevant data is available from the Data Provider, so long as such data is not published in its final edited form. Otherwise the parties will have recourse to Primary Disruption Fallbacks only if relevant data is unavailable from the Data Provider on a relevant day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If specified by the parties to apply in the related Confirmation, Final Edited Data means that the parties will have recourse to Primary Disruption Fallbacks even if relevant data is available from the Data Provider, so long as such data is not published in its final edited form. Otherwise the parties will have recourse to Primary Disruption Fallbacks only if relevant data is unavailable from the Data Provider on a relevant day.
	 *
	 */
	Boolean getFinalEditedData();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The source or sources of weather index data specified by the parties in the related Confirmation. Examples include: AU-CBM (the Commonwealth Bureau of Meteorology in Australia) and CM-SMI (the Swiss Meteorological Institute).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The source or sources of weather index data specified by the parties in the related Confirmation. Examples include: AU-CBM (the Commonwealth Bureau of Meteorology in Australia) and CM-SMI (the Swiss Meteorological Institute).
	 *
	 */
	WeatherStation getWeatherStation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If weather index data is not available for the weather station specified by the parties in the related Confirmation, the first alternative Weather Index Station.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If weather index data is not available for the weather station specified by the parties in the related Confirmation, the first alternative Weather Index Station.
	 *
	 */
	WeatherStation getWeatherStationFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If weather index data is neither available for the weather station specified by the parties in the related Confirmation nor the first alternative Weather Index Station, the second alternative Weather Index Station.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If weather index data is neither available for the weather station specified by the parties in the related Confirmation nor the first alternative Weather Index Station, the second alternative Weather Index Station.
	 *
	 */
	WeatherStation getWeatherStationSecondFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A provider of either temperature data or precipitation data specified by the parties in the related Confirmation. If the parties fail to specify an Alternative Data Provider, the "Fallback Data" Disruption Fallback will not apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A provider of either temperature data or precipitation data specified by the parties in the related Confirmation. If the parties fail to specify an Alternative Data Provider, the "Fallback Data" Disruption Fallback will not apply.
	 *
	 */
	Boolean getAlternativeDataProvider();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the parties specify "Not Applicable", the "Synoptic Data" Disruption Fallback will not apply. Synoptic Data means that maximum and/or minimum temperature or daily precipitation at the location for the Missing Data Day will be the maxium and/or minimum temperature or daily precipitation for that day at the Location (Weather Index Station) which has not been subject to ultimate quality control, integrity or verification process.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the parties specify "Not Applicable", the "Synoptic Data" Disruption Fallback will not apply. Synoptic Data means that maximum and/or minimum temperature or daily precipitation at the location for the Missing Data Day will be the maxium and/or minimum temperature or daily precipitation for that day at the Location (Weather Index Station) which has not been subject to ultimate quality control, integrity or verification process.
	 *
	 */
	Boolean getSynopticDataFallback();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Weather Index Station from which data with which to apply the "Adjustement to Fallback Station Data" terms. See Section 11.20 of the 2005 ISDA Commodity Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Weather Index Station from which data with which to apply the "Adjustement to Fallback Station Data" terms. See Section 11.20 of the 2005 ISDA Commodity Definitions.
	 *
	 */
	Boolean getAdjustmentToFallbackWeatherStation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A list of actions available to the parties should a Primary Disruption Event occur. A Primary Disruption Event means if maximum or minimum temperature or precipitation data for a Missing Data Day is required to determine a Payment Amount then the maximum and/or minimum temperature or the daily precipitation for that day will be determined in accordance with the first applicable Primary Disruption Fallback.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of actions available to the parties should a Primary Disruption Event occur. A Primary Disruption Event means if maximum or minimum temperature or precipitation data for a Missing Data Day is required to determine a Payment Amount then the maximum and/or minimum temperature or the daily precipitation for that day will be determined in accordance with the first applicable Primary Disruption Fallback.
	 *
	 */
	DisruptionFallback getPrimaryDisruptionFallbacks();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A list of actions available to the parties should a Secondary Disruption Event occur. A Primary Disruption Event means if maximum or minimum temperature or precipitation data for a Missing Data Day is required to determine a Payment Amount then the maximum and/or minimum temperature or the daily precipitation for that day will be determined in accordance with the first applicable Secondary Disruption Fallback.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of actions available to the parties should a Secondary Disruption Event occur. A Primary Disruption Event means if maximum or minimum temperature or precipitation data for a Missing Data Day is required to determine a Payment Amount then the maximum and/or minimum temperature or the daily precipitation for that day will be determined in accordance with the first applicable Secondary Disruption Fallback.
	 *
	 */
	DisruptionFallback getSecondaryDisruptionFallbacks();

	/*********************** Build Methods  ***********************/
	WeatherIndexData build();
	
	WeatherIndexData.WeatherIndexDataBuilder toBuilder();
	
	static WeatherIndexData.WeatherIndexDataBuilder builder() {
		return new WeatherIndexData.WeatherIndexDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherIndexData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherIndexData> getType() {
		return WeatherIndexData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("referenceLevel"), processor, ReferenceLevel.class, getReferenceLevel());
		processRosetta(path.newSubPath("dataProvider"), processor, DataProvider.class, getDataProvider());
		processor.processBasic(path.newSubPath("finalEditedData"), Boolean.class, getFinalEditedData(), this);
		processRosetta(path.newSubPath("weatherStation"), processor, WeatherStation.class, getWeatherStation());
		processRosetta(path.newSubPath("weatherStationFallback"), processor, WeatherStation.class, getWeatherStationFallback());
		processRosetta(path.newSubPath("weatherStationSecondFallback"), processor, WeatherStation.class, getWeatherStationSecondFallback());
		processor.processBasic(path.newSubPath("alternativeDataProvider"), Boolean.class, getAlternativeDataProvider(), this);
		processor.processBasic(path.newSubPath("synopticDataFallback"), Boolean.class, getSynopticDataFallback(), this);
		processor.processBasic(path.newSubPath("adjustmentToFallbackWeatherStation"), Boolean.class, getAdjustmentToFallbackWeatherStation(), this);
		processRosetta(path.newSubPath("primaryDisruptionFallbacks"), processor, DisruptionFallback.class, getPrimaryDisruptionFallbacks());
		processRosetta(path.newSubPath("secondaryDisruptionFallbacks"), processor, DisruptionFallback.class, getSecondaryDisruptionFallbacks());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherIndexDataBuilder extends WeatherIndexData, RosettaModelObjectBuilder {
		ReferenceLevel.ReferenceLevelBuilder getOrCreateReferenceLevel();
		@Override
		ReferenceLevel.ReferenceLevelBuilder getReferenceLevel();
		DataProvider.DataProviderBuilder getOrCreateDataProvider();
		@Override
		DataProvider.DataProviderBuilder getDataProvider();
		WeatherStation.WeatherStationBuilder getOrCreateWeatherStation();
		@Override
		WeatherStation.WeatherStationBuilder getWeatherStation();
		WeatherStation.WeatherStationBuilder getOrCreateWeatherStationFallback();
		@Override
		WeatherStation.WeatherStationBuilder getWeatherStationFallback();
		WeatherStation.WeatherStationBuilder getOrCreateWeatherStationSecondFallback();
		@Override
		WeatherStation.WeatherStationBuilder getWeatherStationSecondFallback();
		DisruptionFallback.DisruptionFallbackBuilder getOrCreatePrimaryDisruptionFallbacks();
		@Override
		DisruptionFallback.DisruptionFallbackBuilder getPrimaryDisruptionFallbacks();
		DisruptionFallback.DisruptionFallbackBuilder getOrCreateSecondaryDisruptionFallbacks();
		@Override
		DisruptionFallback.DisruptionFallbackBuilder getSecondaryDisruptionFallbacks();
		WeatherIndexData.WeatherIndexDataBuilder setReferenceLevel(ReferenceLevel referenceLevel);
		WeatherIndexData.WeatherIndexDataBuilder setDataProvider(DataProvider dataProvider);
		WeatherIndexData.WeatherIndexDataBuilder setFinalEditedData(Boolean finalEditedData);
		WeatherIndexData.WeatherIndexDataBuilder setWeatherStation(WeatherStation weatherStation);
		WeatherIndexData.WeatherIndexDataBuilder setWeatherStationFallback(WeatherStation weatherStationFallback);
		WeatherIndexData.WeatherIndexDataBuilder setWeatherStationSecondFallback(WeatherStation weatherStationSecondFallback);
		WeatherIndexData.WeatherIndexDataBuilder setAlternativeDataProvider(Boolean alternativeDataProvider);
		WeatherIndexData.WeatherIndexDataBuilder setSynopticDataFallback(Boolean synopticDataFallback);
		WeatherIndexData.WeatherIndexDataBuilder setAdjustmentToFallbackWeatherStation(Boolean adjustmentToFallbackWeatherStation);
		WeatherIndexData.WeatherIndexDataBuilder setPrimaryDisruptionFallbacks(DisruptionFallback primaryDisruptionFallbacks);
		WeatherIndexData.WeatherIndexDataBuilder setSecondaryDisruptionFallbacks(DisruptionFallback secondaryDisruptionFallbacks);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("referenceLevel"), processor, ReferenceLevel.ReferenceLevelBuilder.class, getReferenceLevel());
			processRosetta(path.newSubPath("dataProvider"), processor, DataProvider.DataProviderBuilder.class, getDataProvider());
			processor.processBasic(path.newSubPath("finalEditedData"), Boolean.class, getFinalEditedData(), this);
			processRosetta(path.newSubPath("weatherStation"), processor, WeatherStation.WeatherStationBuilder.class, getWeatherStation());
			processRosetta(path.newSubPath("weatherStationFallback"), processor, WeatherStation.WeatherStationBuilder.class, getWeatherStationFallback());
			processRosetta(path.newSubPath("weatherStationSecondFallback"), processor, WeatherStation.WeatherStationBuilder.class, getWeatherStationSecondFallback());
			processor.processBasic(path.newSubPath("alternativeDataProvider"), Boolean.class, getAlternativeDataProvider(), this);
			processor.processBasic(path.newSubPath("synopticDataFallback"), Boolean.class, getSynopticDataFallback(), this);
			processor.processBasic(path.newSubPath("adjustmentToFallbackWeatherStation"), Boolean.class, getAdjustmentToFallbackWeatherStation(), this);
			processRosetta(path.newSubPath("primaryDisruptionFallbacks"), processor, DisruptionFallback.DisruptionFallbackBuilder.class, getPrimaryDisruptionFallbacks());
			processRosetta(path.newSubPath("secondaryDisruptionFallbacks"), processor, DisruptionFallback.DisruptionFallbackBuilder.class, getSecondaryDisruptionFallbacks());
		}
		

		WeatherIndexData.WeatherIndexDataBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherIndexData  ***********************/
	class WeatherIndexDataImpl implements WeatherIndexData {
		private final ReferenceLevel referenceLevel;
		private final DataProvider dataProvider;
		private final Boolean finalEditedData;
		private final WeatherStation weatherStation;
		private final WeatherStation weatherStationFallback;
		private final WeatherStation weatherStationSecondFallback;
		private final Boolean alternativeDataProvider;
		private final Boolean synopticDataFallback;
		private final Boolean adjustmentToFallbackWeatherStation;
		private final DisruptionFallback primaryDisruptionFallbacks;
		private final DisruptionFallback secondaryDisruptionFallbacks;
		
		protected WeatherIndexDataImpl(WeatherIndexData.WeatherIndexDataBuilder builder) {
			this.referenceLevel = ofNullable(builder.getReferenceLevel()).map(f->f.build()).orElse(null);
			this.dataProvider = ofNullable(builder.getDataProvider()).map(f->f.build()).orElse(null);
			this.finalEditedData = builder.getFinalEditedData();
			this.weatherStation = ofNullable(builder.getWeatherStation()).map(f->f.build()).orElse(null);
			this.weatherStationFallback = ofNullable(builder.getWeatherStationFallback()).map(f->f.build()).orElse(null);
			this.weatherStationSecondFallback = ofNullable(builder.getWeatherStationSecondFallback()).map(f->f.build()).orElse(null);
			this.alternativeDataProvider = builder.getAlternativeDataProvider();
			this.synopticDataFallback = builder.getSynopticDataFallback();
			this.adjustmentToFallbackWeatherStation = builder.getAdjustmentToFallbackWeatherStation();
			this.primaryDisruptionFallbacks = ofNullable(builder.getPrimaryDisruptionFallbacks()).map(f->f.build()).orElse(null);
			this.secondaryDisruptionFallbacks = ofNullable(builder.getSecondaryDisruptionFallbacks()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceLevel")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("referenceLevel")
		public ReferenceLevel getReferenceLevel() {
			return referenceLevel;
		}
		
		@Override
		@RosettaAttribute("dataProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataProvider")
		public DataProvider getDataProvider() {
			return dataProvider;
		}
		
		@Override
		@RosettaAttribute("finalEditedData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalEditedData")
		public Boolean getFinalEditedData() {
			return finalEditedData;
		}
		
		@Override
		@RosettaAttribute("weatherStation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("weatherStation")
		public WeatherStation getWeatherStation() {
			return weatherStation;
		}
		
		@Override
		@RosettaAttribute("weatherStationFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationFallback")
		public WeatherStation getWeatherStationFallback() {
			return weatherStationFallback;
		}
		
		@Override
		@RosettaAttribute("weatherStationSecondFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationSecondFallback")
		public WeatherStation getWeatherStationSecondFallback() {
			return weatherStationSecondFallback;
		}
		
		@Override
		@RosettaAttribute("alternativeDataProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("alternativeDataProvider")
		public Boolean getAlternativeDataProvider() {
			return alternativeDataProvider;
		}
		
		@Override
		@RosettaAttribute("synopticDataFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("synopticDataFallback")
		public Boolean getSynopticDataFallback() {
			return synopticDataFallback;
		}
		
		@Override
		@RosettaAttribute("adjustmentToFallbackWeatherStation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustmentToFallbackWeatherStation")
		public Boolean getAdjustmentToFallbackWeatherStation() {
			return adjustmentToFallbackWeatherStation;
		}
		
		@Override
		@RosettaAttribute("primaryDisruptionFallbacks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryDisruptionFallbacks")
		public DisruptionFallback getPrimaryDisruptionFallbacks() {
			return primaryDisruptionFallbacks;
		}
		
		@Override
		@RosettaAttribute("secondaryDisruptionFallbacks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryDisruptionFallbacks")
		public DisruptionFallback getSecondaryDisruptionFallbacks() {
			return secondaryDisruptionFallbacks;
		}
		
		@Override
		public WeatherIndexData build() {
			return this;
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder toBuilder() {
			WeatherIndexData.WeatherIndexDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherIndexData.WeatherIndexDataBuilder builder) {
			ofNullable(getReferenceLevel()).ifPresent(builder::setReferenceLevel);
			ofNullable(getDataProvider()).ifPresent(builder::setDataProvider);
			ofNullable(getFinalEditedData()).ifPresent(builder::setFinalEditedData);
			ofNullable(getWeatherStation()).ifPresent(builder::setWeatherStation);
			ofNullable(getWeatherStationFallback()).ifPresent(builder::setWeatherStationFallback);
			ofNullable(getWeatherStationSecondFallback()).ifPresent(builder::setWeatherStationSecondFallback);
			ofNullable(getAlternativeDataProvider()).ifPresent(builder::setAlternativeDataProvider);
			ofNullable(getSynopticDataFallback()).ifPresent(builder::setSynopticDataFallback);
			ofNullable(getAdjustmentToFallbackWeatherStation()).ifPresent(builder::setAdjustmentToFallbackWeatherStation);
			ofNullable(getPrimaryDisruptionFallbacks()).ifPresent(builder::setPrimaryDisruptionFallbacks);
			ofNullable(getSecondaryDisruptionFallbacks()).ifPresent(builder::setSecondaryDisruptionFallbacks);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndexData _that = getType().cast(o);
		
			if (!Objects.equals(referenceLevel, _that.getReferenceLevel())) return false;
			if (!Objects.equals(dataProvider, _that.getDataProvider())) return false;
			if (!Objects.equals(finalEditedData, _that.getFinalEditedData())) return false;
			if (!Objects.equals(weatherStation, _that.getWeatherStation())) return false;
			if (!Objects.equals(weatherStationFallback, _that.getWeatherStationFallback())) return false;
			if (!Objects.equals(weatherStationSecondFallback, _that.getWeatherStationSecondFallback())) return false;
			if (!Objects.equals(alternativeDataProvider, _that.getAlternativeDataProvider())) return false;
			if (!Objects.equals(synopticDataFallback, _that.getSynopticDataFallback())) return false;
			if (!Objects.equals(adjustmentToFallbackWeatherStation, _that.getAdjustmentToFallbackWeatherStation())) return false;
			if (!Objects.equals(primaryDisruptionFallbacks, _that.getPrimaryDisruptionFallbacks())) return false;
			if (!Objects.equals(secondaryDisruptionFallbacks, _that.getSecondaryDisruptionFallbacks())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceLevel != null ? referenceLevel.hashCode() : 0);
			_result = 31 * _result + (dataProvider != null ? dataProvider.hashCode() : 0);
			_result = 31 * _result + (finalEditedData != null ? finalEditedData.hashCode() : 0);
			_result = 31 * _result + (weatherStation != null ? weatherStation.hashCode() : 0);
			_result = 31 * _result + (weatherStationFallback != null ? weatherStationFallback.hashCode() : 0);
			_result = 31 * _result + (weatherStationSecondFallback != null ? weatherStationSecondFallback.hashCode() : 0);
			_result = 31 * _result + (alternativeDataProvider != null ? alternativeDataProvider.hashCode() : 0);
			_result = 31 * _result + (synopticDataFallback != null ? synopticDataFallback.hashCode() : 0);
			_result = 31 * _result + (adjustmentToFallbackWeatherStation != null ? adjustmentToFallbackWeatherStation.hashCode() : 0);
			_result = 31 * _result + (primaryDisruptionFallbacks != null ? primaryDisruptionFallbacks.hashCode() : 0);
			_result = 31 * _result + (secondaryDisruptionFallbacks != null ? secondaryDisruptionFallbacks.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndexData {" +
				"referenceLevel=" + this.referenceLevel + ", " +
				"dataProvider=" + this.dataProvider + ", " +
				"finalEditedData=" + this.finalEditedData + ", " +
				"weatherStation=" + this.weatherStation + ", " +
				"weatherStationFallback=" + this.weatherStationFallback + ", " +
				"weatherStationSecondFallback=" + this.weatherStationSecondFallback + ", " +
				"alternativeDataProvider=" + this.alternativeDataProvider + ", " +
				"synopticDataFallback=" + this.synopticDataFallback + ", " +
				"adjustmentToFallbackWeatherStation=" + this.adjustmentToFallbackWeatherStation + ", " +
				"primaryDisruptionFallbacks=" + this.primaryDisruptionFallbacks + ", " +
				"secondaryDisruptionFallbacks=" + this.secondaryDisruptionFallbacks +
			'}';
		}
	}

	/*********************** Builder Implementation of WeatherIndexData  ***********************/
	class WeatherIndexDataBuilderImpl implements WeatherIndexData.WeatherIndexDataBuilder {
	
		protected ReferenceLevel.ReferenceLevelBuilder referenceLevel;
		protected DataProvider.DataProviderBuilder dataProvider;
		protected Boolean finalEditedData;
		protected WeatherStation.WeatherStationBuilder weatherStation;
		protected WeatherStation.WeatherStationBuilder weatherStationFallback;
		protected WeatherStation.WeatherStationBuilder weatherStationSecondFallback;
		protected Boolean alternativeDataProvider;
		protected Boolean synopticDataFallback;
		protected Boolean adjustmentToFallbackWeatherStation;
		protected DisruptionFallback.DisruptionFallbackBuilder primaryDisruptionFallbacks;
		protected DisruptionFallback.DisruptionFallbackBuilder secondaryDisruptionFallbacks;
		
		@Override
		@RosettaAttribute("referenceLevel")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("referenceLevel")
		public ReferenceLevel.ReferenceLevelBuilder getReferenceLevel() {
			return referenceLevel;
		}
		
		@Override
		public ReferenceLevel.ReferenceLevelBuilder getOrCreateReferenceLevel() {
			ReferenceLevel.ReferenceLevelBuilder result;
			if (referenceLevel!=null) {
				result = referenceLevel;
			}
			else {
				result = referenceLevel = ReferenceLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dataProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataProvider")
		public DataProvider.DataProviderBuilder getDataProvider() {
			return dataProvider;
		}
		
		@Override
		public DataProvider.DataProviderBuilder getOrCreateDataProvider() {
			DataProvider.DataProviderBuilder result;
			if (dataProvider!=null) {
				result = dataProvider;
			}
			else {
				result = dataProvider = DataProvider.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalEditedData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalEditedData")
		public Boolean getFinalEditedData() {
			return finalEditedData;
		}
		
		@Override
		@RosettaAttribute("weatherStation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("weatherStation")
		public WeatherStation.WeatherStationBuilder getWeatherStation() {
			return weatherStation;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder getOrCreateWeatherStation() {
			WeatherStation.WeatherStationBuilder result;
			if (weatherStation!=null) {
				result = weatherStation;
			}
			else {
				result = weatherStation = WeatherStation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationFallback")
		public WeatherStation.WeatherStationBuilder getWeatherStationFallback() {
			return weatherStationFallback;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder getOrCreateWeatherStationFallback() {
			WeatherStation.WeatherStationBuilder result;
			if (weatherStationFallback!=null) {
				result = weatherStationFallback;
			}
			else {
				result = weatherStationFallback = WeatherStation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherStationSecondFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherStationSecondFallback")
		public WeatherStation.WeatherStationBuilder getWeatherStationSecondFallback() {
			return weatherStationSecondFallback;
		}
		
		@Override
		public WeatherStation.WeatherStationBuilder getOrCreateWeatherStationSecondFallback() {
			WeatherStation.WeatherStationBuilder result;
			if (weatherStationSecondFallback!=null) {
				result = weatherStationSecondFallback;
			}
			else {
				result = weatherStationSecondFallback = WeatherStation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("alternativeDataProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("alternativeDataProvider")
		public Boolean getAlternativeDataProvider() {
			return alternativeDataProvider;
		}
		
		@Override
		@RosettaAttribute("synopticDataFallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("synopticDataFallback")
		public Boolean getSynopticDataFallback() {
			return synopticDataFallback;
		}
		
		@Override
		@RosettaAttribute("adjustmentToFallbackWeatherStation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustmentToFallbackWeatherStation")
		public Boolean getAdjustmentToFallbackWeatherStation() {
			return adjustmentToFallbackWeatherStation;
		}
		
		@Override
		@RosettaAttribute("primaryDisruptionFallbacks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryDisruptionFallbacks")
		public DisruptionFallback.DisruptionFallbackBuilder getPrimaryDisruptionFallbacks() {
			return primaryDisruptionFallbacks;
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder getOrCreatePrimaryDisruptionFallbacks() {
			DisruptionFallback.DisruptionFallbackBuilder result;
			if (primaryDisruptionFallbacks!=null) {
				result = primaryDisruptionFallbacks;
			}
			else {
				result = primaryDisruptionFallbacks = DisruptionFallback.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryDisruptionFallbacks")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryDisruptionFallbacks")
		public DisruptionFallback.DisruptionFallbackBuilder getSecondaryDisruptionFallbacks() {
			return secondaryDisruptionFallbacks;
		}
		
		@Override
		public DisruptionFallback.DisruptionFallbackBuilder getOrCreateSecondaryDisruptionFallbacks() {
			DisruptionFallback.DisruptionFallbackBuilder result;
			if (secondaryDisruptionFallbacks!=null) {
				result = secondaryDisruptionFallbacks;
			}
			else {
				result = secondaryDisruptionFallbacks = DisruptionFallback.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("referenceLevel")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("referenceLevel")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setReferenceLevel(ReferenceLevel _referenceLevel) {
			this.referenceLevel = _referenceLevel == null ? null : _referenceLevel.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dataProvider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dataProvider")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setDataProvider(DataProvider _dataProvider) {
			this.dataProvider = _dataProvider == null ? null : _dataProvider.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalEditedData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalEditedData")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setFinalEditedData(Boolean _finalEditedData) {
			this.finalEditedData = _finalEditedData == null ? null : _finalEditedData;
			return this;
		}
		
		@RosettaAttribute("weatherStation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("weatherStation")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setWeatherStation(WeatherStation _weatherStation) {
			this.weatherStation = _weatherStation == null ? null : _weatherStation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherStationFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationFallback")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setWeatherStationFallback(WeatherStation _weatherStationFallback) {
			this.weatherStationFallback = _weatherStationFallback == null ? null : _weatherStationFallback.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherStationSecondFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherStationSecondFallback")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setWeatherStationSecondFallback(WeatherStation _weatherStationSecondFallback) {
			this.weatherStationSecondFallback = _weatherStationSecondFallback == null ? null : _weatherStationSecondFallback.toBuilder();
			return this;
		}
		
		@RosettaAttribute("alternativeDataProvider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("alternativeDataProvider")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setAlternativeDataProvider(Boolean _alternativeDataProvider) {
			this.alternativeDataProvider = _alternativeDataProvider == null ? null : _alternativeDataProvider;
			return this;
		}
		
		@RosettaAttribute("synopticDataFallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("synopticDataFallback")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setSynopticDataFallback(Boolean _synopticDataFallback) {
			this.synopticDataFallback = _synopticDataFallback == null ? null : _synopticDataFallback;
			return this;
		}
		
		@RosettaAttribute("adjustmentToFallbackWeatherStation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustmentToFallbackWeatherStation")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setAdjustmentToFallbackWeatherStation(Boolean _adjustmentToFallbackWeatherStation) {
			this.adjustmentToFallbackWeatherStation = _adjustmentToFallbackWeatherStation == null ? null : _adjustmentToFallbackWeatherStation;
			return this;
		}
		
		@RosettaAttribute("primaryDisruptionFallbacks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryDisruptionFallbacks")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setPrimaryDisruptionFallbacks(DisruptionFallback _primaryDisruptionFallbacks) {
			this.primaryDisruptionFallbacks = _primaryDisruptionFallbacks == null ? null : _primaryDisruptionFallbacks.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryDisruptionFallbacks")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryDisruptionFallbacks")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder setSecondaryDisruptionFallbacks(DisruptionFallback _secondaryDisruptionFallbacks) {
			this.secondaryDisruptionFallbacks = _secondaryDisruptionFallbacks == null ? null : _secondaryDisruptionFallbacks.toBuilder();
			return this;
		}
		
		@Override
		public WeatherIndexData build() {
			return new WeatherIndexData.WeatherIndexDataImpl(this);
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder prune() {
			if (referenceLevel!=null && !referenceLevel.prune().hasData()) referenceLevel = null;
			if (dataProvider!=null && !dataProvider.prune().hasData()) dataProvider = null;
			if (weatherStation!=null && !weatherStation.prune().hasData()) weatherStation = null;
			if (weatherStationFallback!=null && !weatherStationFallback.prune().hasData()) weatherStationFallback = null;
			if (weatherStationSecondFallback!=null && !weatherStationSecondFallback.prune().hasData()) weatherStationSecondFallback = null;
			if (primaryDisruptionFallbacks!=null && !primaryDisruptionFallbacks.prune().hasData()) primaryDisruptionFallbacks = null;
			if (secondaryDisruptionFallbacks!=null && !secondaryDisruptionFallbacks.prune().hasData()) secondaryDisruptionFallbacks = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReferenceLevel()!=null && getReferenceLevel().hasData()) return true;
			if (getDataProvider()!=null && getDataProvider().hasData()) return true;
			if (getFinalEditedData()!=null) return true;
			if (getWeatherStation()!=null && getWeatherStation().hasData()) return true;
			if (getWeatherStationFallback()!=null && getWeatherStationFallback().hasData()) return true;
			if (getWeatherStationSecondFallback()!=null && getWeatherStationSecondFallback().hasData()) return true;
			if (getAlternativeDataProvider()!=null) return true;
			if (getSynopticDataFallback()!=null) return true;
			if (getAdjustmentToFallbackWeatherStation()!=null) return true;
			if (getPrimaryDisruptionFallbacks()!=null && getPrimaryDisruptionFallbacks().hasData()) return true;
			if (getSecondaryDisruptionFallbacks()!=null && getSecondaryDisruptionFallbacks().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeatherIndexData.WeatherIndexDataBuilder o = (WeatherIndexData.WeatherIndexDataBuilder) other;
			
			merger.mergeRosetta(getReferenceLevel(), o.getReferenceLevel(), this::setReferenceLevel);
			merger.mergeRosetta(getDataProvider(), o.getDataProvider(), this::setDataProvider);
			merger.mergeRosetta(getWeatherStation(), o.getWeatherStation(), this::setWeatherStation);
			merger.mergeRosetta(getWeatherStationFallback(), o.getWeatherStationFallback(), this::setWeatherStationFallback);
			merger.mergeRosetta(getWeatherStationSecondFallback(), o.getWeatherStationSecondFallback(), this::setWeatherStationSecondFallback);
			merger.mergeRosetta(getPrimaryDisruptionFallbacks(), o.getPrimaryDisruptionFallbacks(), this::setPrimaryDisruptionFallbacks);
			merger.mergeRosetta(getSecondaryDisruptionFallbacks(), o.getSecondaryDisruptionFallbacks(), this::setSecondaryDisruptionFallbacks);
			
			merger.mergeBasic(getFinalEditedData(), o.getFinalEditedData(), this::setFinalEditedData);
			merger.mergeBasic(getAlternativeDataProvider(), o.getAlternativeDataProvider(), this::setAlternativeDataProvider);
			merger.mergeBasic(getSynopticDataFallback(), o.getSynopticDataFallback(), this::setSynopticDataFallback);
			merger.mergeBasic(getAdjustmentToFallbackWeatherStation(), o.getAdjustmentToFallbackWeatherStation(), this::setAdjustmentToFallbackWeatherStation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeatherIndexData _that = getType().cast(o);
		
			if (!Objects.equals(referenceLevel, _that.getReferenceLevel())) return false;
			if (!Objects.equals(dataProvider, _that.getDataProvider())) return false;
			if (!Objects.equals(finalEditedData, _that.getFinalEditedData())) return false;
			if (!Objects.equals(weatherStation, _that.getWeatherStation())) return false;
			if (!Objects.equals(weatherStationFallback, _that.getWeatherStationFallback())) return false;
			if (!Objects.equals(weatherStationSecondFallback, _that.getWeatherStationSecondFallback())) return false;
			if (!Objects.equals(alternativeDataProvider, _that.getAlternativeDataProvider())) return false;
			if (!Objects.equals(synopticDataFallback, _that.getSynopticDataFallback())) return false;
			if (!Objects.equals(adjustmentToFallbackWeatherStation, _that.getAdjustmentToFallbackWeatherStation())) return false;
			if (!Objects.equals(primaryDisruptionFallbacks, _that.getPrimaryDisruptionFallbacks())) return false;
			if (!Objects.equals(secondaryDisruptionFallbacks, _that.getSecondaryDisruptionFallbacks())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (referenceLevel != null ? referenceLevel.hashCode() : 0);
			_result = 31 * _result + (dataProvider != null ? dataProvider.hashCode() : 0);
			_result = 31 * _result + (finalEditedData != null ? finalEditedData.hashCode() : 0);
			_result = 31 * _result + (weatherStation != null ? weatherStation.hashCode() : 0);
			_result = 31 * _result + (weatherStationFallback != null ? weatherStationFallback.hashCode() : 0);
			_result = 31 * _result + (weatherStationSecondFallback != null ? weatherStationSecondFallback.hashCode() : 0);
			_result = 31 * _result + (alternativeDataProvider != null ? alternativeDataProvider.hashCode() : 0);
			_result = 31 * _result + (synopticDataFallback != null ? synopticDataFallback.hashCode() : 0);
			_result = 31 * _result + (adjustmentToFallbackWeatherStation != null ? adjustmentToFallbackWeatherStation.hashCode() : 0);
			_result = 31 * _result + (primaryDisruptionFallbacks != null ? primaryDisruptionFallbacks.hashCode() : 0);
			_result = 31 * _result + (secondaryDisruptionFallbacks != null ? secondaryDisruptionFallbacks.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherIndexDataBuilder {" +
				"referenceLevel=" + this.referenceLevel + ", " +
				"dataProvider=" + this.dataProvider + ", " +
				"finalEditedData=" + this.finalEditedData + ", " +
				"weatherStation=" + this.weatherStation + ", " +
				"weatherStationFallback=" + this.weatherStationFallback + ", " +
				"weatherStationSecondFallback=" + this.weatherStationSecondFallback + ", " +
				"alternativeDataProvider=" + this.alternativeDataProvider + ", " +
				"synopticDataFallback=" + this.synopticDataFallback + ", " +
				"adjustmentToFallbackWeatherStation=" + this.adjustmentToFallbackWeatherStation + ", " +
				"primaryDisruptionFallbacks=" + this.primaryDisruptionFallbacks + ", " +
				"secondaryDisruptionFallbacks=" + this.secondaryDisruptionFallbacks +
			'}';
		}
	}
}
