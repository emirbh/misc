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
import drr.standards.iosco.upi.meta.AnnaDsbIndexTrancheMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbIndexTranche", builder=AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbIndexTranche", model="drr", builder=AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilderImpl.class, version="7.7.0")
public interface AnnaDsbIndexTranche extends RosettaModelObject {

	AnnaDsbIndexTrancheMeta metaData = new AnnaDsbIndexTrancheMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	Integer getUnderlyingInstrumentIndexTermValue();
	Integer getUnderlyingCreditIndexSeries();
	String getUnderlierID();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit();
	Integer getUnderlyingCreditIndexVersion();

	/*********************** Build Methods  ***********************/
	AnnaDsbIndexTranche build();
	
	AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder toBuilder();
	
	static AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder builder() {
		return new AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbIndexTranche> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbIndexTranche> getType() {
		return AnnaDsbIndexTranche.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
		processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbIndexTrancheBuilder extends AnnaDsbIndexTranche, RosettaModelObjectBuilder {
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingInstrumentIndexTermValue(Integer UnderlyingInstrumentIndexTermValue);
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingCreditIndexSeries(Integer UnderlyingCreditIndexSeries);
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlierID(String UnderlierID);
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum UnderlyingInstrumentIndexTermUnit);
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingCreditIndexVersion(Integer UnderlyingCreditIndexVersion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
		}
		

		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbIndexTranche  ***********************/
	class AnnaDsbIndexTrancheImpl implements AnnaDsbIndexTranche {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final Integer underlyingInstrumentIndexTermValue;
		private final Integer underlyingCreditIndexSeries;
		private final String underlierID;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		private final Integer underlyingCreditIndexVersion;
		
		protected AnnaDsbIndexTrancheImpl(AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder builder) {
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.underlyingInstrumentIndexTermValue = builder.getUnderlyingInstrumentIndexTermValue();
			this.underlyingCreditIndexSeries = builder.getUnderlyingCreditIndexSeries();
			this.underlierID = builder.getUnderlierID();
			this.underlyingInstrumentIndexTermUnit = builder.getUnderlyingInstrumentIndexTermUnit();
			this.underlyingCreditIndexVersion = builder.getUnderlyingCreditIndexVersion();
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
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		public Integer getUnderlyingInstrumentIndexTermValue() {
			return underlyingInstrumentIndexTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit() {
			return underlyingInstrumentIndexTermUnit;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlyingCreditIndexVersion")
		public Integer getUnderlyingCreditIndexVersion() {
			return underlyingCreditIndexVersion;
		}
		
		@Override
		public AnnaDsbIndexTranche build() {
			return this;
		}
		
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder toBuilder() {
			AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getUnderlyingInstrumentIndexTermValue()).ifPresent(builder::setUnderlyingInstrumentIndexTermValue);
			ofNullable(getUnderlyingCreditIndexSeries()).ifPresent(builder::setUnderlyingCreditIndexSeries);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
			ofNullable(getUnderlyingInstrumentIndexTermUnit()).ifPresent(builder::setUnderlyingInstrumentIndexTermUnit);
			ofNullable(getUnderlyingCreditIndexVersion()).ifPresent(builder::setUnderlyingCreditIndexVersion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbIndexTranche _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbIndexTranche {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbIndexTranche  ***********************/
	class AnnaDsbIndexTrancheBuilderImpl implements AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder {
	
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected Integer underlyingInstrumentIndexTermValue;
		protected Integer underlyingCreditIndexSeries;
		protected String underlierID;
		protected AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		protected Integer underlyingCreditIndexVersion;
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		public Integer getUnderlyingInstrumentIndexTermValue() {
			return underlyingInstrumentIndexTermValue;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@Required
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		public AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit() {
			return underlyingInstrumentIndexTermUnit;
		}
		
		@Override
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlyingCreditIndexVersion")
		public Integer getUnderlyingCreditIndexVersion() {
			return underlyingCreditIndexVersion;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingInstrumentIndexTermValue(Integer _underlyingInstrumentIndexTermValue) {
			this.underlyingInstrumentIndexTermValue = _underlyingInstrumentIndexTermValue == null ? null : _underlyingInstrumentIndexTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlyingCreditIndexSeries")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingCreditIndexSeries(Integer _underlyingCreditIndexSeries) {
			this.underlyingCreditIndexSeries = _underlyingCreditIndexSeries == null ? null : _underlyingCreditIndexSeries;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _underlyingInstrumentIndexTermUnit) {
			this.underlyingInstrumentIndexTermUnit = _underlyingInstrumentIndexTermUnit == null ? null : _underlyingInstrumentIndexTermUnit;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlyingCreditIndexVersion")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder setUnderlyingCreditIndexVersion(Integer _underlyingCreditIndexVersion) {
			this.underlyingCreditIndexVersion = _underlyingCreditIndexVersion == null ? null : _underlyingCreditIndexVersion;
			return this;
		}
		
		@Override
		public AnnaDsbIndexTranche build() {
			return new AnnaDsbIndexTranche.AnnaDsbIndexTrancheImpl(this);
		}
		
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlierIDSource()!=null) return true;
			if (getUnderlyingInstrumentIndexTermValue()!=null) return true;
			if (getUnderlyingCreditIndexSeries()!=null) return true;
			if (getUnderlierID()!=null) return true;
			if (getUnderlyingInstrumentIndexTermUnit()!=null) return true;
			if (getUnderlyingCreditIndexVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder o = (AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermValue(), o.getUnderlyingInstrumentIndexTermValue(), this::setUnderlyingInstrumentIndexTermValue);
			merger.mergeBasic(getUnderlyingCreditIndexSeries(), o.getUnderlyingCreditIndexSeries(), this::setUnderlyingCreditIndexSeries);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			merger.mergeBasic(getUnderlyingInstrumentIndexTermUnit(), o.getUnderlyingInstrumentIndexTermUnit(), this::setUnderlyingInstrumentIndexTermUnit);
			merger.mergeBasic(getUnderlyingCreditIndexVersion(), o.getUnderlyingCreditIndexVersion(), this::setUnderlyingCreditIndexVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbIndexTranche _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermValue, _that.getUnderlyingInstrumentIndexTermValue())) return false;
			if (!Objects.equals(underlyingCreditIndexSeries, _that.getUnderlyingCreditIndexSeries())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(underlyingInstrumentIndexTermUnit, _that.getUnderlyingInstrumentIndexTermUnit())) return false;
			if (!Objects.equals(underlyingCreditIndexVersion, _that.getUnderlyingCreditIndexVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermValue != null ? underlyingInstrumentIndexTermValue.hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexSeries != null ? underlyingCreditIndexSeries.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexTermUnit != null ? underlyingInstrumentIndexTermUnit.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingCreditIndexVersion != null ? underlyingCreditIndexVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbIndexTrancheBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion +
			'}';
		}
	}
}
