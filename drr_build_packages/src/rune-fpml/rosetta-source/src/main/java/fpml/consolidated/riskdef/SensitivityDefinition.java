package fpml.consolidated.riskdef;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.riskdef.meta.SensitivityDefinitionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A set of characteristics describing a sensitivity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A set of characteristics describing a sensitivity.
 *
 */
@RosettaDataType(value="SensitivityDefinition", builder=SensitivityDefinition.SensitivityDefinitionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SensitivityDefinition", model="fpml", builder=SensitivityDefinition.SensitivityDefinitionBuilderImpl.class, version="2.1.1")
public interface SensitivityDefinition extends RosettaModelObject {

	SensitivityDefinitionMeta metaData = new SensitivityDefinitionMeta();

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
	 * Provision The name of the derivative, e.g. first derivative, Hessian, etc. Typically not required, but may be used to explain more complex derivative calculations.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the derivative, e.g. first derivative, Hessian, etc. Typically not required, but may be used to explain more complex derivative calculations.
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the valuation scenario to which this sensitivity definition applies. If the SensitivityDefinition occurs within a SensitivitySetDefinition, this is not required and normally not used. In this case, if it is supplied it overrides the valuationScenarioReference in the SensitivitySetDefinition.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the valuation scenario to which this sensitivity definition applies. If the SensitivityDefinition occurs within a SensitivitySetDefinition, this is not required and normally not used. In this case, if it is supplied it overrides the valuationScenarioReference in the SensitivitySetDefinition.
	 *
	 */
	ValuationScenarioReference getValuationScenarioReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A partial derivative of the measure with respect to an input.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A partial derivative of the measure with respect to an input.
	 *
	 */
	List<? extends PricingParameterDerivative> getPartialDerivative();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A formula defining how to compute the derivative from the partial derivatives. If absent, the derivative is just the product of the partial derivatives. Normally only required for more higher-order derivatives, e.g. Hessians.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A formula defining how to compute the derivative from the partial derivatives. If absent, the derivative is just the product of the partial derivatives. Normally only required for more higher-order derivatives, e.g. Hessians.
	 *
	 */
	DerivativeFormula getFormula();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time dimension of the sensitivity point (tenor and/or date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time dimension of the sensitivity point (tenor and/or date).
	 *
	 */
	TimeDimension getTerm();
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
	List<? extends SensitivityDefinitionChoice> getSensitivityDefinitionChoice();

	/*********************** Build Methods  ***********************/
	SensitivityDefinition build();
	
	SensitivityDefinition.SensitivityDefinitionBuilder toBuilder();
	
	static SensitivityDefinition.SensitivityDefinitionBuilder builder() {
		return new SensitivityDefinition.SensitivityDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivityDefinition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivityDefinition> getType() {
		return SensitivityDefinition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("partialDerivative"), processor, PricingParameterDerivative.class, getPartialDerivative());
		processRosetta(path.newSubPath("formula"), processor, DerivativeFormula.class, getFormula());
		processRosetta(path.newSubPath("term"), processor, TimeDimension.class, getTerm());
		processRosetta(path.newSubPath("sensitivityDefinitionChoice"), processor, SensitivityDefinitionChoice.class, getSensitivityDefinitionChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivityDefinitionBuilder extends SensitivityDefinition, RosettaModelObjectBuilder {
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference();
		@Override
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference();
		PricingParameterDerivative.PricingParameterDerivativeBuilder getOrCreatePartialDerivative(int index);
		@Override
		List<? extends PricingParameterDerivative.PricingParameterDerivativeBuilder> getPartialDerivative();
		DerivativeFormula.DerivativeFormulaBuilder getOrCreateFormula();
		@Override
		DerivativeFormula.DerivativeFormulaBuilder getFormula();
		TimeDimension.TimeDimensionBuilder getOrCreateTerm();
		@Override
		TimeDimension.TimeDimensionBuilder getTerm();
		SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder getOrCreateSensitivityDefinitionChoice(int index);
		@Override
		List<? extends SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder> getSensitivityDefinitionChoice();
		SensitivityDefinition.SensitivityDefinitionBuilder setId(String id);
		SensitivityDefinition.SensitivityDefinitionBuilder setName(String name);
		SensitivityDefinition.SensitivityDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		SensitivityDefinition.SensitivityDefinitionBuilder addPartialDerivative(PricingParameterDerivative partialDerivative);
		SensitivityDefinition.SensitivityDefinitionBuilder addPartialDerivative(PricingParameterDerivative partialDerivative, int idx);
		SensitivityDefinition.SensitivityDefinitionBuilder addPartialDerivative(List<? extends PricingParameterDerivative> partialDerivative);
		SensitivityDefinition.SensitivityDefinitionBuilder setPartialDerivative(List<? extends PricingParameterDerivative> partialDerivative);
		SensitivityDefinition.SensitivityDefinitionBuilder setFormula(DerivativeFormula formula);
		SensitivityDefinition.SensitivityDefinitionBuilder setTerm(TimeDimension term);
		SensitivityDefinition.SensitivityDefinitionBuilder addSensitivityDefinitionChoice(SensitivityDefinitionChoice sensitivityDefinitionChoice);
		SensitivityDefinition.SensitivityDefinitionBuilder addSensitivityDefinitionChoice(SensitivityDefinitionChoice sensitivityDefinitionChoice, int idx);
		SensitivityDefinition.SensitivityDefinitionBuilder addSensitivityDefinitionChoice(List<? extends SensitivityDefinitionChoice> sensitivityDefinitionChoice);
		SensitivityDefinition.SensitivityDefinitionBuilder setSensitivityDefinitionChoice(List<? extends SensitivityDefinitionChoice> sensitivityDefinitionChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("partialDerivative"), processor, PricingParameterDerivative.PricingParameterDerivativeBuilder.class, getPartialDerivative());
			processRosetta(path.newSubPath("formula"), processor, DerivativeFormula.DerivativeFormulaBuilder.class, getFormula());
			processRosetta(path.newSubPath("term"), processor, TimeDimension.TimeDimensionBuilder.class, getTerm());
			processRosetta(path.newSubPath("sensitivityDefinitionChoice"), processor, SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder.class, getSensitivityDefinitionChoice());
		}
		

		SensitivityDefinition.SensitivityDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivityDefinition  ***********************/
	class SensitivityDefinitionImpl implements SensitivityDefinition {
		private final String id;
		private final String name;
		private final ValuationScenarioReference valuationScenarioReference;
		private final List<? extends PricingParameterDerivative> partialDerivative;
		private final DerivativeFormula formula;
		private final TimeDimension term;
		private final List<? extends SensitivityDefinitionChoice> sensitivityDefinitionChoice;
		
		protected SensitivityDefinitionImpl(SensitivityDefinition.SensitivityDefinitionBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).map(f->f.build()).orElse(null);
			this.partialDerivative = ofNullable(builder.getPartialDerivative()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.sensitivityDefinitionChoice = ofNullable(builder.getSensitivityDefinitionChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationScenarioReference")
		public ValuationScenarioReference getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("partialDerivative")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partialDerivative")
		public List<? extends PricingParameterDerivative> getPartialDerivative() {
			return partialDerivative;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public DerivativeFormula getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public TimeDimension getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("sensitivityDefinitionChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivityDefinitionChoice")
		public List<? extends SensitivityDefinitionChoice> getSensitivityDefinitionChoice() {
			return sensitivityDefinitionChoice;
		}
		
		@Override
		public SensitivityDefinition build() {
			return this;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder toBuilder() {
			SensitivityDefinition.SensitivityDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityDefinition.SensitivityDefinitionBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getPartialDerivative()).ifPresent(builder::setPartialDerivative);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getSensitivityDefinitionChoice()).ifPresent(builder::setSensitivityDefinitionChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDefinition _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!ListEquals.listEquals(partialDerivative, _that.getPartialDerivative())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!ListEquals.listEquals(sensitivityDefinitionChoice, _that.getSensitivityDefinitionChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (partialDerivative != null ? partialDerivative.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (sensitivityDefinitionChoice != null ? sensitivityDefinitionChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityDefinition {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"partialDerivative=" + this.partialDerivative + ", " +
				"formula=" + this.formula + ", " +
				"term=" + this.term + ", " +
				"sensitivityDefinitionChoice=" + this.sensitivityDefinitionChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivityDefinition  ***********************/
	class SensitivityDefinitionBuilderImpl implements SensitivityDefinition.SensitivityDefinitionBuilder {
	
		protected String id;
		protected String name;
		protected ValuationScenarioReference.ValuationScenarioReferenceBuilder valuationScenarioReference;
		protected List<PricingParameterDerivative.PricingParameterDerivativeBuilder> partialDerivative = new ArrayList<>();
		protected DerivativeFormula.DerivativeFormulaBuilder formula;
		protected TimeDimension.TimeDimensionBuilder term;
		protected List<SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder> sensitivityDefinitionChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationScenarioReference")
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference() {
			ValuationScenarioReference.ValuationScenarioReferenceBuilder result;
			if (valuationScenarioReference!=null) {
				result = valuationScenarioReference;
			}
			else {
				result = valuationScenarioReference = ValuationScenarioReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partialDerivative")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partialDerivative")
		public List<? extends PricingParameterDerivative.PricingParameterDerivativeBuilder> getPartialDerivative() {
			return partialDerivative;
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder getOrCreatePartialDerivative(int index) {
			if (partialDerivative==null) {
				this.partialDerivative = new ArrayList<>();
			}
			return getIndex(partialDerivative, index, () -> {
						PricingParameterDerivative.PricingParameterDerivativeBuilder newPartialDerivative = PricingParameterDerivative.builder();
						return newPartialDerivative;
					});
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public DerivativeFormula.DerivativeFormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder getOrCreateFormula() {
			DerivativeFormula.DerivativeFormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = DerivativeFormula.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public TimeDimension.TimeDimensionBuilder getTerm() {
			return term;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder getOrCreateTerm() {
			TimeDimension.TimeDimensionBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = TimeDimension.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sensitivityDefinitionChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivityDefinitionChoice")
		public List<? extends SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder> getSensitivityDefinitionChoice() {
			return sensitivityDefinitionChoice;
		}
		
		@Override
		public SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder getOrCreateSensitivityDefinitionChoice(int index) {
			if (sensitivityDefinitionChoice==null) {
				this.sensitivityDefinitionChoice = new ArrayList<>();
			}
			return getIndex(sensitivityDefinitionChoice, index, () -> {
						SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder newSensitivityDefinitionChoice = SensitivityDefinitionChoice.builder();
						return newSensitivityDefinitionChoice;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partialDerivative")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partialDerivative")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder addPartialDerivative(PricingParameterDerivative _partialDerivative) {
			if (_partialDerivative != null) {
				this.partialDerivative.add(_partialDerivative.toBuilder());
			}
			return this;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder addPartialDerivative(PricingParameterDerivative _partialDerivative, int idx) {
			getIndex(this.partialDerivative, idx, () -> _partialDerivative.toBuilder());
			return this;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder addPartialDerivative(List<? extends PricingParameterDerivative> partialDerivatives) {
			if (partialDerivatives != null) {
				for (final PricingParameterDerivative toAdd : partialDerivatives) {
					this.partialDerivative.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partialDerivative")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partialDerivative")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setPartialDerivative(List<? extends PricingParameterDerivative> partialDerivatives) {
			if (partialDerivatives == null) {
				this.partialDerivative = new ArrayList<>();
			} else {
				this.partialDerivative = partialDerivatives.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("formula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formula")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setFormula(DerivativeFormula _formula) {
			this.formula = _formula == null ? null : _formula.toBuilder();
			return this;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("term")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setTerm(TimeDimension _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sensitivityDefinitionChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sensitivityDefinitionChoice")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder addSensitivityDefinitionChoice(SensitivityDefinitionChoice _sensitivityDefinitionChoice) {
			if (_sensitivityDefinitionChoice != null) {
				this.sensitivityDefinitionChoice.add(_sensitivityDefinitionChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder addSensitivityDefinitionChoice(SensitivityDefinitionChoice _sensitivityDefinitionChoice, int idx) {
			getIndex(this.sensitivityDefinitionChoice, idx, () -> _sensitivityDefinitionChoice.toBuilder());
			return this;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder addSensitivityDefinitionChoice(List<? extends SensitivityDefinitionChoice> sensitivityDefinitionChoices) {
			if (sensitivityDefinitionChoices != null) {
				for (final SensitivityDefinitionChoice toAdd : sensitivityDefinitionChoices) {
					this.sensitivityDefinitionChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sensitivityDefinitionChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sensitivityDefinitionChoice")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder setSensitivityDefinitionChoice(List<? extends SensitivityDefinitionChoice> sensitivityDefinitionChoices) {
			if (sensitivityDefinitionChoices == null) {
				this.sensitivityDefinitionChoice = new ArrayList<>();
			} else {
				this.sensitivityDefinitionChoice = sensitivityDefinitionChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SensitivityDefinition build() {
			return new SensitivityDefinition.SensitivityDefinitionImpl(this);
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder prune() {
			if (valuationScenarioReference!=null && !valuationScenarioReference.prune().hasData()) valuationScenarioReference = null;
			partialDerivative = partialDerivative.stream().filter(b->b!=null).<PricingParameterDerivative.PricingParameterDerivativeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (formula!=null && !formula.prune().hasData()) formula = null;
			if (term!=null && !term.prune().hasData()) term = null;
			sensitivityDefinitionChoice = sensitivityDefinitionChoice.stream().filter(b->b!=null).<SensitivityDefinitionChoice.SensitivityDefinitionChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().hasData()) return true;
			if (getPartialDerivative()!=null && getPartialDerivative().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getSensitivityDefinitionChoice()!=null && getSensitivityDefinitionChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityDefinition.SensitivityDefinitionBuilder o = (SensitivityDefinition.SensitivityDefinitionBuilder) other;
			
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::setValuationScenarioReference);
			merger.mergeRosetta(getPartialDerivative(), o.getPartialDerivative(), this::getOrCreatePartialDerivative);
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getSensitivityDefinitionChoice(), o.getSensitivityDefinitionChoice(), this::getOrCreateSensitivityDefinitionChoice);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityDefinition _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!ListEquals.listEquals(partialDerivative, _that.getPartialDerivative())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!ListEquals.listEquals(sensitivityDefinitionChoice, _that.getSensitivityDefinitionChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (partialDerivative != null ? partialDerivative.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (sensitivityDefinitionChoice != null ? sensitivityDefinitionChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityDefinitionBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"partialDerivative=" + this.partialDerivative + ", " +
				"formula=" + this.formula + ", " +
				"term=" + this.term + ", " +
				"sensitivityDefinitionChoice=" + this.sensitivityDefinitionChoice +
			'}';
		}
	}
}
