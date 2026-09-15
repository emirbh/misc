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
import drr.standards.iosco.upi.meta.AnnaDsbCreditMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbCredit", builder=AnnaDsbCredit.AnnaDsbCreditBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbCredit", model="drr", builder=AnnaDsbCredit.AnnaDsbCreditBuilderImpl.class, version="7.7.0")
public interface AnnaDsbCredit extends RosettaModelObject {

	AnnaDsbCreditMeta metaData = new AnnaDsbCreditMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic();
	AnnaDsbDebtSeniorityEnum getDebtSeniority();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit();
	String getUnderlyingInstrumentISIN();
	Integer getUnderlyingCreditIndexVersion();
	Integer getUnderlyingInstrumentIndexTermValue();
	Integer getUnderlyingCreditIndexSeries();
	AnnaDsbUnderlying getUnderlying();
	String getUnderlyingInstrumentIndexProp();
	String getUnderlyingInstrumentIndex();
	String getUnderlierName();
	String getUnderlyingInstrumentLEI();

	/*********************** Build Methods  ***********************/
	AnnaDsbCredit build();
	
	AnnaDsbCredit.AnnaDsbCreditBuilder toBuilder();
	
	static AnnaDsbCredit.AnnaDsbCreditBuilder builder() {
		return new AnnaDsbCredit.AnnaDsbCreditBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbCredit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbCredit> getType() {
		return AnnaDsbCredit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
		processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
		processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.class, getUnderlying());
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
		processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentLEI"), String.class, getUnderlyingInstrumentLEI(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbCreditBuilder extends AnnaDsbCredit, RosettaModelObjectBuilder {
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying();
		@Override
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying();
		AnnaDsbCredit.AnnaDsbCreditBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum UnderlierCharacteristic);
		AnnaDsbCredit.AnnaDsbCreditBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum DebtSeniority);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum UnderlyingInstrumentIndexTermUnit);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentISIN(String UnderlyingInstrumentISIN);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingCreditIndexVersion(Integer UnderlyingCreditIndexVersion);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndexTermValue(Integer UnderlyingInstrumentIndexTermValue);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingCreditIndexSeries(Integer UnderlyingCreditIndexSeries);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlying(AnnaDsbUnderlying Underlying);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndexProp(String UnderlyingInstrumentIndexProp);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndex(String UnderlyingInstrumentIndex);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlierName(String UnderlierName);
		AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentLEI(String UnderlyingInstrumentLEI);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
			processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
			processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder.class, getUnderlying());
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
			processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentLEI"), String.class, getUnderlyingInstrumentLEI(), this);
		}
		

		AnnaDsbCredit.AnnaDsbCreditBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbCredit  ***********************/
	class AnnaDsbCreditImpl implements AnnaDsbCredit {
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		private final AnnaDsbDebtSeniorityEnum debtSeniority;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		private final String underlyingInstrumentISIN;
		private final Integer underlyingCreditIndexVersion;
		private final Integer underlyingInstrumentIndexTermValue;
		private final Integer underlyingCreditIndexSeries;
		private final AnnaDsbUnderlying underlying;
		private final String underlyingInstrumentIndexProp;
		private final String underlyingInstrumentIndex;
		private final String underlierName;
		private final String underlyingInstrumentLEI;
		
		protected AnnaDsbCreditImpl(AnnaDsbCredit.AnnaDsbCreditBuilder builder) {
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.debtSeniority = builder.getDebtSeniority();
			this.underlyingInstrumentIndexTermUnit = builder.getUnderlyingInstrumentIndexTermUnit();
			this.underlyingInstrumentISIN = builder.getUnderlyingInstrumentISIN();
			this.underlyingCreditIndexVersion = builder.getUnderlyingCreditIndexVersion();
			this.underlyingInstrumentIndexTermValue = builder.getUnderlyingInstrumentIndexTermValue();
			this.underlyingCreditIndexSeries = builder.getUnderlyingCreditIndexSeries();
			this.underlying = ofNullable(builder.getUnderlying()).map(f->f.build()).orElse(null);
			this.underlyingInstrumentIndexProp = builder.getUnderlyingInstrumentIndexProp();
			this.underlyingInstrumentIndex = builder.getUnderlyingInstrumentIndex();
			this.underlierName = builder.getUnderlierName();
			this.underlyingInstrumentLEI = builder.getUnderlyingInstrumentLEI();
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
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
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying getUnderlying() {
			return underlying;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentLEI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentLEI")
		public String getUnderlyingInstrumentLEI() {
			return underlyingInstrumentLEI;
		}
		
		@Override
		public AnnaDsbCredit build() {
			return this;
		}
		
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder toBuilder() {
			AnnaDsbCredit.AnnaDsbCreditBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbCredit.AnnaDsbCreditBuilder builder) {
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getUnderlyingInstrumentIndexTermUnit()).ifPresent(builder::setUnderlyingInstrumentIndexTermUnit);
			ofNullable(getUnderlyingInstrumentISIN()).ifPresent(builder::setUnderlyingInstrumentISIN);
			ofNullable(getUnderlyingCreditIndexVersion()).ifPresent(builder::setUnderlyingCreditIndexVersion);
			ofNullable(getUnderlyingInstrumentIndexTermValue()).ifPresent(builder::setUnderlyingInstrumentIndexTermValue);
			ofNullable(getUnderlyingCreditIndexSeries()).ifPresent(builder::setUnderlyingCreditIndexSeries);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getUnderlyingInstrumentIndexProp()).ifPresent(builder::setUnderlyingInstrumentIndexProp);
			ofNullable(getUnderlyingInstrumentIndex()).ifPresent(builder::setUnderlyingInstrumentIndex);
			ofNullable(getUnderlierName()).ifPresent(builder::setUnderlierName);
			ofNullable(getUnderlyingInstrumentLEI()).ifPresent(builder::setUnderlyingInstrumentLEI);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCredit _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			if (!Objects.equals(underlyingInstrumentLEI, _that.getUnderlyingInstrumentLEI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentLEI != null ? underlyingInstrumentLEI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbCredit {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"Underlying=" + this.underlying + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlierName=" + this.underlierName + ", " +
				"UnderlyingInstrumentLEI=" + this.underlyingInstrumentLEI +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbCredit  ***********************/
	class AnnaDsbCreditBuilderImpl implements AnnaDsbCredit.AnnaDsbCreditBuilder {
	
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		protected AnnaDsbDebtSeniorityEnum debtSeniority;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		protected String underlyingInstrumentISIN;
		protected Integer underlyingCreditIndexVersion;
		protected Integer underlyingInstrumentIndexTermValue;
		protected Integer underlyingCreditIndexSeries;
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying;
		protected String underlyingInstrumentIndexProp;
		protected String underlyingInstrumentIndex;
		protected String underlierName;
		protected String underlyingInstrumentLEI;
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
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
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying() {
			return underlying;
		}
		
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying() {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder result;
			if (underlying!=null) {
				result = underlying;
			}
			else {
				result = underlying = AnnaDsbUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentLEI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentLEI")
		public String getUnderlyingInstrumentLEI() {
			return underlyingInstrumentLEI;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DebtSeniority")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _underlyingInstrumentIndexTermUnit) {
			this.underlyingInstrumentIndexTermUnit = _underlyingInstrumentIndexTermUnit == null ? null : _underlyingInstrumentIndexTermUnit;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentISIN(String _underlyingInstrumentISIN) {
			this.underlyingInstrumentISIN = _underlyingInstrumentISIN == null ? null : _underlyingInstrumentISIN;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingCreditIndexVersion(Integer _underlyingCreditIndexVersion) {
			this.underlyingCreditIndexVersion = _underlyingCreditIndexVersion == null ? null : _underlyingCreditIndexVersion;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndexTermValue(Integer _underlyingInstrumentIndexTermValue) {
			this.underlyingInstrumentIndexTermValue = _underlyingInstrumentIndexTermValue == null ? null : _underlyingInstrumentIndexTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexSeries")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingCreditIndexSeries(Integer _underlyingCreditIndexSeries) {
			this.underlyingCreditIndexSeries = _underlyingCreditIndexSeries == null ? null : _underlyingCreditIndexSeries;
			return this;
		}
		
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Underlying")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlying(AnnaDsbUnderlying _underlying) {
			this.underlying = _underlying == null ? null : _underlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndexProp(String _underlyingInstrumentIndexProp) {
			this.underlyingInstrumentIndexProp = _underlyingInstrumentIndexProp == null ? null : _underlyingInstrumentIndexProp;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentIndex(String _underlyingInstrumentIndex) {
			this.underlyingInstrumentIndex = _underlyingInstrumentIndex == null ? null : _underlyingInstrumentIndex;
			return this;
		}
		
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierName")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlierName(String _underlierName) {
			this.underlierName = _underlierName == null ? null : _underlierName;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentLEI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentLEI")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder setUnderlyingInstrumentLEI(String _underlyingInstrumentLEI) {
			this.underlyingInstrumentLEI = _underlyingInstrumentLEI == null ? null : _underlyingInstrumentLEI;
			return this;
		}
		
		@Override
		public AnnaDsbCredit build() {
			return new AnnaDsbCredit.AnnaDsbCreditImpl(this);
		}
		
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder prune() {
			if (underlying!=null && !underlying.prune().hasData()) underlying = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getDebtSeniority()!=null) return true;
			if (getUnderlyingInstrumentIndexTermUnit()!=null) return true;
			if (getUnderlyingInstrumentISIN()!=null) return true;
			if (getUnderlyingCreditIndexVersion()!=null) return true;
			if (getUnderlyingInstrumentIndexTermValue()!=null) return true;
			if (getUnderlyingCreditIndexSeries()!=null) return true;
			if (getUnderlying()!=null && getUnderlying().hasData()) return true;
			if (getUnderlyingInstrumentIndexProp()!=null) return true;
			if (getUnderlyingInstrumentIndex()!=null) return true;
			if (getUnderlierName()!=null) return true;
			if (getUnderlyingInstrumentLEI()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCredit.AnnaDsbCreditBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbCredit.AnnaDsbCreditBuilder o = (AnnaDsbCredit.AnnaDsbCreditBuilder) other;
			
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::setUnderlying);
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermUnit(), o.getUnderlyingInstrumentIndexTermUnit(), this::setUnderlyingInstrumentIndexTermUnit);
			merger.mergeBasic(getUnderlyingInstrumentISIN(), o.getUnderlyingInstrumentISIN(), this::setUnderlyingInstrumentISIN);
			merger.mergeBasic(getUnderlyingCreditIndexVersion(), o.getUnderlyingCreditIndexVersion(), this::setUnderlyingCreditIndexVersion);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermValue(), o.getUnderlyingInstrumentIndexTermValue(), this::setUnderlyingInstrumentIndexTermValue);
			merger.mergeBasic(getUnderlyingCreditIndexSeries(), o.getUnderlyingCreditIndexSeries(), this::setUnderlyingCreditIndexSeries);
			merger.mergeBasic(getUnderlyingInstrumentIndexProp(), o.getUnderlyingInstrumentIndexProp(), this::setUnderlyingInstrumentIndexProp);
			merger.mergeBasic(getUnderlyingInstrumentIndex(), o.getUnderlyingInstrumentIndex(), this::setUnderlyingInstrumentIndex);
			merger.mergeBasic(getUnderlierName(), o.getUnderlierName(), this::setUnderlierName);
			merger.mergeBasic(getUnderlyingInstrumentLEI(), o.getUnderlyingInstrumentLEI(), this::setUnderlyingInstrumentLEI);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCredit _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			if (!Objects.equals(underlyingInstrumentLEI, _that.getUnderlyingInstrumentLEI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentLEI != null ? underlyingInstrumentLEI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbCreditBuilder {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"Underlying=" + this.underlying + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlierName=" + this.underlierName + ", " +
				"UnderlyingInstrumentLEI=" + this.underlyingInstrumentLEI +
			'}';
		}
	}
}
