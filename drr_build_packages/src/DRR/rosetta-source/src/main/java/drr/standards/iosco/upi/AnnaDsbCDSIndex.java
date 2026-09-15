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
import drr.standards.iosco.upi.meta.AnnaDsbCDSIndexMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbCDSIndex", builder=AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbCDSIndex", model="drr", builder=AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilderImpl.class, version="7.7.0")
public interface AnnaDsbCDSIndex extends RosettaModelObject {

	AnnaDsbCDSIndexMeta metaData = new AnnaDsbCDSIndexMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	Integer getUnderlyingInstrumentIndexTermValue();
	Integer getUnderlyingCreditIndexSeries();
	String getUnderlierID();
	AnnaDsbUnderlyingInstrumentIndexTermUnitEnum getUnderlyingInstrumentIndexTermUnit();
	Integer getUnderlyingCreditIndexVersion();

	/*********************** Build Methods  ***********************/
	AnnaDsbCDSIndex build();
	
	AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder toBuilder();
	
	static AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder builder() {
		return new AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbCDSIndex> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbCDSIndex> getType() {
		return AnnaDsbCDSIndex.class;
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
	interface AnnaDsbCDSIndexBuilder extends AnnaDsbCDSIndex, RosettaModelObjectBuilder {
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingInstrumentIndexTermValue(Integer UnderlyingInstrumentIndexTermValue);
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingCreditIndexSeries(Integer UnderlyingCreditIndexSeries);
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlierID(String UnderlierID);
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum UnderlyingInstrumentIndexTermUnit);
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingCreditIndexVersion(Integer UnderlyingCreditIndexVersion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermValue"), Integer.class, getUnderlyingInstrumentIndexTermValue(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexSeries"), Integer.class, getUnderlyingCreditIndexSeries(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexTermUnit"), AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.class, getUnderlyingInstrumentIndexTermUnit(), this);
			processor.processBasic(path.newSubPath("UnderlyingCreditIndexVersion"), Integer.class, getUnderlyingCreditIndexVersion(), this);
		}
		

		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbCDSIndex  ***********************/
	class AnnaDsbCDSIndexImpl implements AnnaDsbCDSIndex {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final Integer underlyingInstrumentIndexTermValue;
		private final Integer underlyingCreditIndexSeries;
		private final String underlierID;
		private final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum underlyingInstrumentIndexTermUnit;
		private final Integer underlyingCreditIndexVersion;
		
		protected AnnaDsbCDSIndexImpl(AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder builder) {
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
		public AnnaDsbCDSIndex build() {
			return this;
		}
		
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder toBuilder() {
			AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder builder) {
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
		
			AnnaDsbCDSIndex _that = getType().cast(o);
		
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
			return "AnnaDsbCDSIndex {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlyingInstrumentIndexTermValue=" + this.underlyingInstrumentIndexTermValue + ", " +
				"UnderlyingCreditIndexSeries=" + this.underlyingCreditIndexSeries + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"UnderlyingInstrumentIndexTermUnit=" + this.underlyingInstrumentIndexTermUnit + ", " +
				"UnderlyingCreditIndexVersion=" + this.underlyingCreditIndexVersion +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbCDSIndex  ***********************/
	class AnnaDsbCDSIndexBuilderImpl implements AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder {
	
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
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermValue")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingInstrumentIndexTermValue(Integer _underlyingInstrumentIndexTermValue) {
			this.underlyingInstrumentIndexTermValue = _underlyingInstrumentIndexTermValue == null ? null : _underlyingInstrumentIndexTermValue;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexSeries")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexSeries")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingCreditIndexSeries(Integer _underlyingCreditIndexSeries) {
			this.underlyingCreditIndexSeries = _underlyingCreditIndexSeries == null ? null : _underlyingCreditIndexSeries;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexTermUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexTermUnit")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingInstrumentIndexTermUnit(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum _underlyingInstrumentIndexTermUnit) {
			this.underlyingInstrumentIndexTermUnit = _underlyingInstrumentIndexTermUnit == null ? null : _underlyingInstrumentIndexTermUnit;
			return this;
		}
		
		@RosettaAttribute("UnderlyingCreditIndexVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingCreditIndexVersion")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder setUnderlyingCreditIndexVersion(Integer _underlyingCreditIndexVersion) {
			this.underlyingCreditIndexVersion = _underlyingCreditIndexVersion == null ? null : _underlyingCreditIndexVersion;
			return this;
		}
		
		@Override
		public AnnaDsbCDSIndex build() {
			return new AnnaDsbCDSIndex.AnnaDsbCDSIndexImpl(this);
		}
		
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder prune() {
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
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder o = (AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder) other;
			
			
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
		
			AnnaDsbCDSIndex _that = getType().cast(o);
		
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
			return "AnnaDsbCDSIndexBuilder {" +
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
