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
import fpml.consolidated.generic.meta.GenericFrequencyMeta;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.PartyReference;
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
@RosettaDataType(value="GenericFrequency", builder=GenericFrequency.GenericFrequencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericFrequency", model="fpml", builder=GenericFrequency.GenericFrequencyBuilderImpl.class, version="2.1.1")
public interface GenericFrequency extends Frequency {

	GenericFrequencyMeta metaData = new GenericFrequencyMeta();

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
	PartyReference getPayerPartyReference();
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
	GenericFrequency build();
	
	GenericFrequency.GenericFrequencyBuilder toBuilder();
	
	static GenericFrequency.GenericFrequencyBuilder builder() {
		return new GenericFrequency.GenericFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericFrequency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericFrequency> getType() {
		return GenericFrequency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.class, getUnderlyerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericFrequencyBuilder extends GenericFrequency, Frequency.FrequencyBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference();
		@Override
		UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference();
		@Override
		GenericFrequency.GenericFrequencyBuilder setId(String id);
		@Override
		GenericFrequency.GenericFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		GenericFrequency.GenericFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		GenericFrequency.GenericFrequencyBuilder setPayerPartyReference(PartyReference payerPartyReference);
		GenericFrequency.GenericFrequencyBuilder setUnderlyerReference(UnderlyerReference underlyerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.UnderlyerReferenceBuilder.class, getUnderlyerReference());
		}
		

		GenericFrequency.GenericFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of GenericFrequency  ***********************/
	class GenericFrequencyImpl extends Frequency.FrequencyImpl implements GenericFrequency {
		private final PartyReference payerPartyReference;
		private final UnderlyerReference underlyerReference;
		
		protected GenericFrequencyImpl(GenericFrequency.GenericFrequencyBuilder builder) {
			super(builder);
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyerReference")
		public UnderlyerReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public GenericFrequency build() {
			return this;
		}
		
		@Override
		public GenericFrequency.GenericFrequencyBuilder toBuilder() {
			GenericFrequency.GenericFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericFrequency.GenericFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericFrequency _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericFrequency {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericFrequency  ***********************/
	class GenericFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl implements GenericFrequency.GenericFrequencyBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected UnderlyerReference.UnderlyerReferenceBuilder underlyerReference;
		
		@Override
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
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
		public GenericFrequency.GenericFrequencyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodMultiplier")
		@Override
		public GenericFrequency.GenericFrequencyBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("period")
		@Override
		public GenericFrequency.GenericFrequencyBuilder setPeriod(PeriodExtendedEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerPartyReference")
		@Override
		public GenericFrequency.GenericFrequencyBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyerReference")
		@Override
		public GenericFrequency.GenericFrequencyBuilder setUnderlyerReference(UnderlyerReference _underlyerReference) {
			this.underlyerReference = _underlyerReference == null ? null : _underlyerReference.toBuilder();
			return this;
		}
		
		@Override
		public GenericFrequency build() {
			return new GenericFrequency.GenericFrequencyImpl(this);
		}
		
		@Override
		public GenericFrequency.GenericFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericFrequency.GenericFrequencyBuilder prune() {
			super.prune();
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericFrequency.GenericFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GenericFrequency.GenericFrequencyBuilder o = (GenericFrequency.GenericFrequencyBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericFrequency _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericFrequencyBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}
}
