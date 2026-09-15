package fpml.consolidated.generic;

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
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.generic.meta.GenericResetFrequencyMeta;
import fpml.consolidated.shared.Frequency;
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
@RosettaDataType(value="GenericResetFrequency", builder=GenericResetFrequency.GenericResetFrequencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericResetFrequency", model="fpml", builder=GenericResetFrequency.GenericResetFrequencyBuilderImpl.class, version="2.1.1")
public interface GenericResetFrequency extends Frequency {

	GenericResetFrequencyMeta metaData = new GenericResetFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	UnderlyerReference getUnderlyerReference();

	/*********************** Build Methods  ***********************/
	GenericResetFrequency build();
	
	GenericResetFrequency.GenericResetFrequencyBuilder toBuilder();
	
	static GenericResetFrequency.GenericResetFrequencyBuilder builder() {
		return new GenericResetFrequency.GenericResetFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericResetFrequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericResetFrequency> getType() {
		return GenericResetFrequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.class, getUnderlyerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericResetFrequencyBuilder extends GenericResetFrequency, Frequency.FrequencyBuilder {
		UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference();
		@Override
		UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference();
		@Override
		GenericResetFrequency.GenericResetFrequencyBuilder setId(String id);
		@Override
		GenericResetFrequency.GenericResetFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		GenericResetFrequency.GenericResetFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		GenericResetFrequency.GenericResetFrequencyBuilder setUnderlyerReference(UnderlyerReference underlyerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.UnderlyerReferenceBuilder.class, getUnderlyerReference());
		}
		

		GenericResetFrequency.GenericResetFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of GenericResetFrequency  ***********************/
	class GenericResetFrequencyImpl extends Frequency.FrequencyImpl implements GenericResetFrequency {
		private final UnderlyerReference underlyerReference;
		
		protected GenericResetFrequencyImpl(GenericResetFrequency.GenericResetFrequencyBuilder builder) {
			super(builder);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public UnderlyerReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public GenericResetFrequency build() {
			return this;
		}
		
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder toBuilder() {
			GenericResetFrequency.GenericResetFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericResetFrequency.GenericResetFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericResetFrequency {" +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericResetFrequency  ***********************/
	class GenericResetFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl implements GenericResetFrequency.GenericResetFrequencyBuilder {
	
		protected UnderlyerReference.UnderlyerReferenceBuilder underlyerReference;
		
		@Override
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference() {
			UnderlyerReference.UnderlyerReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = UnderlyerReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodMultiplier")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("period")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder setPeriod(PeriodExtendedEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerReference")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder setUnderlyerReference(UnderlyerReference _underlyerReference) {
			this.underlyerReference = _underlyerReference == null ? null : _underlyerReference.toBuilder();
			return this;
		}
		
		@Override
		public GenericResetFrequency build() {
			return new GenericResetFrequency.GenericResetFrequencyImpl(this);
		}
		
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder prune() {
			super.prune();
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GenericResetFrequency.GenericResetFrequencyBuilder o = (GenericResetFrequency.GenericResetFrequencyBuilder) other;
			
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericResetFrequencyBuilder {" +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}
}
