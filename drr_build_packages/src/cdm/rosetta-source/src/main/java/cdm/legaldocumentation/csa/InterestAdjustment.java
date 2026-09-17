package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.InterestAdjustmentMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify whether the Interest Adjustment is applicable and what its periodicity is.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="InterestAdjustment", builder=InterestAdjustment.InterestAdjustmentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="InterestAdjustment", model="cdm", builder=InterestAdjustment.InterestAdjustmentBuilderImpl.class, version="6.23.0")
public interface InterestAdjustment extends RosettaModelObject {

	InterestAdjustmentMeta metaData = new InterestAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Interest Adjustment is applicable when True and not applicable when False.
	 */
	Boolean getIsApplicable();
	/**
	 * The qualification of the Interest Adjustment periodicity.
	 */
	InterestAdjustmentPeriodicity getPeriodicity();

	/*********************** Build Methods  ***********************/
	InterestAdjustment build();
	
	InterestAdjustment.InterestAdjustmentBuilder toBuilder();
	
	static InterestAdjustment.InterestAdjustmentBuilder builder() {
		return new InterestAdjustment.InterestAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestAdjustment> getType() {
		return InterestAdjustment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processRosetta(path.newSubPath("periodicity"), processor, InterestAdjustmentPeriodicity.class, getPeriodicity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAdjustmentBuilder extends InterestAdjustment, RosettaModelObjectBuilder {
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getOrCreatePeriodicity();
		@Override
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getPeriodicity();
		InterestAdjustment.InterestAdjustmentBuilder setIsApplicable(Boolean isApplicable);
		InterestAdjustment.InterestAdjustmentBuilder setPeriodicity(InterestAdjustmentPeriodicity periodicity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processRosetta(path.newSubPath("periodicity"), processor, InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder.class, getPeriodicity());
		}
		

		InterestAdjustment.InterestAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAdjustment  ***********************/
	class InterestAdjustmentImpl implements InterestAdjustment {
		private final Boolean isApplicable;
		private final InterestAdjustmentPeriodicity periodicity;
		
		protected InterestAdjustmentImpl(InterestAdjustment.InterestAdjustmentBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.periodicity = ofNullable(builder.getPeriodicity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("periodicity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("periodicity")
		public InterestAdjustmentPeriodicity getPeriodicity() {
			return periodicity;
		}
		
		@Override
		public InterestAdjustment build() {
			return this;
		}
		
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder toBuilder() {
			InterestAdjustment.InterestAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAdjustment.InterestAdjustmentBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPeriodicity()).ifPresent(builder::setPeriodicity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(periodicity, _that.getPeriodicity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (periodicity != null ? periodicity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustment {" +
				"isApplicable=" + this.isApplicable + ", " +
				"periodicity=" + this.periodicity +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestAdjustment  ***********************/
	class InterestAdjustmentBuilderImpl implements InterestAdjustment.InterestAdjustmentBuilder {
	
		protected Boolean isApplicable;
		protected InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder periodicity;
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("periodicity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("periodicity")
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getPeriodicity() {
			return periodicity;
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder getOrCreatePeriodicity() {
			InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder result;
			if (periodicity!=null) {
				result = periodicity;
			}
			else {
				result = periodicity = InterestAdjustmentPeriodicity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("periodicity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodicity")
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder setPeriodicity(InterestAdjustmentPeriodicity _periodicity) {
			this.periodicity = _periodicity == null ? null : _periodicity.toBuilder();
			return this;
		}
		
		@Override
		public InterestAdjustment build() {
			return new InterestAdjustment.InterestAdjustmentImpl(this);
		}
		
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder prune() {
			if (periodicity!=null && !periodicity.prune().hasData()) periodicity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getPeriodicity()!=null && getPeriodicity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustment.InterestAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAdjustment.InterestAdjustmentBuilder o = (InterestAdjustment.InterestAdjustmentBuilder) other;
			
			merger.mergeRosetta(getPeriodicity(), o.getPeriodicity(), this::setPeriodicity);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(periodicity, _that.getPeriodicity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (periodicity != null ? periodicity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustmentBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"periodicity=" + this.periodicity +
			'}';
		}
	}
}
