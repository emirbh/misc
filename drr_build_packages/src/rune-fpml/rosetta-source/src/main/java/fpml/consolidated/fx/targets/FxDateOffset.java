package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fpmlenum.FxOffsetConventionEnum;
import fpml.consolidated.fx.targets.meta.FxDateOffsetMeta;
import fpml.consolidated.shared.Period;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The representation of the schedule as an offset relative to another schedule. For example, the settlement schedule may be relative to the expiry schedule by an FxForward offset.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The representation of the schedule as an offset relative to another schedule. For example, the settlement schedule may be relative to the expiry schedule by an FxForward offset.
 *
 */
@RosettaDataType(value="FxDateOffset", builder=FxDateOffset.FxDateOffsetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxDateOffset", model="fpml", builder=FxDateOffset.FxDateOffsetBuilderImpl.class, version="2.1.1")
public interface FxDateOffset extends RosettaModelObject {

	FxDateOffsetMeta metaData = new FxDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The FX Offset Convention can be FxSpot or FxForward.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The FX Offset Convention can be FxSpot or FxForward.
	 *
	 */
	FxOffsetConventionEnum getConvention();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The settlement offset to the expiry schedule or the expiry offset to the settlement schedule. It is only specified when the settlement convention is FxForward.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The settlement offset to the expiry schedule or the expiry offset to the settlement schedule. It is only specified when the settlement convention is FxForward.
	 *
	 */
	Period getOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether the settlement schedule is relative to the expiry schedule or the expiry schedule is relative to the settlement schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the settlement schedule is relative to the expiry schedule or the expiry schedule is relative to the settlement schedule.
	 *
	 */
	FxScheduleReference getRelativeTo();

	/*********************** Build Methods  ***********************/
	FxDateOffset build();
	
	FxDateOffset.FxDateOffsetBuilder toBuilder();
	
	static FxDateOffset.FxDateOffsetBuilder builder() {
		return new FxDateOffset.FxDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDateOffset> getType() {
		return FxDateOffset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("convention"), FxOffsetConventionEnum.class, getConvention(), this);
		processRosetta(path.newSubPath("offset"), processor, Period.class, getOffset());
		processRosetta(path.newSubPath("relativeTo"), processor, FxScheduleReference.class, getRelativeTo());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDateOffsetBuilder extends FxDateOffset, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateOffset();
		@Override
		Period.PeriodBuilder getOffset();
		FxScheduleReference.FxScheduleReferenceBuilder getOrCreateRelativeTo();
		@Override
		FxScheduleReference.FxScheduleReferenceBuilder getRelativeTo();
		FxDateOffset.FxDateOffsetBuilder setConvention(FxOffsetConventionEnum convention);
		FxDateOffset.FxDateOffsetBuilder setOffset(Period offset);
		FxDateOffset.FxDateOffsetBuilder setRelativeTo(FxScheduleReference relativeTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("convention"), FxOffsetConventionEnum.class, getConvention(), this);
			processRosetta(path.newSubPath("offset"), processor, Period.PeriodBuilder.class, getOffset());
			processRosetta(path.newSubPath("relativeTo"), processor, FxScheduleReference.FxScheduleReferenceBuilder.class, getRelativeTo());
		}
		

		FxDateOffset.FxDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of FxDateOffset  ***********************/
	class FxDateOffsetImpl implements FxDateOffset {
		private final FxOffsetConventionEnum convention;
		private final Period offset;
		private final FxScheduleReference relativeTo;
		
		protected FxDateOffsetImpl(FxDateOffset.FxDateOffsetBuilder builder) {
			this.convention = builder.getConvention();
			this.offset = ofNullable(builder.getOffset()).map(f->f.build()).orElse(null);
			this.relativeTo = ofNullable(builder.getRelativeTo()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("convention")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("convention")
		public FxOffsetConventionEnum getConvention() {
			return convention;
		}
		
		@Override
		@RosettaAttribute("offset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offset")
		public Period getOffset() {
			return offset;
		}
		
		@Override
		@RosettaAttribute("relativeTo")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("relativeTo")
		public FxScheduleReference getRelativeTo() {
			return relativeTo;
		}
		
		@Override
		public FxDateOffset build() {
			return this;
		}
		
		@Override
		public FxDateOffset.FxDateOffsetBuilder toBuilder() {
			FxDateOffset.FxDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDateOffset.FxDateOffsetBuilder builder) {
			ofNullable(getConvention()).ifPresent(builder::setConvention);
			ofNullable(getOffset()).ifPresent(builder::setOffset);
			ofNullable(getRelativeTo()).ifPresent(builder::setRelativeTo);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(convention, _that.getConvention())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			if (!Objects.equals(relativeTo, _that.getRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (convention != null ? convention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			_result = 31 * _result + (relativeTo != null ? relativeTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDateOffset {" +
				"convention=" + this.convention + ", " +
				"offset=" + this.offset + ", " +
				"relativeTo=" + this.relativeTo +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDateOffset  ***********************/
	class FxDateOffsetBuilderImpl implements FxDateOffset.FxDateOffsetBuilder {
	
		protected FxOffsetConventionEnum convention;
		protected Period.PeriodBuilder offset;
		protected FxScheduleReference.FxScheduleReferenceBuilder relativeTo;
		
		@Override
		@RosettaAttribute("convention")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("convention")
		public FxOffsetConventionEnum getConvention() {
			return convention;
		}
		
		@Override
		@RosettaAttribute("offset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offset")
		public Period.PeriodBuilder getOffset() {
			return offset;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateOffset() {
			Period.PeriodBuilder result;
			if (offset!=null) {
				result = offset;
			}
			else {
				result = offset = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeTo")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("relativeTo")
		public FxScheduleReference.FxScheduleReferenceBuilder getRelativeTo() {
			return relativeTo;
		}
		
		@Override
		public FxScheduleReference.FxScheduleReferenceBuilder getOrCreateRelativeTo() {
			FxScheduleReference.FxScheduleReferenceBuilder result;
			if (relativeTo!=null) {
				result = relativeTo;
			}
			else {
				result = relativeTo = FxScheduleReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("convention")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("convention")
		@Override
		public FxDateOffset.FxDateOffsetBuilder setConvention(FxOffsetConventionEnum _convention) {
			this.convention = _convention == null ? null : _convention;
			return this;
		}
		
		@RosettaAttribute("offset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offset")
		@Override
		public FxDateOffset.FxDateOffsetBuilder setOffset(Period _offset) {
			this.offset = _offset == null ? null : _offset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeTo")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("relativeTo")
		@Override
		public FxDateOffset.FxDateOffsetBuilder setRelativeTo(FxScheduleReference _relativeTo) {
			this.relativeTo = _relativeTo == null ? null : _relativeTo.toBuilder();
			return this;
		}
		
		@Override
		public FxDateOffset build() {
			return new FxDateOffset.FxDateOffsetImpl(this);
		}
		
		@Override
		public FxDateOffset.FxDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDateOffset.FxDateOffsetBuilder prune() {
			if (offset!=null && !offset.prune().hasData()) offset = null;
			if (relativeTo!=null && !relativeTo.prune().hasData()) relativeTo = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConvention()!=null) return true;
			if (getOffset()!=null && getOffset().hasData()) return true;
			if (getRelativeTo()!=null && getRelativeTo().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDateOffset.FxDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDateOffset.FxDateOffsetBuilder o = (FxDateOffset.FxDateOffsetBuilder) other;
			
			merger.mergeRosetta(getOffset(), o.getOffset(), this::setOffset);
			merger.mergeRosetta(getRelativeTo(), o.getRelativeTo(), this::setRelativeTo);
			
			merger.mergeBasic(getConvention(), o.getConvention(), this::setConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(convention, _that.getConvention())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			if (!Objects.equals(relativeTo, _that.getRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (convention != null ? convention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			_result = 31 * _result + (relativeTo != null ? relativeTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDateOffsetBuilder {" +
				"convention=" + this.convention + ", " +
				"offset=" + this.offset + ", " +
				"relativeTo=" + this.relativeTo +
			'}';
		}
	}
}
