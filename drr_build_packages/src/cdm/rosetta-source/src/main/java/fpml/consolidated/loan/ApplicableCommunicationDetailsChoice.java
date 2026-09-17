package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.ApplicableCommunicationDetailsChoiceMeta;
import fpml.consolidated.shared.RelatedBusinessUnit;
import fpml.consolidated.shared.RelatedPerson;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ApplicableCommunicationDetailsChoice", builder=ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableCommunicationDetailsChoice", model="fpml", builder=ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilderImpl.class, version="2.1.1")
public interface ApplicableCommunicationDetailsChoice extends RosettaModelObject {

	ApplicableCommunicationDetailsChoiceMeta metaData = new ApplicableCommunicationDetailsChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	RelatedPerson getRelatedPerson();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	RelatedBusinessUnit getRelatedBusinessUnit();

	/*********************** Build Methods  ***********************/
	ApplicableCommunicationDetailsChoice build();
	
	ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder toBuilder();
	
	static ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder builder() {
		return new ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableCommunicationDetailsChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableCommunicationDetailsChoice> getType() {
		return ApplicableCommunicationDetailsChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.class, getRelatedPerson());
		processRosetta(path.newSubPath("relatedBusinessUnit"), processor, RelatedBusinessUnit.class, getRelatedBusinessUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableCommunicationDetailsChoiceBuilder extends ApplicableCommunicationDetailsChoice, RosettaModelObjectBuilder {
		RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson();
		@Override
		RelatedPerson.RelatedPersonBuilder getRelatedPerson();
		RelatedBusinessUnit.RelatedBusinessUnitBuilder getOrCreateRelatedBusinessUnit();
		@Override
		RelatedBusinessUnit.RelatedBusinessUnitBuilder getRelatedBusinessUnit();
		ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder setRelatedPerson(RelatedPerson relatedPerson);
		ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder setRelatedBusinessUnit(RelatedBusinessUnit relatedBusinessUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.RelatedPersonBuilder.class, getRelatedPerson());
			processRosetta(path.newSubPath("relatedBusinessUnit"), processor, RelatedBusinessUnit.RelatedBusinessUnitBuilder.class, getRelatedBusinessUnit());
		}
		

		ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableCommunicationDetailsChoice  ***********************/
	class ApplicableCommunicationDetailsChoiceImpl implements ApplicableCommunicationDetailsChoice {
		private final RelatedPerson relatedPerson;
		private final RelatedBusinessUnit relatedBusinessUnit;
		
		protected ApplicableCommunicationDetailsChoiceImpl(ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder builder) {
			this.relatedPerson = ofNullable(builder.getRelatedPerson()).map(f->f.build()).orElse(null);
			this.relatedBusinessUnit = ofNullable(builder.getRelatedBusinessUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relatedPerson")
		public RelatedPerson getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relatedBusinessUnit")
		public RelatedBusinessUnit getRelatedBusinessUnit() {
			return relatedBusinessUnit;
		}
		
		@Override
		public ApplicableCommunicationDetailsChoice build() {
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder toBuilder() {
			ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder builder) {
			ofNullable(getRelatedPerson()).ifPresent(builder::setRelatedPerson);
			ofNullable(getRelatedBusinessUnit()).ifPresent(builder::setRelatedBusinessUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableCommunicationDetailsChoice _that = getType().cast(o);
		
			if (!Objects.equals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!Objects.equals(relatedBusinessUnit, _that.getRelatedBusinessUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (relatedBusinessUnit != null ? relatedBusinessUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableCommunicationDetailsChoice {" +
				"relatedPerson=" + this.relatedPerson + ", " +
				"relatedBusinessUnit=" + this.relatedBusinessUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableCommunicationDetailsChoice  ***********************/
	class ApplicableCommunicationDetailsChoiceBuilderImpl implements ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder {
	
		protected RelatedPerson.RelatedPersonBuilder relatedPerson;
		protected RelatedBusinessUnit.RelatedBusinessUnitBuilder relatedBusinessUnit;
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relatedPerson")
		public RelatedPerson.RelatedPersonBuilder getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		public RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson() {
			RelatedPerson.RelatedPersonBuilder result;
			if (relatedPerson!=null) {
				result = relatedPerson;
			}
			else {
				result = relatedPerson = RelatedPerson.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relatedBusinessUnit")
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder getRelatedBusinessUnit() {
			return relatedBusinessUnit;
		}
		
		@Override
		public RelatedBusinessUnit.RelatedBusinessUnitBuilder getOrCreateRelatedBusinessUnit() {
			RelatedBusinessUnit.RelatedBusinessUnitBuilder result;
			if (relatedBusinessUnit!=null) {
				result = relatedBusinessUnit;
			}
			else {
				result = relatedBusinessUnit = RelatedBusinessUnit.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relatedPerson")
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder setRelatedPerson(RelatedPerson _relatedPerson) {
			this.relatedPerson = _relatedPerson == null ? null : _relatedPerson.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedBusinessUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relatedBusinessUnit")
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder setRelatedBusinessUnit(RelatedBusinessUnit _relatedBusinessUnit) {
			this.relatedBusinessUnit = _relatedBusinessUnit == null ? null : _relatedBusinessUnit.toBuilder();
			return this;
		}
		
		@Override
		public ApplicableCommunicationDetailsChoice build() {
			return new ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceImpl(this);
		}
		
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder prune() {
			if (relatedPerson!=null && !relatedPerson.prune().hasData()) relatedPerson = null;
			if (relatedBusinessUnit!=null && !relatedBusinessUnit.prune().hasData()) relatedBusinessUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelatedPerson()!=null && getRelatedPerson().hasData()) return true;
			if (getRelatedBusinessUnit()!=null && getRelatedBusinessUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder o = (ApplicableCommunicationDetailsChoice.ApplicableCommunicationDetailsChoiceBuilder) other;
			
			merger.mergeRosetta(getRelatedPerson(), o.getRelatedPerson(), this::setRelatedPerson);
			merger.mergeRosetta(getRelatedBusinessUnit(), o.getRelatedBusinessUnit(), this::setRelatedBusinessUnit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableCommunicationDetailsChoice _that = getType().cast(o);
		
			if (!Objects.equals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!Objects.equals(relatedBusinessUnit, _that.getRelatedBusinessUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (relatedBusinessUnit != null ? relatedBusinessUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableCommunicationDetailsChoiceBuilder {" +
				"relatedPerson=" + this.relatedPerson + ", " +
				"relatedBusinessUnit=" + this.relatedBusinessUnit +
			'}';
		}
	}
}
