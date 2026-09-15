package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FxInformationSourceMeta;
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
@RosettaDataType(value="FxInformationSource", builder=FxInformationSource.FxInformationSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxInformationSource", model="fpml", builder=FxInformationSource.FxInformationSourceBuilderImpl.class, version="2.1.1")
public interface FxInformationSource extends InformationSource {

	FxInformationSourceMeta metaData = new FxInformationSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time that the fixing will be taken along with a business center to define the time zone
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time that the fixing will be taken along with a business center to define the time zone
	 *
	 */
	BusinessCenterTime getFixingTime();

	/*********************** Build Methods  ***********************/
	FxInformationSource build();
	
	FxInformationSource.FxInformationSourceBuilder toBuilder();
	
	static FxInformationSource.FxInformationSourceBuilder builder() {
		return new FxInformationSource.FxInformationSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxInformationSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxInformationSource> getType() {
		return FxInformationSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.class, getRateSource());
		processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.class, getRateSourcePage());
		processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxInformationSourceBuilder extends FxInformationSource, InformationSource.InformationSourceBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		@Override
		FxInformationSource.FxInformationSourceBuilder setRateSource(InformationProvider rateSource);
		@Override
		FxInformationSource.FxInformationSourceBuilder setRateSourcePage(RateSourcePage rateSourcePage);
		@Override
		FxInformationSource.FxInformationSourceBuilder setRateSourcePageHeading(String rateSourcePageHeading);
		FxInformationSource.FxInformationSourceBuilder setFixingTime(BusinessCenterTime fixingTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rateSource"), processor, InformationProvider.InformationProviderBuilder.class, getRateSource());
			processRosetta(path.newSubPath("rateSourcePage"), processor, RateSourcePage.RateSourcePageBuilder.class, getRateSourcePage());
			processor.processBasic(path.newSubPath("rateSourcePageHeading"), String.class, getRateSourcePageHeading(), this);
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
		}
		

		FxInformationSource.FxInformationSourceBuilder prune();
	}

	/*********************** Immutable Implementation of FxInformationSource  ***********************/
	class FxInformationSourceImpl extends InformationSource.InformationSourceImpl implements FxInformationSource {
		private final BusinessCenterTime fixingTime;
		
		protected FxInformationSourceImpl(FxInformationSource.FxInformationSourceBuilder builder) {
			super(builder);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FxInformationSource build() {
			return this;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder toBuilder() {
			FxInformationSource.FxInformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxInformationSource.FxInformationSourceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInformationSource {" +
				"fixingTime=" + this.fixingTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxInformationSource  ***********************/
	class FxInformationSourceBuilderImpl extends InformationSource.InformationSourceBuilderImpl implements FxInformationSource.FxInformationSourceBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		
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
		
		@RosettaAttribute("rateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSource")
		@Override
		public FxInformationSource.FxInformationSourceBuilder setRateSource(InformationProvider _rateSource) {
			this.rateSource = _rateSource == null ? null : _rateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSourcePage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSourcePage")
		@Override
		public FxInformationSource.FxInformationSourceBuilder setRateSourcePage(RateSourcePage _rateSourcePage) {
			this.rateSourcePage = _rateSourcePage == null ? null : _rateSourcePage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rateSourcePageHeading")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rateSourcePageHeading")
		@Override
		public FxInformationSource.FxInformationSourceBuilder setRateSourcePageHeading(String _rateSourcePageHeading) {
			this.rateSourcePageHeading = _rateSourcePageHeading == null ? null : _rateSourcePageHeading;
			return this;
		}
		
		@RosettaAttribute("fixingTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixingTime")
		@Override
		public FxInformationSource.FxInformationSourceBuilder setFixingTime(BusinessCenterTime _fixingTime) {
			this.fixingTime = _fixingTime == null ? null : _fixingTime.toBuilder();
			return this;
		}
		
		@Override
		public FxInformationSource build() {
			return new FxInformationSource.FxInformationSourceImpl(this);
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInformationSource.FxInformationSourceBuilder prune() {
			super.prune();
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInformationSource.FxInformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxInformationSource.FxInformationSourceBuilder o = (FxInformationSource.FxInformationSourceBuilder) other;
			
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInformationSourceBuilder {" +
				"fixingTime=" + this.fixingTime +
			'}' + " " + super.toString();
		}
	}
}
