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
import fpml.consolidated.fpmlenum.ObservationPeriodDatesEnum;
import fpml.consolidated.shared.meta.ObservationShiftParametersMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Specifies parameters specific to the observation shift method of compounding/averaging.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Specifies parameters specific to the observation shift method of compounding/averaging.
 *
 */
@RosettaDataType(value="ObservationShiftParameters", builder=ObservationShiftParameters.ObservationShiftParametersBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservationShiftParameters", model="fpml", builder=ObservationShiftParameters.ObservationShiftParametersBuilderImpl.class, version="2.1.1")
public interface ObservationShiftParameters extends ObservationOffset {

	ObservationShiftParametersMeta metaData = new ObservationShiftParametersMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies how the observation period is to be determined relative to the basic calculation period. Options include "standard" (observation period aligns with the calculation period except for any shifts/lookbacks/lockouts, i.e. it is set in arrears), "InAdvance" (observation period is based on the prior or deemed prior calculation period plus any shifts), or "FixingDate" (observation period is based on a fixing date defined the the FpML resetDates structure; this is used only for fallback rate definitions that reference existing resetDates structures.).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies how the observation period is to be determined relative to the basic calculation period. Options include "standard" (observation period aligns with the calculation period except for any shifts/lookbacks/lockouts, i.e. it is set in arrears), "InAdvance" (observation period is based on the prior or deemed prior calculation period plus any shifts), or "FixingDate" (observation period is based on a fixing date defined the the FpML resetDates structure; this is used only for fallback rate definitions that reference existing resetDates structures.).
	 *
	 */
	ObservationPeriodDatesEnum getObservationPeriodDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Any additional business centers that are applicable to the observation shift calculation, in addition to the regular "applicableBusinessDays".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Any additional business centers that are applicable to the observation shift calculation, in addition to the regular "applicableBusinessDays".
	 *
	 */
	BusinessCentersOrReference getAdditionalBusinessDays();

	/*********************** Build Methods  ***********************/
	ObservationShiftParameters build();
	
	ObservationShiftParameters.ObservationShiftParametersBuilder toBuilder();
	
	static ObservationShiftParameters.ObservationShiftParametersBuilder builder() {
		return new ObservationShiftParameters.ObservationShiftParametersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationShiftParameters> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationShiftParameters> getType() {
		return ObservationShiftParameters.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("offsetDays"), Integer.class, getOffsetDays(), this);
		processor.processBasic(path.newSubPath("observationPeriodDates"), ObservationPeriodDatesEnum.class, getObservationPeriodDates(), this);
		processRosetta(path.newSubPath("additionalBusinessDays"), processor, BusinessCentersOrReference.class, getAdditionalBusinessDays());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationShiftParametersBuilder extends ObservationShiftParameters, ObservationOffset.ObservationOffsetBuilder {
		BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getOrCreateAdditionalBusinessDays();
		@Override
		BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getAdditionalBusinessDays();
		@Override
		ObservationShiftParameters.ObservationShiftParametersBuilder setOffsetDays(Integer offsetDays);
		ObservationShiftParameters.ObservationShiftParametersBuilder setObservationPeriodDates(ObservationPeriodDatesEnum observationPeriodDates);
		ObservationShiftParameters.ObservationShiftParametersBuilder setAdditionalBusinessDays(BusinessCentersOrReference additionalBusinessDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("offsetDays"), Integer.class, getOffsetDays(), this);
			processor.processBasic(path.newSubPath("observationPeriodDates"), ObservationPeriodDatesEnum.class, getObservationPeriodDates(), this);
			processRosetta(path.newSubPath("additionalBusinessDays"), processor, BusinessCentersOrReference.BusinessCentersOrReferenceBuilder.class, getAdditionalBusinessDays());
		}
		

		ObservationShiftParameters.ObservationShiftParametersBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationShiftParameters  ***********************/
	class ObservationShiftParametersImpl extends ObservationOffset.ObservationOffsetImpl implements ObservationShiftParameters {
		private final ObservationPeriodDatesEnum observationPeriodDates;
		private final BusinessCentersOrReference additionalBusinessDays;
		
		protected ObservationShiftParametersImpl(ObservationShiftParameters.ObservationShiftParametersBuilder builder) {
			super(builder);
			this.observationPeriodDates = builder.getObservationPeriodDates();
			this.additionalBusinessDays = ofNullable(builder.getAdditionalBusinessDays()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("observationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationPeriodDates")
		public ObservationPeriodDatesEnum getObservationPeriodDates() {
			return observationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("additionalBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalBusinessDays")
		public BusinessCentersOrReference getAdditionalBusinessDays() {
			return additionalBusinessDays;
		}
		
		@Override
		public ObservationShiftParameters build() {
			return this;
		}
		
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder toBuilder() {
			ObservationShiftParameters.ObservationShiftParametersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationShiftParameters.ObservationShiftParametersBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getObservationPeriodDates()).ifPresent(builder::setObservationPeriodDates);
			ofNullable(getAdditionalBusinessDays()).ifPresent(builder::setAdditionalBusinessDays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationShiftParameters _that = getType().cast(o);
		
			if (!Objects.equals(observationPeriodDates, _that.getObservationPeriodDates())) return false;
			if (!Objects.equals(additionalBusinessDays, _that.getAdditionalBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (observationPeriodDates != null ? observationPeriodDates.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalBusinessDays != null ? additionalBusinessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationShiftParameters {" +
				"observationPeriodDates=" + this.observationPeriodDates + ", " +
				"additionalBusinessDays=" + this.additionalBusinessDays +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ObservationShiftParameters  ***********************/
	class ObservationShiftParametersBuilderImpl extends ObservationOffset.ObservationOffsetBuilderImpl implements ObservationShiftParameters.ObservationShiftParametersBuilder {
	
		protected ObservationPeriodDatesEnum observationPeriodDates;
		protected BusinessCentersOrReference.BusinessCentersOrReferenceBuilder additionalBusinessDays;
		
		@Override
		@RosettaAttribute("observationPeriodDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationPeriodDates")
		public ObservationPeriodDatesEnum getObservationPeriodDates() {
			return observationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("additionalBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalBusinessDays")
		public BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getAdditionalBusinessDays() {
			return additionalBusinessDays;
		}
		
		@Override
		public BusinessCentersOrReference.BusinessCentersOrReferenceBuilder getOrCreateAdditionalBusinessDays() {
			BusinessCentersOrReference.BusinessCentersOrReferenceBuilder result;
			if (additionalBusinessDays!=null) {
				result = additionalBusinessDays;
			}
			else {
				result = additionalBusinessDays = BusinessCentersOrReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("offsetDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offsetDays")
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder setOffsetDays(Integer _offsetDays) {
			this.offsetDays = _offsetDays == null ? null : _offsetDays;
			return this;
		}
		
		@RosettaAttribute("observationPeriodDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationPeriodDates")
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder setObservationPeriodDates(ObservationPeriodDatesEnum _observationPeriodDates) {
			this.observationPeriodDates = _observationPeriodDates == null ? null : _observationPeriodDates;
			return this;
		}
		
		@RosettaAttribute("additionalBusinessDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalBusinessDays")
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder setAdditionalBusinessDays(BusinessCentersOrReference _additionalBusinessDays) {
			this.additionalBusinessDays = _additionalBusinessDays == null ? null : _additionalBusinessDays.toBuilder();
			return this;
		}
		
		@Override
		public ObservationShiftParameters build() {
			return new ObservationShiftParameters.ObservationShiftParametersImpl(this);
		}
		
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder prune() {
			super.prune();
			if (additionalBusinessDays!=null && !additionalBusinessDays.prune().hasData()) additionalBusinessDays = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getObservationPeriodDates()!=null) return true;
			if (getAdditionalBusinessDays()!=null && getAdditionalBusinessDays().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationShiftParameters.ObservationShiftParametersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ObservationShiftParameters.ObservationShiftParametersBuilder o = (ObservationShiftParameters.ObservationShiftParametersBuilder) other;
			
			merger.mergeRosetta(getAdditionalBusinessDays(), o.getAdditionalBusinessDays(), this::setAdditionalBusinessDays);
			
			merger.mergeBasic(getObservationPeriodDates(), o.getObservationPeriodDates(), this::setObservationPeriodDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ObservationShiftParameters _that = getType().cast(o);
		
			if (!Objects.equals(observationPeriodDates, _that.getObservationPeriodDates())) return false;
			if (!Objects.equals(additionalBusinessDays, _that.getAdditionalBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (observationPeriodDates != null ? observationPeriodDates.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalBusinessDays != null ? additionalBusinessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationShiftParametersBuilder {" +
				"observationPeriodDates=" + this.observationPeriodDates + ", " +
				"additionalBusinessDays=" + this.additionalBusinessDays +
			'}' + " " + super.toString();
		}
	}
}
