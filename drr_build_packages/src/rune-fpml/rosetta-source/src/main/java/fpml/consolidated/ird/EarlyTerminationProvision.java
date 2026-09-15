package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.EarlyTerminationProvisionMeta;
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
 * Provision A type defining an early termination provision for a swap. This early termination is at fair value, i.e. on termination the fair value of the product must be settled between the parties.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining an early termination provision for a swap. This early termination is at fair value, i.e. on termination the fair value of the product must be settled between the parties.
 *
 */
@RosettaDataType(value="EarlyTerminationProvision", builder=EarlyTerminationProvision.EarlyTerminationProvisionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EarlyTerminationProvision", model="fpml", builder=EarlyTerminationProvision.EarlyTerminationProvisionBuilderImpl.class, version="2.1.1")
public interface EarlyTerminationProvision extends RosettaModelObject {

	EarlyTerminationProvisionMeta metaData = new EarlyTerminationProvisionMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A mandatory early termination provision to terminate the swap at fair value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A mandatory early termination provision to terminate the swap at fair value.
	 *
	 */
	MandatoryEarlyTermination getMandatoryEarlyTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Period after trade date of the mandatory early termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Period after trade date of the mandatory early termination date.
	 *
	 */
	Period getMandatoryEarlyTerminationDateTenor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An option for either or both parties to terminate the swap at fair value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An option for either or both parties to terminate the swap at fair value.
	 *
	 */
	OptionalEarlyTermination getOptionalEarlyTermination();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Definition of the first early termination date and the frequency of the termination dates subsequent to that. American exercise is defined by having a frequency of one day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Definition of the first early termination date and the frequency of the termination dates subsequent to that. American exercise is defined by having a frequency of one day.
	 *
	 */
	ExercisePeriod getOptionalEarlyTerminationParameters();

	/*********************** Build Methods  ***********************/
	EarlyTerminationProvision build();
	
	EarlyTerminationProvision.EarlyTerminationProvisionBuilder toBuilder();
	
	static EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder() {
		return new EarlyTerminationProvision.EarlyTerminationProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EarlyTerminationProvision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EarlyTerminationProvision> getType() {
		return EarlyTerminationProvision.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("mandatoryEarlyTermination"), processor, MandatoryEarlyTermination.class, getMandatoryEarlyTermination());
		processRosetta(path.newSubPath("mandatoryEarlyTerminationDateTenor"), processor, Period.class, getMandatoryEarlyTerminationDateTenor());
		processRosetta(path.newSubPath("optionalEarlyTermination"), processor, OptionalEarlyTermination.class, getOptionalEarlyTermination());
		processRosetta(path.newSubPath("optionalEarlyTerminationParameters"), processor, ExercisePeriod.class, getOptionalEarlyTerminationParameters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EarlyTerminationProvisionBuilder extends EarlyTerminationProvision, RosettaModelObjectBuilder {
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getOrCreateMandatoryEarlyTermination();
		@Override
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getMandatoryEarlyTermination();
		Period.PeriodBuilder getOrCreateMandatoryEarlyTerminationDateTenor();
		@Override
		Period.PeriodBuilder getMandatoryEarlyTerminationDateTenor();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOrCreateOptionalEarlyTermination();
		@Override
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOptionalEarlyTermination();
		ExercisePeriod.ExercisePeriodBuilder getOrCreateOptionalEarlyTerminationParameters();
		@Override
		ExercisePeriod.ExercisePeriodBuilder getOptionalEarlyTerminationParameters();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setId(String id);
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setMandatoryEarlyTermination(MandatoryEarlyTermination mandatoryEarlyTermination);
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setMandatoryEarlyTerminationDateTenor(Period mandatoryEarlyTerminationDateTenor);
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setOptionalEarlyTermination(OptionalEarlyTermination optionalEarlyTermination);
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setOptionalEarlyTerminationParameters(ExercisePeriod optionalEarlyTerminationParameters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("mandatoryEarlyTermination"), processor, MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder.class, getMandatoryEarlyTermination());
			processRosetta(path.newSubPath("mandatoryEarlyTerminationDateTenor"), processor, Period.PeriodBuilder.class, getMandatoryEarlyTerminationDateTenor());
			processRosetta(path.newSubPath("optionalEarlyTermination"), processor, OptionalEarlyTermination.OptionalEarlyTerminationBuilder.class, getOptionalEarlyTermination());
			processRosetta(path.newSubPath("optionalEarlyTerminationParameters"), processor, ExercisePeriod.ExercisePeriodBuilder.class, getOptionalEarlyTerminationParameters());
		}
		

		EarlyTerminationProvision.EarlyTerminationProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of EarlyTerminationProvision  ***********************/
	class EarlyTerminationProvisionImpl implements EarlyTerminationProvision {
		private final String id;
		private final MandatoryEarlyTermination mandatoryEarlyTermination;
		private final Period mandatoryEarlyTerminationDateTenor;
		private final OptionalEarlyTermination optionalEarlyTermination;
		private final ExercisePeriod optionalEarlyTerminationParameters;
		
		protected EarlyTerminationProvisionImpl(EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder) {
			this.id = builder.getId();
			this.mandatoryEarlyTermination = ofNullable(builder.getMandatoryEarlyTermination()).map(f->f.build()).orElse(null);
			this.mandatoryEarlyTerminationDateTenor = ofNullable(builder.getMandatoryEarlyTerminationDateTenor()).map(f->f.build()).orElse(null);
			this.optionalEarlyTermination = ofNullable(builder.getOptionalEarlyTermination()).map(f->f.build()).orElse(null);
			this.optionalEarlyTerminationParameters = ofNullable(builder.getOptionalEarlyTerminationParameters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTermination getMandatoryEarlyTermination() {
			return mandatoryEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDateTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTerminationDateTenor")
		public Period getMandatoryEarlyTerminationDateTenor() {
			return mandatoryEarlyTerminationDateTenor;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTermination")
		public OptionalEarlyTermination getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTerminationParameters")
		public ExercisePeriod getOptionalEarlyTerminationParameters() {
			return optionalEarlyTerminationParameters;
		}
		
		@Override
		public EarlyTerminationProvision build() {
			return this;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder toBuilder() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getMandatoryEarlyTermination()).ifPresent(builder::setMandatoryEarlyTermination);
			ofNullable(getMandatoryEarlyTerminationDateTenor()).ifPresent(builder::setMandatoryEarlyTerminationDateTenor);
			ofNullable(getOptionalEarlyTermination()).ifPresent(builder::setOptionalEarlyTermination);
			ofNullable(getOptionalEarlyTerminationParameters()).ifPresent(builder::setOptionalEarlyTerminationParameters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationProvision _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mandatoryEarlyTermination, _that.getMandatoryEarlyTermination())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationDateTenor, _that.getMandatoryEarlyTerminationDateTenor())) return false;
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationParameters, _that.getOptionalEarlyTerminationParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTermination != null ? mandatoryEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationDateTenor != null ? mandatoryEarlyTerminationDateTenor.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationParameters != null ? optionalEarlyTerminationParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationProvision {" +
				"id=" + this.id + ", " +
				"mandatoryEarlyTermination=" + this.mandatoryEarlyTermination + ", " +
				"mandatoryEarlyTerminationDateTenor=" + this.mandatoryEarlyTerminationDateTenor + ", " +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationParameters=" + this.optionalEarlyTerminationParameters +
			'}';
		}
	}

	/*********************** Builder Implementation of EarlyTerminationProvision  ***********************/
	class EarlyTerminationProvisionBuilderImpl implements EarlyTerminationProvision.EarlyTerminationProvisionBuilder {
	
		protected String id;
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination;
		protected Period.PeriodBuilder mandatoryEarlyTerminationDateTenor;
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination;
		protected ExercisePeriod.ExercisePeriodBuilder optionalEarlyTerminationParameters;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getMandatoryEarlyTermination() {
			return mandatoryEarlyTermination;
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getOrCreateMandatoryEarlyTermination() {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder result;
			if (mandatoryEarlyTermination!=null) {
				result = mandatoryEarlyTermination;
			}
			else {
				result = mandatoryEarlyTermination = MandatoryEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDateTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTerminationDateTenor")
		public Period.PeriodBuilder getMandatoryEarlyTerminationDateTenor() {
			return mandatoryEarlyTerminationDateTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateMandatoryEarlyTerminationDateTenor() {
			Period.PeriodBuilder result;
			if (mandatoryEarlyTerminationDateTenor!=null) {
				result = mandatoryEarlyTerminationDateTenor;
			}
			else {
				result = mandatoryEarlyTerminationDateTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTermination")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOrCreateOptionalEarlyTermination() {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder result;
			if (optionalEarlyTermination!=null) {
				result = optionalEarlyTermination;
			}
			else {
				result = optionalEarlyTermination = OptionalEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionalEarlyTerminationParameters")
		public ExercisePeriod.ExercisePeriodBuilder getOptionalEarlyTerminationParameters() {
			return optionalEarlyTerminationParameters;
		}
		
		@Override
		public ExercisePeriod.ExercisePeriodBuilder getOrCreateOptionalEarlyTerminationParameters() {
			ExercisePeriod.ExercisePeriodBuilder result;
			if (optionalEarlyTerminationParameters!=null) {
				result = optionalEarlyTerminationParameters;
			}
			else {
				result = optionalEarlyTerminationParameters = ExercisePeriod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("mandatoryEarlyTermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryEarlyTermination")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setMandatoryEarlyTermination(MandatoryEarlyTermination _mandatoryEarlyTermination) {
			this.mandatoryEarlyTermination = _mandatoryEarlyTermination == null ? null : _mandatoryEarlyTermination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryEarlyTerminationDateTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryEarlyTerminationDateTenor")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setMandatoryEarlyTerminationDateTenor(Period _mandatoryEarlyTerminationDateTenor) {
			this.mandatoryEarlyTerminationDateTenor = _mandatoryEarlyTerminationDateTenor == null ? null : _mandatoryEarlyTerminationDateTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionalEarlyTermination")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setOptionalEarlyTermination(OptionalEarlyTermination _optionalEarlyTermination) {
			this.optionalEarlyTermination = _optionalEarlyTermination == null ? null : _optionalEarlyTermination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionalEarlyTerminationParameters")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setOptionalEarlyTerminationParameters(ExercisePeriod _optionalEarlyTerminationParameters) {
			this.optionalEarlyTerminationParameters = _optionalEarlyTerminationParameters == null ? null : _optionalEarlyTerminationParameters.toBuilder();
			return this;
		}
		
		@Override
		public EarlyTerminationProvision build() {
			return new EarlyTerminationProvision.EarlyTerminationProvisionImpl(this);
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder prune() {
			if (mandatoryEarlyTermination!=null && !mandatoryEarlyTermination.prune().hasData()) mandatoryEarlyTermination = null;
			if (mandatoryEarlyTerminationDateTenor!=null && !mandatoryEarlyTerminationDateTenor.prune().hasData()) mandatoryEarlyTerminationDateTenor = null;
			if (optionalEarlyTermination!=null && !optionalEarlyTermination.prune().hasData()) optionalEarlyTermination = null;
			if (optionalEarlyTerminationParameters!=null && !optionalEarlyTerminationParameters.prune().hasData()) optionalEarlyTerminationParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getMandatoryEarlyTermination()!=null && getMandatoryEarlyTermination().hasData()) return true;
			if (getMandatoryEarlyTerminationDateTenor()!=null && getMandatoryEarlyTerminationDateTenor().hasData()) return true;
			if (getOptionalEarlyTermination()!=null && getOptionalEarlyTermination().hasData()) return true;
			if (getOptionalEarlyTerminationParameters()!=null && getOptionalEarlyTerminationParameters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder o = (EarlyTerminationProvision.EarlyTerminationProvisionBuilder) other;
			
			merger.mergeRosetta(getMandatoryEarlyTermination(), o.getMandatoryEarlyTermination(), this::setMandatoryEarlyTermination);
			merger.mergeRosetta(getMandatoryEarlyTerminationDateTenor(), o.getMandatoryEarlyTerminationDateTenor(), this::setMandatoryEarlyTerminationDateTenor);
			merger.mergeRosetta(getOptionalEarlyTermination(), o.getOptionalEarlyTermination(), this::setOptionalEarlyTermination);
			merger.mergeRosetta(getOptionalEarlyTerminationParameters(), o.getOptionalEarlyTerminationParameters(), this::setOptionalEarlyTerminationParameters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationProvision _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mandatoryEarlyTermination, _that.getMandatoryEarlyTermination())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationDateTenor, _that.getMandatoryEarlyTerminationDateTenor())) return false;
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			if (!Objects.equals(optionalEarlyTerminationParameters, _that.getOptionalEarlyTerminationParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTermination != null ? mandatoryEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationDateTenor != null ? mandatoryEarlyTerminationDateTenor.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationParameters != null ? optionalEarlyTerminationParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationProvisionBuilder {" +
				"id=" + this.id + ", " +
				"mandatoryEarlyTermination=" + this.mandatoryEarlyTermination + ", " +
				"mandatoryEarlyTerminationDateTenor=" + this.mandatoryEarlyTerminationDateTenor + ", " +
				"optionalEarlyTermination=" + this.optionalEarlyTermination + ", " +
				"optionalEarlyTerminationParameters=" + this.optionalEarlyTerminationParameters +
			'}';
		}
	}
}
