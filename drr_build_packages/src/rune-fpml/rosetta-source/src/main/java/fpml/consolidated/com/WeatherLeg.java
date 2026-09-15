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
import fpml.consolidated.com.meta.WeatherLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A weather leg of a Commodity Swap defines Weather Index Swap transactions. Weather Index Swap transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature, precipitation and other weather-related measurements at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Swap transactions result in a cash flow to one of the two counterparties each Calculation Period depending on the relationship between the Settlement Level and the Weather Index Level. A Weather Index swap transaction always consists of a commodity swap element as a parent to two weatherLeg elements.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A weather leg of a Commodity Swap defines Weather Index Swap transactions. Weather Index Swap transactions are OTC derivative transactions which settle financially based on an index calculated from observations of temperature, precipitation and other weather-related measurements at weather stations throughout the world. Sub-Annex C of the 2005 ISDA Commodity Definitions provides definitions and terms for a number of types of weather indices. These indices include: HDD (heating degree days), CDD (cooling degree days), CPD (critical precipitation days). Weather Index Swap transactions result in a cash flow to one of the two counterparties each Calculation Period depending on the relationship between the Settlement Level and the Weather Index Level. A Weather Index swap transaction always consists of a commodity swap element as a parent to two weatherLeg elements.
 *
 */
