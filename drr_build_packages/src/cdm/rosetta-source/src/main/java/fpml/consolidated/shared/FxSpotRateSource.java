package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FxSpotRateSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the rate source and fixing time for an fx rate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the rate source and fixing time for an fx rate.
 *
 */
@RosettaDataType(value="FxSpotRateSource", builder=FxSpotRateSource.FxSpotRateSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxSpotRateSource", model="fpml", builder=FxSpotRateSource.FxSpotRateSourceBuilderImpl.class, version="2.1.1")
public interface FxSpotRateSource extends RosettaModelObject {

	FxSpotRateSourceMeta metaData = new FxSpotRateSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 */
	InformationSource getPrimaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 *
	 */
	InformationSource getSecondaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 *
	 */
	BusinessCenterTime getFixingTime();

	/*********************** Build Methods  ***********************/
	FxSpotRateSource build();
	
	FxSpotRateSource.FxSpotRateSourceBuilder toBuilder();
	
	static FxSpotRateSource.FxSpotRateSourceBuilder builder() {
		return new FxSpotRateSource.FxSpotRateSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSpotRateSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxSpotRateSource> getType() {
		return FxSpotRateSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSpotRateSourceBuilder extends FxSpotRateSource, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		@Override
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		@Override
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxSpotRateSource.FxSpotRateSourceBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		FxSpotRateSource.FxSpotRateSourceBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		FxSpotRateSource.FxSpotRateSourceBuilder setFixingTime(BusinessCenterTime fixingTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
		}
		

		FxSpotRateSource.FxSpotRateSourceBuilder prune();
	}

	/*********************** Immutable Implementation of FxSpotRateSource  ***********************/
	class FxSpotRateSourceImpl implements FxSpotRateSource {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		private final BusinessCenterTime fixingTime;
		
		protected FxSpotRateSourceImpl(FxSpotRateSource.FxSpotRateSourceBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("primaryRateSource")
		public InformationSource getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryRateSource")
		public InformationSource getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FxSpotRateSource build() {
			return this;
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder toBuilder() {
			FxSpotRateSource.FxSpotRateSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSpotRateSource.FxSpotRateSourceBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSpotRateSource _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSpotRateSource {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSpotRateSource  ***********************/
	class FxSpotRateSourceBuilderImpl implements FxSpotRateSource.FxSpotRateSourceBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("primaryRateSource")
		public InformationSource.InformationSourceBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryRateSource")
		public InformationSource.InformationSourceBuilder getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryRateSource!=null) {
				result = secondaryRateSource;
			}
			else {
				result = secondaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("primaryRateSource")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder setPrimaryRateSource(InformationSource _primaryRateSource) {
			this.primaryRateSource = _primaryRateSource == null ? null : _primaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryRateSource")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder setSecondaryRateSource(InformationSource _secondaryRateSource) {
			this.secondaryRateSource = _secondaryRateSource == null ? null : _secondaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder setFixingTime(BusinessCenterTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@Override
		public FxSpotRateSource build() {
			return new FxSpotRateSource.FxSpotRateSourceImpl(this);
		}
		
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSpotRateSource.FxSpotRateSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSpotRateSource.FxSpotRateSourceBuilder o = (FxSpotRateSource.FxSpotRateSourceBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSpotRateSource _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSpotRateSourceBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime +
			'}';
		}
	}
}
