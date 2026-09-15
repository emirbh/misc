package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUnderlierTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUnderlierType", builder=AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUnderlierType", model="drr", builder=AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUnderlierType extends RosettaModelObject {

	AnnaDsbUnderlierTypeMeta metaData = new AnnaDsbUnderlierTypeMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	AnnaDsbDebtSeniorityEnum getDebtSeniority();
	Integer getUnderlyingInstrumentIndexTermValue();
	Integer getUnderlyingCreditIndexSeries();
	String getUnderlierID();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit();
	Integer getUnderlyingCreditIndexVersion();
	Integer getReferenceRateTermValue();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit();

	/*********************** Build Methods  ***********************/
	AnnaDsbUnderlierType build();
	
	AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder toBuilder();
	
	static AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder builder() {
		return new AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUnderlierType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUnderlierType> getType() {
		return AnnaDsbUnderlierType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
		processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUnderlierTypeBuilder extends AnnaDsbUnderlierType, RosettaModelObjectBuilder {
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum DebtSeniority);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingInstrumentIndexTermValue(Integer UnderlyingInstrumentIndexTermValue);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingCreditIndexSeries(Integer UnderlyingCreditIndexSeries);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlierID(String UnderlierID);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum UnderlyingInstrumentIndexTermUnit);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingCreditIndexVersion(Integer UnderlyingCreditIndexVersion);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setReferenceRateTermValue(Integer ReferenceRateTermValue);
		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ReferenceRateTermUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("DebtSeniority"), AnnaDsbDebtSeniorityEnum.class, getDebtSeniority(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermValue"), Integer.class, getReferenceRateTermValue(), this);
			processor.processBasic(path.newSubPath("ReferenceRateTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getReferenceRateTermUnit(), this);
		}
		

		AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUnderlierType  ***********************/
	class AnnaDsbUnderlierTypeImpl implements AnnaDsbUnderlierType {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final AnnaDsbDebtSeniorityEnum debtSeniority;
		private final Integer underlyingInstrumentIndexTermValue;
		private final Integer underlyingCreditIndexSeries;
		private final String underlierID;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		private final Integer underlyingCreditIndexVersion;
		private final Integer referenceRateTermValue;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		
		protected AnnaDsbUnderlierTypeImpl(AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder builder) {
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.debtSeniority = builder.getDebtSeniority();
			this.underlyingInstrumentIndexTermValue = builder.getUnderlyingInstrumentIndexTermValue();
			this.underlyingCreditIndexSeries = builder.getUnderlyingCreditIndexSeries();
			this.underlierID = builder.getUnderlierID();
			this.underlyingInstrumentIndexTermUnit = builder.getUnderlyingInstrumentIndexTermUnit();
			this.underlyingCreditIndexVersion = builder.getUnderlyingCreditIndexVersion();
			this.referenceRateTermValue = builder.getReferenceRateTermValue();
			this.referenceRateTermUnit = builder.getReferenceRateTermUnit();
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
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
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		public Integer getUnderlyingCreditIndexVersion() {
			return underlyingCreditIndexVersion;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit() {
			return referenceRateTermUnit;
		}
		
		@Override
		public AnnaDsbUnderlierType build() {
			return this;
		}
		
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder toBuilder() {
			AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
			ofNullable(getUnderlyingInstrumentIndexTermValue()).ifPresent(builder::setUnderlyingInstrumentIndexTermValue);
			ofNullable(getUnderlyingCreditIndexSeries()).ifPresent(builder::setUnderlyingCreditIndexSeries);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
			ofNullable(getUnderlyingInstrumentIndexTermUnit()).ifPresent(builder::setUnderlyingInstrumentIndexTermUnit);
			ofNullable(getUnderlyingCreditIndexVersion()).ifPresent(builder::setUnderlyingCreditIndexVersion);
			ofNullable(getReferenceRateTermValue()).ifPresent(builder::setReferenceRateTermValue);
			ofNullable(getReferenceRateTermUnit()).ifPresent(builder::setReferenceRateTermUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlierType _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlierType {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUnderlierType  ***********************/
	class AnnaDsbUnderlierTypeBuilderImpl implements AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder {
	
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected AnnaDsbDebtSeniorityEnum debtSeniority;
		protected Integer underlyingInstrumentIndexTermValue;
		protected Integer underlyingCreditIndexSeries;
		protected String underlierID;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		protected Integer underlyingCreditIndexVersion;
		protected Integer referenceRateTermValue;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum referenceRateTermUnit;
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DebtSeniority")
		public AnnaDsbDebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
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
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		public Integer getUnderlyingCreditIndexVersion() {
			return underlyingCreditIndexVersion;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermValue")
		public Integer getReferenceRateTermValue() {
			return referenceRateTermValue;
		}
		
		@Override
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getReferenceRateTermUnit() {
			return referenceRateTermUnit;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("DebtSeniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DebtSeniority")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setDebtSeniority(AnnaDsbDebtSeniorityEnum _debtSeniority) {
			this.debtSeniority = _debtSeniority == null ? null : _debtSeniority;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingInstrumentIndexTermValue(Integer _underlyingInstrumentIndexTermValue) {
			this.underlyingInstrumentIndexTermValue = _underlyingInstrumentIndexTermValue == null ? null : _underlyingInstrumentIndexTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexSeries")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingCreditIndexSeries(Integer _underlyingCreditIndexSeries) {
			this.underlyingCreditIndexSeries = _underlyingCreditIndexSeries == null ? null : _underlyingCreditIndexSeries;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _underlyingInstrumentIndexTermUnit) {
			this.underlyingInstrumentIndexTermUnit = _underlyingInstrumentIndexTermUnit == null ? null : _underlyingInstrumentIndexTermUnit;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setUnderlyingCreditIndexVersion(Integer _underlyingCreditIndexVersion) {
			this.underlyingCreditIndexVersion = _underlyingCreditIndexVersion == null ? null : _underlyingCreditIndexVersion;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermValue")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setReferenceRateTermValue(Integer _referenceRateTermValue) {
			this.referenceRateTermValue = _referenceRateTermValue == null ? null : _referenceRateTermValue;
			return this;
		}
		
		@RosettaAttribute("ReferenceRateTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReferenceRateTermUnit")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder setReferenceRateTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _referenceRateTermUnit) {
			this.referenceRateTermUnit = _referenceRateTermUnit == null ? null : _referenceRateTermUnit;
			return this;
		}
		
		@Override
		public AnnaDsbUnderlierType build() {
			return new AnnaDsbUnderlierType.AnnaDsbUnderlierTypeImpl(this);
		}
		
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlierIDSource()!=null) return true;
			if (getDebtSeniority()!=null) return true;
			if (getUnderlyingInstrumentIndexTermValue()!=null) return true;
			if (getUnderlyingCreditIndexSeries()!=null) return true;
			if (getUnderlierID()!=null) return true;
			if (getUnderlyingInstrumentIndexTermUnit()!=null) return true;
			if (getUnderlyingCreditIndexVersion()!=null) return true;
			if (getReferenceRateTermValue()!=null) return true;
			if (getReferenceRateTermUnit()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder o = (AnnaDsbUnderlierType.AnnaDsbUnderlierTypeBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermValue(), o.getUnderlyingInstrumentIndexTermValue(), this::setUnderlyingInstrumentIndexTermValue);
			merger.mergeBasic(getUnderlyingCreditIndexSeries(), o.getUnderlyingCreditIndexSeries(), this::setUnderlyingCreditIndexSeries);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermUnit(), o.getUnderlyingInstrumentIndexTermUnit(), this::setUnderlyingInstrumentIndexTermUnit);
			merger.mergeBasic(getUnderlyingCreditIndexVersion(), o.getUnderlyingCreditIndexVersion(), this::setUnderlyingCreditIndexVersion);
			merger.mergeBasic(getReferenceRateTermValue(), o.getReferenceRateTermValue(), this::setReferenceRateTermValue);
			merger.mergeBasic(getReferenceRateTermUnit(), o.getReferenceRateTermUnit(), this::setReferenceRateTermUnit);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlierType _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			if (!Objects.equals(referenceRateTermValue, _that.getReferenceRateTermValue())) return false;
			if (!Objects.equals(referenceRateTermUnit, _that.getReferenceRateTermUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermValue != null ? referenceRateTermValue.hashCode() : 0);
			_result = 31 * _result + (referenceRateTermUnit != null ? referenceRateTermUnit.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlierTypeBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"DebtSeniority=" + this.debtSeniority + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion + ", " +
				"ReferenceRateTermValue=" + this.referenceRateTermValue + ", " +
				"ReferenceRateTermUnit=" + this.referenceRateTermUnit +
			'}';
		}
	}
}