@RosettaDataType(value="WeatherLeg", builder=WeatherLeg.WeatherLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WeatherLeg", model="fpml", builder=WeatherLeg.WeatherLegBuilderImpl.class, version="2.1.1")
public interface WeatherLeg extends FinancialSwapLeg {

	WeatherLegMeta metaData = new WeatherLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defining the Weather Index Level or Weather Index Strike Level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defining the Weather Index Level or Weather Index Strike Level.
	 *
	 */
	WeatherIndex getWeatherIndexLevel();
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
	WeatherCalculationPeriods getWeatherCalculationPeriods();
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
	CalculationPeriodsReference getWeatherCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the price per weather index unit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the price per weather index unit.
	 *
	 */
	NonNegativeMoney getWeatherNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines details relevant to the calculation of the aggregate weather index amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines details relevant to the calculation of the aggregate weather index amount.
	 *
	 */
	WeatherLegCalculation getCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods or Calculation Date
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods or Calculation Date
	 *
	 */
	CommodityRelativePaymentDates getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies where the data (e.g. CPD) have been collected, an actual physical reference point (weather station) and various fall back arrangements.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies where the data (e.g. CPD) have been collected, an actual physical reference point (weather station) and various fall back arrangements.
	 *
	 */
	WeatherIndexData getWeatherIndexData();

	/*********************** Build Methods  ***********************/
	WeatherLeg build();
	
	WeatherLeg.WeatherLegBuilder toBuilder();
	
	static WeatherLeg.WeatherLegBuilder builder() {
		return new WeatherLeg.WeatherLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeatherLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WeatherLeg> getType() {
		return WeatherLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("weatherIndexLevel"), processor, WeatherIndex.class, getWeatherIndexLevel());
		processRosetta(path.newSubPath("weatherCalculationPeriods"), processor, WeatherCalculationPeriods.class, getWeatherCalculationPeriods());
		processRosetta(path.newSubPath("weatherCalculationPeriodsReference"), processor, CalculationPeriodsReference.class, getWeatherCalculationPeriodsReference());
		processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.class, getWeatherNotionalAmount());
		processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("paymentDates"), processor, CommodityRelativePaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.class, getWeatherIndexData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeatherLegBuilder extends WeatherLeg, FinancialSwapLeg.FinancialSwapLegBuilder {
		WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexLevel();
		@Override
		WeatherIndex.WeatherIndexBuilder getWeatherIndexLevel();
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getOrCreateWeatherCalculationPeriods();
		@Override
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getWeatherCalculationPeriods();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateWeatherCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getWeatherCalculationPeriodsReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount();
		WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation();
		@Override
		WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreatePaymentDates();
		@Override
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getPaymentDates();
		WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData();
		@Override
		WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData();
		@Override
		WeatherLeg.WeatherLegBuilder setId(String id);
		@Override
		WeatherLeg.WeatherLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		WeatherLeg.WeatherLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		WeatherLeg.WeatherLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		WeatherLeg.WeatherLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		WeatherLeg.WeatherLegBuilder setWeatherIndexLevel(WeatherIndex weatherIndexLevel);
		WeatherLeg.WeatherLegBuilder setWeatherCalculationPeriods(WeatherCalculationPeriods weatherCalculationPeriods);
		WeatherLeg.WeatherLegBuilder setWeatherCalculationPeriodsReference(CalculationPeriodsReference weatherCalculationPeriodsReference);
		WeatherLeg.WeatherLegBuilder setWeatherNotionalAmount(NonNegativeMoney weatherNotionalAmount);
		WeatherLeg.WeatherLegBuilder setCalculation(WeatherLegCalculation calculation);
		WeatherLeg.WeatherLegBuilder setPaymentDates(CommodityRelativePaymentDates paymentDates);
		WeatherLeg.WeatherLegBuilder setWeatherIndexData(WeatherIndexData weatherIndexData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("weatherIndexLevel"), processor, WeatherIndex.WeatherIndexBuilder.class, getWeatherIndexLevel());
			processRosetta(path.newSubPath("weatherCalculationPeriods"), processor, WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder.class, getWeatherCalculationPeriods());
			processRosetta(path.newSubPath("weatherCalculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getWeatherCalculationPeriodsReference());
			processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getWeatherNotionalAmount());
			processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.WeatherLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("paymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.WeatherIndexDataBuilder.class, getWeatherIndexData());
		}
		

		WeatherLeg.WeatherLegBuilder prune();
	}

	/*********************** Immutable Implementation of WeatherLeg  ***********************/
	class WeatherLegImpl extends FinancialSwapLeg.FinancialSwapLegImpl implements WeatherLeg {
		private final WeatherIndex weatherIndexLevel;
		private final WeatherCalculationPeriods weatherCalculationPeriods;
		private final CalculationPeriodsReference weatherCalculationPeriodsReference;
		private final NonNegativeMoney weatherNotionalAmount;
		private final WeatherLegCalculation calculation;
		private final CommodityRelativePaymentDates paymentDates;
		private final WeatherIndexData weatherIndexData;
		
		protected WeatherLegImpl(WeatherLeg.WeatherLegBuilder builder) {
			super(builder);
			this.weatherIndexLevel = ofNullable(builder.getWeatherIndexLevel()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriods = ofNullable(builder.getWeatherCalculationPeriods()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriodsReference = ofNullable(builder.getWeatherCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.weatherNotionalAmount = ofNullable(builder.getWeatherNotionalAmount()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.weatherIndexData = ofNullable(builder.getWeatherIndexData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("weatherIndexLevel")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("weatherIndexLevel")
		public WeatherIndex getWeatherIndexLevel() {
			return weatherIndexLevel;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriods getWeatherCalculationPeriods() {
			return weatherCalculationPeriods;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriodsReference")
		public CalculationPeriodsReference getWeatherCalculationPeriodsReference() {
			return weatherCalculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("weatherNotionalAmount")
		public NonNegativeMoney getWeatherNotionalAmount() {
			return weatherNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculation")
		public WeatherLegCalculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public CommodityRelativePaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexData")
		public WeatherIndexData getWeatherIndexData() {
			return weatherIndexData;
		}
		
		@Override
		public WeatherLeg build() {
			return this;
		}
		
		@Override
		public WeatherLeg.WeatherLegBuilder toBuilder() {
			WeatherLeg.WeatherLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeatherLeg.WeatherLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getWeatherIndexLevel()).ifPresent(builder::setWeatherIndexLevel);
			ofNullable(getWeatherCalculationPeriods()).ifPresent(builder::setWeatherCalculationPeriods);
			ofNullable(getWeatherCalculationPeriodsReference()).ifPresent(builder::setWeatherCalculationPeriodsReference);
			ofNullable(getWeatherNotionalAmount()).ifPresent(builder::setWeatherNotionalAmount);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getWeatherIndexData()).ifPresent(builder::setWeatherIndexData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			WeatherLeg _that = getType().cast(o);
		
			if (!Objects.equals(weatherIndexLevel, _that.getWeatherIndexLevel())) return false;
			if (!Objects.equals(weatherCalculationPeriods, _that.getWeatherCalculationPeriods())) return false;
			if (!Objects.equals(weatherCalculationPeriodsReference, _that.getWeatherCalculationPeriodsReference())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weatherIndexLevel != null ? weatherIndexLevel.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriods != null ? weatherCalculationPeriods.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodsReference != null ? weatherCalculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherLeg {" +
				"weatherIndexLevel=" + this.weatherIndexLevel + ", " +
				"weatherCalculationPeriods=" + this.weatherCalculationPeriods + ", " +
				"weatherCalculationPeriodsReference=" + this.weatherCalculationPeriodsReference + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"calculation=" + this.calculation + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"weatherIndexData=" + this.weatherIndexData +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of WeatherLeg  ***********************/
	class WeatherLegBuilderImpl extends FinancialSwapLeg.FinancialSwapLegBuilderImpl implements WeatherLeg.WeatherLegBuilder {
	
		protected WeatherIndex.WeatherIndexBuilder weatherIndexLevel;
		protected WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder weatherCalculationPeriods;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder weatherCalculationPeriodsReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder weatherNotionalAmount;
		protected WeatherLegCalculation.WeatherLegCalculationBuilder calculation;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder paymentDates;
		protected WeatherIndexData.WeatherIndexDataBuilder weatherIndexData;
		
		@Override
		@RosettaAttribute("weatherIndexLevel")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("weatherIndexLevel")
		public WeatherIndex.WeatherIndexBuilder getWeatherIndexLevel() {
			return weatherIndexLevel;
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexLevel() {
			WeatherIndex.WeatherIndexBuilder result;
			if (weatherIndexLevel!=null) {
				result = weatherIndexLevel;
			}
			else {
				result = weatherIndexLevel = WeatherIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getWeatherCalculationPeriods() {
			return weatherCalculationPeriods;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getOrCreateWeatherCalculationPeriods() {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder result;
			if (weatherCalculationPeriods!=null) {
				result = weatherCalculationPeriods;
			}
			else {
				result = weatherCalculationPeriods = WeatherCalculationPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getWeatherCalculationPeriodsReference() {
			return weatherCalculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateWeatherCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (weatherCalculationPeriodsReference!=null) {
				result = weatherCalculationPeriodsReference;
			}
			else {
				result = weatherCalculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("weatherNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount() {
			return weatherNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (weatherNotionalAmount!=null) {
				result = weatherNotionalAmount;
			}
			else {
				result = weatherNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculation")
		public WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation() {
			return calculation;
		}
		
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation() {
			WeatherLegCalculation.WeatherLegCalculationBuilder result;
			if (calculation!=null) {
				result = calculation;
			}
			else {
				result = calculation = WeatherLegCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreatePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexData")
		public WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData() {
			return weatherIndexData;
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData() {
			WeatherIndexData.WeatherIndexDataBuilder result;
			if (weatherIndexData!=null) {
				result = weatherIndexData;
			}
			else {
				result = weatherIndexData = WeatherIndexData.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public WeatherLeg.WeatherLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public WeatherLeg.WeatherLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public WeatherLeg.WeatherLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public WeatherLeg.WeatherLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public WeatherLeg.WeatherLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherIndexLevel")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("weatherIndexLevel")
		@Override
		public WeatherLeg.WeatherLegBuilder setWeatherIndexLevel(WeatherIndex _weatherIndexLevel) {
			this.weatherIndexLevel = _weatherIndexLevel == null ? null : _weatherIndexLevel.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherCalculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherCalculationPeriods")
		@Override
		public WeatherLeg.WeatherLegBuilder setWeatherCalculationPeriods(WeatherCalculationPeriods _weatherCalculationPeriods) {
			this.weatherCalculationPeriods = _weatherCalculationPeriods == null ? null : _weatherCalculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherCalculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherCalculationPeriodsReference")
		@Override
		public WeatherLeg.WeatherLegBuilder setWeatherCalculationPeriodsReference(CalculationPeriodsReference _weatherCalculationPeriodsReference) {
			this.weatherCalculationPeriodsReference = _weatherCalculationPeriodsReference == null ? null : _weatherCalculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("weatherNotionalAmount")
		@Override
		public WeatherLeg.WeatherLegBuilder setWeatherNotionalAmount(NonNegativeMoney _weatherNotionalAmount) {
			this.weatherNotionalAmount = _weatherNotionalAmount == null ? null : _weatherNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculation")
		@Override
		public WeatherLeg.WeatherLegBuilder setCalculation(WeatherLegCalculation _calculation) {
			this.calculation = _calculation == null ? null : _calculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public WeatherLeg.WeatherLegBuilder setPaymentDates(CommodityRelativePaymentDates _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherIndexData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherIndexData")
		@Override
		public WeatherLeg.WeatherLegBuilder setWeatherIndexData(WeatherIndexData _weatherIndexData) {
			this.weatherIndexData = _weatherIndexData == null ? null : _weatherIndexData.toBuilder();
			return this;
		}
		
		@Override
		public WeatherLeg build() {
			return new WeatherLeg.WeatherLegImpl(this);
		}
		
		@Override
		public WeatherLeg.WeatherLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherLeg.WeatherLegBuilder prune() {
			super.prune();
			if (weatherIndexLevel!=null && !weatherIndexLevel.prune().hasData()) weatherIndexLevel = null;
			if (weatherCalculationPeriods!=null && !weatherCalculationPeriods.prune().hasData()) weatherCalculationPeriods = null;
			if (weatherCalculationPeriodsReference!=null && !weatherCalculationPeriodsReference.prune().hasData()) weatherCalculationPeriodsReference = null;
			if (weatherNotionalAmount!=null && !weatherNotionalAmount.prune().hasData()) weatherNotionalAmount = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (weatherIndexData!=null && !weatherIndexData.prune().hasData()) weatherIndexData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getWeatherIndexLevel()!=null && getWeatherIndexLevel().hasData()) return true;
			if (getWeatherCalculationPeriods()!=null && getWeatherCalculationPeriods().hasData()) return true;
			if (getWeatherCalculationPeriodsReference()!=null && getWeatherCalculationPeriodsReference().hasData()) return true;
			if (getWeatherNotionalAmount()!=null && getWeatherNotionalAmount().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getWeatherIndexData()!=null && getWeatherIndexData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeatherLeg.WeatherLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			WeatherLeg.WeatherLegBuilder o = (WeatherLeg.WeatherLegBuilder) other;
			
			merger.mergeRosetta(getWeatherIndexLevel(), o.getWeatherIndexLevel(), this::setWeatherIndexLevel);
			merger.mergeRosetta(getWeatherCalculationPeriods(), o.getWeatherCalculationPeriods(), this::setWeatherCalculationPeriods);
			merger.mergeRosetta(getWeatherCalculationPeriodsReference(), o.getWeatherCalculationPeriodsReference(), this::setWeatherCalculationPeriodsReference);
			merger.mergeRosetta(getWeatherNotionalAmount(), o.getWeatherNotionalAmount(), this::setWeatherNotionalAmount);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getWeatherIndexData(), o.getWeatherIndexData(), this::setWeatherIndexData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			WeatherLeg _that = getType().cast(o);
		
			if (!Objects.equals(weatherIndexLevel, _that.getWeatherIndexLevel())) return false;
			if (!Objects.equals(weatherCalculationPeriods, _that.getWeatherCalculationPeriods())) return false;
			if (!Objects.equals(weatherCalculationPeriodsReference, _that.getWeatherCalculationPeriodsReference())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (weatherIndexLevel != null ? weatherIndexLevel.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriods != null ? weatherCalculationPeriods.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodsReference != null ? weatherCalculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeatherLegBuilder {" +
				"weatherIndexLevel=" + this.weatherIndexLevel + ", " +
				"weatherCalculationPeriods=" + this.weatherCalculationPeriods + ", " +
				"weatherCalculationPeriodsReference=" + this.weatherCalculationPeriodsReference + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"calculation=" + this.calculation + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"weatherIndexData=" + this.weatherIndexData +
			'}' + " " + super.toString();
		}
	}
}
