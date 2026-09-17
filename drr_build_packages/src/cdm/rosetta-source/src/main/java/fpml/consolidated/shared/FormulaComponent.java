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
import fpml.consolidated.shared.meta.FormulaComponentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Elements describing the components of the formula. The name attribute points to a value used in the math element. The href attribute points to a numeric value defined elsewhere in the document that is used by the formula component.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Elements describing the components of the formula. The name attribute points to a value used in the math element. The href attribute points to a numeric value defined elsewhere in the document that is used by the formula component.
 *
 */
@RosettaDataType(value="FormulaComponent", builder=FormulaComponent.FormulaComponentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FormulaComponent", model="fpml", builder=FormulaComponent.FormulaComponentBuilderImpl.class, version="2.1.1")
public interface FormulaComponent extends RosettaModelObject {

	FormulaComponentMeta metaData = new FormulaComponentMeta();

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
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Text description of the component
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Text description of the component
	 *
	 */
	String getComponentDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional formulas required to describe this component
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional formulas required to describe this component
	 *
	 */
	Formula getFormula();

	/*********************** Build Methods  ***********************/
	FormulaComponent build();
	
	FormulaComponent.FormulaComponentBuilder toBuilder();
	
	static FormulaComponent.FormulaComponentBuilder builder() {
		return new FormulaComponent.FormulaComponentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FormulaComponent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FormulaComponent> getType() {
		return FormulaComponent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("componentDescription"), String.class, getComponentDescription(), this);
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FormulaComponentBuilder extends FormulaComponent, RosettaModelObjectBuilder {
		Formula.FormulaBuilder getOrCreateFormula();
		@Override
		Formula.FormulaBuilder getFormula();
		FormulaComponent.FormulaComponentBuilder setName(String name);
		FormulaComponent.FormulaComponentBuilder setComponentDescription(String componentDescription);
		FormulaComponent.FormulaComponentBuilder setFormula(Formula formula);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("componentDescription"), String.class, getComponentDescription(), this);
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
		}
		

		FormulaComponent.FormulaComponentBuilder prune();
	}

	/*********************** Immutable Implementation of FormulaComponent  ***********************/
	class FormulaComponentImpl implements FormulaComponent {
		private final String name;
		private final String componentDescription;
		private final Formula formula;
		
		protected FormulaComponentImpl(FormulaComponent.FormulaComponentBuilder builder) {
			this.name = builder.getName();
			this.componentDescription = builder.getComponentDescription();
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("componentDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentDescription")
		public String getComponentDescription() {
			return componentDescription;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		public FormulaComponent build() {
			return this;
		}
		
		@Override
		public FormulaComponent.FormulaComponentBuilder toBuilder() {
			FormulaComponent.FormulaComponentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FormulaComponent.FormulaComponentBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getComponentDescription()).ifPresent(builder::setComponentDescription);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaComponent _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(componentDescription, _that.getComponentDescription())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (componentDescription != null ? componentDescription.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaComponent {" +
				"name=" + this.name + ", " +
				"componentDescription=" + this.componentDescription + ", " +
				"formula=" + this.formula +
			'}';
		}
	}

	/*********************** Builder Implementation of FormulaComponent  ***********************/
	class FormulaComponentBuilderImpl implements FormulaComponent.FormulaComponentBuilder {
	
		protected String name;
		protected String componentDescription;
		protected Formula.FormulaBuilder formula;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("componentDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("componentDescription")
		public String getComponentDescription() {
			return componentDescription;
		}
		
		@Override
		@RosettaAttribute("formula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formula")
		public Formula.FormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public Formula.FormulaBuilder getOrCreateFormula() {
			Formula.FormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = Formula.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public FormulaComponent.FormulaComponentBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("componentDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("componentDescription")
		@Override
		public FormulaComponent.FormulaComponentBuilder setComponentDescription(String _componentDescription) {
			this.componentDescription = _componentDescription == null ? null : _componentDescription;
			return this;
		}
		
		@RosettaAttribute("formula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formula")
		@Override
		public FormulaComponent.FormulaComponentBuilder setFormula(Formula _formula) {
			this.formula = _formula == null ? null : _formula.toBuilder();
			return this;
		}
		
		@Override
		public FormulaComponent build() {
			return new FormulaComponent.FormulaComponentImpl(this);
		}
		
		@Override
		public FormulaComponent.FormulaComponentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaComponent.FormulaComponentBuilder prune() {
			if (formula!=null && !formula.prune().hasData()) formula = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getComponentDescription()!=null) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaComponent.FormulaComponentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FormulaComponent.FormulaComponentBuilder o = (FormulaComponent.FormulaComponentBuilder) other;
			
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getComponentDescription(), o.getComponentDescription(), this::setComponentDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaComponent _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(componentDescription, _that.getComponentDescription())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (componentDescription != null ? componentDescription.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaComponentBuilder {" +
				"name=" + this.name + ", " +
				"componentDescription=" + this.componentDescription + ", " +
				"formula=" + this.formula +
			'}';
		}
	}
}
