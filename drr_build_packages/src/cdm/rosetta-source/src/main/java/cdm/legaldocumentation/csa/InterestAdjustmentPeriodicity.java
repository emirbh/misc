package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.InterestAdjustmentPeriodicityMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Interest Adjustment periodicity.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="InterestAdjustmentPeriodicity", builder=InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="InterestAdjustmentPeriodicity", model="cdm", builder=InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilderImpl.class, version="6.23.0")
public interface InterestAdjustmentPeriodicity extends RosettaModelObject {

	InterestAdjustmentPeriodicityMeta metaData = new InterestAdjustmentPeriodicityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Interest Adjustment periodicity when specified through a standardized election.
	 */
	InterestAdjustmentPeriodicityEnum getStandardElection();
	/**
	 * The Interest Adjustment periodicity when specified through a custom election.
	 */
	String getCustomElection();

	/*********************** Build Methods  ***********************/
	InterestAdjustmentPeriodicity build();
	
	InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder toBuilder();
	
	static InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder() {
		return new InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAdjustmentPeriodicity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestAdjustmentPeriodicity> getType() {
		return InterestAdjustmentPeriodicity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardElection"), InterestAdjustmentPeriodicityEnum.class, getStandardElection(), this);
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAdjustmentPeriodicityBuilder extends InterestAdjustmentPeriodicity, RosettaModelObjectBuilder {
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setStandardElection(InterestAdjustmentPeriodicityEnum standardElection);
		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setCustomElection(String customElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardElection"), InterestAdjustmentPeriodicityEnum.class, getStandardElection(), this);
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		}
		

		InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAdjustmentPeriodicity  ***********************/
	class InterestAdjustmentPeriodicityImpl implements InterestAdjustmentPeriodicity {
		private final InterestAdjustmentPeriodicityEnum standardElection;
		private final String customElection;
		
		protected InterestAdjustmentPeriodicityImpl(InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder) {
			this.standardElection = builder.getStandardElection();
			this.customElection = builder.getCustomElection();
		}
		
		@Override
		@RosettaAttribute("standardElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardElection")
		public InterestAdjustmentPeriodicityEnum getStandardElection() {
			return standardElection;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public InterestAdjustmentPeriodicity build() {
			return this;
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder toBuilder() {
			InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder builder) {
			ofNullable(getStandardElection()).ifPresent(builder::setStandardElection);
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustmentPeriodicity _that = getType().cast(o);
		
			if (!Objects.equals(standardElection, _that.getStandardElection())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardElection != null ? standardElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustmentPeriodicity {" +
				"standardElection=" + this.standardElection + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestAdjustmentPeriodicity  ***********************/
	class InterestAdjustmentPeriodicityBuilderImpl implements InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder {
	
		protected InterestAdjustmentPeriodicityEnum standardElection;
		protected String customElection;
		
		@Override
		@RosettaAttribute("standardElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardElection")
		public InterestAdjustmentPeriodicityEnum getStandardElection() {
			return standardElection;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@RosettaAttribute("standardElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("standardElection")
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setStandardElection(InterestAdjustmentPeriodicityEnum _standardElection) {
			this.standardElection = _standardElection == null ? null : _standardElection;
			return this;
		}
		
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customElection")
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder setCustomElection(String _customElection) {
			this.customElection = _customElection == null ? null : _customElection;
			return this;
		}
		
		@Override
		public InterestAdjustmentPeriodicity build() {
			return new InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityImpl(this);
		}
		
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardElection()!=null) return true;
			if (getCustomElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder o = (InterestAdjustmentPeriodicity.InterestAdjustmentPeriodicityBuilder) other;
			
			
			merger.mergeBasic(getStandardElection(), o.getStandardElection(), this::setStandardElection);
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAdjustmentPeriodicity _that = getType().cast(o);
		
			if (!Objects.equals(standardElection, _that.getStandardElection())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardElection != null ? standardElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAdjustmentPeriodicityBuilder {" +
				"standardElection=" + this.standardElection + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}
}
