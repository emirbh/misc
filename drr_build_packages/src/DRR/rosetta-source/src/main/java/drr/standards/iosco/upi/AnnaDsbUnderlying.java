package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUnderlyingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUnderlying", builder=AnnaDsbUnderlying.AnnaDsbUnderlyingBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUnderlying", model="drr", builder=AnnaDsbUnderlying.AnnaDsbUnderlyingBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUnderlying extends RosettaModelObject {

	AnnaDsbUnderlyingMeta metaData = new AnnaDsbUnderlyingMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbDebtSeniorityEnum getDebtSeniority();
	AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic();
	String getReferenceRate();
	String getUnderlierID();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit();
	String getUnderlyingInstrumentISIN();
	Integer getUnderlyingCreditIndexVersion();
	AnnaDsbUnderlierType getUnderlierType();
	AnnaDsbEmpty getBasket();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit();
	AnnaDsbUnderlyingAssetType getUnderlyingAssetType();
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	Integer getUnderlyingInstrumentIndexTermValue();
	Integer getUnderlyingCreditIndexSeries();
	String getInstrumentISIN();
	String getInstrumentLEI();
	String getUnderlyingInstrumentIndex();
	String getUnderlyingInstrumentIndexProp();
	Integer getReferenceRateTermValue();
	String getUnderlyingInstrumentUPI();
	String getUnderlyingInstrumentLEI();

	/*********************** Build Methods  ***********************/
	AnnaDsbUnderlying build();
	
	AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder toBuilder();
	
	static AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder builder() {
		return new AnnaDsbUnderlying.AnnaDsbUnderlyingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUnderlying> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUnderlying> getType() {
		return AnnaDsbUnderlying.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
		processRosetta(path.newSubPath("UnderlierType"), processor, AnnaDsbUnderlierType.class, getUnderlierType());
		processRosetta(path.newSubPath("Basket"), processor, AnnaDsbEmpty.class, getBasket());
		processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
		processRosetta(path.newSubPath("UnderlyingAssetType"), processor, AnnaDsbUnderlyingAssetType.class, getUnderlyingAssetType());
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
		processor.processBasic(path.newSubPath("InstrumentISIN"), String.class, getInstrumentISIN(), this);
		processor.processBasic(path.newSubPath("InstrumentLEI"), String.class, getInstrumentLEI(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentUPI"), String.class, getUnderlyingInstrumentUPI(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentLEI"), String.class, getUnderlyingInstrumentLEI(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUnderlyingBuilder extends AnnaDsbUnderlying, RosettaModelObjectBuilder {
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder getOrCreateUnderlierType();
		@Override
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder getUnderlierType();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateBasket();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getBasket();
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder getOrCreateUnderlyingAssetType();
		@Override
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder getUnderlyingAssetType();
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum DebtSeniority);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum UnderlierCharacteristic);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setReferenceRate(String ReferenceRate);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierID(String UnderlierID);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum UnderlyingInstrumentIndexTermUnit);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentISIN(String UnderlyingInstrumentISIN);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingCreditIndexVersion(Integer UnderlyingCreditIndexVersion);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierType(AnnaDsbUnderlierType UnderlierType);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setBasket(AnnaDsbEmpty Basket);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ReferenceRateTermUnit);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetType UnderlyingAssetType);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndexTermValue(Integer UnderlyingInstrumentIndexTermValue);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingCreditIndexSeries(Integer UnderlyingCreditIndexSeries);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setInstrumentISIN(String InstrumentISIN);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setInstrumentLEI(String InstrumentLEI);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndex(String UnderlyingInstrumentIndex);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndexProp(String UnderlyingInstrumentIndexProp);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setReferenceRateTermValue(Integer ReferenceRateTermValue);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentUPI(String UnderlyingInstrumentUPI);
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentLEI(String UnderlyingInstrumentLEI);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("ReferenceRate"), String.class, getReferenceRate(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
			processRosetta(path.newSubPath("UnderlierType"), processor, AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder.class, getUnderlierType());
			processRosetta(path.newSubPath("Basket"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getBasket());
			processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
			processRosetta(path.newSubPath("UnderlyingAssetType"), processor, AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder.class, getUnderlyingAssetType());
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
			processor.processBasic(path.newSubPath("InstrumentISIN"), String.class, getInstrumentISIN(), this);
			processor.processBasic(path.newSubPath("InstrumentLEI"), String.class, getInstrumentLEI(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentUPI"), String.class, getUnderlyingInstrumentUPI(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentLEI"), String.class, getUnderlyingInstrumentLEI(), this);
		}
		

		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUnderlying  ***********************/
	class AnnaDsbUnderlyingImpl implements AnnaDsbUnderlying {
		private final AnnaDsbDebtSeniorityEnum debtSeniority;
		private final AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		private final String referenceRate;
		private final String underlierID;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		private final String underlyingInstrumentISIN;
		private final Integer underlyingCreditIndexVersion;
		private final AnnaDsbUnderlierType underlierType;
		private final AnnaDsbEmpty basket;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		private final AnnaDsbUnderlyingAssetType underlyingAssetType;
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final Integer underlyingInstrumentIndexTermValue;
		private final Integer underlyingCreditIndexSeries;
		private final String instrumentISIN;
		private final String instrumentLEI;
		private final String underlyingInstrumentIndex;
		private final String underlyingInstrumentIndexProp;
		private final Integer referenceRateTermValue;
		private final String underlyingInstrumentUPI;
		private final String underlyingInstrumentLEI;
		
		protected AnnaDsbUnderlyingImpl(AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder builder) {
			this.debtSeniority = builder.getDebtSeniority();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.referenceRate = builder.getReferenceRate();
			this.underlierID = builder.getUnderlierID();
			this.underlyingInstrumentIndexTermUnit = builder.getUnderlyingInstrumentIndexTermUnit();
			this.underlyingInstrumentISIN = builder.getUnderlyingInstrumentISIN();
			this.underlyingCreditIndexVersion = builder.getUnderlyingCreditIndexVersion();
			this.underlierType = ofNullable(builder.getUnderlierType()).map(f->f.build()).orElse(null);
			this.basket = ofNullable(builder.getBasket()).map(f->f.build()).orElse(null);
			this.referenceRateTermUnit = builder.getReferenceRateTermUnit();
			this.underlyingAssetType = ofNullable(builder.getUnderlyingAssetType()).map(f->f.build()).orElse(null);
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.underlyingInstrumentIndexTermValue = builder.getUnderlyingInstrumentIndexTermValue();
			this.underlyingCreditIndexSeries = builder.getUnderlyingCreditIndexSeries();
			this.instrumentISIN = builder.getInstrumentISIN();
			this.instrumentLEI = builder.getInstrumentLEI();
			this.underlyingInstrumentIndex = builder.getUnderlyingInstrumentIndex();
			this.underlyingInstrumentIndexProp = builder.getUnderlyingInstrumentIndexProp();
			this.referenceRateTermValue = builder.getReferenceRateTermValue();
			this.underlyingInstrumentUPI = builder.getUnderlyingInstrumentUPI();
			this.underlyingInstrumentLEI = builder.getUnderlyingInstrumentLEI();
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRate")
		public String getReferenceRate() {
			return referenceRate;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit() {
			return underlyingInstrumentIndexTermUnit;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		public String getUnderlyingInstrumentISIN() {
			return underlyingInstrumentISIN;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		public Integer getUnderlyingCreditIndexVersion() {
			return underlyingCreditIndexVersion;
		}
		
		@Override
		@RosettaAttribute("UnderlierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierType")
		public AnnaDsbUnderlierType getUnderlierType() {
			return underlierType;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Basket")
		public AnnaDsbEmpty getBasket() {
			return basket;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit() {
			return referenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetType")
		public AnnaDsbUnderlyingAssetType getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		public Integer getUnderlyingInstrumentIndexTermValue() {
			return underlyingInstrumentIndexTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingCreditIndexSeries")
		public Integer getUnderlyingCreditIndexSeries() {
			return underlyingCreditIndexSeries;
		}
		
		@Override
		@RosettaAttribute("InstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("InstrumentISIN")
		public String getInstrumentISIN() {
			return instrumentISIN;
		}
		
		@Override
		@RosettaAttribute("InstrumentLEI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("InstrumentLEI")
		public String getInstrumentLEI() {
			return instrumentLEI;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentUPI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentUPI")
		public String getUnderlyingInstrumentUPI() {
			return underlyingInstrumentUPI;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentLEI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentLEI")
		public String getUnderlyingInstrumentLEI() {
			return underlyingInstrumentLEI;
		}
		
		@Override
		public AnnaDsbUnderlying build() {
			return this;
		}
		
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder toBuilder() {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder builder) {
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getReferenceRate()).ifPresent(builder::setReferenceRate);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
			ofNullable(getUnderlyingInstrumentIndexTermUnit()).ifPresent(builder::setUnderlyingInstrumentIndexTermUnit);
			ofNullable(getUnderlyingInstrumentISIN()).ifPresent(builder::setUnderlyingInstrumentISIN);
			ofNullable(getUnderlyingCreditIndexVersion()).ifPresent(builder::setUnderlyingCreditIndexVersion);
			ofNullable(getUnderlierType()).ifPresent(builder::setUnderlierType);
			ofNullable(getBasket()).ifPresent(builder::setBasket);
			ofNullable(getReferenceRateTermUnit()).ifPresent(builder::setReferenceRateTermUnit);
			ofNullable(getUnderlyingAssetType()).ifPresent(builder::setUnderlyingAssetType);
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getUnderlyingInstrumentIndexTermValue()).ifPresent(builder::setUnderlyingInstrumentIndexTermValue);
			ofNullable(getUnderlyingCreditIndexSeries()).ifPresent(builder::setUnderlyingCreditIndexSeries);
			ofNullable(getInstrumentISIN()).ifPresent(builder::setInstrumentISIN);
			ofNullable(getInstrumentLEI()).ifPresent(builder::setInstrumentLEI);
			ofNullable(getUnderlyingInstrumentIndex()).ifPresent(builder::setUnderlyingInstrumentIndex);
			ofNullable(getUnderlyingInstrumentIndexProp()).ifPresent(builder::setUnderlyingInstrumentIndexProp);
			ofNullable(getReferenceRateTermValue()).ifPresent(builder::setReferenceRateTermValue);
			ofNullable(getUnderlyingInstrumentUPI()).ifPresent(builder::setUnderlyingInstrumentUPI);
			ofNullable(getUnderlyingInstrumentLEI()).ifPresent(builder::setUnderlyingInstrumentLEI);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			if (!Objects.equals(underlierType, _that.getUnderlierType())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(instrumentISIN, _that.getInstrumentISIN())) return false;
			if (!Objects.equals(instrumentLEI, _that.getInstrumentLEI())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(underlyingInstrumentUPI, _that.getUnderlyingInstrumentUPI())) return false;
			if (!Objects.equals(underlyingInstrumentLEI, _that.getUnderlyingInstrumentLEI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			_result = 31 * _result + (underlierType != null ? underlierType.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.hashCode() : 0);
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (instrumentISIN != null ? instrumentISIN.hashCode() : 0);
			_result = 31 * _result + (instrumentLEI != null ? instrumentLEI.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentUPI != null ? underlyingInstrumentUPI.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentLEI != null ? underlyingInstrumentLEI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlying {" +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion + ", " +
				"UnderlierType=" + this.underlierType + ", " +
				"Basket=" + this.basket + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit + ", " +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"InstrumentISIN=" + this.instrumentISIN + ", " +
				"InstrumentLEI=" + this.instrumentLEI + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"UnderlyingInstrumentUPI=" + this.underlyingInstrumentUPI + ", " +
				"UnderlyingInstrumentLEI=" + this.underlyingInstrumentLEI +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUnderlying  ***********************/
	class AnnaDsbUnderlyingBuilderImpl implements AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder {
	
		protected AnnaDsbDebtSeniorityEnum debtSeniority;
		protected AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		protected String referenceRate;
		protected String underlierID;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		protected String underlyingInstrumentISIN;
		protected Integer underlyingCreditIndexVersion;
		protected AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder underlierType;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder basket;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		protected AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder underlyingAssetType;
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected Integer underlyingInstrumentIndexTermValue;
		protected Integer underlyingCreditIndexSeries;
		protected String instrumentISIN;
		protected String instrumentLEI;
		protected String underlyingInstrumentIndex;
		protected String underlyingInstrumentIndexProp;
		protected Integer referenceRateTermValue;
		protected String underlyingInstrumentUPI;
		protected String underlyingInstrumentLEI;
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRate")
		public String getReferenceRate() {
			return referenceRate;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit() {
			return underlyingInstrumentIndexTermUnit;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		public String getUnderlyingInstrumentISIN() {
			return underlyingInstrumentISIN;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		public Integer getUnderlyingCreditIndexVersion() {
			return underlyingCreditIndexVersion;
		}
		
		@Override
		@RosettaAttribute("UnderlierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierType")
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder getUnderlierType() {
			return underlierType;
		}
		
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder getOrCreateUnderlierType() {
			AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder result;
			if (underlierType!=null) {
				result = underlierType;
			}
			else {
				result = underlierType = AnnaDsbUnderlierType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Basket")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getBasket() {
			return basket;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateBasket() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (basket!=null) {
				result = basket;
			}
			else {
				result = basket = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit() {
			return referenceRateTermUnit;
		}
		
		@Override
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingAssetType")
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder getOrCreateUnderlyingAssetType() {
			AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder result;
			if (underlyingAssetType!=null) {
				result = underlyingAssetType;
			}
			else {
				result = underlyingAssetType = AnnaDsbUnderlyingAssetType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		public Integer getUnderlyingInstrumentIndexTermValue() {
			return underlyingInstrumentIndexTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingCreditIndexSeries")
		public Integer getUnderlyingCreditIndexSeries() {
			return underlyingCreditIndexSeries;
		}
		
		@Override
		@RosettaAttribute("InstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("InstrumentISIN")
		public String getInstrumentISIN() {
			return instrumentISIN;
		}
		
		@Override
		@RosettaAttribute("InstrumentLEI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("InstrumentLEI")
		public String getInstrumentLEI() {
			return instrumentLEI;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentUPI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentUPI")
		public String getUnderlyingInstrumentUPI() {
			return underlyingInstrumentUPI;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentLEI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentLEI")
		public String getUnderlyingInstrumentLEI() {
			return underlyingInstrumentLEI;
		}
		
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DebtSeniority")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("ReferenceRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRate")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setReferenceRate(String _referenceRate) {
			this.referenceRate = _referenceRate == null ? null : _referenceRate;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _underlyingInstrumentIndexTermUnit) {
			this.underlyingInstrumentIndexTermUnit = _underlyingInstrumentIndexTermUnit == null ? null : _underlyingInstrumentIndexTermUnit;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentISIN(String _underlyingInstrumentISIN) {
			this.underlyingInstrumentISIN = _underlyingInstrumentISIN == null ? null : _underlyingInstrumentISIN;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingCreditIndexVersion(Integer _underlyingCreditIndexVersion) {
			this.underlyingCreditIndexVersion = _underlyingCreditIndexVersion == null ? null : _underlyingCreditIndexVersion;
			return this;
		}
		
		@RosettaAttribute("UnderlierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierType")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierType(AnnaDsbUnderlierType _underlierType) {
			this.underlierType = _underlierType == null ? null : _underlierType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Basket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Basket")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setBasket(AnnaDsbEmpty _basket) {
			this.basket = _basket == null ? null : _basket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _referenceRateTermUnit) {
			this.referenceRateTermUnit = _referenceRateTermUnit == null ? null : _referenceRateTermUnit;
			return this;
		}
		
		@RosettaAttribute("UnderlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingAssetType")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingAssetType(AnnaDsbUnderlyingAssetType _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndexTermValue(Integer _underlyingInstrumentIndexTermValue) {
			this.underlyingInstrumentIndexTermValue = _underlyingInstrumentIndexTermValue == null ? null : _underlyingInstrumentIndexTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexSeries")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingCreditIndexSeries(Integer _underlyingCreditIndexSeries) {
			this.underlyingCreditIndexSeries = _underlyingCreditIndexSeries == null ? null : _underlyingCreditIndexSeries;
			return this;
		}
		
		@RosettaAttribute("InstrumentISIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("InstrumentISIN")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setInstrumentISIN(String _instrumentISIN) {
			this.instrumentISIN = _instrumentISIN == null ? null : _instrumentISIN;
			return this;
		}
		
		@RosettaAttribute("InstrumentLEI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("InstrumentLEI")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setInstrumentLEI(String _instrumentLEI) {
			this.instrumentLEI = _instrumentLEI == null ? null : _instrumentLEI;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndex(String _underlyingInstrumentIndex) {
			this.underlyingInstrumentIndex = _underlyingInstrumentIndex == null ? null : _underlyingInstrumentIndex;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentIndexProp(String _underlyingInstrumentIndexProp) {
			this.underlyingInstrumentIndexProp = _underlyingInstrumentIndexProp == null ? null : _underlyingInstrumentIndexProp;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermValue")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setReferenceRateTermValue(Integer _referenceRateTermValue) {
			this.referenceRateTermValue = _referenceRateTermValue == null ? null : _referenceRateTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentUPI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentUPI")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentUPI(String _underlyingInstrumentUPI) {
			this.underlyingInstrumentUPI = _underlyingInstrumentUPI == null ? null : _underlyingInstrumentUPI;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentLEI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentLEI")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder setUnderlyingInstrumentLEI(String _underlyingInstrumentLEI) {
			this.underlyingInstrumentLEI = _underlyingInstrumentLEI == null ? null : _underlyingInstrumentLEI;
			return this;
		}
		
		@Override
		public AnnaDsbUnderlying build() {
			return new AnnaDsbUnderlying.AnnaDsbUnderlyingImpl(this);
		}
		
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder prune() {
			if (underlierType!=null && !underlierType.prune().hasData()) underlierType = null;
			if (basket!=null && !basket.prune().hasData()) basket = null;
			if (underlyingAssetType!=null && !underlyingAssetType.prune().hasData()) underlyingAssetType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDebtSeniority()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getReferenceRate()!=null) return true;
			if (getUnderlierID()!=null) return true;
			if (getUnderlyingInstrumentIndexTermUnit()!=null) return true;
			if (getUnderlyingInstrumentISIN()!=null) return true;
			if (getUnderlyingCreditIndexVersion()!=null) return true;
			if (getUnderlierType()!=null && getUnderlierType().hasData()) return true;
			if (getBasket()!=null && getBasket().hasData()) return true;
			if (getReferenceRateTermUnit()!=null) return true;
			if (getUnderlyingAssetType()!=null && getUnderlyingAssetType().hasData()) return true;
			if (getUnderlierIDSource()!=null) return true;
			if (getUnderlyingInstrumentIndexTermValue()!=null) return true;
			if (getUnderlyingCreditIndexSeries()!=null) return true;
			if (getInstrumentISIN()!=null) return true;
			if (getInstrumentLEI()!=null) return true;
			if (getUnderlyingInstrumentIndex()!=null) return true;
			if (getUnderlyingInstrumentIndexProp()!=null) return true;
			if (getReferenceRateTermValue()!=null) return true;
			if (getUnderlyingInstrumentUPI()!=null) return true;
			if (getUnderlyingInstrumentLEI()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder o = (AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder) other;
			
			merger.mergeRosetta(getUnderlierType(), o.getUnderlierType(), this::setUnderlierType);
			merger.mergeRosetta(getBasket(), o.getBasket(), this::setBasket);
			merger.mergeRosetta(getUnderlyingAssetType(), o.getUnderlyingAssetType(), this::setUnderlyingAssetType);
			
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getReferenceRate(), o.getReferenceRate(), this::setReferenceRate);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermUnit(), o.getUnderlyingInstrumentIndexTermUnit(), this::setUnderlyingInstrumentIndexTermUnit);
			merger.mergeBasic(getUnderlyingInstrumentISIN(), o.getUnderlyingInstrumentISIN(), this::setUnderlyingInstrumentISIN);
			merger.mergeBasic(getUnderlyingCreditIndexVersion(), o.getUnderlyingCreditIndexVersion(), this::setUnderlyingCreditIndexVersion);
			merger.mergeBasic(getReferenceRateTermUnit(), o.getReferenceRateTermUnit(), this::setReferenceRateTermUnit);
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermValue(), o.getUnderlyingInstrumentIndexTermValue(), this::setUnderlyingInstrumentIndexTermValue);
			merger.mergeBasic(getUnderlyingCreditIndexSeries(), o.getUnderlyingCreditIndexSeries(), this::setUnderlyingCreditIndexSeries);
			merger.mergeBasic(getInstrumentISIN(), o.getInstrumentISIN(), this::setInstrumentISIN);
			merger.mergeBasic(getInstrumentLEI(), o.getInstrumentLEI(), this::setInstrumentLEI);
			merger.mergeBasic(getUnderlyingInstrumentIndex(), o.getUnderlyingInstrumentIndex(), this::setUnderlyingInstrumentIndex);
			merger.mergeBasic(getUnderlyingInstrumentIndexProp(), o.getUnderlyingInstrumentIndexProp(), this::setUnderlyingInstrumentIndexProp);
			merger.mergeBasic(getReferenceRateTermValue(), o.getReferenceRateTermValue(), this::setReferenceRateTermValue);
			merger.mergeBasic(getUnderlyingInstrumentUPI(), o.getUnderlyingInstrumentUPI(), this::setUnderlyingInstrumentUPI);
			merger.mergeBasic(getUnderlyingInstrumentLEI(), o.getUnderlyingInstrumentLEI(), this::setUnderlyingInstrumentLEI);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlying _that = getType().cast(o);
		
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(referenceRate, _that.getReferenceRate())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			if (!Objects.equals(underlierType, _that.getUnderlierType())) return false;
			if (!Objects.equals(basket, _that.getBasket())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(instrumentISIN, _that.getInstrumentISIN())) return false;
			if (!Objects.equals(instrumentLEI, _that.getInstrumentLEI())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(underlyingInstrumentUPI, _that.getUnderlyingInstrumentUPI())) return false;
			if (!Objects.equals(underlyingInstrumentLEI, _that.getUnderlyingInstrumentLEI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (referenceRate != null ? referenceRate.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			_result = 31 * _result + (underlierType != null ? underlierType.hashCode() : 0);
			_result = 31 * _result + (basket != null ? basket.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.hashCode() : 0);
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (instrumentISIN != null ? instrumentISIN.hashCode() : 0);
			_result = 31 * _result + (instrumentLEI != null ? instrumentLEI.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentUPI != null ? underlyingInstrumentUPI.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentLEI != null ? underlyingInstrumentLEI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingBuilder {" +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"ReferenceRate=" + this.referenceRate + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion + ", " +
				"UnderlierType=" + this.underlierType + ", " +
				"Basket=" + this.basket + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit + ", " +
				"UnderlyingAssetType=" + this.underlyingAssetType + ", " +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"InstrumentISIN=" + this.instrumentISIN + ", " +
				"InstrumentLEI=" + this.instrumentLEI + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"UnderlyingInstrumentUPI=" + this.underlyingInstrumentUPI + ", " +
				"UnderlyingInstrumentLEI=" + this.underlyingInstrumentLEI +
			'}';
		}
	}
}
