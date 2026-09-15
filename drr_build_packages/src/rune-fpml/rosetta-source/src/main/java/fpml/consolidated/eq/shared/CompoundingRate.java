package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.CompoundingRateMeta;
import fpml.consolidated.shared.InterestAccrualsMethod;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a compounding rate. The compounding interest can either point back to the floating rate calculation of interest calculation node on the Interest Leg, or be defined specifically.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a compounding rate. The compounding interest can either point back to the floating rate calculation of interest calculation node on the Interest Leg, or be defined specifically.
 *
 */
@RosettaDataType(value="CompoundingRate", builder=CompoundingRate.CompoundingRateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CompoundingRate", model="fpml", builder=CompoundingRate.CompoundingRateBuilderImpl.class, version="2.1.1")
public interface CompoundingRate extends RosettaModelObject {

	CompoundingRateMeta metaData = new CompoundingRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the floating rate calculation of interest calculation node on the Interest Leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the floating rate calculation of interest calculation node on the Interest Leg.
	 *
	 */
	FloatingRateCalculationReference getInterestLegRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines a specific rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a specific rate.
	 *
	 */
	InterestAccrualsMethod getSpecificRate();

	/*********************** Build Methods  ***********************/
	CompoundingRate build();
	
	CompoundingRate.CompoundingRateBuilder toBuilder();
	
	static CompoundingRate.CompoundingRateBuilder builder() {
		return new CompoundingRate.CompoundingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompoundingRate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CompoundingRate> getType() {
		return CompoundingRate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("interestLegRate"), processor, FloatingRateCalculationReference.class, getInterestLegRate());
		processRosetta(path.newSubPath("specificRate"), processor, InterestAccrualsMethod.class, getSpecificRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompoundingRateBuilder extends CompoundingRate, RosettaModelObjectBuilder {
		FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getOrCreateInterestLegRate();
		@Override
		FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getInterestLegRate();
		InterestAccrualsMethod.InterestAccrualsMethodBuilder getOrCreateSpecificRate();
		@Override
		InterestAccrualsMethod.InterestAccrualsMethodBuilder getSpecificRate();
		CompoundingRate.CompoundingRateBuilder setInterestLegRate(FloatingRateCalculationReference interestLegRate);
		CompoundingRate.CompoundingRateBuilder setSpecificRate(InterestAccrualsMethod specificRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("interestLegRate"), processor, FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder.class, getInterestLegRate());
			processRosetta(path.newSubPath("specificRate"), processor, InterestAccrualsMethod.InterestAccrualsMethodBuilder.class, getSpecificRate());
		}
		

		CompoundingRate.CompoundingRateBuilder prune();
	}

	/*********************** Immutable Implementation of CompoundingRate  ***********************/
	class CompoundingRateImpl implements CompoundingRate {
		private final FloatingRateCalculationReference interestLegRate;
		private final InterestAccrualsMethod specificRate;
		
		protected CompoundingRateImpl(CompoundingRate.CompoundingRateBuilder builder) {
			this.interestLegRate = ofNullable(builder.getInterestLegRate()).map(f->f.build()).orElse(null);
			this.specificRate = ofNullable(builder.getSpecificRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestLegRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegRate")
		public FloatingRateCalculationReference getInterestLegRate() {
			return interestLegRate;
		}
		
		@Override
		@RosettaAttribute("specificRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificRate")
		public InterestAccrualsMethod getSpecificRate() {
			return specificRate;
		}
		
		@Override
		public CompoundingRate build() {
			return this;
		}
		
		@Override
		public CompoundingRate.CompoundingRateBuilder toBuilder() {
			CompoundingRate.CompoundingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompoundingRate.CompoundingRateBuilder builder) {
			ofNullable(getInterestLegRate()).ifPresent(builder::setInterestLegRate);
			ofNullable(getSpecificRate()).ifPresent(builder::setSpecificRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingRate _that = getType().cast(o);
		
			if (!Objects.equals(interestLegRate, _that.getInterestLegRate())) return false;
			if (!Objects.equals(specificRate, _that.getSpecificRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestLegRate != null ? interestLegRate.hashCode() : 0);
			_result = 31 * _result + (specificRate != null ? specificRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingRate {" +
				"interestLegRate=" + this.interestLegRate + ", " +
				"specificRate=" + this.specificRate +
			'}';
		}
	}

	/*********************** Builder Implementation of CompoundingRate  ***********************/
	class CompoundingRateBuilderImpl implements CompoundingRate.CompoundingRateBuilder {
	
		protected FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder interestLegRate;
		protected InterestAccrualsMethod.InterestAccrualsMethodBuilder specificRate;
		
		@Override
		@RosettaAttribute("interestLegRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegRate")
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getInterestLegRate() {
			return interestLegRate;
		}
		
		@Override
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getOrCreateInterestLegRate() {
			FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder result;
			if (interestLegRate!=null) {
				result = interestLegRate;
			}
			else {
				result = interestLegRate = FloatingRateCalculationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specificRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificRate")
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder getSpecificRate() {
			return specificRate;
		}
		
		@Override
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder getOrCreateSpecificRate() {
			InterestAccrualsMethod.InterestAccrualsMethodBuilder result;
			if (specificRate!=null) {
				result = specificRate;
			}
			else {
				result = specificRate = InterestAccrualsMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("interestLegRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestLegRate")
		@Override
		public CompoundingRate.CompoundingRateBuilder setInterestLegRate(FloatingRateCalculationReference _interestLegRate) {
			this.interestLegRate = _interestLegRate == null ? null : _interestLegRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specificRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specificRate")
		@Override
		public CompoundingRate.CompoundingRateBuilder setSpecificRate(InterestAccrualsMethod _specificRate) {
			this.specificRate = _specificRate == null ? null : _specificRate.toBuilder();
			return this;
		}
		
		@Override
		public CompoundingRate build() {
			return new CompoundingRate.CompoundingRateImpl(this);
		}
		
		@Override
		public CompoundingRate.CompoundingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingRate.CompoundingRateBuilder prune() {
			if (interestLegRate!=null && !interestLegRate.prune().hasData()) interestLegRate = null;
			if (specificRate!=null && !specificRate.prune().hasData()) specificRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterestLegRate()!=null && getInterestLegRate().hasData()) return true;
			if (getSpecificRate()!=null && getSpecificRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingRate.CompoundingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompoundingRate.CompoundingRateBuilder o = (CompoundingRate.CompoundingRateBuilder) other;
			
			merger.mergeRosetta(getInterestLegRate(), o.getInterestLegRate(), this::setInterestLegRate);
			merger.mergeRosetta(getSpecificRate(), o.getSpecificRate(), this::setSpecificRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingRate _that = getType().cast(o);
		
			if (!Objects.equals(interestLegRate, _that.getInterestLegRate())) return false;
			if (!Objects.equals(specificRate, _that.getSpecificRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestLegRate != null ? interestLegRate.hashCode() : 0);
			_result = 31 * _result + (specificRate != null ? specificRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingRateBuilder {" +
				"interestLegRate=" + this.interestLegRate + ", " +
				"specificRate=" + this.specificRate +
			'}';
		}
	}
}
